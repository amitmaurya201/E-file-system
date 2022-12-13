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

package io.jetprocess.masterdata.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.ReceiptListViewDto;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.service.base.MasterdataServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=masterdata",
		"json.web.service.context.path=Masterdata" }, service = AopService.class)
public class MasterdataServiceImpl extends MasterdataServiceBaseImpl {
	
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId) {

		return masterdataLocalService.getReceiptInboxList(userPostId);
	}
	
	public List<Masterdata> getCategoryMasterdata() {

		return masterdataLocalService.getCategory();
	}

	public List<Masterdata> getSubCategoryMasterdata(long categoryId) {

		return masterdataLocalService.getSubcategories(categoryId);
	}

	public List<Masterdata> getTypeMasterdata() {

		return masterdataLocalService.getTypes();
	}

	public List<Masterdata> getDeliveryModeMasterdata() {

		return masterdataLocalService.getDeliveryModes();
	}

	public List<Masterdata> getFileCodeMasterdata() {

		return masterdataLocalService.getFile();
	}

	public List<Masterdata> getBasicHeadMasterdata() {

		return masterdataLocalService.getBasicHead();
	}

	public List<Masterdata> getPrimaryHeadMasterdata(long basicHeadId) {

		return masterdataLocalService.getPrimaryHead(basicHeadId);
	}

	public List<Masterdata> getSecondaryHeadMasterdata(long primaryHeadId) {

		return masterdataLocalService.getSecondaryHead(primaryHeadId);
	}

	public List<Masterdata> getTeritaryHeadMasterdata(long secondaryHeadId) {

		return masterdataLocalService.getSecondaryHead(secondaryHeadId);
	}

	public List<Masterdata> getOrganizationMasterdata() {

		return masterdataLocalService.getOrgranizations();
	}

	public List<Masterdata> getSubOrganizationMasterdata(long organizationId) {

		return masterdataLocalService.getSubOrgranizations(organizationId);
	}

	public List<Masterdata> getReceiptCategoryMasterdata() {

		return masterdataLocalService.getReceiptCategory();
	}

	public List<Masterdata> getReceiptSubCategoryMasterdata(long receiptCategoryId) {

		return masterdataLocalService.getReceiptSubCategory(receiptCategoryId);
	}

	public List<Masterdata> getCountriesMasterdata() {

		return masterdataLocalService.getCountry();
	}

	public List<Masterdata> getStatesMasterdata(long countryId) {
		return masterdataLocalService.getStates(countryId);
	}

	public Masterdata getBasicHeadByIdMasterdata(long basicHeadId) {

		return masterdataLocalService.getBasic(basicHeadId);
	}

	public Masterdata getPrimaryHeadByIdMasterdata(long primaryHeadId) {

		return masterdataLocalService.getPrimary(primaryHeadId);
	}

	public Masterdata getSecondaryHeadByIdMasterdata(long secondaryHeadId) {

		return masterdataLocalService.getSecondary(secondaryHeadId);
	}

	public Masterdata getTertiaryByIdMasterdata(long tertiaryHeadId) {

		return masterdataLocalService.getTertiary(tertiaryHeadId);
	}

	public List<FileListViewDto> getFileCreatedListMasterdata(long userPostId) {

		return masterdataLocalService.getFileList(userPostId);
	}

	public List<ReceiptListViewDto> getReceiptListMasterdata(long userPostId) {

		return masterdataLocalService.getReceiptList(userPostId);
	}
public Masterdata getFileCodeValueByIdMasterdata(long fileCodeId) {
		
		return masterdataLocalService.getFileById(fileCodeId);
		
	}
	public Masterdata getCategoryValueByIdMasterdata(long categoryId) {
		
		return masterdataLocalService.getCategoryById(categoryId);
		
	}
	public Masterdata getSubCategoryValueByIdMasterdata(long subCategoryId) {
		
		return masterdataLocalService.getSubCategoryById(subCategoryId);
	}
	public Masterdata getTypeValueByIdMasterdata(long typeId) {
	
		return masterdataLocalService.getTypeById(typeId);
	}
    public Masterdata getDeliveryModeByIdMasterdata(long deliveryModeId) {
    	
    	return masterdataLocalService.getDeliveryModeById(deliveryModeId);
    }
    public Masterdata getOrganizationByIdMasterdata(long organizationId) {
    	
    	return masterdataLocalService.getOrganizationById(organizationId);
    }
    public Masterdata getSubOrganizationByIdMasterdata(long subOrganizationId) {
    	
    	return masterdataLocalService.getSubOrganizationById(subOrganizationId);
    }
    public Masterdata getCountryByIdMasterdata(long countryId) {
    	
    	return masterdataLocalService.getCountryById(countryId);
    }
    public Masterdata getStateByIdMasterdata(long stateId) {
    	
    	return masterdataLocalService.getStateById(stateId);
    }
    public Masterdata getReceiptCategoryByIdMasterdata(long receiptCategoryId) {
    	
    	return masterdataLocalService.getReceiptCategoryById(receiptCategoryId);
    }
    public Masterdata getReceiptSubCategoryByIdMasterdata(long receiptSubCategoryId) {
    	
    	return masterdataLocalService.getReceiptSubCategoryById(receiptSubCategoryId);
    }
    public  List<ReceiptMovementDTO> getReceiptMovementListByReceiptId(long receiptId){
		return masterdataLocalService.getReceiptMovementListByReceiptId(receiptId);
	}
    public  List<FileMovementDTO> getFileMovementListByFileId(long fileId){
    	return masterdataLocalService.getFileMovementListByFileId(fileId);
    }

    public List<FileMovementDTO> getFileInboxList(long userPostId){
		
		return masterdataFinder.getFileInboxList(userPostId);
	}
    
    public List<ReceiptMovementDTO> getReceiptSentList(long userPostId) {
		return masterdataLocalService.getReceiptSentList(userPostId) ;
		
	}
    
    // filesent list method 
    
    public List<FileMovementDTO> getFileSentListByUserPostId(long userPostId) {
		return masterdataLocalService.getFileSentListByUserPostId(userPostId);
		
	}
    
	private Log logger = LogFactoryUtil.getLog(this.getClass());
}