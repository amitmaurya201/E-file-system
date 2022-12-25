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

import io.jetprocess.model.ReceiptMovement;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the receipt movement service. This utility wraps <code>io.jetprocess.service.persistence.impl.ReceiptMovementPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptMovementPersistence
 * @generated
 */
public class ReceiptMovementUtil {

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
	public static void clearCache(ReceiptMovement receiptMovement) {
		getPersistence().clearCache(receiptMovement);
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
	public static Map<Serializable, ReceiptMovement> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ReceiptMovement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReceiptMovement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReceiptMovement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ReceiptMovement update(ReceiptMovement receiptMovement) {
		return getPersistence().update(receiptMovement);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ReceiptMovement update(
		ReceiptMovement receiptMovement, ServiceContext serviceContext) {

		return getPersistence().update(receiptMovement, serviceContext);
	}

	/**
	 * Returns all the receipt movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receipt movements
	 */
	public static List<ReceiptMovement> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the receipt movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the receipt movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipt movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public static ReceiptMovement findByUuid_First(
			String uuid, OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchByUuid_First(
		String uuid, OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public static ReceiptMovement findByUuid_Last(
			String uuid, OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchByUuid_Last(
		String uuid, OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the receipt movements before and after the current receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param rmId the primary key of the current receipt movement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	public static ReceiptMovement[] findByUuid_PrevAndNext(
			long rmId, String uuid,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByUuid_PrevAndNext(
			rmId, uuid, orderByComparator);
	}

	/**
	 * Removes all the receipt movements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of receipt movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receipt movements
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReceiptMovementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public static ReceiptMovement findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the receipt movement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receipt movement that was removed
	 */
	public static ReceiptMovement removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of receipt movements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receipt movements
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receipt movements
	 */
	public static List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public static ReceiptMovement findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public static ReceiptMovement findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the receipt movements before and after the current receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rmId the primary key of the current receipt movement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	public static ReceiptMovement[] findByUuid_C_PrevAndNext(
			long rmId, String uuid, long companyId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByUuid_C_PrevAndNext(
			rmId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the receipt movements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receipt movements
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the receipt movements where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @return the matching receipt movements
	 */
	public static List<ReceiptMovement> findByreceiptId(long receiptId) {
		return getPersistence().findByreceiptId(receiptId);
	}

	/**
	 * Returns a range of all the receipt movements where receiptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param receiptId the receipt ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByreceiptId(
		long receiptId, int start, int end) {

		return getPersistence().findByreceiptId(receiptId, start, end);
	}

	/**
	 * Returns an ordered range of all the receipt movements where receiptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param receiptId the receipt ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByreceiptId(
		long receiptId, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().findByreceiptId(
			receiptId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipt movements where receiptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param receiptId the receipt ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt movements
	 */
	public static List<ReceiptMovement> findByreceiptId(
		long receiptId, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByreceiptId(
			receiptId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt movement in the ordered set where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public static ReceiptMovement findByreceiptId_First(
			long receiptId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByreceiptId_First(
			receiptId, orderByComparator);
	}

	/**
	 * Returns the first receipt movement in the ordered set where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchByreceiptId_First(
		long receiptId, OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().fetchByreceiptId_First(
			receiptId, orderByComparator);
	}

	/**
	 * Returns the last receipt movement in the ordered set where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public static ReceiptMovement findByreceiptId_Last(
			long receiptId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByreceiptId_Last(
			receiptId, orderByComparator);
	}

	/**
	 * Returns the last receipt movement in the ordered set where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchByreceiptId_Last(
		long receiptId, OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().fetchByreceiptId_Last(
			receiptId, orderByComparator);
	}

	/**
	 * Returns the receipt movements before and after the current receipt movement in the ordered set where receiptId = &#63;.
	 *
	 * @param rmId the primary key of the current receipt movement
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	public static ReceiptMovement[] findByreceiptId_PrevAndNext(
			long rmId, long receiptId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByreceiptId_PrevAndNext(
			rmId, receiptId, orderByComparator);
	}

	/**
	 * Removes all the receipt movements where receiptId = &#63; from the database.
	 *
	 * @param receiptId the receipt ID
	 */
	public static void removeByreceiptId(long receiptId) {
		getPersistence().removeByreceiptId(receiptId);
	}

	/**
	 * Returns the number of receipt movements where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @return the number of matching receipt movements
	 */
	public static int countByreceiptId(long receiptId) {
		return getPersistence().countByreceiptId(receiptId);
	}

	/**
	 * Caches the receipt movement in the entity cache if it is enabled.
	 *
	 * @param receiptMovement the receipt movement
	 */
	public static void cacheResult(ReceiptMovement receiptMovement) {
		getPersistence().cacheResult(receiptMovement);
	}

	/**
	 * Caches the receipt movements in the entity cache if it is enabled.
	 *
	 * @param receiptMovements the receipt movements
	 */
	public static void cacheResult(List<ReceiptMovement> receiptMovements) {
		getPersistence().cacheResult(receiptMovements);
	}

	/**
	 * Creates a new receipt movement with the primary key. Does not add the receipt movement to the database.
	 *
	 * @param rmId the primary key for the new receipt movement
	 * @return the new receipt movement
	 */
	public static ReceiptMovement create(long rmId) {
		return getPersistence().create(rmId);
	}

	/**
	 * Removes the receipt movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement that was removed
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	public static ReceiptMovement remove(long rmId)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().remove(rmId);
	}

	public static ReceiptMovement updateImpl(ReceiptMovement receiptMovement) {
		return getPersistence().updateImpl(receiptMovement);
	}

	/**
	 * Returns the receipt movement with the primary key or throws a <code>NoSuchReceiptMovementException</code> if it could not be found.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	public static ReceiptMovement findByPrimaryKey(long rmId)
		throws io.jetprocess.exception.NoSuchReceiptMovementException {

		return getPersistence().findByPrimaryKey(rmId);
	}

	/**
	 * Returns the receipt movement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement, or <code>null</code> if a receipt movement with the primary key could not be found
	 */
	public static ReceiptMovement fetchByPrimaryKey(long rmId) {
		return getPersistence().fetchByPrimaryKey(rmId);
	}

	/**
	 * Returns all the receipt movements.
	 *
	 * @return the receipt movements
	 */
	public static List<ReceiptMovement> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the receipt movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of receipt movements
	 */
	public static List<ReceiptMovement> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the receipt movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of receipt movements
	 */
	public static List<ReceiptMovement> findAll(
		int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipt movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of receipt movements
	 */
	public static List<ReceiptMovement> findAll(
		int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the receipt movements from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of receipt movements.
	 *
	 * @return the number of receipt movements
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReceiptMovementPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ReceiptMovementPersistence _persistence;

}