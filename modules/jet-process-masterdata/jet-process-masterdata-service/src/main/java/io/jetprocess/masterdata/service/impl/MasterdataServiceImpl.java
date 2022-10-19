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

import java.util.List;

import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.service.base.MasterdataServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=masterdata",
		"json.web.service.context.path=Masterdata"
	},
	service = AopService.class
)
public class MasterdataServiceImpl extends MasterdataServiceBaseImpl {

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

	

}