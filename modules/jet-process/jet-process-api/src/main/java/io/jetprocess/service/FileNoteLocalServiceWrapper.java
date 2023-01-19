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
 * Provides a wrapper for {@link FileNoteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileNoteLocalService
 * @generated
 */
public class FileNoteLocalServiceWrapper
	implements FileNoteLocalService, ServiceWrapper<FileNoteLocalService> {

	public FileNoteLocalServiceWrapper() {
		this(null);
	}

	public FileNoteLocalServiceWrapper(
		FileNoteLocalService fileNoteLocalService) {

		_fileNoteLocalService = fileNoteLocalService;
	}

	/**
	 * Adds the file note to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileNoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileNote the file note
	 * @return the file note that was added
	 */
	@Override
	public io.jetprocess.model.FileNote addFileNote(
		io.jetprocess.model.FileNote fileNote) {

		return _fileNoteLocalService.addFileNote(fileNote);
	}

	@Override
	public io.jetprocess.model.FileNote createFileNote() {
		return _fileNoteLocalService.createFileNote();
	}

	/**
	 * Creates a new file note with the primary key. Does not add the file note to the database.
	 *
	 * @param fileNoteId the primary key for the new file note
	 * @return the new file note
	 */
	@Override
	public io.jetprocess.model.FileNote createFileNote(long fileNoteId) {
		return _fileNoteLocalService.createFileNote(fileNoteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileNoteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the file note from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileNoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileNote the file note
	 * @return the file note that was removed
	 */
	@Override
	public io.jetprocess.model.FileNote deleteFileNote(
		io.jetprocess.model.FileNote fileNote) {

		return _fileNoteLocalService.deleteFileNote(fileNote);
	}

	/**
	 * Deletes the file note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileNoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note that was removed
	 * @throws PortalException if a file note with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.FileNote deleteFileNote(long fileNoteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileNoteLocalService.deleteFileNote(fileNoteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileNoteLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fileNoteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fileNoteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fileNoteLocalService.dynamicQuery();
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

		return _fileNoteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileNoteModelImpl</code>.
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

		return _fileNoteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileNoteModelImpl</code>.
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

		return _fileNoteLocalService.dynamicQuery(
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

		return _fileNoteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fileNoteLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.FileNote fetchFileNote(long fileNoteId) {
		return _fileNoteLocalService.fetchFileNote(fileNoteId);
	}

	/**
	 * Returns the file note matching the UUID and group.
	 *
	 * @param uuid the file note's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public io.jetprocess.model.FileNote fetchFileNoteByUuidAndGroupId(
		String uuid, long groupId) {

		return _fileNoteLocalService.fetchFileNoteByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fileNoteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _fileNoteLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the file note with the primary key.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note
	 * @throws PortalException if a file note with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.FileNote getFileNote(long fileNoteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileNoteLocalService.getFileNote(fileNoteId);
	}

	/**
	 * Returns the file note matching the UUID and group.
	 *
	 * @param uuid the file note's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file note
	 * @throws PortalException if a matching file note could not be found
	 */
	@Override
	public io.jetprocess.model.FileNote getFileNoteByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileNoteLocalService.getFileNoteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the file notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of file notes
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileNote> getFileNotes(
		int start, int end) {

		return _fileNoteLocalService.getFileNotes(start, end);
	}

	/**
	 * Returns all the file notes matching the UUID and company.
	 *
	 * @param uuid the UUID of the file notes
	 * @param companyId the primary key of the company
	 * @return the matching file notes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileNote>
		getFileNotesByUuidAndCompanyId(String uuid, long companyId) {

		return _fileNoteLocalService.getFileNotesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of file notes matching the UUID and company.
	 *
	 * @param uuid the UUID of the file notes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching file notes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.FileNote>
		getFileNotesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.FileNote> orderByComparator) {

		return _fileNoteLocalService.getFileNotesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file notes.
	 *
	 * @return the number of file notes
	 */
	@Override
	public int getFileNotesCount() {
		return _fileNoteLocalService.getFileNotesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fileNoteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fileNoteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileNoteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the file note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileNoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileNote the file note
	 * @return the file note that was updated
	 */
	@Override
	public io.jetprocess.model.FileNote updateFileNote(
		io.jetprocess.model.FileNote fileNote) {

		return _fileNoteLocalService.updateFileNote(fileNote);
	}

	@Override
	public FileNoteLocalService getWrappedService() {
		return _fileNoteLocalService;
	}

	@Override
	public void setWrappedService(FileNoteLocalService fileNoteLocalService) {
		_fileNoteLocalService = fileNoteLocalService;
	}

	private FileNoteLocalService _fileNoteLocalService;

}