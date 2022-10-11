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
 * Provides a wrapper for {@link DocFileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocFileLocalService
 * @generated
 */
public class DocFileLocalServiceWrapper
	implements DocFileLocalService, ServiceWrapper<DocFileLocalService> {

	public DocFileLocalServiceWrapper() {
		this(null);
	}

	public DocFileLocalServiceWrapper(DocFileLocalService docFileLocalService) {
		_docFileLocalService = docFileLocalService;
	}

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
	@Override
	public io.jetprocess.model.DocFile addDocFile(
		io.jetprocess.model.DocFile docFile) {

		return _docFileLocalService.addDocFile(docFile);
	}

	@Override
	public io.jetprocess.model.DocFile addDocFile(
			long groupId, String nature, String type, String subject,
			String category, String subCategory, String remarks,
			String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.addDocFile(
			groupId, nature, type, subject, category, subCategory, remarks,
			reference, serviceContext);
	}

	@Override
	public io.jetprocess.model.DocFile addDocFile(
			long groupId, String nature, String type, String fileNumber,
			String subject, String catagory, String subCategory, String remarks,
			String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.addDocFile(
			groupId, nature, type, fileNumber, subject, catagory, subCategory,
			remarks, reference, serviceContext);
	}

	/**
	 * Creates a new doc file with the primary key. Does not add the doc file to the database.
	 *
	 * @param docFileId the primary key for the new doc file
	 * @return the new doc file
	 */
	@Override
	public io.jetprocess.model.DocFile createDocFile(long docFileId) {
		return _docFileLocalService.createDocFile(docFileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.DocFile deleteDocFile(
		io.jetprocess.model.DocFile docFile) {

		return _docFileLocalService.deleteDocFile(docFile);
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
	@Override
	public io.jetprocess.model.DocFile deleteDocFile(long docFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.deleteDocFile(docFileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _docFileLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _docFileLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _docFileLocalService.dynamicQuery();
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

		return _docFileLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _docFileLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _docFileLocalService.dynamicQuery(
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

		return _docFileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _docFileLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.model.DocFile fetchDocFile(long docFileId) {
		return _docFileLocalService.fetchDocFile(docFileId);
	}

	/**
	 * Returns the doc file matching the UUID and group.
	 *
	 * @param uuid the doc file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public io.jetprocess.model.DocFile fetchDocFileByUuidAndGroupId(
		String uuid, long groupId) {

		return _docFileLocalService.fetchDocFileByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _docFileLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the doc file with the primary key.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file
	 * @throws PortalException if a doc file with the primary key could not be found
	 */
	@Override
	public io.jetprocess.model.DocFile getDocFile(long docFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.getDocFile(docFileId);
	}

	@Override
	public java.util.List<io.jetprocess.model.DocFile> getDocFileByGroupId(
		long groupId, int start, int end) {

		return _docFileLocalService.getDocFileByGroupId(groupId, start, end);
	}

	/**
	 * Returns the doc file matching the UUID and group.
	 *
	 * @param uuid the doc file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching doc file
	 * @throws PortalException if a matching doc file could not be found
	 */
	@Override
	public io.jetprocess.model.DocFile getDocFileByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.getDocFileByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<io.jetprocess.model.DocFile> getDocFiles(
		int start, int end) {

		return _docFileLocalService.getDocFiles(start, end);
	}

	/**
	 * Returns all the doc files matching the UUID and company.
	 *
	 * @param uuid the UUID of the doc files
	 * @param companyId the primary key of the company
	 * @return the matching doc files, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<io.jetprocess.model.DocFile>
		getDocFilesByUuidAndCompanyId(String uuid, long companyId) {

		return _docFileLocalService.getDocFilesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<io.jetprocess.model.DocFile>
		getDocFilesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<io.jetprocess.model.DocFile> orderByComparator) {

		return _docFileLocalService.getDocFilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of doc files.
	 *
	 * @return the number of doc files
	 */
	@Override
	public int getDocFilesCount() {
		return _docFileLocalService.getDocFilesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _docFileLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public String getGenerateFileNumber(io.jetprocess.model.DocFile docfile) {
		return _docFileLocalService.getGenerateFileNumber(docfile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _docFileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _docFileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public io.jetprocess.model.DocFile updateDocFile(
		io.jetprocess.model.DocFile docFile) {

		return _docFileLocalService.updateDocFile(docFile);
	}

	@Override
	public io.jetprocess.model.DocFile updateDocFile(
			long docFileId, String nature, String type, String subject,
			String fileNumber, String category, String subCategory,
			String remarks, String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileLocalService.updateDocFile(
			docFileId, nature, type, subject, fileNumber, category, subCategory,
			remarks, reference, serviceContext);
	}

	@Override
	public DocFileLocalService getWrappedService() {
		return _docFileLocalService;
	}

	@Override
	public void setWrappedService(DocFileLocalService docFileLocalService) {
		_docFileLocalService = docFileLocalService;
	}

	private DocFileLocalService _docFileLocalService;

}