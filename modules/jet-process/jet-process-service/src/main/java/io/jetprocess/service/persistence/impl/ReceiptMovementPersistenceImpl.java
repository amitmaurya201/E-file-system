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

import io.jetprocess.exception.NoSuchReceiptMovementException;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.model.ReceiptMovementTable;
import io.jetprocess.model.impl.ReceiptMovementImpl;
import io.jetprocess.model.impl.ReceiptMovementModelImpl;
import io.jetprocess.service.persistence.ReceiptMovementPersistence;
import io.jetprocess.service.persistence.ReceiptMovementUtil;
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
 * The persistence implementation for the receipt movement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ReceiptMovementPersistence.class, BasePersistence.class})
public class ReceiptMovementPersistenceImpl
	extends BasePersistenceImpl<ReceiptMovement>
	implements ReceiptMovementPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ReceiptMovementUtil</code> to access the receipt movement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ReceiptMovementImpl.class.getName();

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
	 * Returns all the receipt movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receipt movements
	 */
	@Override
	public List<ReceiptMovement> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the receipt movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of matching receipt movements
	 */
	@Override
	public List<ReceiptMovement> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the receipt movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt movements
	 */
	@Override
	public List<ReceiptMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the receipt movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt movements
	 */
	@Override
	public List<ReceiptMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator,
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

		List<ReceiptMovement> list = null;

		if (useFinderCache) {
			list = (List<ReceiptMovement>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ReceiptMovement receiptMovement : list) {
					if (!uuid.equals(receiptMovement.getUuid())) {
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

			sb.append(_SQL_SELECT_RECEIPTMOVEMENT_WHERE);

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
				sb.append(ReceiptMovementModelImpl.ORDER_BY_JPQL);
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

				list = (List<ReceiptMovement>)QueryUtil.list(
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
	 * Returns the first receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement findByUuid_First(
			String uuid, OrderByComparator<ReceiptMovement> orderByComparator)
		throws NoSuchReceiptMovementException {

		ReceiptMovement receiptMovement = fetchByUuid_First(
			uuid, orderByComparator);

		if (receiptMovement != null) {
			return receiptMovement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchReceiptMovementException(sb.toString());
	}

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement fetchByUuid_First(
		String uuid, OrderByComparator<ReceiptMovement> orderByComparator) {

		List<ReceiptMovement> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement findByUuid_Last(
			String uuid, OrderByComparator<ReceiptMovement> orderByComparator)
		throws NoSuchReceiptMovementException {

		ReceiptMovement receiptMovement = fetchByUuid_Last(
			uuid, orderByComparator);

		if (receiptMovement != null) {
			return receiptMovement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchReceiptMovementException(sb.toString());
	}

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement fetchByUuid_Last(
		String uuid, OrderByComparator<ReceiptMovement> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ReceiptMovement> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the receipt movements before and after the current receipt movement in the ordered set where uuid = &#63;.
	 *
	 * @param rmId the primary key of the current receipt movement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	@Override
	public ReceiptMovement[] findByUuid_PrevAndNext(
			long rmId, String uuid,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws NoSuchReceiptMovementException {

		uuid = Objects.toString(uuid, "");

		ReceiptMovement receiptMovement = findByPrimaryKey(rmId);

		Session session = null;

		try {
			session = openSession();

			ReceiptMovement[] array = new ReceiptMovementImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, receiptMovement, uuid, orderByComparator, true);

			array[1] = receiptMovement;

			array[2] = getByUuid_PrevAndNext(
				session, receiptMovement, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ReceiptMovement getByUuid_PrevAndNext(
		Session session, ReceiptMovement receiptMovement, String uuid,
		OrderByComparator<ReceiptMovement> orderByComparator,
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

		sb.append(_SQL_SELECT_RECEIPTMOVEMENT_WHERE);

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
			sb.append(ReceiptMovementModelImpl.ORDER_BY_JPQL);
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
						receiptMovement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ReceiptMovement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the receipt movements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ReceiptMovement receiptMovement :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(receiptMovement);
		}
	}

	/**
	 * Returns the number of receipt movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receipt movements
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RECEIPTMOVEMENT_WHERE);

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
		"receiptMovement.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(receiptMovement.uuid IS NULL OR receiptMovement.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReceiptMovementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement findByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptMovementException {

		ReceiptMovement receiptMovement = fetchByUUID_G(uuid, groupId);

		if (receiptMovement == null) {
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

			throw new NoSuchReceiptMovementException(sb.toString());
		}

		return receiptMovement;
	}

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the receipt movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement fetchByUUID_G(
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

		if (result instanceof ReceiptMovement) {
			ReceiptMovement receiptMovement = (ReceiptMovement)result;

			if (!Objects.equals(uuid, receiptMovement.getUuid()) ||
				(groupId != receiptMovement.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RECEIPTMOVEMENT_WHERE);

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

				List<ReceiptMovement> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ReceiptMovement receiptMovement = list.get(0);

					result = receiptMovement;

					cacheResult(receiptMovement);
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
			return (ReceiptMovement)result;
		}
	}

	/**
	 * Removes the receipt movement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receipt movement that was removed
	 */
	@Override
	public ReceiptMovement removeByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptMovementException {

		ReceiptMovement receiptMovement = findByUUID_G(uuid, groupId);

		return remove(receiptMovement);
	}

	/**
	 * Returns the number of receipt movements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receipt movements
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RECEIPTMOVEMENT_WHERE);

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
		"receiptMovement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(receiptMovement.uuid IS NULL OR receiptMovement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"receiptMovement.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receipt movements
	 */
	@Override
	public List<ReceiptMovement> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of matching receipt movements
	 */
	@Override
	public List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt movements
	 */
	@Override
	public List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt movements
	 */
	@Override
	public List<ReceiptMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator,
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

		List<ReceiptMovement> list = null;

		if (useFinderCache) {
			list = (List<ReceiptMovement>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ReceiptMovement receiptMovement : list) {
					if (!uuid.equals(receiptMovement.getUuid()) ||
						(companyId != receiptMovement.getCompanyId())) {

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

			sb.append(_SQL_SELECT_RECEIPTMOVEMENT_WHERE);

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
				sb.append(ReceiptMovementModelImpl.ORDER_BY_JPQL);
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

				list = (List<ReceiptMovement>)QueryUtil.list(
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
	 * Returns the first receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws NoSuchReceiptMovementException {

		ReceiptMovement receiptMovement = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (receiptMovement != null) {
			return receiptMovement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchReceiptMovementException(sb.toString());
	}

	/**
	 * Returns the first receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		List<ReceiptMovement> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement
	 * @throws NoSuchReceiptMovementException if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws NoSuchReceiptMovementException {

		ReceiptMovement receiptMovement = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (receiptMovement != null) {
			return receiptMovement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchReceiptMovementException(sb.toString());
	}

	/**
	 * Returns the last receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt movement, or <code>null</code> if a matching receipt movement could not be found
	 */
	@Override
	public ReceiptMovement fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ReceiptMovement> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the receipt movements before and after the current receipt movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rmId the primary key of the current receipt movement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	@Override
	public ReceiptMovement[] findByUuid_C_PrevAndNext(
			long rmId, String uuid, long companyId,
			OrderByComparator<ReceiptMovement> orderByComparator)
		throws NoSuchReceiptMovementException {

		uuid = Objects.toString(uuid, "");

		ReceiptMovement receiptMovement = findByPrimaryKey(rmId);

		Session session = null;

		try {
			session = openSession();

			ReceiptMovement[] array = new ReceiptMovementImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, receiptMovement, uuid, companyId, orderByComparator,
				true);

			array[1] = receiptMovement;

			array[2] = getByUuid_C_PrevAndNext(
				session, receiptMovement, uuid, companyId, orderByComparator,
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

	protected ReceiptMovement getByUuid_C_PrevAndNext(
		Session session, ReceiptMovement receiptMovement, String uuid,
		long companyId, OrderByComparator<ReceiptMovement> orderByComparator,
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

		sb.append(_SQL_SELECT_RECEIPTMOVEMENT_WHERE);

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
			sb.append(ReceiptMovementModelImpl.ORDER_BY_JPQL);
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
						receiptMovement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ReceiptMovement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the receipt movements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ReceiptMovement receiptMovement :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(receiptMovement);
		}
	}

	/**
	 * Returns the number of receipt movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receipt movements
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RECEIPTMOVEMENT_WHERE);

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
		"receiptMovement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(receiptMovement.uuid IS NULL OR receiptMovement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"receiptMovement.companyId = ?";

	public ReceiptMovementPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ReceiptMovement.class);

		setModelImplClass(ReceiptMovementImpl.class);
		setModelPKClass(long.class);

		setTable(ReceiptMovementTable.INSTANCE);
	}

	/**
	 * Caches the receipt movement in the entity cache if it is enabled.
	 *
	 * @param receiptMovement the receipt movement
	 */
	@Override
	public void cacheResult(ReceiptMovement receiptMovement) {
		entityCache.putResult(
			ReceiptMovementImpl.class, receiptMovement.getPrimaryKey(),
			receiptMovement);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				receiptMovement.getUuid(), receiptMovement.getGroupId()
			},
			receiptMovement);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the receipt movements in the entity cache if it is enabled.
	 *
	 * @param receiptMovements the receipt movements
	 */
	@Override
	public void cacheResult(List<ReceiptMovement> receiptMovements) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (receiptMovements.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ReceiptMovement receiptMovement : receiptMovements) {
			if (entityCache.getResult(
					ReceiptMovementImpl.class,
					receiptMovement.getPrimaryKey()) == null) {

				cacheResult(receiptMovement);
			}
		}
	}

	/**
	 * Clears the cache for all receipt movements.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ReceiptMovementImpl.class);

		finderCache.clearCache(ReceiptMovementImpl.class);
	}

	/**
	 * Clears the cache for the receipt movement.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReceiptMovement receiptMovement) {
		entityCache.removeResult(ReceiptMovementImpl.class, receiptMovement);
	}

	@Override
	public void clearCache(List<ReceiptMovement> receiptMovements) {
		for (ReceiptMovement receiptMovement : receiptMovements) {
			entityCache.removeResult(
				ReceiptMovementImpl.class, receiptMovement);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ReceiptMovementImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ReceiptMovementImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ReceiptMovementModelImpl receiptMovementModelImpl) {

		Object[] args = new Object[] {
			receiptMovementModelImpl.getUuid(),
			receiptMovementModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, receiptMovementModelImpl);
	}

	/**
	 * Creates a new receipt movement with the primary key. Does not add the receipt movement to the database.
	 *
	 * @param rmId the primary key for the new receipt movement
	 * @return the new receipt movement
	 */
	@Override
	public ReceiptMovement create(long rmId) {
		ReceiptMovement receiptMovement = new ReceiptMovementImpl();

		receiptMovement.setNew(true);
		receiptMovement.setPrimaryKey(rmId);

		String uuid = _portalUUID.generate();

		receiptMovement.setUuid(uuid);

		receiptMovement.setCompanyId(CompanyThreadLocal.getCompanyId());

		return receiptMovement;
	}

	/**
	 * Removes the receipt movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement that was removed
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	@Override
	public ReceiptMovement remove(long rmId)
		throws NoSuchReceiptMovementException {

		return remove((Serializable)rmId);
	}

	/**
	 * Removes the receipt movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the receipt movement
	 * @return the receipt movement that was removed
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	@Override
	public ReceiptMovement remove(Serializable primaryKey)
		throws NoSuchReceiptMovementException {

		Session session = null;

		try {
			session = openSession();

			ReceiptMovement receiptMovement = (ReceiptMovement)session.get(
				ReceiptMovementImpl.class, primaryKey);

			if (receiptMovement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReceiptMovementException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(receiptMovement);
		}
		catch (NoSuchReceiptMovementException noSuchEntityException) {
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
	protected ReceiptMovement removeImpl(ReceiptMovement receiptMovement) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(receiptMovement)) {
				receiptMovement = (ReceiptMovement)session.get(
					ReceiptMovementImpl.class,
					receiptMovement.getPrimaryKeyObj());
			}

			if (receiptMovement != null) {
				session.delete(receiptMovement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (receiptMovement != null) {
			clearCache(receiptMovement);
		}

		return receiptMovement;
	}

	@Override
	public ReceiptMovement updateImpl(ReceiptMovement receiptMovement) {
		boolean isNew = receiptMovement.isNew();

		if (!(receiptMovement instanceof ReceiptMovementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(receiptMovement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					receiptMovement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in receiptMovement proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ReceiptMovement implementation " +
					receiptMovement.getClass());
		}

		ReceiptMovementModelImpl receiptMovementModelImpl =
			(ReceiptMovementModelImpl)receiptMovement;

		if (Validator.isNull(receiptMovement.getUuid())) {
			String uuid = _portalUUID.generate();

			receiptMovement.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (receiptMovement.getCreateDate() == null)) {
			if (serviceContext == null) {
				receiptMovement.setCreateDate(date);
			}
			else {
				receiptMovement.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!receiptMovementModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				receiptMovement.setModifiedDate(date);
			}
			else {
				receiptMovement.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(receiptMovement);
			}
			else {
				receiptMovement = (ReceiptMovement)session.merge(
					receiptMovement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ReceiptMovementImpl.class, receiptMovementModelImpl, false, true);

		cacheUniqueFindersCache(receiptMovementModelImpl);

		if (isNew) {
			receiptMovement.setNew(false);
		}

		receiptMovement.resetOriginalValues();

		return receiptMovement;
	}

	/**
	 * Returns the receipt movement with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the receipt movement
	 * @return the receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	@Override
	public ReceiptMovement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReceiptMovementException {

		ReceiptMovement receiptMovement = fetchByPrimaryKey(primaryKey);

		if (receiptMovement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReceiptMovementException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return receiptMovement;
	}

	/**
	 * Returns the receipt movement with the primary key or throws a <code>NoSuchReceiptMovementException</code> if it could not be found.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement
	 * @throws NoSuchReceiptMovementException if a receipt movement with the primary key could not be found
	 */
	@Override
	public ReceiptMovement findByPrimaryKey(long rmId)
		throws NoSuchReceiptMovementException {

		return findByPrimaryKey((Serializable)rmId);
	}

	/**
	 * Returns the receipt movement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rmId the primary key of the receipt movement
	 * @return the receipt movement, or <code>null</code> if a receipt movement with the primary key could not be found
	 */
	@Override
	public ReceiptMovement fetchByPrimaryKey(long rmId) {
		return fetchByPrimaryKey((Serializable)rmId);
	}

	/**
	 * Returns all the receipt movements.
	 *
	 * @return the receipt movements
	 */
	@Override
	public List<ReceiptMovement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the receipt movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @return the range of receipt movements
	 */
	@Override
	public List<ReceiptMovement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the receipt movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of receipt movements
	 */
	@Override
	public List<ReceiptMovement> findAll(
		int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the receipt movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt movements
	 * @param end the upper bound of the range of receipt movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of receipt movements
	 */
	@Override
	public List<ReceiptMovement> findAll(
		int start, int end,
		OrderByComparator<ReceiptMovement> orderByComparator,
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

		List<ReceiptMovement> list = null;

		if (useFinderCache) {
			list = (List<ReceiptMovement>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RECEIPTMOVEMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RECEIPTMOVEMENT;

				sql = sql.concat(ReceiptMovementModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ReceiptMovement>)QueryUtil.list(
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
	 * Removes all the receipt movements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ReceiptMovement receiptMovement : findAll()) {
			remove(receiptMovement);
		}
	}

	/**
	 * Returns the number of receipt movements.
	 *
	 * @return the number of receipt movements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RECEIPTMOVEMENT);

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
		return "rmId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RECEIPTMOVEMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ReceiptMovementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the receipt movement persistence.
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

		_setReceiptMovementUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setReceiptMovementUtilPersistence(null);

		entityCache.removeCache(ReceiptMovementImpl.class.getName());
	}

	private void _setReceiptMovementUtilPersistence(
		ReceiptMovementPersistence receiptMovementPersistence) {

		try {
			Field field = ReceiptMovementUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, receiptMovementPersistence);
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

	private static final String _SQL_SELECT_RECEIPTMOVEMENT =
		"SELECT receiptMovement FROM ReceiptMovement receiptMovement";

	private static final String _SQL_SELECT_RECEIPTMOVEMENT_WHERE =
		"SELECT receiptMovement FROM ReceiptMovement receiptMovement WHERE ";

	private static final String _SQL_COUNT_RECEIPTMOVEMENT =
		"SELECT COUNT(receiptMovement) FROM ReceiptMovement receiptMovement";

	private static final String _SQL_COUNT_RECEIPTMOVEMENT_WHERE =
		"SELECT COUNT(receiptMovement) FROM ReceiptMovement receiptMovement WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "receiptMovement.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ReceiptMovement exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ReceiptMovement exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ReceiptMovementPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private ReceiptMovementModelArgumentsResolver
		_receiptMovementModelArgumentsResolver;

}