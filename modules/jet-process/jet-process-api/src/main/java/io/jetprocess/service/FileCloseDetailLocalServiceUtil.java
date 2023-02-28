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

import io.jetprocess.model.FileCloseDetail;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FileCloseDetail. This utility wraps
 * <code>io.jetprocess.service.impl.FileCloseDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FileCloseDetailLocalService
 * @generated
 */
public class FileCloseDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.FileCloseDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the file close detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCloseDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCloseDetail the file close detail
	 * @return the file close detail that was added
	 */
	public static FileCloseDetail addFileCloseDetail(
		FileCloseDetail fileCloseDetail) {

		return getService().addFileCloseDetail(fileCloseDetail);
	}

	/**
	 * Creates a new file close detail with the primary key. Does not add the file close detail to the database.
	 *
	 * @param fileClosedId the primary key for the new file close detail
	 * @return the new file close detail
	 */
	public static FileCloseDetail createFileCloseDetail(long fileClosedId) {
		return getService().createFileCloseDetail(fileClosedId);
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
	 * Deletes the file close detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCloseDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCloseDetail the file close detail
	 * @return the file close detail that was removed
	 */
	public static FileCloseDetail deleteFileCloseDetail(
		FileCloseDetail fileCloseDetail) {

		return getService().deleteFileCloseDetail(fileCloseDetail);
	}

	/**
	 * Deletes the file close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCloseDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail that was removed
	 * @throws PortalException if a file close detail with the primary key could not be found
	 */
	public static FileCloseDetail deleteFileCloseDetail(long fileClosedId)
		throws PortalException {

		return getService().deleteFileCloseDetail(fileClosedId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCloseDetailModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCloseDetailModelImpl</code>.
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

	public static FileCloseDetail fetchFileCloseDetail(long fileClosedId) {
		return getService().fetchFileCloseDetail(fileClosedId);
	}

	/**
	 * Returns the file close detail matching the UUID and group.
	 *
	 * @param uuid the file close detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	public static FileCloseDetail fetchFileCloseDetailByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFileCloseDetailByUuidAndGroupId(uuid, groupId);
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
	 * Returns the file close detail with the primary key.
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail
	 * @throws PortalException if a file close detail with the primary key could not be found
	 */
	public static FileCloseDetail getFileCloseDetail(long fileClosedId)
		throws PortalException {

		return getService().getFileCloseDetail(fileClosedId);
	}

	/**
	 * Returns the file close detail matching the UUID and group.
	 *
	 * @param uuid the file close detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file close detail
	 * @throws PortalException if a matching file close detail could not be found
	 */
	public static FileCloseDetail getFileCloseDetailByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFileCloseDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the file close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @return the range of file close details
	 */
	public static List<FileCloseDetail> getFileCloseDetails(
		int start, int end) {

		return getService().getFileCloseDetails(start, end);
	}

	/**
	 * Returns all the file close details matching the UUID and company.
	 *
	 * @param uuid the UUID of the file close details
	 * @param companyId the primary key of the company
	 * @return the matching file close details, or an empty list if no matches were found
	 */
	public static List<FileCloseDetail> getFileCloseDetailsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getFileCloseDetailsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of file close details matching the UUID and company.
	 *
	 * @param uuid the UUID of the file close details
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching file close details, or an empty list if no matches were found
	 */
	public static List<FileCloseDetail> getFileCloseDetailsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCloseDetail> orderByComparator) {

		return getService().getFileCloseDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file close details.
	 *
	 * @return the number of file close details
	 */
	public static int getFileCloseDetailsCount() {
		return getService().getFileCloseDetailsCount();
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
	 * Updates the file close detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCloseDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCloseDetail the file close detail
	 * @return the file close detail that was updated
	 */
	public static FileCloseDetail updateFileCloseDetail(
		FileCloseDetail fileCloseDetail) {

		return getService().updateFileCloseDetail(fileCloseDetail);
	}

	public static FileCloseDetailLocalService getService() {
		return _service;
	}

	private static volatile FileCloseDetailLocalService _service;

}