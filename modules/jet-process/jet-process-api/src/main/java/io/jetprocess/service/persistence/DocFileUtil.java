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

import io.jetprocess.model.DocFile;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the doc file service. This utility wraps <code>io.jetprocess.service.persistence.impl.DocFilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocFilePersistence
 * @generated
 */
public class DocFileUtil {

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
	public static void clearCache(DocFile docFile) {
		getPersistence().clearCache(docFile);
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
	public static Map<Serializable, DocFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocFile update(DocFile docFile) {
		return getPersistence().update(docFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocFile update(
		DocFile docFile, ServiceContext serviceContext) {

		return getPersistence().update(docFile, serviceContext);
	}

	/**
	 * Returns all the doc files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching doc files
	 */
	public static List<DocFile> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the doc files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of matching doc files
	 */
	public static List<DocFile> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the doc files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doc files
	 */
	public static List<DocFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doc files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doc files
	 */
	public static List<DocFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocFile> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findByUuid_First(
			String uuid, OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByUuid_First(
		String uuid, OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findByUuid_Last(
			String uuid, OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByUuid_Last(
		String uuid, OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the doc files before and after the current doc file in the ordered set where uuid = &#63;.
	 *
	 * @param docFileId the primary key of the current doc file
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public static DocFile[] findByUuid_PrevAndNext(
			long docFileId, String uuid,
			OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByUuid_PrevAndNext(
			docFileId, uuid, orderByComparator);
	}

	/**
	 * Removes all the doc files where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of doc files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching doc files
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the doc file where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the doc file that was removed
	 */
	public static DocFile removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of doc files where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching doc files
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching doc files
	 */
	public static List<DocFile> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of matching doc files
	 */
	public static List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doc files
	 */
	public static List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doc files
	 */
	public static List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocFile> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the doc files before and after the current doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param docFileId the primary key of the current doc file
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public static DocFile[] findByUuid_C_PrevAndNext(
			long docFileId, String uuid, long companyId,
			OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByUuid_C_PrevAndNext(
			docFileId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the doc files where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching doc files
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the doc files where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching doc files
	 */
	public static List<DocFile> findBygroupId(long groupId) {
		return getPersistence().findBygroupId(groupId);
	}

	/**
	 * Returns a range of all the doc files where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of matching doc files
	 */
	public static List<DocFile> findBygroupId(
		long groupId, int start, int end) {

		return getPersistence().findBygroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the doc files where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doc files
	 */
	public static List<DocFile> findBygroupId(
		long groupId, int start, int end,
		OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().findBygroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doc files where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doc files
	 */
	public static List<DocFile> findBygroupId(
		long groupId, int start, int end,
		OrderByComparator<DocFile> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBygroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findBygroupId_First(
			long groupId, OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findBygroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchBygroupId_First(
		long groupId, OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().fetchBygroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findBygroupId_Last(
			long groupId, OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findBygroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchBygroupId_Last(
		long groupId, OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().fetchBygroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the doc files before and after the current doc file in the ordered set where groupId = &#63;.
	 *
	 * @param docFileId the primary key of the current doc file
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public static DocFile[] findBygroupId_PrevAndNext(
			long docFileId, long groupId,
			OrderByComparator<DocFile> orderByComparator)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findBygroupId_PrevAndNext(
			docFileId, groupId, orderByComparator);
	}

	/**
	 * Removes all the doc files where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeBygroupId(long groupId) {
		getPersistence().removeBygroupId(groupId);
	}

	/**
	 * Returns the number of doc files where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching doc files
	 */
	public static int countBygroupId(long groupId) {
		return getPersistence().countBygroupId(groupId);
	}

	/**
	 * Returns the doc file where docFileId = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param docFileId the doc file ID
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findByDocFileId(long docFileId)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByDocFileId(docFileId);
	}

	/**
	 * Returns the doc file where docFileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param docFileId the doc file ID
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByDocFileId(long docFileId) {
		return getPersistence().fetchByDocFileId(docFileId);
	}

	/**
	 * Returns the doc file where docFileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param docFileId the doc file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByDocFileId(
		long docFileId, boolean useFinderCache) {

		return getPersistence().fetchByDocFileId(docFileId, useFinderCache);
	}

	/**
	 * Removes the doc file where docFileId = &#63; from the database.
	 *
	 * @param docFileId the doc file ID
	 * @return the doc file that was removed
	 */
	public static DocFile removeByDocFileId(long docFileId)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().removeByDocFileId(docFileId);
	}

	/**
	 * Returns the number of doc files where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @return the number of matching doc files
	 */
	public static int countByDocFileId(long docFileId) {
		return getPersistence().countByDocFileId(docFileId);
	}

	/**
	 * Returns the doc file where nature = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param nature the nature
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public static DocFile findByNature(String nature)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByNature(nature);
	}

	/**
	 * Returns the doc file where nature = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nature the nature
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByNature(String nature) {
		return getPersistence().fetchByNature(nature);
	}

	/**
	 * Returns the doc file where nature = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nature the nature
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchByNature(String nature, boolean useFinderCache) {
		return getPersistence().fetchByNature(nature, useFinderCache);
	}

	/**
	 * Removes the doc file where nature = &#63; from the database.
	 *
	 * @param nature the nature
	 * @return the doc file that was removed
	 */
	public static DocFile removeByNature(String nature)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().removeByNature(nature);
	}

	/**
	 * Returns the number of doc files where nature = &#63;.
	 *
	 * @param nature the nature
	 * @return the number of matching doc files
	 */
	public static int countByNature(String nature) {
		return getPersistence().countByNature(nature);
	}

	/**
	 * Caches the doc file in the entity cache if it is enabled.
	 *
	 * @param docFile the doc file
	 */
	public static void cacheResult(DocFile docFile) {
		getPersistence().cacheResult(docFile);
	}

	/**
	 * Caches the doc files in the entity cache if it is enabled.
	 *
	 * @param docFiles the doc files
	 */
	public static void cacheResult(List<DocFile> docFiles) {
		getPersistence().cacheResult(docFiles);
	}

	/**
	 * Creates a new doc file with the primary key. Does not add the doc file to the database.
	 *
	 * @param docFileId the primary key for the new doc file
	 * @return the new doc file
	 */
	public static DocFile create(long docFileId) {
		return getPersistence().create(docFileId);
	}

	/**
	 * Removes the doc file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file that was removed
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public static DocFile remove(long docFileId)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().remove(docFileId);
	}

	public static DocFile updateImpl(DocFile docFile) {
		return getPersistence().updateImpl(docFile);
	}

	/**
	 * Returns the doc file with the primary key or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public static DocFile findByPrimaryKey(long docFileId)
		throws io.jetprocess.exception.NoSuchDocFileException {

		return getPersistence().findByPrimaryKey(docFileId);
	}

	/**
	 * Returns the doc file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file, or <code>null</code> if a doc file with the primary key could not be found
	 */
	public static DocFile fetchByPrimaryKey(long docFileId) {
		return getPersistence().fetchByPrimaryKey(docFileId);
	}

	/**
	 * Returns all the doc files.
	 *
	 * @return the doc files
	 */
	public static List<DocFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the doc files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of doc files
	 */
	public static List<DocFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the doc files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doc files
	 */
	public static List<DocFile> findAll(
		int start, int end, OrderByComparator<DocFile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doc files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of doc files
	 */
	public static List<DocFile> findAll(
		int start, int end, OrderByComparator<DocFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the doc files from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of doc files.
	 *
	 * @return the number of doc files
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocFilePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DocFilePersistence _persistence;

}