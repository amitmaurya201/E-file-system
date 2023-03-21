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

import io.jetprocess.exception.NoSuchDocumentNoteMapException;
import io.jetprocess.model.DocumentNoteMap;
import io.jetprocess.model.DocumentNoteMapTable;
import io.jetprocess.model.impl.DocumentNoteMapImpl;
import io.jetprocess.model.impl.DocumentNoteMapModelImpl;
import io.jetprocess.service.persistence.DocumentNoteMapPersistence;
import io.jetprocess.service.persistence.DocumentNoteMapUtil;
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
 * The persistence implementation for the document note map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DocumentNoteMapPersistence.class, BasePersistence.class})
public class DocumentNoteMapPersistenceImpl
	extends BasePersistenceImpl<DocumentNoteMap>
	implements DocumentNoteMapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentNoteMapUtil</code> to access the document note map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentNoteMapImpl.class.getName();

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
	 * Returns all the document note maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document note maps
	 */
	@Override
	public List<DocumentNoteMap> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of matching document note maps
	 */
	@Override
	public List<DocumentNoteMap> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document note maps
	 */
	@Override
	public List<DocumentNoteMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document note maps
	 */
	@Override
	public List<DocumentNoteMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator,
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

		List<DocumentNoteMap> list = null;

		if (useFinderCache) {
			list = (List<DocumentNoteMap>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentNoteMap documentNoteMap : list) {
					if (!uuid.equals(documentNoteMap.getUuid())) {
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

			sb.append(_SQL_SELECT_DOCUMENTNOTEMAP_WHERE);

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
				sb.append(DocumentNoteMapModelImpl.ORDER_BY_JPQL);
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

				list = (List<DocumentNoteMap>)QueryUtil.list(
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
	 * Returns the first document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap findByUuid_First(
			String uuid, OrderByComparator<DocumentNoteMap> orderByComparator)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = fetchByUuid_First(
			uuid, orderByComparator);

		if (documentNoteMap != null) {
			return documentNoteMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentNoteMapException(sb.toString());
	}

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchByUuid_First(
		String uuid, OrderByComparator<DocumentNoteMap> orderByComparator) {

		List<DocumentNoteMap> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap findByUuid_Last(
			String uuid, OrderByComparator<DocumentNoteMap> orderByComparator)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = fetchByUuid_Last(
			uuid, orderByComparator);

		if (documentNoteMap != null) {
			return documentNoteMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentNoteMapException(sb.toString());
	}

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchByUuid_Last(
		String uuid, OrderByComparator<DocumentNoteMap> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DocumentNoteMap> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document note maps before and after the current document note map in the ordered set where uuid = &#63;.
	 *
	 * @param documentNoteMapId the primary key of the current document note map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	@Override
	public DocumentNoteMap[] findByUuid_PrevAndNext(
			long documentNoteMapId, String uuid,
			OrderByComparator<DocumentNoteMap> orderByComparator)
		throws NoSuchDocumentNoteMapException {

		uuid = Objects.toString(uuid, "");

		DocumentNoteMap documentNoteMap = findByPrimaryKey(documentNoteMapId);

		Session session = null;

		try {
			session = openSession();

			DocumentNoteMap[] array = new DocumentNoteMapImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, documentNoteMap, uuid, orderByComparator, true);

			array[1] = documentNoteMap;

			array[2] = getByUuid_PrevAndNext(
				session, documentNoteMap, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentNoteMap getByUuid_PrevAndNext(
		Session session, DocumentNoteMap documentNoteMap, String uuid,
		OrderByComparator<DocumentNoteMap> orderByComparator,
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

		sb.append(_SQL_SELECT_DOCUMENTNOTEMAP_WHERE);

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
			sb.append(DocumentNoteMapModelImpl.ORDER_BY_JPQL);
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
						documentNoteMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocumentNoteMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document note maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DocumentNoteMap documentNoteMap :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documentNoteMap);
		}
	}

	/**
	 * Returns the number of document note maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document note maps
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTNOTEMAP_WHERE);

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
		"documentNoteMap.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(documentNoteMap.uuid IS NULL OR documentNoteMap.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocumentNoteMapException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap findByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = fetchByUUID_G(uuid, groupId);

		if (documentNoteMap == null) {
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

			throw new NoSuchDocumentNoteMapException(sb.toString());
		}

		return documentNoteMap;
	}

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the document note map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchByUUID_G(
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

		if (result instanceof DocumentNoteMap) {
			DocumentNoteMap documentNoteMap = (DocumentNoteMap)result;

			if (!Objects.equals(uuid, documentNoteMap.getUuid()) ||
				(groupId != documentNoteMap.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DOCUMENTNOTEMAP_WHERE);

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

				List<DocumentNoteMap> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DocumentNoteMap documentNoteMap = list.get(0);

					result = documentNoteMap;

					cacheResult(documentNoteMap);
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
			return (DocumentNoteMap)result;
		}
	}

	/**
	 * Removes the document note map where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the document note map that was removed
	 */
	@Override
	public DocumentNoteMap removeByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = findByUUID_G(uuid, groupId);

		return remove(documentNoteMap);
	}

	/**
	 * Returns the number of document note maps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching document note maps
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCUMENTNOTEMAP_WHERE);

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
		"documentNoteMap.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(documentNoteMap.uuid IS NULL OR documentNoteMap.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"documentNoteMap.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching document note maps
	 */
	@Override
	public List<DocumentNoteMap> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of matching document note maps
	 */
	@Override
	public List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document note maps
	 */
	@Override
	public List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document note maps
	 */
	@Override
	public List<DocumentNoteMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator,
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

		List<DocumentNoteMap> list = null;

		if (useFinderCache) {
			list = (List<DocumentNoteMap>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentNoteMap documentNoteMap : list) {
					if (!uuid.equals(documentNoteMap.getUuid()) ||
						(companyId != documentNoteMap.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DOCUMENTNOTEMAP_WHERE);

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
				sb.append(DocumentNoteMapModelImpl.ORDER_BY_JPQL);
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

				list = (List<DocumentNoteMap>)QueryUtil.list(
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
	 * Returns the first document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DocumentNoteMap> orderByComparator)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (documentNoteMap != null) {
			return documentNoteMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDocumentNoteMapException(sb.toString());
	}

	/**
	 * Returns the first document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		List<DocumentNoteMap> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DocumentNoteMap> orderByComparator)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (documentNoteMap != null) {
			return documentNoteMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDocumentNoteMapException(sb.toString());
	}

	/**
	 * Returns the last document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DocumentNoteMap> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document note maps before and after the current document note map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param documentNoteMapId the primary key of the current document note map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	@Override
	public DocumentNoteMap[] findByUuid_C_PrevAndNext(
			long documentNoteMapId, String uuid, long companyId,
			OrderByComparator<DocumentNoteMap> orderByComparator)
		throws NoSuchDocumentNoteMapException {

		uuid = Objects.toString(uuid, "");

		DocumentNoteMap documentNoteMap = findByPrimaryKey(documentNoteMapId);

		Session session = null;

		try {
			session = openSession();

			DocumentNoteMap[] array = new DocumentNoteMapImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, documentNoteMap, uuid, companyId, orderByComparator,
				true);

			array[1] = documentNoteMap;

			array[2] = getByUuid_C_PrevAndNext(
				session, documentNoteMap, uuid, companyId, orderByComparator,
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

	protected DocumentNoteMap getByUuid_C_PrevAndNext(
		Session session, DocumentNoteMap documentNoteMap, String uuid,
		long companyId, OrderByComparator<DocumentNoteMap> orderByComparator,
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

		sb.append(_SQL_SELECT_DOCUMENTNOTEMAP_WHERE);

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
			sb.append(DocumentNoteMapModelImpl.ORDER_BY_JPQL);
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
						documentNoteMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocumentNoteMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document note maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DocumentNoteMap documentNoteMap :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(documentNoteMap);
		}
	}

	/**
	 * Returns the number of document note maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching document note maps
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCUMENTNOTEMAP_WHERE);

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
		"documentNoteMap.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(documentNoteMap.uuid IS NULL OR documentNoteMap.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"documentNoteMap.companyId = ?";

	private FinderPath _finderPathFetchByfindByMovementId;
	private FinderPath _finderPathCountByfindByMovementId;

	/**
	 * Returns the document note map where movementId = &#63; or throws a <code>NoSuchDocumentNoteMapException</code> if it could not be found.
	 *
	 * @param movementId the movement ID
	 * @return the matching document note map
	 * @throws NoSuchDocumentNoteMapException if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap findByfindByMovementId(long movementId)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = fetchByfindByMovementId(movementId);

		if (documentNoteMap == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("movementId=");
			sb.append(movementId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocumentNoteMapException(sb.toString());
		}

		return documentNoteMap;
	}

	/**
	 * Returns the document note map where movementId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param movementId the movement ID
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchByfindByMovementId(long movementId) {
		return fetchByfindByMovementId(movementId, true);
	}

	/**
	 * Returns the document note map where movementId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param movementId the movement ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document note map, or <code>null</code> if a matching document note map could not be found
	 */
	@Override
	public DocumentNoteMap fetchByfindByMovementId(
		long movementId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {movementId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfindByMovementId, finderArgs);
		}

		if (result instanceof DocumentNoteMap) {
			DocumentNoteMap documentNoteMap = (DocumentNoteMap)result;

			if (movementId != documentNoteMap.getMovementId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCUMENTNOTEMAP_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYMOVEMENTID_MOVEMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(movementId);

				List<DocumentNoteMap> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfindByMovementId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {movementId};
							}

							_log.warn(
								"DocumentNoteMapPersistenceImpl.fetchByfindByMovementId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocumentNoteMap documentNoteMap = list.get(0);

					result = documentNoteMap;

					cacheResult(documentNoteMap);
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
			return (DocumentNoteMap)result;
		}
	}

	/**
	 * Removes the document note map where movementId = &#63; from the database.
	 *
	 * @param movementId the movement ID
	 * @return the document note map that was removed
	 */
	@Override
	public DocumentNoteMap removeByfindByMovementId(long movementId)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = findByfindByMovementId(movementId);

		return remove(documentNoteMap);
	}

	/**
	 * Returns the number of document note maps where movementId = &#63;.
	 *
	 * @param movementId the movement ID
	 * @return the number of matching document note maps
	 */
	@Override
	public int countByfindByMovementId(long movementId) {
		FinderPath finderPath = _finderPathCountByfindByMovementId;

		Object[] finderArgs = new Object[] {movementId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTNOTEMAP_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYMOVEMENTID_MOVEMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(movementId);

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

	private static final String _FINDER_COLUMN_FINDBYMOVEMENTID_MOVEMENTID_2 =
		"documentNoteMap.movementId = ?";

	public DocumentNoteMapPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DocumentNoteMap.class);

		setModelImplClass(DocumentNoteMapImpl.class);
		setModelPKClass(long.class);

		setTable(DocumentNoteMapTable.INSTANCE);
	}

	/**
	 * Caches the document note map in the entity cache if it is enabled.
	 *
	 * @param documentNoteMap the document note map
	 */
	@Override
	public void cacheResult(DocumentNoteMap documentNoteMap) {
		entityCache.putResult(
			DocumentNoteMapImpl.class, documentNoteMap.getPrimaryKey(),
			documentNoteMap);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				documentNoteMap.getUuid(), documentNoteMap.getGroupId()
			},
			documentNoteMap);

		finderCache.putResult(
			_finderPathFetchByfindByMovementId,
			new Object[] {documentNoteMap.getMovementId()}, documentNoteMap);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the document note maps in the entity cache if it is enabled.
	 *
	 * @param documentNoteMaps the document note maps
	 */
	@Override
	public void cacheResult(List<DocumentNoteMap> documentNoteMaps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (documentNoteMaps.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DocumentNoteMap documentNoteMap : documentNoteMaps) {
			if (entityCache.getResult(
					DocumentNoteMapImpl.class,
					documentNoteMap.getPrimaryKey()) == null) {

				cacheResult(documentNoteMap);
			}
		}
	}

	/**
	 * Clears the cache for all document note maps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentNoteMapImpl.class);

		finderCache.clearCache(DocumentNoteMapImpl.class);
	}

	/**
	 * Clears the cache for the document note map.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentNoteMap documentNoteMap) {
		entityCache.removeResult(DocumentNoteMapImpl.class, documentNoteMap);
	}

	@Override
	public void clearCache(List<DocumentNoteMap> documentNoteMaps) {
		for (DocumentNoteMap documentNoteMap : documentNoteMaps) {
			entityCache.removeResult(
				DocumentNoteMapImpl.class, documentNoteMap);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DocumentNoteMapImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocumentNoteMapImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentNoteMapModelImpl documentNoteMapModelImpl) {

		Object[] args = new Object[] {
			documentNoteMapModelImpl.getUuid(),
			documentNoteMapModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, documentNoteMapModelImpl);

		args = new Object[] {documentNoteMapModelImpl.getMovementId()};

		finderCache.putResult(
			_finderPathCountByfindByMovementId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByfindByMovementId, args, documentNoteMapModelImpl);
	}

	/**
	 * Creates a new document note map with the primary key. Does not add the document note map to the database.
	 *
	 * @param documentNoteMapId the primary key for the new document note map
	 * @return the new document note map
	 */
	@Override
	public DocumentNoteMap create(long documentNoteMapId) {
		DocumentNoteMap documentNoteMap = new DocumentNoteMapImpl();

		documentNoteMap.setNew(true);
		documentNoteMap.setPrimaryKey(documentNoteMapId);

		String uuid = _portalUUID.generate();

		documentNoteMap.setUuid(uuid);

		documentNoteMap.setCompanyId(CompanyThreadLocal.getCompanyId());

		return documentNoteMap;
	}

	/**
	 * Removes the document note map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map that was removed
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	@Override
	public DocumentNoteMap remove(long documentNoteMapId)
		throws NoSuchDocumentNoteMapException {

		return remove((Serializable)documentNoteMapId);
	}

	/**
	 * Removes the document note map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document note map
	 * @return the document note map that was removed
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	@Override
	public DocumentNoteMap remove(Serializable primaryKey)
		throws NoSuchDocumentNoteMapException {

		Session session = null;

		try {
			session = openSession();

			DocumentNoteMap documentNoteMap = (DocumentNoteMap)session.get(
				DocumentNoteMapImpl.class, primaryKey);

			if (documentNoteMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentNoteMapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documentNoteMap);
		}
		catch (NoSuchDocumentNoteMapException noSuchEntityException) {
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
	protected DocumentNoteMap removeImpl(DocumentNoteMap documentNoteMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentNoteMap)) {
				documentNoteMap = (DocumentNoteMap)session.get(
					DocumentNoteMapImpl.class,
					documentNoteMap.getPrimaryKeyObj());
			}

			if (documentNoteMap != null) {
				session.delete(documentNoteMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (documentNoteMap != null) {
			clearCache(documentNoteMap);
		}

		return documentNoteMap;
	}

	@Override
	public DocumentNoteMap updateImpl(DocumentNoteMap documentNoteMap) {
		boolean isNew = documentNoteMap.isNew();

		if (!(documentNoteMap instanceof DocumentNoteMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentNoteMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					documentNoteMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentNoteMap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentNoteMap implementation " +
					documentNoteMap.getClass());
		}

		DocumentNoteMapModelImpl documentNoteMapModelImpl =
			(DocumentNoteMapModelImpl)documentNoteMap;

		if (Validator.isNull(documentNoteMap.getUuid())) {
			String uuid = _portalUUID.generate();

			documentNoteMap.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (documentNoteMap.getCreateDate() == null)) {
			if (serviceContext == null) {
				documentNoteMap.setCreateDate(date);
			}
			else {
				documentNoteMap.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!documentNoteMapModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				documentNoteMap.setModifiedDate(date);
			}
			else {
				documentNoteMap.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(documentNoteMap);
			}
			else {
				documentNoteMap = (DocumentNoteMap)session.merge(
					documentNoteMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocumentNoteMapImpl.class, documentNoteMapModelImpl, false, true);

		cacheUniqueFindersCache(documentNoteMapModelImpl);

		if (isNew) {
			documentNoteMap.setNew(false);
		}

		documentNoteMap.resetOriginalValues();

		return documentNoteMap;
	}

	/**
	 * Returns the document note map with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document note map
	 * @return the document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	@Override
	public DocumentNoteMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentNoteMapException {

		DocumentNoteMap documentNoteMap = fetchByPrimaryKey(primaryKey);

		if (documentNoteMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentNoteMapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documentNoteMap;
	}

	/**
	 * Returns the document note map with the primary key or throws a <code>NoSuchDocumentNoteMapException</code> if it could not be found.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map
	 * @throws NoSuchDocumentNoteMapException if a document note map with the primary key could not be found
	 */
	@Override
	public DocumentNoteMap findByPrimaryKey(long documentNoteMapId)
		throws NoSuchDocumentNoteMapException {

		return findByPrimaryKey((Serializable)documentNoteMapId);
	}

	/**
	 * Returns the document note map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentNoteMapId the primary key of the document note map
	 * @return the document note map, or <code>null</code> if a document note map with the primary key could not be found
	 */
	@Override
	public DocumentNoteMap fetchByPrimaryKey(long documentNoteMapId) {
		return fetchByPrimaryKey((Serializable)documentNoteMapId);
	}

	/**
	 * Returns all the document note maps.
	 *
	 * @return the document note maps
	 */
	@Override
	public List<DocumentNoteMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @return the range of document note maps
	 */
	@Override
	public List<DocumentNoteMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document note maps
	 */
	@Override
	public List<DocumentNoteMap> findAll(
		int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document note maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentNoteMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document note maps
	 * @param end the upper bound of the range of document note maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document note maps
	 */
	@Override
	public List<DocumentNoteMap> findAll(
		int start, int end,
		OrderByComparator<DocumentNoteMap> orderByComparator,
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

		List<DocumentNoteMap> list = null;

		if (useFinderCache) {
			list = (List<DocumentNoteMap>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCUMENTNOTEMAP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTNOTEMAP;

				sql = sql.concat(DocumentNoteMapModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DocumentNoteMap>)QueryUtil.list(
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
	 * Removes all the document note maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentNoteMap documentNoteMap : findAll()) {
			remove(documentNoteMap);
		}
	}

	/**
	 * Returns the number of document note maps.
	 *
	 * @return the number of document note maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCUMENTNOTEMAP);

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
		return "documentNoteMapId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCUMENTNOTEMAP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentNoteMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document note map persistence.
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

		_finderPathFetchByfindByMovementId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByMovementId",
			new String[] {Long.class.getName()}, new String[] {"movementId"},
			true);

		_finderPathCountByfindByMovementId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByMovementId", new String[] {Long.class.getName()},
			new String[] {"movementId"}, false);

		_setDocumentNoteMapUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDocumentNoteMapUtilPersistence(null);

		entityCache.removeCache(DocumentNoteMapImpl.class.getName());
	}

	private void _setDocumentNoteMapUtilPersistence(
		DocumentNoteMapPersistence documentNoteMapPersistence) {

		try {
			Field field = DocumentNoteMapUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, documentNoteMapPersistence);
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

	private static final String _SQL_SELECT_DOCUMENTNOTEMAP =
		"SELECT documentNoteMap FROM DocumentNoteMap documentNoteMap";

	private static final String _SQL_SELECT_DOCUMENTNOTEMAP_WHERE =
		"SELECT documentNoteMap FROM DocumentNoteMap documentNoteMap WHERE ";

	private static final String _SQL_COUNT_DOCUMENTNOTEMAP =
		"SELECT COUNT(documentNoteMap) FROM DocumentNoteMap documentNoteMap";

	private static final String _SQL_COUNT_DOCUMENTNOTEMAP_WHERE =
		"SELECT COUNT(documentNoteMap) FROM DocumentNoteMap documentNoteMap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documentNoteMap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocumentNoteMap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocumentNoteMap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentNoteMapPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private DocumentNoteMapModelArgumentsResolver
		_documentNoteMapModelArgumentsResolver;

}