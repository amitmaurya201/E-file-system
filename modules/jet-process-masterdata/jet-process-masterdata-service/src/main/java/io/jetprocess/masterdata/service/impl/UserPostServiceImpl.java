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

import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.base.UserPostServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=masterdata",
		"json.web.service.context.path=UserPost"
	},
	service = AopService.class
)
public class UserPostServiceImpl extends UserPostServiceBaseImpl {
	
	
	public List<UserPost> getUserPostList(long userId) {

		return userPostLocalService.getUserPostList(userId);
	}

	public UserPost getUserPostById(long userPostId) {

		return userPostLocalService.getUserPostById(userPostId);
	}

	
	
}