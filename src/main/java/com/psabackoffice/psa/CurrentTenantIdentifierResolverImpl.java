package com.psabackoffice.psa;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.wavemaker.runtime.security.SecurityService;

import com.psabackoffice.psa.TblUserPsa;
import com.psabackoffice.psa.service.TblUserPsaService;

public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    private static final String DEFAULT_SCHEMA = "Job1111";

    @Autowired
    private SecurityService securityService;

    @Autowired
    private TblUserPsaService tblUserPsaService;

    private static final org.slf4j.Logger logger= LoggerFactory.getLogger(CurrentTenantIdentifierResolverImpl.class);

    @Override
    public String resolveCurrentTenantIdentifier() {
        final String jobNumber = TenantIdFilter.getJobNumber();
        if (StringUtils.isNotBlank(jobNumber)) {
            logger.info("CurrentTenantIdentifierResolverImpl.resolveCurrentTenantIdentifier: jobNumber {}:", jobNumber);
            return getUpdatedJobNumber(jobNumber);
        } else {
            boolean authenticated = securityService.isAuthenticated();
            logger.info("JobNumber not found in HTTP request.  Authenticated User check response: " + authenticated);
            
            if (authenticated) {
                String userID = securityService.getUserId();
                logger.info("CurrentTenantIdentifierResolverImpl.resolveCurrentTenantIdentifier: found User ID: " + userID);
                final TblUserPsa tblUserPsa = tblUserPsaService.findById(Integer.parseInt(userID));
                String updatedJobNumber = getUpdatedJobNumber(String.valueOf(tblUserPsa.getFkDefaultJobNumberId()));
                logger.info("Returning Job Number {} for User ID {} ", updatedJobNumber, userID);
                return updatedJobNumber;
            }
            //return DEFAULT_SCHEMA;
            throw new RuntimeException("Cannot resolve current tenantId for unauthenticated user.");
        }
    }

    private String getUpdatedJobNumber(String jobNumber) {
        if (jobNumber.startsWith("Job")){
            return jobNumber;
        }
        return "Job" + jobNumber;
    }

    @Override
    public boolean validateExistingCurrentSessions() {

        return true;
    }
}
