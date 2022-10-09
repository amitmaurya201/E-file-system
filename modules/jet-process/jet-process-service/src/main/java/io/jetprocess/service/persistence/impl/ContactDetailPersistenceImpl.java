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

import io.jetprocess.exception.NoSuchContactDetailException;
import io.jetprocess.model.ContactDetail;
import io.jetprocess.model.ContactDetailTable;
import io.jetprocess.model.impl.ContactDetailImpl;
import io.jetprocess.model.impl.ContactDetailModelImpl;
import io.jetprocess.service.persistence.ContactDetailPersistence;
import io.jetprocess.service.persistence.ContactDetailUtil;
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
 * The persistence implementation for the contact detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ContactDetailPersistence.class, BasePersistence.class})
public class ContactDetailPersistenceImpl
	extends BasePersistenceImpl<ContactDetail>
	implements ContactDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ContactDetailUtil</code> to access the contact detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ContactDetailImpl.class.getName();

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
	 * Returns all the contact details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contact details
	 */
	@Override
	public List<ContactDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the contact details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator,
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

		List<ContactDetail> list = null;

		if (useFinderCache) {
			list = (List<ContactDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ContactDetail contactDetail : list) {
					if (!uuid.equals(contactDetail.getUuid())) {
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

			sb.append(_SQL_SELECT_CONTACTDETAIL_WHERE);

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
				sb.append(ContactDetailModelImpl.ORDER_BY_JPQL);
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

				list = (List<ContactDetail>)QueryUtil.list(
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
	 * Returns the first contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail findByUuid_First(
			String uuid, OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByUuid_First(
			uuid, orderByComparator);

		if (contactDetail != null) {
			return contactDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchContactDetailException(sb.toString());
	}

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByUuid_First(
		String uuid, OrderByComparator<ContactDetail> orderByComparator) {

		List<ContactDetail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail findByUuid_Last(
			String uuid, OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByUuid_Last(uuid, orderByComparator);

		if (contactDetail != null) {
			return contactDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchContactDetailException(sb.toString());
	}

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByUuid_Last(
		String uuid, OrderByComparator<ContactDetail> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ContactDetail> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact details before and after the current contact detail in the ordered set where uuid = &#63;.
	 *
	 * @param contactDetailId the primary key of the current contact detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	@Override
	public ContactDetail[] findByUuid_PrevAndNext(
			long contactDetailId, String uuid,
			OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		uuid = Objects.toString(uuid, "");

		ContactDetail contactDetail = findByPrimaryKey(contactDetailId);

		Session session = null;

		try {
			session = openSession();

			ContactDetail[] array = new ContactDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, contactDetail, uuid, orderByComparator, true);

			array[1] = contactDetail;

			array[2] = getByUuid_PrevAndNext(
				session, contactDetail, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactDetail getByUuid_PrevAndNext(
		Session session, ContactDetail contactDetail, String uuid,
		OrderByComparator<ContactDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONTACTDETAIL_WHERE);

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
			sb.append(ContactDetailModelImpl.ORDER_BY_JPQL);
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
						contactDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ContactDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ContactDetail contactDetail :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(contactDetail);
		}
	}

	/**
	 * Returns the number of contact details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contact details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONTACTDETAIL_WHERE);

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
		"contactDetail.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(contactDetail.uuid IS NULL OR contactDetail.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByUUID_G(uuid, groupId);

		if (contactDetail == null) {
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

			throw new NoSuchContactDetailException(sb.toString());
		}

		return contactDetail;
	}

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the contact detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByUUID_G(
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

		if (result instanceof ContactDetail) {
			ContactDetail contactDetail = (ContactDetail)result;

			if (!Objects.equals(uuid, contactDetail.getUuid()) ||
				(groupId != contactDetail.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CONTACTDETAIL_WHERE);

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

				List<ContactDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ContactDetail contactDetail = list.get(0);

					result = contactDetail;

					cacheResult(contactDetail);
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
			return (ContactDetail)result;
		}
	}

	/**
	 * Removes the contact detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the contact detail that was removed
	 */
	@Override
	public ContactDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = findByUUID_G(uuid, groupId);

		return remove(contactDetail);
	}

	/**
	 * Returns the number of contact details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching contact details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONTACTDETAIL_WHERE);

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
		"contactDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(contactDetail.uuid IS NULL OR contactDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"contactDetail.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching contact details
	 */
	@Override
	public List<ContactDetail> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator,
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

		List<ContactDetail> list = null;

		if (useFinderCache) {
			list = (List<ContactDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ContactDetail contactDetail : list) {
					if (!uuid.equals(contactDetail.getUuid()) ||
						(companyId != contactDetail.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CONTACTDETAIL_WHERE);

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
				sb.append(ContactDetailModelImpl.ORDER_BY_JPQL);
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

				list = (List<ContactDetail>)QueryUtil.list(
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
	 * Returns the first contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (contactDetail != null) {
			return contactDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchContactDetailException(sb.toString());
	}

	/**
	 * Returns the first contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ContactDetail> orderByComparator) {

		List<ContactDetail> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (contactDetail != null) {
			return contactDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchContactDetailException(sb.toString());
	}

	/**
	 * Returns the last contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ContactDetail> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ContactDetail> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact details before and after the current contact detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param contactDetailId the primary key of the current contact detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	@Override
	public ContactDetail[] findByUuid_C_PrevAndNext(
			long contactDetailId, String uuid, long companyId,
			OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		uuid = Objects.toString(uuid, "");

		ContactDetail contactDetail = findByPrimaryKey(contactDetailId);

		Session session = null;

		try {
			session = openSession();

			ContactDetail[] array = new ContactDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, contactDetail, uuid, companyId, orderByComparator,
				true);

			array[1] = contactDetail;

			array[2] = getByUuid_C_PrevAndNext(
				session, contactDetail, uuid, companyId, orderByComparator,
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

	protected ContactDetail getByUuid_C_PrevAndNext(
		Session session, ContactDetail contactDetail, String uuid,
		long companyId, OrderByComparator<ContactDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_CONTACTDETAIL_WHERE);

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
			sb.append(ContactDetailModelImpl.ORDER_BY_JPQL);
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
						contactDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ContactDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ContactDetail contactDetail :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(contactDetail);
		}
	}

	/**
	 * Returns the number of contact details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching contact details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONTACTDETAIL_WHERE);

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
		"contactDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(contactDetail.uuid IS NULL OR contactDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"contactDetail.companyId = ?";

	private FinderPath _finderPathFetchByContactDetailId;
	private FinderPath _finderPathCountByContactDetailId;

	/**
	 * Returns the contact detail where contactDetailId = &#63; or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail findByContactDetailId(long contactDetailId)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByContactDetailId(contactDetailId);

		if (contactDetail == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("contactDetailId=");
			sb.append(contactDetailId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchContactDetailException(sb.toString());
		}

		return contactDetail;
	}

	/**
	 * Returns the contact detail where contactDetailId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByContactDetailId(long contactDetailId) {
		return fetchByContactDetailId(contactDetailId, true);
	}

	/**
	 * Returns the contact detail where contactDetailId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactDetailId the contact detail ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByContactDetailId(
		long contactDetailId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {contactDetailId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByContactDetailId, finderArgs);
		}

		if (result instanceof ContactDetail) {
			ContactDetail contactDetail = (ContactDetail)result;

			if (contactDetailId != contactDetail.getContactDetailId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CONTACTDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_CONTACTDETAILID_CONTACTDETAILID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contactDetailId);

				List<ContactDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByContactDetailId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {contactDetailId};
							}

							_log.warn(
								"ContactDetailPersistenceImpl.fetchByContactDetailId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ContactDetail contactDetail = list.get(0);

					result = contactDetail;

					cacheResult(contactDetail);
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
			return (ContactDetail)result;
		}
	}

	/**
	 * Removes the contact detail where contactDetailId = &#63; from the database.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the contact detail that was removed
	 */
	@Override
	public ContactDetail removeByContactDetailId(long contactDetailId)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = findByContactDetailId(contactDetailId);

		return remove(contactDetail);
	}

	/**
	 * Returns the number of contact details where contactDetailId = &#63;.
	 *
	 * @param contactDetailId the contact detail ID
	 * @return the number of matching contact details
	 */
	@Override
	public int countByContactDetailId(long contactDetailId) {
		FinderPath finderPath = _finderPathCountByContactDetailId;

		Object[] finderArgs = new Object[] {contactDetailId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONTACTDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_CONTACTDETAILID_CONTACTDETAILID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contactDetailId);

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
		_FINDER_COLUMN_CONTACTDETAILID_CONTACTDETAILID_2 =
			"contactDetail.contactDetailId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the contact details where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contact details
	 */
	@Override
	public List<ContactDetail> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact details where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact details where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the contact details where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact details
	 */
	@Override
	public List<ContactDetail> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ContactDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<ContactDetail> list = null;

		if (useFinderCache) {
			list = (List<ContactDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ContactDetail contactDetail : list) {
					if (groupId != contactDetail.getGroupId()) {
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

			sb.append(_SQL_SELECT_CONTACTDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ContactDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ContactDetail>)QueryUtil.list(
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
	 * Returns the first contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail findByGroupId_First(
			long groupId, OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByGroupId_First(
			groupId, orderByComparator);

		if (contactDetail != null) {
			return contactDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchContactDetailException(sb.toString());
	}

	/**
	 * Returns the first contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByGroupId_First(
		long groupId, OrderByComparator<ContactDetail> orderByComparator) {

		List<ContactDetail> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail
	 * @throws NoSuchContactDetailException if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail findByGroupId_Last(
			long groupId, OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (contactDetail != null) {
			return contactDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchContactDetailException(sb.toString());
	}

	/**
	 * Returns the last contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact detail, or <code>null</code> if a matching contact detail could not be found
	 */
	@Override
	public ContactDetail fetchByGroupId_Last(
		long groupId, OrderByComparator<ContactDetail> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ContactDetail> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact details before and after the current contact detail in the ordered set where groupId = &#63;.
	 *
	 * @param contactDetailId the primary key of the current contact detail
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	@Override
	public ContactDetail[] findByGroupId_PrevAndNext(
			long contactDetailId, long groupId,
			OrderByComparator<ContactDetail> orderByComparator)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = findByPrimaryKey(contactDetailId);

		Session session = null;

		try {
			session = openSession();

			ContactDetail[] array = new ContactDetailImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, contactDetail, groupId, orderByComparator, true);

			array[1] = contactDetail;

			array[2] = getByGroupId_PrevAndNext(
				session, contactDetail, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactDetail getByGroupId_PrevAndNext(
		Session session, ContactDetail contactDetail, long groupId,
		OrderByComparator<ContactDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONTACTDETAIL_WHERE);

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
			sb.append(ContactDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						contactDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ContactDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact details where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ContactDetail contactDetail :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(contactDetail);
		}
	}

	/**
	 * Returns the number of contact details where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contact details
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONTACTDETAIL_WHERE);

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
		"contactDetail.groupId = ?";

	public ContactDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ContactDetail.class);

		setModelImplClass(ContactDetailImpl.class);
		setModelPKClass(long.class);

		setTable(ContactDetailTable.INSTANCE);
	}

	/**
	 * Caches the contact detail in the entity cache if it is enabled.
	 *
	 * @param contactDetail the contact detail
	 */
	@Override
	public void cacheResult(ContactDetail contactDetail) {
		entityCache.putResult(
			ContactDetailImpl.class, contactDetail.getPrimaryKey(),
			contactDetail);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {contactDetail.getUuid(), contactDetail.getGroupId()},
			contactDetail);

		finderCache.putResult(
			_finderPathFetchByContactDetailId,
			new Object[] {contactDetail.getContactDetailId()}, contactDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the contact details in the entity cache if it is enabled.
	 *
	 * @param contactDetails the contact details
	 */
	@Override
	public void cacheResult(List<ContactDetail> contactDetails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (contactDetails.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ContactDetail contactDetail : contactDetails) {
			if (entityCache.getResult(
					ContactDetailImpl.class, contactDetail.getPrimaryKey()) ==
						null) {

				cacheResult(contactDetail);
			}
		}
	}

	/**
	 * Clears the cache for all contact details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ContactDetailImpl.class);

		finderCache.clearCache(ContactDetailImpl.class);
	}

	/**
	 * Clears the cache for the contact detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactDetail contactDetail) {
		entityCache.removeResult(ContactDetailImpl.class, contactDetail);
	}

	@Override
	public void clearCache(List<ContactDetail> contactDetails) {
		for (ContactDetail contactDetail : contactDetails) {
			entityCache.removeResult(ContactDetailImpl.class, contactDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ContactDetailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ContactDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ContactDetailModelImpl contactDetailModelImpl) {

		Object[] args = new Object[] {
			contactDetailModelImpl.getUuid(),
			contactDetailModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, contactDetailModelImpl);

		args = new Object[] {contactDetailModelImpl.getContactDetailId()};

		finderCache.putResult(
			_finderPathCountByContactDetailId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByContactDetailId, args, contactDetailModelImpl);
	}

	/**
	 * Creates a new contact detail with the primary key. Does not add the contact detail to the database.
	 *
	 * @param contactDetailId the primary key for the new contact detail
	 * @return the new contact detail
	 */
	@Override
	public ContactDetail create(long contactDetailId) {
		ContactDetail contactDetail = new ContactDetailImpl();

		contactDetail.setNew(true);
		contactDetail.setPrimaryKey(contactDetailId);

		String uuid = _portalUUID.generate();

		contactDetail.setUuid(uuid);

		contactDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return contactDetail;
	}

	/**
	 * Removes the contact detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail that was removed
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	@Override
	public ContactDetail remove(long contactDetailId)
		throws NoSuchContactDetailException {

		return remove((Serializable)contactDetailId);
	}

	/**
	 * Removes the contact detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact detail
	 * @return the contact detail that was removed
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	@Override
	public ContactDetail remove(Serializable primaryKey)
		throws NoSuchContactDetailException {

		Session session = null;

		try {
			session = openSession();

			ContactDetail contactDetail = (ContactDetail)session.get(
				ContactDetailImpl.class, primaryKey);

			if (contactDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(contactDetail);
		}
		catch (NoSuchContactDetailException noSuchEntityException) {
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
	protected ContactDetail removeImpl(ContactDetail contactDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactDetail)) {
				contactDetail = (ContactDetail)session.get(
					ContactDetailImpl.class, contactDetail.getPrimaryKeyObj());
			}

			if (contactDetail != null) {
				session.delete(contactDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (contactDetail != null) {
			clearCache(contactDetail);
		}

		return contactDetail;
	}

	@Override
	public ContactDetail updateImpl(ContactDetail contactDetail) {
		boolean isNew = contactDetail.isNew();

		if (!(contactDetail instanceof ContactDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(contactDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					contactDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in contactDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ContactDetail implementation " +
					contactDetail.getClass());
		}

		ContactDetailModelImpl contactDetailModelImpl =
			(ContactDetailModelImpl)contactDetail;

		if (Validator.isNull(contactDetail.getUuid())) {
			String uuid = _portalUUID.generate();

			contactDetail.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (contactDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				contactDetail.setCreateDate(date);
			}
			else {
				contactDetail.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!contactDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				contactDetail.setModifiedDate(date);
			}
			else {
				contactDetail.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(contactDetail);
			}
			else {
				contactDetail = (ContactDetail)session.merge(contactDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ContactDetailImpl.class, contactDetailModelImpl, false, true);

		cacheUniqueFindersCache(contactDetailModelImpl);

		if (isNew) {
			contactDetail.setNew(false);
		}

		contactDetail.resetOriginalValues();

		return contactDetail;
	}

	/**
	 * Returns the contact detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact detail
	 * @return the contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	@Override
	public ContactDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactDetailException {

		ContactDetail contactDetail = fetchByPrimaryKey(primaryKey);

		if (contactDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return contactDetail;
	}

	/**
	 * Returns the contact detail with the primary key or throws a <code>NoSuchContactDetailException</code> if it could not be found.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail
	 * @throws NoSuchContactDetailException if a contact detail with the primary key could not be found
	 */
	@Override
	public ContactDetail findByPrimaryKey(long contactDetailId)
		throws NoSuchContactDetailException {

		return findByPrimaryKey((Serializable)contactDetailId);
	}

	/**
	 * Returns the contact detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDetailId the primary key of the contact detail
	 * @return the contact detail, or <code>null</code> if a contact detail with the primary key could not be found
	 */
	@Override
	public ContactDetail fetchByPrimaryKey(long contactDetailId) {
		return fetchByPrimaryKey((Serializable)contactDetailId);
	}

	/**
	 * Returns all the contact details.
	 *
	 * @return the contact details
	 */
	@Override
	public List<ContactDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @return the range of contact details
	 */
	@Override
	public List<ContactDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact details
	 */
	@Override
	public List<ContactDetail> findAll(
		int start, int end,
		OrderByComparator<ContactDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the contact details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact details
	 * @param end the upper bound of the range of contact details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of contact details
	 */
	@Override
	public List<ContactDetail> findAll(
		int start, int end, OrderByComparator<ContactDetail> orderByComparator,
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

		List<ContactDetail> list = null;

		if (useFinderCache) {
			list = (List<ContactDetail>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONTACTDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTDETAIL;

				sql = sql.concat(ContactDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ContactDetail>)QueryUtil.list(
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
	 * Removes all the contact details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ContactDetail contactDetail : findAll()) {
			remove(contactDetail);
		}
	}

	/**
	 * Returns the number of contact details.
	 *
	 * @return the number of contact details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CONTACTDETAIL);

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
		return "contactDetailId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONTACTDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ContactDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the contact detail persistence.
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

		_finderPathFetchByContactDetailId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByContactDetailId",
			new String[] {Long.class.getName()},
			new String[] {"contactDetailId"}, true);

		_finderPathCountByContactDetailId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactDetailId",
			new String[] {Long.class.getName()},
			new String[] {"contactDetailId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_setContactDetailUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setContactDetailUtilPersistence(null);

		entityCache.removeCache(ContactDetailImpl.class.getName());
	}

	private void _setContactDetailUtilPersistence(
		ContactDetailPersistence contactDetailPersistence) {

		try {
			Field field = ContactDetailUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, contactDetailPersistence);
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

	private static final String _SQL_SELECT_CONTACTDETAIL =
		"SELECT contactDetail FROM ContactDetail contactDetail";

	private static final String _SQL_SELECT_CONTACTDETAIL_WHERE =
		"SELECT contactDetail FROM ContactDetail contactDetail WHERE ";

	private static final String _SQL_COUNT_CONTACTDETAIL =
		"SELECT COUNT(contactDetail) FROM ContactDetail contactDetail";

	private static final String _SQL_COUNT_CONTACTDETAIL_WHERE =
		"SELECT COUNT(contactDetail) FROM ContactDetail contactDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "contactDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ContactDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ContactDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ContactDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private ContactDetailModelArgumentsResolver
		_contactDetailModelArgumentsResolver;

}