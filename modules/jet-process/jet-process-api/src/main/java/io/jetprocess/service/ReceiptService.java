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

package io.jetprocess.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import io.jetprocess.exception.NoSuchReceiptException;
import io.jetprocess.model.Receipt;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Receipt. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ReceiptService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>io.jetprocess.service.impl.ReceiptServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the receipt remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ReceiptServiceUtil} if injection and service tracking are not available.
	 */
	public Receipt createReceipt(
			long groupId, long typeId, long tempfileEntryId,
			long deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String name, String designation, String mobile, String email,
			String address, long countryId, long stateId, String pinCode,
			long organizationId, long subOrganizationId, String city,
			long userPostId, ServiceContext serviceContext)
		throws PortalException;

	public Receipt deleteReceipt(long receiptId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Receipt> getAllReceipt();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Receipt getReceiptByReceiptId(long receiptId)
		throws NoSuchReceiptException;

	public Receipt updateReceipt(
			long receiptId, long groupId, long typeId, long tempfileEntryId,
			long deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber, long receiptCategoryId,
			long receiptSubCategoryId, String subject, String remarks,
			String document, String name, String designation, String mobile,
			String email, String address, long countryId, long stateId,
			String pinCode, long organizationId, long subOrganizationId,
			String city, long userPostId, ServiceContext serviceContext)
		throws PortalException;

}