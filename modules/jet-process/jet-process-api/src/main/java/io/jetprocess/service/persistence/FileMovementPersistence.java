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

import io.jetprocess.exception.NoSuchFileMovementException;
import io.jetprocess.model.FileMovement;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the file movement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileMovementUtil
 * @generated
 */
@ProviderType
public interface FileMovementPersistence extends BasePersistence<FileMovement> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileMovementUtil} to access the file movement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the file movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file movements
	 */
	public java.util.List<FileMovement> findByUuid(String uuid);

	/**
	 * Returns a range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of matching file movements
	 */
	public java.util.List<FileMovement> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file movements
	 */
	public java.util.List<FileMovement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file movements
	 */
	public java.util.List<FileMovement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public FileMovement findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
				orderByComparator)
		throws NoSuchFileMovementException;

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public FileMovement fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator);

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public FileMovement findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
				orderByComparator)
		throws NoSuchFileMovementException;

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public FileMovement fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator);

	/**
	 * Returns the file movements before and after the current file movement in the ordered set where uuid = &#63;.
	 *
	 * @param fmId the primary key of the current file movement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	public FileMovement[] findByUuid_PrevAndNext(
			long fmId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
				orderByComparator)
		throws NoSuchFileMovementException;

	/**
	 * Removes all the file movements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of file movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file movements
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public FileMovement findByUUID_G(String uuid, long groupId)
		throws NoSuchFileMovementException;

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public FileMovement fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public FileMovement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the file movement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file movement that was removed
	 */
	public FileMovement removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileMovementException;

	/**
	 * Returns the number of file movements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file movements
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file movements
	 */
	public java.util.List<FileMovement> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of matching file movements
	 */
	public java.util.List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file movements
	 */
	public java.util.List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file movements
	 */
	public java.util.List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public FileMovement findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
				orderByComparator)
		throws NoSuchFileMovementException;

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public FileMovement fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator);

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public FileMovement findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
				orderByComparator)
		throws NoSuchFileMovementException;

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public FileMovement fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator);

	/**
	 * Returns the file movements before and after the current file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fmId the primary key of the current file movement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	public FileMovement[] findByUuid_C_PrevAndNext(
			long fmId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
				orderByComparator)
		throws NoSuchFileMovementException;

	/**
	 * Removes all the file movements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file movements
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the file movement where fileId = &#63; or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @return the matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	public FileMovement findByfileId(long fileId)
		throws NoSuchFileMovementException;

	/**
	 * Returns the file movement where fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public FileMovement fetchByfileId(long fileId);

	/**
	 * Returns the file movement where fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public FileMovement fetchByfileId(long fileId, boolean useFinderCache);

	/**
	 * Removes the file movement where fileId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @return the file movement that was removed
	 */
	public FileMovement removeByfileId(long fileId)
		throws NoSuchFileMovementException;

	/**
	 * Returns the number of file movements where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the number of matching file movements
	 */
	public int countByfileId(long fileId);

	/**
	 * Caches the file movement in the entity cache if it is enabled.
	 *
	 * @param fileMovement the file movement
	 */
	public void cacheResult(FileMovement fileMovement);

	/**
	 * Caches the file movements in the entity cache if it is enabled.
	 *
	 * @param fileMovements the file movements
	 */
	public void cacheResult(java.util.List<FileMovement> fileMovements);

	/**
	 * Creates a new file movement with the primary key. Does not add the file movement to the database.
	 *
	 * @param fmId the primary key for the new file movement
	 * @return the new file movement
	 */
	public FileMovement create(long fmId);

	/**
	 * Removes the file movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement that was removed
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	public FileMovement remove(long fmId) throws NoSuchFileMovementException;

	public FileMovement updateImpl(FileMovement fileMovement);

	/**
	 * Returns the file movement with the primary key or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	public FileMovement findByPrimaryKey(long fmId)
		throws NoSuchFileMovementException;

	/**
	 * Returns the file movement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement, or <code>null</code> if a file movement with the primary key could not be found
	 */
	public FileMovement fetchByPrimaryKey(long fmId);

	/**
	 * Returns all the file movements.
	 *
	 * @return the file movements
	 */
	public java.util.List<FileMovement> findAll();

	/**
	 * Returns a range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of file movements
	 */
	public java.util.List<FileMovement> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file movements
	 */
	public java.util.List<FileMovement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file movements
	 */
	public java.util.List<FileMovement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the file movements from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of file movements.
	 *
	 * @return the number of file movements
	 */
	public int countAll();

}