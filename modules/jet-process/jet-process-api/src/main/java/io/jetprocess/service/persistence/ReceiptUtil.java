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

import io.jetprocess.model.Receipt;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the receipt service. This utility wraps <code>io.jetprocess.service.persistence.impl.ReceiptPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptPersistence
 * @generated
 */
public class ReceiptUtil {

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
	public static void clearCache(Receipt receipt) {
		getPersistence().clearCache(receipt);
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
	public static Map<Serializable, Receipt> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Receipt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Receipt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Receipt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Receipt update(Receipt receipt) {
		return getPersistence().update(receipt);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Receipt update(
		Receipt receipt, ServiceContext serviceContext) {

		return getPersistence().update(receipt, serviceContext);
	}

	/**
	 * Returns all the receipts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receipts
	 */
	public static List<Receipt> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @return the range of matching receipts
	 */
	public static List<Receipt> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipts
	 */
	public static List<Receipt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipts
	 */
	public static List<Receipt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Receipt> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findByUuid_First(
			String uuid, OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByUuid_First(
		String uuid, OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findByUuid_Last(
			String uuid, OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByUuid_Last(
		String uuid, OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the receipts before and after the current receipt in the ordered set where uuid = &#63;.
	 *
	 * @param receiptId the primary key of the current receipt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public static Receipt[] findByUuid_PrevAndNext(
			long receiptId, String uuid,
			OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByUuid_PrevAndNext(
			receiptId, uuid, orderByComparator);
	}

	/**
	 * Removes all the receipts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of receipts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receipts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the receipt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReceiptException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the receipt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the receipt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the receipt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receipt that was removed
	 */
	public static Receipt removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of receipts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receipts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receipts
	 */
	public static List<Receipt> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @return the range of matching receipts
	 */
	public static List<Receipt> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipts
	 */
	public static List<Receipt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipts
	 */
	public static List<Receipt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Receipt> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the receipts before and after the current receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param receiptId the primary key of the current receipt
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public static Receipt[] findByUuid_C_PrevAndNext(
			long receiptId, String uuid, long companyId,
			OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByUuid_C_PrevAndNext(
			receiptId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the receipts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receipts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the receipts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching receipts
	 */
	public static List<Receipt> findBygroupId(long groupId) {
		return getPersistence().findBygroupId(groupId);
	}

	/**
	 * Returns a range of all the receipts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @return the range of matching receipts
	 */
	public static List<Receipt> findBygroupId(
		long groupId, int start, int end) {

		return getPersistence().findBygroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the receipts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipts
	 */
	public static List<Receipt> findBygroupId(
		long groupId, int start, int end,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().findBygroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipts
	 */
	public static List<Receipt> findBygroupId(
		long groupId, int start, int end,
		OrderByComparator<Receipt> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBygroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findBygroupId_First(
			long groupId, OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findBygroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first receipt in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchBygroupId_First(
		long groupId, OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().fetchBygroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last receipt in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findBygroupId_Last(
			long groupId, OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findBygroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last receipt in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchBygroupId_Last(
		long groupId, OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().fetchBygroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the receipts before and after the current receipt in the ordered set where groupId = &#63;.
	 *
	 * @param receiptId the primary key of the current receipt
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public static Receipt[] findBygroupId_PrevAndNext(
			long receiptId, long groupId,
			OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findBygroupId_PrevAndNext(
			receiptId, groupId, orderByComparator);
	}

	/**
	 * Removes all the receipts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeBygroupId(long groupId) {
		getPersistence().removeBygroupId(groupId);
	}

	/**
	 * Returns the number of receipts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching receipts
	 */
	public static int countBygroupId(long groupId) {
		return getPersistence().countBygroupId(groupId);
	}

	/**
	 * Returns all the receipts where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @return the matching receipts
	 */
	public static List<Receipt> findByG_R(long groupId, long receiptId) {
		return getPersistence().findByG_R(groupId, receiptId);
	}

	/**
	 * Returns a range of all the receipts where groupId = &#63; and receiptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @return the range of matching receipts
	 */
	public static List<Receipt> findByG_R(
		long groupId, long receiptId, int start, int end) {

		return getPersistence().findByG_R(groupId, receiptId, start, end);
	}

	/**
	 * Returns an ordered range of all the receipts where groupId = &#63; and receiptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipts
	 */
	public static List<Receipt> findByG_R(
		long groupId, long receiptId, int start, int end,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().findByG_R(
			groupId, receiptId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipts where groupId = &#63; and receiptId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipts
	 */
	public static List<Receipt> findByG_R(
		long groupId, long receiptId, int start, int end,
		OrderByComparator<Receipt> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_R(
			groupId, receiptId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first receipt in the ordered set where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findByG_R_First(
			long groupId, long receiptId,
			OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByG_R_First(
			groupId, receiptId, orderByComparator);
	}

	/**
	 * Returns the first receipt in the ordered set where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByG_R_First(
		long groupId, long receiptId,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().fetchByG_R_First(
			groupId, receiptId, orderByComparator);
	}

	/**
	 * Returns the last receipt in the ordered set where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findByG_R_Last(
			long groupId, long receiptId,
			OrderByComparator<Receipt> orderByComparator)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByG_R_Last(
			groupId, receiptId, orderByComparator);
	}

	/**
	 * Returns the last receipt in the ordered set where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByG_R_Last(
		long groupId, long receiptId,
		OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().fetchByG_R_Last(
			groupId, receiptId, orderByComparator);
	}

	/**
	 * Removes all the receipts where groupId = &#63; and receiptId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 */
	public static void removeByG_R(long groupId, long receiptId) {
		getPersistence().removeByG_R(groupId, receiptId);
	}

	/**
	 * Returns the number of receipts where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @return the number of matching receipts
	 */
	public static int countByG_R(long groupId, long receiptId) {
		return getPersistence().countByG_R(groupId, receiptId);
	}

	/**
	 * Returns the receipt where receiptId = &#63; or throws a <code>NoSuchReceiptException</code> if it could not be found.
	 *
	 * @param receiptId the receipt ID
	 * @return the matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public static Receipt findByReceiptId(long receiptId)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByReceiptId(receiptId);
	}

	/**
	 * Returns the receipt where receiptId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByReceiptId(long receiptId) {
		return getPersistence().fetchByReceiptId(receiptId);
	}

	/**
	 * Returns the receipt where receiptId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchByReceiptId(
		long receiptId, boolean useFinderCache) {

		return getPersistence().fetchByReceiptId(receiptId, useFinderCache);
	}

	/**
	 * Removes the receipt where receiptId = &#63; from the database.
	 *
	 * @param receiptId the receipt ID
	 * @return the receipt that was removed
	 */
	public static Receipt removeByReceiptId(long receiptId)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().removeByReceiptId(receiptId);
	}

	/**
	 * Returns the number of receipts where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @return the number of matching receipts
	 */
	public static int countByReceiptId(long receiptId) {
		return getPersistence().countByReceiptId(receiptId);
	}

	/**
	 * Caches the receipt in the entity cache if it is enabled.
	 *
	 * @param receipt the receipt
	 */
	public static void cacheResult(Receipt receipt) {
		getPersistence().cacheResult(receipt);
	}

	/**
	 * Caches the receipts in the entity cache if it is enabled.
	 *
	 * @param receipts the receipts
	 */
	public static void cacheResult(List<Receipt> receipts) {
		getPersistence().cacheResult(receipts);
	}

	/**
	 * Creates a new receipt with the primary key. Does not add the receipt to the database.
	 *
	 * @param receiptId the primary key for the new receipt
	 * @return the new receipt
	 */
	public static Receipt create(long receiptId) {
		return getPersistence().create(receiptId);
	}

	/**
	 * Removes the receipt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt that was removed
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public static Receipt remove(long receiptId)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().remove(receiptId);
	}

	public static Receipt updateImpl(Receipt receipt) {
		return getPersistence().updateImpl(receipt);
	}

	/**
	 * Returns the receipt with the primary key or throws a <code>NoSuchReceiptException</code> if it could not be found.
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public static Receipt findByPrimaryKey(long receiptId)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getPersistence().findByPrimaryKey(receiptId);
	}

	/**
	 * Returns the receipt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt, or <code>null</code> if a receipt with the primary key could not be found
	 */
	public static Receipt fetchByPrimaryKey(long receiptId) {
		return getPersistence().fetchByPrimaryKey(receiptId);
	}

	/**
	 * Returns all the receipts.
	 *
	 * @return the receipts
	 */
	public static List<Receipt> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @return the range of receipts
	 */
	public static List<Receipt> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of receipts
	 */
	public static List<Receipt> findAll(
		int start, int end, OrderByComparator<Receipt> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of receipts
	 */
	public static List<Receipt> findAll(
		int start, int end, OrderByComparator<Receipt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the receipts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of receipts.
	 *
	 * @return the number of receipts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReceiptPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ReceiptPersistence _persistence;

}