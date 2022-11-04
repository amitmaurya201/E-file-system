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
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import java.util.List;

import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalServiceUtil;
import io.jetprocess.masterdata.service.base.UserPostLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.masterdata.model.UserPost", service = AopService.class)
public class UserPostLocalServiceImpl extends UserPostLocalServiceBaseImpl {

	public List<UserPost> getUserPostList(long userId ) {
       //    List<UserPost> userPostlist = userPostLocalService.getUserPosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
         List<UserPost> list  = userPostPersistence.findByuserId(userId);
		return list;
	}

	public UserPost getUserPostById(long userPostId) {
		UserPost userPost = userPostLocalService.getUserPostById(1);
		

		return userPost;
	}

}