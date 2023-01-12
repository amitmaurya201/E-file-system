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

import io.jetprocess.model.ReceiptMovement;

import java.io.Serializable;

import java.util.List;

import javax.portlet.PortletException;

/**
 * Provides the local service utility for ReceiptMovement. This utility wraps
 * <code>io.jetprocess.service.impl.ReceiptMovementLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptMovementLocalService
 * @generated
 */
public class ReceiptMovementLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.ReceiptMovementLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ReceiptMovement addReceiptMovement(
		ReceiptMovement receiptMovement) {

		return getService().addReceiptMovement(receiptMovement);
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
	 * Creates a new receipt movement with the primary key. Does not add the receipt movement to the database.
	 *
	 * @param rmId the primary key for the new receipt movement
	 * @return the new receipt movement
	 */
	public static ReceiptMovement createReceiptMovement(long rmId) {
		return getService().createReceiptMovement(rmId);
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
	public static ReceiptMovement deleteReceiptMovement(long rmId)
		throws PortalException {

		return getService().deleteReceiptMovement(rmId);
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
	public static ReceiptMovement deleteReceiptMovement(
		ReceiptMovement receiptMovement) {

		return getService().deleteReceiptMovement(receiptMovement);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptMovementModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptMovementModelImpl</code>.
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

	public static ReceiptMovement fetchReceiptMovement(long rmId) {
		return getService().fetchReceiptMovement(rmId);
	}

	/**
	 * Returns the receipt movement matching the UUID and group.
	 *
	 * @param uuid the receipt movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	public static ReceiptMovement fetchReceiptMovementByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchReceiptMovementByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the receipt movement with the primary key.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement
	 * @throws PortalException if a receipt movement with the primary key could not be found
	 */
	public static ReceiptMovement getReceiptMovement(long rmId)
		throws PortalException {

		return getService().getReceiptMovement(rmId);
	}

	public static List<ReceiptMovement> getReceiptMovementByFileMovementId(
		long fileMovementId) {

		return getService().getReceiptMovementByFileMovementId(fileMovementId);
	}

	public static List<ReceiptMovement> getReceiptMovementByReceiptId(
		long receiptId) {

		return getService().getReceiptMovementByReceiptId(receiptId);
	}

	/**
	 * Returns the receipt movement matching the UUID and group.
	 *
	 * @param uuid the receipt movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt movement
	 * @throws PortalException if a matching receipt movement could not be found
	 */
	public static ReceiptMovement getReceiptMovementByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getReceiptMovementByUuidAndGroupId(uuid, groupId);
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
	public static List<ReceiptMovement> getReceiptMovements(
		int start, int end) {

		return getService().getReceiptMovements(start, end);
	}

	/**
	 * Returns all the receipt movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipt movements
	 * @param companyId the primary key of the company
	 * @return the matching receipt movements, or an empty list if no matches were found
	 */
	public static List<ReceiptMovement> getReceiptMovementsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getReceiptMovementsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ReceiptMovement> getReceiptMovementsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return getService().getReceiptMovementsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of receipt movements.
	 *
	 * @return the number of receipt movements
	 */
	public static int getReceiptMovementsCount() {
		return getService().getReceiptMovementsCount();
	}

	public static Boolean isActive(long receiptId) {
		return getService().isActive(receiptId);
	}

	public static Boolean isPullBackAvailable(long rmId) {
		return getService().isPullBackAvailable(rmId);
	}

	public static boolean pullBackedAlready(long rmId) throws PortalException {
		return getService().pullBackedAlready(rmId);
	}

	public static void pullBackReceiptMovement(
			long receiptId, long receiptMovementId, String remarks,
			long userPostId)
		throws PortalException {

		getService().pullBackReceiptMovement(
			receiptId, receiptMovementId, remarks, userPostId);
	}

	public static void pullBackReceiptsAttatchWithFile(
		List<ReceiptMovement> receiptMovementList, long fileMovementId) {

		getService().pullBackReceiptsAttatchWithFile(
			receiptMovementList, fileMovementId);
	}

	public static boolean saveReadMovement(long receiptId, long rmId) {
		return getService().saveReadMovement(receiptId, rmId);
	}

	public static boolean saveReceiveMovement(long receiptId, long rmId) {
		return getService().saveReceiveMovement(receiptId, rmId);
	}

	public static void saveSendReceipt(
		long receiverId, long senderId, long receiptId, String priority,
		String dueDate, String remark) throws PortalException, PortletException {

		getService().saveSendReceipt(
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
	public static ReceiptMovement updateReceiptMovement(
		ReceiptMovement receiptMovement) {

		return getService().updateReceiptMovement(receiptMovement);
	}

	public static ReceiptMovementLocalService getService() {
		return _service;
	}

	private static volatile ReceiptMovementLocalService _service;

}