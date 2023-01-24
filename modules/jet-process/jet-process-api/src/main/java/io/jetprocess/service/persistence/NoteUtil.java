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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import io.jetprocess.model.Note;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the note service. This utility wraps <code>io.jetprocess.service.persistence.impl.NotePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotePersistence
 * @generated
 */
public class NoteUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Note note) {
		getPersistence().clearCache(note);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Note> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Note> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Note> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Note> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Note update(Note note) {
		return getPersistence().update(note);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Note update(Note note, ServiceContext serviceContext) {
		return getPersistence().update(note, serviceContext);
	}

	/**
	 * Returns all the notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notes
	 */
	public static List<Note> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Note> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Note> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Note> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUuid_First(
			String uuid, OrderByComparator<Note> orderByComparator)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUuid_First(
		String uuid, OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUuid_Last(
			String uuid, OrderByComparator<Note> orderByComparator)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUuid_Last(
		String uuid, OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note[] findByUuid_PrevAndNext(
			long noteId, String uuid, OrderByComparator<Note> orderByComparator)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByUuid_PrevAndNext(
			noteId, uuid, orderByComparator);
	}

	/**
	 * Removes all the notes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the note where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the note that was removed
	 */
	public static Note removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of notes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notes
	 */
	public static List<Note> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Note> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Note[] findByUuid_C_PrevAndNext(
			long noteId, String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByUuid_C_PrevAndNext(
			noteId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the notes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the note where createdBy = &#63; or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param createdBy the created by
	 * @return the matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	public static Note findByuserPostId(long createdBy)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByuserPostId(createdBy);
	}

	/**
	 * Returns the note where createdBy = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param createdBy the created by
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByuserPostId(long createdBy) {
		return getPersistence().fetchByuserPostId(createdBy);
	}

	/**
	 * Returns the note where createdBy = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param createdBy the created by
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	public static Note fetchByuserPostId(
		long createdBy, boolean useFinderCache) {

		return getPersistence().fetchByuserPostId(createdBy, useFinderCache);
	}

	/**
	 * Removes the note where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @return the note that was removed
	 */
	public static Note removeByuserPostId(long createdBy)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().removeByuserPostId(createdBy);
	}

	/**
	 * Returns the number of notes where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching notes
	 */
	public static int countByuserPostId(long createdBy) {
		return getPersistence().countByuserPostId(createdBy);
	}

	/**
	 * Caches the note in the entity cache if it is enabled.
	 *
	 * @param note the note
	 */
	public static void cacheResult(Note note) {
		getPersistence().cacheResult(note);
	}

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	public static void cacheResult(List<Note> notes) {
		getPersistence().cacheResult(notes);
	}

	/**
	 * Creates a new note with the primary key. Does not add the note to the database.
	 *
	 * @param noteId the primary key for the new note
	 * @return the new note
	 */
	public static Note create(long noteId) {
		return getPersistence().create(noteId);
	}

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the note
	 * @return the note that was removed
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note remove(long noteId)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().remove(noteId);
	}

	public static Note updateImpl(Note note) {
		return getPersistence().updateImpl(note);
	}

	/**
	 * Returns the note with the primary key or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	public static Note findByPrimaryKey(long noteId)
		throws io.jetprocess.exception.NoSuchNoteException {

		return getPersistence().findByPrimaryKey(noteId);
	}

	/**
	 * Returns the note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note, or <code>null</code> if a note with the primary key could not be found
	 */
	public static Note fetchByPrimaryKey(long noteId) {
		return getPersistence().fetchByPrimaryKey(noteId);
	}

	/**
	 * Returns all the notes.
	 *
	 * @return the notes
	 */
	public static List<Note> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Note> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Note> findAll(
		int start, int end, OrderByComparator<Note> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Note> findAll(
		int start, int end, OrderByComparator<Note> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the notes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of notes.
	 *
	 * @return the number of notes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NotePersistence getPersistence() {
		return _persistence;
	}

	private static volatile NotePersistence _persistence;

}