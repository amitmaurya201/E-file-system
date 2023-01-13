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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MasterdataService}.
 *
 * @author Brian Wing Shun Chan
 * @see MasterdataService
 * @generated
 */
public class MasterdataServiceWrapper
	implements MasterdataService, ServiceWrapper<MasterdataService> {

	public MasterdataServiceWrapper() {
		this(null);
	}

	public MasterdataServiceWrapper(MasterdataService masterdataService) {
		_masterdataService = masterdataService;
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getBasicHeadByIdMasterdata(
		long basicHeadId) {

		return _masterdataService.getBasicHeadByIdMasterdata(basicHeadId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getBasicHeadMasterdata() {

		return _masterdataService.getBasicHeadMasterdata();
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCategoryMasterdata() {

		return _masterdataService.getCategoryMasterdata();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getCategoryValueByIdMasterdata(long categoryId) {

		return _masterdataService.getCategoryValueByIdMasterdata(categoryId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCountriesMasterdata() {

		return _masterdataService.getCountriesMasterdata();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getCountryByIdMasterdata(
		long countryId) {

		return _masterdataService.getCountryByIdMasterdata(countryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getDeliveryModeByIdMasterdata(long deliveryModeId) {

		return _masterdataService.getDeliveryModeByIdMasterdata(deliveryModeId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getDeliveryModeMasterdata() {

		return _masterdataService.getDeliveryModeMasterdata();
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getFileCodeMasterdata() {

		return _masterdataService.getFileCodeMasterdata();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getFileCodeValueByIdMasterdata(long fileCodeId) {

		return _masterdataService.getFileCodeValueByIdMasterdata(fileCodeId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileMovementListByFileId(long fileId) {

		return _masterdataService.getFileMovementListByFileId(fileId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getOrganizationByIdMasterdata(long organizationId) {

		return _masterdataService.getOrganizationByIdMasterdata(organizationId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getOrganizationMasterdata() {

		return _masterdataService.getOrganizationMasterdata();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterdataService.getOSGiServiceIdentifier();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getPrimaryHeadByIdMasterdata(long primaryHeadId) {

		return _masterdataService.getPrimaryHeadByIdMasterdata(primaryHeadId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getPrimaryHeadMasterdata(long basicHeadId) {

		return _masterdataService.getPrimaryHeadMasterdata(basicHeadId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getReceiptCategoryByIdMasterdata(long receiptCategoryId) {

		return _masterdataService.getReceiptCategoryByIdMasterdata(
			receiptCategoryId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptCategoryMasterdata() {

		return _masterdataService.getReceiptCategoryMasterdata();
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.ReceiptMovementDTO>
		getReceiptMovementListByReceiptId(long receiptId) {

		return _masterdataService.getReceiptMovementListByReceiptId(receiptId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.ReceiptMovementDTO>
		getReceiptSentList(long userPostId) {

		return _masterdataService.getReceiptSentList(userPostId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getReceiptSubCategoryByIdMasterdata(long receiptSubCategoryId) {

		return _masterdataService.getReceiptSubCategoryByIdMasterdata(
			receiptSubCategoryId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptSubCategoryMasterdata(long receiptCategoryId) {

		return _masterdataService.getReceiptSubCategoryMasterdata(
			receiptCategoryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getSecondaryHeadByIdMasterdata(long secondaryHeadId) {

		return _masterdataService.getSecondaryHeadByIdMasterdata(
			secondaryHeadId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSecondaryHeadMasterdata(long primaryHeadId) {

		return _masterdataService.getSecondaryHeadMasterdata(primaryHeadId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getStateByIdMasterdata(
		long stateId) {

		return _masterdataService.getStateByIdMasterdata(stateId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getStatesMasterdata(long countryId) {

		return _masterdataService.getStatesMasterdata(countryId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubCategoryMasterdata(long categoryId) {

		return _masterdataService.getSubCategoryMasterdata(categoryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getSubCategoryValueByIdMasterdata(long subCategoryId) {

		return _masterdataService.getSubCategoryValueByIdMasterdata(
			subCategoryId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata
		getSubOrganizationByIdMasterdata(long subOrganizationId) {

		return _masterdataService.getSubOrganizationByIdMasterdata(
			subOrganizationId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubOrganizationMasterdata(long organizationId) {

		return _masterdataService.getSubOrganizationMasterdata(organizationId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTeritaryHeadMasterdata(long secondaryHeadId) {

		return _masterdataService.getTeritaryHeadMasterdata(secondaryHeadId);
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getTertiaryByIdMasterdata(
		long tertiaryHeadId) {

		return _masterdataService.getTertiaryByIdMasterdata(tertiaryHeadId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTypeMasterdata() {

		return _masterdataService.getTypeMasterdata();
	}

	@Override
	public io.jetprocess.masterdata.model.Masterdata getTypeValueByIdMasterdata(
		long typeId) {

		return _masterdataService.getTypeValueByIdMasterdata(typeId);
	}

	@Override
	public MasterdataService getWrappedService() {
		return _masterdataService;
	}

	@Override
	public void setWrappedService(MasterdataService masterdataService) {
		_masterdataService = masterdataService;
	}

	private MasterdataService _masterdataService;

}