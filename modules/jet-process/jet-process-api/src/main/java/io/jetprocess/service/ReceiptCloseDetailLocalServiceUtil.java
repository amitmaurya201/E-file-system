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

import io.jetprocess.model.ReceiptCloseDetail;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ReceiptCloseDetail. This utility wraps
 * <code>io.jetprocess.service.impl.ReceiptCloseDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptCloseDetailLocalService
 * @generated
 */
public class ReceiptCloseDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.ReceiptCloseDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ReceiptCloseDetail addClosedReceiptDetails(
			long receiptId, long closedBy, String closingRemarks,
			long closedMovementId)
		throws PortalException {

		return getService().addClosedReceiptDetails(
			receiptId, closedBy, closingRemarks, closedMovementId);
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
	public static ReceiptCloseDetail addReceiptCloseDetail(
		ReceiptCloseDetail receiptCloseDetail) {

		return getService().addReceiptCloseDetail(receiptCloseDetail);
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
	 * Creates a new receipt close detail with the primary key. Does not add the receipt close detail to the database.
	 *
	 * @param ReceiptClosedId the primary key for the new receipt close detail
	 * @return the new receipt close detail
	 */
	public static ReceiptCloseDetail createReceiptCloseDetail(
		long ReceiptClosedId) {

		return getService().createReceiptCloseDetail(ReceiptClosedId);
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
	public static ReceiptCloseDetail deleteReceiptCloseDetail(
			long ReceiptClosedId)
		throws PortalException {

		return getService().deleteReceiptCloseDetail(ReceiptClosedId);
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
	public static ReceiptCloseDetail deleteReceiptCloseDetail(
		ReceiptCloseDetail receiptCloseDetail) {

		return getService().deleteReceiptCloseDetail(receiptCloseDetail);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptCloseDetailModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptCloseDetailModelImpl</code>.
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

	public static ReceiptCloseDetail fetchReceiptCloseDetail(
		long ReceiptClosedId) {

		return getService().fetchReceiptCloseDetail(ReceiptClosedId);
	}

	/**
	 * Returns the receipt close detail matching the UUID and group.
	 *
	 * @param uuid the receipt close detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail fetchReceiptCloseDetailByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchReceiptCloseDetailByUuidAndGroupId(
			uuid, groupId);
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
	 * Returns the receipt close detail with the primary key.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail
	 * @throws PortalException if a receipt close detail with the primary key could not be found
	 */
	public static ReceiptCloseDetail getReceiptCloseDetail(long ReceiptClosedId)
		throws PortalException {

		return getService().getReceiptCloseDetail(ReceiptClosedId);
	}

	/**
	 * Returns the receipt close detail matching the UUID and group.
	 *
	 * @param uuid the receipt close detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt close detail
	 * @throws PortalException if a matching receipt close detail could not be found
	 */
	public static ReceiptCloseDetail getReceiptCloseDetailByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getReceiptCloseDetailByUuidAndGroupId(
			uuid, groupId);
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
	public static List<ReceiptCloseDetail> getReceiptCloseDetails(
		int start, int end) {

		return getService().getReceiptCloseDetails(start, end);
	}

	/**
	 * Returns all the receipt close details matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipt close details
	 * @param companyId the primary key of the company
	 * @return the matching receipt close details, or an empty list if no matches were found
	 */
	public static List<ReceiptCloseDetail>
		getReceiptCloseDetailsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getReceiptCloseDetailsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ReceiptCloseDetail>
		getReceiptCloseDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return getService().getReceiptCloseDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of receipt close details.
	 *
	 * @return the number of receipt close details
	 */
	public static int getReceiptCloseDetailsCount() {
		return getService().getReceiptCloseDetailsCount();
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
	public static ReceiptCloseDetail updateReceiptCloseDetail(
		ReceiptCloseDetail receiptCloseDetail) {

		return getService().updateReceiptCloseDetail(receiptCloseDetail);
	}

	public static ReceiptCloseDetailLocalService getService() {
		return _service;
	}

	private static volatile ReceiptCloseDetailLocalService _service;

}