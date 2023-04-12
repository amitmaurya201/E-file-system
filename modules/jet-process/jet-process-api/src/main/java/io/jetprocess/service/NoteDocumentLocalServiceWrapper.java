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
 * Provides a wrapper for {@link NoteDocumentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocumentLocalService
 * @generated
 */
public class NoteDocumentLocalServiceWrapper
	implements NoteDocumentLocalService,
			   ServiceWrapper<NoteDocumentLocalService> {

	public NoteDocumentLocalServiceWrapper() {
		this(null);
	}

	public NoteDocumentLocalServiceWrapper(
		NoteDocumentLocalService noteDocumentLocalService) {

		_noteDocumentLocalService = noteDocumentLocalService;
	}

	/**
	 * Adds the note document to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocument the note document
	 * @return the note document that was added
	 */
	@Override
	public io.jetprocess.model.NoteDocument addNoteDocument(
		io.jetprocess.model.NoteDocument noteDocument) {

		return _noteDocumentLocalService.addNoteDocument(noteDocument);
	}

	@Override
	public io.jetprocess.model.DocumentNoteMap addNoteDocument(
		String noteSubject, long noteCategoryId, java.util.Date createdOn,
		String content, long createdBy) {

		return _noteDocumentLocalService.addNoteDocument(
			noteSubject, noteCategoryId, createdOn, content, createdBy);
	}

	/**
	 * Creates a new note document with the primary key. Does not add the note document to the database.
	 *
	 * @param noteDocumentId the primary key for the new note document
	 * @return the new note document
	 */
	@Override
	public io.jetprocess.model.NoteDocument createNoteDocument(
		long noteDocumentId) {

		return _noteDocumentLocalService.createNoteDocument(noteDocumentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocumentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the note document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocumentId the primary key of the note document
	 * @return the note document that was removed
	 * @throws PortalException if a note document with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.NoteDocument deleteNoteDocument(
			long noteDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocumentLocalService.deleteNoteDocument(noteDocumentId);
	}

	/**
	 * Deletes the note document from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocument the note document
	 * @return the note document that was removed
	 */
	@Override
	public io.jetprocess.model.NoteDocument deleteNoteDocument(
		io.jetprocess.model.NoteDocument noteDocument) {

		return _noteDocumentLocalService.deleteNoteDocument(noteDocument);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocumentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _noteDocumentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _noteDocumentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _noteDocumentLocalService.dynamicQuery();
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

		return _noteDocumentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocumentModelImpl</code>.
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

		return _noteDocumentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocumentModelImpl</code>.
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

		return _noteDocumentLocalService.dynamicQuery(
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

		return _noteDocumentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _noteDocumentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.NoteDocument fetchNoteDocument(
		long noteDocumentId) {

		return _noteDocumentLocalService.fetchNoteDocument(noteDocumentId);
	}

	/**
	 * Returns the note document matching the UUID and group.
	 *
	 * @param uuid the note document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note document, or <code>null</code> if a matching note document could not be found
	 */
	@Override
	public io.jetprocess.model.NoteDocument fetchNoteDocumentByUuidAndGroupId(
		String uuid, long groupId) {

		return _noteDocumentLocalService.fetchNoteDocumentByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public String generateNoteDocumentNumber(long noteDocumentId) {
		return _noteDocumentLocalService.generateNoteDocumentNumber(
			noteDocumentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _noteDocumentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _noteDocumentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _noteDocumentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the note document with the primary key.
	 *
	 * @param noteDocumentId the primary key of the note document
	 * @return the note document
	 * @throws PortalException if a note document with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.NoteDocument getNoteDocument(long noteDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocumentLocalService.getNoteDocument(noteDocumentId);
	}

	/**
	 * Returns the note document matching the UUID and group.
	 *
	 * @param uuid the note document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note document
	 * @throws PortalException if a matching note document could not be found
	 */
	@Override
	public io.jetprocess.model.NoteDocument getNoteDocumentByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocumentLocalService.getNoteDocumentByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the note documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of note documents
	 * @param end the upper bound of the range of note documents (not inclusive)
	 * @return the range of note documents
	 */
	@Override
	public java.util.List<io.jetprocess.model.NoteDocument> getNoteDocuments(
		int start, int end) {

		return _noteDocumentLocalService.getNoteDocuments(start, end);
	}

	/**
	 * Returns all the note documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the note documents
	 * @param companyId the primary key of the company
	 * @return the matching note documents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.NoteDocument>
		getNoteDocumentsByUuidAndCompanyId(String uuid, long companyId) {

		return _noteDocumentLocalService.getNoteDocumentsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of note documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the note documents
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of note documents
	 * @param end the upper bound of the range of note documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching note documents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.NoteDocument>
		getNoteDocumentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.NoteDocument> orderByComparator) {

		return _noteDocumentLocalService.getNoteDocumentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of note documents.
	 *
	 * @return the number of note documents
	 */
	@Override
	public int getNoteDocumentsCount() {
		return _noteDocumentLocalService.getNoteDocumentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _noteDocumentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public io.jetprocess.model.Note updateNoteDocument(
			long noteId, String content, long updatedby)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocumentLocalService.updateNoteDocument(
			noteId, content, updatedby);
	}

	/**
	 * Updates the note document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocument the note document
	 * @return the note document that was updated
	 */
	@Override
	public io.jetprocess.model.NoteDocument updateNoteDocument(
		io.jetprocess.model.NoteDocument noteDocument) {

		return _noteDocumentLocalService.updateNoteDocument(noteDocument);
	}

	@Override
	public NoteDocumentLocalService getWrappedService() {
		return _noteDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		NoteDocumentLocalService noteDocumentLocalService) {

		_noteDocumentLocalService = noteDocumentLocalService;
	}

	private NoteDocumentLocalService _noteDocumentLocalService;

}