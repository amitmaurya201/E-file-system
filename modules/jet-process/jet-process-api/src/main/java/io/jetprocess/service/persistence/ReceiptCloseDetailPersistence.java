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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import io.jetprocess.exception.NoSuchReceiptCloseDetailException;
import io.jetprocess.model.ReceiptCloseDetail;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the receipt close detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptCloseDetailUtil
 * @generated
 */
@ProviderType
public interface ReceiptCloseDetailPersistence
	extends BasePersistence<ReceiptCloseDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReceiptCloseDetailUtil} to access the receipt close detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the receipt close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receipt close details
	 */
	public java.util.List<ReceiptCloseDetail> findByUuid(String uuid);

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
	public java.util.List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator);

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
	public java.util.List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
				orderByComparator)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator);

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
				orderByComparator)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator);

	/**
	 * Returns the receipt close details before and after the current receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param ReceiptClosedId the primary key of the current receipt close detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	public ReceiptCloseDetail[] findByUuid_PrevAndNext(
			long ReceiptClosedId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
				orderByComparator)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Removes all the receipt close details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of receipt close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receipt close details
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReceiptCloseDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the receipt close detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receipt close detail that was removed
	 */
	public ReceiptCloseDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Returns the number of receipt close details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receipt close details
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receipt close details
	 */
	public java.util.List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator);

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
	public java.util.List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
				orderByComparator)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator);

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
				orderByComparator)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public ReceiptCloseDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator);

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
	public ReceiptCloseDetail[] findByUuid_C_PrevAndNext(
			long ReceiptClosedId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
				orderByComparator)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Removes all the receipt close details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receipt close details
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the receipt close detail in the entity cache if it is enabled.
	 *
	 * @param receiptCloseDetail the receipt close detail
	 */
	public void cacheResult(ReceiptCloseDetail receiptCloseDetail);

	/**
	 * Caches the receipt close details in the entity cache if it is enabled.
	 *
	 * @param receiptCloseDetails the receipt close details
	 */
	public void cacheResult(
		java.util.List<ReceiptCloseDetail> receiptCloseDetails);

	/**
	 * Creates a new receipt close detail with the primary key. Does not add the receipt close detail to the database.
	 *
	 * @param ReceiptClosedId the primary key for the new receipt close detail
	 * @return the new receipt close detail
	 */
	public ReceiptCloseDetail create(long ReceiptClosedId);

	/**
	 * Removes the receipt close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail that was removed
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	public ReceiptCloseDetail remove(long ReceiptClosedId)
		throws NoSuchReceiptCloseDetailException;

	public ReceiptCloseDetail updateImpl(ReceiptCloseDetail receiptCloseDetail);

	/**
	 * Returns the receipt close detail with the primary key or throws a <code>NoSuchReceiptCloseDetailException</code> if it could not be found.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	public ReceiptCloseDetail findByPrimaryKey(long ReceiptClosedId)
		throws NoSuchReceiptCloseDetailException;

	/**
	 * Returns the receipt close detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail, or <code>null</code> if a receipt close detail with the primary key could not be found
	 */
	public ReceiptCloseDetail fetchByPrimaryKey(long ReceiptClosedId);

	/**
	 * Returns all the receipt close details.
	 *
	 * @return the receipt close details
	 */
	public java.util.List<ReceiptCloseDetail> findAll();

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
	public java.util.List<ReceiptCloseDetail> findAll(int start, int end);

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
	public java.util.List<ReceiptCloseDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator);

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
	public java.util.List<ReceiptCloseDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptCloseDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the receipt close details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of receipt close details.
	 *
	 * @return the number of receipt close details
	 */
	public int countAll();

}