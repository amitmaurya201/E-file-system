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

import com.liferay.portal.kernel.exception.PortalException;

import io.jetprocess.model.DocFile;

import java.util.List;

/**
 * Provides the remote service utility for DocFile. This utility wraps
 * <code>io.jetprocess.service.impl.DocFileServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DocFileService
 * @generated
 */
public class DocFileServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>io.jetprocess.service.impl.DocFileServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONObject addNonSfsDocFile(
			long groupId, String nature, String type, long basicHeadId,
			long primaryHeadId, long secondaryHeadId, long tertiaryHeadId,
			long year, long fileCodeId, String subject, long categoryId,
			long subCategoryId, String remarks, String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addNonSfsDocFile(
			groupId, nature, type, basicHeadId, primaryHeadId, secondaryHeadId,
			tertiaryHeadId, year, fileCodeId, subject, categoryId,
			subCategoryId, remarks, reference, serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONObject addSfsDocFile(
			long groupId, String nature, String type, String subject,
			long categoryId, long subCategoryId, String remarks,
			String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addSfsDocFile(
			groupId, nature, type, subject, categoryId, subCategoryId, remarks,
			reference, serviceContext);
	}

	public static DocFile deleteDocFile(long docFileId) throws PortalException {
		return getService().deleteDocFile(docFileId);
	}

	public static List<DocFile> getDocFileList() {
		return getService().getDocFileList();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DocFile updateNonSfsDocFile(
			long docFileId, String nature, String type, long basicHeadId,
			long primaryHeadId, long secondaryHeadId, long tertiaryHeadId,
			long year, long fileCodeId, String subject, String fileNumber,
			long categoryId, long subCategoryId, String remarks,
			String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateNonSfsDocFile(
			docFileId, nature, type, basicHeadId, primaryHeadId,
			secondaryHeadId, tertiaryHeadId, year, fileCodeId, subject,
			fileNumber, categoryId, subCategoryId, remarks, reference,
			serviceContext);
	}

	public static DocFile updateSfsDocFile(
			long docFileId, String nature, String type, String subject,
			long categoryId, long subCategoryId, String fileNumber,
			String remarks, String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateSfsDocFile(
			docFileId, nature, type, subject, categoryId, subCategoryId,
			fileNumber, remarks, reference, serviceContext);
	}

	public static DocFileService getService() {
		return _service;
	}

	private static volatile DocFileService _service;

}