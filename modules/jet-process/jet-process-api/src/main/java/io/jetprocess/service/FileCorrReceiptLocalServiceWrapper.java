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
 * Provides a wrapper for {@link FileCorrReceiptLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrReceiptLocalService
 * @generated
 */
public class FileCorrReceiptLocalServiceWrapper
	implements FileCorrReceiptLocalService,
			   ServiceWrapper<FileCorrReceiptLocalService> {

	public FileCorrReceiptLocalServiceWrapper() {
		this(null);
	}

	public FileCorrReceiptLocalServiceWrapper(
		FileCorrReceiptLocalService fileCorrReceiptLocalService) {

		_fileCorrReceiptLocalService = fileCorrReceiptLocalService;
	}

	/**
	 * Adds the file corr receipt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrReceipt the file corr receipt
	 * @return the file corr receipt that was added
	 */
	@Override
	public io.jetprocess.model.FileCorrReceipt addFileCorrReceipt(
		io.jetprocess.model.FileCorrReceipt fileCorrReceipt) {

		return _fileCorrReceiptLocalService.addFileCorrReceipt(fileCorrReceipt);
	}

	@Override
	public void addReceiptInFile(
			long receiptId, long docFileId, long userPostId, String remark,
			long receiptMovementId, long fileMovementId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_fileCorrReceiptLocalService.addReceiptInFile(
			receiptId, docFileId, userPostId, remark, receiptMovementId,
			fileMovementId);
	}

	/**
	 * Creates a new file corr receipt with the primary key. Does not add the file corr receipt to the database.
	 *
	 * @param fileCorrReceiptId the primary key for the new file corr receipt
	 * @return the new file corr receipt
	 */
	@Override
	public io.jetprocess.model.FileCorrReceipt createFileCorrReceipt(
		long fileCorrReceiptId) {

		return _fileCorrReceiptLocalService.createFileCorrReceipt(
			fileCorrReceiptId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrReceiptLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the file corr receipt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrReceipt the file corr receipt
	 * @return the file corr receipt that was removed
	 */
	@Override
	public io.jetprocess.model.FileCorrReceipt deleteFileCorrReceipt(
		io.jetprocess.model.FileCorrReceipt fileCorrReceipt) {

		return _fileCorrReceiptLocalService.deleteFileCorrReceipt(
			fileCorrReceipt);
	}

	/**
	 * Deletes the file corr receipt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt that was removed
	 * @throws PortalException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.FileCorrReceipt deleteFileCorrReceipt(
			long fileCorrReceiptId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrReceiptLocalService.deleteFileCorrReceipt(
			fileCorrReceiptId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrReceiptLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public boolean detachFileCorrReceipt(
		long receiptId, long receiptMovementId, String detachRemark,
		long detachBy) {

		return _fileCorrReceiptLocalService.detachFileCorrReceipt(
			receiptId, receiptMovementId, detachRemark, detachBy);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fileCorrReceiptLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fileCorrReceiptLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fileCorrReceiptLocalService.dynamicQuery();
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

		return _fileCorrReceiptLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrReceiptModelImpl</code>.
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

		return _fileCorrReceiptLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrReceiptModelImpl</code>.
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

		return _fileCorrReceiptLocalService.dynamicQuery(
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

		return _fileCorrReceiptLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fileCorrReceiptLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.FileCorrReceipt fetchFileCorrReceipt(
		long fileCorrReceiptId) {

		return _fileCorrReceiptLocalService.fetchFileCorrReceipt(
			fileCorrReceiptId);
	}

	/**
	 * Returns the file corr receipt matching the UUID and group.
	 *
	 * @param uuid the file corr receipt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public io.jetprocess.model.FileCorrReceipt
		fetchFileCorrReceiptByUuidAndGroupId(String uuid, long groupId) {

		return _fileCorrReceiptLocalService.
			fetchFileCorrReceiptByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fileCorrReceiptLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _fileCorrReceiptLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the file corr receipt with the primary key.
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt
	 * @throws PortalException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.FileCorrReceipt getFileCorrReceipt(
			long fileCorrReceiptId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrReceiptLocalService.getFileCorrReceipt(
			fileCorrReceiptId);
	}

	@Override
	public java.util.List<io.jetprocess.model.FileCorrReceipt>
		getFileCorrReceiptByFileId(long fileId) {

		return _fileCorrReceiptLocalService.getFileCorrReceiptByFileId(fileId);
	}

	@Override
	public io.jetprocess.model.FileCorrReceipt
		getFileCorrReceiptByReceiptIdAndReceiptMovementId(
			long receiptId, long receiptMovementId) {

		return _fileCorrReceiptLocalService.
			getFileCorrReceiptByReceiptIdAndReceiptMovementId(
				receiptId, receiptMovementId);
	}

	/**
	 * Returns the file corr receipt matching the UUID and group.
	 *
	 * @param uuid the file corr receipt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file corr receipt
	 * @throws PortalException if a matching file corr receipt could not be found
	 */
	@Override
	public io.jetprocess.model.FileCorrReceipt
			getFileCorrReceiptByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrReceiptLocalService.getFileCorrReceiptByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the file corr receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of file corr receipts
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileCorrReceipt>
		getFileCorrReceipts(int start, int end) {

		return _fileCorrReceiptLocalService.getFileCorrReceipts(start, end);
	}

	/**
	 * Returns all the file corr receipts matching the UUID and company.
	 *
	 * @param uuid the UUID of the file corr receipts
	 * @param companyId the primary key of the company
	 * @return the matching file corr receipts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileCorrReceipt>
		getFileCorrReceiptsByUuidAndCompanyId(String uuid, long companyId) {

		return _fileCorrReceiptLocalService.
			getFileCorrReceiptsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of file corr receipts matching the UUID and company.
	 *
	 * @param uuid the UUID of the file corr receipts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching file corr receipts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileCorrReceipt>
		getFileCorrReceiptsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.FileCorrReceipt> orderByComparator) {

		return _fileCorrReceiptLocalService.
			getFileCorrReceiptsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file corr receipts.
	 *
	 * @return the number of file corr receipts
	 */
	@Override
	public int getFileCorrReceiptsCount() {
		return _fileCorrReceiptLocalService.getFileCorrReceiptsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fileCorrReceiptLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fileCorrReceiptLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrReceiptLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the file corr receipt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrReceipt the file corr receipt
	 * @return the file corr receipt that was updated
	 */
	@Override
	public io.jetprocess.model.FileCorrReceipt updateFileCorrReceipt(
		io.jetprocess.model.FileCorrReceipt fileCorrReceipt) {

		return _fileCorrReceiptLocalService.updateFileCorrReceipt(
			fileCorrReceipt);
	}

	@Override
	public FileCorrReceiptLocalService getWrappedService() {
		return _fileCorrReceiptLocalService;
	}

	@Override
	public void setWrappedService(
		FileCorrReceiptLocalService fileCorrReceiptLocalService) {

		_fileCorrReceiptLocalService = fileCorrReceiptLocalService;
	}

	private FileCorrReceiptLocalService _fileCorrReceiptLocalService;

}