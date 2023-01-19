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
 * Provides a wrapper for {@link NoteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NoteLocalService
 * @generated
 */
public class NoteLocalServiceWrapper
	implements NoteLocalService, ServiceWrapper<NoteLocalService> {

	public NoteLocalServiceWrapper() {
		this(null);
	}

	public NoteLocalServiceWrapper(NoteLocalService noteLocalService) {
		_noteLocalService = noteLocalService;
	}

	/**
	 * Adds the note to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param note the note
	 * @return the note that was added
	 */
	@Override
	public io.jetprocess.model.Note addNote(io.jetprocess.model.Note note) {
		return _noteLocalService.addNote(note);
	}

	@Override
	public io.jetprocess.model.Note addNote(
		String content, long createdBy, String signature, long fileId) {

		return _noteLocalService.addNote(content, createdBy, signature, fileId);
	}

	/**
	 * Creates a new note with the primary key. Does not add the note to the database.
	 *
	 * @param noteId the primary key for the new note
	 * @return the new note
	 */
	@Override
	public io.jetprocess.model.Note createNote(long noteId) {
		return _noteLocalService.createNote(noteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteId the primary key of the note
	 * @return the note that was removed
	 * @throws PortalException if a note with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.Note deleteNote(long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteLocalService.deleteNote(noteId);
	}

	/**
	 * Deletes the note from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param note the note
	 * @return the note that was removed
	 */
	@Override
	public io.jetprocess.model.Note deleteNote(io.jetprocess.model.Note note) {
		return _noteLocalService.deleteNote(note);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _noteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _noteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _noteLocalService.dynamicQuery();
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

		return _noteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteModelImpl</code>.
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

		return _noteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteModelImpl</code>.
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

		return _noteLocalService.dynamicQuery(
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

		return _noteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _noteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.Note editNote(
			long noteId, String content, String signature)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteLocalService.editNote(noteId, content, signature);
	}

	@Override
	public io.jetprocess.model.Note fetchNote(long noteId) {
		return _noteLocalService.fetchNote(noteId);
	}

	/**
	 * Returns the note matching the UUID and group.
	 *
	 * @param uuid the note's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public io.jetprocess.model.Note fetchNoteByUuidAndGroupId(
		String uuid, long groupId) {

		return _noteLocalService.fetchNoteByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _noteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _noteLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _noteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the note with the primary key.
	 *
	 * @param noteId the primary key of the note
	 * @return the note
	 * @throws PortalException if a note with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.Note getNote(long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteLocalService.getNote(noteId);
	}

	/**
	 * Returns the note matching the UUID and group.
	 *
	 * @param uuid the note's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note
	 * @throws PortalException if a matching note could not be found
	 */
	@Override
	public io.jetprocess.model.Note getNoteByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteLocalService.getNoteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of notes
	 */
	@Override
	public java.util.List<io.jetprocess.model.Note> getNotes(
		int start, int end) {

		return _noteLocalService.getNotes(start, end);
	}

	/**
	 * Returns all the notes matching the UUID and company.
	 *
	 * @param uuid the UUID of the notes
	 * @param companyId the primary key of the company
	 * @return the matching notes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.Note> getNotesByUuidAndCompanyId(
		String uuid, long companyId) {

		return _noteLocalService.getNotesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of notes matching the UUID and company.
	 *
	 * @param uuid the UUID of the notes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching notes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.Note> getNotesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<io.jetprocess.model.Note> orderByComparator) {

		return _noteLocalService.getNotesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of notes.
	 *
	 * @return the number of notes
	 */
	@Override
	public int getNotesCount() {
		return _noteLocalService.getNotesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _noteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param note the note
	 * @return the note that was updated
	 */
	@Override
	public io.jetprocess.model.Note updateNote(io.jetprocess.model.Note note) {
		return _noteLocalService.updateNote(note);
	}

	@Override
	public NoteLocalService getWrappedService() {
		return _noteLocalService;
	}

	@Override
	public void setWrappedService(NoteLocalService noteLocalService) {
		_noteLocalService = noteLocalService;
	}

	private NoteLocalService _noteLocalService;

}