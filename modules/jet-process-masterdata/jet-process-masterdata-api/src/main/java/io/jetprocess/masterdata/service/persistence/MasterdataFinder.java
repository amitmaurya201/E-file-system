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

package io.jetprocess.masterdata.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface MasterdataFinder {

	public java.util.List<io.jetprocess.masterdata.model.ReceiptMovementDTO>
		getReceiptInboxList(long userPostId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCategories();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubCategories(long categoryId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata> getType();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getDeliveryMode();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getFileCode();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getBasicHeads();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getPrimaryHeads(long basicHeadId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSecondaryHeads(long primaryHeadId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTeritaryHeads(long secondaryHeadsId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getOrganization();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubOrganization(long organizationId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptCategory();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptSubCategory(long receiptCategoryId);

	public java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCountries();

	public java.util.List<io.jetprocess.masterdata.model.Masterdata> getStates(
		long countryId);

	public io.jetprocess.masterdata.model.Masterdata getBasicHeadById(
		long basicHeadId);

	public io.jetprocess.masterdata.model.Masterdata getPrimaryHeadById(
		long primaryHeadId);

	public io.jetprocess.masterdata.model.Masterdata getSecondaryHeadById(
		long secondaryHeadId);

	public io.jetprocess.masterdata.model.Masterdata getTertiaryHeadById(
		long tertiaryHeadId);

	public java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedList(long userPostId);

	public java.util.List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptCreatedList(long userPostId);

	public int getFileCreatedListCount(long userPostId);

	public int getReceiptCreatedListCount(long userPostId);

	public io.jetprocess.masterdata.model.Masterdata getFileCodeValueById(
		long fileCodeId);

	public io.jetprocess.masterdata.model.Masterdata getCategoryValueById(
		long categoryId);

	public io.jetprocess.masterdata.model.Masterdata getSubCategoryValueById(
		long subCategoryId);

	public io.jetprocess.masterdata.model.Masterdata getTypeValueById(
		long typeId);

	public io.jetprocess.masterdata.model.Masterdata getDeliveryModeValueById(
		long deliveryModeId);

	public io.jetprocess.masterdata.model.Masterdata getOrganizationValueById(
		long organizationId);

	public io.jetprocess.masterdata.model.Masterdata
		getSubOrganizationValueById(long subOrganizationId);

	public io.jetprocess.masterdata.model.Masterdata getCountryValueById(
		long countryId);

	public io.jetprocess.masterdata.model.Masterdata getStateValueById(
		long stateId);

	public io.jetprocess.masterdata.model.Masterdata
		getReceiptCategoryValueById(long receiptCategoryId);

	public io.jetprocess.masterdata.model.Masterdata
		getReceiptSubCategoryValueById(long receiptSubCategoryId);

	public java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListSearch(long userPostId, String data);

	public java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListSearch1(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order);

	public java.util.List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptListSearch(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order);

	public java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListSearchBykey(long userPostId, String keyword);

	public java.util.List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptCreatedListSearch(long userPostId, String keyword);

	public java.util.List<io.jetprocess.masterdata.model.ReceiptMovementDTO>
		getReceiptSentListByFinder(long userPostId);

	public java.util.List<io.jetprocess.masterdata.model.ReceiptMovementDTO>
		getReceiptMovementListByReceiptId(long receiptId);

	public java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileInboxList(long userPostId);

	public java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileMovementListByFileId(long fileId);

	public java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileSentList(long userPostId);

	public java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileSentList(long userPostId, String keyword);

	public java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileSentList(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order);

	public java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileInboxList(long userPostId, String keyword);

	public java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileInboxList(
			long userPostId, String keyword, int start, int end, String orderBy,
			String order);

}