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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import io.jetprocess.exception.NoSuchFileCloseDetailException;
import io.jetprocess.model.FileCloseDetail;
import io.jetprocess.model.FileCloseDetailTable;
import io.jetprocess.model.impl.FileCloseDetailImpl;
import io.jetprocess.model.impl.FileCloseDetailModelImpl;
import io.jetprocess.service.persistence.FileCloseDetailPersistence;
import io.jetprocess.service.persistence.FileCloseDetailUtil;
import io.jetprocess.service.persistence.impl.constants.JET_PROCESSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the file close detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FileCloseDetailPersistence.class, BasePersistence.class})
public class FileCloseDetailPersistenceImpl
	extends BasePersistenceImpl<FileCloseDetail>
	implements FileCloseDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FileCloseDetailUtil</code> to access the file close detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FileCloseDetailImpl.class.getName();

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
	 * Returns all the file close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file close details
	 */
	@Override
	public List<FileCloseDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @return the range of matching file close details
	 */
	@Override
	public List<FileCloseDetail> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file close details
	 */
	@Override
	public List<FileCloseDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileCloseDetail> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file close details
	 */
	@Override
	public List<FileCloseDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileCloseDetail> orderByComparator,
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

		List<FileCloseDetail> list = null;

		if (useFinderCache) {
			list = (List<FileCloseDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileCloseDetail fileCloseDetail : list) {
					if (!uuid.equals(fileCloseDetail.getUuid())) {
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

			sb.append(_SQL_SELECT_FILECLOSEDETAIL_WHERE);

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
				sb.append(FileCloseDetailModelImpl.ORDER_BY_JPQL);
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

				list = (List<FileCloseDetail>)QueryUtil.list(
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
	 * Returns the first file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail findByUuid_First(
			String uuid, OrderByComparator<FileCloseDetail> orderByComparator)
		throws NoSuchFileCloseDetailException {

		FileCloseDetail fileCloseDetail = fetchByUuid_First(
			uuid, orderByComparator);

		if (fileCloseDetail != null) {
			return fileCloseDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileCloseDetailException(sb.toString());
	}

	/**
	 * Returns the first file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail fetchByUuid_First(
		String uuid, OrderByComparator<FileCloseDetail> orderByComparator) {

		List<FileCloseDetail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail findByUuid_Last(
			String uuid, OrderByComparator<FileCloseDetail> orderByComparator)
		throws NoSuchFileCloseDetailException {

		FileCloseDetail fileCloseDetail = fetchByUuid_Last(
			uuid, orderByComparator);

		if (fileCloseDetail != null) {
			return fileCloseDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileCloseDetailException(sb.toString());
	}

	/**
	 * Returns the last file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail fetchByUuid_Last(
		String uuid, OrderByComparator<FileCloseDetail> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FileCloseDetail> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file close details before and after the current file close detail in the ordered set where uuid = &#63;.
	 *
	 * @param fileClosedId the primary key of the current file close detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file close detail
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	@Override
	public FileCloseDetail[] findByUuid_PrevAndNext(
			long fileClosedId, String uuid,
			OrderByComparator<FileCloseDetail> orderByComparator)
		throws NoSuchFileCloseDetailException {

		uuid = Objects.toString(uuid, "");

		FileCloseDetail fileCloseDetail = findByPrimaryKey(fileClosedId);

		Session session = null;

		try {
			session = openSession();

			FileCloseDetail[] array = new FileCloseDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fileCloseDetail, uuid, orderByComparator, true);

			array[1] = fileCloseDetail;

			array[2] = getByUuid_PrevAndNext(
				session, fileCloseDetail, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileCloseDetail getByUuid_PrevAndNext(
		Session session, FileCloseDetail fileCloseDetail, String uuid,
		OrderByComparator<FileCloseDetail> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FILECLOSEDETAIL_WHERE);

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
			sb.append(FileCloseDetailModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						fileCloseDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileCloseDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file close details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FileCloseDetail fileCloseDetail :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fileCloseDetail);
		}
	}

	/**
	 * Returns the number of file close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file close details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILECLOSEDETAIL_WHERE);

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
		"fileCloseDetail.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fileCloseDetail.uuid IS NULL OR fileCloseDetail.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the file close detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileCloseDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchFileCloseDetailException {

		FileCloseDetail fileCloseDetail = fetchByUUID_G(uuid, groupId);

		if (fileCloseDetail == null) {
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

			throw new NoSuchFileCloseDetailException(sb.toString());
		}

		return fileCloseDetail;
	}

	/**
	 * Returns the file close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the file close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail fetchByUUID_G(
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

		if (result instanceof FileCloseDetail) {
			FileCloseDetail fileCloseDetail = (FileCloseDetail)result;

			if (!Objects.equals(uuid, fileCloseDetail.getUuid()) ||
				(groupId != fileCloseDetail.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FILECLOSEDETAIL_WHERE);

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

				List<FileCloseDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FileCloseDetail fileCloseDetail = list.get(0);

					result = fileCloseDetail;

					cacheResult(fileCloseDetail);
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
			return (FileCloseDetail)result;
		}
	}

	/**
	 * Removes the file close detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file close detail that was removed
	 */
	@Override
	public FileCloseDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileCloseDetailException {

		FileCloseDetail fileCloseDetail = findByUUID_G(uuid, groupId);

		return remove(fileCloseDetail);
	}

	/**
	 * Returns the number of file close details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file close details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILECLOSEDETAIL_WHERE);

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
		"fileCloseDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(fileCloseDetail.uuid IS NULL OR fileCloseDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"fileCloseDetail.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file close details
	 */
	@Override
	public List<FileCloseDetail> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @return the range of matching file close details
	 */
	@Override
	public List<FileCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file close details
	 */
	@Override
	public List<FileCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCloseDetail> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file close details
	 */
	@Override
	public List<FileCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCloseDetail> orderByComparator,
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

		List<FileCloseDetail> list = null;

		if (useFinderCache) {
			list = (List<FileCloseDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileCloseDetail fileCloseDetail : list) {
					if (!uuid.equals(fileCloseDetail.getUuid()) ||
						(companyId != fileCloseDetail.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FILECLOSEDETAIL_WHERE);

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
				sb.append(FileCloseDetailModelImpl.ORDER_BY_JPQL);
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

				list = (List<FileCloseDetail>)QueryUtil.list(
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
	 * Returns the first file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileCloseDetail> orderByComparator)
		throws NoSuchFileCloseDetailException {

		FileCloseDetail fileCloseDetail = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (fileCloseDetail != null) {
			return fileCloseDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileCloseDetailException(sb.toString());
	}

	/**
	 * Returns the first file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileCloseDetail> orderByComparator) {

		List<FileCloseDetail> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file close detail
	 * @throws NoSuchFileCloseDetailException if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileCloseDetail> orderByComparator)
		throws NoSuchFileCloseDetailException {

		FileCloseDetail fileCloseDetail = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (fileCloseDetail != null) {
			return fileCloseDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileCloseDetailException(sb.toString());
	}

	/**
	 * Returns the last file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file close detail, or <code>null</code> if a matching file close detail could not be found
	 */
	@Override
	public FileCloseDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileCloseDetail> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FileCloseDetail> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file close details before and after the current file close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileClosedId the primary key of the current file close detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file close detail
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	@Override
	public FileCloseDetail[] findByUuid_C_PrevAndNext(
			long fileClosedId, String uuid, long companyId,
			OrderByComparator<FileCloseDetail> orderByComparator)
		throws NoSuchFileCloseDetailException {

		uuid = Objects.toString(uuid, "");

		FileCloseDetail fileCloseDetail = findByPrimaryKey(fileClosedId);

		Session session = null;

		try {
			session = openSession();

			FileCloseDetail[] array = new FileCloseDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, fileCloseDetail, uuid, companyId, orderByComparator,
				true);

			array[1] = fileCloseDetail;

			array[2] = getByUuid_C_PrevAndNext(
				session, fileCloseDetail, uuid, companyId, orderByComparator,
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

	protected FileCloseDetail getByUuid_C_PrevAndNext(
		Session session, FileCloseDetail fileCloseDetail, String uuid,
		long companyId, OrderByComparator<FileCloseDetail> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FILECLOSEDETAIL_WHERE);

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
			sb.append(FileCloseDetailModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						fileCloseDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileCloseDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file close details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FileCloseDetail fileCloseDetail :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileCloseDetail);
		}
	}

	/**
	 * Returns the number of file close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file close details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILECLOSEDETAIL_WHERE);

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
		"fileCloseDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(fileCloseDetail.uuid IS NULL OR fileCloseDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"fileCloseDetail.companyId = ?";

	public FileCloseDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FileCloseDetail.class);

		setModelImplClass(FileCloseDetailImpl.class);
		setModelPKClass(long.class);

		setTable(FileCloseDetailTable.INSTANCE);
	}

	/**
	 * Caches the file close detail in the entity cache if it is enabled.
	 *
	 * @param fileCloseDetail the file close detail
	 */
	@Override
	public void cacheResult(FileCloseDetail fileCloseDetail) {
		entityCache.putResult(
			FileCloseDetailImpl.class, fileCloseDetail.getPrimaryKey(),
			fileCloseDetail);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				fileCloseDetail.getUuid(), fileCloseDetail.getGroupId()
			},
			fileCloseDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the file close details in the entity cache if it is enabled.
	 *
	 * @param fileCloseDetails the file close details
	 */
	@Override
	public void cacheResult(List<FileCloseDetail> fileCloseDetails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fileCloseDetails.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FileCloseDetail fileCloseDetail : fileCloseDetails) {
			if (entityCache.getResult(
					FileCloseDetailImpl.class,
					fileCloseDetail.getPrimaryKey()) == null) {

				cacheResult(fileCloseDetail);
			}
		}
	}

	/**
	 * Clears the cache for all file close details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FileCloseDetailImpl.class);

		finderCache.clearCache(FileCloseDetailImpl.class);
	}

	/**
	 * Clears the cache for the file close detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileCloseDetail fileCloseDetail) {
		entityCache.removeResult(FileCloseDetailImpl.class, fileCloseDetail);
	}

	@Override
	public void clearCache(List<FileCloseDetail> fileCloseDetails) {
		for (FileCloseDetail fileCloseDetail : fileCloseDetails) {
			entityCache.removeResult(
				FileCloseDetailImpl.class, fileCloseDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FileCloseDetailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FileCloseDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FileCloseDetailModelImpl fileCloseDetailModelImpl) {

		Object[] args = new Object[] {
			fileCloseDetailModelImpl.getUuid(),
			fileCloseDetailModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, fileCloseDetailModelImpl);
	}

	/**
	 * Creates a new file close detail with the primary key. Does not add the file close detail to the database.
	 *
	 * @param fileClosedId the primary key for the new file close detail
	 * @return the new file close detail
	 */
	@Override
	public FileCloseDetail create(long fileClosedId) {
		FileCloseDetail fileCloseDetail = new FileCloseDetailImpl();

		fileCloseDetail.setNew(true);
		fileCloseDetail.setPrimaryKey(fileClosedId);

		String uuid = _portalUUID.generate();

		fileCloseDetail.setUuid(uuid);

		fileCloseDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return fileCloseDetail;
	}

	/**
	 * Removes the file close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail that was removed
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	@Override
	public FileCloseDetail remove(long fileClosedId)
		throws NoSuchFileCloseDetailException {

		return remove((Serializable)fileClosedId);
	}

	/**
	 * Removes the file close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file close detail
	 * @return the file close detail that was removed
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	@Override
	public FileCloseDetail remove(Serializable primaryKey)
		throws NoSuchFileCloseDetailException {

		Session session = null;

		try {
			session = openSession();

			FileCloseDetail fileCloseDetail = (FileCloseDetail)session.get(
				FileCloseDetailImpl.class, primaryKey);

			if (fileCloseDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileCloseDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fileCloseDetail);
		}
		catch (NoSuchFileCloseDetailException noSuchEntityException) {
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
	protected FileCloseDetail removeImpl(FileCloseDetail fileCloseDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileCloseDetail)) {
				fileCloseDetail = (FileCloseDetail)session.get(
					FileCloseDetailImpl.class,
					fileCloseDetail.getPrimaryKeyObj());
			}

			if (fileCloseDetail != null) {
				session.delete(fileCloseDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fileCloseDetail != null) {
			clearCache(fileCloseDetail);
		}

		return fileCloseDetail;
	}

	@Override
	public FileCloseDetail updateImpl(FileCloseDetail fileCloseDetail) {
		boolean isNew = fileCloseDetail.isNew();

		if (!(fileCloseDetail instanceof FileCloseDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fileCloseDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fileCloseDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fileCloseDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FileCloseDetail implementation " +
					fileCloseDetail.getClass());
		}

		FileCloseDetailModelImpl fileCloseDetailModelImpl =
			(FileCloseDetailModelImpl)fileCloseDetail;

		if (Validator.isNull(fileCloseDetail.getUuid())) {
			String uuid = _portalUUID.generate();

			fileCloseDetail.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (fileCloseDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				fileCloseDetail.setCreateDate(date);
			}
			else {
				fileCloseDetail.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!fileCloseDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fileCloseDetail.setModifiedDate(date);
			}
			else {
				fileCloseDetail.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fileCloseDetail);
			}
			else {
				fileCloseDetail = (FileCloseDetail)session.merge(
					fileCloseDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FileCloseDetailImpl.class, fileCloseDetailModelImpl, false, true);

		cacheUniqueFindersCache(fileCloseDetailModelImpl);

		if (isNew) {
			fileCloseDetail.setNew(false);
		}

		fileCloseDetail.resetOriginalValues();

		return fileCloseDetail;
	}

	/**
	 * Returns the file close detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file close detail
	 * @return the file close detail
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	@Override
	public FileCloseDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileCloseDetailException {

		FileCloseDetail fileCloseDetail = fetchByPrimaryKey(primaryKey);

		if (fileCloseDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileCloseDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fileCloseDetail;
	}

	/**
	 * Returns the file close detail with the primary key or throws a <code>NoSuchFileCloseDetailException</code> if it could not be found.
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail
	 * @throws NoSuchFileCloseDetailException if a file close detail with the primary key could not be found
	 */
	@Override
	public FileCloseDetail findByPrimaryKey(long fileClosedId)
		throws NoSuchFileCloseDetailException {

		return findByPrimaryKey((Serializable)fileClosedId);
	}

	/**
	 * Returns the file close detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileClosedId the primary key of the file close detail
	 * @return the file close detail, or <code>null</code> if a file close detail with the primary key could not be found
	 */
	@Override
	public FileCloseDetail fetchByPrimaryKey(long fileClosedId) {
		return fetchByPrimaryKey((Serializable)fileClosedId);
	}

	/**
	 * Returns all the file close details.
	 *
	 * @return the file close details
	 */
	@Override
	public List<FileCloseDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @return the range of file close details
	 */
	@Override
	public List<FileCloseDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file close details
	 */
	@Override
	public List<FileCloseDetail> findAll(
		int start, int end,
		OrderByComparator<FileCloseDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file close details
	 * @param end the upper bound of the range of file close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file close details
	 */
	@Override
	public List<FileCloseDetail> findAll(
		int start, int end,
		OrderByComparator<FileCloseDetail> orderByComparator,
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

		List<FileCloseDetail> list = null;

		if (useFinderCache) {
			list = (List<FileCloseDetail>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FILECLOSEDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FILECLOSEDETAIL;

				sql = sql.concat(FileCloseDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FileCloseDetail>)QueryUtil.list(
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
	 * Removes all the file close details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FileCloseDetail fileCloseDetail : findAll()) {
			remove(fileCloseDetail);
		}
	}

	/**
	 * Returns the number of file close details.
	 *
	 * @return the number of file close details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FILECLOSEDETAIL);

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
		return "fileClosedId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FILECLOSEDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FileCloseDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the file close detail persistence.
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

		_setFileCloseDetailUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFileCloseDetailUtilPersistence(null);

		entityCache.removeCache(FileCloseDetailImpl.class.getName());
	}

	private void _setFileCloseDetailUtilPersistence(
		FileCloseDetailPersistence fileCloseDetailPersistence) {

		try {
			Field field = FileCloseDetailUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, fileCloseDetailPersistence);
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

	private static final String _SQL_SELECT_FILECLOSEDETAIL =
		"SELECT fileCloseDetail FROM FileCloseDetail fileCloseDetail";

	private static final String _SQL_SELECT_FILECLOSEDETAIL_WHERE =
		"SELECT fileCloseDetail FROM FileCloseDetail fileCloseDetail WHERE ";

	private static final String _SQL_COUNT_FILECLOSEDETAIL =
		"SELECT COUNT(fileCloseDetail) FROM FileCloseDetail fileCloseDetail";

	private static final String _SQL_COUNT_FILECLOSEDETAIL_WHERE =
		"SELECT COUNT(fileCloseDetail) FROM FileCloseDetail fileCloseDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fileCloseDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FileCloseDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FileCloseDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FileCloseDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FileCloseDetailModelArgumentsResolver
		_fileCloseDetailModelArgumentsResolver;

}