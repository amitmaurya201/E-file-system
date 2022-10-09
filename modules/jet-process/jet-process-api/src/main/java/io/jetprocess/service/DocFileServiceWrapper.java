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
	public io.jetprocess.model.DocFile addDocFile(
			long groupId, String nature, String type, String subject,
			String fileNumber, String category, String subCategory,
			String remarks, String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileService.addDocFile(
			groupId, nature, type, subject, fileNumber, category, subCategory,
			remarks, reference, serviceContext);
	}

	@Override
	public io.jetprocess.model.DocFile deleteDocFile(long docFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileService.deleteDocFile(docFileId);
	}

	@Override
	public java.util.List<io.jetprocess.model.DocFile> getDocFileByGroupId(
		long groupId, int start, int end) {

		return _docFileService.getDocFileByGroupId(groupId, start, end);
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
			long docFileId, String nature, String type, String subject,
			String fileNumber, String category, String subCategory,
			String remarks, String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docFileService.updateDocFile(
			docFileId, nature, type, subject, fileNumber, category, subCategory,
			remarks, reference, serviceContext);
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