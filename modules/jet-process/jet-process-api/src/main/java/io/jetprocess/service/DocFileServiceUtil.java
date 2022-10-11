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
	public static DocFile addDocFile(
			long groupId, String nature, String type, String subject,
			String category, String subCategory, String remarks,
			String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDocFile(
			groupId, nature, type, subject, category, subCategory, remarks,
			reference, serviceContext);
	}

	public static DocFile addDocFile(
			long groupId, String nature, String type, String subject,
			String fileNumber, String category, String subCategory,
			String remarks, String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDocFile(
			groupId, nature, type, subject, fileNumber, category, subCategory,
			remarks, reference, serviceContext);
	}

	public static DocFile deleteDocFile(long docFileId) throws PortalException {
		return getService().deleteDocFile(docFileId);
	}

	public static List<DocFile> getDocFileByGroupId(
		long groupId, int start, int end) {

		return getService().getDocFileByGroupId(groupId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DocFile updateDocFile(
			long docFileId, String nature, String type, String subject,
			String fileNumber, String category, String subCategory,
			String remarks, String reference,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDocFile(
			docFileId, nature, type, subject, fileNumber, category, subCategory,
			remarks, reference, serviceContext);
	}

	public static DocFileService getService() {
		return _service;
	}

	private static volatile DocFileService _service;

}