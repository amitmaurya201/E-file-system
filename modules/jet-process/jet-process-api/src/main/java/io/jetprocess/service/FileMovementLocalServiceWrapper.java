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
 * Provides a wrapper for {@link FileMovementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileMovementLocalService
 * @generated
 */
public class FileMovementLocalServiceWrapper
	implements FileMovementLocalService,
			   ServiceWrapper<FileMovementLocalService> {

	public FileMovementLocalServiceWrapper() {
		this(null);
	}

	public FileMovementLocalServiceWrapper(
		FileMovementLocalService fileMovementLocalService) {

		_fileMovementLocalService = fileMovementLocalService;
	}

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
	@Override
	public io.jetprocess.model.FileMovement addFileMovement(
		io.jetprocess.model.FileMovement fileMovement) {

		return _fileMovementLocalService.addFileMovement(fileMovement);
	}

	/**
	 * Creates a new file movement with the primary key. Does not add the file movement to the database.
	 *
	 * @param fmId the primary key for the new file movement
	 * @return the new file movement
	 */
	@Override
	public io.jetprocess.model.FileMovement createFileMovement(long fmId) {
		return _fileMovementLocalService.createFileMovement(fmId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.FileMovement deleteFileMovement(
		io.jetprocess.model.FileMovement fileMovement) {

		return _fileMovementLocalService.deleteFileMovement(fileMovement);
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
	@Override
	public io.jetprocess.model.FileMovement deleteFileMovement(long fmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.deleteFileMovement(fmId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fileMovementLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fileMovementLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fileMovementLocalService.dynamicQuery();
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

		return _fileMovementLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _fileMovementLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _fileMovementLocalService.dynamicQuery(
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

		return _fileMovementLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fileMovementLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.FileMovement fetchFileMovement(long fmId) {
		return _fileMovementLocalService.fetchFileMovement(fmId);
	}

	/**
	 * Returns the file movement matching the UUID and group.
	 *
	 * @param uuid the file movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public io.jetprocess.model.FileMovement fetchFileMovementByUuidAndGroupId(
		String uuid, long groupId) {

		return _fileMovementLocalService.fetchFileMovementByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fileMovementLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _fileMovementLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the file movement with the primary key.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement
	 * @throws PortalException if a file movement with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.FileMovement getFileMovement(long fmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.getFileMovement(fmId);
	}

	@Override
	public java.util.List<io.jetprocess.model.FileMovement>
		getFileMovementByFileId(long fileId) {

		return _fileMovementLocalService.getFileMovementByFileId(fileId);
	}

	@Override
	public io.jetprocess.model.FileMovement getFileMovementById(long fmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.getFileMovementById(fmId);
	}

	/**
	 * Returns the file movement matching the UUID and group.
	 *
	 * @param uuid the file movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file movement
	 * @throws PortalException if a matching file movement could not be found
	 */
	@Override
	public io.jetprocess.model.FileMovement getFileMovementByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.getFileMovementByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<io.jetprocess.model.FileMovement> getFileMovements(
		int start, int end) {

		return _fileMovementLocalService.getFileMovements(start, end);
	}

	/**
	 * Returns all the file movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the file movements
	 * @param companyId the primary key of the company
	 * @return the matching file movements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileMovement>
		getFileMovementsByUuidAndCompanyId(String uuid, long companyId) {

		return _fileMovementLocalService.getFileMovementsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<io.jetprocess.model.FileMovement>
		getFileMovementsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.FileMovement> orderByComparator) {

		return _fileMovementLocalService.getFileMovementsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file movements.
	 *
	 * @return the number of file movements
	 */
	@Override
	public int getFileMovementsCount() {
		return _fileMovementLocalService.getFileMovementsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fileMovementLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fileMovementLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public Boolean isActive(long docFileId) {
		return _fileMovementLocalService.isActive(docFileId);
	}

	@Override
	public void isActiveTrue(
			long docFileId, long userpost, long fileMovementId,
			String pullBackRemark, javax.portlet.ActionRequest actionRequest)
		throws com.liferay.portal.kernel.exception.PortalException {

		_fileMovementLocalService.isActiveTrue(
			docFileId, userpost, fileMovementId, pullBackRemark, actionRequest);
	}

	@Override
	public Boolean isPullBackAvailable(long fmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.isPullBackAvailable(fmId);
	}

	@Override
	public boolean pullBackedAlready(long fmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.pullBackedAlready(fmId);
	}

	@Override
	public io.jetprocess.model.FileMovement pullBackFileMovement(
			long fileId, long fileMovementId, String remarks)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.pullBackFileMovement(
			fileId, fileMovementId, remarks);
	}

	@Override
	public void saveFileMovement(
			long receiverId, long senderId, long fileId, String priority,
			java.util.Date dueDate, String remark, boolean active,
			int currentState, long movementType)
		throws com.liferay.portal.kernel.exception.PortalException {

		_fileMovementLocalService.saveFileMovement(
			receiverId, senderId, fileId, priority, dueDate, remark, active,
			currentState, movementType);
	}

	@Override
	public boolean saveReadMovement(long fileId, long fmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.saveReadMovement(fileId, fmId);
	}

	@Override
	public boolean saveReceiveMovement(long fileId, long fmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileMovementLocalService.saveReceiveMovement(fileId, fmId);
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
	 * @throws PortalException
	 */
	@Override
	public void saveSendFile(
			long receiverId, long senderId, long fileId, String priority,
			java.util.Date dueDate, String remark, boolean active,
			int currentState, long movementType, long fileMovementId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_fileMovementLocalService.saveSendFile(
			receiverId, senderId, fileId, priority, dueDate, remark, active,
			currentState, movementType, fileMovementId);
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
	@Override
	public io.jetprocess.model.FileMovement updateFileMovement(
		io.jetprocess.model.FileMovement fileMovement) {

		return _fileMovementLocalService.updateFileMovement(fileMovement);
	}

	@Override
	public FileMovementLocalService getWrappedService() {
		return _fileMovementLocalService;
	}

	@Override
	public void setWrappedService(
		FileMovementLocalService fileMovementLocalService) {

		_fileMovementLocalService = fileMovementLocalService;
	}

	private FileMovementLocalService _fileMovementLocalService;

}