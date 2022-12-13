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

import io.jetprocess.model.FileMovement;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the file movement service. This utility wraps <code>io.jetprocess.service.persistence.impl.FileMovementPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileMovementPersistence
 * @generated
 */
public class FileMovementUtil {

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
	public static void clearCache(FileMovement fileMovement) {
		getPersistence().clearCache(fileMovement);
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
	public static Map<Serializable, FileMovement> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FileMovement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FileMovement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FileMovement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FileMovement> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FileMovement update(FileMovement fileMovement) {
		return getPersistence().update(fileMovement);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FileMovement update(
		FileMovement fileMovement, ServiceContext serviceContext) {

		return getPersistence().update(fileMovement, serviceContext);
	}

	/**
	 * Returns all the file movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file movements
	 */
	public static List<FileMovement> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of matching file movements
	 */
	public static List<FileMovement> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file movements
	 */
	public static List<FileMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileMovement> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file movements
	 */
	public static List<FileMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileMovement> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public static FileMovement findByUuid_First(
			String uuid, OrderByComparator<FileMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchByUuid_First(
		String uuid, OrderByComparator<FileMovement> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public static FileMovement findByUuid_Last(
			String uuid, OrderByComparator<FileMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchByUuid_Last(
		String uuid, OrderByComparator<FileMovement> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the file movements before and after the current file movement in the ordered set where uuid = &#63;.
	 *
	 * @param fmId the primary key of the current file movement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	public static FileMovement[] findByUuid_PrevAndNext(
			long fmId, String uuid,
			OrderByComparator<FileMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByUuid_PrevAndNext(
			fmId, uuid, orderByComparator);
	}

	/**
	 * Removes all the file movements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of file movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file movements
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public static FileMovement findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the file movement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file movement that was removed
	 */
	public static FileMovement removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of file movements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file movements
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file movements
	 */
	public static List<FileMovement> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of matching file movements
	 */
	public static List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file movements
	 */
	public static List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileMovement> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file movements
	 */
	public static List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileMovement> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public static FileMovement findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileMovement> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public static FileMovement findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileMovement> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the file movements before and after the current file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fmId the primary key of the current file movement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	public static FileMovement[] findByUuid_C_PrevAndNext(
			long fmId, String uuid, long companyId,
			OrderByComparator<FileMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fmId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the file movements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file movements
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the file movement where fileId = &#63; or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @return the matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public static FileMovement findByfileId(long fileId)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByfileId(fileId);
	}

	/**
	 * Returns the file movement where fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchByfileId(long fileId) {
		return getPersistence().fetchByfileId(fileId);
	}

	/**
	 * Returns the file movement where fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchByfileId(
		long fileId, boolean useFinderCache) {

		return getPersistence().fetchByfileId(fileId, useFinderCache);
	}

	/**
	 * Removes the file movement where fileId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @return the file movement that was removed
	 */
	public static FileMovement removeByfileId(long fileId)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().removeByfileId(fileId);
	}

	/**
	 * Returns the number of file movements where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the number of matching file movements
	 */
	public static int countByfileId(long fileId) {
		return getPersistence().countByfileId(fileId);
	}

	/**
	 * Caches the file movement in the entity cache if it is enabled.
	 *
	 * @param fileMovement the file movement
	 */
	public static void cacheResult(FileMovement fileMovement) {
		getPersistence().cacheResult(fileMovement);
	}

	/**
	 * Caches the file movements in the entity cache if it is enabled.
	 *
	 * @param fileMovements the file movements
	 */
	public static void cacheResult(List<FileMovement> fileMovements) {
		getPersistence().cacheResult(fileMovements);
	}

	/**
	 * Creates a new file movement with the primary key. Does not add the file movement to the database.
	 *
	 * @param fmId the primary key for the new file movement
	 * @return the new file movement
	 */
	public static FileMovement create(long fmId) {
		return getPersistence().create(fmId);
	}

	/**
	 * Removes the file movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement that was removed
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	public static FileMovement remove(long fmId)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().remove(fmId);
	}

	public static FileMovement updateImpl(FileMovement fileMovement) {
		return getPersistence().updateImpl(fileMovement);
	}

	/**
	 * Returns the file movement with the primary key or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	public static FileMovement findByPrimaryKey(long fmId)
		throws io.jetprocess.exception.NoSuchFileMovementException {

		return getPersistence().findByPrimaryKey(fmId);
	}

	/**
	 * Returns the file movement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement, or <code>null</code> if a file movement with the primary key could not be found
	 */
	public static FileMovement fetchByPrimaryKey(long fmId) {
		return getPersistence().fetchByPrimaryKey(fmId);
	}

	/**
	 * Returns all the file movements.
	 *
	 * @return the file movements
	 */
	public static List<FileMovement> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of file movements
	 */
	public static List<FileMovement> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file movements
	 */
	public static List<FileMovement> findAll(
		int start, int end, OrderByComparator<FileMovement> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file movements
	 */
	public static List<FileMovement> findAll(
		int start, int end, OrderByComparator<FileMovement> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the file movements from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of file movements.
	 *
	 * @return the number of file movements
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FileMovementPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FileMovementPersistence _persistence;

}