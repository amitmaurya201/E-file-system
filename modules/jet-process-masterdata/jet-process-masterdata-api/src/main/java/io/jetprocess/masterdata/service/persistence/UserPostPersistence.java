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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import io.jetprocess.masterdata.exception.NoSuchUserPostException;
import io.jetprocess.masterdata.model.UserPost;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPostUtil
 * @generated
 */
@ProviderType
public interface UserPostPersistence extends BasePersistence<UserPost> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPostUtil} to access the user post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user posts
	 */
	public java.util.List<UserPost> findByUuid(String uuid);

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
	public java.util.List<UserPost> findByUuid(String uuid, int start, int end);

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
	public java.util.List<UserPost> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator);

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
	public java.util.List<UserPost> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public UserPost findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPost>
				orderByComparator)
		throws NoSuchUserPostException;

	/**
	 * Returns the first user post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public UserPost fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator);

	/**
	 * Returns the last user post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public UserPost findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPost>
				orderByComparator)
		throws NoSuchUserPostException;

	/**
	 * Returns the last user post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public UserPost fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator);

	/**
	 * Returns the user posts before and after the current user post in the ordered set where uuid = &#63;.
	 *
	 * @param userPostId the primary key of the current user post
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user post
	 * @throws NoSuchUserPostException if a user post with the primary key could not be found
	 */
	public UserPost[] findByUuid_PrevAndNext(
			long userPostId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPost>
				orderByComparator)
		throws NoSuchUserPostException;

	/**
	 * Removes all the user posts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user posts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user post where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserPostException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public UserPost findByUUID_G(String uuid, long groupId)
		throws NoSuchUserPostException;

	/**
	 * Returns the user post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public UserPost fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the user post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public UserPost fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the user post where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user post that was removed
	 */
	public UserPost removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserPostException;

	/**
	 * Returns the number of user posts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user posts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user posts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user posts
	 */
	public java.util.List<UserPost> findByuserId(long userId);

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
	public java.util.List<UserPost> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<UserPost> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator);

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
	public java.util.List<UserPost> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user post in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public UserPost findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPost>
				orderByComparator)
		throws NoSuchUserPostException;

	/**
	 * Returns the first user post in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public UserPost fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator);

	/**
	 * Returns the last user post in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user post
	 * @throws NoSuchUserPostException if a matching user post could not be found
	 */
	public UserPost findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPost>
				orderByComparator)
		throws NoSuchUserPostException;

	/**
	 * Returns the last user post in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user post, or <code>null</code> if a matching user post could not be found
	 */
	public UserPost fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator);

	/**
	 * Returns the user posts before and after the current user post in the ordered set where userId = &#63;.
	 *
	 * @param userPostId the primary key of the current user post
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user post
	 * @throws NoSuchUserPostException if a user post with the primary key could not be found
	 */
	public UserPost[] findByuserId_PrevAndNext(
			long userPostId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPost>
				orderByComparator)
		throws NoSuchUserPostException;

	/**
	 * Removes all the user posts where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of user posts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user posts
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the user post in the entity cache if it is enabled.
	 *
	 * @param userPost the user post
	 */
	public void cacheResult(UserPost userPost);

	/**
	 * Caches the user posts in the entity cache if it is enabled.
	 *
	 * @param userPosts the user posts
	 */
	public void cacheResult(java.util.List<UserPost> userPosts);

	/**
	 * Creates a new user post with the primary key. Does not add the user post to the database.
	 *
	 * @param userPostId the primary key for the new user post
	 * @return the new user post
	 */
	public UserPost create(long userPostId);

	/**
	 * Removes the user post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPostId the primary key of the user post
	 * @return the user post that was removed
	 * @throws NoSuchUserPostException if a user post with the primary key could not be found
	 */
	public UserPost remove(long userPostId) throws NoSuchUserPostException;

	public UserPost updateImpl(UserPost userPost);

	/**
	 * Returns the user post with the primary key or throws a <code>NoSuchUserPostException</code> if it could not be found.
	 *
	 * @param userPostId the primary key of the user post
	 * @return the user post
	 * @throws NoSuchUserPostException if a user post with the primary key could not be found
	 */
	public UserPost findByPrimaryKey(long userPostId)
		throws NoSuchUserPostException;

	/**
	 * Returns the user post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPostId the primary key of the user post
	 * @return the user post, or <code>null</code> if a user post with the primary key could not be found
	 */
	public UserPost fetchByPrimaryKey(long userPostId);

	/**
	 * Returns all the user posts.
	 *
	 * @return the user posts
	 */
	public java.util.List<UserPost> findAll();

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
	public java.util.List<UserPost> findAll(int start, int end);

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
	public java.util.List<UserPost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator);

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
	public java.util.List<UserPost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user posts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user posts.
	 *
	 * @return the number of user posts
	 */
	public int countAll();

}