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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactDetailLocalService
 * @generated
 */
public class ContactDetailLocalServiceWrapper
	implements ContactDetailLocalService,
			   ServiceWrapper<ContactDetailLocalService> {

	public ContactDetailLocalServiceWrapper() {
		this(null);
	}

	public ContactDetailLocalServiceWrapper(
		ContactDetailLocalService contactDetailLocalService) {

		_contactDetailLocalService = contactDetailLocalService;
	}

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
	@Override
	public io.jetprocess.model.ContactDetail addContactDetail(
		io.jetprocess.model.ContactDetail contactDetail) {

		return _contactDetailLocalService.addContactDetail(contactDetail);
	}

	@Override
	public io.jetprocess.model.ContactDetail addContactDetails(
			long groupId, String minDeptOth, String name, String designation,
			String mobile, String email, String address, String country,
			String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailLocalService.addContactDetails(
			groupId, minDeptOth, name, designation, mobile, email, address,
			country, state, district, pinCode, serviceContext);
	}

	/**
	 * Creates a new contact detail with the primary key. Does not add the contact detail to the database.
	 *
	 * @param contactDetailId the primary key for the new contact detail
	 * @return the new contact detail
	 */
	@Override
	public io.jetprocess.model.ContactDetail createContactDetail(
		long contactDetailId) {

		return _contactDetailLocalService.createContactDetail(contactDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.ContactDetail deleteContactDetail(
		io.jetprocess.model.ContactDetail contactDetail) {

		return _contactDetailLocalService.deleteContactDetail(contactDetail);
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
	@Override
	public io.jetprocess.model.ContactDetail deleteContactDetail(
			long contactDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailLocalService.deleteContactDetail(contactDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _contactDetailLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _contactDetailLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactDetailLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _contactDetailLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _contactDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _contactDetailLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _contactDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _contactDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.ContactDetail fetchContactDetail(
		long contactDetailId) {

		return _contactDetailLocalService.fetchContactDetail(contactDetailId);
	}

	/**
	 * Returns the contact detail matching the UUID and group.
	 *
	 * @param uuid the contact detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public io.jetprocess.model.ContactDetail fetchContactDetailByUuidAndGroupId(
		String uuid, long groupId) {

		return _contactDetailLocalService.fetchContactDetailByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _contactDetailLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the contact detail with the primary key.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail
	 * @throws PortalException if a contact detail with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.ContactDetail getContactDetail(
			long contactDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailLocalService.getContactDetail(contactDetailId);
	}

	@Override
	public java.util.List<io.jetprocess.model.ContactDetail>
		getContactDetailByGroupId(long groupId, int start, int end) {

		return _contactDetailLocalService.getContactDetailByGroupId(
			groupId, start, end);
	}

	/**
	 * Returns the contact detail matching the UUID and group.
	 *
	 * @param uuid the contact detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact detail
	 * @throws PortalException if a matching contact detail could not be found
	 */
	@Override
	public io.jetprocess.model.ContactDetail getContactDetailByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailLocalService.getContactDetailByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<io.jetprocess.model.ContactDetail> getContactDetails(
		int start, int end) {

		return _contactDetailLocalService.getContactDetails(start, end);
	}

	/**
	 * Returns all the contact details matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact details
	 * @param companyId the primary key of the company
	 * @return the matching contact details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.ContactDetail>
		getContactDetailsByUuidAndCompanyId(String uuid, long companyId) {

		return _contactDetailLocalService.getContactDetailsByUuidAndCompanyId(
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
	@Override
	public java.util.List<io.jetprocess.model.ContactDetail>
		getContactDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.ContactDetail> orderByComparator) {

		return _contactDetailLocalService.getContactDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of contact details.
	 *
	 * @return the number of contact details
	 */
	@Override
	public int getContactDetailsCount() {
		return _contactDetailLocalService.getContactDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _contactDetailLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _contactDetailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.ContactDetail updateContactDetail(
		io.jetprocess.model.ContactDetail contactDetail) {

		return _contactDetailLocalService.updateContactDetail(contactDetail);
	}

	@Override
	public io.jetprocess.model.ContactDetail updateContactDetail(
			long contactDetailId, String minDeptOth, String name,
			String designation, String mobile, String email, String address,
			String country, String state, String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactDetailLocalService.updateContactDetail(
			contactDetailId, minDeptOth, name, designation, mobile, email,
			address, country, state, district, pinCode, serviceContext);
	}

	@Override
	public ContactDetailLocalService getWrappedService() {
		return _contactDetailLocalService;
	}

	@Override
	public void setWrappedService(
		ContactDetailLocalService contactDetailLocalService) {

		_contactDetailLocalService = contactDetailLocalService;
	}

	private ContactDetailLocalService _contactDetailLocalService;

}