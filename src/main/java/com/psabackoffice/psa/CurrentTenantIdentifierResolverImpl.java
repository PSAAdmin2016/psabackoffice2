package com.psabackoffice.psa;

import com.psabackoffice.psa.TblUserPsa;
import com.psabackoffice.psa.service.TblUserPsaService;
import com.wavemaker.runtime.security.SecurityService;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
            logger.info("CurrentTenantIdentifierResolverImpl.resolveCurrentTenantIdentifier: jobNumber {}", jobNumber);
            return getUpdatedJobNumber(jobNumber);
        } else {
            logger.info("JobNumber not found");
            boolean authenticated = securityService.isAuthenticated();
            if (authenticated) {
                // Multi-tenancy logic goes here, based on
                // user's JOB_ID field from PSA table
                String userID = securityService.getUserId();
                logger.info("CurrentTenantIdentifierResolverImpl.resolveCurrentTenantIdentifier: found User ID: " + userID);
                final TblUserPsa tblUserPsa = tblUserPsaService.findById(Integer.parseInt(userID));
                //return getUpdatedJobNumber(String.valueOf(tblUserPsa.getTblJobNumbers().getJobNumber()));
                return getUpdatedJobNumber(String.valueOf(tblUserPsa.getFkDefaultJobNumberId()));
            }
            return DEFAULT_SCHEMA;
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
