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

import io.jetprocess.model.DocumentNoteMap;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DocumentNoteMap. This utility wraps
 * <code>io.jetprocess.service.impl.DocumentNoteMapLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentNoteMapLocalService
 * @generated
 */
public class DocumentNoteMapLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.DocumentNoteMapLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DocumentNoteMap addDocumentNoteMap(
		DocumentNoteMap documentNoteMap) {

		return getService().addDocumentNoteMap(documentNoteMap);
	}

	/**
	 * Creates a new document note map with the primary key. Does not add the document note map to the database.
	 *
	 * @param documentNoteMapId the primary key for the new document note map
	 * @return the new document note map
	 */
	public static DocumentNoteMap createDocumentNoteMap(
		long documentNoteMapId) {

		return getService().createDocumentNoteMap(documentNoteMapId);
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
	 * Deletes the document note map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentNoteMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentNoteMap the document note map
	 * @return the document note map that was removed
	 */
	public static DocumentNoteMap deleteDocumentNoteMap(
		DocumentNoteMap documentNoteMap) {

		return getService().deleteDocumentNoteMap(documentNoteMap);
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
	public static DocumentNoteMap deleteDocumentNoteMap(long documentNoteMapId)
		throws PortalException {

		return getService().deleteDocumentNoteMap(documentNoteMapId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.DocumentNoteMapModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.DocumentNoteMapModelImpl</code>.
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

	public static DocumentNoteMap fetchDocumentNoteMap(long documentNoteMapId) {
		return getService().fetchDocumentNoteMap(documentNoteMapId);
	}

	/**
	 * Returns the document note map matching the UUID and group.
	 *
	 * @param uuid the document note map's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	public static DocumentNoteMap fetchDocumentNoteMapByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDocumentNoteMapByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the document note map with the primary key.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map
	 * @throws PortalException if a document note map with the primary key could not be found
	 */
	public static DocumentNoteMap getDocumentNoteMap(long documentNoteMapId)
		throws PortalException {

		return getService().getDocumentNoteMap(documentNoteMapId);
	}

	/**
	 * Returns the document note map matching the UUID and group.
	 *
	 * @param uuid the document note map's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document note map
	 * @throws PortalException if a matching document note map could not be found
	 */
	public static DocumentNoteMap getDocumentNoteMapByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDocumentNoteMapByUuidAndGroupId(uuid, groupId);
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
	public static List<DocumentNoteMap> getDocumentNoteMaps(
		int start, int end) {

		return getService().getDocumentNoteMaps(start, end);
	}

	/**
	 * Returns all the document note maps matching the UUID and company.
	 *
	 * @param uuid the UUID of the document note maps
	 * @param companyId the primary key of the company
	 * @return the matching document note maps, or an empty list if no matches were found
	 */
	public static List<DocumentNoteMap> getDocumentNoteMapsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDocumentNoteMapsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<DocumentNoteMap> getDocumentNoteMapsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return getService().getDocumentNoteMapsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of document note maps.
	 *
	 * @return the number of document note maps
	 */
	public static int getDocumentNoteMapsCount() {
		return getService().getDocumentNoteMapsCount();
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
	 * Updates the document note map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentNoteMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentNoteMap the document note map
	 * @return the document note map that was updated
	 */
	public static DocumentNoteMap updateDocumentNoteMap(
		DocumentNoteMap documentNoteMap) {

		return getService().updateDocumentNoteMap(documentNoteMap);
	}

	public static DocumentNoteMapLocalService getService() {
		return _service;
	}

	private static volatile DocumentNoteMapLocalService _service;

}