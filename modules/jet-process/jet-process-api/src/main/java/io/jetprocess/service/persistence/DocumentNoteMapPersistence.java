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

import io.jetprocess.exception.NoSuchDocumentNoteMapException;
import io.jetprocess.model.DocumentNoteMap;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the document note map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentNoteMapUtil
 * @generated
 */
@ProviderType
public interface DocumentNoteMapPersistence
	extends BasePersistence<DocumentNoteMap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentNoteMapUtil} to access the document note map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the document note maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document note maps
	 */
	public java.util.List<DocumentNoteMap> findByUuid(String uuid);

	/**
	 * Returns a range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of matching document note maps
	 */
	public java.util.List<DocumentNoteMap> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document note maps
	 */
	public java.util.List<DocumentNoteMap> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document note maps
	 */
	public java.util.List<DocumentNoteMap> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public DocumentNoteMap findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
				orderByComparator)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public DocumentNoteMap fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator);

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public DocumentNoteMap findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
				orderByComparator)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public DocumentNoteMap fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator);

	/**
	 * Returns the document note maps before and after the current document note map in the ordered set where uuid = &#63;.
	 *
	 * @param documentNoteMapId the primary key of the current document note map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	public DocumentNoteMap[] findByUuid_PrevAndNext(
			long documentNoteMapId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
				orderByComparator)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Removes all the document note maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of document note maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document note maps
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocumentNoteMapException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public DocumentNoteMap findByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public DocumentNoteMap fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public DocumentNoteMap fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the document note map where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the document note map that was removed
	 */
	public DocumentNoteMap removeByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Returns the number of document note maps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching document note maps
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching document note maps
	 */
	public java.util.List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of matching document note maps
	 */
	public java.util.List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document note maps
	 */
	public java.util.List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document note maps
	 */
	public java.util.List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public DocumentNoteMap findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
				orderByComparator)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public DocumentNoteMap fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator);

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	public DocumentNoteMap findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
				orderByComparator)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public DocumentNoteMap fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator);

	/**
	 * Returns the document note maps before and after the current document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param documentNoteMapId the primary key of the current document note map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	public DocumentNoteMap[] findByUuid_C_PrevAndNext(
			long documentNoteMapId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
				orderByComparator)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Removes all the document note maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching document note maps
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the document note map in the entity cache if it is enabled.
	 *
	 * @param documentNoteMap the document note map
	 */
	public void cacheResult(DocumentNoteMap documentNoteMap);

	/**
	 * Caches the document note maps in the entity cache if it is enabled.
	 *
	 * @param documentNoteMaps the document note maps
	 */
	public void cacheResult(java.util.List<DocumentNoteMap> documentNoteMaps);

	/**
	 * Creates a new document note map with the primary key. Does not add the document note map to the database.
	 *
	 * @param documentNoteMapId the primary key for the new document note map
	 * @return the new document note map
	 */
	public DocumentNoteMap create(long documentNoteMapId);

	/**
	 * Removes the document note map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map that was removed
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	public DocumentNoteMap remove(long documentNoteMapId)
		throws NoSuchDocumentNoteMapException;

	public DocumentNoteMap updateImpl(DocumentNoteMap documentNoteMap);

	/**
	 * Returns the document note map with the primary key or throws a <code>NoSuchDocumentNoteMapException</code> if it could not be found.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	public DocumentNoteMap findByPrimaryKey(long documentNoteMapId)
		throws NoSuchDocumentNoteMapException;

	/**
	 * Returns the document note map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map, or <code>null</code> if a document note map with the primary key could not be found
	 */
	public DocumentNoteMap fetchByPrimaryKey(long documentNoteMapId);

	/**
	 * Returns all the document note maps.
	 *
	 * @return the document note maps
	 */
	public java.util.List<DocumentNoteMap> findAll();

	/**
	 * Returns a range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of document note maps
	 */
	public java.util.List<DocumentNoteMap> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document note maps
	 */
	public java.util.List<DocumentNoteMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document note maps
	 */
	public java.util.List<DocumentNoteMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentNoteMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the document note maps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of document note maps.
	 *
	 * @return the number of document note maps
	 */
	public int countAll();

}