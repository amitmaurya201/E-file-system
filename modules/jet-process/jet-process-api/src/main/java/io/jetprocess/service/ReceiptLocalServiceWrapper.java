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
 * Provides a wrapper for {@link ReceiptLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptLocalService
 * @generated
 */
public class ReceiptLocalServiceWrapper
	implements ReceiptLocalService, ServiceWrapper<ReceiptLocalService> {

	public ReceiptLocalServiceWrapper() {
		this(null);
	}

	public ReceiptLocalServiceWrapper(ReceiptLocalService receiptLocalService) {
		_receiptLocalService = receiptLocalService;
	}

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
	@Override
	public io.jetprocess.model.Receipt addReceipt(
		io.jetprocess.model.Receipt receipt) {

		return _receiptLocalService.addReceipt(receipt);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new receipt with the primary key. Does not add the receipt to the database.
	 *
	 * @param receiptId the primary key for the new receipt
	 * @return the new receipt
	 */
	@Override
	public io.jetprocess.model.Receipt createReceipt(long receiptId) {
		return _receiptLocalService.createReceipt(receiptId);
	}

	@Override
	public io.jetprocess.model.Receipt createReceipt(
			long groupId, long typeId, long tempfileEntryId,
			long deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String name, String designation, String mobile, String email,
			String address, long countryId, long stateId, String pinCode,
			long organizationId, long subOrganizationId, String city,
			long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptLocalService.createReceipt(
			groupId, typeId, tempfileEntryId, deliveryModeId, receivedOn,
			letterDate, referenceNumber, modeNumber, receiptCategoryId,
			receiptSubCategoryId, subject, remarks, name, designation, mobile,
			email, address, countryId, stateId, pinCode, organizationId,
			subOrganizationId, city, userPostId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public io.jetprocess.model.Receipt deleteReceipt(long receiptId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptLocalService.deleteReceipt(receiptId);
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
	@Override
	public io.jetprocess.model.Receipt deleteReceipt(
		io.jetprocess.model.Receipt receipt) {

		return _receiptLocalService.deleteReceipt(receipt);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _receiptLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _receiptLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _receiptLocalService.dynamicQuery();
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

		return _receiptLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _receiptLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _receiptLocalService.dynamicQuery(
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

		return _receiptLocalService.dynamicQueryCount(dynamicQuery);
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

		return _receiptLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.Receipt fetchReceipt(long receiptId) {
		return _receiptLocalService.fetchReceipt(receiptId);
	}

	/**
	 * Returns the receipt matching the UUID and group.
	 *
	 * @param uuid the receipt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt, or <code>null</code> if a matching receipt could not be found
	 */
	@Override
	public io.jetprocess.model.Receipt fetchReceiptByUuidAndGroupId(
		String uuid, long groupId) {

		return _receiptLocalService.fetchReceiptByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _receiptLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<io.jetprocess.model.Receipt> getAllReceipt() {
		return _receiptLocalService.getAllReceipt();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _receiptLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _receiptLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _receiptLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the receipt with the primary key.
	 *
	 * @param receiptId the primary key of the receipt
	 * @return the receipt
	 * @throws PortalException if a receipt with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.Receipt getReceipt(long receiptId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptLocalService.getReceipt(receiptId);
	}

	@Override
	public io.jetprocess.model.Receipt getReceiptByReceiptId(long receiptId)
		throws io.jetprocess.exception.NoSuchReceiptException {

		return _receiptLocalService.getReceiptByReceiptId(receiptId);
	}

	@Override
	public io.jetprocess.model.Receipt getReceiptByTempFileId(long tempFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.io.IOException {

		return _receiptLocalService.getReceiptByTempFileId(tempFileId);
	}

	/**
	 * Returns the receipt matching the UUID and group.
	 *
	 * @param uuid the receipt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt
	 * @throws PortalException if a matching receipt could not be found
	 */
	@Override
	public io.jetprocess.model.Receipt getReceiptByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptLocalService.getReceiptByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<io.jetprocess.model.Receipt> getReceipts(
		int start, int end) {

		return _receiptLocalService.getReceipts(start, end);
	}

	/**
	 * Returns all the receipts matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipts
	 * @param companyId the primary key of the company
	 * @return the matching receipts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.Receipt>
		getReceiptsByUuidAndCompanyId(String uuid, long companyId) {

		return _receiptLocalService.getReceiptsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<io.jetprocess.model.Receipt>
		getReceiptsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.Receipt> orderByComparator) {

		return _receiptLocalService.getReceiptsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of receipts.
	 *
	 * @return the number of receipts
	 */
	@Override
	public int getReceiptsCount() {
		return _receiptLocalService.getReceiptsCount();
	}

	@Override
	public io.jetprocess.model.Receipt updateReceipt(
			long receiptId, long groupId, long typeId, long tempfileEntryId,
			long deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String document, String name, String designation, String mobile,
			String email, String address, long countryId, long stateId,
			String pinCode, long organizationId, long subOrganizationId,
			String city, long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptLocalService.updateReceipt(
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
	@Override
	public io.jetprocess.model.Receipt updateReceipt(
		io.jetprocess.model.Receipt receipt) {

		return _receiptLocalService.updateReceipt(receipt);
	}

	@Override
	public ReceiptLocalService getWrappedService() {
		return _receiptLocalService;
	}

	@Override
	public void setWrappedService(ReceiptLocalService receiptLocalService) {
		_receiptLocalService = receiptLocalService;
	}

	private ReceiptLocalService _receiptLocalService;

}