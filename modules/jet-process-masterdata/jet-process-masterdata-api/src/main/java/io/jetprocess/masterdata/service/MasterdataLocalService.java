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

package io.jetprocess.masterdata.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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

import io.jetprocess.masterdata.model.FileCorrespondenceReceiptDTO;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Masterdata. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MasterdataLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MasterdataLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>io.jetprocess.masterdata.service.impl.MasterdataLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the masterdata local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MasterdataLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the masterdata to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdata the masterdata
	 * @return the masterdata that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Masterdata addMasterdata(Masterdata masterdata);

	/**
	 * Creates a new masterdata with the primary key. Does not add the masterdata to the database.
	 *
	 * @param masterdataId the primary key for the new masterdata
	 * @return the new masterdata
	 */
	@Transactional(enabled = false)
	public Masterdata createMasterdata(String masterdataId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the masterdata from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdata the masterdata
	 * @return the masterdata that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Masterdata deleteMasterdata(Masterdata masterdata);

	/**
	 * Deletes the masterdata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata that was removed
	 * @throws PortalException if a masterdata with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Masterdata deleteMasterdata(String masterdataId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.MasterdataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.MasterdataModelImpl</code>.
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
	public Masterdata fetchMasterdata(String masterdataId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getBasic(long basicHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getBasicHead();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getCategory();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getCategoryById(long categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getCountry();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getCountryById(long countryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getDeliveryModeById(long deliveryModeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getDeliveryModes();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getFile();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getFileById(long fileCodeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileCorrespondenceReceiptDTO>
		getFileCorrespondenceReceipteDetail(long fileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileMovementDTO> getFileMovementListByFileId(long fileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getLastActiveRmIdByReceiptId(long receiptId);

	/**
	 * Returns the masterdata with the primary key.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata
	 * @throws PortalException if a masterdata with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getMasterdata(String masterdataId) throws PortalException;

	/**
	 * Returns a range of all the masterdatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.MasterdataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of masterdatas
	 * @param end the upper bound of the range of masterdatas (not inclusive)
	 * @return the range of masterdatas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getMasterdatas(int start, int end);

	/**
	 * Returns the number of masterdatas.
	 *
	 * @return the number of masterdatas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMasterdatasCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaximumFmIdByFileIdData(long fileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaximumRmIdByReceiptId(long receiptId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMaxReceiptClosedId(long receiptId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getOrganizationById(long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getOrgranizations();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getPrimary(long primaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getPrimaryHead(long basicHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getReceiptCategory();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getReceiptCategoryById(long receiptCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovementDTO> getReceiptMovementListByReceiptId(
		long receiptId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovementDTO> getReceiptSentList(long userPostId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getReceiptSubCategory(long receiptCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getReceiptSubCategoryById(long receiptSubCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getSecondary(long secondaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getSecondaryHead(long primaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getStateById(long stateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getStates(long countryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getSubcategories(long categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getSubCategoryById(long subCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getSubOrganizationById(long subOrganizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getSubOrgranizations(long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getTeritaryHead(long seondaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getTertiary(long tertiaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getTypeById(long typeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getTypes();

	/**
	 * Updates the masterdata in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterdataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterdata the masterdata
	 * @return the masterdata that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Masterdata updateMasterdata(Masterdata masterdata);

}