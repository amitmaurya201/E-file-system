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

import io.jetprocess.exception.NoSuchNoteException;
import io.jetprocess.model.Note;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteUtil
 * @generated
 */
@ProviderType
public interface NotePersistence extends BasePersistence<Note> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NoteUtil} to access the note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notes
	 */
	public java.util.List<Note> findByUuid(String uuid);

	/**
	 * Returns a range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	public java.util.List<Note> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	public java.util.List<Note> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator);

	/**
	 * Returns an ordered range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	public java.util.List<Note> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public Note findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Note>
				orderByComparator)
		throws NoSuchNoteException;

	/**
	 * Returns the first note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public Note fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator);

	/**
	 * Returns the last note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public Note findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Note>
				orderByComparator)
		throws NoSuchNoteException;

	/**
	 * Returns the last note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public Note fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator);

	/**
	 * Returns the notes before and after the current note in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public Note[] findByUuid_PrevAndNext(
			long noteId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Note>
				orderByComparator)
		throws NoSuchNoteException;

	/**
	 * Removes all the notes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public Note findByUUID_G(String uuid, long groupId)
		throws NoSuchNoteException;

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public Note fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public Note fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the note where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the note that was removed
	 */
	public Note removeByUUID_G(String uuid, long groupId)
		throws NoSuchNoteException;

	/**
	 * Returns the number of notes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notes
	 */
	public java.util.List<Note> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	public java.util.List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	public java.util.List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator);

	/**
	 * Returns an ordered range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	public java.util.List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public Note findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Note>
				orderByComparator)
		throws NoSuchNoteException;

	/**
	 * Returns the first note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public Note fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator);

	/**
	 * Returns the last note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public Note findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Note>
				orderByComparator)
		throws NoSuchNoteException;

	/**
	 * Returns the last note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public Note fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator);

	/**
	 * Returns the notes before and after the current note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public Note[] findByUuid_C_PrevAndNext(
			long noteId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Note>
				orderByComparator)
		throws NoSuchNoteException;

	/**
	 * Removes all the notes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the note where createdBy = &#63; or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param createdBy the created by
	 * @return the matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public Note findByuserPostId(long createdBy) throws NoSuchNoteException;

	/**
	 * Returns the note where createdBy = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param createdBy the created by
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public Note fetchByuserPostId(long createdBy);

	/**
	 * Returns the note where createdBy = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param createdBy the created by
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public Note fetchByuserPostId(long createdBy, boolean useFinderCache);

	/**
	 * Removes the note where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @return the note that was removed
	 */
	public Note removeByuserPostId(long createdBy) throws NoSuchNoteException;

	/**
	 * Returns the number of notes where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching notes
	 */
	public int countByuserPostId(long createdBy);

	/**
	 * Caches the note in the entity cache if it is enabled.
	 *
	 * @param note the note
	 */
	public void cacheResult(Note note);

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	public void cacheResult(java.util.List<Note> notes);

	/**
	 * Creates a new note with the primary key. Does not add the note to the database.
	 *
	 * @param noteId the primary key for the new note
	 * @return the new note
	 */
	public Note create(long noteId);

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the note
	 * @return the note that was removed
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public Note remove(long noteId) throws NoSuchNoteException;

	public Note updateImpl(Note note);

	/**
	 * Returns the note with the primary key or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public Note findByPrimaryKey(long noteId) throws NoSuchNoteException;

	/**
	 * Returns the note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note, or <code>null</code> if a note with the primary key could not be found
	 */
	public Note fetchByPrimaryKey(long noteId);

	/**
	 * Returns all the notes.
	 *
	 * @return the notes
	 */
	public java.util.List<Note> findAll();

	/**
	 * Returns a range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of notes
	 */
	public java.util.List<Note> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notes
	 */
	public java.util.List<Note> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator);

	/**
	 * Returns an ordered range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notes
	 */
	public java.util.List<Note> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Note>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the notes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of notes.
	 *
	 * @return the number of notes
	 */
	public int countAll();

}