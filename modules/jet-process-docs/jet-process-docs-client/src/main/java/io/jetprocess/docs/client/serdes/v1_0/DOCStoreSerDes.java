package io.jetprocess.docs.client.serdes.v1_0;

import io.jetprocess.docs.client.dto.v1_0.DOCStore;
import io.jetprocess.docs.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class DOCStoreSerDes {

	public static DOCStore toDTO(String json) {
		DOCStoreJSONParser docStoreJSONParser = new DOCStoreJSONParser();

		return docStoreJSONParser.parseToDTO(json);
	}

	public static DOCStore[] toDTOs(String json) {
		DOCStoreJSONParser docStoreJSONParser = new DOCStoreJSONParser();

		return docStoreJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DOCStore docStore) {
		if (docStore == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (docStore.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(docStore.getDescription()));

			sb.append("\"");
		}

		if (docStore.getDocumentStream() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentStream\": ");

			sb.append("\"");

			sb.append(_escape(docStore.getDocumentStream()));

			sb.append("\"");
		}

		if (docStore.getFileId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileId\": ");

			sb.append(docStore.getFileId());
		}

		if (docStore.getFileName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(docStore.getFileName()));

			sb.append("\"");
		}

		if (docStore.getFolderName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"folderName\": ");

			sb.append("\"");

			sb.append(_escape(docStore.getFolderName()));

			sb.append("\"");
		}

		if (docStore.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append("\"");

			sb.append(_escape(docStore.getGroupId()));

			sb.append("\"");
		}

		if (docStore.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(docStore.getId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DOCStoreJSONParser docStoreJSONParser = new DOCStoreJSONParser();

		return docStoreJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DOCStore docStore) {
		if (docStore == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (docStore.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(docStore.getDescription()));
		}

		if (docStore.getDocumentStream() == null) {
			map.put("documentStream", null);
		}
		else {
			map.put(
				"documentStream", String.valueOf(docStore.getDocumentStream()));
		}

		if (docStore.getFileId() == null) {
			map.put("fileId", null);
		}
		else {
			map.put("fileId", String.valueOf(docStore.getFileId()));
		}

		if (docStore.getFileName() == null) {
			map.put("fileName", null);
		}
		else {
			map.put("fileName", String.valueOf(docStore.getFileName()));
		}

		if (docStore.getFolderName() == null) {
			map.put("folderName", null);
		}
		else {
			map.put("folderName", String.valueOf(docStore.getFolderName()));
		}

		if (docStore.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(docStore.getGroupId()));
		}

		if (docStore.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(docStore.getId()));
		}

		return map;
	}

	public static class DOCStoreJSONParser extends BaseJSONParser<DOCStore> {

		@Override
		protected DOCStore createDTO() {
			return new DOCStore();
		}

		@Override
		protected DOCStore[] createDTOArray(int size) {
			return new DOCStore[size];
		}

		@Override
		protected void setField(
			DOCStore docStore, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					docStore.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "documentStream")) {
				if (jsonParserFieldValue != null) {
					docStore.setDocumentStream((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileId")) {
				if (jsonParserFieldValue != null) {
					docStore.setFileId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileName")) {
				if (jsonParserFieldValue != null) {
					docStore.setFileName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "folderName")) {
				if (jsonParserFieldValue != null) {
					docStore.setFolderName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					docStore.setGroupId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					docStore.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}