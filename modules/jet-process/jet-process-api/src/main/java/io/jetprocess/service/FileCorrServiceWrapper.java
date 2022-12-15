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
 * Provides a wrapper for {@link FileCorrService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrService
 * @generated
 */
public class FileCorrServiceWrapper
	implements FileCorrService, ServiceWrapper<FileCorrService> {

	public FileCorrServiceWrapper() {
		this(null);
	}

	public FileCorrServiceWrapper(FileCorrService fileCorrService) {
		_fileCorrService = fileCorrService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fileCorrService.getOSGiServiceIdentifier();
	}

	@Override
	public FileCorrService getWrappedService() {
		return _fileCorrService;
	}

	@Override
	public void setWrappedService(FileCorrService fileCorrService) {
		_fileCorrService = fileCorrService;
	}

	private FileCorrService _fileCorrService;

}