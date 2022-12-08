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

package io.jetprocess.masterdata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import io.jetprocess.masterdata.service.MasterdataServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>MasterdataServiceUtil</code> service
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
public class MasterdataServiceHttp {

	public static java.util.List
		<io.jetprocess.masterdata.model.ReceiptMovementDTO> getReceiptInboxList(
			HttpPrincipal httpPrincipal, long userPostId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptInboxList",
				_getReceiptInboxListParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userPostId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<io.jetprocess.masterdata.model.ReceiptMovementDTO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCategoryMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getCategoryMasterdata",
				_getCategoryMasterdataParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubCategoryMasterdata(HttpPrincipal httpPrincipal, long categoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSubCategoryMasterdata",
				_getSubCategoryMasterdataParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTypeMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getTypeMasterdata",
				_getTypeMasterdataParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getDeliveryModeMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getDeliveryModeMasterdata",
				_getDeliveryModeMasterdataParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getFileCodeMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getFileCodeMasterdata",
				_getFileCodeMasterdataParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getBasicHeadMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getBasicHeadMasterdata",
				_getBasicHeadMasterdataParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getPrimaryHeadMasterdata(
			HttpPrincipal httpPrincipal, long basicHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getPrimaryHeadMasterdata",
				_getPrimaryHeadMasterdataParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, basicHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSecondaryHeadMasterdata(
			HttpPrincipal httpPrincipal, long primaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSecondaryHeadMasterdata",
				_getSecondaryHeadMasterdataParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTeritaryHeadMasterdata(
			HttpPrincipal httpPrincipal, long secondaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getTeritaryHeadMasterdata",
				_getTeritaryHeadMasterdataParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, secondaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getOrganizationMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getOrganizationMasterdata",
				_getOrganizationMasterdataParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubOrganizationMasterdata(
			HttpPrincipal httpPrincipal, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSubOrganizationMasterdata",
				_getSubOrganizationMasterdataParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptCategoryMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptCategoryMasterdata",
				_getReceiptCategoryMasterdataParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptSubCategoryMasterdata(
			HttpPrincipal httpPrincipal, long receiptCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptSubCategoryMasterdata",
				_getReceiptSubCategoryMasterdataParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, receiptCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCountriesMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getCountriesMasterdata",
				_getCountriesMasterdataParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getStatesMasterdata(HttpPrincipal httpPrincipal, long countryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getStatesMasterdata",
				_getStatesMasterdataParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, countryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getBasicHeadByIdMasterdata(
			HttpPrincipal httpPrincipal, long basicHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getBasicHeadByIdMasterdata",
				_getBasicHeadByIdMasterdataParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, basicHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getPrimaryHeadByIdMasterdata(
			HttpPrincipal httpPrincipal, long primaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getPrimaryHeadByIdMasterdata",
				_getPrimaryHeadByIdMasterdataParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getSecondaryHeadByIdMasterdata(
			HttpPrincipal httpPrincipal, long secondaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSecondaryHeadByIdMasterdata",
				_getSecondaryHeadByIdMasterdataParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, secondaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getTertiaryByIdMasterdata(
			HttpPrincipal httpPrincipal, long tertiaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getTertiaryByIdMasterdata",
				_getTertiaryByIdMasterdataParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, tertiaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.FileListViewDto>
		getFileCreatedListMasterdata(
			HttpPrincipal httpPrincipal, long userPostId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getFileCreatedListMasterdata",
				_getFileCreatedListMasterdataParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userPostId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<io.jetprocess.masterdata.model.FileListViewDto>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<io.jetprocess.masterdata.model.ReceiptListViewDto>
			getReceiptListMasterdata(
				HttpPrincipal httpPrincipal, long userPostId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptListMasterdata",
				_getReceiptListMasterdataParameterTypes21);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userPostId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<io.jetprocess.masterdata.model.ReceiptListViewDto>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getFileCodeValueByIdMasterdata(
			HttpPrincipal httpPrincipal, long fileCodeId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getFileCodeValueByIdMasterdata",
				_getFileCodeValueByIdMasterdataParameterTypes22);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fileCodeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getCategoryValueByIdMasterdata(
			HttpPrincipal httpPrincipal, long categoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getCategoryValueByIdMasterdata",
				_getCategoryValueByIdMasterdataParameterTypes23);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getSubCategoryValueByIdMasterdata(
			HttpPrincipal httpPrincipal, long subCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class,
				"getSubCategoryValueByIdMasterdata",
				_getSubCategoryValueByIdMasterdataParameterTypes24);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getTypeValueByIdMasterdata(HttpPrincipal httpPrincipal, long typeId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getTypeValueByIdMasterdata",
				_getTypeValueByIdMasterdataParameterTypes25);

			MethodHandler methodHandler = new MethodHandler(methodKey, typeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getDeliveryModeByIdMasterdata(
			HttpPrincipal httpPrincipal, long deliveryModeId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getDeliveryModeByIdMasterdata",
				_getDeliveryModeByIdMasterdataParameterTypes26);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, deliveryModeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getOrganizationByIdMasterdata(
			HttpPrincipal httpPrincipal, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getOrganizationByIdMasterdata",
				_getOrganizationByIdMasterdataParameterTypes27);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getSubOrganizationByIdMasterdata(
			HttpPrincipal httpPrincipal, long subOrganizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSubOrganizationByIdMasterdata",
				_getSubOrganizationByIdMasterdataParameterTypes28);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subOrganizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getCountryByIdMasterdata(HttpPrincipal httpPrincipal, long countryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getCountryByIdMasterdata",
				_getCountryByIdMasterdataParameterTypes29);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, countryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getStateByIdMasterdata(HttpPrincipal httpPrincipal, long stateId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getStateByIdMasterdata",
				_getStateByIdMasterdataParameterTypes30);

			MethodHandler methodHandler = new MethodHandler(methodKey, stateId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getReceiptCategoryByIdMasterdata(
			HttpPrincipal httpPrincipal, long receiptCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptCategoryByIdMasterdata",
				_getReceiptCategoryByIdMasterdataParameterTypes31);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, receiptCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getReceiptSubCategoryByIdMasterdata(
			HttpPrincipal httpPrincipal, long receiptSubCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class,
				"getReceiptSubCategoryByIdMasterdata",
				_getReceiptSubCategoryByIdMasterdataParameterTypes32);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, receiptSubCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<io.jetprocess.masterdata.model.ReceiptMovementDTO>
			getReceiptMovementDTOListByUserPostId(
				HttpPrincipal httpPrincipal, long userPostId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class,
				"getReceiptMovementDTOListByUserPostId",
				_getReceiptMovementDTOListByUserPostIdParameterTypes33);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userPostId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<io.jetprocess.masterdata.model.ReceiptMovementDTO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MasterdataServiceHttp.class);

	private static final Class<?>[] _getReceiptInboxListParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _getCategoryMasterdataParameterTypes1 =
		new Class[] {};
	private static final Class<?>[] _getSubCategoryMasterdataParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getTypeMasterdataParameterTypes3 =
		new Class[] {};
	private static final Class<?>[] _getDeliveryModeMasterdataParameterTypes4 =
		new Class[] {};
	private static final Class<?>[] _getFileCodeMasterdataParameterTypes5 =
		new Class[] {};
	private static final Class<?>[] _getBasicHeadMasterdataParameterTypes6 =
		new Class[] {};
	private static final Class<?>[] _getPrimaryHeadMasterdataParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _getSecondaryHeadMasterdataParameterTypes8 =
		new Class[] {long.class};
	private static final Class<?>[] _getTeritaryHeadMasterdataParameterTypes9 =
		new Class[] {long.class};
	private static final Class<?>[] _getOrganizationMasterdataParameterTypes10 =
		new Class[] {};
	private static final Class<?>[]
		_getSubOrganizationMasterdataParameterTypes11 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getReceiptCategoryMasterdataParameterTypes12 = new Class[] {};
	private static final Class<?>[]
		_getReceiptSubCategoryMasterdataParameterTypes13 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCountriesMasterdataParameterTypes14 =
		new Class[] {};
	private static final Class<?>[] _getStatesMasterdataParameterTypes15 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getBasicHeadByIdMasterdataParameterTypes16 = new Class[] {long.class};
	private static final Class<?>[]
		_getPrimaryHeadByIdMasterdataParameterTypes17 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getSecondaryHeadByIdMasterdataParameterTypes18 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getTertiaryByIdMasterdataParameterTypes19 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getFileCreatedListMasterdataParameterTypes20 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getReceiptListMasterdataParameterTypes21 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getFileCodeValueByIdMasterdataParameterTypes22 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getCategoryValueByIdMasterdataParameterTypes23 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getSubCategoryValueByIdMasterdataParameterTypes24 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getTypeValueByIdMasterdataParameterTypes25 = new Class[] {long.class};
	private static final Class<?>[]
		_getDeliveryModeByIdMasterdataParameterTypes26 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getOrganizationByIdMasterdataParameterTypes27 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getSubOrganizationByIdMasterdataParameterTypes28 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCountryByIdMasterdataParameterTypes29 =
		new Class[] {long.class};
	private static final Class<?>[] _getStateByIdMasterdataParameterTypes30 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getReceiptCategoryByIdMasterdataParameterTypes31 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getReceiptSubCategoryByIdMasterdataParameterTypes32 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getReceiptMovementDTOListByUserPostIdParameterTypes33 = new Class[] {
			long.class
		};

}