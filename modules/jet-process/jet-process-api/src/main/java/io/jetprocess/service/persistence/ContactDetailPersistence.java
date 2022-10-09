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

import io.jetprocess.exception.NoSuchContactDetailException;
import io.jetprocess.model.ContactDetail;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the contact detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDetailUtil
 * @generated
 */
@ProviderType
public interface ContactDetailPersistence
	extends BasePersistence<ContactDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactDetailUtil} to access the contact detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the contact details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contact details
	 */
	public java.util.List<ContactDetail> findByUuid(String uuid);

	/**
	 * Returns a range of all the contact details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of matching contact details
	 */
	public java.util.List<ContactDetail> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the contact details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact details
	 */
	public java.util.List<ContactDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contact details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact details
	 */
	public java.util.List<ContactDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public ContactDetail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public ContactDetail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns the contact details before and after the current contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param contactDetailId the primary key of the current contact detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public ContactDetail[] findByUuid_PrevAndNext(
			long contactDetailId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Removes all the contact details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of contact details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contact details
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public ContactDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchContactDetailException;

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the contact detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the contact detail that was removed
	 */
	public ContactDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchContactDetailException;

	/**
	 * Returns the number of contact details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching contact details
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching contact details
	 */
	public java.util.List<ContactDetail> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of matching contact details
	 */
	public java.util.List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact details
	 */
	public java.util.List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact details
	 */
	public java.util.List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public ContactDetail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public ContactDetail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns the contact details before and after the current contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param contactDetailId the primary key of the current contact detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public ContactDetail[] findByUuid_C_PrevAndNext(
			long contactDetailId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Removes all the contact details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching contact details
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the contact detail where contactDetailId = &#63; or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public ContactDetail findByContactDetailId(long contactDetailId)
		throws NoSuchContactDetailException;

	/**
	 * Returns the contact detail where contactDetailId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByContactDetailId(long contactDetailId);

	/**
	 * Returns the contact detail where contactDetailId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactDetailId the contact detail ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByContactDetailId(
		long contactDetailId, boolean useFinderCache);

	/**
	 * Removes the contact detail where contactDetailId = &#63; from the database.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the contact detail that was removed
	 */
	public ContactDetail removeByContactDetailId(long contactDetailId)
		throws NoSuchContactDetailException;

	/**
	 * Returns the number of contact details where contactDetailId = &#63;.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the number of matching contact details
	 */
	public int countByContactDetailId(long contactDetailId);

	/**
	 * Returns all the contact details where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contact details
	 */
	public java.util.List<ContactDetail> findByGroupId(long groupId);

	/**
	 * Returns a range of all the contact details where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of matching contact details
	 */
	public java.util.List<ContactDetail> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the contact details where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact details
	 */
	public java.util.List<ContactDetail> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contact details where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact details
	 */
	public java.util.List<ContactDetail> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public ContactDetail findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Returns the first contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns the last contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public ContactDetail findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Returns the last contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public ContactDetail fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns the contact details before and after the current contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param contactDetailId the primary key of the current contact detail
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public ContactDetail[] findByGroupId_PrevAndNext(
			long contactDetailId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
				orderByComparator)
		throws NoSuchContactDetailException;

	/**
	 * Removes all the contact details where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of contact details where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contact details
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the contact detail in the entity cache if it is enabled.
	 *
	 * @param contactDetail the contact detail
	 */
	public void cacheResult(ContactDetail contactDetail);

	/**
	 * Caches the contact details in the entity cache if it is enabled.
	 *
	 * @param contactDetails the contact details
	 */
	public void cacheResult(java.util.List<ContactDetail> contactDetails);

	/**
	 * Creates a new contact detail with the primary key. Does not add the contact detail to the database.
	 *
	 * @param contactDetailId the primary key for the new contact detail
	 * @return the new contact detail
	 */
	public ContactDetail create(long contactDetailId);

	/**
	 * Removes the contact detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail that was removed
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public ContactDetail remove(long contactDetailId)
		throws NoSuchContactDetailException;

	public ContactDetail updateImpl(ContactDetail contactDetail);

	/**
	 * Returns the contact detail with the primary key or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public ContactDetail findByPrimaryKey(long contactDetailId)
		throws NoSuchContactDetailException;

	/**
	 * Returns the contact detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail, or <code>null</code> if a contact detail with the primary key could not be found
	 */
	public ContactDetail fetchByPrimaryKey(long contactDetailId);

	/**
	 * Returns all the contact details.
	 *
	 * @return the contact details
	 */
	public java.util.List<ContactDetail> findAll();

	/**
	 * Returns a range of all the contact details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of contact details
	 */
	public java.util.List<ContactDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the contact details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact details
	 */
	public java.util.List<ContactDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contact details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of contact details
	 */
	public java.util.List<ContactDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the contact details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of contact details.
	 *
	 * @return the number of contact details
	 */
	public int countAll();

}