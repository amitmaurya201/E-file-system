package io.jetprocess.docs.resource.v1_0.test;

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

import io.jetprocess.docs.client.dto.v1_0.DOCStore;
import io.jetprocess.docs.client.http.HttpInvoker;
import io.jetprocess.docs.client.pagination.Page;
import io.jetprocess.docs.client.resource.v1_0.DOCStoreResource;
import io.jetprocess.docs.client.serdes.v1_0.DOCStoreSerDes;

import java.io.File;

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
public abstract class BaseDOCStoreResourceTestCase {

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

		_docStoreResource.setContextCompany(testCompany);

		DOCStoreResource.Builder builder = DOCStoreResource.builder();

		docStoreResource = builder.authentication(
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

		DOCStore docStore1 = randomDOCStore();

		String json = objectMapper.writeValueAsString(docStore1);

		DOCStore docStore2 = DOCStoreSerDes.toDTO(json);

		Assert.assertTrue(equals(docStore1, docStore2));
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

		DOCStore docStore = randomDOCStore();

		String json1 = objectMapper.writeValueAsString(docStore);
		String json2 = DOCStoreSerDes.toJSON(docStore);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		DOCStore docStore = randomDOCStore();

		docStore.setDescription(regex);
		docStore.setDocumentStream(regex);
		docStore.setFileName(regex);
		docStore.setFolderName(regex);
		docStore.setGroupId(regex);

		String json = DOCStoreSerDes.toJSON(docStore);

		Assert.assertFalse(json.contains(regex));

		docStore = DOCStoreSerDes.toDTO(json);

		Assert.assertEquals(regex, docStore.getDescription());
		Assert.assertEquals(regex, docStore.getDocumentStream());
		Assert.assertEquals(regex, docStore.getFileName());
		Assert.assertEquals(regex, docStore.getFolderName());
		Assert.assertEquals(regex, docStore.getGroupId());
	}

	@Test
	public void testTempFileUpload() throws Exception {
		DOCStore randomDOCStore = randomDOCStore();

		Map<String, File> multipartFiles = getMultipartFiles();

		DOCStore postDOCStore = testTempFileUpload_addDOCStore(
			randomDOCStore, multipartFiles);

		assertEquals(randomDOCStore, postDOCStore);
		assertValid(postDOCStore);

		assertValid(postDOCStore, multipartFiles);
	}

	protected DOCStore testTempFileUpload_addDOCStore(
			DOCStore docStore, Map<String, File> multipartFiles)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUploadFile() throws Exception {
		DOCStore randomDOCStore = randomDOCStore();

		Map<String, File> multipartFiles = getMultipartFiles();

		DOCStore postDOCStore = testUploadFile_addDOCStore(
			randomDOCStore, multipartFiles);

		assertEquals(randomDOCStore, postDOCStore);
		assertValid(postDOCStore);

		assertValid(postDOCStore, multipartFiles);
	}

	protected DOCStore testUploadFile_addDOCStore(
			DOCStore docStore, Map<String, File> multipartFiles)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testFetchFiles() throws Exception {
		DOCStore randomDOCStore = randomDOCStore();

		Map<String, File> multipartFiles = getMultipartFiles();

		DOCStore postDOCStore = testFetchFiles_addDOCStore(
			randomDOCStore, multipartFiles);

		assertEquals(randomDOCStore, postDOCStore);
		assertValid(postDOCStore);

		assertValid(postDOCStore, multipartFiles);
	}

	protected DOCStore testFetchFiles_addDOCStore(
			DOCStore docStore, Map<String, File> multipartFiles)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected DOCStore testGraphQLDOCStore_addDOCStore() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(DOCStore docStore, List<DOCStore> docStores) {
		boolean contains = false;

		for (DOCStore item : docStores) {
			if (equals(docStore, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			docStores + " does not contain " + docStore, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(DOCStore docStore1, DOCStore docStore2) {
		Assert.assertTrue(
			docStore1 + " does not equal " + docStore2,
			equals(docStore1, docStore2));
	}

	protected void assertEquals(
		List<DOCStore> docStores1, List<DOCStore> docStores2) {

		Assert.assertEquals(docStores1.size(), docStores2.size());

		for (int i = 0; i < docStores1.size(); i++) {
			DOCStore docStore1 = docStores1.get(i);
			DOCStore docStore2 = docStores2.get(i);

			assertEquals(docStore1, docStore2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<DOCStore> docStores1, List<DOCStore> docStores2) {

		Assert.assertEquals(docStores1.size(), docStores2.size());

		for (DOCStore docStore1 : docStores1) {
			boolean contains = false;

			for (DOCStore docStore2 : docStores2) {
				if (equals(docStore1, docStore2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				docStores2 + " does not contain " + docStore1, contains);
		}
	}

	protected void assertValid(DOCStore docStore) throws Exception {
		boolean valid = true;

		if (docStore.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (docStore.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("documentStream", additionalAssertFieldName)) {
				if (docStore.getDocumentStream() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileId", additionalAssertFieldName)) {
				if (docStore.getFileId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (docStore.getFileName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("folderName", additionalAssertFieldName)) {
				if (docStore.getFolderName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (docStore.getGroupId() == null) {
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

	protected void assertValid(
			DOCStore docStore, Map<String, File> multipartFiles)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertValid(Page<DOCStore> page) {
		boolean valid = false;

		java.util.Collection<DOCStore> docStores = page.getItems();

		int size = docStores.size();

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
				getDeclaredFields(io.jetprocess.docs.dto.v1_0.DOCStore.class)) {

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

	protected boolean equals(DOCStore docStore1, DOCStore docStore2) {
		if (docStore1 == docStore2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						docStore1.getDescription(),
						docStore2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("documentStream", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						docStore1.getDocumentStream(),
						docStore2.getDocumentStream())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						docStore1.getFileId(), docStore2.getFileId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						docStore1.getFileName(), docStore2.getFileName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("folderName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						docStore1.getFolderName(), docStore2.getFolderName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						docStore1.getGroupId(), docStore2.getGroupId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(docStore1.getId(), docStore2.getId())) {
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

		if (!(_docStoreResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_docStoreResource;

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
		EntityField entityField, String operator, DOCStore docStore) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(docStore.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("documentStream")) {
			sb.append("'");
			sb.append(String.valueOf(docStore.getDocumentStream()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fileId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileName")) {
			sb.append("'");
			sb.append(String.valueOf(docStore.getFileName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("folderName")) {
			sb.append("'");
			sb.append(String.valueOf(docStore.getFolderName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("groupId")) {
			sb.append("'");
			sb.append(String.valueOf(docStore.getGroupId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Map<String, File> getMultipartFiles() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
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

	protected DOCStore randomDOCStore() throws Exception {
		return new DOCStore() {
			{
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				documentStream = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fileName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				folderName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				groupId = StringUtil.toLowerCase(RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
			}
		};
	}

	protected DOCStore randomIrrelevantDOCStore() throws Exception {
		DOCStore randomIrrelevantDOCStore = randomDOCStore();

		return randomIrrelevantDOCStore;
	}

	protected DOCStore randomPatchDOCStore() throws Exception {
		return randomDOCStore();
	}

	protected DOCStoreResource docStoreResource;
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
		LogFactoryUtil.getLog(BaseDOCStoreResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private io.jetprocess.docs.resource.v1_0.DOCStoreResource _docStoreResource;

}