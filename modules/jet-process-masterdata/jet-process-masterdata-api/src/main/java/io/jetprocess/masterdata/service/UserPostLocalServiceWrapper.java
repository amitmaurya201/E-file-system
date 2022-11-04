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
 * Provides a wrapper for {@link UserPostLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPostLocalService
 * @generated
 */
public class UserPostLocalServiceWrapper
	implements ServiceWrapper<UserPostLocalService>, UserPostLocalService {

	public UserPostLocalServiceWrapper() {
		this(null);
	}

	public UserPostLocalServiceWrapper(
		UserPostLocalService userPostLocalService) {

		_userPostLocalService = userPostLocalService;
	}

	/**
	 * Adds the user post to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserPostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userPost the user post
	 * @return the user post that was added
	 */
	@Override
	public io.jetprocess.masterdata.model.UserPost addUserPost(
		io.jetprocess.masterdata.model.UserPost userPost) {

		return _userPostLocalService.addUserPost(userPost);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPostLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user post with the primary key. Does not add the user post to the database.
	 *
	 * @param userPostId the primary key for the new user post
	 * @return the new user post
	 */
	@Override
	public io.jetprocess.masterdata.model.UserPost createUserPost(
		long userPostId) {

		return _userPostLocalService.createUserPost(userPostId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPostLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserPostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userPostId the primary key of the user post
	 * @return the user post that was removed
	 * @throws PortalException if a user post with the primary key could not be found
	 */
	@Override
	public io.jetprocess.masterdata.model.UserPost deleteUserPost(
			long userPostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPostLocalService.deleteUserPost(userPostId);
	}

	/**
	 * Deletes the user post from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserPostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userPost the user post
	 * @return the user post that was removed
	 */
	@Override
	public io.jetprocess.masterdata.model.UserPost deleteUserPost(
		io.jetprocess.masterdata.model.UserPost userPost) {

		return _userPostLocalService.deleteUserPost(userPost);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userPostLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userPostLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userPostLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userPostLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userPostLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userPostLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userPostLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userPostLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public io.jetprocess.masterdata.model.UserPost fetchUserPost(
		long userPostId) {

		return _userPostLocalService.fetchUserPost(userPostId);
	}

	/**
	 * Returns the user post matching the UUID and group.
	 *
	 * @param uuid the user post's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user post, or <code>null</code> if a matching user post could not be found
	 */
	@Override
	public io.jetprocess.masterdata.model.UserPost
		fetchUserPostByUuidAndGroupId(String uuid, long groupId) {

		return _userPostLocalService.fetchUserPostByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userPostLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userPostLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPostLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPostLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user post with the primary key.
	 *
	 * @param userPostId the primary key of the user post
	 * @return the user post
	 * @throws PortalException if a user post with the primary key could not be found
	 */
	@Override
	public io.jetprocess.masterdata.model.UserPost getUserPost(long userPostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPostLocalService.getUserPost(userPostId);
	}

	@Override
	public io.jetprocess.masterdata.model.UserPost getUserPostById(
		long userPostId) {

		return _userPostLocalService.getUserPostById(userPostId);
	}

	/**
	 * Returns the user post matching the UUID and group.
	 *
	 * @param uuid the user post's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user post
	 * @throws PortalException if a matching user post could not be found
	 */
	@Override
	public io.jetprocess.masterdata.model.UserPost getUserPostByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPostLocalService.getUserPostByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<io.jetprocess.masterdata.model.UserPost>
		getUserPostList(long userId) {

		return _userPostLocalService.getUserPostList(userId);
	}

	/**
	 * Returns a range of all the user posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>io.jetprocess.masterdata.model.impl.UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @return the range of user posts
	 */
	@Override
	public java.util.List<io.jetprocess.masterdata.model.UserPost> getUserPosts(
		int start, int end) {

		return _userPostLocalService.getUserPosts(start, end);
	}

	/**
	 * Returns the number of user posts.
	 *
	 * @return the number of user posts
	 */
	@Override
	public int getUserPostsCount() {
		return _userPostLocalService.getUserPostsCount();
	}

	/**
	 * Updates the user post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserPostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userPost the user post
	 * @return the user post that was updated
	 */
	@Override
	public io.jetprocess.masterdata.model.UserPost updateUserPost(
		io.jetprocess.masterdata.model.UserPost userPost) {

		return _userPostLocalService.updateUserPost(userPost);
	}

	@Override
	public UserPostLocalService getWrappedService() {
		return _userPostLocalService;
	}

	@Override
	public void setWrappedService(UserPostLocalService userPostLocalService) {
		_userPostLocalService = userPostLocalService;
	}

	private UserPostLocalService _userPostLocalService;

}