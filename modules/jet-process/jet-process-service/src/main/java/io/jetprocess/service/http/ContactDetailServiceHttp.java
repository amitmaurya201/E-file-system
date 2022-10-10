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

import io.jetprocess.service.ContactDetailServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ContactDetailServiceUtil</code> service
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
public class ContactDetailServiceHttp {

	public static io.jetprocess.model.ContactDetail addContactDetails(
			HttpPrincipal httpPrincipal, long groupId, String minDeptOth,
			String name, String designation, String mobile, String email,
			String address, String country, String state, String district,
			String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ContactDetailServiceUtil.class, "addContactDetails",
				_addContactDetailsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, minDeptOth, name, designation, mobile,
				email, address, country, state, district, pinCode,
				serviceContext);

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

			return (io.jetprocess.model.ContactDetail)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.model.ContactDetail deleteContactDetail(
			HttpPrincipal httpPrincipal, long contactDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ContactDetailServiceUtil.class, "deleteContactDetail",
				_deleteContactDetailParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, contactDetailId);

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

			return (io.jetprocess.model.ContactDetail)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.model.ContactDetail>
		getContactDetailByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				ContactDetailServiceUtil.class, "getContactDetailByGroupId",
				_getContactDetailByGroupIdParameterTypes2);

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

			return (java.util.List<io.jetprocess.model.ContactDetail>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.model.ContactDetail updateContactDetail(
			HttpPrincipal httpPrincipal, long contactDetailId,
			String minDeptOth, String name, String designation, String mobile,
			String email, String address, String country, String state,
			String district, String pinCode,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ContactDetailServiceUtil.class, "updateContactDetail",
				_updateContactDetailParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, contactDetailId, minDeptOth, name, designation,
				mobile, email, address, country, state, district, pinCode,
				serviceContext);

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

			return (io.jetprocess.model.ContactDetail)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ContactDetailServiceHttp.class);

	private static final Class<?>[] _addContactDetailsParameterTypes0 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class,
			String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteContactDetailParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getContactDetailByGroupIdParameterTypes2 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[] _updateContactDetailParameterTypes3 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class,
			String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}