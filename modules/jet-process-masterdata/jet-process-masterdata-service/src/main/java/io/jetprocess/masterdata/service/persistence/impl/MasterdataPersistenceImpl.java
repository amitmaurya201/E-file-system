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

package io.jetprocess.masterdata.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;

import io.jetprocess.masterdata.exception.NoSuchMasterdataException;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.MasterdataTable;
import io.jetprocess.masterdata.model.impl.MasterdataImpl;
import io.jetprocess.masterdata.model.impl.MasterdataModelImpl;
import io.jetprocess.masterdata.service.persistence.MasterdataPersistence;
import io.jetprocess.masterdata.service.persistence.MasterdataUtil;
import io.jetprocess.masterdata.service.persistence.impl.constants.MasterdataPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the masterdata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {MasterdataPersistence.class, BasePersistence.class})
public class MasterdataPersistenceImpl
	extends BasePersistenceImpl<Masterdata> implements MasterdataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterdataUtil</code> to access the masterdata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterdataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MasterdataPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Masterdata.class);

		setModelImplClass(MasterdataImpl.class);
		setModelPKClass(String.class);

		setTable(MasterdataTable.INSTANCE);
	}

	/**
	 * Caches the masterdata in the entity cache if it is enabled.
	 *
	 * @param masterdata the masterdata
	 */
	@Override
	public void cacheResult(Masterdata masterdata) {
		entityCache.putResult(
			MasterdataImpl.class, masterdata.getPrimaryKey(), masterdata);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the masterdatas in the entity cache if it is enabled.
	 *
	 * @param masterdatas the masterdatas
	 */
	@Override
	public void cacheResult(List<Masterdata> masterdatas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterdatas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Masterdata masterdata : masterdatas) {
			if (entityCache.getResult(
					MasterdataImpl.class, masterdata.getPrimaryKey()) == null) {

				cacheResult(masterdata);
			}
		}
	}

	/**
	 * Clears the cache for all masterdatas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterdataImpl.class);

		finderCache.clearCache(MasterdataImpl.class);
	}

	/**
	 * Clears the cache for the masterdata.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Masterdata masterdata) {
		entityCache.removeResult(MasterdataImpl.class, masterdata);
	}

	@Override
	public void clearCache(List<Masterdata> masterdatas) {
		for (Masterdata masterdata : masterdatas) {
			entityCache.removeResult(MasterdataImpl.class, masterdata);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MasterdataImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterdataImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new masterdata with the primary key. Does not add the masterdata to the database.
	 *
	 * @param masterdataId the primary key for the new masterdata
	 * @return the new masterdata
	 */
	@Override
	public Masterdata create(String masterdataId) {
		Masterdata masterdata = new MasterdataImpl();

		masterdata.setNew(true);
		masterdata.setPrimaryKey(masterdataId);

		return masterdata;
	}

	/**
	 * Removes the masterdata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata that was removed
	 * @throws NoSuchMasterdataException if a masterdata with the primary key could not be found
	 */
	@Override
	public Masterdata remove(String masterdataId)
		throws NoSuchMasterdataException {

		return remove((Serializable)masterdataId);
	}

	/**
	 * Removes the masterdata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the masterdata
	 * @return the masterdata that was removed
	 * @throws NoSuchMasterdataException if a masterdata with the primary key could not be found
	 */
	@Override
	public Masterdata remove(Serializable primaryKey)
		throws NoSuchMasterdataException {

		Session session = null;

		try {
			session = openSession();

			Masterdata masterdata = (Masterdata)session.get(
				MasterdataImpl.class, primaryKey);

			if (masterdata == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterdataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterdata);
		}
		catch (NoSuchMasterdataException noSuchEntityException) {
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
	protected Masterdata removeImpl(Masterdata masterdata) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterdata)) {
				masterdata = (Masterdata)session.get(
					MasterdataImpl.class, masterdata.getPrimaryKeyObj());
			}

			if (masterdata != null) {
				session.delete(masterdata);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterdata != null) {
			clearCache(masterdata);
		}

		return masterdata;
	}

	@Override
	public Masterdata updateImpl(Masterdata masterdata) {
		boolean isNew = masterdata.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterdata);
			}
			else {
				masterdata = (Masterdata)session.merge(masterdata);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(MasterdataImpl.class, masterdata, false, true);

		if (isNew) {
			masterdata.setNew(false);
		}

		masterdata.resetOriginalValues();

		return masterdata;
	}

	/**
	 * Returns the masterdata with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the masterdata
	 * @return the masterdata
	 * @throws NoSuchMasterdataException if a masterdata with the primary key could not be found
	 */
	@Override
	public Masterdata findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterdataException {

		Masterdata masterdata = fetchByPrimaryKey(primaryKey);

		if (masterdata == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterdataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterdata;
	}

	/**
	 * Returns the masterdata with the primary key or throws a <code>NoSuchMasterdataException</code> if it could not be found.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata
	 * @throws NoSuchMasterdataException if a masterdata with the primary key could not be found
	 */
	@Override
	public Masterdata findByPrimaryKey(String masterdataId)
		throws NoSuchMasterdataException {

		return findByPrimaryKey((Serializable)masterdataId);
	}

	/**
	 * Returns the masterdata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata, or <code>null</code> if a masterdata with the primary key could not be found
	 */
	@Override
	public Masterdata fetchByPrimaryKey(String masterdataId) {
		return fetchByPrimaryKey((Serializable)masterdataId);
	}

	/**
	 * Returns all the masterdatas.
	 *
	 * @return the masterdatas
	 */
	@Override
	public List<Masterdata> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the masterdatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterdataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of masterdatas
	 * @param end the upper bound of the range of masterdatas (not inclusive)
	 * @return the range of masterdatas
	 */
	@Override
	public List<Masterdata> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the masterdatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterdataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of masterdatas
	 * @param end the upper bound of the range of masterdatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of masterdatas
	 */
	@Override
	public List<Masterdata> findAll(
		int start, int end, OrderByComparator<Masterdata> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the masterdatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterdataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of masterdatas
	 * @param end the upper bound of the range of masterdatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of masterdatas
	 */
	@Override
	public List<Masterdata> findAll(
		int start, int end, OrderByComparator<Masterdata> orderByComparator,
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

		List<Masterdata> list = null;

		if (useFinderCache) {
			list = (List<Masterdata>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERDATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERDATA;

				sql = sql.concat(MasterdataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Masterdata>)QueryUtil.list(
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
	 * Removes all the masterdatas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Masterdata masterdata : findAll()) {
			remove(masterdata);
		}
	}

	/**
	 * Returns the number of masterdatas.
	 *
	 * @return the number of masterdatas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERDATA);

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
		return "masterdataId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterdataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the masterdata persistence.
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

		_setMasterdataUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterdataUtilPersistence(null);

		entityCache.removeCache(MasterdataImpl.class.getName());
	}

	private void _setMasterdataUtilPersistence(
		MasterdataPersistence masterdataPersistence) {

		try {
			Field field = MasterdataUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, masterdataPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MasterdataPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MasterdataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MasterdataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MASTERDATA =
		"SELECT masterdata FROM Masterdata masterdata";

	private static final String _SQL_COUNT_MASTERDATA =
		"SELECT COUNT(masterdata) FROM Masterdata masterdata";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterdata.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Masterdata exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterdataPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private MasterdataModelArgumentsResolver _masterdataModelArgumentsResolver;

}