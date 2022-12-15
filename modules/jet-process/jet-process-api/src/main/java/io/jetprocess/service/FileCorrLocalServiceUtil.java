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

import io.jetprocess.model.FileCorr;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FileCorr. This utility wraps
 * <code>io.jetprocess.service.impl.FileCorrLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrLocalService
 * @generated
 */
public class FileCorrLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.FileCorrLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the file corr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorr the file corr
	 * @return the file corr that was added
	 */
	public static FileCorr addFileCorr(FileCorr fileCorr) {
		return getService().addFileCorr(fileCorr);
	}

	/**
	 * Creates a new file corr with the primary key. Does not add the file corr to the database.
	 *
	 * @param fileCorrId the primary key for the new file corr
	 * @return the new file corr
	 */
	public static FileCorr createFileCorr(long fileCorrId) {
		return getService().createFileCorr(fileCorrId);
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
	 * Deletes the file corr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorr the file corr
	 * @return the file corr that was removed
	 */
	public static FileCorr deleteFileCorr(FileCorr fileCorr) {
		return getService().deleteFileCorr(fileCorr);
	}

	/**
	 * Deletes the file corr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr that was removed
	 * @throws PortalException if a file corr with the primary key could not be found
	 */
	public static FileCorr deleteFileCorr(long fileCorrId)
		throws PortalException {

		return getService().deleteFileCorr(fileCorrId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrModelImpl</code>.
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

	public static FileCorr fetchFileCorr(long fileCorrId) {
		return getService().fetchFileCorr(fileCorrId);
	}

	/**
	 * Returns the file corr matching the UUID and group.
	 *
	 * @param uuid the file corr's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	public static FileCorr fetchFileCorrByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFileCorrByUuidAndGroupId(uuid, groupId);
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
	 * Returns the file corr with the primary key.
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr
	 * @throws PortalException if a file corr with the primary key could not be found
	 */
	public static FileCorr getFileCorr(long fileCorrId) throws PortalException {
		return getService().getFileCorr(fileCorrId);
	}

	/**
	 * Returns the file corr matching the UUID and group.
	 *
	 * @param uuid the file corr's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file corr
	 * @throws PortalException if a matching file corr could not be found
	 */
	public static FileCorr getFileCorrByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFileCorrByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the file corrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @return the range of file corrs
	 */
	public static List<FileCorr> getFileCorrs(int start, int end) {
		return getService().getFileCorrs(start, end);
	}

	/**
	 * Returns all the file corrs matching the UUID and company.
	 *
	 * @param uuid the UUID of the file corrs
	 * @param companyId the primary key of the company
	 * @return the matching file corrs, or an empty list if no matches were found
	 */
	public static List<FileCorr> getFileCorrsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getFileCorrsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of file corrs matching the UUID and company.
	 *
	 * @param uuid the UUID of the file corrs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of file corrs
	 * @param end the upper bound of the range of file corrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching file corrs, or an empty list if no matches were found
	 */
	public static List<FileCorr> getFileCorrsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCorr> orderByComparator) {

		return getService().getFileCorrsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file corrs.
	 *
	 * @return the number of file corrs
	 */
	public static int getFileCorrsCount() {
		return getService().getFileCorrsCount();
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
	 * Updates the file corr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorr the file corr
	 * @return the file corr that was updated
	 */
	public static FileCorr updateFileCorr(FileCorr fileCorr) {
		return getService().updateFileCorr(fileCorr);
	}

	public static FileCorrLocalService getService() {
		return _service;
	}

	private static volatile FileCorrLocalService _service;

}