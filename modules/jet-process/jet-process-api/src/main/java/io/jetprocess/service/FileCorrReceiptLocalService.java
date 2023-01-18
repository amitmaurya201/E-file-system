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

import io.jetprocess.model.FileCorrReceipt;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for FileCorrReceipt. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrReceiptLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FileCorrReceiptLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>io.jetprocess.service.impl.FileCorrReceiptLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the file corr receipt local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FileCorrReceiptLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the file corr receipt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrReceipt the file corr receipt
	 * @return the file corr receipt that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public FileCorrReceipt addFileCorrReceipt(FileCorrReceipt fileCorrReceipt);

	public void addReceiptInFile(
			long receiptId, long docFileId, long userPostId, String remark)
		throws PortalException;

	/**
	 * Creates a new file corr receipt with the primary key. Does not add the file corr receipt to the database.
	 *
	 * @param fileCorrReceiptId the primary key for the new file corr receipt
	 * @return the new file corr receipt
	 */
	@Transactional(enabled = false)
	public FileCorrReceipt createFileCorrReceipt(long fileCorrReceiptId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the file corr receipt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrReceipt the file corr receipt
	 * @return the file corr receipt that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public FileCorrReceipt deleteFileCorrReceipt(
		FileCorrReceipt fileCorrReceipt);

	/**
	 * Deletes the file corr receipt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt that was removed
	 * @throws PortalException if a file corr receipt with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public FileCorrReceipt deleteFileCorrReceipt(long fileCorrReceiptId)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrReceiptModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrReceiptModelImpl</code>.
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
	public FileCorrReceipt fetchFileCorrReceipt(long fileCorrReceiptId);

	/**
	 * Returns the file corr receipt matching the UUID and group.
	 *
	 * @param uuid the file corr receipt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FileCorrReceipt fetchFileCorrReceiptByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Returns the file corr receipt with the primary key.
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt
	 * @throws PortalException if a file corr receipt with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FileCorrReceipt getFileCorrReceipt(long fileCorrReceiptId)
		throws PortalException;

	/**
	 * Returns the file corr receipt matching the UUID and group.
	 *
	 * @param uuid the file corr receipt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file corr receipt
	 * @throws PortalException if a matching file corr receipt could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FileCorrReceipt getFileCorrReceiptByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the file corr receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of file corr receipts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileCorrReceipt> getFileCorrReceipts(int start, int end);

	/**
	 * Returns all the file corr receipts matching the UUID and company.
	 *
	 * @param uuid the UUID of the file corr receipts
	 * @param companyId the primary key of the company
	 * @return the matching file corr receipts, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileCorrReceipt> getFileCorrReceiptsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of file corr receipts matching the UUID and company.
	 *
	 * @param uuid the UUID of the file corr receipts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching file corr receipts, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileCorrReceipt> getFileCorrReceiptsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator);

	/**
	 * Returns the number of file corr receipts.
	 *
	 * @return the number of file corr receipts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFileCorrReceiptsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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

	/**
	 * Updates the file corr receipt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileCorrReceiptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileCorrReceipt the file corr receipt
	 * @return the file corr receipt that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public FileCorrReceipt updateFileCorrReceipt(
		FileCorrReceipt fileCorrReceipt);

}