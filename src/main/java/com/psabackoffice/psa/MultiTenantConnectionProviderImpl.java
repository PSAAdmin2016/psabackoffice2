package com.psabackoffice.psa;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.spi.Stoppable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider, Stoppable {

    private DataSource dataSource;
    
    private static final Logger logger = LoggerFactory.getLogger(MultiTenantConnectionProviderImpl.class);

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
 public Connection getConnection(String tenantId) throws SQLException {
        final Connection connection = getAnyConnection();
        try {
            connection.createStatement().execute("USE " + getTenantDatabaseName(tenantId));
            logger.info("Schema switched to {} ", getTenantDatabaseName(tenantId));
            return connection;
        } catch (SQLException e) {
            try {
                connection.close();
            } catch (Exception e1) {
                logger.warn("Failed to close connection", e1);
            }
            throw new HibernateException("Could not alter JDBC connection to specified schema [" + tenantId + "]",e);
        }
    }

    private String getTenantDatabaseName(String tenantId) {
        return tenantId;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        System.out.println("Data Source set");
        this.dataSource = dataSource;
    }
}
