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

import io.jetprocess.exception.NoSuchNoteDocMovementException;
import io.jetprocess.model.NoteDocMovement;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the note doc movement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocMovementUtil
 * @generated
 */
@ProviderType
public interface NoteDocMovementPersistence
	extends BasePersistence<NoteDocMovement> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NoteDocMovementUtil} to access the note doc movement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the note doc movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching note doc movements
	 */
	public java.util.List<NoteDocMovement> findByUuid(String uuid);

	/**
	 * Returns a range of all the note doc movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @return the range of matching note doc movements
	 */
	public java.util.List<NoteDocMovement> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the note doc movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching note doc movements
	 */
	public java.util.List<NoteDocMovement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the note doc movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching note doc movements
	 */
	public java.util.List<NoteDocMovement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	public NoteDocMovement findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
				orderByComparator)
		throws NoSuchNoteDocMovementException;

	/**
	 * Returns the first note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	public NoteDocMovement fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator);

	/**
	 * Returns the last note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	public NoteDocMovement findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
				orderByComparator)
		throws NoSuchNoteDocMovementException;

	/**
	 * Returns the last note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	public NoteDocMovement fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator);

	/**
	 * Returns the note doc movements before and after the current note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param movementId the primary key of the current note doc movement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note doc movement
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	public NoteDocMovement[] findByUuid_PrevAndNext(
			long movementId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
				orderByComparator)
		throws NoSuchNoteDocMovementException;

	/**
	 * Removes all the note doc movements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of note doc movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching note doc movements
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the note doc movement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNoteDocMovementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	public NoteDocMovement findByUUID_G(String uuid, long groupId)
		throws NoSuchNoteDocMovementException;

	/**
	 * Returns the note doc movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	public NoteDocMovement fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the note doc movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	public NoteDocMovement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the note doc movement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the note doc movement that was removed
	 */
	public NoteDocMovement removeByUUID_G(String uuid, long groupId)
		throws NoSuchNoteDocMovementException;

	/**
	 * Returns the number of note doc movements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching note doc movements
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching note doc movements
	 */
	public java.util.List<NoteDocMovement> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @return the range of matching note doc movements
	 */
	public java.util.List<NoteDocMovement> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching note doc movements
	 */
	public java.util.List<NoteDocMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching note doc movements
	 */
	public java.util.List<NoteDocMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	public NoteDocMovement findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
				orderByComparator)
		throws NoSuchNoteDocMovementException;

	/**
	 * Returns the first note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	public NoteDocMovement fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator);

	/**
	 * Returns the last note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	public NoteDocMovement findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
				orderByComparator)
		throws NoSuchNoteDocMovementException;

	/**
	 * Returns the last note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	public NoteDocMovement fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator);

	/**
	 * Returns the note doc movements before and after the current note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param movementId the primary key of the current note doc movement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note doc movement
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	public NoteDocMovement[] findByUuid_C_PrevAndNext(
			long movementId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
				orderByComparator)
		throws NoSuchNoteDocMovementException;

	/**
	 * Removes all the note doc movements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching note doc movements
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the note doc movement in the entity cache if it is enabled.
	 *
	 * @param noteDocMovement the note doc movement
	 */
	public void cacheResult(NoteDocMovement noteDocMovement);

	/**
	 * Caches the note doc movements in the entity cache if it is enabled.
	 *
	 * @param noteDocMovements the note doc movements
	 */
	public void cacheResult(java.util.List<NoteDocMovement> noteDocMovements);

	/**
	 * Creates a new note doc movement with the primary key. Does not add the note doc movement to the database.
	 *
	 * @param movementId the primary key for the new note doc movement
	 * @return the new note doc movement
	 */
	public NoteDocMovement create(long movementId);

	/**
	 * Removes the note doc movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement that was removed
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	public NoteDocMovement remove(long movementId)
		throws NoSuchNoteDocMovementException;

	public NoteDocMovement updateImpl(NoteDocMovement noteDocMovement);

	/**
	 * Returns the note doc movement with the primary key or throws a <code>NoSuchNoteDocMovementException</code> if it could not be found.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	public NoteDocMovement findByPrimaryKey(long movementId)
		throws NoSuchNoteDocMovementException;

	/**
	 * Returns the note doc movement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement, or <code>null</code> if a note doc movement with the primary key could not be found
	 */
	public NoteDocMovement fetchByPrimaryKey(long movementId);

	/**
	 * Returns all the note doc movements.
	 *
	 * @return the note doc movements
	 */
	public java.util.List<NoteDocMovement> findAll();

	/**
	 * Returns a range of all the note doc movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @return the range of note doc movements
	 */
	public java.util.List<NoteDocMovement> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the note doc movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of note doc movements
	 */
	public java.util.List<NoteDocMovement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the note doc movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of note doc movements
	 */
	public java.util.List<NoteDocMovement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NoteDocMovement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the note doc movements from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of note doc movements.
	 *
	 * @return the number of note doc movements
	 */
	public int countAll();

}