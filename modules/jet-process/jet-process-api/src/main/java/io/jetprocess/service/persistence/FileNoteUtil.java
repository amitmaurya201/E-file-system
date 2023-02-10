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

import io.jetprocess.model.FileNote;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the file note service. This utility wraps <code>io.jetprocess.service.persistence.impl.FileNotePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileNotePersistence
 * @generated
 */
public class FileNoteUtil {

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
	public static void clearCache(FileNote fileNote) {
		getPersistence().clearCache(fileNote);
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
	public static Map<Serializable, FileNote> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FileNote> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FileNote> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FileNote> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FileNote> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FileNote update(FileNote fileNote) {
		return getPersistence().update(fileNote);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FileNote update(
		FileNote fileNote, ServiceContext serviceContext) {

		return getPersistence().update(fileNote, serviceContext);
	}

	/**
	 * Returns all the file notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file notes
	 */
	public static List<FileNote> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<FileNote> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<FileNote> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileNote> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<FileNote> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileNote> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public static FileNote findByUuid_First(
			String uuid, OrderByComparator<FileNote> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByUuid_First(
		String uuid, OrderByComparator<FileNote> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public static FileNote findByUuid_Last(
			String uuid, OrderByComparator<FileNote> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByUuid_Last(
		String uuid, OrderByComparator<FileNote> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the file notes before and after the current file note in the ordered set where uuid = &#63;.
	 *
	 * @param fileNoteId the primary key of the current file note
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	public static FileNote[] findByUuid_PrevAndNext(
			long fileNoteId, String uuid,
			OrderByComparator<FileNote> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByUuid_PrevAndNext(
			fileNoteId, uuid, orderByComparator);
	}

	/**
	 * Removes all the file notes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of file notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file notes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public static FileNote findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the file note where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file note that was removed
	 */
	public static FileNote removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of file notes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file notes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file notes
	 */
	public static List<FileNote> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileNote> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileNote> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public static FileNote findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileNote> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileNote> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public static FileNote findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileNote> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileNote> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static FileNote[] findByUuid_C_PrevAndNext(
			long fileNoteId, String uuid, long companyId,
			OrderByComparator<FileNote> orderByComparator)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fileNoteId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the file notes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file notes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the file note where noteId = &#63; or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param noteId the note ID
	 * @return the matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public static FileNote findByNoteId(long noteId)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByNoteId(noteId);
	}

	/**
	 * Returns the file note where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param noteId the note ID
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByNoteId(long noteId) {
		return getPersistence().fetchByNoteId(noteId);
	}

	/**
	 * Returns the file note where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param noteId the note ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByNoteId(long noteId, boolean useFinderCache) {
		return getPersistence().fetchByNoteId(noteId, useFinderCache);
	}

	/**
	 * Removes the file note where noteId = &#63; from the database.
	 *
	 * @param noteId the note ID
	 * @return the file note that was removed
	 */
	public static FileNote removeByNoteId(long noteId)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().removeByNoteId(noteId);
	}

	/**
	 * Returns the number of file notes where noteId = &#63;.
	 *
	 * @param noteId the note ID
	 * @return the number of matching file notes
	 */
	public static int countByNoteId(long noteId) {
		return getPersistence().countByNoteId(noteId);
	}

	/**
	 * Returns the file note where fileMovementId = &#63; or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param fileMovementId the file movement ID
	 * @return the matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	public static FileNote findByfilemovementId(long fileMovementId)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByfilemovementId(fileMovementId);
	}

	/**
	 * Returns the file note where fileMovementId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileMovementId the file movement ID
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByfilemovementId(long fileMovementId) {
		return getPersistence().fetchByfilemovementId(fileMovementId);
	}

	/**
	 * Returns the file note where fileMovementId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileMovementId the file movement ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	public static FileNote fetchByfilemovementId(
		long fileMovementId, boolean useFinderCache) {

		return getPersistence().fetchByfilemovementId(
			fileMovementId, useFinderCache);
	}

	/**
	 * Removes the file note where fileMovementId = &#63; from the database.
	 *
	 * @param fileMovementId the file movement ID
	 * @return the file note that was removed
	 */
	public static FileNote removeByfilemovementId(long fileMovementId)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().removeByfilemovementId(fileMovementId);
	}

	/**
	 * Returns the number of file notes where fileMovementId = &#63;.
	 *
	 * @param fileMovementId the file movement ID
	 * @return the number of matching file notes
	 */
	public static int countByfilemovementId(long fileMovementId) {
		return getPersistence().countByfilemovementId(fileMovementId);
	}

	/**
	 * Caches the file note in the entity cache if it is enabled.
	 *
	 * @param fileNote the file note
	 */
	public static void cacheResult(FileNote fileNote) {
		getPersistence().cacheResult(fileNote);
	}

	/**
	 * Caches the file notes in the entity cache if it is enabled.
	 *
	 * @param fileNotes the file notes
	 */
	public static void cacheResult(List<FileNote> fileNotes) {
		getPersistence().cacheResult(fileNotes);
	}

	/**
	 * Creates a new file note with the primary key. Does not add the file note to the database.
	 *
	 * @param fileNoteId the primary key for the new file note
	 * @return the new file note
	 */
	public static FileNote create(long fileNoteId) {
		return getPersistence().create(fileNoteId);
	}

	/**
	 * Removes the file note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note that was removed
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	public static FileNote remove(long fileNoteId)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().remove(fileNoteId);
	}

	public static FileNote updateImpl(FileNote fileNote) {
		return getPersistence().updateImpl(fileNote);
	}

	/**
	 * Returns the file note with the primary key or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	public static FileNote findByPrimaryKey(long fileNoteId)
		throws io.jetprocess.exception.NoSuchFileNoteException {

		return getPersistence().findByPrimaryKey(fileNoteId);
	}

	/**
	 * Returns the file note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note, or <code>null</code> if a file note with the primary key could not be found
	 */
	public static FileNote fetchByPrimaryKey(long fileNoteId) {
		return getPersistence().fetchByPrimaryKey(fileNoteId);
	}

	/**
	 * Returns all the file notes.
	 *
	 * @return the file notes
	 */
	public static List<FileNote> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<FileNote> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<FileNote> findAll(
		int start, int end, OrderByComparator<FileNote> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<FileNote> findAll(
		int start, int end, OrderByComparator<FileNote> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the file notes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of file notes.
	 *
	 * @return the number of file notes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FileNotePersistence getPersistence() {
		return _persistence;
	}

	private static volatile FileNotePersistence _persistence;

}