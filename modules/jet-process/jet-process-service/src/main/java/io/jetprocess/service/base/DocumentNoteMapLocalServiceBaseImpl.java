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

package io.jetprocess.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import io.jetprocess.model.DocumentNoteMap;
import io.jetprocess.service.DocumentNoteMapLocalService;
import io.jetprocess.service.DocumentNoteMapLocalServiceUtil;
import io.jetprocess.service.persistence.DocFilePersistence;
import io.jetprocess.service.persistence.DocumentNoteMapPersistence;
import io.jetprocess.service.persistence.FileCloseDetailPersistence;
import io.jetprocess.service.persistence.FileCorrReceiptPersistence;
import io.jetprocess.service.persistence.FileMovementPersistence;
import io.jetprocess.service.persistence.FileNotePersistence;
import io.jetprocess.service.persistence.NoteDocMovementPersistence;
import io.jetprocess.service.persistence.NoteDocumentPersistence;
import io.jetprocess.service.persistence.NotePersistence;
import io.jetprocess.service.persistence.ReceiptCloseDetailPersistence;
import io.jetprocess.service.persistence.ReceiptMovementPersistence;
import io.jetprocess.service.persistence.ReceiptPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the document note map local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link io.jetprocess.service.impl.DocumentNoteMapLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.jetprocess.service.impl.DocumentNoteMapLocalServiceImpl
 * @generated
 */
public abstract class DocumentNoteMapLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DocumentNoteMapLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DocumentNoteMapLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DocumentNoteMapLocalServiceUtil</code>.
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DocumentNoteMap addDocumentNoteMap(DocumentNoteMap documentNoteMap) {
		documentNoteMap.setNew(true);

		return documentNoteMapPersistence.update(documentNoteMap);
	}

	/**
	 * Creates a new document note map with the primary key. Does not add the document note map to the database.
	 *
	 * @param documentNoteMapId the primary key for the new document note map
	 * @return the new document note map
	 */
	@Override
	@Transactional(enabled = false)
	public DocumentNoteMap createDocumentNoteMap(long documentNoteMapId) {
		return documentNoteMapPersistence.create(documentNoteMapId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DocumentNoteMap deleteDocumentNoteMap(long documentNoteMapId)
		throws PortalException {

		return documentNoteMapPersistence.remove(documentNoteMapId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DocumentNoteMap deleteDocumentNoteMap(
		DocumentNoteMap documentNoteMap) {

		return documentNoteMapPersistence.remove(documentNoteMap);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return documentNoteMapPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DocumentNoteMap.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return documentNoteMapPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return documentNoteMapPersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return documentNoteMapPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return documentNoteMapPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return documentNoteMapPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DocumentNoteMap fetchDocumentNoteMap(long documentNoteMapId) {
		return documentNoteMapPersistence.fetchByPrimaryKey(documentNoteMapId);
	}

	/**
	 * Returns the document note map matching the UUID and group.
	 *
	 * @param uuid the document note map's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchDocumentNoteMapByUuidAndGroupId(
		String uuid, long groupId) {

		return documentNoteMapPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the document note map with the primary key.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map
	 * @throws PortalException if a document note map with the primary key could not be found
	 */
	@Override
	public DocumentNoteMap getDocumentNoteMap(long documentNoteMapId)
		throws PortalException {

		return documentNoteMapPersistence.findByPrimaryKey(documentNoteMapId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(documentNoteMapLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DocumentNoteMap.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("documentNoteMapId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			documentNoteMapLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DocumentNoteMap.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"documentNoteMapId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(documentNoteMapLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DocumentNoteMap.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("documentNoteMapId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DocumentNoteMap>() {

				@Override
				public void performAction(DocumentNoteMap documentNoteMap)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, documentNoteMap);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(DocumentNoteMap.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return documentNoteMapPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return documentNoteMapLocalService.deleteDocumentNoteMap(
			(DocumentNoteMap)persistedModel);
	}

	@Override
	public BasePersistence<DocumentNoteMap> getBasePersistence() {
		return documentNoteMapPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return documentNoteMapPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the document note maps matching the UUID and company.
	 *
	 * @param uuid the UUID of the document note maps
	 * @param companyId the primary key of the company
	 * @return the matching document note maps, or an empty list if no matches were found
	 */
	@Override
	public List<DocumentNoteMap> getDocumentNoteMapsByUuidAndCompanyId(
		String uuid, long companyId) {

		return documentNoteMapPersistence.findByUuid_C(uuid, companyId);
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
	public List<DocumentNoteMap> getDocumentNoteMapsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return documentNoteMapPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public DocumentNoteMap getDocumentNoteMapByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return documentNoteMapPersistence.findByUUID_G(uuid, groupId);
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
	public List<DocumentNoteMap> getDocumentNoteMaps(int start, int end) {
		return documentNoteMapPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of document note maps.
	 *
	 * @return the number of document note maps
	 */
	@Override
	public int getDocumentNoteMapsCount() {
		return documentNoteMapPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DocumentNoteMap updateDocumentNoteMap(
		DocumentNoteMap documentNoteMap) {

		return documentNoteMapPersistence.update(documentNoteMap);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DocumentNoteMapLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		documentNoteMapLocalService = (DocumentNoteMapLocalService)aopProxy;

		_setLocalServiceUtilService(documentNoteMapLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DocumentNoteMapLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DocumentNoteMap.class;
	}

	protected String getModelClassName() {
		return DocumentNoteMap.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = documentNoteMapPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		DocumentNoteMapLocalService documentNoteMapLocalService) {

		try {
			Field field =
				DocumentNoteMapLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, documentNoteMapLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected DocFilePersistence docFilePersistence;

	protected DocumentNoteMapLocalService documentNoteMapLocalService;

	@Reference
	protected DocumentNoteMapPersistence documentNoteMapPersistence;

	@Reference
	protected FileCloseDetailPersistence fileCloseDetailPersistence;

	@Reference
	protected FileCorrReceiptPersistence fileCorrReceiptPersistence;

	@Reference
	protected FileMovementPersistence fileMovementPersistence;

	@Reference
	protected FileNotePersistence fileNotePersistence;

	@Reference
	protected NotePersistence notePersistence;

	@Reference
	protected NoteDocMovementPersistence noteDocMovementPersistence;

	@Reference
	protected NoteDocumentPersistence noteDocumentPersistence;

	@Reference
	protected ReceiptPersistence receiptPersistence;

	@Reference
	protected ReceiptCloseDetailPersistence receiptCloseDetailPersistence;

	@Reference
	protected ReceiptMovementPersistence receiptMovementPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.GroupLocalService
		groupLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}