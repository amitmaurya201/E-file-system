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
 * Provides a wrapper for {@link NoteDocMovementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocMovementLocalService
 * @generated
 */
public class NoteDocMovementLocalServiceWrapper
	implements NoteDocMovementLocalService,
			   ServiceWrapper<NoteDocMovementLocalService> {

	public NoteDocMovementLocalServiceWrapper() {
		this(null);
	}

	public NoteDocMovementLocalServiceWrapper(
		NoteDocMovementLocalService noteDocMovementLocalService) {

		_noteDocMovementLocalService = noteDocMovementLocalService;
	}

	/**
	 * Adds the note doc movement to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocMovement the note doc movement
	 * @return the note doc movement that was added
	 */
	@Override
	public io.jetprocess.model.NoteDocMovement addNoteDocMovement(
		io.jetprocess.model.NoteDocMovement noteDocMovement) {

		return _noteDocMovementLocalService.addNoteDocMovement(noteDocMovement);
	}

	/**
	 * Creates a new note doc movement with the primary key. Does not add the note doc movement to the database.
	 *
	 * @param movementId the primary key for the new note doc movement
	 * @return the new note doc movement
	 */
	@Override
	public io.jetprocess.model.NoteDocMovement createNoteDocMovement(
		long movementId) {

		return _noteDocMovementLocalService.createNoteDocMovement(movementId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocMovementLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the note doc movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement that was removed
	 * @throws PortalException if a note doc movement with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.NoteDocMovement deleteNoteDocMovement(
			long movementId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocMovementLocalService.deleteNoteDocMovement(movementId);
	}

	/**
	 * Deletes the note doc movement from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocMovement the note doc movement
	 * @return the note doc movement that was removed
	 */
	@Override
	public io.jetprocess.model.NoteDocMovement deleteNoteDocMovement(
		io.jetprocess.model.NoteDocMovement noteDocMovement) {

		return _noteDocMovementLocalService.deleteNoteDocMovement(
			noteDocMovement);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocMovementLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _noteDocMovementLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _noteDocMovementLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _noteDocMovementLocalService.dynamicQuery();
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

		return _noteDocMovementLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocMovementModelImpl</code>.
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

		return _noteDocMovementLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocMovementModelImpl</code>.
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

		return _noteDocMovementLocalService.dynamicQuery(
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

		return _noteDocMovementLocalService.dynamicQueryCount(dynamicQuery);
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

		return _noteDocMovementLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.NoteDocMovement fetchNoteDocMovement(
		long movementId) {

		return _noteDocMovementLocalService.fetchNoteDocMovement(movementId);
	}

	/**
	 * Returns the note doc movement matching the UUID and group.
	 *
	 * @param uuid the note doc movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	@Override
	public io.jetprocess.model.NoteDocMovement
		fetchNoteDocMovementByUuidAndGroupId(String uuid, long groupId) {

		return _noteDocMovementLocalService.
			fetchNoteDocMovementByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _noteDocMovementLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _noteDocMovementLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _noteDocMovementLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the note doc movement with the primary key.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement
	 * @throws PortalException if a note doc movement with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.NoteDocMovement getNoteDocMovement(
			long movementId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocMovementLocalService.getNoteDocMovement(movementId);
	}

	/**
	 * Returns the note doc movement matching the UUID and group.
	 *
	 * @param uuid the note doc movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note doc movement
	 * @throws PortalException if a matching note doc movement could not be found
	 */
	@Override
	public io.jetprocess.model.NoteDocMovement
			getNoteDocMovementByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocMovementLocalService.getNoteDocMovementByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the note doc movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @return the range of note doc movements
	 */
	@Override
	public java.util.List<io.jetprocess.model.NoteDocMovement>
		getNoteDocMovements(int start, int end) {

		return _noteDocMovementLocalService.getNoteDocMovements(start, end);
	}

	/**
	 * Returns all the note doc movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the note doc movements
	 * @param companyId the primary key of the company
	 * @return the matching note doc movements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.NoteDocMovement>
		getNoteDocMovementsByUuidAndCompanyId(String uuid, long companyId) {

		return _noteDocMovementLocalService.
			getNoteDocMovementsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of note doc movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the note doc movements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching note doc movements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.NoteDocMovement>
		getNoteDocMovementsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.NoteDocMovement> orderByComparator) {

		return _noteDocMovementLocalService.
			getNoteDocMovementsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of note doc movements.
	 *
	 * @return the number of note doc movements
	 */
	@Override
	public int getNoteDocMovementsCount() {
		return _noteDocMovementLocalService.getNoteDocMovementsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _noteDocMovementLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _noteDocMovementLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public io.jetprocess.model.NoteDocMovement saveNoteDocumentMovement(
		long receiverId, long senderId, long noteDocumentId, String remarks,
		boolean active) {

		return _noteDocMovementLocalService.saveNoteDocumentMovement(
			receiverId, senderId, noteDocumentId, remarks, active);
	}

	@Override
	public io.jetprocess.model.NoteDocMovement sendNoteDocumentMovement(
		long receiverId, long senderId, long noteDocumentId, String remarks) {

		return _noteDocMovementLocalService.sendNoteDocumentMovement(
			receiverId, senderId, noteDocumentId, remarks);
	}

	/**
	 * Updates the note doc movement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocMovement the note doc movement
	 * @return the note doc movement that was updated
	 */
	@Override
	public io.jetprocess.model.NoteDocMovement updateNoteDocMovement(
		io.jetprocess.model.NoteDocMovement noteDocMovement) {

		return _noteDocMovementLocalService.updateNoteDocMovement(
			noteDocMovement);
	}

	@Override
	public NoteDocMovementLocalService getWrappedService() {
		return _noteDocMovementLocalService;
	}

	@Override
	public void setWrappedService(
		NoteDocMovementLocalService noteDocMovementLocalService) {

		_noteDocMovementLocalService = noteDocMovementLocalService;
	}

	private NoteDocMovementLocalService _noteDocMovementLocalService;

}