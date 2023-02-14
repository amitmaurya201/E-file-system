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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.base.UserPostLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.masterdata.model.UserPost", service = AopService.class)
public class UserPostLocalServiceImpl extends UserPostLocalServiceBaseImpl {

	public List<UserPost> getUserPostList(long userId ) {
         List<UserPost> list  = userPostPersistence.findByuserId(userId);
		return list;
	}

	public UserPost getUserPostById(long userPostId) {
		try {
			return  userPostLocalService.getUserPost(userPostId) ;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	 // create method for get userpost id 
	public long getUserPostId(ActionRequest actionRequest) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession sessionUserPost = themeDisplay.getRequest().getSession();
		String userPosts = (String) sessionUserPost.getAttribute("userPostId");
		long userpost = Long.parseLong(userPosts);
		
		return userpost;
		
	}
	
	
	public List<UserPost> getUserPostExceptGivenUserPostId(long userPostId) throws PortalException{
		
		List<UserPost> userPostList = getUserPosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<UserPost> newUserPostList = new ArrayList<>(userPostList);
		UserPost selectedUserPost = getUserPost(userPostId);
		boolean isUserPostAvailable = newUserPostList.contains(selectedUserPost);
		if (isUserPostAvailable) {
			newUserPostList.remove(selectedUserPost);
		}

		return newUserPostList;
			}
	
}