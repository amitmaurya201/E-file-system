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

import io.jetprocess.exception.NoSuchNoteDocMovementException;
import io.jetprocess.model.NoteDocMovement;
import io.jetprocess.model.NoteDocMovementTable;
import io.jetprocess.model.impl.NoteDocMovementImpl;
import io.jetprocess.model.impl.NoteDocMovementModelImpl;
import io.jetprocess.service.persistence.NoteDocMovementPersistence;
import io.jetprocess.service.persistence.NoteDocMovementUtil;
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
 * The persistence implementation for the note doc movement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {NoteDocMovementPersistence.class, BasePersistence.class})
public class NoteDocMovementPersistenceImpl
	extends BasePersistenceImpl<NoteDocMovement>
	implements NoteDocMovementPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NoteDocMovementUtil</code> to access the note doc movement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NoteDocMovementImpl.class.getName();

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
	 * Returns all the note doc movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching note doc movements
	 */
	@Override
	public List<NoteDocMovement> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the note doc movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @return the range of matching note doc movements
	 */
	@Override
	public List<NoteDocMovement> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the note doc movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching note doc movements
	 */
	@Override
	public List<NoteDocMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NoteDocMovement> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the note doc movements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching note doc movements
	 */
	@Override
	public List<NoteDocMovement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NoteDocMovement> orderByComparator,
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

		List<NoteDocMovement> list = null;

		if (useFinderCache) {
			list = (List<NoteDocMovement>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NoteDocMovement noteDocMovement : list) {
					if (!uuid.equals(noteDocMovement.getUuid())) {
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

			sb.append(_SQL_SELECT_NOTEDOCMOVEMENT_WHERE);

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
				sb.append(NoteDocMovementModelImpl.ORDER_BY_JPQL);
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

				list = (List<NoteDocMovement>)QueryUtil.list(
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
	 * Returns the first note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement findByUuid_First(
			String uuid, OrderByComparator<NoteDocMovement> orderByComparator)
		throws NoSuchNoteDocMovementException {

		NoteDocMovement noteDocMovement = fetchByUuid_First(
			uuid, orderByComparator);

		if (noteDocMovement != null) {
			return noteDocMovement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNoteDocMovementException(sb.toString());
	}

	/**
	 * Returns the first note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement fetchByUuid_First(
		String uuid, OrderByComparator<NoteDocMovement> orderByComparator) {

		List<NoteDocMovement> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement findByUuid_Last(
			String uuid, OrderByComparator<NoteDocMovement> orderByComparator)
		throws NoSuchNoteDocMovementException {

		NoteDocMovement noteDocMovement = fetchByUuid_Last(
			uuid, orderByComparator);

		if (noteDocMovement != null) {
			return noteDocMovement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNoteDocMovementException(sb.toString());
	}

	/**
	 * Returns the last note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement fetchByUuid_Last(
		String uuid, OrderByComparator<NoteDocMovement> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<NoteDocMovement> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the note doc movements before and after the current note doc movement in the ordered set where uuid = &#63;.
	 *
	 * @param movementId the primary key of the current note doc movement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note doc movement
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	@Override
	public NoteDocMovement[] findByUuid_PrevAndNext(
			long movementId, String uuid,
			OrderByComparator<NoteDocMovement> orderByComparator)
		throws NoSuchNoteDocMovementException {

		uuid = Objects.toString(uuid, "");

		NoteDocMovement noteDocMovement = findByPrimaryKey(movementId);

		Session session = null;

		try {
			session = openSession();

			NoteDocMovement[] array = new NoteDocMovementImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, noteDocMovement, uuid, orderByComparator, true);

			array[1] = noteDocMovement;

			array[2] = getByUuid_PrevAndNext(
				session, noteDocMovement, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NoteDocMovement getByUuid_PrevAndNext(
		Session session, NoteDocMovement noteDocMovement, String uuid,
		OrderByComparator<NoteDocMovement> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTEDOCMOVEMENT_WHERE);

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
			sb.append(NoteDocMovementModelImpl.ORDER_BY_JPQL);
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
						noteDocMovement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NoteDocMovement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the note doc movements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (NoteDocMovement noteDocMovement :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(noteDocMovement);
		}
	}

	/**
	 * Returns the number of note doc movements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching note doc movements
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NOTEDOCMOVEMENT_WHERE);

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
		"noteDocMovement.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(noteDocMovement.uuid IS NULL OR noteDocMovement.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the note doc movement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNoteDocMovementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement findByUUID_G(String uuid, long groupId)
		throws NoSuchNoteDocMovementException {

		NoteDocMovement noteDocMovement = fetchByUUID_G(uuid, groupId);

		if (noteDocMovement == null) {
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

			throw new NoSuchNoteDocMovementException(sb.toString());
		}

		return noteDocMovement;
	}

	/**
	 * Returns the note doc movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the note doc movement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement fetchByUUID_G(
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

		if (result instanceof NoteDocMovement) {
			NoteDocMovement noteDocMovement = (NoteDocMovement)result;

			if (!Objects.equals(uuid, noteDocMovement.getUuid()) ||
				(groupId != noteDocMovement.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_NOTEDOCMOVEMENT_WHERE);

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

				List<NoteDocMovement> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					NoteDocMovement noteDocMovement = list.get(0);

					result = noteDocMovement;

					cacheResult(noteDocMovement);
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
			return (NoteDocMovement)result;
		}
	}

	/**
	 * Removes the note doc movement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the note doc movement that was removed
	 */
	@Override
	public NoteDocMovement removeByUUID_G(String uuid, long groupId)
		throws NoSuchNoteDocMovementException {

		NoteDocMovement noteDocMovement = findByUUID_G(uuid, groupId);

		return remove(noteDocMovement);
	}

	/**
	 * Returns the number of note doc movements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching note doc movements
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTEDOCMOVEMENT_WHERE);

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
		"noteDocMovement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(noteDocMovement.uuid IS NULL OR noteDocMovement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"noteDocMovement.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching note doc movements
	 */
	@Override
	public List<NoteDocMovement> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @return the range of matching note doc movements
	 */
	@Override
	public List<NoteDocMovement> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching note doc movements
	 */
	@Override
	public List<NoteDocMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NoteDocMovement> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching note doc movements
	 */
	@Override
	public List<NoteDocMovement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NoteDocMovement> orderByComparator,
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

		List<NoteDocMovement> list = null;

		if (useFinderCache) {
			list = (List<NoteDocMovement>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NoteDocMovement noteDocMovement : list) {
					if (!uuid.equals(noteDocMovement.getUuid()) ||
						(companyId != noteDocMovement.getCompanyId())) {

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

			sb.append(_SQL_SELECT_NOTEDOCMOVEMENT_WHERE);

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
				sb.append(NoteDocMovementModelImpl.ORDER_BY_JPQL);
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

				list = (List<NoteDocMovement>)QueryUtil.list(
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
	 * Returns the first note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<NoteDocMovement> orderByComparator)
		throws NoSuchNoteDocMovementException {

		NoteDocMovement noteDocMovement = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (noteDocMovement != null) {
			return noteDocMovement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNoteDocMovementException(sb.toString());
	}

	/**
	 * Returns the first note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<NoteDocMovement> orderByComparator) {

		List<NoteDocMovement> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note doc movement
	 * @throws NoSuchNoteDocMovementException if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<NoteDocMovement> orderByComparator)
		throws NoSuchNoteDocMovementException {

		NoteDocMovement noteDocMovement = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (noteDocMovement != null) {
			return noteDocMovement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNoteDocMovementException(sb.toString());
	}

	/**
	 * Returns the last note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note doc movement, or <code>null</code> if a matching note doc movement could not be found
	 */
	@Override
	public NoteDocMovement fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<NoteDocMovement> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<NoteDocMovement> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the note doc movements before and after the current note doc movement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param movementId the primary key of the current note doc movement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note doc movement
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	@Override
	public NoteDocMovement[] findByUuid_C_PrevAndNext(
			long movementId, String uuid, long companyId,
			OrderByComparator<NoteDocMovement> orderByComparator)
		throws NoSuchNoteDocMovementException {

		uuid = Objects.toString(uuid, "");

		NoteDocMovement noteDocMovement = findByPrimaryKey(movementId);

		Session session = null;

		try {
			session = openSession();

			NoteDocMovement[] array = new NoteDocMovementImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, noteDocMovement, uuid, companyId, orderByComparator,
				true);

			array[1] = noteDocMovement;

			array[2] = getByUuid_C_PrevAndNext(
				session, noteDocMovement, uuid, companyId, orderByComparator,
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

	protected NoteDocMovement getByUuid_C_PrevAndNext(
		Session session, NoteDocMovement noteDocMovement, String uuid,
		long companyId, OrderByComparator<NoteDocMovement> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTEDOCMOVEMENT_WHERE);

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
			sb.append(NoteDocMovementModelImpl.ORDER_BY_JPQL);
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
						noteDocMovement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NoteDocMovement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the note doc movements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (NoteDocMovement noteDocMovement :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(noteDocMovement);
		}
	}

	/**
	 * Returns the number of note doc movements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching note doc movements
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTEDOCMOVEMENT_WHERE);

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
		"noteDocMovement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(noteDocMovement.uuid IS NULL OR noteDocMovement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"noteDocMovement.companyId = ?";

	public NoteDocMovementPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(NoteDocMovement.class);

		setModelImplClass(NoteDocMovementImpl.class);
		setModelPKClass(long.class);

		setTable(NoteDocMovementTable.INSTANCE);
	}

	/**
	 * Caches the note doc movement in the entity cache if it is enabled.
	 *
	 * @param noteDocMovement the note doc movement
	 */
	@Override
	public void cacheResult(NoteDocMovement noteDocMovement) {
		entityCache.putResult(
			NoteDocMovementImpl.class, noteDocMovement.getPrimaryKey(),
			noteDocMovement);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				noteDocMovement.getUuid(), noteDocMovement.getGroupId()
			},
			noteDocMovement);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the note doc movements in the entity cache if it is enabled.
	 *
	 * @param noteDocMovements the note doc movements
	 */
	@Override
	public void cacheResult(List<NoteDocMovement> noteDocMovements) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (noteDocMovements.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (NoteDocMovement noteDocMovement : noteDocMovements) {
			if (entityCache.getResult(
					NoteDocMovementImpl.class,
					noteDocMovement.getPrimaryKey()) == null) {

				cacheResult(noteDocMovement);
			}
		}
	}

	/**
	 * Clears the cache for all note doc movements.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NoteDocMovementImpl.class);

		finderCache.clearCache(NoteDocMovementImpl.class);
	}

	/**
	 * Clears the cache for the note doc movement.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NoteDocMovement noteDocMovement) {
		entityCache.removeResult(NoteDocMovementImpl.class, noteDocMovement);
	}

	@Override
	public void clearCache(List<NoteDocMovement> noteDocMovements) {
		for (NoteDocMovement noteDocMovement : noteDocMovements) {
			entityCache.removeResult(
				NoteDocMovementImpl.class, noteDocMovement);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NoteDocMovementImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NoteDocMovementImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		NoteDocMovementModelImpl noteDocMovementModelImpl) {

		Object[] args = new Object[] {
			noteDocMovementModelImpl.getUuid(),
			noteDocMovementModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, noteDocMovementModelImpl);
	}

	/**
	 * Creates a new note doc movement with the primary key. Does not add the note doc movement to the database.
	 *
	 * @param movementId the primary key for the new note doc movement
	 * @return the new note doc movement
	 */
	@Override
	public NoteDocMovement create(long movementId) {
		NoteDocMovement noteDocMovement = new NoteDocMovementImpl();

		noteDocMovement.setNew(true);
		noteDocMovement.setPrimaryKey(movementId);

		String uuid = _portalUUID.generate();

		noteDocMovement.setUuid(uuid);

		noteDocMovement.setCompanyId(CompanyThreadLocal.getCompanyId());

		return noteDocMovement;
	}

	/**
	 * Removes the note doc movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement that was removed
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	@Override
	public NoteDocMovement remove(long movementId)
		throws NoSuchNoteDocMovementException {

		return remove((Serializable)movementId);
	}

	/**
	 * Removes the note doc movement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the note doc movement
	 * @return the note doc movement that was removed
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	@Override
	public NoteDocMovement remove(Serializable primaryKey)
		throws NoSuchNoteDocMovementException {

		Session session = null;

		try {
			session = openSession();

			NoteDocMovement noteDocMovement = (NoteDocMovement)session.get(
				NoteDocMovementImpl.class, primaryKey);

			if (noteDocMovement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNoteDocMovementException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(noteDocMovement);
		}
		catch (NoSuchNoteDocMovementException noSuchEntityException) {
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
	protected NoteDocMovement removeImpl(NoteDocMovement noteDocMovement) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(noteDocMovement)) {
				noteDocMovement = (NoteDocMovement)session.get(
					NoteDocMovementImpl.class,
					noteDocMovement.getPrimaryKeyObj());
			}

			if (noteDocMovement != null) {
				session.delete(noteDocMovement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (noteDocMovement != null) {
			clearCache(noteDocMovement);
		}

		return noteDocMovement;
	}

	@Override
	public NoteDocMovement updateImpl(NoteDocMovement noteDocMovement) {
		boolean isNew = noteDocMovement.isNew();

		if (!(noteDocMovement instanceof NoteDocMovementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(noteDocMovement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					noteDocMovement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in noteDocMovement proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom NoteDocMovement implementation " +
					noteDocMovement.getClass());
		}

		NoteDocMovementModelImpl noteDocMovementModelImpl =
			(NoteDocMovementModelImpl)noteDocMovement;

		if (Validator.isNull(noteDocMovement.getUuid())) {
			String uuid = _portalUUID.generate();

			noteDocMovement.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (noteDocMovement.getCreateDate() == null)) {
			if (serviceContext == null) {
				noteDocMovement.setCreateDate(date);
			}
			else {
				noteDocMovement.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!noteDocMovementModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				noteDocMovement.setModifiedDate(date);
			}
			else {
				noteDocMovement.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(noteDocMovement);
			}
			else {
				noteDocMovement = (NoteDocMovement)session.merge(
					noteDocMovement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			NoteDocMovementImpl.class, noteDocMovementModelImpl, false, true);

		cacheUniqueFindersCache(noteDocMovementModelImpl);

		if (isNew) {
			noteDocMovement.setNew(false);
		}

		noteDocMovement.resetOriginalValues();

		return noteDocMovement;
	}

	/**
	 * Returns the note doc movement with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the note doc movement
	 * @return the note doc movement
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	@Override
	public NoteDocMovement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNoteDocMovementException {

		NoteDocMovement noteDocMovement = fetchByPrimaryKey(primaryKey);

		if (noteDocMovement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNoteDocMovementException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return noteDocMovement;
	}

	/**
	 * Returns the note doc movement with the primary key or throws a <code>NoSuchNoteDocMovementException</code> if it could not be found.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement
	 * @throws NoSuchNoteDocMovementException if a note doc movement with the primary key could not be found
	 */
	@Override
	public NoteDocMovement findByPrimaryKey(long movementId)
		throws NoSuchNoteDocMovementException {

		return findByPrimaryKey((Serializable)movementId);
	}

	/**
	 * Returns the note doc movement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movementId the primary key of the note doc movement
	 * @return the note doc movement, or <code>null</code> if a note doc movement with the primary key could not be found
	 */
	@Override
	public NoteDocMovement fetchByPrimaryKey(long movementId) {
		return fetchByPrimaryKey((Serializable)movementId);
	}

	/**
	 * Returns all the note doc movements.
	 *
	 * @return the note doc movements
	 */
	@Override
	public List<NoteDocMovement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the note doc movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @return the range of note doc movements
	 */
	@Override
	public List<NoteDocMovement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the note doc movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of note doc movements
	 */
	@Override
	public List<NoteDocMovement> findAll(
		int start, int end,
		OrderByComparator<NoteDocMovement> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the note doc movements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteDocMovementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of note doc movements
	 * @param end the upper bound of the range of note doc movements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of note doc movements
	 */
	@Override
	public List<NoteDocMovement> findAll(
		int start, int end,
		OrderByComparator<NoteDocMovement> orderByComparator,
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

		List<NoteDocMovement> list = null;

		if (useFinderCache) {
			list = (List<NoteDocMovement>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NOTEDOCMOVEMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NOTEDOCMOVEMENT;

				sql = sql.concat(NoteDocMovementModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<NoteDocMovement>)QueryUtil.list(
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
	 * Removes all the note doc movements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NoteDocMovement noteDocMovement : findAll()) {
			remove(noteDocMovement);
		}
	}

	/**
	 * Returns the number of note doc movements.
	 *
	 * @return the number of note doc movements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NOTEDOCMOVEMENT);

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
		return "movementId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NOTEDOCMOVEMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NoteDocMovementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the note doc movement persistence.
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

		_setNoteDocMovementUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNoteDocMovementUtilPersistence(null);

		entityCache.removeCache(NoteDocMovementImpl.class.getName());
	}

	private void _setNoteDocMovementUtilPersistence(
		NoteDocMovementPersistence noteDocMovementPersistence) {

		try {
			Field field = NoteDocMovementUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, noteDocMovementPersistence);
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

	private static final String _SQL_SELECT_NOTEDOCMOVEMENT =
		"SELECT noteDocMovement FROM NoteDocMovement noteDocMovement";

	private static final String _SQL_SELECT_NOTEDOCMOVEMENT_WHERE =
		"SELECT noteDocMovement FROM NoteDocMovement noteDocMovement WHERE ";

	private static final String _SQL_COUNT_NOTEDOCMOVEMENT =
		"SELECT COUNT(noteDocMovement) FROM NoteDocMovement noteDocMovement";

	private static final String _SQL_COUNT_NOTEDOCMOVEMENT_WHERE =
		"SELECT COUNT(noteDocMovement) FROM NoteDocMovement noteDocMovement WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "noteDocMovement.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No NoteDocMovement exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No NoteDocMovement exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NoteDocMovementPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private NoteDocMovementModelArgumentsResolver
		_noteDocMovementModelArgumentsResolver;

}