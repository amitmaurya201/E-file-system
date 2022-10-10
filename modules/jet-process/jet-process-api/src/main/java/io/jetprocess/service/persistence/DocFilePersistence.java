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

import io.jetprocess.exception.NoSuchDocFileException;
import io.jetprocess.model.DocFile;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the doc file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocFileUtil
 * @generated
 */
@ProviderType
public interface DocFilePersistence extends BasePersistence<DocFile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocFileUtil} to access the doc file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the doc files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching doc files
	 */
	public java.util.List<DocFile> findByUuid(String uuid);

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
	public java.util.List<DocFile> findByUuid(String uuid, int start, int end);

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
	public java.util.List<DocFile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

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
	public java.util.List<DocFile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

	/**
	 * Returns the doc files before and after the current doc file in the ordered set where uuid = &#63;.
	 *
	 * @param docFileId the primary key of the current doc file
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public DocFile[] findByUuid_PrevAndNext(
			long docFileId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Removes all the doc files where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of doc files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching doc files
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findByUUID_G(String uuid, long groupId)
		throws NoSuchDocFileException;

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the doc file where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the doc file that was removed
	 */
	public DocFile removeByUUID_G(String uuid, long groupId)
		throws NoSuchDocFileException;

	/**
	 * Returns the number of doc files where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching doc files
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching doc files
	 */
	public java.util.List<DocFile> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

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
	public java.util.List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

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
	public DocFile[] findByUuid_C_PrevAndNext(
			long docFileId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Removes all the doc files where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching doc files
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the doc files where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching doc files
	 */
	public java.util.List<DocFile> findBygroupId(long groupId);

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
	public java.util.List<DocFile> findBygroupId(
		long groupId, int start, int end);

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
	public java.util.List<DocFile> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

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
	public java.util.List<DocFile> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findBygroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Returns the first doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

	/**
	 * Returns the last doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findBygroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Returns the last doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

	/**
	 * Returns the doc files before and after the current doc file in the ordered set where groupId = &#63;.
	 *
	 * @param docFileId the primary key of the current doc file
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public DocFile[] findBygroupId_PrevAndNext(
			long docFileId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DocFile>
				orderByComparator)
		throws NoSuchDocFileException;

	/**
	 * Removes all the doc files where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeBygroupId(long groupId);

	/**
	 * Returns the number of doc files where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching doc files
	 */
	public int countBygroupId(long groupId);

	/**
	 * Returns the doc file where docFileId = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param docFileId the doc file ID
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findByDocFileId(long docFileId)
		throws NoSuchDocFileException;

	/**
	 * Returns the doc file where docFileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param docFileId the doc file ID
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByDocFileId(long docFileId);

	/**
	 * Returns the doc file where docFileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param docFileId the doc file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByDocFileId(long docFileId, boolean useFinderCache);

	/**
	 * Removes the doc file where docFileId = &#63; from the database.
	 *
	 * @param docFileId the doc file ID
	 * @return the doc file that was removed
	 */
	public DocFile removeByDocFileId(long docFileId)
		throws NoSuchDocFileException;

	/**
	 * Returns the number of doc files where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @return the number of matching doc files
	 */
	public int countByDocFileId(long docFileId);

	/**
	 * Returns the doc file where nature = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param nature the nature
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	public DocFile findByNature(String nature) throws NoSuchDocFileException;

	/**
	 * Returns the doc file where nature = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nature the nature
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByNature(String nature);

	/**
	 * Returns the doc file where nature = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nature the nature
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public DocFile fetchByNature(String nature, boolean useFinderCache);

	/**
	 * Removes the doc file where nature = &#63; from the database.
	 *
	 * @param nature the nature
	 * @return the doc file that was removed
	 */
	public DocFile removeByNature(String nature) throws NoSuchDocFileException;

	/**
	 * Returns the number of doc files where nature = &#63;.
	 *
	 * @param nature the nature
	 * @return the number of matching doc files
	 */
	public int countByNature(String nature);

	/**
	 * Caches the doc file in the entity cache if it is enabled.
	 *
	 * @param docFile the doc file
	 */
	public void cacheResult(DocFile docFile);

	/**
	 * Caches the doc files in the entity cache if it is enabled.
	 *
	 * @param docFiles the doc files
	 */
	public void cacheResult(java.util.List<DocFile> docFiles);

	/**
	 * Creates a new doc file with the primary key. Does not add the doc file to the database.
	 *
	 * @param docFileId the primary key for the new doc file
	 * @return the new doc file
	 */
	public DocFile create(long docFileId);

	/**
	 * Removes the doc file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file that was removed
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public DocFile remove(long docFileId) throws NoSuchDocFileException;

	public DocFile updateImpl(DocFile docFile);

	/**
	 * Returns the doc file with the primary key or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	public DocFile findByPrimaryKey(long docFileId)
		throws NoSuchDocFileException;

	/**
	 * Returns the doc file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file, or <code>null</code> if a doc file with the primary key could not be found
	 */
	public DocFile fetchByPrimaryKey(long docFileId);

	/**
	 * Returns all the doc files.
	 *
	 * @return the doc files
	 */
	public java.util.List<DocFile> findAll();

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
	public java.util.List<DocFile> findAll(int start, int end);

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
	public java.util.List<DocFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator);

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
	public java.util.List<DocFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the doc files from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of doc files.
	 *
	 * @return the number of doc files
	 */
	public int countAll();

}