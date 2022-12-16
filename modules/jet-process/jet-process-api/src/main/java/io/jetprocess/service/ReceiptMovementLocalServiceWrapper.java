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
 * Provides a wrapper for {@link ReceiptMovementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptMovementLocalService
 * @generated
 */
public class ReceiptMovementLocalServiceWrapper
	implements ReceiptMovementLocalService,
			   ServiceWrapper<ReceiptMovementLocalService> {

	public ReceiptMovementLocalServiceWrapper() {
		this(null);
	}

	public ReceiptMovementLocalServiceWrapper(
		ReceiptMovementLocalService receiptMovementLocalService) {

		_receiptMovementLocalService = receiptMovementLocalService;
	}

	/**
	 * Adds the receipt movement to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptMovement the receipt movement
	 * @return the receipt movement that was added
	 */
	@Override
	public io.jetprocess.model.ReceiptMovement addReceiptMovement(
		io.jetprocess.model.ReceiptMovement receiptMovement) {

		return _receiptMovementLocalService.addReceiptMovement(receiptMovement);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptMovementLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new receipt movement with the primary key. Does not add the receipt movement to the database.
	 *
	 * @param rmId the primary key for the new receipt movement
	 * @return the new receipt movement
	 */
	@Override
	public io.jetprocess.model.ReceiptMovement createReceiptMovement(
		long rmId) {

		return _receiptMovementLocalService.createReceiptMovement(rmId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptMovementLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the receipt movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement that was removed
	 * @throws PortalException if a receipt movement with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.ReceiptMovement deleteReceiptMovement(long rmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptMovementLocalService.deleteReceiptMovement(rmId);
	}

	/**
	 * Deletes the receipt movement from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptMovement the receipt movement
	 * @return the receipt movement that was removed
	 */
	@Override
	public io.jetprocess.model.ReceiptMovement deleteReceiptMovement(
		io.jetprocess.model.ReceiptMovement receiptMovement) {

		return _receiptMovementLocalService.deleteReceiptMovement(
			receiptMovement);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _receiptMovementLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _receiptMovementLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _receiptMovementLocalService.dynamicQuery();
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

		return _receiptMovementLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptMovementModelImpl</code>.
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

		return _receiptMovementLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptMovementModelImpl</code>.
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

		return _receiptMovementLocalService.dynamicQuery(
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

		return _receiptMovementLocalService.dynamicQueryCount(dynamicQuery);
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

		return _receiptMovementLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.ReceiptMovement fetchReceiptMovement(long rmId) {
		return _receiptMovementLocalService.fetchReceiptMovement(rmId);
	}

	/**
	 * Returns the receipt movement matching the UUID and group.
	 *
	 * @param uuid the receipt movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	@Override
	public io.jetprocess.model.ReceiptMovement
		fetchReceiptMovementByUuidAndGroupId(String uuid, long groupId) {

		return _receiptMovementLocalService.
			fetchReceiptMovementByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _receiptMovementLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _receiptMovementLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _receiptMovementLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _receiptMovementLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptMovementLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the receipt movement with the primary key.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement
	 * @throws PortalException if a receipt movement with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.ReceiptMovement getReceiptMovement(long rmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptMovementLocalService.getReceiptMovement(rmId);
	}

	@Override
	public io.jetprocess.model.ReceiptMovement getReceiptMovementByReceiptId(
		long receiptId) {

		return _receiptMovementLocalService.getReceiptMovementByReceiptId(
			receiptId);
	}

	/**
	 * Returns the receipt movement matching the UUID and group.
	 *
	 * @param uuid the receipt movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt movement
	 * @throws PortalException if a matching receipt movement could not be found
	 */
	@Override
	public io.jetprocess.model.ReceiptMovement
			getReceiptMovementByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptMovementLocalService.getReceiptMovementByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the receipt movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of receipt movements
	 */
	@Override
	public java.util.List<io.jetprocess.model.ReceiptMovement>
		getReceiptMovements(int start, int end) {

		return _receiptMovementLocalService.getReceiptMovements(start, end);
	}

	/**
	 * Returns all the receipt movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipt movements
	 * @param companyId the primary key of the company
	 * @return the matching receipt movements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.ReceiptMovement>
		getReceiptMovementsByUuidAndCompanyId(String uuid, long companyId) {

		return _receiptMovementLocalService.
			getReceiptMovementsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of receipt movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipt movements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching receipt movements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.ReceiptMovement>
		getReceiptMovementsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.ReceiptMovement> orderByComparator) {

		return _receiptMovementLocalService.
			getReceiptMovementsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of receipt movements.
	 *
	 * @return the number of receipt movements
	 */
	@Override
	public int getReceiptMovementsCount() {
		return _receiptMovementLocalService.getReceiptMovementsCount();
	}

	@Override
	public io.jetprocess.model.ReceiptMovement pullBackReceiptMovement(
			long receiptId, long receiptMovementId, String remarks)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptMovementLocalService.pullBackReceiptMovement(
			receiptId, receiptMovementId, remarks);
	}

	@Override
	public void saveSendReceipt(
		long receiverId, long senderId, long receiptId, String priority,
		String dueDate, String remark) {

		_receiptMovementLocalService.saveSendReceipt(
			receiverId, senderId, receiptId, priority, dueDate, remark);
	}

	/**
	 * Updates the receipt movement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptMovement the receipt movement
	 * @return the receipt movement that was updated
	 */
	@Override
	public io.jetprocess.model.ReceiptMovement updateReceiptMovement(
		io.jetprocess.model.ReceiptMovement receiptMovement) {

		return _receiptMovementLocalService.updateReceiptMovement(
			receiptMovement);
	}

	@Override
	public ReceiptMovementLocalService getWrappedService() {
		return _receiptMovementLocalService;
	}

	@Override
	public void setWrappedService(
		ReceiptMovementLocalService receiptMovementLocalService) {

		_receiptMovementLocalService = receiptMovementLocalService;
	}

	private ReceiptMovementLocalService _receiptMovementLocalService;

}