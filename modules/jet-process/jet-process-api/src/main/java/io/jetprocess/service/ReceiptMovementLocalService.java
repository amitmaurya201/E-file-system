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

import io.jetprocess.model.ReceiptMovement;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ReceiptMovement. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptMovementLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ReceiptMovementLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>io.jetprocess.service.impl.ReceiptMovementLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the receipt movement local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ReceiptMovementLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the receipt movement to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptMovement the receipt movement
	 * @return the receipt movement that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ReceiptMovement addReceiptMovement(ReceiptMovement receiptMovement);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new receipt movement with the primary key. Does not add the receipt movement to the database.
	 *
	 * @param rmId the primary key for the new receipt movement
	 * @return the new receipt movement
	 */
	@Transactional(enabled = false)
	public ReceiptMovement createReceiptMovement(long rmId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the receipt movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement that was removed
	 * @throws PortalException if a receipt movement with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ReceiptMovement deleteReceiptMovement(long rmId)
		throws PortalException;

	/**
	 * Deletes the receipt movement from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptMovement the receipt movement
	 * @return the receipt movement that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ReceiptMovement deleteReceiptMovement(
		ReceiptMovement receiptMovement);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptMovementModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptMovementModelImpl</code>.
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
	public ReceiptMovement fetchReceiptMovement(long rmId);

	/**
	 * Returns the receipt movement matching the UUID and group.
	 *
	 * @param uuid the receipt movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ReceiptMovement fetchReceiptMovementByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

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
	 * Returns the receipt movement with the primary key.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement
	 * @throws PortalException if a receipt movement with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ReceiptMovement getReceiptMovement(long rmId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovement> getReceiptMovementByFileMovementId(
		long fileMovementId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovement> getReceiptMovementByReceiptId(long receiptId);

	/**
	 * Returns the receipt movement matching the UUID and group.
	 *
	 * @param uuid the receipt movement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching receipt movement
	 * @throws PortalException if a matching receipt movement could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ReceiptMovement getReceiptMovementByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the receipt movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.model.impl.ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of receipt movements
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovement> getReceiptMovements(int start, int end);

	/**
	 * Returns all the receipt movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipt movements
	 * @param companyId the primary key of the company
	 * @return the matching receipt movements, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovement> getReceiptMovementsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of receipt movements matching the UUID and company.
	 *
	 * @param uuid the UUID of the receipt movements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching receipt movements, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovement> getReceiptMovementsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator);

	/**
	 * Returns the number of receipt movements.
	 *
	 * @return the number of receipt movements
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getReceiptMovementsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Boolean isActive(long receiptId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Boolean isPullBackAvailable(long rmId);

	public boolean pullBackedAlready(long rmId) throws PortalException;

	public void pullBackReceiptMovement(
			long receiptId, long receiptMovementId, String remarks,
			long userPostId)
		throws PortalException;

	public void pullBackReceiptsAttatchWithFile(
		List<ReceiptMovement> receiptMovementList, long fileMovementId);

	public boolean saveReadMovement(long receiptId, long rmId);

	public boolean saveReceiveMovement(long receiptId, long rmId);

	public void saveSendReceipt(
			long receiverId, long senderId, long receiptId, String priority,
			String dueDate, String remark)
		throws PortalException;

	/**
	 * Updates the receipt movement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReceiptMovementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param receiptMovement the receipt movement
	 * @return the receipt movement that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ReceiptMovement updateReceiptMovement(
		ReceiptMovement receiptMovement);

}