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

package io.jetprocess.masterdata.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import io.jetprocess.masterdata.exception.NoSuchMasterdataException;
import io.jetprocess.masterdata.model.Masterdata;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the masterdata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterdataUtil
 * @generated
 */
@ProviderType
public interface MasterdataPersistence extends BasePersistence<Masterdata> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterdataUtil} to access the masterdata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the masterdata in the entity cache if it is enabled.
	 *
	 * @param masterdata the masterdata
	 */
	public void cacheResult(Masterdata masterdata);

	/**
	 * Caches the masterdatas in the entity cache if it is enabled.
	 *
	 * @param masterdatas the masterdatas
	 */
	public void cacheResult(java.util.List<Masterdata> masterdatas);

	/**
	 * Creates a new masterdata with the primary key. Does not add the masterdata to the database.
	 *
	 * @param masterdataId the primary key for the new masterdata
	 * @return the new masterdata
	 */
	public Masterdata create(String masterdataId);

	/**
	 * Removes the masterdata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata that was removed
	 * @throws NoSuchMasterdataException if a masterdata with the primary key could not be found
	 */
	public Masterdata remove(String masterdataId)
		throws NoSuchMasterdataException;

	public Masterdata updateImpl(Masterdata masterdata);

	/**
	 * Returns the masterdata with the primary key or throws a <code>NoSuchMasterdataException</code> if it could not be found.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata
	 * @throws NoSuchMasterdataException if a masterdata with the primary key could not be found
	 */
	public Masterdata findByPrimaryKey(String masterdataId)
		throws NoSuchMasterdataException;

	/**
	 * Returns the masterdata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterdataId the primary key of the masterdata
	 * @return the masterdata, or <code>null</code> if a masterdata with the primary key could not be found
	 */
	public Masterdata fetchByPrimaryKey(String masterdataId);

	/**
	 * Returns all the masterdatas.
	 *
	 * @return the masterdatas
	 */
	public java.util.List<Masterdata> findAll();

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
	public java.util.List<Masterdata> findAll(int start, int end);

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
	public java.util.List<Masterdata> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Masterdata>
			orderByComparator);

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
	public java.util.List<Masterdata> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Masterdata>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the masterdatas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of masterdatas.
	 *
	 * @return the number of masterdatas
	 */
	public int countAll();

}