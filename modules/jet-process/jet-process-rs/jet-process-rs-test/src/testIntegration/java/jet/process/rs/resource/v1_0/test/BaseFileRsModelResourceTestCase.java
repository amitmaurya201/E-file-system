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

import jet.process.rs.client.dto.v1_0.FileRsModel;
import jet.process.rs.client.http.HttpInvoker;
import jet.process.rs.client.pagination.Page;
import jet.process.rs.client.resource.v1_0.FileRsModelResource;
import jet.process.rs.client.serdes.v1_0.FileRsModelSerDes;

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
public abstract class BaseFileRsModelResourceTestCase {

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

		_fileRsModelResource.setContextCompany(testCompany);

		FileRsModelResource.Builder builder = FileRsModelResource.builder();

		fileRsModelResource = builder.authentication(
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

		FileRsModel fileRsModel1 = randomFileRsModel();

		String json = objectMapper.writeValueAsString(fileRsModel1);

		FileRsModel fileRsModel2 = FileRsModelSerDes.toDTO(json);

		Assert.assertTrue(equals(fileRsModel1, fileRsModel2));
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

		FileRsModel fileRsModel = randomFileRsModel();

		String json1 = objectMapper.writeValueAsString(fileRsModel);
		String json2 = FileRsModelSerDes.toJSON(fileRsModel);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		FileRsModel fileRsModel = randomFileRsModel();

		fileRsModel.setFileNumber(regex);
		fileRsModel.setNature(regex);
		fileRsModel.setReference(regex);
		fileRsModel.setRemarks(regex);
		fileRsModel.setSubject(regex);
		fileRsModel.setType(regex);

		String json = FileRsModelSerDes.toJSON(fileRsModel);

		Assert.assertFalse(json.contains(regex));

		fileRsModel = FileRsModelSerDes.toDTO(json);

		Assert.assertEquals(regex, fileRsModel.getFileNumber());
		Assert.assertEquals(regex, fileRsModel.getNature());
		Assert.assertEquals(regex, fileRsModel.getReference());
		Assert.assertEquals(regex, fileRsModel.getRemarks());
		Assert.assertEquals(regex, fileRsModel.getSubject());
		Assert.assertEquals(regex, fileRsModel.getType());
	}

	@Test
	public void testCreateFile() throws Exception {
		FileRsModel randomFileRsModel = randomFileRsModel();

		FileRsModel postFileRsModel = testCreateFile_addFileRsModel(
			randomFileRsModel);

		assertEquals(randomFileRsModel, postFileRsModel);
		assertValid(postFileRsModel);
	}

