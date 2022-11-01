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

import io.jetprocess.masterdata.model.Masterdata;

import java.util.List;

/**
 * Provides the remote service utility for Masterdata. This utility wraps
 * <code>io.jetprocess.masterdata.service.impl.MasterdataServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MasterdataService
 * @generated
 */
public class MasterdataServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.masterdata.service.impl.MasterdataServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Masterdata getBasicHeadByIdMasterdata(long basicHeadId) {
		return getService().getBasicHeadByIdMasterdata(basicHeadId);
	}

	public static List<Masterdata> getBasicHeadMasterdata() {
		return getService().getBasicHeadMasterdata();
	}

	public static List<Masterdata> getCategoryMasterdata() {
		return getService().getCategoryMasterdata();
	}

	public static List<Masterdata> getCountriesMasterdata() {
		return getService().getCountriesMasterdata();
	}

	public static List<Masterdata> getDeliveryModeMasterdata() {
		return getService().getDeliveryModeMasterdata();
	}

	public static List<Masterdata> getFileCodeMasterdata() {
		return getService().getFileCodeMasterdata();
	}

	public static List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListMasterdata() {

		return getService().getFileCreatedListMasterdata();
	}

	public static List<Masterdata> getOrganizationMasterdata() {
		return getService().getOrganizationMasterdata();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Masterdata getPrimaryHeadByIdMasterdata(long primaryHeadId) {
		return getService().getPrimaryHeadByIdMasterdata(primaryHeadId);
	}

	public static List<Masterdata> getPrimaryHeadMasterdata(long basicHeadId) {
		return getService().getPrimaryHeadMasterdata(basicHeadId);
	}

	public static List<Masterdata> getReceiptCategoryMasterdata() {
		return getService().getReceiptCategoryMasterdata();
	}

	public static List<io.jetprocess.masterdata.model.ReceiptListViewDto>
		getReceiptListMasterdata() {

		return getService().getReceiptListMasterdata();
	}

	public static List<Masterdata> getReceiptSubCategoryMasterdata(
		long receiptCategoryId) {

		return getService().getReceiptSubCategoryMasterdata(receiptCategoryId);
	}

	public static Masterdata getSecondaryHeadByIdMasterdata(
		long secondaryHeadId) {

		return getService().getSecondaryHeadByIdMasterdata(secondaryHeadId);
	}

	public static List<Masterdata> getSecondaryHeadMasterdata(
		long primaryHeadId) {

		return getService().getSecondaryHeadMasterdata(primaryHeadId);
	}

	public static List<Masterdata> getStatesMasterdata(long countryId) {
		return getService().getStatesMasterdata(countryId);
	}

	public static List<Masterdata> getSubCategoryMasterdata(long categoryId) {
		return getService().getSubCategoryMasterdata(categoryId);
	}

	public static List<Masterdata> getSubOrganizationMasterdata(
		long organizationId) {

		return getService().getSubOrganizationMasterdata(organizationId);
	}

	public static List<Masterdata> getTeritaryHeadMasterdata(
		long secondaryHeadId) {

		return getService().getTeritaryHeadMasterdata(secondaryHeadId);
	}

	public static Masterdata getTertiaryByIdMasterdata(long tertiaryHeadId) {
		return getService().getTertiaryByIdMasterdata(tertiaryHeadId);
	}

	public static List<Masterdata> getTypeMasterdata() {
		return getService().getTypeMasterdata();
	}

	public static MasterdataService getService() {
		return _service;
	}

	private static volatile MasterdataService _service;

}