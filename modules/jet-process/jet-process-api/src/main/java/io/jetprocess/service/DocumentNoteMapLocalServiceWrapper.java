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
 * Provides a wrapper for {@link DocumentNoteMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentNoteMapLocalService
 * @generated
 */
public class DocumentNoteMapLocalServiceWrapper
	implements DocumentNoteMapLocalService,
			   ServiceWrapper<DocumentNoteMapLocalService> {

	public DocumentNoteMapLocalServiceWrapper() {
		this(null);
	}

	public DocumentNoteMapLocalServiceWrapper(
		DocumentNoteMapLocalService documentNoteMapLocalService) {

		_documentNoteMapLocalService = documentNoteMapLocalService;
	}

	/**
	 * Adds the document note map to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentNoteMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentNoteMap the document note map
	 * @return the document note map that was added
	 */
	@Override
	public io.jetprocess.model.DocumentNoteMap addDocumentNoteMap(
		io.jetprocess.model.DocumentNoteMap documentNoteMap) {

		return _documentNoteMapLocalService.addDocumentNoteMap(documentNoteMap);
	}

	/**
	 * Creates a new document note map with the primary key. Does not add the document note map to the database.
	 *
	 * @param documentNoteMapId the primary key for the new document note map
	 * @return the new document note map
	 */
	@Override
	public io.jetprocess.model.DocumentNoteMap createDocumentNoteMap(
		long documentNoteMapId) {

		return _documentNoteMapLocalService.createDocumentNoteMap(
			documentNoteMapId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentNoteMapLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the document note map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentNoteMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentNoteMap the document note map
	 * @return the document note map that was removed
	 */
	@Override
	public io.jetprocess.model.DocumentNoteMap deleteDocumentNoteMap(
		io.jetprocess.model.DocumentNoteMap documentNoteMap) {

		return _documentNoteMapLocalService.deleteDocumentNoteMap(
			documentNoteMap);
	}

	/**
	 * Deletes the document note map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentNoteMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map that was removed
	 * @throws PortalException if a document note map with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.DocumentNoteMap deleteDocumentNoteMap(
			long documentNoteMapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentNoteMapLocalService.deleteDocumentNoteMap(
			documentNoteMapId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentNoteMapLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _documentNoteMapLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _documentNoteMapLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentNoteMapLocalService.dynamicQuery();
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

		return _documentNoteMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.DocumentNoteMapModelImpl</code>.
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

		return _documentNoteMapLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.DocumentNoteMapModelImpl</code>.
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

		return _documentNoteMapLocalService.dynamicQuery(
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

		return _documentNoteMapLocalService.dynamicQueryCount(dynamicQuery);
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

		return _documentNoteMapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.DocumentNoteMap fetchDocumentNoteMap(
		long documentNoteMapId) {

		return _documentNoteMapLocalService.fetchDocumentNoteMap(
			documentNoteMapId);
	}

	/**
	 * Returns the document note map matching the UUID and group.
	 *
	 * @param uuid the document note map's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public io.jetprocess.model.DocumentNoteMap
		fetchDocumentNoteMapByUuidAndGroupId(String uuid, long groupId) {

		return _documentNoteMapLocalService.
			fetchDocumentNoteMapByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _documentNoteMapLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the document note map with the primary key.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map
	 * @throws PortalException if a document note map with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.DocumentNoteMap getDocumentNoteMap(
			long documentNoteMapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentNoteMapLocalService.getDocumentNoteMap(
			documentNoteMapId);
	}

	@Override
	public io.jetprocess.model.DocumentNoteMap getDocumentNoteMapbyMovementId(
		long movementId) {

		return _documentNoteMapLocalService.getDocumentNoteMapbyMovementId(
			movementId);
	}

	/**
	 * Returns the document note map matching the UUID and group.
	 *
	 * @param uuid the document note map's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document note map
	 * @throws PortalException if a matching document note map could not be found
	 */
	@Override
	public io.jetprocess.model.DocumentNoteMap
			getDocumentNoteMapByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentNoteMapLocalService.getDocumentNoteMapByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of document note maps
	 */
	@Override
	public java.util.List<io.jetprocess.model.DocumentNoteMap>
		getDocumentNoteMaps(int start, int end) {

		return _documentNoteMapLocalService.getDocumentNoteMaps(start, end);
	}

	/**
	 * Returns all the document note maps matching the UUID and company.
	 *
	 * @param uuid the UUID of the document note maps
	 * @param companyId the primary key of the company
	 * @return the matching document note maps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.DocumentNoteMap>
		getDocumentNoteMapsByUuidAndCompanyId(String uuid, long companyId) {

		return _documentNoteMapLocalService.
			getDocumentNoteMapsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of document note maps matching the UUID and company.
	 *
	 * @param uuid the UUID of the document note maps
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching document note maps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.DocumentNoteMap>
		getDocumentNoteMapsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.DocumentNoteMap> orderByComparator) {

		return _documentNoteMapLocalService.
			getDocumentNoteMapsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of document note maps.
	 *
	 * @return the number of document note maps
	 */
	@Override
	public int getDocumentNoteMapsCount() {
		return _documentNoteMapLocalService.getDocumentNoteMapsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _documentNoteMapLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _documentNoteMapLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentNoteMapLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentNoteMapLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public io.jetprocess.model.DocumentNoteMap saveDocumentNoteMap(
		long noteDocumentId, long noteId, long movementId) {

		return _documentNoteMapLocalService.saveDocumentNoteMap(
			noteDocumentId, noteId, movementId);
	}

	/**
	 * Updates the document note map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentNoteMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentNoteMap the document note map
	 * @return the document note map that was updated
	 */
	@Override
	public io.jetprocess.model.DocumentNoteMap updateDocumentNoteMap(
		io.jetprocess.model.DocumentNoteMap documentNoteMap) {

		return _documentNoteMapLocalService.updateDocumentNoteMap(
			documentNoteMap);
	}

	@Override
	public DocumentNoteMapLocalService getWrappedService() {
		return _documentNoteMapLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentNoteMapLocalService documentNoteMapLocalService) {

		_documentNoteMapLocalService = documentNoteMapLocalService;
	}

	private DocumentNoteMapLocalService _documentNoteMapLocalService;

}