	protected FileRsModel testCreateFile_addFileRsModel(FileRsModel fileRsModel)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected FileRsModel testGraphQLFileRsModel_addFileRsModel()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		FileRsModel fileRsModel, List<FileRsModel> fileRsModels) {

		boolean contains = false;

		for (FileRsModel item : fileRsModels) {
			if (equals(fileRsModel, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			fileRsModels + " does not contain " + fileRsModel, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		FileRsModel fileRsModel1, FileRsModel fileRsModel2) {

		Assert.assertTrue(
			fileRsModel1 + " does not equal " + fileRsModel2,
			equals(fileRsModel1, fileRsModel2));
	}

	protected void assertEquals(
		List<FileRsModel> fileRsModels1, List<FileRsModel> fileRsModels2) {

		Assert.assertEquals(fileRsModels1.size(), fileRsModels2.size());

		for (int i = 0; i < fileRsModels1.size(); i++) {
			FileRsModel fileRsModel1 = fileRsModels1.get(i);
			FileRsModel fileRsModel2 = fileRsModels2.get(i);

			assertEquals(fileRsModel1, fileRsModel2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<FileRsModel> fileRsModels1, List<FileRsModel> fileRsModels2) {

		Assert.assertEquals(fileRsModels1.size(), fileRsModels2.size());

		for (FileRsModel fileRsModel1 : fileRsModels1) {
			boolean contains = false;

			for (FileRsModel fileRsModel2 : fileRsModels2) {
				if (equals(fileRsModel1, fileRsModel2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				fileRsModels2 + " does not contain " + fileRsModel1, contains);
		}
	}

	protected void assertValid(FileRsModel fileRsModel) throws Exception {
		boolean valid = true;

		if (fileRsModel.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("basicHeadId", additionalAssertFieldName)) {
				if (fileRsModel.getBasicHeadId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("categoryId", additionalAssertFieldName)) {
				if (fileRsModel.getCategoryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileCodeId", additionalAssertFieldName)) {
				if (fileRsModel.getFileCodeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileNumber", additionalAssertFieldName)) {
				if (fileRsModel.getFileNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (fileRsModel.getGroupId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nature", additionalAssertFieldName)) {
				if (fileRsModel.getNature() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("primaryHeadId", additionalAssertFieldName)) {
				if (fileRsModel.getPrimaryHeadId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("reference", additionalAssertFieldName)) {
				if (fileRsModel.getReference() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("remarks", additionalAssertFieldName)) {
				if (fileRsModel.getRemarks() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("secondaryHeadId", additionalAssertFieldName)) {
				if (fileRsModel.getSecondaryHeadId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("subCategoryId", additionalAssertFieldName)) {
				if (fileRsModel.getSubCategoryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("subject", additionalAssertFieldName)) {
				if (fileRsModel.getSubject() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tertiaryHeadId", additionalAssertFieldName)) {
				if (fileRsModel.getTertiaryHeadId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (fileRsModel.getType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userPostId", additionalAssertFieldName)) {
				if (fileRsModel.getUserPostId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("year", additionalAssertFieldName)) {
				if (fileRsModel.getYear() == null) {
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

	protected void assertValid(Page<FileRsModel> page) {
		boolean valid = false;

		java.util.Collection<FileRsModel> fileRsModels = page.getItems();

		int size = fileRsModels.size();

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
				getDeclaredFields(jet.process.rs.dto.v1_0.FileRsModel.class)) {

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
		FileRsModel fileRsModel1, FileRsModel fileRsModel2) {

		if (fileRsModel1 == fileRsModel2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("basicHeadId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getBasicHeadId(),
						fileRsModel2.getBasicHeadId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("categoryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getCategoryId(),
						fileRsModel2.getCategoryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileCodeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getFileCodeId(),
						fileRsModel2.getFileCodeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getFileNumber(),
						fileRsModel2.getFileNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getGroupId(), fileRsModel2.getGroupId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getId(), fileRsModel2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nature", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getNature(), fileRsModel2.getNature())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("primaryHeadId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getPrimaryHeadId(),
						fileRsModel2.getPrimaryHeadId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("reference", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getReference(),
						fileRsModel2.getReference())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("remarks", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getRemarks(), fileRsModel2.getRemarks())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("secondaryHeadId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getSecondaryHeadId(),
						fileRsModel2.getSecondaryHeadId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("subCategoryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getSubCategoryId(),
						fileRsModel2.getSubCategoryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("subject", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getSubject(), fileRsModel2.getSubject())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tertiaryHeadId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getTertiaryHeadId(),
						fileRsModel2.getTertiaryHeadId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getType(), fileRsModel2.getType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userPostId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getUserPostId(),
						fileRsModel2.getUserPostId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("year", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						fileRsModel1.getYear(), fileRsModel2.getYear())) {

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

		if (!(_fileRsModelResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_fileRsModelResource;

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
		EntityField entityField, String operator, FileRsModel fileRsModel) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("basicHeadId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("categoryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileCodeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileNumber")) {
			sb.append("'");
			sb.append(String.valueOf(fileRsModel.getFileNumber()));
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

		if (entityFieldName.equals("nature")) {
			sb.append("'");
			sb.append(String.valueOf(fileRsModel.getNature()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("primaryHeadId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("reference")) {
			sb.append("'");
			sb.append(String.valueOf(fileRsModel.getReference()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("remarks")) {
			sb.append("'");
			sb.append(String.valueOf(fileRsModel.getRemarks()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("secondaryHeadId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("subCategoryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("subject")) {
			sb.append("'");
			sb.append(String.valueOf(fileRsModel.getSubject()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("tertiaryHeadId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("type")) {
			sb.append("'");
			sb.append(String.valueOf(fileRsModel.getType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("userPostId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("year")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

	protected FileRsModel randomFileRsModel() throws Exception {
		return new FileRsModel() {
			{
				basicHeadId = RandomTestUtil.randomLong();
				categoryId = RandomTestUtil.randomLong();
				fileCodeId = RandomTestUtil.randomLong();
				fileNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				groupId = RandomTestUtil.randomLong();
				id = RandomTestUtil.randomLong();
				nature = StringUtil.toLowerCase(RandomTestUtil.randomString());
				primaryHeadId = RandomTestUtil.randomLong();
				reference = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				remarks = StringUtil.toLowerCase(RandomTestUtil.randomString());
				secondaryHeadId = RandomTestUtil.randomLong();
				subCategoryId = RandomTestUtil.randomLong();
				subject = StringUtil.toLowerCase(RandomTestUtil.randomString());
				tertiaryHeadId = RandomTestUtil.randomLong();
				type = StringUtil.toLowerCase(RandomTestUtil.randomString());
				userPostId = RandomTestUtil.randomLong();
				year = RandomTestUtil.randomLong();
			}
		};
	}

	protected FileRsModel randomIrrelevantFileRsModel() throws Exception {
		FileRsModel randomIrrelevantFileRsModel = randomFileRsModel();

		return randomIrrelevantFileRsModel;
	}

	protected FileRsModel randomPatchFileRsModel() throws Exception {
		return randomFileRsModel();
	}

	protected FileRsModelResource fileRsModelResource;
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
		LogFactoryUtil.getLog(BaseFileRsModelResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private jet.process.rs.resource.v1_0.FileRsModelResource
		_fileRsModelResource;

}