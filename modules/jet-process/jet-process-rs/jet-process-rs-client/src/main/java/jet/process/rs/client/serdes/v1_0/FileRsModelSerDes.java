package jet.process.rs.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import jet.process.rs.client.dto.v1_0.FileRsModel;
import jet.process.rs.client.json.BaseJSONParser;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class FileRsModelSerDes {

	public static FileRsModel toDTO(String json) {
		FileRsModelJSONParser fileRsModelJSONParser =
			new FileRsModelJSONParser();

		return fileRsModelJSONParser.parseToDTO(json);
	}

	public static FileRsModel[] toDTOs(String json) {
		FileRsModelJSONParser fileRsModelJSONParser =
			new FileRsModelJSONParser();

		return fileRsModelJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FileRsModel fileRsModel) {
		if (fileRsModel == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (fileRsModel.getBasicHeadId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"basicHeadId\": ");

			sb.append(fileRsModel.getBasicHeadId());
		}

		if (fileRsModel.getFileCodeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileCodeId\": ");

			sb.append(fileRsModel.getFileCodeId());
		}

		if (fileRsModel.getFileNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileNumber\": ");

			sb.append("\"");

			sb.append(_escape(fileRsModel.getFileNumber()));

			sb.append("\"");
		}

		if (fileRsModel.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(fileRsModel.getGroupId());
		}

		if (fileRsModel.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(fileRsModel.getId());
		}

		if (fileRsModel.getNature() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nature\": ");

			sb.append("\"");

			sb.append(_escape(fileRsModel.getNature()));

			sb.append("\"");
		}

		if (fileRsModel.getPrimaryHeadId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"primaryHeadId\": ");

			sb.append(fileRsModel.getPrimaryHeadId());
		}

		if (fileRsModel.getSecondaryHeadId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"secondaryHeadId\": ");

			sb.append(fileRsModel.getSecondaryHeadId());
		}

		if (fileRsModel.getSubject() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subject\": ");

			sb.append("\"");

			sb.append(_escape(fileRsModel.getSubject()));

			sb.append("\"");
		}

		if (fileRsModel.getTertiaryHeadId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tertiaryHeadId\": ");

			sb.append(fileRsModel.getTertiaryHeadId());
		}

		if (fileRsModel.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(fileRsModel.getType()));

			sb.append("\"");
		}

		if (fileRsModel.getYear() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"year\": ");

			sb.append(fileRsModel.getYear());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FileRsModelJSONParser fileRsModelJSONParser =
			new FileRsModelJSONParser();

		return fileRsModelJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FileRsModel fileRsModel) {
		if (fileRsModel == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (fileRsModel.getBasicHeadId() == null) {
			map.put("basicHeadId", null);
		}
		else {
			map.put(
				"basicHeadId", String.valueOf(fileRsModel.getBasicHeadId()));
		}

		if (fileRsModel.getFileCodeId() == null) {
			map.put("fileCodeId", null);
		}
		else {
			map.put("fileCodeId", String.valueOf(fileRsModel.getFileCodeId()));
		}

		if (fileRsModel.getFileNumber() == null) {
			map.put("fileNumber", null);
		}
		else {
			map.put("fileNumber", String.valueOf(fileRsModel.getFileNumber()));
		}

		if (fileRsModel.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(fileRsModel.getGroupId()));
		}

		if (fileRsModel.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(fileRsModel.getId()));
		}

		if (fileRsModel.getNature() == null) {
			map.put("nature", null);
		}
		else {
			map.put("nature", String.valueOf(fileRsModel.getNature()));
		}

		if (fileRsModel.getPrimaryHeadId() == null) {
			map.put("primaryHeadId", null);
		}
		else {
			map.put(
				"primaryHeadId",
				String.valueOf(fileRsModel.getPrimaryHeadId()));
		}

		if (fileRsModel.getSecondaryHeadId() == null) {
			map.put("secondaryHeadId", null);
		}
		else {
			map.put(
				"secondaryHeadId",
				String.valueOf(fileRsModel.getSecondaryHeadId()));
		}

		if (fileRsModel.getSubject() == null) {
			map.put("subject", null);
		}
		else {
			map.put("subject", String.valueOf(fileRsModel.getSubject()));
		}

		if (fileRsModel.getTertiaryHeadId() == null) {
			map.put("tertiaryHeadId", null);
		}
		else {
			map.put(
				"tertiaryHeadId",
				String.valueOf(fileRsModel.getTertiaryHeadId()));
		}

		if (fileRsModel.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(fileRsModel.getType()));
		}

		if (fileRsModel.getYear() == null) {
			map.put("year", null);
		}
		else {
			map.put("year", String.valueOf(fileRsModel.getYear()));
		}

		return map;
	}

	public static class FileRsModelJSONParser
		extends BaseJSONParser<FileRsModel> {

		@Override
		protected FileRsModel createDTO() {
			return new FileRsModel();
		}

		@Override
		protected FileRsModel[] createDTOArray(int size) {
			return new FileRsModel[size];
		}

		@Override
		protected void setField(
			FileRsModel fileRsModel, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "basicHeadId")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setBasicHeadId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileCodeId")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setFileCodeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileNumber")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setFileNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setGroupId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nature")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setNature((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "primaryHeadId")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setPrimaryHeadId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "secondaryHeadId")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setSecondaryHeadId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "subject")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setSubject((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tertiaryHeadId")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setTertiaryHeadId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "year")) {
				if (jsonParserFieldValue != null) {
					fileRsModel.setYear(
						Long.valueOf((String)jsonParserFieldValue));
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