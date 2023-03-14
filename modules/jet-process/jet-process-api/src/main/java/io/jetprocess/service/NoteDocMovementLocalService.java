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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import io.jetprocess.model.NoteDocMovement;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for NoteDocMovement. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see NoteDocMovementLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface NoteDocMovementLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>io.jetprocess.service.impl.NoteDocMovementLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the note doc movement local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link NoteDocMovementLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public NoteDocMovement addNoteDocMovement(NoteDocMovement noteDocMovement);

	/**
	 * Creates a new note doc movement with the primary key. Does not add the note doc movement to the database.
	 *
	 * @param movementId the primary key for the new note doc movement
	 * @return the new note doc movement
	 */
	@Transactional(enabled = false)
	public NoteDocMovement createNoteDocMovement(long movementId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public NoteDocMovement deleteNoteDocMovement(long movementId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public NoteDocMovement deleteNoteDocMovement(
		NoteDocMovement noteDocMovement);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NoteDocMovement fetchNoteDocMovement(long movementId);

	/**
	 * Returns the note doc movement matching the UUID and group.
	 *
	 * @param uuid the note doc movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NoteDocMovement fetchNoteDocMovementByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the note doc movement with the primary key.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement
	 * @throws PortalException if a note doc movement with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NoteDocMovement getNoteDocMovement(long movementId)
		throws PortalException;

	/**
	 * Returns the note doc movement matching the UUID and group.
	 *
	 * @param uuid the note doc movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching note doc movement
	 * @throws PortalException if a matching note doc movement could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NoteDocMovement getNoteDocMovementByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<NoteDocMovement> getNoteDocMovements(int start, int end);

	/**
	 * Returns all the note doc movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the note doc movements
	 * @param companyId the primary key of the company
	 * @return the matching note doc movements, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<NoteDocMovement> getNoteDocMovementsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<NoteDocMovement> getNoteDocMovementsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NoteDocMovement> orderByComparator);

	/**
	 * Returns the number of note doc movements.
	 *
	 * @return the number of note doc movements
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNoteDocMovementsCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public NoteDocMovement saveNoteDocumentMovement(
		long receiverId, long senderId, long noteDocumentId, String remarks,
		boolean active, long movementType);

	public NoteDocMovement sendNoteDocumentMovement(
		long receiverId, long senderId, long noteDocumentId, String remarks);

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
	@Indexable(type = IndexableType.REINDEX)
	public NoteDocMovement updateNoteDocMovement(
		NoteDocMovement noteDocMovement);

}