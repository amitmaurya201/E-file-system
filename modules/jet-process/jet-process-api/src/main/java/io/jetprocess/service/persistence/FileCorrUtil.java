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

package io.jetprocess.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import io.jetprocess.model.FileCorr;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the file corr service. This utility wraps <code>io.jetprocess.service.persistence.impl.FileCorrPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrPersistence
 * @generated
 */
public class FileCorrUtil {

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
	public static void clearCache(FileCorr fileCorr) {
		getPersistence().clearCache(fileCorr);
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
	public static Map<Serializable, FileCorr> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FileCorr> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FileCorr> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FileCorr> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FileCorr> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FileCorr update(FileCorr fileCorr) {
		return getPersistence().update(fileCorr);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FileCorr update(
		FileCorr fileCorr, ServiceContext serviceContext) {

		return getPersistence().update(fileCorr, serviceContext);
	}

	/**
	 * Returns all the file corrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file corrs
	 */
	public static List<FileCorr> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the file corrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @return the range of matching file corrs
	 */
	public static List<FileCorr> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the file corrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corrs
	 */
	public static List<FileCorr> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileCorr> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file corrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corrs
	 */
	public static List<FileCorr> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileCorr> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file corr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public static FileCorr findByUuid_First(
			String uuid, OrderByComparator<FileCorr> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first file corr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public static FileCorr fetchByUuid_First(
		String uuid, OrderByComparator<FileCorr> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last file corr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public static FileCorr findByUuid_Last(
			String uuid, OrderByComparator<FileCorr> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last file corr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public static FileCorr fetchByUuid_Last(
		String uuid, OrderByComparator<FileCorr> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the file corrs before and after the current file corr in the ordered set where uuid = &#63;.
	 *
	 * @param fileCorrId the primary key of the current file corr
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr
	 * @throws NoSuchFileCorrException if a file corr with the primary key could not be found
	 */
	public static FileCorr[] findByUuid_PrevAndNext(
			long fileCorrId, String uuid,
			OrderByComparator<FileCorr> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().findByUuid_PrevAndNext(
			fileCorrId, uuid, orderByComparator);
	}

	/**
	 * Removes all the file corrs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of file corrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file corrs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the file corr where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileCorrException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public static FileCorr findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the file corr where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public static FileCorr fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the file corr where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public static FileCorr fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the file corr where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file corr that was removed
	 */
	public static FileCorr removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of file corrs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file corrs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file corrs
	 */
	public static List<FileCorr> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @return the range of matching file corrs
	 */
	public static List<FileCorr> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corrs
	 */
	public static List<FileCorr> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCorr> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corrs
	 */
	public static List<FileCorr> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCorr> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public static FileCorr findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileCorr> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public static FileCorr fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileCorr> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public static FileCorr findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileCorr> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public static FileCorr fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileCorr> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the file corrs before and after the current file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileCorrId the primary key of the current file corr
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr
	 * @throws NoSuchFileCorrException if a file corr with the primary key could not be found
	 */
	public static FileCorr[] findByUuid_C_PrevAndNext(
			long fileCorrId, String uuid, long companyId,
			OrderByComparator<FileCorr> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fileCorrId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the file corrs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file corrs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the file corr in the entity cache if it is enabled.
	 *
	 * @param fileCorr the file corr
	 */
	public static void cacheResult(FileCorr fileCorr) {
		getPersistence().cacheResult(fileCorr);
	}

	/**
	 * Caches the file corrs in the entity cache if it is enabled.
	 *
	 * @param fileCorrs the file corrs
	 */
	public static void cacheResult(List<FileCorr> fileCorrs) {
		getPersistence().cacheResult(fileCorrs);
	}

	/**
	 * Creates a new file corr with the primary key. Does not add the file corr to the database.
	 *
	 * @param fileCorrId the primary key for the new file corr
	 * @return the new file corr
	 */
	public static FileCorr create(long fileCorrId) {
		return getPersistence().create(fileCorrId);
	}

	/**
	 * Removes the file corr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr that was removed
	 * @throws NoSuchFileCorrException if a file corr with the primary key could not be found
	 */
	public static FileCorr remove(long fileCorrId)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().remove(fileCorrId);
	}

	public static FileCorr updateImpl(FileCorr fileCorr) {
		return getPersistence().updateImpl(fileCorr);
	}

	/**
	 * Returns the file corr with the primary key or throws a <code>NoSuchFileCorrException</code> if it could not be found.
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr
	 * @throws NoSuchFileCorrException if a file corr with the primary key could not be found
	 */
	public static FileCorr findByPrimaryKey(long fileCorrId)
		throws io.jetprocess.exception.NoSuchFileCorrException {

		return getPersistence().findByPrimaryKey(fileCorrId);
	}

	/**
	 * Returns the file corr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr, or <code>null</code> if a file corr with the primary key could not be found
	 */
	public static FileCorr fetchByPrimaryKey(long fileCorrId) {
		return getPersistence().fetchByPrimaryKey(fileCorrId);
	}

	/**
	 * Returns all the file corrs.
	 *
	 * @return the file corrs
	 */
	public static List<FileCorr> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the file corrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @return the range of file corrs
	 */
	public static List<FileCorr> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the file corrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file corrs
	 */
	public static List<FileCorr> findAll(
		int start, int end, OrderByComparator<FileCorr> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file corrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file corrs
	 */
	public static List<FileCorr> findAll(
		int start, int end, OrderByComparator<FileCorr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the file corrs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of file corrs.
	 *
	 * @return the number of file corrs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FileCorrPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FileCorrPersistence _persistence;

}