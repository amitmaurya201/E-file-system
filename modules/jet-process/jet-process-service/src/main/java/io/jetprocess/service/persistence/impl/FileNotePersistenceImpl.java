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

import io.jetprocess.exception.NoSuchFileNoteException;
import io.jetprocess.model.FileNote;
import io.jetprocess.model.FileNoteTable;
import io.jetprocess.model.impl.FileNoteImpl;
import io.jetprocess.model.impl.FileNoteModelImpl;
import io.jetprocess.service.persistence.FileNotePersistence;
import io.jetprocess.service.persistence.FileNoteUtil;
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
 * The persistence implementation for the file note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FileNotePersistence.class, BasePersistence.class})
public class FileNotePersistenceImpl
	extends BasePersistenceImpl<FileNote> implements FileNotePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FileNoteUtil</code> to access the file note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FileNoteImpl.class.getName();

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
	 * Returns all the file notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file notes
	 */
	@Override
	public List<FileNote> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of matching file notes
	 */
	@Override
	public List<FileNote> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file notes
	 */
	@Override
	public List<FileNote> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileNote> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file notes
	 */
	@Override
	public List<FileNote> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileNote> orderByComparator, boolean useFinderCache) {

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

		List<FileNote> list = null;

		if (useFinderCache) {
			list = (List<FileNote>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileNote fileNote : list) {
					if (!uuid.equals(fileNote.getUuid())) {
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

			sb.append(_SQL_SELECT_FILENOTE_WHERE);

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
				sb.append(FileNoteModelImpl.ORDER_BY_JPQL);
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

				list = (List<FileNote>)QueryUtil.list(
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
	 * Returns the first file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	@Override
	public FileNote findByUuid_First(
			String uuid, OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		FileNote fileNote = fetchByUuid_First(uuid, orderByComparator);

		if (fileNote != null) {
			return fileNote;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileNoteException(sb.toString());
	}

	/**
	 * Returns the first file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByUuid_First(
		String uuid, OrderByComparator<FileNote> orderByComparator) {

		List<FileNote> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	@Override
	public FileNote findByUuid_Last(
			String uuid, OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		FileNote fileNote = fetchByUuid_Last(uuid, orderByComparator);

		if (fileNote != null) {
			return fileNote;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileNoteException(sb.toString());
	}

	/**
	 * Returns the last file note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByUuid_Last(
		String uuid, OrderByComparator<FileNote> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FileNote> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file notes before and after the current file note in the ordered set where uuid = &#63;.
	 *
	 * @param fileNoteId the primary key of the current file note
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	@Override
	public FileNote[] findByUuid_PrevAndNext(
			long fileNoteId, String uuid,
			OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		uuid = Objects.toString(uuid, "");

		FileNote fileNote = findByPrimaryKey(fileNoteId);

		Session session = null;

		try {
			session = openSession();

			FileNote[] array = new FileNoteImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fileNote, uuid, orderByComparator, true);

			array[1] = fileNote;

			array[2] = getByUuid_PrevAndNext(
				session, fileNote, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileNote getByUuid_PrevAndNext(
		Session session, FileNote fileNote, String uuid,
		OrderByComparator<FileNote> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FILENOTE_WHERE);

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
			sb.append(FileNoteModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(fileNote)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileNote> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file notes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FileNote fileNote :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fileNote);
		}
	}

	/**
	 * Returns the number of file notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file notes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILENOTE_WHERE);

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
		"fileNote.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fileNote.uuid IS NULL OR fileNote.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	@Override
	public FileNote findByUUID_G(String uuid, long groupId)
		throws NoSuchFileNoteException {

		FileNote fileNote = fetchByUUID_G(uuid, groupId);

		if (fileNote == null) {
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

			throw new NoSuchFileNoteException(sb.toString());
		}

		return fileNote;
	}

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the file note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByUUID_G(
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

		if (result instanceof FileNote) {
			FileNote fileNote = (FileNote)result;

			if (!Objects.equals(uuid, fileNote.getUuid()) ||
				(groupId != fileNote.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FILENOTE_WHERE);

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

				List<FileNote> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FileNote fileNote = list.get(0);

					result = fileNote;

					cacheResult(fileNote);
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
			return (FileNote)result;
		}
	}

	/**
	 * Removes the file note where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file note that was removed
	 */
	@Override
	public FileNote removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileNoteException {

		FileNote fileNote = findByUUID_G(uuid, groupId);

		return remove(fileNote);
	}

	/**
	 * Returns the number of file notes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file notes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILENOTE_WHERE);

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
		"fileNote.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(fileNote.uuid IS NULL OR fileNote.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"fileNote.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file notes
	 */
	@Override
	public List<FileNote> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of matching file notes
	 */
	@Override
	public List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file notes
	 */
	@Override
	public List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileNote> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file notes
	 */
	@Override
	public List<FileNote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileNote> orderByComparator, boolean useFinderCache) {

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

		List<FileNote> list = null;

		if (useFinderCache) {
			list = (List<FileNote>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileNote fileNote : list) {
					if (!uuid.equals(fileNote.getUuid()) ||
						(companyId != fileNote.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FILENOTE_WHERE);

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
				sb.append(FileNoteModelImpl.ORDER_BY_JPQL);
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

				list = (List<FileNote>)QueryUtil.list(
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
	 * Returns the first file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	@Override
	public FileNote findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		FileNote fileNote = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (fileNote != null) {
			return fileNote;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileNoteException(sb.toString());
	}

	/**
	 * Returns the first file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileNote> orderByComparator) {

		List<FileNote> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	@Override
	public FileNote findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		FileNote fileNote = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (fileNote != null) {
			return fileNote;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileNoteException(sb.toString());
	}

	/**
	 * Returns the last file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileNote> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FileNote> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file notes before and after the current file note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fileNoteId the primary key of the current file note
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	@Override
	public FileNote[] findByUuid_C_PrevAndNext(
			long fileNoteId, String uuid, long companyId,
			OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		uuid = Objects.toString(uuid, "");

		FileNote fileNote = findByPrimaryKey(fileNoteId);

		Session session = null;

		try {
			session = openSession();

			FileNote[] array = new FileNoteImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, fileNote, uuid, companyId, orderByComparator, true);

			array[1] = fileNote;

			array[2] = getByUuid_C_PrevAndNext(
				session, fileNote, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileNote getByUuid_C_PrevAndNext(
		Session session, FileNote fileNote, String uuid, long companyId,
		OrderByComparator<FileNote> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FILENOTE_WHERE);

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
			sb.append(FileNoteModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(fileNote)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileNote> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file notes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FileNote fileNote :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileNote);
		}
	}

	/**
	 * Returns the number of file notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file notes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILENOTE_WHERE);

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
		"fileNote.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(fileNote.uuid IS NULL OR fileNote.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"fileNote.companyId = ?";

	private FinderPath _finderPathFetchByNoteId;
	private FinderPath _finderPathCountByNoteId;

	/**
	 * Returns the file note where noteId = &#63; or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param noteId the note ID
	 * @return the matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	@Override
	public FileNote findByNoteId(long noteId) throws NoSuchFileNoteException {
		FileNote fileNote = fetchByNoteId(noteId);

		if (fileNote == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("noteId=");
			sb.append(noteId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileNoteException(sb.toString());
		}

		return fileNote;
	}

	/**
	 * Returns the file note where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param noteId the note ID
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByNoteId(long noteId) {
		return fetchByNoteId(noteId, true);
	}

	/**
	 * Returns the file note where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param noteId the note ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByNoteId(long noteId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {noteId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByNoteId, finderArgs);
		}

		if (result instanceof FileNote) {
			FileNote fileNote = (FileNote)result;

			if (noteId != fileNote.getNoteId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FILENOTE_WHERE);

			sb.append(_FINDER_COLUMN_NOTEID_NOTEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(noteId);

				List<FileNote> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByNoteId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {noteId};
							}

							_log.warn(
								"FileNotePersistenceImpl.fetchByNoteId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FileNote fileNote = list.get(0);

					result = fileNote;

					cacheResult(fileNote);
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
			return (FileNote)result;
		}
	}

	/**
	 * Removes the file note where noteId = &#63; from the database.
	 *
	 * @param noteId the note ID
	 * @return the file note that was removed
	 */
	@Override
	public FileNote removeByNoteId(long noteId) throws NoSuchFileNoteException {
		FileNote fileNote = findByNoteId(noteId);

		return remove(fileNote);
	}

	/**
	 * Returns the number of file notes where noteId = &#63;.
	 *
	 * @param noteId the note ID
	 * @return the number of matching file notes
	 */
	@Override
	public int countByNoteId(long noteId) {
		FinderPath finderPath = _finderPathCountByNoteId;

		Object[] finderArgs = new Object[] {noteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILENOTE_WHERE);

			sb.append(_FINDER_COLUMN_NOTEID_NOTEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(noteId);

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

	private static final String _FINDER_COLUMN_NOTEID_NOTEID_2 =
		"fileNote.noteId = ?";

	private FinderPath _finderPathWithPaginationFindByfilemovementId;
	private FinderPath _finderPathWithoutPaginationFindByfilemovementId;
	private FinderPath _finderPathCountByfilemovementId;

	/**
	 * Returns all the file notes where fileMovementId = &#63;.
	 *
	 * @param fileMovementId the file movement ID
	 * @return the matching file notes
	 */
	@Override
	public List<FileNote> findByfilemovementId(long fileMovementId) {
		return findByfilemovementId(
			fileMovementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file notes where fileMovementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param fileMovementId the file movement ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of matching file notes
	 */
	@Override
	public List<FileNote> findByfilemovementId(
		long fileMovementId, int start, int end) {

		return findByfilemovementId(fileMovementId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file notes where fileMovementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param fileMovementId the file movement ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file notes
	 */
	@Override
	public List<FileNote> findByfilemovementId(
		long fileMovementId, int start, int end,
		OrderByComparator<FileNote> orderByComparator) {

		return findByfilemovementId(
			fileMovementId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file notes where fileMovementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param fileMovementId the file movement ID
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file notes
	 */
	@Override
	public List<FileNote> findByfilemovementId(
		long fileMovementId, int start, int end,
		OrderByComparator<FileNote> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfilemovementId;
				finderArgs = new Object[] {fileMovementId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfilemovementId;
			finderArgs = new Object[] {
				fileMovementId, start, end, orderByComparator
			};
		}

		List<FileNote> list = null;

		if (useFinderCache) {
			list = (List<FileNote>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileNote fileNote : list) {
					if (fileMovementId != fileNote.getFileMovementId()) {
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

			sb.append(_SQL_SELECT_FILENOTE_WHERE);

			sb.append(_FINDER_COLUMN_FILEMOVEMENTID_FILEMOVEMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileNoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileMovementId);

				list = (List<FileNote>)QueryUtil.list(
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
	 * Returns the first file note in the ordered set where fileMovementId = &#63;.
	 *
	 * @param fileMovementId the file movement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	@Override
	public FileNote findByfilemovementId_First(
			long fileMovementId, OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		FileNote fileNote = fetchByfilemovementId_First(
			fileMovementId, orderByComparator);

		if (fileNote != null) {
			return fileNote;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileMovementId=");
		sb.append(fileMovementId);

		sb.append("}");

		throw new NoSuchFileNoteException(sb.toString());
	}

	/**
	 * Returns the first file note in the ordered set where fileMovementId = &#63;.
	 *
	 * @param fileMovementId the file movement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByfilemovementId_First(
		long fileMovementId, OrderByComparator<FileNote> orderByComparator) {

		List<FileNote> list = findByfilemovementId(
			fileMovementId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file note in the ordered set where fileMovementId = &#63;.
	 *
	 * @param fileMovementId the file movement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note
	 * @throws NoSuchFileNoteException if a matching file note could not be found
	 */
	@Override
	public FileNote findByfilemovementId_Last(
			long fileMovementId, OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		FileNote fileNote = fetchByfilemovementId_Last(
			fileMovementId, orderByComparator);

		if (fileNote != null) {
			return fileNote;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileMovementId=");
		sb.append(fileMovementId);

		sb.append("}");

		throw new NoSuchFileNoteException(sb.toString());
	}

	/**
	 * Returns the last file note in the ordered set where fileMovementId = &#63;.
	 *
	 * @param fileMovementId the file movement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file note, or <code>null</code> if a matching file note could not be found
	 */
	@Override
	public FileNote fetchByfilemovementId_Last(
		long fileMovementId, OrderByComparator<FileNote> orderByComparator) {

		int count = countByfilemovementId(fileMovementId);

		if (count == 0) {
			return null;
		}

		List<FileNote> list = findByfilemovementId(
			fileMovementId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file notes before and after the current file note in the ordered set where fileMovementId = &#63;.
	 *
	 * @param fileNoteId the primary key of the current file note
	 * @param fileMovementId the file movement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	@Override
	public FileNote[] findByfilemovementId_PrevAndNext(
			long fileNoteId, long fileMovementId,
			OrderByComparator<FileNote> orderByComparator)
		throws NoSuchFileNoteException {

		FileNote fileNote = findByPrimaryKey(fileNoteId);

		Session session = null;

		try {
			session = openSession();

			FileNote[] array = new FileNoteImpl[3];

			array[0] = getByfilemovementId_PrevAndNext(
				session, fileNote, fileMovementId, orderByComparator, true);

			array[1] = fileNote;

			array[2] = getByfilemovementId_PrevAndNext(
				session, fileNote, fileMovementId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileNote getByfilemovementId_PrevAndNext(
		Session session, FileNote fileNote, long fileMovementId,
		OrderByComparator<FileNote> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FILENOTE_WHERE);

		sb.append(_FINDER_COLUMN_FILEMOVEMENTID_FILEMOVEMENTID_2);

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
			sb.append(FileNoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fileMovementId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fileNote)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileNote> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file notes where fileMovementId = &#63; from the database.
	 *
	 * @param fileMovementId the file movement ID
	 */
	@Override
	public void removeByfilemovementId(long fileMovementId) {
		for (FileNote fileNote :
				findByfilemovementId(
					fileMovementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileNote);
		}
	}

	/**
	 * Returns the number of file notes where fileMovementId = &#63;.
	 *
	 * @param fileMovementId the file movement ID
	 * @return the number of matching file notes
	 */
	@Override
	public int countByfilemovementId(long fileMovementId) {
		FinderPath finderPath = _finderPathCountByfilemovementId;

		Object[] finderArgs = new Object[] {fileMovementId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILENOTE_WHERE);

			sb.append(_FINDER_COLUMN_FILEMOVEMENTID_FILEMOVEMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileMovementId);

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

	private static final String _FINDER_COLUMN_FILEMOVEMENTID_FILEMOVEMENTID_2 =
		"fileNote.fileMovementId = ?";

	public FileNotePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FileNote.class);

		setModelImplClass(FileNoteImpl.class);
		setModelPKClass(long.class);

		setTable(FileNoteTable.INSTANCE);
	}

	/**
	 * Caches the file note in the entity cache if it is enabled.
	 *
	 * @param fileNote the file note
	 */
	@Override
	public void cacheResult(FileNote fileNote) {
		entityCache.putResult(
			FileNoteImpl.class, fileNote.getPrimaryKey(), fileNote);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {fileNote.getUuid(), fileNote.getGroupId()}, fileNote);

		finderCache.putResult(
			_finderPathFetchByNoteId, new Object[] {fileNote.getNoteId()},
			fileNote);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the file notes in the entity cache if it is enabled.
	 *
	 * @param fileNotes the file notes
	 */
	@Override
	public void cacheResult(List<FileNote> fileNotes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fileNotes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FileNote fileNote : fileNotes) {
			if (entityCache.getResult(
					FileNoteImpl.class, fileNote.getPrimaryKey()) == null) {

				cacheResult(fileNote);
			}
		}
	}

	/**
	 * Clears the cache for all file notes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FileNoteImpl.class);

		finderCache.clearCache(FileNoteImpl.class);
	}

	/**
	 * Clears the cache for the file note.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileNote fileNote) {
		entityCache.removeResult(FileNoteImpl.class, fileNote);
	}

	@Override
	public void clearCache(List<FileNote> fileNotes) {
		for (FileNote fileNote : fileNotes) {
			entityCache.removeResult(FileNoteImpl.class, fileNote);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FileNoteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FileNoteImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FileNoteModelImpl fileNoteModelImpl) {

		Object[] args = new Object[] {
			fileNoteModelImpl.getUuid(), fileNoteModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, fileNoteModelImpl);

		args = new Object[] {fileNoteModelImpl.getNoteId()};

		finderCache.putResult(_finderPathCountByNoteId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByNoteId, args, fileNoteModelImpl);
	}

	/**
	 * Creates a new file note with the primary key. Does not add the file note to the database.
	 *
	 * @param fileNoteId the primary key for the new file note
	 * @return the new file note
	 */
	@Override
	public FileNote create(long fileNoteId) {
		FileNote fileNote = new FileNoteImpl();

		fileNote.setNew(true);
		fileNote.setPrimaryKey(fileNoteId);

		String uuid = _portalUUID.generate();

		fileNote.setUuid(uuid);

		fileNote.setCompanyId(CompanyThreadLocal.getCompanyId());

		return fileNote;
	}

	/**
	 * Removes the file note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note that was removed
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	@Override
	public FileNote remove(long fileNoteId) throws NoSuchFileNoteException {
		return remove((Serializable)fileNoteId);
	}

	/**
	 * Removes the file note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file note
	 * @return the file note that was removed
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	@Override
	public FileNote remove(Serializable primaryKey)
		throws NoSuchFileNoteException {

		Session session = null;

		try {
			session = openSession();

			FileNote fileNote = (FileNote)session.get(
				FileNoteImpl.class, primaryKey);

			if (fileNote == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileNoteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fileNote);
		}
		catch (NoSuchFileNoteException noSuchEntityException) {
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
	protected FileNote removeImpl(FileNote fileNote) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileNote)) {
				fileNote = (FileNote)session.get(
					FileNoteImpl.class, fileNote.getPrimaryKeyObj());
			}

			if (fileNote != null) {
				session.delete(fileNote);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fileNote != null) {
			clearCache(fileNote);
		}

		return fileNote;
	}

	@Override
	public FileNote updateImpl(FileNote fileNote) {
		boolean isNew = fileNote.isNew();

		if (!(fileNote instanceof FileNoteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fileNote.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fileNote);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fileNote proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FileNote implementation " +
					fileNote.getClass());
		}

		FileNoteModelImpl fileNoteModelImpl = (FileNoteModelImpl)fileNote;

		if (Validator.isNull(fileNote.getUuid())) {
			String uuid = _portalUUID.generate();

			fileNote.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (fileNote.getCreateDate() == null)) {
			if (serviceContext == null) {
				fileNote.setCreateDate(date);
			}
			else {
				fileNote.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!fileNoteModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fileNote.setModifiedDate(date);
			}
			else {
				fileNote.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fileNote);
			}
			else {
				fileNote = (FileNote)session.merge(fileNote);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FileNoteImpl.class, fileNoteModelImpl, false, true);

		cacheUniqueFindersCache(fileNoteModelImpl);

		if (isNew) {
			fileNote.setNew(false);
		}

		fileNote.resetOriginalValues();

		return fileNote;
	}

	/**
	 * Returns the file note with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file note
	 * @return the file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	@Override
	public FileNote findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileNoteException {

		FileNote fileNote = fetchByPrimaryKey(primaryKey);

		if (fileNote == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileNoteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fileNote;
	}

	/**
	 * Returns the file note with the primary key or throws a <code>NoSuchFileNoteException</code> if it could not be found.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note
	 * @throws NoSuchFileNoteException if a file note with the primary key could not be found
	 */
	@Override
	public FileNote findByPrimaryKey(long fileNoteId)
		throws NoSuchFileNoteException {

		return findByPrimaryKey((Serializable)fileNoteId);
	}

	/**
	 * Returns the file note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileNoteId the primary key of the file note
	 * @return the file note, or <code>null</code> if a file note with the primary key could not be found
	 */
	@Override
	public FileNote fetchByPrimaryKey(long fileNoteId) {
		return fetchByPrimaryKey((Serializable)fileNoteId);
	}

	/**
	 * Returns all the file notes.
	 *
	 * @return the file notes
	 */
	@Override
	public List<FileNote> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @return the range of file notes
	 */
	@Override
	public List<FileNote> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file notes
	 */
	@Override
	public List<FileNote> findAll(
		int start, int end, OrderByComparator<FileNote> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileNoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file notes
	 * @param end the upper bound of the range of file notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file notes
	 */
	@Override
	public List<FileNote> findAll(
		int start, int end, OrderByComparator<FileNote> orderByComparator,
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

		List<FileNote> list = null;

		if (useFinderCache) {
			list = (List<FileNote>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FILENOTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FILENOTE;

				sql = sql.concat(FileNoteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FileNote>)QueryUtil.list(
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
	 * Removes all the file notes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FileNote fileNote : findAll()) {
			remove(fileNote);
		}
	}

	/**
	 * Returns the number of file notes.
	 *
	 * @return the number of file notes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FILENOTE);

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
		return "fileNoteId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FILENOTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FileNoteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the file note persistence.
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

		_finderPathFetchByNoteId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByNoteId",
			new String[] {Long.class.getName()}, new String[] {"noteId"}, true);

		_finderPathCountByNoteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNoteId",
			new String[] {Long.class.getName()}, new String[] {"noteId"},
			false);

		_finderPathWithPaginationFindByfilemovementId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfilemovementId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fileMovementId"}, true);

		_finderPathWithoutPaginationFindByfilemovementId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfilemovementId",
			new String[] {Long.class.getName()},
			new String[] {"fileMovementId"}, true);

		_finderPathCountByfilemovementId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfilemovementId",
			new String[] {Long.class.getName()},
			new String[] {"fileMovementId"}, false);

		_setFileNoteUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFileNoteUtilPersistence(null);

		entityCache.removeCache(FileNoteImpl.class.getName());
	}

	private void _setFileNoteUtilPersistence(
		FileNotePersistence fileNotePersistence) {

		try {
			Field field = FileNoteUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, fileNotePersistence);
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

	private static final String _SQL_SELECT_FILENOTE =
		"SELECT fileNote FROM FileNote fileNote";

	private static final String _SQL_SELECT_FILENOTE_WHERE =
		"SELECT fileNote FROM FileNote fileNote WHERE ";

	private static final String _SQL_COUNT_FILENOTE =
		"SELECT COUNT(fileNote) FROM FileNote fileNote";

	private static final String _SQL_COUNT_FILENOTE_WHERE =
		"SELECT COUNT(fileNote) FROM FileNote fileNote WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fileNote.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FileNote exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FileNote exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FileNotePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FileNoteModelArgumentsResolver _fileNoteModelArgumentsResolver;

}