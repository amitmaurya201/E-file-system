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

import io.jetprocess.service.DocFileServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DocFileServiceUtil</code> service
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
public class DocFileServiceHttp {

	public static io.jetprocess.model.DocFile deleteDocFile(
			HttpPrincipal httpPrincipal, long docFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DocFileServiceUtil.class, "deleteDocFile",
				_deleteDocFileParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, docFileId);

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

			return (io.jetprocess.model.DocFile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.model.DocFile> getDocFileList(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				DocFileServiceUtil.class, "getDocFileList",
				_getDocFileListParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.model.DocFile>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject addDocFile(
			HttpPrincipal httpPrincipal, long groupId, String nature,
			String type, long basicHeadId, long primaryHeadId,
			long secondaryHeadId, long tertiaryHeadId, long year,
			long fileCodeId, String subject, String fileNumber, long categoryId,
			long subCategoryId, String remarks, String reference,
			long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DocFileServiceUtil.class, "addDocFile",
				_addDocFileParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, nature, type, basicHeadId, primaryHeadId,
				secondaryHeadId, tertiaryHeadId, year, fileCodeId, subject,
				fileNumber, categoryId, subCategoryId, remarks, reference,
				userPostId, serviceContext);

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

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.model.DocFile updateDocFile(
			HttpPrincipal httpPrincipal, long docFileId, String subject,
			long categoryId, long subCategoryId, String remarks,
			String reference, long userPostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DocFileServiceUtil.class, "updateDocFile",
				_updateDocFileParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, docFileId, subject, categoryId, subCategoryId,
				remarks, reference, userPostId, serviceContext);

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

			return (io.jetprocess.model.DocFile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DocFileServiceHttp.class);

	private static final Class<?>[] _deleteDocFileParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _getDocFileListParameterTypes1 =
		new Class[] {};
	private static final Class<?>[] _addDocFileParameterTypes2 = new Class[] {
		long.class, String.class, String.class, long.class, long.class,
		long.class, long.class, long.class, long.class, String.class,
		String.class, long.class, long.class, String.class, String.class,
		long.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateDocFileParameterTypes3 =
		new Class[] {
			long.class, String.class, long.class, long.class, String.class,
			String.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}