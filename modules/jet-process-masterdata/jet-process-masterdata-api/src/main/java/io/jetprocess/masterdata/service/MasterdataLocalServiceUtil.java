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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import io.jetprocess.masterdata.model.Masterdata;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Masterdata. This utility wraps
 * <code>io.jetprocess.masterdata.service.impl.MasterdataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MasterdataLocalService
 * @generated
 */
public class MasterdataLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.masterdata.service.impl.MasterdataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Masterdata addMasterdata(Masterdata masterdata) {
		return getService().addMasterdata(masterdata);
	}

	/**
	 * Creates a new masterdata with the primary key. Does not add the masterdata to the database.
	 *
	 * @param masterdataId the primary key for the new masterdata
	 * @return the new masterdata
	 */
	public static Masterdata createMasterdata(String masterdataId) {
		return getService().createMasterdata(masterdataId);
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
	 * Deletes the masterdata from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdata the masterdata
	 * @return the masterdata that was removed
	 */
	public static Masterdata deleteMasterdata(Masterdata masterdata) {
		return getService().deleteMasterdata(masterdata);
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
	public static Masterdata deleteMasterdata(String masterdataId)
		throws PortalException {

		return getService().deleteMasterdata(masterdataId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.MasterdataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.MasterdataModelImpl</code>.
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

	public static Masterdata fetchMasterdata(String masterdataId) {
		return getService().fetchMasterdata(masterdataId);
	}

	public static Masterdata getBasic(long basicHeadId) {
		return getService().getBasic(basicHeadId);
	}

	public static List<Masterdata> getBasicHead() {
		return getService().getBasicHead();
	}

	public static List<Masterdata> getCategory() {
		return getService().getCategory();
	}

	public static Masterdata getCategoryById(long categoryId) {
		return getService().getCategoryById(categoryId);
	}

	public static List<Masterdata> getCountry() {
		return getService().getCountry();
	}

	public static Masterdata getCountryById(long countryId) {
		return getService().getCountryById(countryId);
	}

	public static Masterdata getDeliveryModeById(long deliveryModeId) {
		return getService().getDeliveryModeById(deliveryModeId);
	}

	public static List<Masterdata> getDeliveryModes() {
		return getService().getDeliveryModes();
	}

	public static List<Masterdata> getFile() {
		return getService().getFile();
	}

	public static Masterdata getFileById(long fileCodeId) {
		return getService().getFileById(fileCodeId);
	}

	public static int getFileCreatedByKeywordCount(
		long userPostId, String keyword, int start, int end, String orderBy,
		String order) {

		return getService().getFileCreatedByKeywordCount(
			userPostId, keyword, start, end, orderBy, order);
	}

	public static List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedByKeywords(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order) {

		return getService().getFileCreatedByKeywords(
			userPostId, keyword, start, end, orderBy, order);
	}

	public static List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListSearchedData(long userPostId, String data) {

		return getService().getFileCreatedListSearchedData(userPostId, data);
	}

	public static List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListSearchedData1(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order) {

		return getService().getFileCreatedListSearchedData1(
			userPostId, keyword, start, end, orderBy, order);
	}

	public static List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileInboxList(long userPostId) {

		return getService().getFileInboxList(userPostId);
	}

	public static List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileList(long userPostId) {

		return getService().getFileList(userPostId);
	}

	public static int getFileListCount(long userPostId) {
		return getService().getFileListCount(userPostId);
	}

	public static List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileMovementListByFileId(long fileId) {

		return getService().getFileMovementListByFileId(fileId);
	}

	public static List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileSentListByUserPostId(long userPostId) {

		return getService().getFileSentListByUserPostId(userPostId);
	}

	/**
	 * Returns the masterdata with the primary key.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata
	 * @throws PortalException if a masterdata with the primary key could not be found
	 */
	public static Masterdata getMasterdata(String masterdataId)
		throws PortalException {

		return getService().getMasterdata(masterdataId);
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
	public static List<Masterdata> getMasterdatas(int start, int end) {
		return getService().getMasterdatas(start, end);
	}

	/**
	 * Returns the number of masterdatas.
	 *
	 * @return the number of masterdatas
	 */
	public static int getMasterdatasCount() {
		return getService().getMasterdatasCount();
	}

	public static Masterdata getOrganizationById(long organizationId) {
		return getService().getOrganizationById(organizationId);
	}

	public static List<Masterdata> getOrgranizations() {
		return getService().getOrgranizations();
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

	public static Masterdata getPrimary(long primaryHeadId) {
		return getService().getPrimary(primaryHeadId);
	}

	public static List<Masterdata> getPrimaryHead(long basicHeadId) {
		return getService().getPrimaryHead(basicHeadId);
	}

	public static List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptBySearchKeywords(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order) {

		return getService().getReceiptBySearchKeywords(
			userPostId, keyword, start, end, orderBy, order);
	}

	public static int getReceiptBySearchKeywordsCount(
		long userPostId, String keyword, int start, int end, String orderBy,
		String order) {

		return getService().getReceiptBySearchKeywordsCount(
			userPostId, keyword, start, end, orderBy, order);
	}

	public static List<Masterdata> getReceiptCategory() {
		return getService().getReceiptCategory();
	}

	public static Masterdata getReceiptCategoryById(long receiptCategoryId) {
		return getService().getReceiptCategoryById(receiptCategoryId);
	}

	public static List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptCreatedListSearchedData(long userPostId, String data) {

		return getService().getReceiptCreatedListSearchedData(userPostId, data);
	}

	public static List<io.jetprocess.masterdata.model.ReceiptMovementDTO>
		getReceiptInboxList(long userPostId) {

		return getService().getReceiptInboxList(userPostId);
	}

	public static List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptList(long userPostId) {

		return getService().getReceiptList(userPostId);
	}

	public static int getReceiptListCount(long userPostId) {
		return getService().getReceiptListCount(userPostId);
	}

	public static List<io.jetprocess.masterdata.model.ReceiptMovementDTO>
		getReceiptMovementListByReceiptId(long receiptId) {

		return getService().getReceiptMovementListByReceiptId(receiptId);
	}

	public static List<io.jetprocess.masterdata.model.ReceiptMovementDTO>
		getReceiptSentList(long userPostId) {

		return getService().getReceiptSentList(userPostId);
	}

	public static List<Masterdata> getReceiptSubCategory(
		long receiptCategoryId) {

		return getService().getReceiptSubCategory(receiptCategoryId);
	}

	public static Masterdata getReceiptSubCategoryById(
		long receiptSubCategoryId) {

		return getService().getReceiptSubCategoryById(receiptSubCategoryId);
	}

	public static Masterdata getSecondary(long secondaryHeadId) {
		return getService().getSecondary(secondaryHeadId);
	}

	public static List<Masterdata> getSecondaryHead(long primaryHeadId) {
		return getService().getSecondaryHead(primaryHeadId);
	}

	public static Masterdata getStateById(long stateId) {
		return getService().getStateById(stateId);
	}

	public static List<Masterdata> getStates(long countryId) {
		return getService().getStates(countryId);
	}

	public static List<Masterdata> getSubcategories(long categoryId) {
		return getService().getSubcategories(categoryId);
	}

	public static Masterdata getSubCategoryById(long subCategoryId) {
		return getService().getSubCategoryById(subCategoryId);
	}

	public static Masterdata getSubOrganizationById(long subOrganizationId) {
		return getService().getSubOrganizationById(subOrganizationId);
	}

	public static List<Masterdata> getSubOrgranizations(long organizationId) {
		return getService().getSubOrgranizations(organizationId);
	}

	public static List<Masterdata> getTeritaryHead(long seondaryHeadId) {
		return getService().getTeritaryHead(seondaryHeadId);
	}

	public static Masterdata getTertiary(long tertiaryHeadId) {
		return getService().getTertiary(tertiaryHeadId);
	}

	public static Masterdata getTypeById(long typeId) {
		return getService().getTypeById(typeId);
	}

	public static List<Masterdata> getTypes() {
		return getService().getTypes();
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
	public static Masterdata updateMasterdata(Masterdata masterdata) {
		return getService().updateMasterdata(masterdata);
	}

	public static MasterdataLocalService getService() {
		return _service;
	}

	private static volatile MasterdataLocalService _service;

}