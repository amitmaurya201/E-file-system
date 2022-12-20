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

import io.jetprocess.exception.NoSuchDocFileException;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.DocFileTable;
import io.jetprocess.model.impl.DocFileImpl;
import io.jetprocess.model.impl.DocFileModelImpl;
import io.jetprocess.service.persistence.DocFilePersistence;
import io.jetprocess.service.persistence.DocFileUtil;
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
 * The persistence implementation for the doc file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DocFilePersistence.class, BasePersistence.class})
public class DocFilePersistenceImpl
	extends BasePersistenceImpl<DocFile> implements DocFilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocFileUtil</code> to access the doc file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocFileImpl.class.getName();

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
	 * Returns all the doc files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching doc files
	 */
	@Override
	public List<DocFile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doc files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of matching doc files
	 */
	@Override
	public List<DocFile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the doc files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doc files
	 */
	@Override
	public List<DocFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocFile> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doc files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doc files
	 */
	@Override
	public List<DocFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocFile> orderByComparator, boolean useFinderCache) {

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

		List<DocFile> list = null;

		if (useFinderCache) {
			list = (List<DocFile>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DocFile docFile : list) {
					if (!uuid.equals(docFile.getUuid())) {
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

			sb.append(_SQL_SELECT_DOCFILE_WHERE);

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
				sb.append(DocFileModelImpl.ORDER_BY_JPQL);
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

				list = (List<DocFile>)QueryUtil.list(
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
	 * Returns the first doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findByUuid_First(
			String uuid, OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		DocFile docFile = fetchByUuid_First(uuid, orderByComparator);

		if (docFile != null) {
			return docFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocFileException(sb.toString());
	}

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByUuid_First(
		String uuid, OrderByComparator<DocFile> orderByComparator) {

		List<DocFile> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findByUuid_Last(
			String uuid, OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		DocFile docFile = fetchByUuid_Last(uuid, orderByComparator);

		if (docFile != null) {
			return docFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocFileException(sb.toString());
	}

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByUuid_Last(
		String uuid, OrderByComparator<DocFile> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DocFile> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the doc files before and after the current doc file in the ordered set where uuid = &#63;.
	 *
	 * @param docFileId the primary key of the current doc file
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	@Override
	public DocFile[] findByUuid_PrevAndNext(
			long docFileId, String uuid,
			OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		uuid = Objects.toString(uuid, "");

		DocFile docFile = findByPrimaryKey(docFileId);

		Session session = null;

		try {
			session = openSession();

			DocFile[] array = new DocFileImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, docFile, uuid, orderByComparator, true);

			array[1] = docFile;

			array[2] = getByUuid_PrevAndNext(
				session, docFile, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocFile getByUuid_PrevAndNext(
		Session session, DocFile docFile, String uuid,
		OrderByComparator<DocFile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCFILE_WHERE);

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
			sb.append(DocFileModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(docFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doc files where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DocFile docFile :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(docFile);
		}
	}

	/**
	 * Returns the number of doc files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching doc files
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCFILE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "docFile.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(docFile.uuid IS NULL OR docFile.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findByUUID_G(String uuid, long groupId)
		throws NoSuchDocFileException {

		DocFile docFile = fetchByUUID_G(uuid, groupId);

		if (docFile == null) {
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

			throw new NoSuchDocFileException(sb.toString());
		}

		return docFile;
	}

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the doc file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByUUID_G(
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

		if (result instanceof DocFile) {
			DocFile docFile = (DocFile)result;

			if (!Objects.equals(uuid, docFile.getUuid()) ||
				(groupId != docFile.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DOCFILE_WHERE);

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

				List<DocFile> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DocFile docFile = list.get(0);

					result = docFile;

					cacheResult(docFile);
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
			return (DocFile)result;
		}
	}

	/**
	 * Removes the doc file where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the doc file that was removed
	 */
	@Override
	public DocFile removeByUUID_G(String uuid, long groupId)
		throws NoSuchDocFileException {

		DocFile docFile = findByUUID_G(uuid, groupId);

		return remove(docFile);
	}

	/**
	 * Returns the number of doc files where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching doc files
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCFILE_WHERE);

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
		"docFile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(docFile.uuid IS NULL OR docFile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"docFile.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching doc files
	 */
	@Override
	public List<DocFile> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of matching doc files
	 */
	@Override
	public List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doc files
	 */
	@Override
	public List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocFile> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doc files
	 */
	@Override
	public List<DocFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocFile> orderByComparator, boolean useFinderCache) {

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

		List<DocFile> list = null;

		if (useFinderCache) {
			list = (List<DocFile>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DocFile docFile : list) {
					if (!uuid.equals(docFile.getUuid()) ||
						(companyId != docFile.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DOCFILE_WHERE);

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
				sb.append(DocFileModelImpl.ORDER_BY_JPQL);
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

				list = (List<DocFile>)QueryUtil.list(
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
	 * Returns the first doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		DocFile docFile = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (docFile != null) {
			return docFile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDocFileException(sb.toString());
	}

	/**
	 * Returns the first doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DocFile> orderByComparator) {

		List<DocFile> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		DocFile docFile = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (docFile != null) {
			return docFile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDocFileException(sb.toString());
	}

	/**
	 * Returns the last doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DocFile> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DocFile> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the doc files before and after the current doc file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param docFileId the primary key of the current doc file
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	@Override
	public DocFile[] findByUuid_C_PrevAndNext(
			long docFileId, String uuid, long companyId,
			OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		uuid = Objects.toString(uuid, "");

		DocFile docFile = findByPrimaryKey(docFileId);

		Session session = null;

		try {
			session = openSession();

			DocFile[] array = new DocFileImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, docFile, uuid, companyId, orderByComparator, true);

			array[1] = docFile;

			array[2] = getByUuid_C_PrevAndNext(
				session, docFile, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocFile getByUuid_C_PrevAndNext(
		Session session, DocFile docFile, String uuid, long companyId,
		OrderByComparator<DocFile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DOCFILE_WHERE);

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
			sb.append(DocFileModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(docFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doc files where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DocFile docFile :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(docFile);
		}
	}

	/**
	 * Returns the number of doc files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching doc files
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCFILE_WHERE);

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
		"docFile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(docFile.uuid IS NULL OR docFile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"docFile.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBygroupId;
	private FinderPath _finderPathWithoutPaginationFindBygroupId;
	private FinderPath _finderPathCountBygroupId;

	/**
	 * Returns all the doc files where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching doc files
	 */
	@Override
	public List<DocFile> findBygroupId(long groupId) {
		return findBygroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doc files where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of matching doc files
	 */
	@Override
	public List<DocFile> findBygroupId(long groupId, int start, int end) {
		return findBygroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the doc files where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doc files
	 */
	@Override
	public List<DocFile> findBygroupId(
		long groupId, int start, int end,
		OrderByComparator<DocFile> orderByComparator) {

		return findBygroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doc files where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doc files
	 */
	@Override
	public List<DocFile> findBygroupId(
		long groupId, int start, int end,
		OrderByComparator<DocFile> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBygroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<DocFile> list = null;

		if (useFinderCache) {
			list = (List<DocFile>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DocFile docFile : list) {
					if (groupId != docFile.getGroupId()) {
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

			sb.append(_SQL_SELECT_DOCFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<DocFile>)QueryUtil.list(
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
	 * Returns the first doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findBygroupId_First(
			long groupId, OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		DocFile docFile = fetchBygroupId_First(groupId, orderByComparator);

		if (docFile != null) {
			return docFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDocFileException(sb.toString());
	}

	/**
	 * Returns the first doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchBygroupId_First(
		long groupId, OrderByComparator<DocFile> orderByComparator) {

		List<DocFile> list = findBygroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findBygroupId_Last(
			long groupId, OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		DocFile docFile = fetchBygroupId_Last(groupId, orderByComparator);

		if (docFile != null) {
			return docFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDocFileException(sb.toString());
	}

	/**
	 * Returns the last doc file in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchBygroupId_Last(
		long groupId, OrderByComparator<DocFile> orderByComparator) {

		int count = countBygroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DocFile> list = findBygroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the doc files before and after the current doc file in the ordered set where groupId = &#63;.
	 *
	 * @param docFileId the primary key of the current doc file
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	@Override
	public DocFile[] findBygroupId_PrevAndNext(
			long docFileId, long groupId,
			OrderByComparator<DocFile> orderByComparator)
		throws NoSuchDocFileException {

		DocFile docFile = findByPrimaryKey(docFileId);

		Session session = null;

		try {
			session = openSession();

			DocFile[] array = new DocFileImpl[3];

			array[0] = getBygroupId_PrevAndNext(
				session, docFile, groupId, orderByComparator, true);

			array[1] = docFile;

			array[2] = getBygroupId_PrevAndNext(
				session, docFile, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocFile getBygroupId_PrevAndNext(
		Session session, DocFile docFile, long groupId,
		OrderByComparator<DocFile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCFILE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(DocFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(docFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doc files where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeBygroupId(long groupId) {
		for (DocFile docFile :
				findBygroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(docFile);
		}
	}

	/**
	 * Returns the number of doc files where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching doc files
	 */
	@Override
	public int countBygroupId(long groupId) {
		FinderPath finderPath = _finderPathCountBygroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"docFile.groupId = ?";

	private FinderPath _finderPathFetchByDocFileId;
	private FinderPath _finderPathCountByDocFileId;

	/**
	 * Returns the doc file where docFileId = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param docFileId the doc file ID
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findByDocFileId(long docFileId)
		throws NoSuchDocFileException {

		DocFile docFile = fetchByDocFileId(docFileId);

		if (docFile == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("docFileId=");
			sb.append(docFileId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocFileException(sb.toString());
		}

		return docFile;
	}

	/**
	 * Returns the doc file where docFileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param docFileId the doc file ID
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByDocFileId(long docFileId) {
		return fetchByDocFileId(docFileId, true);
	}

	/**
	 * Returns the doc file where docFileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param docFileId the doc file ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByDocFileId(long docFileId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {docFileId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDocFileId, finderArgs);
		}

		if (result instanceof DocFile) {
			DocFile docFile = (DocFile)result;

			if (docFileId != docFile.getDocFileId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCFILE_WHERE);

			sb.append(_FINDER_COLUMN_DOCFILEID_DOCFILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(docFileId);

				List<DocFile> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDocFileId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {docFileId};
							}

							_log.warn(
								"DocFilePersistenceImpl.fetchByDocFileId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocFile docFile = list.get(0);

					result = docFile;

					cacheResult(docFile);
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
			return (DocFile)result;
		}
	}

	/**
	 * Removes the doc file where docFileId = &#63; from the database.
	 *
	 * @param docFileId the doc file ID
	 * @return the doc file that was removed
	 */
	@Override
	public DocFile removeByDocFileId(long docFileId)
		throws NoSuchDocFileException {

		DocFile docFile = findByDocFileId(docFileId);

		return remove(docFile);
	}

	/**
	 * Returns the number of doc files where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @return the number of matching doc files
	 */
	@Override
	public int countByDocFileId(long docFileId) {
		FinderPath finderPath = _finderPathCountByDocFileId;

		Object[] finderArgs = new Object[] {docFileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCFILE_WHERE);

			sb.append(_FINDER_COLUMN_DOCFILEID_DOCFILEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(docFileId);

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

	private static final String _FINDER_COLUMN_DOCFILEID_DOCFILEID_2 =
		"docFile.docFileId = ?";

	private FinderPath _finderPathFetchByNature;
	private FinderPath _finderPathCountByNature;

	/**
	 * Returns the doc file where nature = &#63; or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param nature the nature
	 * @return the matching doc file
	 * @throws NoSuchDocFileException if a matching doc file could not be found
	 */
	@Override
	public DocFile findByNature(String nature) throws NoSuchDocFileException {
		DocFile docFile = fetchByNature(nature);

		if (docFile == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nature=");
			sb.append(nature);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocFileException(sb.toString());
		}

		return docFile;
	}

	/**
	 * Returns the doc file where nature = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nature the nature
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByNature(String nature) {
		return fetchByNature(nature, true);
	}

	/**
	 * Returns the doc file where nature = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nature the nature
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc file, or <code>null</code> if a matching doc file could not be found
	 */
	@Override
	public DocFile fetchByNature(String nature, boolean useFinderCache) {
		nature = Objects.toString(nature, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nature};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByNature, finderArgs);
		}

		if (result instanceof DocFile) {
			DocFile docFile = (DocFile)result;

			if (!Objects.equals(nature, docFile.getNature())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCFILE_WHERE);

			boolean bindNature = false;

			if (nature.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATURE_NATURE_3);
			}
			else {
				bindNature = true;

				sb.append(_FINDER_COLUMN_NATURE_NATURE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNature) {
					queryPos.add(nature);
				}

				List<DocFile> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByNature, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {nature};
							}

							_log.warn(
								"DocFilePersistenceImpl.fetchByNature(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocFile docFile = list.get(0);

					result = docFile;

					cacheResult(docFile);
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
			return (DocFile)result;
		}
	}

	/**
	 * Removes the doc file where nature = &#63; from the database.
	 *
	 * @param nature the nature
	 * @return the doc file that was removed
	 */
	@Override
	public DocFile removeByNature(String nature) throws NoSuchDocFileException {
		DocFile docFile = findByNature(nature);

		return remove(docFile);
	}

	/**
	 * Returns the number of doc files where nature = &#63;.
	 *
	 * @param nature the nature
	 * @return the number of matching doc files
	 */
	@Override
	public int countByNature(String nature) {
		nature = Objects.toString(nature, "");

		FinderPath finderPath = _finderPathCountByNature;

		Object[] finderArgs = new Object[] {nature};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCFILE_WHERE);

			boolean bindNature = false;

			if (nature.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATURE_NATURE_3);
			}
			else {
				bindNature = true;

				sb.append(_FINDER_COLUMN_NATURE_NATURE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNature) {
					queryPos.add(nature);
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

	private static final String _FINDER_COLUMN_NATURE_NATURE_2 =
		"docFile.nature = ?";

	private static final String _FINDER_COLUMN_NATURE_NATURE_3 =
		"(docFile.nature IS NULL OR docFile.nature = '')";

	public DocFilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DocFile.class);

		setModelImplClass(DocFileImpl.class);
		setModelPKClass(long.class);

		setTable(DocFileTable.INSTANCE);
	}

	/**
	 * Caches the doc file in the entity cache if it is enabled.
	 *
	 * @param docFile the doc file
	 */
	@Override
	public void cacheResult(DocFile docFile) {
		entityCache.putResult(
			DocFileImpl.class, docFile.getPrimaryKey(), docFile);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {docFile.getUuid(), docFile.getGroupId()}, docFile);

		finderCache.putResult(
			_finderPathFetchByDocFileId, new Object[] {docFile.getDocFileId()},
			docFile);

		finderCache.putResult(
			_finderPathFetchByNature, new Object[] {docFile.getNature()},
			docFile);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the doc files in the entity cache if it is enabled.
	 *
	 * @param docFiles the doc files
	 */
	@Override
	public void cacheResult(List<DocFile> docFiles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (docFiles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DocFile docFile : docFiles) {
			if (entityCache.getResult(
					DocFileImpl.class, docFile.getPrimaryKey()) == null) {

				cacheResult(docFile);
			}
		}
	}

	/**
	 * Clears the cache for all doc files.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocFileImpl.class);

		finderCache.clearCache(DocFileImpl.class);
	}

	/**
	 * Clears the cache for the doc file.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocFile docFile) {
		entityCache.removeResult(DocFileImpl.class, docFile);
	}

	@Override
	public void clearCache(List<DocFile> docFiles) {
		for (DocFile docFile : docFiles) {
			entityCache.removeResult(DocFileImpl.class, docFile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DocFileImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocFileImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(DocFileModelImpl docFileModelImpl) {
		Object[] args = new Object[] {
			docFileModelImpl.getUuid(), docFileModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, docFileModelImpl);

		args = new Object[] {docFileModelImpl.getDocFileId()};

		finderCache.putResult(
			_finderPathCountByDocFileId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDocFileId, args, docFileModelImpl);

		args = new Object[] {docFileModelImpl.getNature()};

		finderCache.putResult(_finderPathCountByNature, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByNature, args, docFileModelImpl);
	}

	/**
	 * Creates a new doc file with the primary key. Does not add the doc file to the database.
	 *
	 * @param docFileId the primary key for the new doc file
	 * @return the new doc file
	 */
	@Override
	public DocFile create(long docFileId) {
		DocFile docFile = new DocFileImpl();

		docFile.setNew(true);
		docFile.setPrimaryKey(docFileId);

		String uuid = _portalUUID.generate();

		docFile.setUuid(uuid);

		docFile.setCompanyId(CompanyThreadLocal.getCompanyId());

		return docFile;
	}

	/**
	 * Removes the doc file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file that was removed
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	@Override
	public DocFile remove(long docFileId) throws NoSuchDocFileException {
		return remove((Serializable)docFileId);
	}

	/**
	 * Removes the doc file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doc file
	 * @return the doc file that was removed
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	@Override
	public DocFile remove(Serializable primaryKey)
		throws NoSuchDocFileException {

		Session session = null;

		try {
			session = openSession();

			DocFile docFile = (DocFile)session.get(
				DocFileImpl.class, primaryKey);

			if (docFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocFileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(docFile);
		}
		catch (NoSuchDocFileException noSuchEntityException) {
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
	protected DocFile removeImpl(DocFile docFile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(docFile)) {
				docFile = (DocFile)session.get(
					DocFileImpl.class, docFile.getPrimaryKeyObj());
			}

			if (docFile != null) {
				session.delete(docFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (docFile != null) {
			clearCache(docFile);
		}

		return docFile;
	}

	@Override
	public DocFile updateImpl(DocFile docFile) {
		boolean isNew = docFile.isNew();

		if (!(docFile instanceof DocFileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(docFile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(docFile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in docFile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocFile implementation " +
					docFile.getClass());
		}

		DocFileModelImpl docFileModelImpl = (DocFileModelImpl)docFile;

		if (Validator.isNull(docFile.getUuid())) {
			String uuid = _portalUUID.generate();

			docFile.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (docFile.getCreateDate() == null)) {
			if (serviceContext == null) {
				docFile.setCreateDate(date);
			}
			else {
				docFile.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!docFileModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				docFile.setModifiedDate(date);
			}
			else {
				docFile.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(docFile);
			}
			else {
				docFile = (DocFile)session.merge(docFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DocFileImpl.class, docFileModelImpl, false, true);

		cacheUniqueFindersCache(docFileModelImpl);

		if (isNew) {
			docFile.setNew(false);
		}

		docFile.resetOriginalValues();

		return docFile;
	}

	/**
	 * Returns the doc file with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doc file
	 * @return the doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	@Override
	public DocFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocFileException {

		DocFile docFile = fetchByPrimaryKey(primaryKey);

		if (docFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocFileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return docFile;
	}

	/**
	 * Returns the doc file with the primary key or throws a <code>NoSuchDocFileException</code> if it could not be found.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file
	 * @throws NoSuchDocFileException if a doc file with the primary key could not be found
	 */
	@Override
	public DocFile findByPrimaryKey(long docFileId)
		throws NoSuchDocFileException {

		return findByPrimaryKey((Serializable)docFileId);
	}

	/**
	 * Returns the doc file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docFileId the primary key of the doc file
	 * @return the doc file, or <code>null</code> if a doc file with the primary key could not be found
	 */
	@Override
	public DocFile fetchByPrimaryKey(long docFileId) {
		return fetchByPrimaryKey((Serializable)docFileId);
	}

	/**
	 * Returns all the doc files.
	 *
	 * @return the doc files
	 */
	@Override
	public List<DocFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doc files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @return the range of doc files
	 */
	@Override
	public List<DocFile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the doc files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doc files
	 */
	@Override
	public List<DocFile> findAll(
		int start, int end, OrderByComparator<DocFile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doc files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc files
	 * @param end the upper bound of the range of doc files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of doc files
	 */
	@Override
	public List<DocFile> findAll(
		int start, int end, OrderByComparator<DocFile> orderByComparator,
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

		List<DocFile> list = null;

		if (useFinderCache) {
			list = (List<DocFile>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCFILE;

				sql = sql.concat(DocFileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DocFile>)QueryUtil.list(
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
	 * Removes all the doc files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocFile docFile : findAll()) {
			remove(docFile);
		}
	}

	/**
	 * Returns the number of doc files.
	 *
	 * @return the number of doc files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCFILE);

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
		return "docFileId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the doc file persistence.
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

		_finderPathWithPaginationFindBygroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindBygroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountBygroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathFetchByDocFileId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDocFileId",
			new String[] {Long.class.getName()}, new String[] {"docFileId"},
			true);

		_finderPathCountByDocFileId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocFileId",
			new String[] {Long.class.getName()}, new String[] {"docFileId"},
			false);

		_finderPathFetchByNature = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByNature",
			new String[] {String.class.getName()}, new String[] {"nature"},
			true);

		_finderPathCountByNature = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNature",
			new String[] {String.class.getName()}, new String[] {"nature"},
			false);

		_setDocFileUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDocFileUtilPersistence(null);

		entityCache.removeCache(DocFileImpl.class.getName());
	}

	private void _setDocFileUtilPersistence(
		DocFilePersistence docFilePersistence) {

		try {
			Field field = DocFileUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, docFilePersistence);
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

	private static final String _SQL_SELECT_DOCFILE =
		"SELECT docFile FROM DocFile docFile";

	private static final String _SQL_SELECT_DOCFILE_WHERE =
		"SELECT docFile FROM DocFile docFile WHERE ";

	private static final String _SQL_COUNT_DOCFILE =
		"SELECT COUNT(docFile) FROM DocFile docFile";

	private static final String _SQL_COUNT_DOCFILE_WHERE =
		"SELECT COUNT(docFile) FROM DocFile docFile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "docFile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocFile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocFile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocFilePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private DocFileModelArgumentsResolver _docFileModelArgumentsResolver;

}