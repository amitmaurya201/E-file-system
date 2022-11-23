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

import io.jetprocess.exception.NoSuchReceiptException;
import io.jetprocess.model.Receipt;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the receipt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptUtil
 * @generated
 */
@ProviderType
public interface ReceiptPersistence extends BasePersistence<Receipt> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReceiptUtil} to access the receipt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the receipts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receipts
	 */
	public java.util.List<Receipt> findByUuid(String uuid);

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
	public java.util.List<Receipt> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Receipt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

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
	public java.util.List<Receipt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Returns the first receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

	/**
	 * Returns the last receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Returns the last receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

	/**
	 * Returns the receipts before and after the current receipt in the ordered set where uuid = &#63;.
	 *
	 * @param receiptId the primary key of the current receipt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public Receipt[] findByUuid_PrevAndNext(
			long receiptId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Removes all the receipts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of receipts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receipts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the receipt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReceiptException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptException;

	/**
	 * Returns the receipt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the receipt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the receipt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receipt that was removed
	 */
	public Receipt removeByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptException;

	/**
	 * Returns the number of receipts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receipts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receipts
	 */
	public java.util.List<Receipt> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Receipt> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Receipt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

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
	public java.util.List<Receipt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Returns the first receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

	/**
	 * Returns the last receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Returns the last receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

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
	public Receipt[] findByUuid_C_PrevAndNext(
			long receiptId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Removes all the receipts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receipts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the receipts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching receipts
	 */
	public java.util.List<Receipt> findBygroupId(long groupId);

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
	public java.util.List<Receipt> findBygroupId(
		long groupId, int start, int end);

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
	public java.util.List<Receipt> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

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
	public java.util.List<Receipt> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first receipt in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findBygroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Returns the first receipt in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

	/**
	 * Returns the last receipt in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findBygroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Returns the last receipt in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

	/**
	 * Returns the receipts before and after the current receipt in the ordered set where groupId = &#63;.
	 *
	 * @param receiptId the primary key of the current receipt
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public Receipt[] findBygroupId_PrevAndNext(
			long receiptId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Removes all the receipts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeBygroupId(long groupId);

	/**
	 * Returns the number of receipts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching receipts
	 */
	public int countBygroupId(long groupId);

	/**
	 * Returns all the receipts where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @return the matching receipts
	 */
	public java.util.List<Receipt> findByG_R(long groupId, long receiptId);

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
	public java.util.List<Receipt> findByG_R(
		long groupId, long receiptId, int start, int end);

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
	public java.util.List<Receipt> findByG_R(
		long groupId, long receiptId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

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
	public java.util.List<Receipt> findByG_R(
		long groupId, long receiptId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first receipt in the ordered set where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findByG_R_First(
			long groupId, long receiptId,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Returns the first receipt in the ordered set where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByG_R_First(
		long groupId, long receiptId,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

	/**
	 * Returns the last receipt in the ordered set where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findByG_R_Last(
			long groupId, long receiptId,
			com.liferay.portal.kernel.util.OrderByComparator<Receipt>
				orderByComparator)
		throws NoSuchReceiptException;

	/**
	 * Returns the last receipt in the ordered set where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByG_R_Last(
		long groupId, long receiptId,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

	/**
	 * Removes all the receipts where groupId = &#63; and receiptId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 */
	public void removeByG_R(long groupId, long receiptId);

	/**
	 * Returns the number of receipts where groupId = &#63; and receiptId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param receiptId the receipt ID
	 * @return the number of matching receipts
	 */
	public int countByG_R(long groupId, long receiptId);

	/**
	 * Returns the receipt where receiptId = &#63; or throws a <code>NoSuchReceiptException</code> if it could not be found.
	 *
	 * @param receiptId the receipt ID
	 * @return the matching receipt
	 * @throws NoSuchReceiptException if a matching receipt could not be found
	 */
	public Receipt findByReceiptId(long receiptId)
		throws NoSuchReceiptException;

	/**
	 * Returns the receipt where receiptId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByReceiptId(long receiptId);

	/**
	 * Returns the receipt where receiptId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public Receipt fetchByReceiptId(long receiptId, boolean useFinderCache);

	/**
	 * Removes the receipt where receiptId = &#63; from the database.
	 *
	 * @param receiptId the receipt ID
	 * @return the receipt that was removed
	 */
	public Receipt removeByReceiptId(long receiptId)
		throws NoSuchReceiptException;

	/**
	 * Returns the number of receipts where receiptId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @return the number of matching receipts
	 */
	public int countByReceiptId(long receiptId);

	/**
	 * Caches the receipt in the entity cache if it is enabled.
	 *
	 * @param receipt the receipt
	 */
	public void cacheResult(Receipt receipt);

	/**
	 * Caches the receipts in the entity cache if it is enabled.
	 *
	 * @param receipts the receipts
	 */
	public void cacheResult(java.util.List<Receipt> receipts);

	/**
	 * Creates a new receipt with the primary key. Does not add the receipt to the database.
	 *
	 * @param receiptId the primary key for the new receipt
	 * @return the new receipt
	 */
	public Receipt create(long receiptId);

	/**
	 * Removes the receipt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt that was removed
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public Receipt remove(long receiptId) throws NoSuchReceiptException;

	public Receipt updateImpl(Receipt receipt);

	/**
	 * Returns the receipt with the primary key or throws a <code>NoSuchReceiptException</code> if it could not be found.
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt
	 * @throws NoSuchReceiptException if a receipt with the primary key could not be found
	 */
	public Receipt findByPrimaryKey(long receiptId)
		throws NoSuchReceiptException;

	/**
	 * Returns the receipt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt, or <code>null</code> if a receipt with the primary key could not be found
	 */
	public Receipt fetchByPrimaryKey(long receiptId);

	/**
	 * Returns all the receipts.
	 *
	 * @return the receipts
	 */
	public java.util.List<Receipt> findAll();

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
	public java.util.List<Receipt> findAll(int start, int end);

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
	public java.util.List<Receipt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator);

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
	public java.util.List<Receipt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Receipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the receipts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of receipts.
	 *
	 * @return the number of receipts
	 */
	public int countAll();

}