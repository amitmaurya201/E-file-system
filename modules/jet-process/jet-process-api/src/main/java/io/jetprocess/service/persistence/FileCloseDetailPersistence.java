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

import io.jetprocess.exception.NoSuchFileCloseDetailException;
import io.jetprocess.model.FileCloseDetail;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the file close detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileCloseDetailUtil
 * @generated
 */
@ProviderType
public interface FileCloseDetailPersistence
	extends BasePersistence<FileCloseDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileCloseDetailUtil} to access the file close detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the file close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file close details
	 */
	public java.util.List<FileCloseDetail> findByUuid(String uuid);

	/**
	 * Returns a range of all the file close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @return the range of matching file close details
	 */
	public java.util.List<FileCloseDetail> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the file close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file close details
	 */
	public java.util.List<FileCloseDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file close details
	 */
	public java.util.List<FileCloseDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	public FileCloseDetail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
				orderByComparator)
		throws NoSuchFileCloseDetailException;

	/**
	 * Returns the first file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	public FileCloseDetail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator);

	/**
	 * Returns the last file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	public FileCloseDetail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
				orderByComparator)
		throws NoSuchFileCloseDetailException;

	/**
	 * Returns the last file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	public FileCloseDetail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator);

	/**
	 * Returns the file close details before and after the current file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param fileClosedId the primary key of the current file close detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file close detail
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	public FileCloseDetail[] findByUuid_PrevAndNext(
			long fileClosedId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
				orderByComparator)
		throws NoSuchFileCloseDetailException;

	/**
	 * Removes all the file close details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of file close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file close details
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the file close detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileCloseDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	public FileCloseDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchFileCloseDetailException;

	/**
	 * Returns the file close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	public FileCloseDetail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the file close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	public FileCloseDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the file close detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file close detail that was removed
	 */
	public FileCloseDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileCloseDetailException;

	/**
	 * Returns the number of file close details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file close details
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file close details
	 */
	public java.util.List<FileCloseDetail> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @return the range of matching file close details
	 */
	public java.util.List<FileCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file close details
	 */
	public java.util.List<FileCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file close details
	 */
	public java.util.List<FileCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	public FileCloseDetail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
				orderByComparator)
		throws NoSuchFileCloseDetailException;

	/**
	 * Returns the first file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	public FileCloseDetail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator);

	/**
	 * Returns the last file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	public FileCloseDetail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
				orderByComparator)
		throws NoSuchFileCloseDetailException;

	/**
	 * Returns the last file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	public FileCloseDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator);

	/**
	 * Returns the file close details before and after the current file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileClosedId the primary key of the current file close detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file close detail
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	public FileCloseDetail[] findByUuid_C_PrevAndNext(
			long fileClosedId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
				orderByComparator)
		throws NoSuchFileCloseDetailException;

	/**
	 * Removes all the file close details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file close details
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the file close detail in the entity cache if it is enabled.
	 *
	 * @param fileCloseDetail the file close detail
	 */
	public void cacheResult(FileCloseDetail fileCloseDetail);

	/**
	 * Caches the file close details in the entity cache if it is enabled.
	 *
	 * @param fileCloseDetails the file close details
	 */
	public void cacheResult(java.util.List<FileCloseDetail> fileCloseDetails);

	/**
	 * Creates a new file close detail with the primary key. Does not add the file close detail to the database.
	 *
	 * @param fileClosedId the primary key for the new file close detail
	 * @return the new file close detail
	 */
	public FileCloseDetail create(long fileClosedId);

	/**
	 * Removes the file close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail that was removed
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	public FileCloseDetail remove(long fileClosedId)
		throws NoSuchFileCloseDetailException;

	public FileCloseDetail updateImpl(FileCloseDetail fileCloseDetail);

	/**
	 * Returns the file close detail with the primary key or throws a <code>NoSuchFileCloseDetailException</code> if it could not be found.
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	public FileCloseDetail findByPrimaryKey(long fileClosedId)
		throws NoSuchFileCloseDetailException;

	/**
	 * Returns the file close detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail, or <code>null</code> if a file close detail with the primary key could not be found
	 */
	public FileCloseDetail fetchByPrimaryKey(long fileClosedId);

	/**
	 * Returns all the file close details.
	 *
	 * @return the file close details
	 */
	public java.util.List<FileCloseDetail> findAll();

	/**
	 * Returns a range of all the file close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @return the range of file close details
	 */
	public java.util.List<FileCloseDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the file close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file close details
	 */
	public java.util.List<FileCloseDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file close details
	 */
	public java.util.List<FileCloseDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCloseDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the file close details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of file close details.
	 *
	 * @return the number of file close details
	 */
	public int countAll();

}