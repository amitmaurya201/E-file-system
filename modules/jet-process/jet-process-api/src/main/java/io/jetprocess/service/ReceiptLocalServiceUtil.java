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

import io.jetprocess.model.Receipt;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Receipt. This utility wraps
 * <code>io.jetprocess.service.impl.ReceiptLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptLocalService
 * @generated
 */
public class ReceiptLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.ReceiptLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the receipt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receipt the receipt
	 * @return the receipt that was added
	 */
	public static Receipt addReceipt(Receipt receipt) {
		return getService().addReceipt(receipt);
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
	 * Creates a new receipt with the primary key. Does not add the receipt to the database.
	 *
	 * @param receiptId the primary key for the new receipt
	 * @return the new receipt
	 */
	public static Receipt createReceipt(long receiptId) {
		return getService().createReceipt(receiptId);
	}

	public static Receipt createReceipt(
			long groupId, long typeId, long tempfileEntryId,
			long deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String name, String designation, String mobile, String email,
			String address, long countryId, long stateId, String pinCode,
			long organizationId, long subOrganizationId, String city,
			long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().createReceipt(
			groupId, typeId, tempfileEntryId, deliveryModeId, receivedOn,
			letterDate, referenceNumber, modeNumber, receiptCategoryId,
			receiptSubCategoryId, subject, remarks, name, designation, mobile,
			email, address, countryId, stateId, pinCode, organizationId,
			subOrganizationId, city, userPostId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the receipt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt that was removed
	 * @throws PortalException if a receipt with the primary key could not be found
	 */
	public static Receipt deleteReceipt(long receiptId) throws PortalException {
		return getService().deleteReceipt(receiptId);
	}

	/**
	 * Deletes the receipt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receipt the receipt
	 * @return the receipt that was removed
	 */
	public static Receipt deleteReceipt(Receipt receipt) {
		return getService().deleteReceipt(receipt);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptModelImpl</code>.
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

	public static Receipt fetchReceipt(long receiptId) {
		return getService().fetchReceipt(receiptId);
	}

	/**
	 * Returns the receipt matching the UUID and group.
	 *
	 * @param uuid the receipt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	public static Receipt fetchReceiptByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchReceiptByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Receipt> getAllReceipt() {
		return getService().getAllReceipt();
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
	 * Returns the receipt with the primary key.
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt
	 * @throws PortalException if a receipt with the primary key could not be found
	 */
	public static Receipt getReceipt(long receiptId) throws PortalException {
		return getService().getReceipt(receiptId);
	}

	public static Receipt getReceiptByReceiptId(long receiptId)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return getService().getReceiptByReceiptId(receiptId);
	}

	public static Receipt getReceiptByTempFileId(long tempFileId)
		throws java.io.IOException, PortalException {

		return getService().getReceiptByTempFileId(tempFileId);
	}

	/**
	 * Returns the receipt matching the UUID and group.
	 *
	 * @param uuid the receipt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt
	 * @throws PortalException if a matching receipt could not be found
	 */
	public static Receipt getReceiptByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getReceiptByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @return the range of receipts
	 */
	public static List<Receipt> getReceipts(int start, int end) {
		return getService().getReceipts(start, end);
	}

	/**
	 * Returns all the receipts matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipts
	 * @param companyId the primary key of the company
	 * @return the matching receipts, or an empty list if no matches were found
	 */
	public static List<Receipt> getReceiptsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getReceiptsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of receipts matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of receipts
	 * @param end the upper bound of the range of receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching receipts, or an empty list if no matches were found
	 */
	public static List<Receipt> getReceiptsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Receipt> orderByComparator) {

		return getService().getReceiptsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of receipts.
	 *
	 * @return the number of receipts
	 */
	public static int getReceiptsCount() {
		return getService().getReceiptsCount();
	}

	public static Receipt updateReceipt(
			long receiptId, long groupId, long typeId, long tempfileEntryId,
			long deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String document, String name, String designation, String mobile,
			String email, String address, long countryId, long stateId,
			String pinCode, long organizationId, long subOrganizationId,
			String city, long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateReceipt(
			receiptId, groupId, typeId, tempfileEntryId, deliveryModeId,
			receivedOn, letterDate, referenceNumber, modeNumber,
			receiptCategoryId, receiptSubCategoryId, subject, remarks, document,
			name, designation, mobile, email, address, countryId, stateId,
			pinCode, organizationId, subOrganizationId, city, userPostId,
			serviceContext);
	}

	/**
	 * Updates the receipt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receipt the receipt
	 * @return the receipt that was updated
	 */
	public static Receipt updateReceipt(Receipt receipt) {
		return getService().updateReceipt(receipt);
	}

	public static ReceiptLocalService getService() {
		return _service;
	}

	private static volatile ReceiptLocalService _service;

}