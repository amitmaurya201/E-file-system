package jet.process.rs.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import jet.process.rs.client.dto.v1_0.ReceiptRsModel;
import jet.process.rs.client.json.BaseJSONParser;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class ReceiptRsModelSerDes {

	public static ReceiptRsModel toDTO(String json) {
		ReceiptRsModelJSONParser receiptRsModelJSONParser =
			new ReceiptRsModelJSONParser();

		return receiptRsModelJSONParser.parseToDTO(json);
	}

	public static ReceiptRsModel[] toDTOs(String json) {
		ReceiptRsModelJSONParser receiptRsModelJSONParser =
			new ReceiptRsModelJSONParser();

		return receiptRsModelJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ReceiptRsModel receiptRsModel) {
		if (receiptRsModel == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (receiptRsModel.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getAddress()));

			sb.append("\"");
		}

		if (receiptRsModel.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getCity()));

			sb.append("\"");
		}

		if (receiptRsModel.getCountryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"countryId\": ");

			sb.append(receiptRsModel.getCountryId());
		}

		if (receiptRsModel.getDeliveryModeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"deliveryModeId\": ");

			sb.append(receiptRsModel.getDeliveryModeId());
		}

		if (receiptRsModel.getDesignation() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"designation\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getDesignation()));

			sb.append("\"");
		}

		if (receiptRsModel.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getEmail()));

			sb.append("\"");
		}

		if (receiptRsModel.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(receiptRsModel.getGroupId());
		}

		if (receiptRsModel.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(receiptRsModel.getId());
		}

		if (receiptRsModel.getLetterDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"letterDate\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getLetterDate()));

			sb.append("\"");
		}

		if (receiptRsModel.getMobile() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mobile\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getMobile()));

			sb.append("\"");
		}

		if (receiptRsModel.getModeNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modeNumber\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getModeNumber()));

			sb.append("\"");
		}

		if (receiptRsModel.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getName()));

			sb.append("\"");
		}

		if (receiptRsModel.getOrganizationId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"organizationId\": ");

			sb.append(receiptRsModel.getOrganizationId());
		}

		if (receiptRsModel.getPinCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pinCode\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getPinCode()));

			sb.append("\"");
		}

		if (receiptRsModel.getReceiptCategoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiptCategoryId\": ");

			sb.append(receiptRsModel.getReceiptCategoryId());
		}

		if (receiptRsModel.getReceiptSubCategoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiptSubCategoryId\": ");

			sb.append(receiptRsModel.getReceiptSubCategoryId());
		}

		if (receiptRsModel.getReceivedOn() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receivedOn\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getReceivedOn()));

			sb.append("\"");
		}

		if (receiptRsModel.getReferenceNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"referenceNumber\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getReferenceNumber()));

			sb.append("\"");
		}

		if (receiptRsModel.getRemarks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"remarks\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getRemarks()));

			sb.append("\"");
		}

		if (receiptRsModel.getStateId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stateId\": ");

			sb.append(receiptRsModel.getStateId());
		}

		if (receiptRsModel.getSubOrganizationId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subOrganizationId\": ");

			sb.append(receiptRsModel.getSubOrganizationId());
		}

		if (receiptRsModel.getSubject() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subject\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getSubject()));

			sb.append("\"");
		}

		if (receiptRsModel.getTempFileId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tempFileId\": ");

			sb.append(receiptRsModel.getTempFileId());
		}

		if (receiptRsModel.getTypeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeId\": ");

			sb.append(receiptRsModel.getTypeId());
		}

		if (receiptRsModel.getUserPostId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userPostId\": ");

			sb.append(receiptRsModel.getUserPostId());
		}

		if (receiptRsModel.getViewPdfUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"viewPdfUrl\": ");

			sb.append("\"");

			sb.append(_escape(receiptRsModel.getViewPdfUrl()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ReceiptRsModelJSONParser receiptRsModelJSONParser =
			new ReceiptRsModelJSONParser();

		return receiptRsModelJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ReceiptRsModel receiptRsModel) {
		if (receiptRsModel == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (receiptRsModel.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(receiptRsModel.getAddress()));
		}

		if (receiptRsModel.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(receiptRsModel.getCity()));
		}

		if (receiptRsModel.getCountryId() == null) {
			map.put("countryId", null);
		}
		else {
			map.put("countryId", String.valueOf(receiptRsModel.getCountryId()));
		}

		if (receiptRsModel.getDeliveryModeId() == null) {
			map.put("deliveryModeId", null);
		}
		else {
			map.put(
				"deliveryModeId",
				String.valueOf(receiptRsModel.getDeliveryModeId()));
		}

		if (receiptRsModel.getDesignation() == null) {
			map.put("designation", null);
		}
		else {
			map.put(
				"designation", String.valueOf(receiptRsModel.getDesignation()));
		}

		if (receiptRsModel.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(receiptRsModel.getEmail()));
		}

		if (receiptRsModel.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(receiptRsModel.getGroupId()));
		}

		if (receiptRsModel.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(receiptRsModel.getId()));
		}

		if (receiptRsModel.getLetterDate() == null) {
			map.put("letterDate", null);
		}
		else {
			map.put(
				"letterDate", String.valueOf(receiptRsModel.getLetterDate()));
		}

		if (receiptRsModel.getMobile() == null) {
			map.put("mobile", null);
		}
		else {
			map.put("mobile", String.valueOf(receiptRsModel.getMobile()));
		}

		if (receiptRsModel.getModeNumber() == null) {
			map.put("modeNumber", null);
		}
		else {
			map.put(
				"modeNumber", String.valueOf(receiptRsModel.getModeNumber()));
		}

		if (receiptRsModel.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(receiptRsModel.getName()));
		}

		if (receiptRsModel.getOrganizationId() == null) {
			map.put("organizationId", null);
		}
		else {
			map.put(
				"organizationId",
				String.valueOf(receiptRsModel.getOrganizationId()));
		}

		if (receiptRsModel.getPinCode() == null) {
			map.put("pinCode", null);
		}
		else {
			map.put("pinCode", String.valueOf(receiptRsModel.getPinCode()));
		}

		if (receiptRsModel.getReceiptCategoryId() == null) {
			map.put("receiptCategoryId", null);
		}
		else {
			map.put(
				"receiptCategoryId",
				String.valueOf(receiptRsModel.getReceiptCategoryId()));
		}

		if (receiptRsModel.getReceiptSubCategoryId() == null) {
			map.put("receiptSubCategoryId", null);
		}
		else {
			map.put(
				"receiptSubCategoryId",
				String.valueOf(receiptRsModel.getReceiptSubCategoryId()));
		}

		if (receiptRsModel.getReceivedOn() == null) {
			map.put("receivedOn", null);
		}
		else {
			map.put(
				"receivedOn", String.valueOf(receiptRsModel.getReceivedOn()));
		}

		if (receiptRsModel.getReferenceNumber() == null) {
			map.put("referenceNumber", null);
		}
		else {
			map.put(
				"referenceNumber",
				String.valueOf(receiptRsModel.getReferenceNumber()));
		}

		if (receiptRsModel.getRemarks() == null) {
			map.put("remarks", null);
		}
		else {
			map.put("remarks", String.valueOf(receiptRsModel.getRemarks()));
		}

		if (receiptRsModel.getStateId() == null) {
			map.put("stateId", null);
		}
		else {
			map.put("stateId", String.valueOf(receiptRsModel.getStateId()));
		}

		if (receiptRsModel.getSubOrganizationId() == null) {
			map.put("subOrganizationId", null);
		}
		else {
			map.put(
				"subOrganizationId",
				String.valueOf(receiptRsModel.getSubOrganizationId()));
		}

		if (receiptRsModel.getSubject() == null) {
			map.put("subject", null);
		}
		else {
			map.put("subject", String.valueOf(receiptRsModel.getSubject()));
		}

		if (receiptRsModel.getTempFileId() == null) {
			map.put("tempFileId", null);
		}
		else {
			map.put(
				"tempFileId", String.valueOf(receiptRsModel.getTempFileId()));
		}

		if (receiptRsModel.getTypeId() == null) {
			map.put("typeId", null);
		}
		else {
			map.put("typeId", String.valueOf(receiptRsModel.getTypeId()));
		}

		if (receiptRsModel.getUserPostId() == null) {
			map.put("userPostId", null);
		}
		else {
			map.put(
				"userPostId", String.valueOf(receiptRsModel.getUserPostId()));
		}

		if (receiptRsModel.getViewPdfUrl() == null) {
			map.put("viewPdfUrl", null);
		}
		else {
			map.put(
				"viewPdfUrl", String.valueOf(receiptRsModel.getViewPdfUrl()));
		}

		return map;
	}

	public static class ReceiptRsModelJSONParser
		extends BaseJSONParser<ReceiptRsModel> {

		@Override
		protected ReceiptRsModel createDTO() {
			return new ReceiptRsModel();
		}

		@Override
		protected ReceiptRsModel[] createDTOArray(int size) {
			return new ReceiptRsModel[size];
		}

		@Override
		protected void setField(
			ReceiptRsModel receiptRsModel, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setCity((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "countryId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setCountryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "deliveryModeId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setDeliveryModeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "designation")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setDesignation((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setGroupId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "letterDate")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setLetterDate((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mobile")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setMobile((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "modeNumber")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setModeNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "organizationId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setOrganizationId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "pinCode")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setPinCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "receiptCategoryId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setReceiptCategoryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "receiptSubCategoryId")) {

				if (jsonParserFieldValue != null) {
					receiptRsModel.setReceiptSubCategoryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "receivedOn")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setReceivedOn((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "referenceNumber")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setReferenceNumber(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "remarks")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setRemarks((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "stateId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setStateId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "subOrganizationId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setSubOrganizationId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "subject")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setSubject((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tempFileId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setTempFileId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "typeId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setTypeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userPostId")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setUserPostId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "viewPdfUrl")) {
				if (jsonParserFieldValue != null) {
					receiptRsModel.setViewPdfUrl((String)jsonParserFieldValue);
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