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
 * Provides a wrapper for {@link FileCorrLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrLocalService
 * @generated
 */
public class FileCorrLocalServiceWrapper
	implements FileCorrLocalService, ServiceWrapper<FileCorrLocalService> {

	public FileCorrLocalServiceWrapper() {
		this(null);
	}

	public FileCorrLocalServiceWrapper(
		FileCorrLocalService fileCorrLocalService) {

		_fileCorrLocalService = fileCorrLocalService;
	}

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
	@Override
	public io.jetprocess.model.FileCorr addFileCorr(
		io.jetprocess.model.FileCorr fileCorr) {

		return _fileCorrLocalService.addFileCorr(fileCorr);
	}

	/**
	 * Creates a new file corr with the primary key. Does not add the file corr to the database.
	 *
	 * @param fileCorrId the primary key for the new file corr
	 * @return the new file corr
	 */
	@Override
	public io.jetprocess.model.FileCorr createFileCorr(long fileCorrId) {
		return _fileCorrLocalService.createFileCorr(fileCorrId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.FileCorr deleteFileCorr(
		io.jetprocess.model.FileCorr fileCorr) {

		return _fileCorrLocalService.deleteFileCorr(fileCorr);
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
	@Override
	public io.jetprocess.model.FileCorr deleteFileCorr(long fileCorrId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrLocalService.deleteFileCorr(fileCorrId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fileCorrLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fileCorrLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fileCorrLocalService.dynamicQuery();
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

		return _fileCorrLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _fileCorrLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _fileCorrLocalService.dynamicQuery(
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

		return _fileCorrLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fileCorrLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.FileCorr fetchFileCorr(long fileCorrId) {
		return _fileCorrLocalService.fetchFileCorr(fileCorrId);
	}

	/**
	 * Returns the file corr matching the UUID and group.
	 *
	 * @param uuid the file corr's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file corr, or <code>null</code> if a matching file corr could not be found
	 */
	@Override
	public io.jetprocess.model.FileCorr fetchFileCorrByUuidAndGroupId(
		String uuid, long groupId) {

		return _fileCorrLocalService.fetchFileCorrByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fileCorrLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _fileCorrLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the file corr with the primary key.
	 *
	 * @param fileCorrId the primary key of the file corr
	 * @return the file corr
	 * @throws PortalException if a file corr with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.FileCorr getFileCorr(long fileCorrId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrLocalService.getFileCorr(fileCorrId);
	}

	/**
	 * Returns the file corr matching the UUID and group.
	 *
	 * @param uuid the file corr's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file corr
	 * @throws PortalException if a matching file corr could not be found
	 */
	@Override
	public io.jetprocess.model.FileCorr getFileCorrByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrLocalService.getFileCorrByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<io.jetprocess.model.FileCorr> getFileCorrs(
		int start, int end) {

		return _fileCorrLocalService.getFileCorrs(start, end);
	}

	/**
	 * Returns all the file corrs matching the UUID and company.
	 *
	 * @param uuid the UUID of the file corrs
	 * @param companyId the primary key of the company
	 * @return the matching file corrs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileCorr>
		getFileCorrsByUuidAndCompanyId(String uuid, long companyId) {

		return _fileCorrLocalService.getFileCorrsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<io.jetprocess.model.FileCorr>
		getFileCorrsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.FileCorr> orderByComparator) {

		return _fileCorrLocalService.getFileCorrsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file corrs.
	 *
	 * @return the number of file corrs
	 */
	@Override
	public int getFileCorrsCount() {
		return _fileCorrLocalService.getFileCorrsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fileCorrLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fileCorrLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCorrLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.FileCorr updateFileCorr(
		io.jetprocess.model.FileCorr fileCorr) {

		return _fileCorrLocalService.updateFileCorr(fileCorr);
	}

	@Override
	public FileCorrLocalService getWrappedService() {
		return _fileCorrLocalService;
	}

	@Override
	public void setWrappedService(FileCorrLocalService fileCorrLocalService) {
		_fileCorrLocalService = fileCorrLocalService;
	}

	private FileCorrLocalService _fileCorrLocalService;

}