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

import io.jetprocess.model.ReceiptCloseDetail;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the receipt close detail service. This utility wraps <code>io.jetprocess.service.persistence.impl.ReceiptCloseDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptCloseDetailPersistence
 * @generated
 */
public class ReceiptCloseDetailUtil {

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
	public static void clearCache(ReceiptCloseDetail receiptCloseDetail) {
		getPersistence().clearCache(receiptCloseDetail);
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
	public static Map<Serializable, ReceiptCloseDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ReceiptCloseDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReceiptCloseDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReceiptCloseDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ReceiptCloseDetail update(
		ReceiptCloseDetail receiptCloseDetail) {

		return getPersistence().update(receiptCloseDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ReceiptCloseDetail update(
		ReceiptCloseDetail receiptCloseDetail, ServiceContext serviceContext) {

		return getPersistence().update(receiptCloseDetail, serviceContext);
	}

	/**
	 * Returns all the receipt close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receipt close details
	 */
	public static List<ReceiptCloseDetail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the receipt close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @return the range of matching receipt close details
	 */
	public static List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the receipt close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt close details
	 */
	public static List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipt close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt close details
	 */
	public static List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail findByUuid_First(
			String uuid,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail fetchByUuid_First(
		String uuid, OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail findByUuid_Last(
			String uuid,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail fetchByUuid_Last(
		String uuid, OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the receipt close details before and after the current receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param ReceiptClosedId the primary key of the current receipt close detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	public static ReceiptCloseDetail[] findByUuid_PrevAndNext(
			long ReceiptClosedId, String uuid,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().findByUuid_PrevAndNext(
			ReceiptClosedId, uuid, orderByComparator);
	}

	/**
	 * Removes all the receipt close details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of receipt close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receipt close details
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReceiptCloseDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the receipt close detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receipt close detail that was removed
	 */
	public static ReceiptCloseDetail removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of receipt close details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receipt close details
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receipt close details
	 */
	public static List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @return the range of matching receipt close details
	 */
	public static List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt close details
	 */
	public static List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt close details
	 */
	public static List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the receipt close details before and after the current receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ReceiptClosedId the primary key of the current receipt close detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	public static ReceiptCloseDetail[] findByUuid_C_PrevAndNext(
			long ReceiptClosedId, String uuid, long companyId,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ReceiptClosedId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the receipt close details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receipt close details
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the receipt close detail in the entity cache if it is enabled.
	 *
	 * @param receiptCloseDetail the receipt close detail
	 */
	public static void cacheResult(ReceiptCloseDetail receiptCloseDetail) {
		getPersistence().cacheResult(receiptCloseDetail);
	}

	/**
	 * Caches the receipt close details in the entity cache if it is enabled.
	 *
	 * @param receiptCloseDetails the receipt close details
	 */
	public static void cacheResult(
		List<ReceiptCloseDetail> receiptCloseDetails) {

		getPersistence().cacheResult(receiptCloseDetails);
	}

	/**
	 * Creates a new receipt close detail with the primary key. Does not add the receipt close detail to the database.
	 *
	 * @param ReceiptClosedId the primary key for the new receipt close detail
	 * @return the new receipt close detail
	 */
	public static ReceiptCloseDetail create(long ReceiptClosedId) {
		return getPersistence().create(ReceiptClosedId);
	}

	/**
	 * Removes the receipt close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail that was removed
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	public static ReceiptCloseDetail remove(long ReceiptClosedId)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().remove(ReceiptClosedId);
	}

	public static ReceiptCloseDetail updateImpl(
		ReceiptCloseDetail receiptCloseDetail) {

		return getPersistence().updateImpl(receiptCloseDetail);
	}

	/**
	 * Returns the receipt close detail with the primary key or throws a <code>NoSuchReceiptCloseDetailException</code> if it could not be found.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	public static ReceiptCloseDetail findByPrimaryKey(long ReceiptClosedId)
		throws io.jetprocess.exception.NoSuchReceiptCloseDetailException {

		return getPersistence().findByPrimaryKey(ReceiptClosedId);
	}

	/**
	 * Returns the receipt close detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail, or <code>null</code> if a receipt close detail with the primary key could not be found
	 */
	public static ReceiptCloseDetail fetchByPrimaryKey(long ReceiptClosedId) {
		return getPersistence().fetchByPrimaryKey(ReceiptClosedId);
	}

	/**
	 * Returns all the receipt close details.
	 *
	 * @return the receipt close details
	 */
	public static List<ReceiptCloseDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the receipt close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @return the range of receipt close details
	 */
	public static List<ReceiptCloseDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the receipt close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of receipt close details
	 */
	public static List<ReceiptCloseDetail> findAll(
		int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipt close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of receipt close details
	 */
	public static List<ReceiptCloseDetail> findAll(
		int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the receipt close details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of receipt close details.
	 *
	 * @return the number of receipt close details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReceiptCloseDetailPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ReceiptCloseDetailPersistence _persistence;

}