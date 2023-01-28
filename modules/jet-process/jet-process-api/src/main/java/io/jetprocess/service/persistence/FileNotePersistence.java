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

import io.jetprocess.exception.NoSuchFileNoteException;
import io.jetprocess.model.FileNote;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the file note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileNoteUtil
 * @generated
 */
@ProviderType
public interface FileNotePersistence extends BasePersistence<FileNote> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileNoteUtil} to access the file note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the file notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file notes
	 */
	public java.util.List<FileNote> findByUuid(String uuid);

	/**
	 * Returns a range of all the file notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of matching file notes
	 */
	public java.util.List<FileNote> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the file notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file notes
	 */
	public java.util.List<FileNote> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file notes
	 */
	public java.util.List<FileNote> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Returns the first file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns the last file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Returns the last file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns the file notes before and after the current file note in the ordered set where uuid = &#63;.
	 *
	 * @param fileNoteId the primary key of the current file note
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	public FileNote[] findByUuid_PrevAndNext(
			long fileNoteId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Removes all the file notes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of file notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file notes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByUUID_G(String uuid, long groupId)
		throws NoSuchFileNoteException;

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the file note where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file note that was removed
	 */
	public FileNote removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileNoteException;

	/**
	 * Returns the number of file notes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file notes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file notes
	 */
	public java.util.List<FileNote> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of matching file notes
	 */
	public java.util.List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file notes
	 */
	public java.util.List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file notes
	 */
	public java.util.List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Returns the first file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns the last file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Returns the last file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns the file notes before and after the current file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileNoteId the primary key of the current file note
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	public FileNote[] findByUuid_C_PrevAndNext(
			long fileNoteId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Removes all the file notes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file notes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the file note where fileId = &#63; and noteId = &#63; or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @param noteId the note ID
	 * @return the matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByFileIdAndNoteId(long fileId, long noteId)
		throws NoSuchFileNoteException;

	/**
	 * Returns the file note where fileId = &#63; and noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @param noteId the note ID
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByFileIdAndNoteId(long fileId, long noteId);

	/**
	 * Returns the file note where fileId = &#63; and noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param noteId the note ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByFileIdAndNoteId(
		long fileId, long noteId, boolean useFinderCache);

	/**
	 * Removes the file note where fileId = &#63; and noteId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @param noteId the note ID
	 * @return the file note that was removed
	 */
	public FileNote removeByFileIdAndNoteId(long fileId, long noteId)
		throws NoSuchFileNoteException;

	/**
	 * Returns the number of file notes where fileId = &#63; and noteId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param noteId the note ID
	 * @return the number of matching file notes
	 */
	public int countByFileIdAndNoteId(long fileId, long noteId);

	/**
	 * Returns the file note where noteId = &#63; or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param noteId the note ID
	 * @return the matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByNoteId(long noteId) throws NoSuchFileNoteException;

	/**
	 * Returns the file note where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param noteId the note ID
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByNoteId(long noteId);

	/**
	 * Returns the file note where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param noteId the note ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByNoteId(long noteId, boolean useFinderCache);

	/**
	 * Removes the file note where noteId = &#63; from the database.
	 *
	 * @param noteId the note ID
	 * @return the file note that was removed
	 */
	public FileNote removeByNoteId(long noteId) throws NoSuchFileNoteException;

	/**
	 * Returns the number of file notes where noteId = &#63;.
	 *
	 * @param noteId the note ID
	 * @return the number of matching file notes
	 */
	public int countByNoteId(long noteId);

	/**
	 * Returns all the file notes where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the matching file notes
	 */
	public java.util.List<FileNote> findByFileNoteListByFileId(long fileId);

	/**
	 * Returns a range of all the file notes where fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of matching file notes
	 */
	public java.util.List<FileNote> findByFileNoteListByFileId(
		long fileId, int start, int end);

	/**
	 * Returns an ordered range of all the file notes where fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file notes
	 */
	public java.util.List<FileNote> findByFileNoteListByFileId(
		long fileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file notes where fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file notes
	 */
	public java.util.List<FileNote> findByFileNoteListByFileId(
		long fileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file note in the ordered set where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByFileNoteListByFileId_First(
			long fileId,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Returns the first file note in the ordered set where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByFileNoteListByFileId_First(
		long fileId,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns the last file note in the ordered set where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public FileNote findByFileNoteListByFileId_Last(
			long fileId,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Returns the last file note in the ordered set where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public FileNote fetchByFileNoteListByFileId_Last(
		long fileId,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns the file notes before and after the current file note in the ordered set where fileId = &#63;.
	 *
	 * @param fileNoteId the primary key of the current file note
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	public FileNote[] findByFileNoteListByFileId_PrevAndNext(
			long fileNoteId, long fileId,
			com.liferay.portal.kernel.util.OrderByComparator<FileNote>
				orderByComparator)
		throws NoSuchFileNoteException;

	/**
	 * Removes all the file notes where fileId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 */
	public void removeByFileNoteListByFileId(long fileId);

	/**
	 * Returns the number of file notes where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the number of matching file notes
	 */
	public int countByFileNoteListByFileId(long fileId);

	/**
	 * Caches the file note in the entity cache if it is enabled.
	 *
	 * @param fileNote the file note
	 */
	public void cacheResult(FileNote fileNote);

	/**
	 * Caches the file notes in the entity cache if it is enabled.
	 *
	 * @param fileNotes the file notes
	 */
	public void cacheResult(java.util.List<FileNote> fileNotes);

	/**
	 * Creates a new file note with the primary key. Does not add the file note to the database.
	 *
	 * @param fileNoteId the primary key for the new file note
	 * @return the new file note
	 */
	public FileNote create(long fileNoteId);

	/**
	 * Removes the file note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note that was removed
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	public FileNote remove(long fileNoteId) throws NoSuchFileNoteException;

	public FileNote updateImpl(FileNote fileNote);

	/**
	 * Returns the file note with the primary key or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	public FileNote findByPrimaryKey(long fileNoteId)
		throws NoSuchFileNoteException;

	/**
	 * Returns the file note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note, or <code>null</code> if a file note with the primary key could not be found
	 */
	public FileNote fetchByPrimaryKey(long fileNoteId);

	/**
	 * Returns all the file notes.
	 *
	 * @return the file notes
	 */
	public java.util.List<FileNote> findAll();

	/**
	 * Returns a range of all the file notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of file notes
	 */
	public java.util.List<FileNote> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the file notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file notes
	 */
	public java.util.List<FileNote> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator);

	/**
	 * Returns an ordered range of all the file notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file notes
	 */
	public java.util.List<FileNote> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileNote>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the file notes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of file notes.
	 *
	 * @return the number of file notes
	 */
	public int countAll();

}