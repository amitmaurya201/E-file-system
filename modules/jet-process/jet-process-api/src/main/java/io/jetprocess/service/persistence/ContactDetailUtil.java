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

import io.jetprocess.model.ContactDetail;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the contact detail service. This utility wraps <code>io.jetprocess.service.persistence.impl.ContactDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDetailPersistence
 * @generated
 */
public class ContactDetailUtil {

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
	public static void clearCache(ContactDetail contactDetail) {
		getPersistence().clearCache(contactDetail);
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
	public static Map<Serializable, ContactDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ContactDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ContactDetail update(ContactDetail contactDetail) {
		return getPersistence().update(contactDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ContactDetail update(
		ContactDetail contactDetail, ServiceContext serviceContext) {

		return getPersistence().update(contactDetail, serviceContext);
	}

	/**
	 * Returns all the contact details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contact details
	 */
	public static List<ContactDetail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ContactDetail> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ContactDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ContactDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public static ContactDetail findByUuid_First(
			String uuid, OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByUuid_First(
		String uuid, OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public static ContactDetail findByUuid_Last(
			String uuid, OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByUuid_Last(
		String uuid, OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the contact details before and after the current contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param contactDetailId the primary key of the current contact detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public static ContactDetail[] findByUuid_PrevAndNext(
			long contactDetailId, String uuid,
			OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByUuid_PrevAndNext(
			contactDetailId, uuid, orderByComparator);
	}

	/**
	 * Removes all the contact details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of contact details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contact details
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public static ContactDetail findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the contact detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the contact detail that was removed
	 */
	public static ContactDetail removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of contact details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching contact details
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching contact details
	 */
	public static List<ContactDetail> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public static ContactDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public static ContactDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ContactDetail[] findByUuid_C_PrevAndNext(
			long contactDetailId, String uuid, long companyId,
			OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByUuid_C_PrevAndNext(
			contactDetailId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the contact details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching contact details
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the contact detail where contactDetailId = &#63; or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public static ContactDetail findByContactDetailId(long contactDetailId)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByContactDetailId(contactDetailId);
	}

	/**
	 * Returns the contact detail where contactDetailId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByContactDetailId(long contactDetailId) {
		return getPersistence().fetchByContactDetailId(contactDetailId);
	}

	/**
	 * Returns the contact detail where contactDetailId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactDetailId the contact detail ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByContactDetailId(
		long contactDetailId, boolean useFinderCache) {

		return getPersistence().fetchByContactDetailId(
			contactDetailId, useFinderCache);
	}

	/**
	 * Removes the contact detail where contactDetailId = &#63; from the database.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the contact detail that was removed
	 */
	public static ContactDetail removeByContactDetailId(long contactDetailId)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().removeByContactDetailId(contactDetailId);
	}

	/**
	 * Returns the number of contact details where contactDetailId = &#63;.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the number of matching contact details
	 */
	public static int countByContactDetailId(long contactDetailId) {
		return getPersistence().countByContactDetailId(contactDetailId);
	}

	/**
	 * Returns all the contact details where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contact details
	 */
	public static List<ContactDetail> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<ContactDetail> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<ContactDetail> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<ContactDetail> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public static ContactDetail findByGroupId_First(
			long groupId, OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByGroupId_First(
		long groupId, OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	public static ContactDetail findByGroupId_Last(
			long groupId, OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchByGroupId_Last(
		long groupId, OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the contact details before and after the current contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param contactDetailId the primary key of the current contact detail
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public static ContactDetail[] findByGroupId_PrevAndNext(
			long contactDetailId, long groupId,
			OrderByComparator<ContactDetail> orderByComparator)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByGroupId_PrevAndNext(
			contactDetailId, groupId, orderByComparator);
	}

	/**
	 * Removes all the contact details where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of contact details where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contact details
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the contact detail in the entity cache if it is enabled.
	 *
	 * @param contactDetail the contact detail
	 */
	public static void cacheResult(ContactDetail contactDetail) {
		getPersistence().cacheResult(contactDetail);
	}

	/**
	 * Caches the contact details in the entity cache if it is enabled.
	 *
	 * @param contactDetails the contact details
	 */
	public static void cacheResult(List<ContactDetail> contactDetails) {
		getPersistence().cacheResult(contactDetails);
	}

	/**
	 * Creates a new contact detail with the primary key. Does not add the contact detail to the database.
	 *
	 * @param contactDetailId the primary key for the new contact detail
	 * @return the new contact detail
	 */
	public static ContactDetail create(long contactDetailId) {
		return getPersistence().create(contactDetailId);
	}

	/**
	 * Removes the contact detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail that was removed
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public static ContactDetail remove(long contactDetailId)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().remove(contactDetailId);
	}

	public static ContactDetail updateImpl(ContactDetail contactDetail) {
		return getPersistence().updateImpl(contactDetail);
	}

	/**
	 * Returns the contact detail with the primary key or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	public static ContactDetail findByPrimaryKey(long contactDetailId)
		throws io.jetprocess.exception.NoSuchContactDetailException {

		return getPersistence().findByPrimaryKey(contactDetailId);
	}

	/**
	 * Returns the contact detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail, or <code>null</code> if a contact detail with the primary key could not be found
	 */
	public static ContactDetail fetchByPrimaryKey(long contactDetailId) {
		return getPersistence().fetchByPrimaryKey(contactDetailId);
	}

	/**
	 * Returns all the contact details.
	 *
	 * @return the contact details
	 */
	public static List<ContactDetail> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ContactDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ContactDetail> findAll(
		int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ContactDetail> findAll(
		int start, int end, OrderByComparator<ContactDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the contact details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of contact details.
	 *
	 * @return the number of contact details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ContactDetailPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ContactDetailPersistence _persistence;

}