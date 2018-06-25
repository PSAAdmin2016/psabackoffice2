/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.psabackoffice.job1111.SteelTrackerDetails;

/**
 * Specifies methods used to obtain and modify SteelTrackerDetails related information
 * which is stored in the database.
 */
@Repository("Job1111.SteelTrackerDetailsDao")
public class SteelTrackerDetailsDao extends WMGenericDaoImpl<SteelTrackerDetails, Integer> {

    @Autowired
    @Qualifier("Job1111Template")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

