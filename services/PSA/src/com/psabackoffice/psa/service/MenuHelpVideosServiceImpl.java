/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.psa.MenuHelpVideos;
import com.psabackoffice.psa.MenuSubHelpVideos;


/**
 * ServiceImpl object for domain model class MenuHelpVideos.
 *
 * @see MenuHelpVideos
 */
@Service("PSA.MenuHelpVideosService")
public class MenuHelpVideosServiceImpl implements MenuHelpVideosService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuHelpVideosServiceImpl.class);

    @Autowired
	@Qualifier("PSA.MenuSubHelpVideosService")
	private MenuSubHelpVideosService menuSubHelpVideosService;

    @Autowired
    @Qualifier("PSA.MenuHelpVideosDao")
    private WMGenericDao<MenuHelpVideos, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<MenuHelpVideos, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public MenuHelpVideos create(MenuHelpVideos menuHelpVideos) {
        LOGGER.debug("Creating a new MenuHelpVideos with information: {}", menuHelpVideos);
        MenuHelpVideos menuHelpVideosCreated = this.wmGenericDao.create(menuHelpVideos);
        if(menuHelpVideosCreated.getMenuSubHelpVideoses() != null) {
            for(MenuSubHelpVideos menuSubHelpVideose : menuHelpVideosCreated.getMenuSubHelpVideoses()) {
                menuSubHelpVideose.setMenuHelpVideos(menuHelpVideosCreated);
                LOGGER.debug("Creating a new child MenuSubHelpVideos with information: {}", menuSubHelpVideose);
                menuSubHelpVideosService.create(menuSubHelpVideose);
            }
        }
        return menuHelpVideosCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public MenuHelpVideos getById(Integer menuhelpvideosId) throws EntityNotFoundException {
        LOGGER.debug("Finding MenuHelpVideos by id: {}", menuhelpvideosId);
        MenuHelpVideos menuHelpVideos = this.wmGenericDao.findById(menuhelpvideosId);
        if (menuHelpVideos == null){
            LOGGER.debug("No MenuHelpVideos found with id: {}", menuhelpvideosId);
            throw new EntityNotFoundException(String.valueOf(menuhelpvideosId));
        }
        return menuHelpVideos;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public MenuHelpVideos findById(Integer menuhelpvideosId) {
        LOGGER.debug("Finding MenuHelpVideos by id: {}", menuhelpvideosId);
        return this.wmGenericDao.findById(menuhelpvideosId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public MenuHelpVideos update(MenuHelpVideos menuHelpVideos) throws EntityNotFoundException {
        LOGGER.debug("Updating MenuHelpVideos with information: {}", menuHelpVideos);
        this.wmGenericDao.update(menuHelpVideos);

        Integer menuhelpvideosId = menuHelpVideos.getId();

        return this.wmGenericDao.findById(menuhelpvideosId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public MenuHelpVideos delete(Integer menuhelpvideosId) throws EntityNotFoundException {
        LOGGER.debug("Deleting MenuHelpVideos with id: {}", menuhelpvideosId);
        MenuHelpVideos deleted = this.wmGenericDao.findById(menuhelpvideosId);
        if (deleted == null) {
            LOGGER.debug("No MenuHelpVideos found with id: {}", menuhelpvideosId);
            throw new EntityNotFoundException(String.valueOf(menuhelpvideosId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<MenuHelpVideos> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all MenuHelpVideos");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<MenuHelpVideos> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all MenuHelpVideos");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table MenuHelpVideos to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<MenuSubHelpVideos> findAssociatedMenuSubHelpVideoses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated menuSubHelpVideoses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("menuHelpVideos.id = '" + id + "'");

        return menuSubHelpVideosService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service MenuSubHelpVideosService instance
	 */
	protected void setMenuSubHelpVideosService(MenuSubHelpVideosService service) {
        this.menuSubHelpVideosService = service;
    }

}

