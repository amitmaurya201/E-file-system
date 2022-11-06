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

import io.jetprocess.model.DocFile;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DocFile. This utility wraps
 * <code>io.jetprocess.service.impl.DocFileLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DocFileLocalService
 * @generated
 */
public class DocFileLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.DocFileLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the doc file to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param docFile the doc file
	 * @return the doc file that was added
	 */
	public static DocFile addDocFile(DocFile docFile) {
		return getService().addDocFile(docFile);
	}

	public static com.liferay.portal.kernel.json.JSONObject addDocFile(
			long groupId, String nature, String type, long basicHeadId,
			long primaryHeadId, long secondaryHeadId, long tertiaryHeadId,
			long year, long fileCodeId, String subject, String fileNumber,
			long categoryId, long subCategoryId, String remarks,
			String reference, long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDocFile(
			groupId, nature, type, basicHeadId, primaryHeadId, secondaryHeadId,
			tertiaryHeadId, year, fileCodeId, subject, fileNumber, categoryId,
			subCategoryId, remarks, reference, userPostId, serviceContext);
	}

	/**
	 * Creates a new doc file with the primary key. Does not add the doc file to the database.
	 *
	 * @param docFileId the primary key for the new doc file
	 * @return the new doc file
	 */
	public static DocFile createDocFile(long docFileId) {
		return getService().createDocFile(docFileId);
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
	 * Deletes the doc file from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param docFile the doc file
	 * @return the doc file that was removed
	 */
	public static DocFile deleteDocFile(DocFile docFile) {
		return getService().deleteDocFile(docFile);
	}

	/**
	 * Deletes the doc file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file that was removed
	 * @throws PortalException if a doc file with the primary key could not be found
	 */
	public static DocFile deleteDocFile(long docFileId) throws PortalException {
		return getService().deleteDocFile(docFileId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.DocFileModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.DocFileModelImpl</code>.
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

	public static DocFile fetchDocFile(long docFileId) {
		return getService().fetchDocFile(docFileId);
	}

	/**
	 * Returns the doc file matching the UUID and group.
	 *
	 * @param uuid the doc file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	public static DocFile fetchDocFileByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDocFileByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the doc file with the primary key.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file
	 * @throws PortalException if a doc file with the primary key could not be found
	 */
	public static DocFile getDocFile(long docFileId) throws PortalException {
		return getService().getDocFile(docFileId);
	}

	/**
	 * Returns the doc file matching the UUID and group.
	 *
	 * @param uuid the doc file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching doc file
	 * @throws PortalException if a matching doc file could not be found
	 */
	public static DocFile getDocFileByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getDocFileByUuidAndGroupId(uuid, groupId);
	}

	public static List<DocFile> getDocFileList() {
		return getService().getDocFileList();
	}

	/**
	 * Returns a range of all the doc files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of doc files
	 */
	public static List<DocFile> getDocFiles(int start, int end) {
		return getService().getDocFiles(start, end);
	}

	/**
	 * Returns all the doc files matching the UUID and company.
	 *
	 * @param uuid the UUID of the doc files
	 * @param companyId the primary key of the company
	 * @return the matching doc files, or an empty list if no matches were found
	 */
	public static List<DocFile> getDocFilesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDocFilesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of doc files matching the UUID and company.
	 *
	 * @param uuid the UUID of the doc files
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching doc files, or an empty list if no matches were found
	 */
	public static List<DocFile> getDocFilesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocFile> orderByComparator) {

		return getService().getDocFilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of doc files.
	 *
	 * @return the number of doc files
	 */
	public static int getDocFilesCount() {
		return getService().getDocFilesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static String getGenerateFileNumber(DocFile docfile) {
		return getService().getGenerateFileNumber(docfile);
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
	 * Updates the doc file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param docFile the doc file
	 * @return the doc file that was updated
	 */
	public static DocFile updateDocFile(DocFile docFile) {
		return getService().updateDocFile(docFile);
	}

	public static DocFile updateDocFile(
			long docFileId, String subject, long categoryId, long subCategoryId,
			String remarks, String reference, long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDocFile(
			docFileId, subject, categoryId, subCategoryId, remarks, reference,
			userPostId, serviceContext);
	}

	public static DocFileLocalService getService() {
		return _service;
	}

	private static volatile DocFileLocalService _service;

}