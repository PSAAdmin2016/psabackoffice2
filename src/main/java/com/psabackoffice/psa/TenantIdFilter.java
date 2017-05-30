package com.psabackoffice.psa;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TenantIdFilter implements Filter {

    private static ThreadLocal<String> jobNumberThreadLocal = new ThreadLocal();

    private static final Logger logger= LoggerFactory.getLogger(TenantIdFilter.class);

    public void init(FilterConfig fConfig) throws ServletException {
        logger.info("TenantId Filter Startup");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        String jobNumber = null;
        if (session != null) {
            jobNumber = (String) session.getAttribute("jobNumber");
            logger.info("Found jobNumber {}", jobNumber);
        }
        if (StringUtils.isNotBlank(jobNumber)) {
            try {
                logger.info("Setting Job Number to: " + jobNumber);
                jobNumberThreadLocal.set(jobNumber);
                chain.doFilter(request, response);
            } finally {
                jobNumberThreadLocal.remove();
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        //we can close resources here
    }

    public static String getJobNumber() {
        return jobNumberThreadLocal.get();
    }

}
