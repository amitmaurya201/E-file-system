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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.ReceiptListViewDto;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Masterdata. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MasterdataServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MasterdataService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>io.jetprocess.masterdata.service.impl.MasterdataServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the masterdata remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MasterdataServiceUtil} if injection and service tracking are not available.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getBasicHeadByIdMasterdata(long basicHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getBasicHeadMasterdata();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getCategoryMasterdata();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getCategoryValueByIdMasterdata(long categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getCountriesMasterdata();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getCountryByIdMasterdata(long countryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getDeliveryModeByIdMasterdata(long deliveryModeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getDeliveryModeMasterdata();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getFileCodeMasterdata();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getFileCodeValueByIdMasterdata(long fileCodeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptListViewDto> getFileCorrespondenceReceipt(long fileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileListViewDto> getFileCreatedListMasterdata(long userPostId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileMovementDTO> getFileInboxList(long userPostId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileMovementDTO> getFileMovementListByFileId(long fileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FileMovementDTO> getFileSentListByUserPostId(long userPostId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getOrganizationByIdMasterdata(long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getOrganizationMasterdata();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getPrimaryHeadByIdMasterdata(long primaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getPrimaryHeadMasterdata(long basicHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getReceiptCategoryByIdMasterdata(long receiptCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getReceiptCategoryMasterdata();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptListViewDto> getReceiptListMasterdata(long userPostId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovementDTO> getReceiptMovementListByReceiptId(
		long receiptId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ReceiptMovementDTO> getReceiptSentList(long userPostId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getReceiptSubCategoryByIdMasterdata(
		long receiptSubCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getReceiptSubCategoryMasterdata(
		long receiptCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getSecondaryHeadByIdMasterdata(long secondaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getSecondaryHeadMasterdata(long primaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getStateByIdMasterdata(long stateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getStatesMasterdata(long countryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getSubCategoryMasterdata(long categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getSubCategoryValueByIdMasterdata(long subCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getSubOrganizationByIdMasterdata(long subOrganizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getSubOrganizationMasterdata(long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getTeritaryHeadMasterdata(long secondaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getTertiaryByIdMasterdata(long tertiaryHeadId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Masterdata> getTypeMasterdata();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Masterdata getTypeValueByIdMasterdata(long typeId);

}