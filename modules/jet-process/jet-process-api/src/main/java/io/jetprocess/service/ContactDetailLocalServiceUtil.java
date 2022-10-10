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

package io.jetprocess.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import io.jetprocess.model.ContactDetail;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ContactDetail. This utility wraps
 * <code>io.jetprocess.service.impl.ContactDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDetailLocalService
 * @generated
 */
public class ContactDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.ContactDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the contact detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactDetail the contact detail
	 * @return the contact detail that was added
	 */
	public static ContactDetail addContactDetail(ContactDetail contactDetail) {
		return getService().addContactDetail(contactDetail);
	}

	public static ContactDetail addContactDetails(
			long groupId, String minDeptOth, String name, String designation,
			String mobile, String email, String address, String country,
			String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addContactDetails(
			groupId, minDeptOth, name, designation, mobile, email, address,
			country, state, district, pinCode, serviceContext);
	}

	/**
	 * Creates a new contact detail with the primary key. Does not add the contact detail to the database.
	 *
	 * @param contactDetailId the primary key for the new contact detail
	 * @return the new contact detail
	 */
	public static ContactDetail createContactDetail(long contactDetailId) {
		return getService().createContactDetail(contactDetailId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the contact detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactDetail the contact detail
	 * @return the contact detail that was removed
	 */
	public static ContactDetail deleteContactDetail(
		ContactDetail contactDetail) {

		return getService().deleteContactDetail(contactDetail);
	}

	/**
	 * Deletes the contact detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail that was removed
	 * @throws PortalException if a contact detail with the primary key could not be found
	 */
	public static ContactDetail deleteContactDetail(long contactDetailId)
		throws PortalException {

		return getService().deleteContactDetail(contactDetailId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ContactDetail fetchContactDetail(long contactDetailId) {
		return getService().fetchContactDetail(contactDetailId);
	}

	/**
	 * Returns the contact detail matching the UUID and group.
	 *
	 * @param uuid the contact detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	public static ContactDetail fetchContactDetailByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchContactDetailByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the contact detail with the primary key.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail
	 * @throws PortalException if a contact detail with the primary key could not be found
	 */
	public static ContactDetail getContactDetail(long contactDetailId)
		throws PortalException {

		return getService().getContactDetail(contactDetailId);
	}

	public static List<ContactDetail> getContactDetailByGroupId(
		long groupId, int start, int end) {

		return getService().getContactDetailByGroupId(groupId, start, end);
	}

	/**
	 * Returns the contact detail matching the UUID and group.
	 *
	 * @param uuid the contact detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact detail
	 * @throws PortalException if a matching contact detail could not be found
	 */
	public static ContactDetail getContactDetailByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getContactDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the contact details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of contact details
	 */
	public static List<ContactDetail> getContactDetails(int start, int end) {
		return getService().getContactDetails(start, end);
	}

	/**
	 * Returns all the contact details matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact details
	 * @param companyId the primary key of the company
	 * @return the matching contact details, or an empty list if no matches were found
	 */
	public static List<ContactDetail> getContactDetailsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getContactDetailsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of contact details matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact details
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching contact details, or an empty list if no matches were found
	 */
	public static List<ContactDetail> getContactDetailsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return getService().getContactDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of contact details.
	 *
	 * @return the number of contact details
	 */
	public static int getContactDetailsCount() {
		return getService().getContactDetailsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the contact detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactDetail the contact detail
	 * @return the contact detail that was updated
	 */
	public static ContactDetail updateContactDetail(
		ContactDetail contactDetail) {

		return getService().updateContactDetail(contactDetail);
	}

	public static ContactDetail updateContactDetail(
			long contactDetailId, String minDeptOth, String name,
			String designation, String mobile, String email, String address,
			String country, String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateContactDetail(
			contactDetailId, minDeptOth, name, designation, mobile, email,
			address, country, state, district, pinCode, serviceContext);
	}

	public static ContactDetailLocalService getService() {
		return _service;
	}

	private static volatile ContactDetailLocalService _service;

}