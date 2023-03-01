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
 * Provides a wrapper for {@link FileCloseDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileCloseDetailLocalService
 * @generated
 */
public class FileCloseDetailLocalServiceWrapper
	implements FileCloseDetailLocalService,
			   ServiceWrapper<FileCloseDetailLocalService> {

	public FileCloseDetailLocalServiceWrapper() {
		this(null);
	}

	public FileCloseDetailLocalServiceWrapper(
		FileCloseDetailLocalService fileCloseDetailLocalService) {

		_fileCloseDetailLocalService = fileCloseDetailLocalService;
	}

	@Override
	public io.jetprocess.model.FileCloseDetail addCloseFileDetail(
			long fileId, long closedBy, String closingRemarks,
			long closingMovementId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCloseDetailLocalService.addCloseFileDetail(
			fileId, closedBy, closingRemarks, closingMovementId);
	}

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
	@Override
	public io.jetprocess.model.FileCloseDetail addFileCloseDetail(
		io.jetprocess.model.FileCloseDetail fileCloseDetail) {

		return _fileCloseDetailLocalService.addFileCloseDetail(fileCloseDetail);
	}

	/**
	 * Creates a new file close detail with the primary key. Does not add the file close detail to the database.
	 *
	 * @param fileClosedId the primary key for the new file close detail
	 * @return the new file close detail
	 */
	@Override
	public io.jetprocess.model.FileCloseDetail createFileCloseDetail(
		long fileClosedId) {

		return _fileCloseDetailLocalService.createFileCloseDetail(fileClosedId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCloseDetailLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.FileCloseDetail deleteFileCloseDetail(
		io.jetprocess.model.FileCloseDetail fileCloseDetail) {

		return _fileCloseDetailLocalService.deleteFileCloseDetail(
			fileCloseDetail);
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
	@Override
	public io.jetprocess.model.FileCloseDetail deleteFileCloseDetail(
			long fileClosedId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCloseDetailLocalService.deleteFileCloseDetail(fileClosedId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCloseDetailLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fileCloseDetailLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fileCloseDetailLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fileCloseDetailLocalService.dynamicQuery();
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

		return _fileCloseDetailLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _fileCloseDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _fileCloseDetailLocalService.dynamicQuery(
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

		return _fileCloseDetailLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fileCloseDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.FileCloseDetail fetchFileCloseDetail(
		long fileClosedId) {

		return _fileCloseDetailLocalService.fetchFileCloseDetail(fileClosedId);
	}

	/**
	 * Returns the file close detail matching the UUID and group.
	 *
	 * @param uuid the file close detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	@Override
	public io.jetprocess.model.FileCloseDetail
		fetchFileCloseDetailByUuidAndGroupId(String uuid, long groupId) {

		return _fileCloseDetailLocalService.
			fetchFileCloseDetailByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fileCloseDetailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _fileCloseDetailLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the file close detail with the primary key.
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail
	 * @throws PortalException if a file close detail with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.FileCloseDetail getFileCloseDetail(
			long fileClosedId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCloseDetailLocalService.getFileCloseDetail(fileClosedId);
	}

	/**
	 * Returns the file close detail matching the UUID and group.
	 *
	 * @param uuid the file close detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file close detail
	 * @throws PortalException if a matching file close detail could not be found
	 */
	@Override
	public io.jetprocess.model.FileCloseDetail
			getFileCloseDetailByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCloseDetailLocalService.getFileCloseDetailByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<io.jetprocess.model.FileCloseDetail>
		getFileCloseDetails(int start, int end) {

		return _fileCloseDetailLocalService.getFileCloseDetails(start, end);
	}

	/**
	 * Returns all the file close details matching the UUID and company.
	 *
	 * @param uuid the UUID of the file close details
	 * @param companyId the primary key of the company
	 * @return the matching file close details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileCloseDetail>
		getFileCloseDetailsByUuidAndCompanyId(String uuid, long companyId) {

		return _fileCloseDetailLocalService.
			getFileCloseDetailsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<io.jetprocess.model.FileCloseDetail>
		getFileCloseDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.FileCloseDetail> orderByComparator) {

		return _fileCloseDetailLocalService.
			getFileCloseDetailsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file close details.
	 *
	 * @return the number of file close details
	 */
	@Override
	public int getFileCloseDetailsCount() {
		return _fileCloseDetailLocalService.getFileCloseDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fileCloseDetailLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fileCloseDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileCloseDetailLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.FileCloseDetail updateFileCloseDetail(
		io.jetprocess.model.FileCloseDetail fileCloseDetail) {

		return _fileCloseDetailLocalService.updateFileCloseDetail(
			fileCloseDetail);
	}

	@Override
	public FileCloseDetailLocalService getWrappedService() {
		return _fileCloseDetailLocalService;
	}

	@Override
	public void setWrappedService(
		FileCloseDetailLocalService fileCloseDetailLocalService) {

		_fileCloseDetailLocalService = fileCloseDetailLocalService;
	}

	private FileCloseDetailLocalService _fileCloseDetailLocalService;

}