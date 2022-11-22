package jet.process.rs.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import jet.process.rs.dto.v1_0.ReceiptRsModel;
import jet.process.rs.resource.v1_0.ReceiptRsModelResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class Query {

	public static void setReceiptRsModelResourceComponentServiceObjects(
		ComponentServiceObjects<ReceiptRsModelResource>
			receiptRsModelResourceComponentServiceObjects) {

		_receiptRsModelResourceComponentServiceObjects =
			receiptRsModelResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {receiptByReceiptId(id: ___){id, typeId, tempFileId, groupId, deliveryModeId, receiptCategoryId, receiptSubCategoryId, countryId, stateId, organizationId, subOrganizationId, userPostId, receivedOn, letterDate, referenceNumber, modeNumber, subject, remarks, name, designation, mobile, email, address, pinCode, city, viewPdfUrl, dmFileId, receiptNumber, typevalue, deliverymodevalue, organizationvalue, suborganizationvalue, countryvalue, statevalue, receiptcategoryvalue, receiptsubcategoryvalue}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ReceiptRsModel receiptByReceiptId(@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_receiptRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			receiptRsModelResource ->
				receiptRsModelResource.getReceiptByReceiptId(id));
	}

	@GraphQLName("ReceiptRsModelPage")
	public class ReceiptRsModelPage {

		public ReceiptRsModelPage(Page receiptRsModelPage) {
			actions = receiptRsModelPage.getActions();

			items = receiptRsModelPage.getItems();
			lastPage = receiptRsModelPage.getLastPage();
			page = receiptRsModelPage.getPage();
			pageSize = receiptRsModelPage.getPageSize();
			totalCount = receiptRsModelPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<ReceiptRsModel> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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

	private void _populateResourceContext(
			ReceiptRsModelResource receiptRsModelResource)
		throws Exception {

		receiptRsModelResource.setContextAcceptLanguage(_acceptLanguage);
		receiptRsModelResource.setContextCompany(_company);
		receiptRsModelResource.setContextHttpServletRequest(
			_httpServletRequest);
		receiptRsModelResource.setContextHttpServletResponse(
			_httpServletResponse);
		receiptRsModelResource.setContextUriInfo(_uriInfo);
		receiptRsModelResource.setContextUser(_user);
		receiptRsModelResource.setGroupLocalService(_groupLocalService);
		receiptRsModelResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<ReceiptRsModelResource>
		_receiptRsModelResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}