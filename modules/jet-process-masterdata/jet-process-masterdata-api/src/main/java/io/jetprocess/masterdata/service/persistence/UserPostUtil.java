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

package io.jetprocess.masterdata.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import io.jetprocess.masterdata.model.UserPost;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user post service. This utility wraps <code>io.jetprocess.masterdata.service.persistence.impl.UserPostPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPostPersistence
 * @generated
 */
public class UserPostUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserPost userPost) {
		getPersistence().clearCache(userPost);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserPost> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserPost> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserPost update(UserPost userPost) {
		return getPersistence().update(userPost);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserPost update(
		UserPost userPost, ServiceContext serviceContext) {

		return getPersistence().update(userPost, serviceContext);
	}

	/**
	 * Returns all the user posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user posts
	 */
	public static List<UserPost> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @return the range of matching user posts
	 */
	public static List<UserPost> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user posts
	 */
	public static List<UserPost> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPost> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user posts
	 */
	public static List<UserPost> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPost> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public static UserPost findByUuid_First(
			String uuid, OrderByComparator<UserPost> orderByComparator)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public static UserPost fetchByUuid_First(
		String uuid, OrderByComparator<UserPost> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public static UserPost findByUuid_Last(
			String uuid, OrderByComparator<UserPost> orderByComparator)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public static UserPost fetchByUuid_Last(
		String uuid, OrderByComparator<UserPost> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user posts before and after the current user post in the ordered set where uuid = &#63;.
	 *
	 * @param userPostId the primary key of the current user post
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user post
	 * @throws NoSuchUserPostException if a user post with the primary key could not be found
	 */
	public static UserPost[] findByUuid_PrevAndNext(
			long userPostId, String uuid,
			OrderByComparator<UserPost> orderByComparator)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().findByUuid_PrevAndNext(
			userPostId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user posts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user posts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the user post where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserPostException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public static UserPost findByUUID_G(String uuid, long groupId)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public static UserPost fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public static UserPost fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the user post where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user post that was removed
	 */
	public static UserPost removeByUUID_G(String uuid, long groupId)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of user posts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user posts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the user posts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user posts
	 */
	public static List<UserPost> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the user posts where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @return the range of matching user posts
	 */
	public static List<UserPost> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the user posts where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user posts
	 */
	public static List<UserPost> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserPost> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user posts where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user posts
	 */
	public static List<UserPost> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserPost> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user post in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public static UserPost findByuserId_First(
			long userId, OrderByComparator<UserPost> orderByComparator)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first user post in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public static UserPost fetchByuserId_First(
		long userId, OrderByComparator<UserPost> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last user post in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public static UserPost findByuserId_Last(
			long userId, OrderByComparator<UserPost> orderByComparator)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last user post in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public static UserPost fetchByuserId_Last(
		long userId, OrderByComparator<UserPost> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the user posts before and after the current user post in the ordered set where userId = &#63;.
	 *
	 * @param userPostId the primary key of the current user post
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user post
	 * @throws NoSuchUserPostException if a user post with the primary key could not be found
	 */
	public static UserPost[] findByuserId_PrevAndNext(
			long userPostId, long userId,
			OrderByComparator<UserPost> orderByComparator)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().findByuserId_PrevAndNext(
			userPostId, userId, orderByComparator);
	}

	/**
	 * Removes all the user posts where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of user posts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user posts
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the user post in the entity cache if it is enabled.
	 *
	 * @param userPost the user post
	 */
	public static void cacheResult(UserPost userPost) {
		getPersistence().cacheResult(userPost);
	}

	/**
	 * Caches the user posts in the entity cache if it is enabled.
	 *
	 * @param userPosts the user posts
	 */
	public static void cacheResult(List<UserPost> userPosts) {
		getPersistence().cacheResult(userPosts);
	}

	/**
	 * Creates a new user post with the primary key. Does not add the user post to the database.
	 *
	 * @param userPostId the primary key for the new user post
	 * @return the new user post
	 */
	public static UserPost create(long userPostId) {
		return getPersistence().create(userPostId);
	}

	/**
	 * Removes the user post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPostId the primary key of the user post
	 * @return the user post that was removed
	 * @throws NoSuchUserPostException if a user post with the primary key could not be found
	 */
	public static UserPost remove(long userPostId)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().remove(userPostId);
	}

	public static UserPost updateImpl(UserPost userPost) {
		return getPersistence().updateImpl(userPost);
	}

	/**
	 * Returns the user post with the primary key or throws a <code>NoSuchUserPostException</code> if it could not be found.
	 *
	 * @param userPostId the primary key of the user post
	 * @return the user post
	 * @throws NoSuchUserPostException if a user post with the primary key could not be found
	 */
	public static UserPost findByPrimaryKey(long userPostId)
		throws io.jetprocess.masterdata.exception.NoSuchUserPostException {

		return getPersistence().findByPrimaryKey(userPostId);
	}

	/**
	 * Returns the user post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPostId the primary key of the user post
	 * @return the user post, or <code>null</code> if a user post with the primary key could not be found
	 */
	public static UserPost fetchByPrimaryKey(long userPostId) {
		return getPersistence().fetchByPrimaryKey(userPostId);
	}

	/**
	 * Returns all the user posts.
	 *
	 * @return the user posts
	 */
	public static List<UserPost> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @return the range of user posts
	 */
	public static List<UserPost> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user posts
	 */
	public static List<UserPost> findAll(
		int start, int end, OrderByComparator<UserPost> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user posts
	 * @param end the upper bound of the range of user posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user posts
	 */
	public static List<UserPost> findAll(
		int start, int end, OrderByComparator<UserPost> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user posts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user posts.
	 *
	 * @return the number of user posts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserPostPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserPostPersistence _persistence;

}