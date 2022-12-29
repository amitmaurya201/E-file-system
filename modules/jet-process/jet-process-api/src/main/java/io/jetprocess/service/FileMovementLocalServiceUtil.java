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

import io.jetprocess.model.FileMovement;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FileMovement. This utility wraps
 * <code>io.jetprocess.service.impl.FileMovementLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FileMovementLocalService
 * @generated
 */
public class FileMovementLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.FileMovementLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the file movement to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileMovement the file movement
	 * @return the file movement that was added
	 */
	public static FileMovement addFileMovement(FileMovement fileMovement) {
		return getService().addFileMovement(fileMovement);
	}

	/**
	 * Creates a new file movement with the primary key. Does not add the file movement to the database.
	 *
	 * @param fmId the primary key for the new file movement
	 * @return the new file movement
	 */
	public static FileMovement createFileMovement(long fmId) {
		return getService().createFileMovement(fmId);
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
	 * Deletes the file movement from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileMovement the file movement
	 * @return the file movement that was removed
	 */
	public static FileMovement deleteFileMovement(FileMovement fileMovement) {
		return getService().deleteFileMovement(fileMovement);
	}

	/**
	 * Deletes the file movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement that was removed
	 * @throws PortalException if a file movement with the primary key could not be found
	 */
	public static FileMovement deleteFileMovement(long fmId)
		throws PortalException {

		return getService().deleteFileMovement(fmId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileMovementModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileMovementModelImpl</code>.
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

	public static FileMovement fetchFileMovement(long fmId) {
		return getService().fetchFileMovement(fmId);
	}

	/**
	 * Returns the file movement matching the UUID and group.
	 *
	 * @param uuid the file movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	public static FileMovement fetchFileMovementByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFileMovementByUuidAndGroupId(uuid, groupId);
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

	/**
	 * Returns the file movement with the primary key.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement
	 * @throws PortalException if a file movement with the primary key could not be found
	 */
	public static FileMovement getFileMovement(long fmId)
		throws PortalException {

		return getService().getFileMovement(fmId);
	}

	public static List<FileMovement> getFileMovementByFileId(long fileId) {
		return getService().getFileMovementByFileId(fileId);
	}

	public static FileMovement getFileMovementById(long fmId)
		throws PortalException {

		return getService().getFileMovementById(fmId);
	}

	/**
	 * Returns the file movement matching the UUID and group.
	 *
	 * @param uuid the file movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file movement
	 * @throws PortalException if a matching file movement could not be found
	 */
	public static FileMovement getFileMovementByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFileMovementByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of file movements
	 */
	public static List<FileMovement> getFileMovements(int start, int end) {
		return getService().getFileMovements(start, end);
	}

	/**
	 * Returns all the file movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the file movements
	 * @param companyId the primary key of the company
	 * @return the matching file movements, or an empty list if no matches were found
	 */
	public static List<FileMovement> getFileMovementsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getFileMovementsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of file movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the file movements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching file movements, or an empty list if no matches were found
	 */
	public static List<FileMovement> getFileMovementsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileMovement> orderByComparator) {

		return getService().getFileMovementsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file movements.
	 *
	 * @return the number of file movements
	 */
	public static int getFileMovementsCount() {
		return getService().getFileMovementsCount();
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

	public static boolean pullBackedAlready(long fmId) throws PortalException {
		return getService().pullBackedAlready(fmId);
	}

	public static FileMovement pullBackFileMovement(
			long fileId, long fileMovementId, String remarks)
		throws PortalException {

		return getService().pullBackFileMovement(
			fileId, fileMovementId, remarks);
	}

	/**
	 * create save send file method
	 *
	 * @param receiverId
	 * @param senderId
	 * @param fileId
	 * @param priority
	 * @param dueDate
	 * @param remark
	 */
	public static void saveSendFile(
		long receiverId, long senderId, long fileId, String priority,
		String dueDate, String remark) {

		getService().saveSendFile(
			receiverId, senderId, fileId, priority, dueDate, remark);
	}

	/**
	 * Updates the file movement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileMovement the file movement
	 * @return the file movement that was updated
	 */
	public static FileMovement updateFileMovement(FileMovement fileMovement) {
		return getService().updateFileMovement(fileMovement);
	}

	public static FileMovementLocalService getService() {
		return _service;
	}

	private static volatile FileMovementLocalService _service;

}