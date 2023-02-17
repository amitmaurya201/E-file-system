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
 * Provides a wrapper for {@link ReceiptCloseDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptCloseDetailLocalService
 * @generated
 */
public class ReceiptCloseDetailLocalServiceWrapper
	implements ReceiptCloseDetailLocalService,
			   ServiceWrapper<ReceiptCloseDetailLocalService> {

	public ReceiptCloseDetailLocalServiceWrapper() {
		this(null);
	}

	public ReceiptCloseDetailLocalServiceWrapper(
		ReceiptCloseDetailLocalService receiptCloseDetailLocalService) {

		_receiptCloseDetailLocalService = receiptCloseDetailLocalService;
	}

	/**
	 * Adds the receipt close detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptCloseDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptCloseDetail the receipt close detail
	 * @return the receipt close detail that was added
	 */
	@Override
	public io.jetprocess.model.ReceiptCloseDetail addReceiptCloseDetail(
		io.jetprocess.model.ReceiptCloseDetail receiptCloseDetail) {

		return _receiptCloseDetailLocalService.addReceiptCloseDetail(
			receiptCloseDetail);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptCloseDetailLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new receipt close detail with the primary key. Does not add the receipt close detail to the database.
	 *
	 * @param ReceiptClosedId the primary key for the new receipt close detail
	 * @return the new receipt close detail
	 */
	@Override
	public io.jetprocess.model.ReceiptCloseDetail createReceiptCloseDetail(
		long ReceiptClosedId) {

		return _receiptCloseDetailLocalService.createReceiptCloseDetail(
			ReceiptClosedId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptCloseDetailLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the receipt close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptCloseDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail that was removed
	 * @throws PortalException if a receipt close detail with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.ReceiptCloseDetail deleteReceiptCloseDetail(
			long ReceiptClosedId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptCloseDetailLocalService.deleteReceiptCloseDetail(
			ReceiptClosedId);
	}

	/**
	 * Deletes the receipt close detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptCloseDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptCloseDetail the receipt close detail
	 * @return the receipt close detail that was removed
	 */
	@Override
	public io.jetprocess.model.ReceiptCloseDetail deleteReceiptCloseDetail(
		io.jetprocess.model.ReceiptCloseDetail receiptCloseDetail) {

		return _receiptCloseDetailLocalService.deleteReceiptCloseDetail(
			receiptCloseDetail);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _receiptCloseDetailLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _receiptCloseDetailLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _receiptCloseDetailLocalService.dynamicQuery();
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

		return _receiptCloseDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptCloseDetailModelImpl</code>.
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

		return _receiptCloseDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptCloseDetailModelImpl</code>.
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

		return _receiptCloseDetailLocalService.dynamicQuery(
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

		return _receiptCloseDetailLocalService.dynamicQueryCount(dynamicQuery);
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

		return _receiptCloseDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.ReceiptCloseDetail fetchReceiptCloseDetail(
		long ReceiptClosedId) {

		return _receiptCloseDetailLocalService.fetchReceiptCloseDetail(
			ReceiptClosedId);
	}

	/**
	 * Returns the receipt close detail matching the UUID and group.
	 *
	 * @param uuid the receipt close detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	@Override
	public io.jetprocess.model.ReceiptCloseDetail
		fetchReceiptCloseDetailByUuidAndGroupId(String uuid, long groupId) {

		return _receiptCloseDetailLocalService.
			fetchReceiptCloseDetailByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _receiptCloseDetailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _receiptCloseDetailLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _receiptCloseDetailLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _receiptCloseDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptCloseDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the receipt close detail with the primary key.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail
	 * @throws PortalException if a receipt close detail with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.ReceiptCloseDetail getReceiptCloseDetail(
			long ReceiptClosedId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptCloseDetailLocalService.getReceiptCloseDetail(
			ReceiptClosedId);
	}

	/**
	 * Returns the receipt close detail matching the UUID and group.
	 *
	 * @param uuid the receipt close detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt close detail
	 * @throws PortalException if a matching receipt close detail could not be found
	 */
	@Override
	public io.jetprocess.model.ReceiptCloseDetail
			getReceiptCloseDetailByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _receiptCloseDetailLocalService.
			getReceiptCloseDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the receipt close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @return the range of receipt close details
	 */
	@Override
	public java.util.List<io.jetprocess.model.ReceiptCloseDetail>
		getReceiptCloseDetails(int start, int end) {

		return _receiptCloseDetailLocalService.getReceiptCloseDetails(
			start, end);
	}

	/**
	 * Returns all the receipt close details matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipt close details
	 * @param companyId the primary key of the company
	 * @return the matching receipt close details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.ReceiptCloseDetail>
		getReceiptCloseDetailsByUuidAndCompanyId(String uuid, long companyId) {

		return _receiptCloseDetailLocalService.
			getReceiptCloseDetailsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of receipt close details matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipt close details
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching receipt close details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.ReceiptCloseDetail>
		getReceiptCloseDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.ReceiptCloseDetail> orderByComparator) {

		return _receiptCloseDetailLocalService.
			getReceiptCloseDetailsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of receipt close details.
	 *
	 * @return the number of receipt close details
	 */
	@Override
	public int getReceiptCloseDetailsCount() {
		return _receiptCloseDetailLocalService.getReceiptCloseDetailsCount();
	}

	/**
	 * Updates the receipt close detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptCloseDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptCloseDetail the receipt close detail
	 * @return the receipt close detail that was updated
	 */
	@Override
	public io.jetprocess.model.ReceiptCloseDetail updateReceiptCloseDetail(
		io.jetprocess.model.ReceiptCloseDetail receiptCloseDetail) {

		return _receiptCloseDetailLocalService.updateReceiptCloseDetail(
			receiptCloseDetail);
	}

	@Override
	public ReceiptCloseDetailLocalService getWrappedService() {
		return _receiptCloseDetailLocalService;
	}

	@Override
	public void setWrappedService(
		ReceiptCloseDetailLocalService receiptCloseDetailLocalService) {

		_receiptCloseDetailLocalService = receiptCloseDetailLocalService;
	}

	private ReceiptCloseDetailLocalService _receiptCloseDetailLocalService;

}