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
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.servlet.http.HttpSession;

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

	public List<UserPost> getUserPostSearchedData(String data) {
		List<UserPost> userPostList = null;
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserPost.class,
				PortalClassLoaderUtil.getClassLoader());
		Criterion criterion = null;
		if (Validator.isNotNull(data)) {
			criterion = RestrictionsFactoryUtil.like("shortName", new String(data));
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.like("description", new String(data)));
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.like("departmentName", new String(data)));
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.like("postName", new String(data)));
			 dynamicQuery.add(criterion);
			userPostList = UserPostLocalServiceUtil.dynamicQuery(dynamicQuery);

		}

		return userPostList;
		
	}
	 // create method for get userpost id 
	public long getUserPostId(ActionRequest actionRequest) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession sessionUserPost = themeDisplay.getRequest().getSession();
		String userPosts = (String) sessionUserPost.getAttribute("userPostId");
		long userpost = Long.parseLong(userPosts);
		
		return userpost;
		
	}
	
	
	
}