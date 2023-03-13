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

import io.jetprocess.model.NoteDocMovement;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for NoteDocMovement. This utility wraps
 * <code>io.jetprocess.service.impl.NoteDocMovementLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocMovementLocalService
 * @generated
 */
public class NoteDocMovementLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.NoteDocMovementLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static NoteDocMovement addNoteDocMovement(
		NoteDocMovement noteDocMovement) {

		return getService().addNoteDocMovement(noteDocMovement);
	}

	/**
	 * Creates a new note doc movement with the primary key. Does not add the note doc movement to the database.
	 *
	 * @param movementId the primary key for the new note doc movement
	 * @return the new note doc movement
	 */
	public static NoteDocMovement createNoteDocMovement(long movementId) {
		return getService().createNoteDocMovement(movementId);
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
	public static NoteDocMovement deleteNoteDocMovement(long movementId)
		throws PortalException {

		return getService().deleteNoteDocMovement(movementId);
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
	public static NoteDocMovement deleteNoteDocMovement(
		NoteDocMovement noteDocMovement) {

		return getService().deleteNoteDocMovement(noteDocMovement);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocMovementModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.NoteDocMovementModelImpl</code>.
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

	public static NoteDocMovement fetchNoteDocMovement(long movementId) {
		return getService().fetchNoteDocMovement(movementId);
	}

	/**
	 * Returns the note doc movement matching the UUID and group.
	 *
	 * @param uuid the note doc movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	public static NoteDocMovement fetchNoteDocMovementByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchNoteDocMovementByUuidAndGroupId(uuid, groupId);
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
	 * Returns the note doc movement with the primary key.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement
	 * @throws PortalException if a note doc movement with the primary key could not be found
	 */
	public static NoteDocMovement getNoteDocMovement(long movementId)
		throws PortalException {

		return getService().getNoteDocMovement(movementId);
	}

	/**
	 * Returns the note doc movement matching the UUID and group.
	 *
	 * @param uuid the note doc movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note doc movement
	 * @throws PortalException if a matching note doc movement could not be found
	 */
	public static NoteDocMovement getNoteDocMovementByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getNoteDocMovementByUuidAndGroupId(uuid, groupId);
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
	public static List<NoteDocMovement> getNoteDocMovements(
		int start, int end) {

		return getService().getNoteDocMovements(start, end);
	}

	/**
	 * Returns all the note doc movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the note doc movements
	 * @param companyId the primary key of the company
	 * @return the matching note doc movements, or an empty list if no matches were found
	 */
	public static List<NoteDocMovement> getNoteDocMovementsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getNoteDocMovementsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<NoteDocMovement> getNoteDocMovementsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NoteDocMovement> orderByComparator) {

		return getService().getNoteDocMovementsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of note doc movements.
	 *
	 * @return the number of note doc movements
	 */
	public static int getNoteDocMovementsCount() {
		return getService().getNoteDocMovementsCount();
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
	 * Updates the note doc movement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NoteDocMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteDocMovement the note doc movement
	 * @return the note doc movement that was updated
	 */
	public static NoteDocMovement updateNoteDocMovement(
		NoteDocMovement noteDocMovement) {

		return getService().updateNoteDocMovement(noteDocMovement);
	}

	public static NoteDocMovementLocalService getService() {
		return _service;
	}

	private static volatile NoteDocMovementLocalService _service;

}