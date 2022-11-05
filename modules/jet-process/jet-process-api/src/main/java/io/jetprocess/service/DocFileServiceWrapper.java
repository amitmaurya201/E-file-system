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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocFileService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocFileService
 * @generated
 */
public class DocFileServiceWrapper
	implements DocFileService, ServiceWrapper<DocFileService> {

	public DocFileServiceWrapper() {
		this(null);
	}

	public DocFileServiceWrapper(DocFileService docFileService) {
		_docFileService = docFileService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject addDocFile(
			long groupId, String nature, String type, long basicHeadId,
			long primaryHeadId, long secondaryHeadId, long tertiaryHeadId,
			long year, long fileCodeId, String subject, long categoryId,
			long subCategoryId, String remarks, String reference,
			long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileService.addDocFile(
			groupId, nature, type, basicHeadId, primaryHeadId, secondaryHeadId,
			tertiaryHeadId, year, fileCodeId, subject, categoryId,
			subCategoryId, remarks, reference, userPostId, serviceContext);
	}

	@Override
	public io.jetprocess.model.DocFile deleteDocFile(long docFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileService.deleteDocFile(docFileId);
	}

	@Override
	public java.util.List<io.jetprocess.model.DocFile> getDocFileList() {
		return _docFileService.getDocFileList();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _docFileService.getOSGiServiceIdentifier();
	}

	@Override
	public io.jetprocess.model.DocFile updateDocFile(
			long docFileId, String subject, long categoryId, long subCategoryId,
			String remarks, String reference, long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileService.updateDocFile(
			docFileId, subject, categoryId, subCategoryId, remarks, reference,
			userPostId, serviceContext);
	}

	@Override
	public DocFileService getWrappedService() {
		return _docFileService;
	}

	@Override
	public void setWrappedService(DocFileService docFileService) {
		_docFileService = docFileService;
	}

	private DocFileService _docFileService;

}