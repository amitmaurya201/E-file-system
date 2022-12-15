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

import io.jetprocess.exception.NoSuchFileCorrException;
import io.jetprocess.model.FileCorr;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the file corr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrUtil
 * @generated
 */
@ProviderType
public interface FileCorrPersistence extends BasePersistence<FileCorr> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileCorrUtil} to access the file corr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the file corrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file corrs
	 */
	public java.util.List<FileCorr> findByUuid(String uuid);

	/**
	 * Returns a range of all the file corrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @return the range of matching file corrs
	 */
	public java.util.List<FileCorr> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the file corrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corrs
	 */
	public java.util.List<FileCorr> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file corrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corrs
	 */
	public java.util.List<FileCorr> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file corr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public FileCorr findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
				orderByComparator)
		throws NoSuchFileCorrException;

	/**
	 * Returns the first file corr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public FileCorr fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator);

	/**
	 * Returns the last file corr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public FileCorr findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
				orderByComparator)
		throws NoSuchFileCorrException;

	/**
	 * Returns the last file corr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public FileCorr fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator);

	/**
	 * Returns the file corrs before and after the current file corr in the ordered set where uuid = &#63;.
	 *
	 * @param fileCorrId the primary key of the current file corr
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr
	 * @throws NoSuchFileCorrException if a file corr with the primary key could not be found
	 */
	public FileCorr[] findByUuid_PrevAndNext(
			long fileCorrId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
				orderByComparator)
		throws NoSuchFileCorrException;

	/**
	 * Removes all the file corrs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of file corrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file corrs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the file corr where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileCorrException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public FileCorr findByUUID_G(String uuid, long groupId)
		throws NoSuchFileCorrException;

	/**
	 * Returns the file corr where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public FileCorr fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the file corr where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public FileCorr fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the file corr where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file corr that was removed
	 */
	public FileCorr removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileCorrException;

	/**
	 * Returns the number of file corrs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file corrs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file corrs
	 */
	public java.util.List<FileCorr> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @return the range of matching file corrs
	 */
	public java.util.List<FileCorr> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corrs
	 */
	public java.util.List<FileCorr> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corrs
	 */
	public java.util.List<FileCorr> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public FileCorr findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
				orderByComparator)
		throws NoSuchFileCorrException;

	/**
	 * Returns the first file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public FileCorr fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator);

	/**
	 * Returns the last file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr
	 * @throws NoSuchFileCorrException if a matching file corr could not be found
	 */
	public FileCorr findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
				orderByComparator)
		throws NoSuchFileCorrException;

	/**
	 * Returns the last file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public FileCorr fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator);

	/**
	 * Returns the file corrs before and after the current file corr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileCorrId the primary key of the current file corr
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr
	 * @throws NoSuchFileCorrException if a file corr with the primary key could not be found
	 */
	public FileCorr[] findByUuid_C_PrevAndNext(
			long fileCorrId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
				orderByComparator)
		throws NoSuchFileCorrException;

	/**
	 * Removes all the file corrs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of file corrs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file corrs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the file corr in the entity cache if it is enabled.
	 *
	 * @param fileCorr the file corr
	 */
	public void cacheResult(FileCorr fileCorr);

	/**
	 * Caches the file corrs in the entity cache if it is enabled.
	 *
	 * @param fileCorrs the file corrs
	 */
	public void cacheResult(java.util.List<FileCorr> fileCorrs);

	/**
	 * Creates a new file corr with the primary key. Does not add the file corr to the database.
	 *
	 * @param fileCorrId the primary key for the new file corr
	 * @return the new file corr
	 */
	public FileCorr create(long fileCorrId);

	/**
	 * Removes the file corr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr that was removed
	 * @throws NoSuchFileCorrException if a file corr with the primary key could not be found
	 */
	public FileCorr remove(long fileCorrId) throws NoSuchFileCorrException;

	public FileCorr updateImpl(FileCorr fileCorr);

	/**
	 * Returns the file corr with the primary key or throws a <code>NoSuchFileCorrException</code> if it could not be found.
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr
	 * @throws NoSuchFileCorrException if a file corr with the primary key could not be found
	 */
	public FileCorr findByPrimaryKey(long fileCorrId)
		throws NoSuchFileCorrException;

	/**
	 * Returns the file corr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr, or <code>null</code> if a file corr with the primary key could not be found
	 */
	public FileCorr fetchByPrimaryKey(long fileCorrId);

	/**
	 * Returns all the file corrs.
	 *
	 * @return the file corrs
	 */
	public java.util.List<FileCorr> findAll();

	/**
	 * Returns a range of all the file corrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @return the range of file corrs
	 */
	public java.util.List<FileCorr> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the file corrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file corrs
	 */
	public java.util.List<FileCorr> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file corrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file corrs
	 */
	public java.util.List<FileCorr> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileCorr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the file corrs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of file corrs.
	 *
	 * @return the number of file corrs
	 */
	public int countAll();

}