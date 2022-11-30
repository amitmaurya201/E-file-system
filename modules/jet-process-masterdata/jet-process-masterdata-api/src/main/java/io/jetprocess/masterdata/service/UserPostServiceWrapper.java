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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserPostService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPostService
 * @generated
 */
public class UserPostServiceWrapper
	implements ServiceWrapper<UserPostService>, UserPostService {

	public UserPostServiceWrapper() {
		this(null);
	}

	public UserPostServiceWrapper(UserPostService userPostService) {
		_userPostService = userPostService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPostService.getOSGiServiceIdentifier();
	}

	@Override
	public io.jetprocess.masterdata.model.UserPost getUserPostById(
		long userPostId) {

		return _userPostService.getUserPostById(userPostId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.UserPost>
		getUserPostList(long userId) {

		return _userPostService.getUserPostList(userId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.UserPost>
		getUserPostSearchedData(String data) {

		return _userPostService.getUserPostSearchedData(data);
	}

	@Override
	public UserPostService getWrappedService() {
		return _userPostService;
	}

	@Override
	public void setWrappedService(UserPostService userPostService) {
		_userPostService = userPostService;
	}

	private UserPostService _userPostService;

}