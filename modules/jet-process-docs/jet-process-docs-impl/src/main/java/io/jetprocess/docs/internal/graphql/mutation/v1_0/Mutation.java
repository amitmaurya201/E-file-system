package io.jetprocess.docs.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.multipart.MultipartBody;

import io.jetprocess.docs.dto.v1_0.DOCStore;
import io.jetprocess.docs.resource.v1_0.DOCStoreResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setDOCStoreResourceComponentServiceObjects(
		ComponentServiceObjects<DOCStoreResource>
			docStoreResourceComponentServiceObjects) {

		_docStoreResourceComponentServiceObjects =
			docStoreResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLName(description = "null", value = "tempFileUploadMultipartBody")
	public DOCStore tempFileUpload(
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_docStoreResourceComponentServiceObjects,
			this::_populateResourceContext,
			docStoreResource -> docStoreResource.tempFileUpload(multipartBody));
	}

	@GraphQLField
	@GraphQLName(description = "null", value = "uploadFileMultipartBody")
	public DOCStore uploadFile(
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_docStoreResourceComponentServiceObjects,
			this::_populateResourceContext,
			docStoreResource -> docStoreResource.uploadFile(multipartBody));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(DOCStoreResource docStoreResource)
		throws Exception {

		docStoreResource.setContextAcceptLanguage(_acceptLanguage);
		docStoreResource.setContextCompany(_company);
		docStoreResource.setContextHttpServletRequest(_httpServletRequest);
		docStoreResource.setContextHttpServletResponse(_httpServletResponse);
		docStoreResource.setContextUriInfo(_uriInfo);
		docStoreResource.setContextUser(_user);
		docStoreResource.setGroupLocalService(_groupLocalService);
		docStoreResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<DOCStoreResource>
		_docStoreResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}