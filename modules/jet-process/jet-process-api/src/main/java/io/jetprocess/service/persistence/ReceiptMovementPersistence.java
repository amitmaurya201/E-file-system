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

import io.jetprocess.exception.NoSuchReceiptMovementException;
import io.jetprocess.model.ReceiptMovement;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the receipt movement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptMovementUtil
 * @generated
 */
@ProviderType
public interface ReceiptMovementPersistence
	extends BasePersistence<ReceiptMovement> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReceiptMovementUtil} to access the receipt movement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the receipt movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receipt movements
	 */
	public java.util.List<ReceiptMovement> findByUuid(String uuid);

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
	public java.util.List<ReceiptMovement> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ReceiptMovement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator);

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
	public java.util.List<ReceiptMovement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public ReceiptMovement findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
				orderByComparator)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public ReceiptMovement fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator);

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public ReceiptMovement findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
				orderByComparator)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public ReceiptMovement fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator);

	/**
	 * Returns the receipt movements before and after the current receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param rmId the primary key of the current receipt movement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	public ReceiptMovement[] findByUuid_PrevAndNext(
			long rmId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
				orderByComparator)
		throws NoSuchReceiptMovementException;

	/**
	 * Removes all the receipt movements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of receipt movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receipt movements
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReceiptMovementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public ReceiptMovement findByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public ReceiptMovement fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public ReceiptMovement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the receipt movement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receipt movement that was removed
	 */
	public ReceiptMovement removeByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the number of receipt movements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receipt movements
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receipt movements
	 */
	public java.util.List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator);

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
	public java.util.List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public ReceiptMovement findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
				orderByComparator)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public ReceiptMovement fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator);

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public ReceiptMovement findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
				orderByComparator)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public ReceiptMovement fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator);

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
	public ReceiptMovement[] findByUuid_C_PrevAndNext(
			long rmId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
				orderByComparator)
		throws NoSuchReceiptMovementException;

	/**
	 * Removes all the receipt movements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receipt movements
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the receipt movement where receiptId = &#63; or throws a <code>NoSuchReceiptMovementException</code> if it could not be found.
	 *
	 * @param receiptId the receipt ID
	 * @return the matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	public ReceiptMovement findByreceiptId(long receiptId)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the receipt movement where receiptId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public ReceiptMovement fetchByreceiptId(long receiptId);

	/**
	 * Returns the receipt movement where receiptId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public ReceiptMovement fetchByreceiptId(
		long receiptId, boolean useFinderCache);

	/**
	 * Removes the receipt movement where receiptId = &#63; from the database.
	 *
	 * @param receiptId the receipt ID
	 * @return the receipt movement that was removed
	 */
	public ReceiptMovement removeByreceiptId(long receiptId)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the number of receipt movements where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @return the number of matching receipt movements
	 */
	public int countByreceiptId(long receiptId);

	/**
	 * Caches the receipt movement in the entity cache if it is enabled.
	 *
	 * @param receiptMovement the receipt movement
	 */
	public void cacheResult(ReceiptMovement receiptMovement);

	/**
	 * Caches the receipt movements in the entity cache if it is enabled.
	 *
	 * @param receiptMovements the receipt movements
	 */
	public void cacheResult(java.util.List<ReceiptMovement> receiptMovements);

	/**
	 * Creates a new receipt movement with the primary key. Does not add the receipt movement to the database.
	 *
	 * @param rmId the primary key for the new receipt movement
	 * @return the new receipt movement
	 */
	public ReceiptMovement create(long rmId);

	/**
	 * Removes the receipt movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement that was removed
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	public ReceiptMovement remove(long rmId)
		throws NoSuchReceiptMovementException;

	public ReceiptMovement updateImpl(ReceiptMovement receiptMovement);

	/**
	 * Returns the receipt movement with the primary key or throws a <code>NoSuchReceiptMovementException</code> if it could not be found.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	public ReceiptMovement findByPrimaryKey(long rmId)
		throws NoSuchReceiptMovementException;

	/**
	 * Returns the receipt movement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement, or <code>null</code> if a receipt movement with the primary key could not be found
	 */
	public ReceiptMovement fetchByPrimaryKey(long rmId);

	/**
	 * Returns all the receipt movements.
	 *
	 * @return the receipt movements
	 */
	public java.util.List<ReceiptMovement> findAll();

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
	public java.util.List<ReceiptMovement> findAll(int start, int end);

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
	public java.util.List<ReceiptMovement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator);

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
	public java.util.List<ReceiptMovement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReceiptMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the receipt movements from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of receipt movements.
	 *
	 * @return the number of receipt movements
	 */
	public int countAll();

}