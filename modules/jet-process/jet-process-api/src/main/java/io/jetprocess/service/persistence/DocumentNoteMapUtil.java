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

import io.jetprocess.model.DocumentNoteMap;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the document note map service. This utility wraps <code>io.jetprocess.service.persistence.impl.DocumentNoteMapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentNoteMapPersistence
 * @generated
 */
public class DocumentNoteMapUtil {

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
	public static void clearCache(DocumentNoteMap documentNoteMap) {
		getPersistence().clearCache(documentNoteMap);
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
	public static Map<Serializable, DocumentNoteMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentNoteMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentNoteMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentNoteMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentNoteMap update(DocumentNoteMap documentNoteMap) {
		return getPersistence().update(documentNoteMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentNoteMap update(
		DocumentNoteMap documentNoteMap, ServiceContext serviceContext) {

		return getPersistence().update(documentNoteMap, serviceContext);
	}

	/**
	 * Returns all the document note maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document note maps
	 */
	public static List<DocumentNoteMap> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of matching document note maps
	 */
	public static List<DocumentNoteMap> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document note maps
	 */
	public static List<DocumentNoteMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document note maps
	 */
	public static List<DocumentNoteMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public static DocumentNoteMap findByUuid_First(
			String uuid, OrderByComparator<DocumentNoteMap> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchByUuid_First(
		String uuid, OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public static DocumentNoteMap findByUuid_Last(
			String uuid, OrderByComparator<DocumentNoteMap> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchByUuid_Last(
		String uuid, OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the document note maps before and after the current document note map in the ordered set where uuid = &#63;.
	 *
	 * @param documentNoteMapId the primary key of the current document note map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	public static DocumentNoteMap[] findByUuid_PrevAndNext(
			long documentNoteMapId, String uuid,
			OrderByComparator<DocumentNoteMap> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByUuid_PrevAndNext(
			documentNoteMapId, uuid, orderByComparator);
	}

	/**
	 * Removes all the document note maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of document note maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document note maps
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocumentNoteMapException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public static DocumentNoteMap findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the document note map where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the document note map that was removed
	 */
	public static DocumentNoteMap removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of document note maps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching document note maps
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching document note maps
	 */
	public static List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of matching document note maps
	 */
	public static List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document note maps
	 */
	public static List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document note maps
	 */
	public static List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public static DocumentNoteMap findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DocumentNoteMap> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public static DocumentNoteMap findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DocumentNoteMap> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the document note maps before and after the current document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param documentNoteMapId the primary key of the current document note map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	public static DocumentNoteMap[] findByUuid_C_PrevAndNext(
			long documentNoteMapId, String uuid, long companyId,
			OrderByComparator<DocumentNoteMap> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByUuid_C_PrevAndNext(
			documentNoteMapId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the document note maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching document note maps
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the document note map where movementId = &#63; or throws a <code>NoSuchDocumentNoteMapException</code> if it could not be found.
	 *
	 * @param movementId the movement ID
	 * @return the matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public static DocumentNoteMap findByfindByMovementId(long movementId)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByfindByMovementId(movementId);
	}

	/**
	 * Returns the document note map where movementId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param movementId the movement ID
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchByfindByMovementId(long movementId) {
		return getPersistence().fetchByfindByMovementId(movementId);
	}

	/**
	 * Returns the document note map where movementId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param movementId the movement ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchByfindByMovementId(
		long movementId, boolean useFinderCache) {

		return getPersistence().fetchByfindByMovementId(
			movementId, useFinderCache);
	}

	/**
	 * Removes the document note map where movementId = &#63; from the database.
	 *
	 * @param movementId the movement ID
	 * @return the document note map that was removed
	 */
	public static DocumentNoteMap removeByfindByMovementId(long movementId)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().removeByfindByMovementId(movementId);
	}

	/**
	 * Returns the number of document note maps where movementId = &#63;.
	 *
	 * @param movementId the movement ID
	 * @return the number of matching document note maps
	 */
	public static int countByfindByMovementId(long movementId) {
		return getPersistence().countByfindByMovementId(movementId);
	}

	/**
	 * Caches the document note map in the entity cache if it is enabled.
	 *
	 * @param documentNoteMap the document note map
	 */
	public static void cacheResult(DocumentNoteMap documentNoteMap) {
		getPersistence().cacheResult(documentNoteMap);
	}

	/**
	 * Caches the document note maps in the entity cache if it is enabled.
	 *
	 * @param documentNoteMaps the document note maps
	 */
	public static void cacheResult(List<DocumentNoteMap> documentNoteMaps) {
		getPersistence().cacheResult(documentNoteMaps);
	}

	/**
	 * Creates a new document note map with the primary key. Does not add the document note map to the database.
	 *
	 * @param documentNoteMapId the primary key for the new document note map
	 * @return the new document note map
	 */
	public static DocumentNoteMap create(long documentNoteMapId) {
		return getPersistence().create(documentNoteMapId);
	}

	/**
	 * Removes the document note map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map that was removed
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	public static DocumentNoteMap remove(long documentNoteMapId)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().remove(documentNoteMapId);
	}

	public static DocumentNoteMap updateImpl(DocumentNoteMap documentNoteMap) {
		return getPersistence().updateImpl(documentNoteMap);
	}

	/**
	 * Returns the document note map with the primary key or throws a <code>NoSuchDocumentNoteMapException</code> if it could not be found.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	public static DocumentNoteMap findByPrimaryKey(long documentNoteMapId)
		throws io.jetprocess.exception.NoSuchDocumentNoteMapException {

		return getPersistence().findByPrimaryKey(documentNoteMapId);
	}

	/**
	 * Returns the document note map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map, or <code>null</code> if a document note map with the primary key could not be found
	 */
	public static DocumentNoteMap fetchByPrimaryKey(long documentNoteMapId) {
		return getPersistence().fetchByPrimaryKey(documentNoteMapId);
	}

	/**
	 * Returns all the document note maps.
	 *
	 * @return the document note maps
	 */
	public static List<DocumentNoteMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of document note maps
	 */
	public static List<DocumentNoteMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document note maps
	 */
	public static List<DocumentNoteMap> findAll(
		int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document note maps
	 */
	public static List<DocumentNoteMap> findAll(
		int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the document note maps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of document note maps.
	 *
	 * @return the number of document note maps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentNoteMapPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DocumentNoteMapPersistence _persistence;

}