package jet.process.rs.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import jet.process.rs.client.dto.v1_0.ReceiptRsModel;
import jet.process.rs.client.http.HttpInvoker;
import jet.process.rs.client.pagination.Page;
import jet.process.rs.client.resource.v1_0.ReceiptRsModelResource;
import jet.process.rs.client.serdes.v1_0.ReceiptRsModelSerDes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public abstract class BaseReceiptRsModelResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_receiptRsModelResource.setContextCompany(testCompany);

		ReceiptRsModelResource.Builder builder =
			ReceiptRsModelResource.builder();

		receiptRsModelResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		ReceiptRsModel receiptRsModel1 = randomReceiptRsModel();

		String json = objectMapper.writeValueAsString(receiptRsModel1);

		ReceiptRsModel receiptRsModel2 = ReceiptRsModelSerDes.toDTO(json);

		Assert.assertTrue(equals(receiptRsModel1, receiptRsModel2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		ReceiptRsModel receiptRsModel = randomReceiptRsModel();

		String json1 = objectMapper.writeValueAsString(receiptRsModel);
		String json2 = ReceiptRsModelSerDes.toJSON(receiptRsModel);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		ReceiptRsModel receiptRsModel = randomReceiptRsModel();

		receiptRsModel.setAddress(regex);
		receiptRsModel.setCity(regex);
		receiptRsModel.setDesignation(regex);
		receiptRsModel.setEmail(regex);
		receiptRsModel.setLetterDate(regex);
		receiptRsModel.setMobile(regex);
		receiptRsModel.setModeNumber(regex);
		receiptRsModel.setName(regex);
		receiptRsModel.setPinCode(regex);
		receiptRsModel.setReceivedOn(regex);
		receiptRsModel.setReferenceNumber(regex);
		receiptRsModel.setRemarks(regex);
		receiptRsModel.setSubject(regex);
		receiptRsModel.setViewPdfUrl(regex);

		String json = ReceiptRsModelSerDes.toJSON(receiptRsModel);

		Assert.assertFalse(json.contains(regex));

		receiptRsModel = ReceiptRsModelSerDes.toDTO(json);

		Assert.assertEquals(regex, receiptRsModel.getAddress());
		Assert.assertEquals(regex, receiptRsModel.getCity());
		Assert.assertEquals(regex, receiptRsModel.getDesignation());
		Assert.assertEquals(regex, receiptRsModel.getEmail());
		Assert.assertEquals(regex, receiptRsModel.getLetterDate());
		Assert.assertEquals(regex, receiptRsModel.getMobile());
		Assert.assertEquals(regex, receiptRsModel.getModeNumber());
		Assert.assertEquals(regex, receiptRsModel.getName());
		Assert.assertEquals(regex, receiptRsModel.getPinCode());
		Assert.assertEquals(regex, receiptRsModel.getReceivedOn());
		Assert.assertEquals(regex, receiptRsModel.getReferenceNumber());
		Assert.assertEquals(regex, receiptRsModel.getRemarks());
		Assert.assertEquals(regex, receiptRsModel.getSubject());
		Assert.assertEquals(regex, receiptRsModel.getViewPdfUrl());
	}

	@Test
	public void testCreateReceipt() throws Exception {
		ReceiptRsModel randomReceiptRsModel = randomReceiptRsModel();

		ReceiptRsModel postReceiptRsModel = testCreateReceipt_addReceiptRsModel(
			randomReceiptRsModel);

		assertEquals(randomReceiptRsModel, postReceiptRsModel);
		assertValid(postReceiptRsModel);
	}

	protected ReceiptRsModel testCreateReceipt_addReceiptRsModel(
			ReceiptRsModel receiptRsModel)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetReceiptByReceiptId() throws Exception {
		ReceiptRsModel postReceiptRsModel =
			testGetReceiptByReceiptId_addReceiptRsModel();

		ReceiptRsModel getReceiptRsModel =
			receiptRsModelResource.getReceiptByReceiptId(
				postReceiptRsModel.getId());

		assertEquals(postReceiptRsModel, getReceiptRsModel);
		assertValid(getReceiptRsModel);
	}

	protected ReceiptRsModel testGetReceiptByReceiptId_addReceiptRsModel()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetReceiptByReceiptId() throws Exception {
		ReceiptRsModel receiptRsModel =
			testGraphQLGetReceiptByReceiptId_addReceiptRsModel();

		Assert.assertTrue(
			equals(
				receiptRsModel,
				ReceiptRsModelSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"receiptByReceiptId",
								new HashMap<String, Object>() {
									{
										put("id", receiptRsModel.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/receiptByReceiptId"))));
	}

	@Test
	public void testGraphQLGetReceiptByReceiptIdNotFound() throws Exception {
		Long irrelevantId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"receiptByReceiptId",
						new HashMap<String, Object>() {
							{
								put("id", irrelevantId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	protected ReceiptRsModel
			testGraphQLGetReceiptByReceiptId_addReceiptRsModel()
		throws Exception {

		return testGraphQLReceiptRsModel_addReceiptRsModel();
	}

	protected ReceiptRsModel testGraphQLReceiptRsModel_addReceiptRsModel()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		ReceiptRsModel receiptRsModel, List<ReceiptRsModel> receiptRsModels) {

		boolean contains = false;

		for (ReceiptRsModel item : receiptRsModels) {
			if (equals(receiptRsModel, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			receiptRsModels + " does not contain " + receiptRsModel, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		ReceiptRsModel receiptRsModel1, ReceiptRsModel receiptRsModel2) {

		Assert.assertTrue(
			receiptRsModel1 + " does not equal " + receiptRsModel2,
			equals(receiptRsModel1, receiptRsModel2));
	}

	protected void assertEquals(
		List<ReceiptRsModel> receiptRsModels1,
		List<ReceiptRsModel> receiptRsModels2) {

		Assert.assertEquals(receiptRsModels1.size(), receiptRsModels2.size());

		for (int i = 0; i < receiptRsModels1.size(); i++) {
			ReceiptRsModel receiptRsModel1 = receiptRsModels1.get(i);
			ReceiptRsModel receiptRsModel2 = receiptRsModels2.get(i);

			assertEquals(receiptRsModel1, receiptRsModel2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<ReceiptRsModel> receiptRsModels1,
		List<ReceiptRsModel> receiptRsModels2) {

		Assert.assertEquals(receiptRsModels1.size(), receiptRsModels2.size());

		for (ReceiptRsModel receiptRsModel1 : receiptRsModels1) {
			boolean contains = false;

			for (ReceiptRsModel receiptRsModel2 : receiptRsModels2) {
				if (equals(receiptRsModel1, receiptRsModel2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				receiptRsModels2 + " does not contain " + receiptRsModel1,
				contains);
		}
	}

	protected void assertValid(ReceiptRsModel receiptRsModel) throws Exception {
		boolean valid = true;

		if (receiptRsModel.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (receiptRsModel.getAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (receiptRsModel.getCity() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("countryId", additionalAssertFieldName)) {
				if (receiptRsModel.getCountryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("deliveryModeId", additionalAssertFieldName)) {
				if (receiptRsModel.getDeliveryModeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("designation", additionalAssertFieldName)) {
				if (receiptRsModel.getDesignation() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (receiptRsModel.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (receiptRsModel.getGroupId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("letterDate", additionalAssertFieldName)) {
				if (receiptRsModel.getLetterDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mobile", additionalAssertFieldName)) {
				if (receiptRsModel.getMobile() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("modeNumber", additionalAssertFieldName)) {
				if (receiptRsModel.getModeNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (receiptRsModel.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("organizationId", additionalAssertFieldName)) {
				if (receiptRsModel.getOrganizationId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("pinCode", additionalAssertFieldName)) {
				if (receiptRsModel.getPinCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"receiptCategoryId", additionalAssertFieldName)) {

				if (receiptRsModel.getReceiptCategoryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"receiptSubCategoryId", additionalAssertFieldName)) {

				if (receiptRsModel.getReceiptSubCategoryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("receivedOn", additionalAssertFieldName)) {
				if (receiptRsModel.getReceivedOn() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("referenceNumber", additionalAssertFieldName)) {
				if (receiptRsModel.getReferenceNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("remarks", additionalAssertFieldName)) {
				if (receiptRsModel.getRemarks() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("stateId", additionalAssertFieldName)) {
				if (receiptRsModel.getStateId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"subOrganizationId", additionalAssertFieldName)) {

				if (receiptRsModel.getSubOrganizationId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("subject", additionalAssertFieldName)) {
				if (receiptRsModel.getSubject() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tempFileId", additionalAssertFieldName)) {
				if (receiptRsModel.getTempFileId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("typeId", additionalAssertFieldName)) {
				if (receiptRsModel.getTypeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userPostId", additionalAssertFieldName)) {
				if (receiptRsModel.getUserPostId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("viewPdfUrl", additionalAssertFieldName)) {
				if (receiptRsModel.getViewPdfUrl() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<ReceiptRsModel> page) {
		boolean valid = false;

		java.util.Collection<ReceiptRsModel> receiptRsModels = page.getItems();

		int size = receiptRsModels.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					jet.process.rs.dto.v1_0.ReceiptRsModel.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		ReceiptRsModel receiptRsModel1, ReceiptRsModel receiptRsModel2) {

		if (receiptRsModel1 == receiptRsModel2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getAddress(),
						receiptRsModel2.getAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getCity(), receiptRsModel2.getCity())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("countryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getCountryId(),
						receiptRsModel2.getCountryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("deliveryModeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getDeliveryModeId(),
						receiptRsModel2.getDeliveryModeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("designation", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getDesignation(),
						receiptRsModel2.getDesignation())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getEmail(),
						receiptRsModel2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getGroupId(),
						receiptRsModel2.getGroupId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getId(), receiptRsModel2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("letterDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getLetterDate(),
						receiptRsModel2.getLetterDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mobile", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getMobile(),
						receiptRsModel2.getMobile())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("modeNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getModeNumber(),
						receiptRsModel2.getModeNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getName(), receiptRsModel2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("organizationId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getOrganizationId(),
						receiptRsModel2.getOrganizationId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("pinCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getPinCode(),
						receiptRsModel2.getPinCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"receiptCategoryId", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						receiptRsModel1.getReceiptCategoryId(),
						receiptRsModel2.getReceiptCategoryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"receiptSubCategoryId", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						receiptRsModel1.getReceiptSubCategoryId(),
						receiptRsModel2.getReceiptSubCategoryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("receivedOn", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getReceivedOn(),
						receiptRsModel2.getReceivedOn())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("referenceNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getReferenceNumber(),
						receiptRsModel2.getReferenceNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("remarks", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getRemarks(),
						receiptRsModel2.getRemarks())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("stateId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getStateId(),
						receiptRsModel2.getStateId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"subOrganizationId", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						receiptRsModel1.getSubOrganizationId(),
						receiptRsModel2.getSubOrganizationId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("subject", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getSubject(),
						receiptRsModel2.getSubject())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tempFileId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getTempFileId(),
						receiptRsModel2.getTempFileId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("typeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getTypeId(),
						receiptRsModel2.getTypeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userPostId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getUserPostId(),
						receiptRsModel2.getUserPostId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("viewPdfUrl", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						receiptRsModel1.getViewPdfUrl(),
						receiptRsModel2.getViewPdfUrl())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_receiptRsModelResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_receiptRsModelResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		ReceiptRsModel receiptRsModel) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("address")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("city")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getCity()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("countryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("deliveryModeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("designation")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getDesignation()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("groupId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("letterDate")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getLetterDate()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("mobile")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getMobile()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("modeNumber")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getModeNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("organizationId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("pinCode")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getPinCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("receiptCategoryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("receiptSubCategoryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("receivedOn")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getReceivedOn()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("referenceNumber")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getReferenceNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("remarks")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getRemarks()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("stateId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("subOrganizationId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("subject")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getSubject()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("tempFileId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("typeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("userPostId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("viewPdfUrl")) {
			sb.append("'");
			sb.append(String.valueOf(receiptRsModel.getViewPdfUrl()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected ReceiptRsModel randomReceiptRsModel() throws Exception {
		return new ReceiptRsModel() {
			{
				address = StringUtil.toLowerCase(RandomTestUtil.randomString());
				city = StringUtil.toLowerCase(RandomTestUtil.randomString());
				countryId = RandomTestUtil.randomLong();
				deliveryModeId = RandomTestUtil.randomLong();
				designation = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				groupId = RandomTestUtil.randomLong();
				id = RandomTestUtil.randomLong();
				letterDate = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				mobile = StringUtil.toLowerCase(RandomTestUtil.randomString());
				modeNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				organizationId = RandomTestUtil.randomLong();
				pinCode = StringUtil.toLowerCase(RandomTestUtil.randomString());
				receiptCategoryId = RandomTestUtil.randomLong();
				receiptSubCategoryId = RandomTestUtil.randomLong();
				receivedOn = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				referenceNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				remarks = StringUtil.toLowerCase(RandomTestUtil.randomString());
				stateId = RandomTestUtil.randomLong();
				subOrganizationId = RandomTestUtil.randomLong();
				subject = StringUtil.toLowerCase(RandomTestUtil.randomString());
				tempFileId = RandomTestUtil.randomLong();
				typeId = RandomTestUtil.randomLong();
				userPostId = RandomTestUtil.randomLong();
				viewPdfUrl = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected ReceiptRsModel randomIrrelevantReceiptRsModel() throws Exception {
		ReceiptRsModel randomIrrelevantReceiptRsModel = randomReceiptRsModel();

		return randomIrrelevantReceiptRsModel;
	}

	protected ReceiptRsModel randomPatchReceiptRsModel() throws Exception {
		return randomReceiptRsModel();
	}

	protected ReceiptRsModelResource receiptRsModelResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseReceiptRsModelResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private jet.process.rs.resource.v1_0.ReceiptRsModelResource
		_receiptRsModelResource;

}