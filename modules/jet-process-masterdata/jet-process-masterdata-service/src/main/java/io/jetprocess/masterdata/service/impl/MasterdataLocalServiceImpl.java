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
import io.jetprocess.masterdata.model.FileCorrespondenceReceiptDTO;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.service.base.MasterdataLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.masterdata.model.Masterdata", service = AopService.class)
public class MasterdataLocalServiceImpl extends MasterdataLocalServiceBaseImpl {

	public List<Masterdata> getCategory() {

		return masterdataFinder.getCategories();
	}

	public List<Masterdata> getSubcategories(long categoryId) {

		return masterdataFinder.getSubCategories(categoryId);
	}

	public List<Masterdata> getTypes() {

		return masterdataFinder.getType();
	}

	public List<Masterdata> getDeliveryModes() {

		return masterdataFinder.getDeliveryMode();

	}

	public List<Masterdata> getFile() {

		return masterdataFinder.getFileCode();
	}

	public List<Masterdata> getBasicHead() {

		return masterdataFinder.getBasicHeads();

	}

	public List<Masterdata> getPrimaryHead(long basicHeadId) {

		return masterdataFinder.getPrimaryHeads(basicHeadId);
	}

	public List<Masterdata> getSecondaryHead(long primaryHeadId) {

		return masterdataFinder.getSecondaryHeads(primaryHeadId);
	}

	public List<Masterdata> getTeritaryHead(long seondaryHeadId) {

		return masterdataFinder.getTeritaryHeads(seondaryHeadId);
	}

	public List<Masterdata> getOrgranizations() {

		return masterdataFinder.getOrganization();
	}

	public List<Masterdata> getSubOrgranizations(long organizationId) {

		return masterdataFinder.getSubOrganization(organizationId);
	}

	public List<Masterdata> getReceiptCategory() {

		return masterdataFinder.getReceiptCategory();
	}

	public List<Masterdata> getReceiptSubCategory(long receiptCategoryId) {

		return masterdataFinder.getReceiptSubCategory(receiptCategoryId);
	}

	public List<Masterdata> getCountry() {

		return masterdataFinder.getCountries();
	}

	public List<Masterdata> getStates(long countryId) {

		return masterdataFinder.getStates(countryId);
	}

	public Masterdata getBasic(long basicHeadId) {

		return masterdataFinder.getBasicHeadById(basicHeadId);
	}

	public Masterdata getPrimary(long primaryHeadId) {

		return masterdataFinder.getPrimaryHeadById(primaryHeadId);
	}

	public Masterdata getSecondary(long secondaryHeadId) {

		return masterdataFinder.getSecondaryHeadById(secondaryHeadId);

	}

	public Masterdata getTertiary(long tertiaryHeadId) {

		return masterdataFinder.getTertiaryHeadById(tertiaryHeadId);
	}

	

	public Masterdata getFileById(long fileCodeId) {

		return masterdataFinder.getFileCodeValueById(fileCodeId);
	}

	public Masterdata getCategoryById(long categoryId) {

		return masterdataFinder.getCategoryValueById(categoryId);

	}

	public Masterdata getSubCategoryById(long subCategoryId) {

		return masterdataFinder.getSubCategoryValueById(subCategoryId);
	}

	public Masterdata getTypeById(long typeId) {

		return masterdataFinder.getTypeValueById(typeId);
	}

	public Masterdata getDeliveryModeById(long deliveryModeId) {

		return masterdataFinder.getDeliveryModeValueById(deliveryModeId);
	}

	public Masterdata getOrganizationById(long organizationId) {

		return masterdataFinder.getOrganizationValueById(organizationId);
	}

	public Masterdata getSubOrganizationById(long subOrganizationId) {

		return masterdataFinder.getSubOrganizationValueById(subOrganizationId);
	}

	public Masterdata getCountryById(long countryId) {

		return masterdataFinder.getCountryValueById(countryId);
	}

	public Masterdata getStateById(long stateId) {

		return masterdataFinder.getStateValueById(stateId);

	}

	public Masterdata getReceiptCategoryById(long receiptCategoryId) {

		return masterdataFinder.getReceiptCategoryValueById(receiptCategoryId);
	}

	public Masterdata getReceiptSubCategoryById(long receiptSubCategoryId) {

		return masterdataFinder.getReceiptSubCategoryValueById(receiptSubCategoryId);
	}



	public List<ReceiptMovementDTO> getReceiptSentList(long userPostId) {
		return masterdataFinder.getReceiptSentListByFinder(userPostId);
	}

	public List<ReceiptMovementDTO> getReceiptMovementListByReceiptId(long receiptId) {
		return masterdataFinder.getReceiptMovementListByReceiptId(receiptId);
	}

	public List<FileMovementDTO> getFileMovementListByFileId(long fileId) {
		return masterdataFinder.getFileMovementListByFileId(fileId);
	}


	public List<FileCorrespondenceReceiptDTO> getFileCorrespondenceReceipteDetail(long fileId) {
		return masterdataFinder.getFileCorrespondenceReceiptDetails(fileId);
	}



	public long getMaximumFmIdByFileIdData(long fileId) {

		return masterdataFinder.getMaximumFmIdByFileId(fileId);
	}

	public long getMaximumRmIdByReceiptId(long receiptId) {

		return masterdataFinder.getMaximumRmIdByReceiptId(receiptId);
	}
	
	public long getLastActiveRmIdByReceiptId(long receiptId) {

		return masterdataFinder.getLastActiveRmIdByReceiptId(receiptId);
	}

	
	public long getMaxReceiptClosedId(long receiptId) {
		return masterdataFinder.getMaxCloseReceiptId(receiptId);

	}
	

	public List<Masterdata> getSubjectCategory() {
		return masterdataFinder.getSubjectCategory();

	}
	
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());

}