/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package io.jetprocess.masterdata.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import io.jetprocess.masterdata.model.Masterdata;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the masterdata service. This utility wraps <code>io.jetprocess.masterdata.service.persistence.impl.MasterdataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterdataPersistence
 * @generated
 */
public class MasterdataUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Masterdata masterdata) {
		getPersistence().clearCache(masterdata);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Masterdata> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Masterdata> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Masterdata> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Masterdata> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Masterdata> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Masterdata update(Masterdata masterdata) {
		return getPersistence().update(masterdata);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Masterdata update(
		Masterdata masterdata, ServiceContext serviceContext) {

		return getPersistence().update(masterdata, serviceContext);
	}

	/**
	 * Caches the masterdata in the entity cache if it is enabled.
	 *
	 * @param masterdata the masterdata
	 */
	public static void cacheResult(Masterdata masterdata) {
		getPersistence().cacheResult(masterdata);
	}

	/**
	 * Caches the masterdatas in the entity cache if it is enabled.
	 *
	 * @param masterdatas the masterdatas
	 */
	public static void cacheResult(List<Masterdata> masterdatas) {
		getPersistence().cacheResult(masterdatas);
	}

	/**
	 * Creates a new masterdata with the primary key. Does not add the masterdata to the database.
	 *
	 * @param masterdataId the primary key for the new masterdata
	 * @return the new masterdata
	 */
	public static Masterdata create(String masterdataId) {
		return getPersistence().create(masterdataId);
	}

	/**
	 * Removes the masterdata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata that was removed
	 * @throws NoSuchMasterdataException if a masterdata with the primary key could not be found
	 */
	public static Masterdata remove(String masterdataId)
		throws io.jetprocess.masterdata.exception.NoSuchMasterdataException {

		return getPersistence().remove(masterdataId);
	}

	public static Masterdata updateImpl(Masterdata masterdata) {
		return getPersistence().updateImpl(masterdata);
	}

	/**
	 * Returns the masterdata with the primary key or throws a <code>NoSuchMasterdataException</code> if it could not be found.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata
	 * @throws NoSuchMasterdataException if a masterdata with the primary key could not be found
	 */
	public static Masterdata findByPrimaryKey(String masterdataId)
		throws io.jetprocess.masterdata.exception.NoSuchMasterdataException {

		return getPersistence().findByPrimaryKey(masterdataId);
	}

	/**
	 * Returns the masterdata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata, or <code>null</code> if a masterdata with the primary key could not be found
	 */
	public static Masterdata fetchByPrimaryKey(String masterdataId) {
		return getPersistence().fetchByPrimaryKey(masterdataId);
	}

	/**
	 * Returns all the masterdatas.
	 *
	 * @return the masterdatas
	 */
	public static List<Masterdata> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the masterdatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterdataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of masterdatas
	 * @param end the upper bound of the range of masterdatas (not inclusive)
	 * @return the range of masterdatas
	 */
	public static List<Masterdata> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the masterdatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterdataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of masterdatas
	 * @param end the upper bound of the range of masterdatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of masterdatas
	 */
	public static List<Masterdata> findAll(
		int start, int end, OrderByComparator<Masterdata> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the masterdatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterdataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of masterdatas
	 * @param end the upper bound of the range of masterdatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of masterdatas
	 */
	public static List<Masterdata> findAll(
		int start, int end, OrderByComparator<Masterdata> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the masterdatas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of masterdatas.
	 *
	 * @return the number of masterdatas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterdataPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterdataPersistence _persistence;

}