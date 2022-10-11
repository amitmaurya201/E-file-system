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

package io.jetprocess.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import io.jetprocess.service.ReceiptServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ReceiptServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReceiptServiceHttp {

	public static io.jetprocess.model.Receipt addReceipt(
			HttpPrincipal httpPrincipal, long groupId, String type,
			String deliveryMode, java.util.Date receivedOn,
			java.util.Date letterDate, String referenceNumber,
			String organisation, String modeNumber, String category,
			String subCategory, String subject, String remarks, String document,
			String minDeptOth, String name, String designation, String mobile,
			String email, String address, String country, String state,
			String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ReceiptServiceUtil.class, "addReceipt",
				_addReceiptParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, type, deliveryMode, receivedOn, letterDate,
				referenceNumber, organisation, modeNumber, category,
				subCategory, subject, remarks, document, minDeptOth, name,
				designation, mobile, email, address, country, state, district,
				pinCode, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.model.Receipt)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.model.Receipt deleteReceipt(
			HttpPrincipal httpPrincipal, long receiptId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ReceiptServiceUtil.class, "deleteReceipt",
				_deleteReceiptParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, receiptId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.model.Receipt)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.model.Receipt>
		getReceiptByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				ReceiptServiceUtil.class, "getReceiptByGroupId",
				_getReceiptByGroupIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.model.Receipt>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ReceiptServiceHttp.class);

	private static final Class<?>[] _addReceiptParameterTypes0 = new Class[] {
		long.class, String.class, String.class, java.util.Date.class,
		java.util.Date.class, String.class, String.class, String.class,
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteReceiptParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getReceiptByGroupIdParameterTypes2 =
		new Class[] {long.class, int.class, int.class};

}