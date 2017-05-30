/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.psabackoffice.psa.MenuSubHelpVideos;

/**
 * Specifies methods used to obtain and modify MenuSubHelpVideos related information
 * which is stored in the database.
 */
@Repository("PSA.MenuSubHelpVideosDao")
public class MenuSubHelpVideosDao extends WMGenericDaoImpl<MenuSubHelpVideos, Integer> {

    @Autowired
    @Qualifier("PSATemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

