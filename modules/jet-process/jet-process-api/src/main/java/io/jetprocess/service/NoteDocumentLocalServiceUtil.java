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

import io.jetprocess.model.NoteDocument;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for NoteDocument. This utility wraps
 * <code>io.jetprocess.service.impl.NoteDocumentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocumentLocalService
 * @generated
 */
public class NoteDocumentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.NoteDocumentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static NoteDocument addNoteDocument(NoteDocument noteDocument) {
		return getService().addNoteDocument(noteDocument);
	}

	public static NoteDocument addNoteDocument(
		String noteDocumentNumber, String subject, long createdBy,
		long subjectCategoryId) {

		return getService().addNoteDocument(
			noteDocumentNumber, subject, createdBy, subjectCategoryId);
	}

	/**
	 * Creates a new note document with the primary key. Does not add the note document to the database.
	 *
	 * @param noteDocumentId the primary key for the new note document
	 * @return the new note document
	 */
	public static NoteDocument createNoteDocument(long noteDocumentId) {
		return getService().createNoteDocument(noteDocumentId);
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
	public static NoteDocument deleteNoteDocument(long noteDocumentId)
		throws PortalException {

		return getService().deleteNoteDocument(noteDocumentId);
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
	public static NoteDocument deleteNoteDocument(NoteDocument noteDocument) {
		return getService().deleteNoteDocument(noteDocument);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocumentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocumentModelImpl</code>.
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

	public static NoteDocument fetchNoteDocument(long noteDocumentId) {
		return getService().fetchNoteDocument(noteDocumentId);
	}

	/**
	 * Returns the note document matching the UUID and group.
	 *
	 * @param uuid the note document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note document, or <code>null</code> if a matching note document could not be found
	 */
	public static NoteDocument fetchNoteDocumentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchNoteDocumentByUuidAndGroupId(uuid, groupId);
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
	 * Returns the note document with the primary key.
	 *
	 * @param noteDocumentId the primary key of the note document
	 * @return the note document
	 * @throws PortalException if a note document with the primary key could not be found
	 */
	public static NoteDocument getNoteDocument(long noteDocumentId)
		throws PortalException {

		return getService().getNoteDocument(noteDocumentId);
	}

	/**
	 * Returns the note document matching the UUID and group.
	 *
	 * @param uuid the note document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note document
	 * @throws PortalException if a matching note document could not be found
	 */
	public static NoteDocument getNoteDocumentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getNoteDocumentByUuidAndGroupId(uuid, groupId);
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
	public static List<NoteDocument> getNoteDocuments(int start, int end) {
		return getService().getNoteDocuments(start, end);
	}

	/**
	 * Returns all the note documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the note documents
	 * @param companyId the primary key of the company
	 * @return the matching note documents, or an empty list if no matches were found
	 */
	public static List<NoteDocument> getNoteDocumentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getNoteDocumentsByUuidAndCompanyId(uuid, companyId);
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
	public static List<NoteDocument> getNoteDocumentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NoteDocument> orderByComparator) {

		return getService().getNoteDocumentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of note documents.
	 *
	 * @return the number of note documents
	 */
	public static int getNoteDocumentsCount() {
		return getService().getNoteDocumentsCount();
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
	 * Updates the note document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocument the note document
	 * @return the note document that was updated
	 */
	public static NoteDocument updateNoteDocument(NoteDocument noteDocument) {
		return getService().updateNoteDocument(noteDocument);
	}

	public static NoteDocumentLocalService getService() {
		return _service;
	}

	private static volatile NoteDocumentLocalService _service;

}