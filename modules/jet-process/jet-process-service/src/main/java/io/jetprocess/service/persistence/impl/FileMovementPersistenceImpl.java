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

package io.jetprocess.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import io.jetprocess.exception.NoSuchFileMovementException;
import io.jetprocess.model.FileMovement;
import io.jetprocess.model.FileMovementTable;
import io.jetprocess.model.impl.FileMovementImpl;
import io.jetprocess.model.impl.FileMovementModelImpl;
import io.jetprocess.service.persistence.FileMovementPersistence;
import io.jetprocess.service.persistence.FileMovementUtil;
import io.jetprocess.service.persistence.impl.constants.JET_PROCESSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the file movement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FileMovementPersistence.class, BasePersistence.class})
public class FileMovementPersistenceImpl
	extends BasePersistenceImpl<FileMovement>
	implements FileMovementPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FileMovementUtil</code> to access the file movement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FileMovementImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the file movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file movements
	 */
	@Override
	public List<FileMovement> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of matching file movements
	 */
	@Override
	public List<FileMovement> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file movements
	 */
	@Override
	public List<FileMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileMovement> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file movements
	 */
	@Override
	public List<FileMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileMovement> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<FileMovement> list = null;

		if (useFinderCache) {
			list = (List<FileMovement>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileMovement fileMovement : list) {
					if (!uuid.equals(fileMovement.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FILEMOVEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileMovementModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<FileMovement>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	@Override
	public FileMovement findByUuid_First(
			String uuid, OrderByComparator<FileMovement> orderByComparator)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = fetchByUuid_First(uuid, orderByComparator);

		if (fileMovement != null) {
			return fileMovement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileMovementException(sb.toString());
	}

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public FileMovement fetchByUuid_First(
		String uuid, OrderByComparator<FileMovement> orderByComparator) {

		List<FileMovement> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	@Override
	public FileMovement findByUuid_Last(
			String uuid, OrderByComparator<FileMovement> orderByComparator)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = fetchByUuid_Last(uuid, orderByComparator);

		if (fileMovement != null) {
			return fileMovement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileMovementException(sb.toString());
	}

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public FileMovement fetchByUuid_Last(
		String uuid, OrderByComparator<FileMovement> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FileMovement> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file movements before and after the current file movement in the ordered set where uuid = &#63;.
	 *
	 * @param fmId the primary key of the current file movement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	@Override
	public FileMovement[] findByUuid_PrevAndNext(
			long fmId, String uuid,
			OrderByComparator<FileMovement> orderByComparator)
		throws NoSuchFileMovementException {

		uuid = Objects.toString(uuid, "");

		FileMovement fileMovement = findByPrimaryKey(fmId);

		Session session = null;

		try {
			session = openSession();

			FileMovement[] array = new FileMovementImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fileMovement, uuid, orderByComparator, true);

			array[1] = fileMovement;

			array[2] = getByUuid_PrevAndNext(
				session, fileMovement, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileMovement getByUuid_PrevAndNext(
		Session session, FileMovement fileMovement, String uuid,
		OrderByComparator<FileMovement> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FILEMOVEMENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FileMovementModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileMovement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileMovement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file movements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FileMovement fileMovement :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fileMovement);
		}
	}

	/**
	 * Returns the number of file movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file movements
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILEMOVEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"fileMovement.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fileMovement.uuid IS NULL OR fileMovement.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	@Override
	public FileMovement findByUUID_G(String uuid, long groupId)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = fetchByUUID_G(uuid, groupId);

		if (fileMovement == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileMovementException(sb.toString());
		}

		return fileMovement;
	}

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public FileMovement fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the file movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public FileMovement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof FileMovement) {
			FileMovement fileMovement = (FileMovement)result;

			if (!Objects.equals(uuid, fileMovement.getUuid()) ||
				(groupId != fileMovement.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FILEMOVEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<FileMovement> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FileMovement fileMovement = list.get(0);

					result = fileMovement;

					cacheResult(fileMovement);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FileMovement)result;
		}
	}

	/**
	 * Removes the file movement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file movement that was removed
	 */
	@Override
	public FileMovement removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = findByUUID_G(uuid, groupId);

		return remove(fileMovement);
	}

	/**
	 * Returns the number of file movements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file movements
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMOVEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"fileMovement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(fileMovement.uuid IS NULL OR fileMovement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"fileMovement.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file movements
	 */
	@Override
	public List<FileMovement> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of matching file movements
	 */
	@Override
	public List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file movements
	 */
	@Override
	public List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileMovement> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file movements
	 */
	@Override
	public List<FileMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileMovement> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<FileMovement> list = null;

		if (useFinderCache) {
			list = (List<FileMovement>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileMovement fileMovement : list) {
					if (!uuid.equals(fileMovement.getUuid()) ||
						(companyId != fileMovement.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FILEMOVEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileMovementModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<FileMovement>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	@Override
	public FileMovement findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileMovement> orderByComparator)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (fileMovement != null) {
			return fileMovement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileMovementException(sb.toString());
	}

	/**
	 * Returns the first file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public FileMovement fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileMovement> orderByComparator) {

		List<FileMovement> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	@Override
	public FileMovement findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileMovement> orderByComparator)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (fileMovement != null) {
			return fileMovement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileMovementException(sb.toString());
	}

	/**
	 * Returns the last file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public FileMovement fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileMovement> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FileMovement> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file movements before and after the current file movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fmId the primary key of the current file movement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	@Override
	public FileMovement[] findByUuid_C_PrevAndNext(
			long fmId, String uuid, long companyId,
			OrderByComparator<FileMovement> orderByComparator)
		throws NoSuchFileMovementException {

		uuid = Objects.toString(uuid, "");

		FileMovement fileMovement = findByPrimaryKey(fmId);

		Session session = null;

		try {
			session = openSession();

			FileMovement[] array = new FileMovementImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, fileMovement, uuid, companyId, orderByComparator,
				true);

			array[1] = fileMovement;

			array[2] = getByUuid_C_PrevAndNext(
				session, fileMovement, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileMovement getByUuid_C_PrevAndNext(
		Session session, FileMovement fileMovement, String uuid, long companyId,
		OrderByComparator<FileMovement> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FILEMOVEMENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FileMovementModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileMovement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileMovement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file movements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FileMovement fileMovement :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileMovement);
		}
	}

	/**
	 * Returns the number of file movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file movements
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMOVEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"fileMovement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(fileMovement.uuid IS NULL OR fileMovement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"fileMovement.companyId = ?";

	private FinderPath _finderPathFetchByfileId;
	private FinderPath _finderPathCountByfileId;

	/**
	 * Returns the file movement where fileId = &#63; or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @return the matching file movement
	 * @throws NoSuchFileMovementException if a matching file movement could not be found
	 */
	@Override
	public FileMovement findByfileId(long fileId)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = fetchByfileId(fileId);

		if (fileMovement == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("fileId=");
			sb.append(fileId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileMovementException(sb.toString());
		}

		return fileMovement;
	}

	/**
	 * Returns the file movement where fileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public FileMovement fetchByfileId(long fileId) {
		return fetchByfileId(fileId, true);
	}

	/**
	 * Returns the file movement where fileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file movement, or <code>null</code> if a matching file movement could not be found
	 */
	@Override
	public FileMovement fetchByfileId(long fileId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fileId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfileId, finderArgs);
		}

		if (result instanceof FileMovement) {
			FileMovement fileMovement = (FileMovement)result;

			if (fileId != fileMovement.getFileId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FILEMOVEMENT_WHERE);

			sb.append(_FINDER_COLUMN_FILEID_FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileId);

				List<FileMovement> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfileId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {fileId};
							}

							_log.warn(
								"FileMovementPersistenceImpl.fetchByfileId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FileMovement fileMovement = list.get(0);

					result = fileMovement;

					cacheResult(fileMovement);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FileMovement)result;
		}
	}

	/**
	 * Removes the file movement where fileId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @return the file movement that was removed
	 */
	@Override
	public FileMovement removeByfileId(long fileId)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = findByfileId(fileId);

		return remove(fileMovement);
	}

	/**
	 * Returns the number of file movements where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the number of matching file movements
	 */
	@Override
	public int countByfileId(long fileId) {
		FinderPath finderPath = _finderPathCountByfileId;

		Object[] finderArgs = new Object[] {fileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILEMOVEMENT_WHERE);

			sb.append(_FINDER_COLUMN_FILEID_FILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILEID_FILEID_2 =
		"fileMovement.fileId = ?";

	public FileMovementPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FileMovement.class);

		setModelImplClass(FileMovementImpl.class);
		setModelPKClass(long.class);

		setTable(FileMovementTable.INSTANCE);
	}

	/**
	 * Caches the file movement in the entity cache if it is enabled.
	 *
	 * @param fileMovement the file movement
	 */
	@Override
	public void cacheResult(FileMovement fileMovement) {
		entityCache.putResult(
			FileMovementImpl.class, fileMovement.getPrimaryKey(), fileMovement);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {fileMovement.getUuid(), fileMovement.getGroupId()},
			fileMovement);

		finderCache.putResult(
			_finderPathFetchByfileId, new Object[] {fileMovement.getFileId()},
			fileMovement);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the file movements in the entity cache if it is enabled.
	 *
	 * @param fileMovements the file movements
	 */
	@Override
	public void cacheResult(List<FileMovement> fileMovements) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fileMovements.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FileMovement fileMovement : fileMovements) {
			if (entityCache.getResult(
					FileMovementImpl.class, fileMovement.getPrimaryKey()) ==
						null) {

				cacheResult(fileMovement);
			}
		}
	}

	/**
	 * Clears the cache for all file movements.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FileMovementImpl.class);

		finderCache.clearCache(FileMovementImpl.class);
	}

	/**
	 * Clears the cache for the file movement.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileMovement fileMovement) {
		entityCache.removeResult(FileMovementImpl.class, fileMovement);
	}

	@Override
	public void clearCache(List<FileMovement> fileMovements) {
		for (FileMovement fileMovement : fileMovements) {
			entityCache.removeResult(FileMovementImpl.class, fileMovement);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FileMovementImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FileMovementImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FileMovementModelImpl fileMovementModelImpl) {

		Object[] args = new Object[] {
			fileMovementModelImpl.getUuid(), fileMovementModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, fileMovementModelImpl);

		args = new Object[] {fileMovementModelImpl.getFileId()};

		finderCache.putResult(_finderPathCountByfileId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByfileId, args, fileMovementModelImpl);
	}

	/**
	 * Creates a new file movement with the primary key. Does not add the file movement to the database.
	 *
	 * @param fmId the primary key for the new file movement
	 * @return the new file movement
	 */
	@Override
	public FileMovement create(long fmId) {
		FileMovement fileMovement = new FileMovementImpl();

		fileMovement.setNew(true);
		fileMovement.setPrimaryKey(fmId);

		String uuid = _portalUUID.generate();

		fileMovement.setUuid(uuid);

		fileMovement.setCompanyId(CompanyThreadLocal.getCompanyId());

		return fileMovement;
	}

	/**
	 * Removes the file movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement that was removed
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	@Override
	public FileMovement remove(long fmId) throws NoSuchFileMovementException {
		return remove((Serializable)fmId);
	}

	/**
	 * Removes the file movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file movement
	 * @return the file movement that was removed
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	@Override
	public FileMovement remove(Serializable primaryKey)
		throws NoSuchFileMovementException {

		Session session = null;

		try {
			session = openSession();

			FileMovement fileMovement = (FileMovement)session.get(
				FileMovementImpl.class, primaryKey);

			if (fileMovement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileMovementException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fileMovement);
		}
		catch (NoSuchFileMovementException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FileMovement removeImpl(FileMovement fileMovement) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileMovement)) {
				fileMovement = (FileMovement)session.get(
					FileMovementImpl.class, fileMovement.getPrimaryKeyObj());
			}

			if (fileMovement != null) {
				session.delete(fileMovement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fileMovement != null) {
			clearCache(fileMovement);
		}

		return fileMovement;
	}

	@Override
	public FileMovement updateImpl(FileMovement fileMovement) {
		boolean isNew = fileMovement.isNew();

		if (!(fileMovement instanceof FileMovementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fileMovement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fileMovement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fileMovement proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FileMovement implementation " +
					fileMovement.getClass());
		}

		FileMovementModelImpl fileMovementModelImpl =
			(FileMovementModelImpl)fileMovement;

		if (Validator.isNull(fileMovement.getUuid())) {
			String uuid = _portalUUID.generate();

			fileMovement.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (fileMovement.getCreateDate() == null)) {
			if (serviceContext == null) {
				fileMovement.setCreateDate(date);
			}
			else {
				fileMovement.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!fileMovementModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fileMovement.setModifiedDate(date);
			}
			else {
				fileMovement.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fileMovement);
			}
			else {
				fileMovement = (FileMovement)session.merge(fileMovement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FileMovementImpl.class, fileMovementModelImpl, false, true);

		cacheUniqueFindersCache(fileMovementModelImpl);

		if (isNew) {
			fileMovement.setNew(false);
		}

		fileMovement.resetOriginalValues();

		return fileMovement;
	}

	/**
	 * Returns the file movement with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file movement
	 * @return the file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	@Override
	public FileMovement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileMovementException {

		FileMovement fileMovement = fetchByPrimaryKey(primaryKey);

		if (fileMovement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileMovementException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fileMovement;
	}

	/**
	 * Returns the file movement with the primary key or throws a <code>NoSuchFileMovementException</code> if it could not be found.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement
	 * @throws NoSuchFileMovementException if a file movement with the primary key could not be found
	 */
	@Override
	public FileMovement findByPrimaryKey(long fmId)
		throws NoSuchFileMovementException {

		return findByPrimaryKey((Serializable)fmId);
	}

	/**
	 * Returns the file movement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fmId the primary key of the file movement
	 * @return the file movement, or <code>null</code> if a file movement with the primary key could not be found
	 */
	@Override
	public FileMovement fetchByPrimaryKey(long fmId) {
		return fetchByPrimaryKey((Serializable)fmId);
	}

	/**
	 * Returns all the file movements.
	 *
	 * @return the file movements
	 */
	@Override
	public List<FileMovement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @return the range of file movements
	 */
	@Override
	public List<FileMovement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file movements
	 */
	@Override
	public List<FileMovement> findAll(
		int start, int end, OrderByComparator<FileMovement> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file movements
	 * @param end the upper bound of the range of file movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file movements
	 */
	@Override
	public List<FileMovement> findAll(
		int start, int end, OrderByComparator<FileMovement> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<FileMovement> list = null;

		if (useFinderCache) {
			list = (List<FileMovement>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FILEMOVEMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FILEMOVEMENT;

				sql = sql.concat(FileMovementModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FileMovement>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the file movements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FileMovement fileMovement : findAll()) {
			remove(fileMovement);
		}
	}

	/**
	 * Returns the number of file movements.
	 *
	 * @return the number of file movements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FILEMOVEMENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "fmId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FILEMOVEMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FileMovementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the file movement persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByfileId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByfileId",
			new String[] {Long.class.getName()}, new String[] {"fileId"}, true);

		_finderPathCountByfileId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfileId",
			new String[] {Long.class.getName()}, new String[] {"fileId"},
			false);

		_setFileMovementUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFileMovementUtilPersistence(null);

		entityCache.removeCache(FileMovementImpl.class.getName());
	}

	private void _setFileMovementUtilPersistence(
		FileMovementPersistence fileMovementPersistence) {

		try {
			Field field = FileMovementUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, fileMovementPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = JET_PROCESSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = JET_PROCESSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = JET_PROCESSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FILEMOVEMENT =
		"SELECT fileMovement FROM FileMovement fileMovement";

	private static final String _SQL_SELECT_FILEMOVEMENT_WHERE =
		"SELECT fileMovement FROM FileMovement fileMovement WHERE ";

	private static final String _SQL_COUNT_FILEMOVEMENT =
		"SELECT COUNT(fileMovement) FROM FileMovement fileMovement";

	private static final String _SQL_COUNT_FILEMOVEMENT_WHERE =
		"SELECT COUNT(fileMovement) FROM FileMovement fileMovement WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fileMovement.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FileMovement exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FileMovement exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FileMovementPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FileMovementModelArgumentsResolver
		_fileMovementModelArgumentsResolver;

}