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

import io.jetprocess.exception.NoSuchFileCorrReceiptException;
import io.jetprocess.model.FileCorrReceipt;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the file corr receipt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrReceiptUtil
 * @generated
 */
@ProviderType
public interface FileCorrReceiptPersistence
	extends BasePersistence<FileCorrReceipt> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileCorrReceiptUtil} to access the file corr receipt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the file corr receipts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByUuid(String uuid);

	/**
	 * Returns a range of all the file corr receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the file corr receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file corr receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the first file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns the last file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the last file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns the file corr receipts before and after the current file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param fileCorrReceiptId the primary key of the current file corr receipt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	public FileCorrReceipt[] findByUuid_PrevAndNext(
			long fileCorrReceiptId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Removes all the file corr receipts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of file corr receipts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file corr receipts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the file corr receipt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileCorrReceiptException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt findByUUID_G(String uuid, long groupId)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the file corr receipt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the file corr receipt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the file corr receipt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file corr receipt that was removed
	 */
	public FileCorrReceipt removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the number of file corr receipts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file corr receipts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the first file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns the last file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the last file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns the file corr receipts before and after the current file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileCorrReceiptId the primary key of the current file corr receipt
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	public FileCorrReceipt[] findByUuid_C_PrevAndNext(
			long fileCorrReceiptId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Removes all the file corr receipts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file corr receipts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the file corr receipts where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @return the matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByfileCorrReceiptBydocFileId(
		long docFileId);

	/**
	 * Returns a range of all the file corr receipts where docFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param docFileId the doc file ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByfileCorrReceiptBydocFileId(
		long docFileId, int start, int end);

	/**
	 * Returns an ordered range of all the file corr receipts where docFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param docFileId the doc file ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByfileCorrReceiptBydocFileId(
		long docFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file corr receipts where docFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param docFileId the doc file ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findByfileCorrReceiptBydocFileId(
		long docFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt findByfileCorrReceiptBydocFileId_First(
			long docFileId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the first file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByfileCorrReceiptBydocFileId_First(
		long docFileId,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns the last file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt findByfileCorrReceiptBydocFileId_Last(
			long docFileId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the last file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByfileCorrReceiptBydocFileId_Last(
		long docFileId,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns the file corr receipts before and after the current file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param fileCorrReceiptId the primary key of the current file corr receipt
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	public FileCorrReceipt[] findByfileCorrReceiptBydocFileId_PrevAndNext(
			long fileCorrReceiptId, long docFileId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
				orderByComparator)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Removes all the file corr receipts where docFileId = &#63; from the database.
	 *
	 * @param docFileId the doc file ID
	 */
	public void removeByfileCorrReceiptBydocFileId(long docFileId);

	/**
	 * Returns the number of file corr receipts where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @return the number of matching file corr receipts
	 */
	public int countByfileCorrReceiptBydocFileId(long docFileId);

	/**
	 * Returns the file corr receipt where receiptId = &#63; and receiptMovementId = &#63; or throws a <code>NoSuchFileCorrReceiptException</code> if it could not be found.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @return the matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt findByFileCorrReceipt(
			long receiptId, long receiptMovementId)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the file corr receipt where receiptId = &#63; and receiptMovementId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByFileCorrReceipt(
		long receiptId, long receiptMovementId);

	/**
	 * Returns the file corr receipt where receiptId = &#63; and receiptMovementId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	public FileCorrReceipt fetchByFileCorrReceipt(
		long receiptId, long receiptMovementId, boolean useFinderCache);

	/**
	 * Removes the file corr receipt where receiptId = &#63; and receiptMovementId = &#63; from the database.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @return the file corr receipt that was removed
	 */
	public FileCorrReceipt removeByFileCorrReceipt(
			long receiptId, long receiptMovementId)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the number of file corr receipts where receiptId = &#63; and receiptMovementId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @return the number of matching file corr receipts
	 */
	public int countByFileCorrReceipt(long receiptId, long receiptMovementId);

	/**
	 * Caches the file corr receipt in the entity cache if it is enabled.
	 *
	 * @param fileCorrReceipt the file corr receipt
	 */
	public void cacheResult(FileCorrReceipt fileCorrReceipt);

	/**
	 * Caches the file corr receipts in the entity cache if it is enabled.
	 *
	 * @param fileCorrReceipts the file corr receipts
	 */
	public void cacheResult(java.util.List<FileCorrReceipt> fileCorrReceipts);

	/**
	 * Creates a new file corr receipt with the primary key. Does not add the file corr receipt to the database.
	 *
	 * @param fileCorrReceiptId the primary key for the new file corr receipt
	 * @return the new file corr receipt
	 */
	public FileCorrReceipt create(long fileCorrReceiptId);

	/**
	 * Removes the file corr receipt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt that was removed
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	public FileCorrReceipt remove(long fileCorrReceiptId)
		throws NoSuchFileCorrReceiptException;

	public FileCorrReceipt updateImpl(FileCorrReceipt fileCorrReceipt);

	/**
	 * Returns the file corr receipt with the primary key or throws a <code>NoSuchFileCorrReceiptException</code> if it could not be found.
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	public FileCorrReceipt findByPrimaryKey(long fileCorrReceiptId)
		throws NoSuchFileCorrReceiptException;

	/**
	 * Returns the file corr receipt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt, or <code>null</code> if a file corr receipt with the primary key could not be found
	 */
	public FileCorrReceipt fetchByPrimaryKey(long fileCorrReceiptId);

	/**
	 * Returns all the file corr receipts.
	 *
	 * @return the file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findAll();

	/**
	 * Returns a range of all the file corr receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the file corr receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file corr receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file corr receipts
	 */
	public java.util.List<FileCorrReceipt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorrReceipt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the file corr receipts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of file corr receipts.
	 *
	 * @return the number of file corr receipts
	 */
	public int countAll();

}