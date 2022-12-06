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

package io.jetprocess.masterdata.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MasterdataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MasterdataLocalService
 * @generated
 */
public class MasterdataLocalServiceWrapper
	implements MasterdataLocalService, ServiceWrapper<MasterdataLocalService> {

	public MasterdataLocalServiceWrapper() {
		this(null);
	}

	public MasterdataLocalServiceWrapper(
		MasterdataLocalService masterdataLocalService) {

		_masterdataLocalService = masterdataLocalService;
	}

	/**
	 * Adds the masterdata to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdata the masterdata
	 * @return the masterdata that was added
	 */
	@Override
	public io.jetprocess.masterdata.model.Masterdata addMasterdata(
		io.jetprocess.masterdata.model.Masterdata masterdata) {

		return _masterdataLocalService.addMasterdata(masterdata);
	}

	/**
	 * Creates a new masterdata with the primary key. Does not add the masterdata to the database.
	 *
	 * @param masterdataId the primary key for the new masterdata
	 * @return the new masterdata
	 */
	@Override
	public io.jetprocess.masterdata.model.Masterdata createMasterdata(
		String masterdataId) {

		return _masterdataLocalService.createMasterdata(masterdataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterdataLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the masterdata from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdata the masterdata
	 * @return the masterdata that was removed
	 */
	@Override
	public io.jetprocess.masterdata.model.Masterdata deleteMasterdata(
		io.jetprocess.masterdata.model.Masterdata masterdata) {

		return _masterdataLocalService.deleteMasterdata(masterdata);
	}

	/**
	 * Deletes the masterdata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata that was removed
	 * @throws PortalException if a masterdata with the primary key could not be found
	 */
	@Override
	public io.jetprocess.masterdata.model.Masterdata deleteMasterdata(
			String masterdataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterdataLocalService.deleteMasterdata(masterdataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterdataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _masterdataLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _masterdataLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterdataLocalService.dynamicQuery();
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

		return _masterdataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.MasterdataModelImpl</code>.
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

		return _masterdataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.MasterdataModelImpl</code>.
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

		return _masterdataLocalService.dynamicQuery(
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

		return _masterdataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterdataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata fetchMasterdata(
		String masterdataId) {

		return _masterdataLocalService.fetchMasterdata(masterdataId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getBasic(
		long basicHeadId) {

		return _masterdataLocalService.getBasic(basicHeadId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getBasicHead() {

		return _masterdataLocalService.getBasicHead();
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCategory() {

		return _masterdataLocalService.getCategory();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getCategoryById(
		long categoryId) {

		return _masterdataLocalService.getCategoryById(categoryId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCountry() {

		return _masterdataLocalService.getCountry();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getCountryById(
		long countryId) {

		return _masterdataLocalService.getCountryById(countryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getDeliveryModeById(
		long deliveryModeId) {

		return _masterdataLocalService.getDeliveryModeById(deliveryModeId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getDeliveryModes() {

		return _masterdataLocalService.getDeliveryModes();
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata> getFile() {
		return _masterdataLocalService.getFile();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getFileById(
		long fileCodeId) {

		return _masterdataLocalService.getFileById(fileCodeId);
	}

	@Override
	public int getFileCreatedByKeywordCount(
		long userPostId, String keyword, int start, int end, String orderBy,
		String order) {

		return _masterdataLocalService.getFileCreatedByKeywordCount(
			userPostId, keyword, start, end, orderBy, order);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedByKeywords(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order) {

		return _masterdataLocalService.getFileCreatedByKeywords(
			userPostId, keyword, start, end, orderBy, order);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListSearchedData(long userPostId, String data) {

		return _masterdataLocalService.getFileCreatedListSearchedData(
			userPostId, data);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListSearchedData1(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order) {

		return _masterdataLocalService.getFileCreatedListSearchedData1(
			userPostId, keyword, start, end, orderBy, order);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileList(long userPostId) {

		return _masterdataLocalService.getFileList(userPostId);
	}

	@Override
	public int getFileListCount(long userPostId) {
		return _masterdataLocalService.getFileListCount(userPostId);
	}

	/**
	 * Returns the masterdata with the primary key.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata
	 * @throws PortalException if a masterdata with the primary key could not be found
	 */
	@Override
	public io.jetprocess.masterdata.model.Masterdata getMasterdata(
			String masterdataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterdataLocalService.getMasterdata(masterdataId);
	}

	/**
	 * Returns a range of all the masterdatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.MasterdataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of masterdatas
	 * @param end the upper bound of the range of masterdatas (not inclusive)
	 * @return the range of masterdatas
	 */
	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getMasterdatas(int start, int end) {

		return _masterdataLocalService.getMasterdatas(start, end);
	}

	/**
	 * Returns the number of masterdatas.
	 *
	 * @return the number of masterdatas
	 */
	@Override
	public int getMasterdatasCount() {
		return _masterdataLocalService.getMasterdatasCount();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getOrganizationById(
		long organizationId) {

		return _masterdataLocalService.getOrganizationById(organizationId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getOrgranizations() {

		return _masterdataLocalService.getOrgranizations();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterdataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterdataLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getPrimary(
		long primaryHeadId) {

		return _masterdataLocalService.getPrimary(primaryHeadId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getPrimaryHead(long basicHeadId) {

		return _masterdataLocalService.getPrimaryHead(basicHeadId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptCategory() {

		return _masterdataLocalService.getReceiptCategory();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getReceiptCategoryById(
		long receiptCategoryId) {

		return _masterdataLocalService.getReceiptCategoryById(
			receiptCategoryId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptCreatedListSearchedData(long userPostId, String data) {

		return _masterdataLocalService.getReceiptCreatedListSearchedData(
			userPostId, data);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptList(long userPostId) {

		return _masterdataLocalService.getReceiptList(userPostId);
	}

	@Override
	public int getReceiptListCount(long userPostId) {
		return _masterdataLocalService.getReceiptListCount(userPostId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptSubCategory(long receiptCategoryId) {

		return _masterdataLocalService.getReceiptSubCategory(receiptCategoryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getReceiptSubCategoryById(
		long receiptSubCategoryId) {

		return _masterdataLocalService.getReceiptSubCategoryById(
			receiptSubCategoryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getSecondary(
		long secondaryHeadId) {

		return _masterdataLocalService.getSecondary(secondaryHeadId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSecondaryHead(long primaryHeadId) {

		return _masterdataLocalService.getSecondaryHead(primaryHeadId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getStateById(
		long stateId) {

		return _masterdataLocalService.getStateById(stateId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata> getStates(
		long countryId) {

		return _masterdataLocalService.getStates(countryId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubcategories(long categoryId) {

		return _masterdataLocalService.getSubcategories(categoryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getSubCategoryById(
		long subCategoryId) {

		return _masterdataLocalService.getSubCategoryById(subCategoryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getSubOrganizationById(
		long subOrganizationId) {

		return _masterdataLocalService.getSubOrganizationById(
			subOrganizationId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubOrgranizations(long organizationId) {

		return _masterdataLocalService.getSubOrgranizations(organizationId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTeritaryHead(long seondaryHeadId) {

		return _masterdataLocalService.getTeritaryHead(seondaryHeadId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getTertiary(
		long tertiaryHeadId) {

		return _masterdataLocalService.getTertiary(tertiaryHeadId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getTypeById(long typeId) {
		return _masterdataLocalService.getTypeById(typeId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTypes() {

		return _masterdataLocalService.getTypes();
	}

	/**
	 * Updates the masterdata in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdata the masterdata
	 * @return the masterdata that was updated
	 */
	@Override
	public io.jetprocess.masterdata.model.Masterdata updateMasterdata(
		io.jetprocess.masterdata.model.Masterdata masterdata) {

		return _masterdataLocalService.updateMasterdata(masterdata);
	}

	@Override
	public MasterdataLocalService getWrappedService() {
		return _masterdataLocalService;
	}

	@Override
	public void setWrappedService(
		MasterdataLocalService masterdataLocalService) {

		_masterdataLocalService = masterdataLocalService;
	}

	private MasterdataLocalService _masterdataLocalService;

}