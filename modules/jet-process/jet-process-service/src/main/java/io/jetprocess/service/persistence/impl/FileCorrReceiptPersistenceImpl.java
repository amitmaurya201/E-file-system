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

import io.jetprocess.exception.NoSuchFileCorrReceiptException;
import io.jetprocess.model.FileCorrReceipt;
import io.jetprocess.model.FileCorrReceiptTable;
import io.jetprocess.model.impl.FileCorrReceiptImpl;
import io.jetprocess.model.impl.FileCorrReceiptModelImpl;
import io.jetprocess.service.persistence.FileCorrReceiptPersistence;
import io.jetprocess.service.persistence.FileCorrReceiptUtil;
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
 * The persistence implementation for the file corr receipt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FileCorrReceiptPersistence.class, BasePersistence.class})
public class FileCorrReceiptPersistenceImpl
	extends BasePersistenceImpl<FileCorrReceipt>
	implements FileCorrReceiptPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FileCorrReceiptUtil</code> to access the file corr receipt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FileCorrReceiptImpl.class.getName();

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
	 * Returns all the file corr receipts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file corr receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file corr receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file corr receipts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator,
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

		List<FileCorrReceipt> list = null;

		if (useFinderCache) {
			list = (List<FileCorrReceipt>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileCorrReceipt fileCorrReceipt : list) {
					if (!uuid.equals(fileCorrReceipt.getUuid())) {
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

			sb.append(_SQL_SELECT_FILECORRRECEIPT_WHERE);

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
				sb.append(FileCorrReceiptModelImpl.ORDER_BY_JPQL);
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

				list = (List<FileCorrReceipt>)QueryUtil.list(
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
	 * Returns the first file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt findByUuid_First(
			String uuid, OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = fetchByUuid_First(
			uuid, orderByComparator);

		if (fileCorrReceipt != null) {
			return fileCorrReceipt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileCorrReceiptException(sb.toString());
	}

	/**
	 * Returns the first file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByUuid_First(
		String uuid, OrderByComparator<FileCorrReceipt> orderByComparator) {

		List<FileCorrReceipt> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt findByUuid_Last(
			String uuid, OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = fetchByUuid_Last(
			uuid, orderByComparator);

		if (fileCorrReceipt != null) {
			return fileCorrReceipt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileCorrReceiptException(sb.toString());
	}

	/**
	 * Returns the last file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByUuid_Last(
		String uuid, OrderByComparator<FileCorrReceipt> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FileCorrReceipt> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file corr receipts before and after the current file corr receipt in the ordered set where uuid = &#63;.
	 *
	 * @param fileCorrReceiptId the primary key of the current file corr receipt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public FileCorrReceipt[] findByUuid_PrevAndNext(
			long fileCorrReceiptId, String uuid,
			OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		uuid = Objects.toString(uuid, "");

		FileCorrReceipt fileCorrReceipt = findByPrimaryKey(fileCorrReceiptId);

		Session session = null;

		try {
			session = openSession();

			FileCorrReceipt[] array = new FileCorrReceiptImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fileCorrReceipt, uuid, orderByComparator, true);

			array[1] = fileCorrReceipt;

			array[2] = getByUuid_PrevAndNext(
				session, fileCorrReceipt, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileCorrReceipt getByUuid_PrevAndNext(
		Session session, FileCorrReceipt fileCorrReceipt, String uuid,
		OrderByComparator<FileCorrReceipt> orderByComparator,
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

		sb.append(_SQL_SELECT_FILECORRRECEIPT_WHERE);

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
			sb.append(FileCorrReceiptModelImpl.ORDER_BY_JPQL);
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
						fileCorrReceipt)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileCorrReceipt> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file corr receipts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FileCorrReceipt fileCorrReceipt :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fileCorrReceipt);
		}
	}

	/**
	 * Returns the number of file corr receipts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file corr receipts
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILECORRRECEIPT_WHERE);

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
		"fileCorrReceipt.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fileCorrReceipt.uuid IS NULL OR fileCorrReceipt.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the file corr receipt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileCorrReceiptException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt findByUUID_G(String uuid, long groupId)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = fetchByUUID_G(uuid, groupId);

		if (fileCorrReceipt == null) {
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

			throw new NoSuchFileCorrReceiptException(sb.toString());
		}

		return fileCorrReceipt;
	}

	/**
	 * Returns the file corr receipt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the file corr receipt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByUUID_G(
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

		if (result instanceof FileCorrReceipt) {
			FileCorrReceipt fileCorrReceipt = (FileCorrReceipt)result;

			if (!Objects.equals(uuid, fileCorrReceipt.getUuid()) ||
				(groupId != fileCorrReceipt.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FILECORRRECEIPT_WHERE);

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

				List<FileCorrReceipt> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FileCorrReceipt fileCorrReceipt = list.get(0);

					result = fileCorrReceipt;

					cacheResult(fileCorrReceipt);
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
			return (FileCorrReceipt)result;
		}
	}

	/**
	 * Removes the file corr receipt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file corr receipt that was removed
	 */
	@Override
	public FileCorrReceipt removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = findByUUID_G(uuid, groupId);

		return remove(fileCorrReceipt);
	}

	/**
	 * Returns the number of file corr receipts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file corr receipts
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILECORRRECEIPT_WHERE);

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
		"fileCorrReceipt.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(fileCorrReceipt.uuid IS NULL OR fileCorrReceipt.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"fileCorrReceipt.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator,
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

		List<FileCorrReceipt> list = null;

		if (useFinderCache) {
			list = (List<FileCorrReceipt>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileCorrReceipt fileCorrReceipt : list) {
					if (!uuid.equals(fileCorrReceipt.getUuid()) ||
						(companyId != fileCorrReceipt.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FILECORRRECEIPT_WHERE);

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
				sb.append(FileCorrReceiptModelImpl.ORDER_BY_JPQL);
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

				list = (List<FileCorrReceipt>)QueryUtil.list(
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
	 * Returns the first file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (fileCorrReceipt != null) {
			return fileCorrReceipt;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileCorrReceiptException(sb.toString());
	}

	/**
	 * Returns the first file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileCorrReceipt> orderByComparator) {

		List<FileCorrReceipt> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (fileCorrReceipt != null) {
			return fileCorrReceipt;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileCorrReceiptException(sb.toString());
	}

	/**
	 * Returns the last file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileCorrReceipt> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FileCorrReceipt> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file corr receipts before and after the current file corr receipt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileCorrReceiptId the primary key of the current file corr receipt
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public FileCorrReceipt[] findByUuid_C_PrevAndNext(
			long fileCorrReceiptId, String uuid, long companyId,
			OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		uuid = Objects.toString(uuid, "");

		FileCorrReceipt fileCorrReceipt = findByPrimaryKey(fileCorrReceiptId);

		Session session = null;

		try {
			session = openSession();

			FileCorrReceipt[] array = new FileCorrReceiptImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, fileCorrReceipt, uuid, companyId, orderByComparator,
				true);

			array[1] = fileCorrReceipt;

			array[2] = getByUuid_C_PrevAndNext(
				session, fileCorrReceipt, uuid, companyId, orderByComparator,
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

	protected FileCorrReceipt getByUuid_C_PrevAndNext(
		Session session, FileCorrReceipt fileCorrReceipt, String uuid,
		long companyId, OrderByComparator<FileCorrReceipt> orderByComparator,
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

		sb.append(_SQL_SELECT_FILECORRRECEIPT_WHERE);

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
			sb.append(FileCorrReceiptModelImpl.ORDER_BY_JPQL);
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
						fileCorrReceipt)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileCorrReceipt> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file corr receipts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FileCorrReceipt fileCorrReceipt :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileCorrReceipt);
		}
	}

	/**
	 * Returns the number of file corr receipts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file corr receipts
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILECORRRECEIPT_WHERE);

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
		"fileCorrReceipt.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(fileCorrReceipt.uuid IS NULL OR fileCorrReceipt.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"fileCorrReceipt.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByfileCorrReceiptBydocFileId;
	private FinderPath
		_finderPathWithoutPaginationFindByfileCorrReceiptBydocFileId;
	private FinderPath _finderPathCountByfileCorrReceiptBydocFileId;

	/**
	 * Returns all the file corr receipts where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @return the matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByfileCorrReceiptBydocFileId(
		long docFileId) {

		return findByfileCorrReceiptBydocFileId(
			docFileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file corr receipts where docFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param docFileId the doc file ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByfileCorrReceiptBydocFileId(
		long docFileId, int start, int end) {

		return findByfileCorrReceiptBydocFileId(docFileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file corr receipts where docFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param docFileId the doc file ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByfileCorrReceiptBydocFileId(
		long docFileId, int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator) {

		return findByfileCorrReceiptBydocFileId(
			docFileId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file corr receipts where docFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param docFileId the doc file ID
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findByfileCorrReceiptBydocFileId(
		long docFileId, int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByfileCorrReceiptBydocFileId;
				finderArgs = new Object[] {docFileId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByfileCorrReceiptBydocFileId;
			finderArgs = new Object[] {
				docFileId, start, end, orderByComparator
			};
		}

		List<FileCorrReceipt> list = null;

		if (useFinderCache) {
			list = (List<FileCorrReceipt>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileCorrReceipt fileCorrReceipt : list) {
					if (docFileId != fileCorrReceipt.getDocFileId()) {
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

			sb.append(_SQL_SELECT_FILECORRRECEIPT_WHERE);

			sb.append(_FINDER_COLUMN_FILECORRRECEIPTBYDOCFILEID_DOCFILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileCorrReceiptModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(docFileId);

				list = (List<FileCorrReceipt>)QueryUtil.list(
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
	 * Returns the first file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt findByfileCorrReceiptBydocFileId_First(
			long docFileId,
			OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt =
			fetchByfileCorrReceiptBydocFileId_First(
				docFileId, orderByComparator);

		if (fileCorrReceipt != null) {
			return fileCorrReceipt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("docFileId=");
		sb.append(docFileId);

		sb.append("}");

		throw new NoSuchFileCorrReceiptException(sb.toString());
	}

	/**
	 * Returns the first file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByfileCorrReceiptBydocFileId_First(
		long docFileId, OrderByComparator<FileCorrReceipt> orderByComparator) {

		List<FileCorrReceipt> list = findByfileCorrReceiptBydocFileId(
			docFileId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt findByfileCorrReceiptBydocFileId_Last(
			long docFileId,
			OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt =
			fetchByfileCorrReceiptBydocFileId_Last(
				docFileId, orderByComparator);

		if (fileCorrReceipt != null) {
			return fileCorrReceipt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("docFileId=");
		sb.append(docFileId);

		sb.append("}");

		throw new NoSuchFileCorrReceiptException(sb.toString());
	}

	/**
	 * Returns the last file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByfileCorrReceiptBydocFileId_Last(
		long docFileId, OrderByComparator<FileCorrReceipt> orderByComparator) {

		int count = countByfileCorrReceiptBydocFileId(docFileId);

		if (count == 0) {
			return null;
		}

		List<FileCorrReceipt> list = findByfileCorrReceiptBydocFileId(
			docFileId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file corr receipts before and after the current file corr receipt in the ordered set where docFileId = &#63;.
	 *
	 * @param fileCorrReceiptId the primary key of the current file corr receipt
	 * @param docFileId the doc file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public FileCorrReceipt[] findByfileCorrReceiptBydocFileId_PrevAndNext(
			long fileCorrReceiptId, long docFileId,
			OrderByComparator<FileCorrReceipt> orderByComparator)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = findByPrimaryKey(fileCorrReceiptId);

		Session session = null;

		try {
			session = openSession();

			FileCorrReceipt[] array = new FileCorrReceiptImpl[3];

			array[0] = getByfileCorrReceiptBydocFileId_PrevAndNext(
				session, fileCorrReceipt, docFileId, orderByComparator, true);

			array[1] = fileCorrReceipt;

			array[2] = getByfileCorrReceiptBydocFileId_PrevAndNext(
				session, fileCorrReceipt, docFileId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileCorrReceipt getByfileCorrReceiptBydocFileId_PrevAndNext(
		Session session, FileCorrReceipt fileCorrReceipt, long docFileId,
		OrderByComparator<FileCorrReceipt> orderByComparator,
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

		sb.append(_SQL_SELECT_FILECORRRECEIPT_WHERE);

		sb.append(_FINDER_COLUMN_FILECORRRECEIPTBYDOCFILEID_DOCFILEID_2);

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
			sb.append(FileCorrReceiptModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(docFileId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fileCorrReceipt)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileCorrReceipt> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file corr receipts where docFileId = &#63; from the database.
	 *
	 * @param docFileId the doc file ID
	 */
	@Override
	public void removeByfileCorrReceiptBydocFileId(long docFileId) {
		for (FileCorrReceipt fileCorrReceipt :
				findByfileCorrReceiptBydocFileId(
					docFileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fileCorrReceipt);
		}
	}

	/**
	 * Returns the number of file corr receipts where docFileId = &#63;.
	 *
	 * @param docFileId the doc file ID
	 * @return the number of matching file corr receipts
	 */
	@Override
	public int countByfileCorrReceiptBydocFileId(long docFileId) {
		FinderPath finderPath = _finderPathCountByfileCorrReceiptBydocFileId;

		Object[] finderArgs = new Object[] {docFileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILECORRRECEIPT_WHERE);

			sb.append(_FINDER_COLUMN_FILECORRRECEIPTBYDOCFILEID_DOCFILEID_2);

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

	private static final String
		_FINDER_COLUMN_FILECORRRECEIPTBYDOCFILEID_DOCFILEID_2 =
			"fileCorrReceipt.docFileId = ?";

	private FinderPath _finderPathFetchByFileCorrReceipt;
	private FinderPath _finderPathCountByFileCorrReceipt;

	/**
	 * Returns the file corr receipt where receiptId = &#63; and receiptMovementId = &#63; or throws a <code>NoSuchFileCorrReceiptException</code> if it could not be found.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @return the matching file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt findByFileCorrReceipt(
			long receiptId, long receiptMovementId)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = fetchByFileCorrReceipt(
			receiptId, receiptMovementId);

		if (fileCorrReceipt == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("receiptId=");
			sb.append(receiptId);

			sb.append(", receiptMovementId=");
			sb.append(receiptMovementId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileCorrReceiptException(sb.toString());
		}

		return fileCorrReceipt;
	}

	/**
	 * Returns the file corr receipt where receiptId = &#63; and receiptMovementId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByFileCorrReceipt(
		long receiptId, long receiptMovementId) {

		return fetchByFileCorrReceipt(receiptId, receiptMovementId, true);
	}

	/**
	 * Returns the file corr receipt where receiptId = &#63; and receiptMovementId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file corr receipt, or <code>null</code> if a matching file corr receipt could not be found
	 */
	@Override
	public FileCorrReceipt fetchByFileCorrReceipt(
		long receiptId, long receiptMovementId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {receiptId, receiptMovementId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFileCorrReceipt, finderArgs);
		}

		if (result instanceof FileCorrReceipt) {
			FileCorrReceipt fileCorrReceipt = (FileCorrReceipt)result;

			if ((receiptId != fileCorrReceipt.getReceiptId()) ||
				(receiptMovementId != fileCorrReceipt.getReceiptMovementId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FILECORRRECEIPT_WHERE);

			sb.append(_FINDER_COLUMN_FILECORRRECEIPT_RECEIPTID_2);

			sb.append(_FINDER_COLUMN_FILECORRRECEIPT_RECEIPTMOVEMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(receiptId);

				queryPos.add(receiptMovementId);

				List<FileCorrReceipt> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFileCorrReceipt, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									receiptId, receiptMovementId
								};
							}

							_log.warn(
								"FileCorrReceiptPersistenceImpl.fetchByFileCorrReceipt(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FileCorrReceipt fileCorrReceipt = list.get(0);

					result = fileCorrReceipt;

					cacheResult(fileCorrReceipt);
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
			return (FileCorrReceipt)result;
		}
	}

	/**
	 * Removes the file corr receipt where receiptId = &#63; and receiptMovementId = &#63; from the database.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @return the file corr receipt that was removed
	 */
	@Override
	public FileCorrReceipt removeByFileCorrReceipt(
			long receiptId, long receiptMovementId)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = findByFileCorrReceipt(
			receiptId, receiptMovementId);

		return remove(fileCorrReceipt);
	}

	/**
	 * Returns the number of file corr receipts where receiptId = &#63; and receiptMovementId = &#63;.
	 *
	 * @param receiptId the receipt ID
	 * @param receiptMovementId the receipt movement ID
	 * @return the number of matching file corr receipts
	 */
	@Override
	public int countByFileCorrReceipt(long receiptId, long receiptMovementId) {
		FinderPath finderPath = _finderPathCountByFileCorrReceipt;

		Object[] finderArgs = new Object[] {receiptId, receiptMovementId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILECORRRECEIPT_WHERE);

			sb.append(_FINDER_COLUMN_FILECORRRECEIPT_RECEIPTID_2);

			sb.append(_FINDER_COLUMN_FILECORRRECEIPT_RECEIPTMOVEMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(receiptId);

				queryPos.add(receiptMovementId);

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

	private static final String _FINDER_COLUMN_FILECORRRECEIPT_RECEIPTID_2 =
		"fileCorrReceipt.receiptId = ? AND ";

	private static final String
		_FINDER_COLUMN_FILECORRRECEIPT_RECEIPTMOVEMENTID_2 =
			"fileCorrReceipt.receiptMovementId = ?";

	public FileCorrReceiptPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FileCorrReceipt.class);

		setModelImplClass(FileCorrReceiptImpl.class);
		setModelPKClass(long.class);

		setTable(FileCorrReceiptTable.INSTANCE);
	}

	/**
	 * Caches the file corr receipt in the entity cache if it is enabled.
	 *
	 * @param fileCorrReceipt the file corr receipt
	 */
	@Override
	public void cacheResult(FileCorrReceipt fileCorrReceipt) {
		entityCache.putResult(
			FileCorrReceiptImpl.class, fileCorrReceipt.getPrimaryKey(),
			fileCorrReceipt);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				fileCorrReceipt.getUuid(), fileCorrReceipt.getGroupId()
			},
			fileCorrReceipt);

		finderCache.putResult(
			_finderPathFetchByFileCorrReceipt,
			new Object[] {
				fileCorrReceipt.getReceiptId(),
				fileCorrReceipt.getReceiptMovementId()
			},
			fileCorrReceipt);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the file corr receipts in the entity cache if it is enabled.
	 *
	 * @param fileCorrReceipts the file corr receipts
	 */
	@Override
	public void cacheResult(List<FileCorrReceipt> fileCorrReceipts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fileCorrReceipts.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FileCorrReceipt fileCorrReceipt : fileCorrReceipts) {
			if (entityCache.getResult(
					FileCorrReceiptImpl.class,
					fileCorrReceipt.getPrimaryKey()) == null) {

				cacheResult(fileCorrReceipt);
			}
		}
	}

	/**
	 * Clears the cache for all file corr receipts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FileCorrReceiptImpl.class);

		finderCache.clearCache(FileCorrReceiptImpl.class);
	}

	/**
	 * Clears the cache for the file corr receipt.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileCorrReceipt fileCorrReceipt) {
		entityCache.removeResult(FileCorrReceiptImpl.class, fileCorrReceipt);
	}

	@Override
	public void clearCache(List<FileCorrReceipt> fileCorrReceipts) {
		for (FileCorrReceipt fileCorrReceipt : fileCorrReceipts) {
			entityCache.removeResult(
				FileCorrReceiptImpl.class, fileCorrReceipt);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FileCorrReceiptImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FileCorrReceiptImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FileCorrReceiptModelImpl fileCorrReceiptModelImpl) {

		Object[] args = new Object[] {
			fileCorrReceiptModelImpl.getUuid(),
			fileCorrReceiptModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, fileCorrReceiptModelImpl);

		args = new Object[] {
			fileCorrReceiptModelImpl.getReceiptId(),
			fileCorrReceiptModelImpl.getReceiptMovementId()
		};

		finderCache.putResult(
			_finderPathCountByFileCorrReceipt, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFileCorrReceipt, args, fileCorrReceiptModelImpl);
	}

	/**
	 * Creates a new file corr receipt with the primary key. Does not add the file corr receipt to the database.
	 *
	 * @param fileCorrReceiptId the primary key for the new file corr receipt
	 * @return the new file corr receipt
	 */
	@Override
	public FileCorrReceipt create(long fileCorrReceiptId) {
		FileCorrReceipt fileCorrReceipt = new FileCorrReceiptImpl();

		fileCorrReceipt.setNew(true);
		fileCorrReceipt.setPrimaryKey(fileCorrReceiptId);

		String uuid = _portalUUID.generate();

		fileCorrReceipt.setUuid(uuid);

		fileCorrReceipt.setCompanyId(CompanyThreadLocal.getCompanyId());

		return fileCorrReceipt;
	}

	/**
	 * Removes the file corr receipt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt that was removed
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public FileCorrReceipt remove(long fileCorrReceiptId)
		throws NoSuchFileCorrReceiptException {

		return remove((Serializable)fileCorrReceiptId);
	}

	/**
	 * Removes the file corr receipt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file corr receipt
	 * @return the file corr receipt that was removed
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public FileCorrReceipt remove(Serializable primaryKey)
		throws NoSuchFileCorrReceiptException {

		Session session = null;

		try {
			session = openSession();

			FileCorrReceipt fileCorrReceipt = (FileCorrReceipt)session.get(
				FileCorrReceiptImpl.class, primaryKey);

			if (fileCorrReceipt == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileCorrReceiptException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fileCorrReceipt);
		}
		catch (NoSuchFileCorrReceiptException noSuchEntityException) {
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
	protected FileCorrReceipt removeImpl(FileCorrReceipt fileCorrReceipt) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileCorrReceipt)) {
				fileCorrReceipt = (FileCorrReceipt)session.get(
					FileCorrReceiptImpl.class,
					fileCorrReceipt.getPrimaryKeyObj());
			}

			if (fileCorrReceipt != null) {
				session.delete(fileCorrReceipt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fileCorrReceipt != null) {
			clearCache(fileCorrReceipt);
		}

		return fileCorrReceipt;
	}

	@Override
	public FileCorrReceipt updateImpl(FileCorrReceipt fileCorrReceipt) {
		boolean isNew = fileCorrReceipt.isNew();

		if (!(fileCorrReceipt instanceof FileCorrReceiptModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fileCorrReceipt.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fileCorrReceipt);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fileCorrReceipt proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FileCorrReceipt implementation " +
					fileCorrReceipt.getClass());
		}

		FileCorrReceiptModelImpl fileCorrReceiptModelImpl =
			(FileCorrReceiptModelImpl)fileCorrReceipt;

		if (Validator.isNull(fileCorrReceipt.getUuid())) {
			String uuid = _portalUUID.generate();

			fileCorrReceipt.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (fileCorrReceipt.getCreateDate() == null)) {
			if (serviceContext == null) {
				fileCorrReceipt.setCreateDate(date);
			}
			else {
				fileCorrReceipt.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!fileCorrReceiptModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fileCorrReceipt.setModifiedDate(date);
			}
			else {
				fileCorrReceipt.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fileCorrReceipt);
			}
			else {
				fileCorrReceipt = (FileCorrReceipt)session.merge(
					fileCorrReceipt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FileCorrReceiptImpl.class, fileCorrReceiptModelImpl, false, true);

		cacheUniqueFindersCache(fileCorrReceiptModelImpl);

		if (isNew) {
			fileCorrReceipt.setNew(false);
		}

		fileCorrReceipt.resetOriginalValues();

		return fileCorrReceipt;
	}

	/**
	 * Returns the file corr receipt with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file corr receipt
	 * @return the file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public FileCorrReceipt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileCorrReceiptException {

		FileCorrReceipt fileCorrReceipt = fetchByPrimaryKey(primaryKey);

		if (fileCorrReceipt == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileCorrReceiptException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fileCorrReceipt;
	}

	/**
	 * Returns the file corr receipt with the primary key or throws a <code>NoSuchFileCorrReceiptException</code> if it could not be found.
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt
	 * @throws NoSuchFileCorrReceiptException if a file corr receipt with the primary key could not be found
	 */
	@Override
	public FileCorrReceipt findByPrimaryKey(long fileCorrReceiptId)
		throws NoSuchFileCorrReceiptException {

		return findByPrimaryKey((Serializable)fileCorrReceiptId);
	}

	/**
	 * Returns the file corr receipt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileCorrReceiptId the primary key of the file corr receipt
	 * @return the file corr receipt, or <code>null</code> if a file corr receipt with the primary key could not be found
	 */
	@Override
	public FileCorrReceipt fetchByPrimaryKey(long fileCorrReceiptId) {
		return fetchByPrimaryKey((Serializable)fileCorrReceiptId);
	}

	/**
	 * Returns all the file corr receipts.
	 *
	 * @return the file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file corr receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @return the range of file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file corr receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findAll(
		int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file corr receipts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileCorrReceiptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file corr receipts
	 * @param end the upper bound of the range of file corr receipts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file corr receipts
	 */
	@Override
	public List<FileCorrReceipt> findAll(
		int start, int end,
		OrderByComparator<FileCorrReceipt> orderByComparator,
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

		List<FileCorrReceipt> list = null;

		if (useFinderCache) {
			list = (List<FileCorrReceipt>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FILECORRRECEIPT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FILECORRRECEIPT;

				sql = sql.concat(FileCorrReceiptModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FileCorrReceipt>)QueryUtil.list(
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
	 * Removes all the file corr receipts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FileCorrReceipt fileCorrReceipt : findAll()) {
			remove(fileCorrReceipt);
		}
	}

	/**
	 * Returns the number of file corr receipts.
	 *
	 * @return the number of file corr receipts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FILECORRRECEIPT);

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
		return "fileCorrReceiptId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FILECORRRECEIPT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FileCorrReceiptModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the file corr receipt persistence.
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

		_finderPathWithPaginationFindByfileCorrReceiptBydocFileId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByfileCorrReceiptBydocFileId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"docFileId"}, true);

		_finderPathWithoutPaginationFindByfileCorrReceiptBydocFileId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByfileCorrReceiptBydocFileId",
				new String[] {Long.class.getName()}, new String[] {"docFileId"},
				true);

		_finderPathCountByfileCorrReceiptBydocFileId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfileCorrReceiptBydocFileId",
			new String[] {Long.class.getName()}, new String[] {"docFileId"},
			false);

		_finderPathFetchByFileCorrReceipt = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFileCorrReceipt",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"receiptId", "receiptMovementId"}, true);

		_finderPathCountByFileCorrReceipt = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileCorrReceipt",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"receiptId", "receiptMovementId"}, false);

		_setFileCorrReceiptUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFileCorrReceiptUtilPersistence(null);

		entityCache.removeCache(FileCorrReceiptImpl.class.getName());
	}

	private void _setFileCorrReceiptUtilPersistence(
		FileCorrReceiptPersistence fileCorrReceiptPersistence) {

		try {
			Field field = FileCorrReceiptUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, fileCorrReceiptPersistence);
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

	private static final String _SQL_SELECT_FILECORRRECEIPT =
		"SELECT fileCorrReceipt FROM FileCorrReceipt fileCorrReceipt";

	private static final String _SQL_SELECT_FILECORRRECEIPT_WHERE =
		"SELECT fileCorrReceipt FROM FileCorrReceipt fileCorrReceipt WHERE ";

	private static final String _SQL_COUNT_FILECORRRECEIPT =
		"SELECT COUNT(fileCorrReceipt) FROM FileCorrReceipt fileCorrReceipt";

	private static final String _SQL_COUNT_FILECORRRECEIPT_WHERE =
		"SELECT COUNT(fileCorrReceipt) FROM FileCorrReceipt fileCorrReceipt WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fileCorrReceipt.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FileCorrReceipt exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FileCorrReceipt exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FileCorrReceiptPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FileCorrReceiptModelArgumentsResolver
		_fileCorrReceiptModelArgumentsResolver;

}