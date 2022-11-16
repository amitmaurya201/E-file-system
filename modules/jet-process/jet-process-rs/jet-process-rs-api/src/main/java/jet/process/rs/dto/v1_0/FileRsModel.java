package jet.process.rs.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Admin
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Contains all the data for file creation.",
	value = "FileRsModel"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "FileRsModel")
public class FileRsModel implements Serializable {

	public static FileRsModel toDTO(String json) {
		return ObjectMapperUtil.readValue(FileRsModel.class, json);
	}

	public static FileRsModel unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(FileRsModel.class, json);
	}

	@Schema
	public Long getBasicHeadId() {
		return basicHeadId;
	}

	public void setBasicHeadId(Long basicHeadId) {
		this.basicHeadId = basicHeadId;
	}

	@JsonIgnore
	public void setBasicHeadId(
		UnsafeSupplier<Long, Exception> basicHeadIdUnsafeSupplier) {

		try {
			basicHeadId = basicHeadIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long basicHeadId;

	@Schema
	public Long getFileCodeId() {
		return fileCodeId;
	}

	public void setFileCodeId(Long fileCodeId) {
		this.fileCodeId = fileCodeId;
	}

	@JsonIgnore
	public void setFileCodeId(
		UnsafeSupplier<Long, Exception> fileCodeIdUnsafeSupplier) {

		try {
			fileCodeId = fileCodeIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long fileCodeId;

	@Schema
	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	@JsonIgnore
	public void setFileNumber(
		UnsafeSupplier<String, Exception> fileNumberUnsafeSupplier) {

		try {
			fileNumber = fileNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String fileNumber;

	@Schema
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@JsonIgnore
	public void setGroupId(
		UnsafeSupplier<Long, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long groupId;

	@Schema
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long id;

	@Schema
	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	@JsonIgnore
	public void setNature(
		UnsafeSupplier<String, Exception> natureUnsafeSupplier) {

		try {
			nature = natureUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String nature;

	@Schema
	public Long getPrimaryHeadId() {
		return primaryHeadId;
	}

	public void setPrimaryHeadId(Long primaryHeadId) {
		this.primaryHeadId = primaryHeadId;
	}

	@JsonIgnore
	public void setPrimaryHeadId(
		UnsafeSupplier<Long, Exception> primaryHeadIdUnsafeSupplier) {

		try {
			primaryHeadId = primaryHeadIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long primaryHeadId;

	@Schema
	public Long getSecondaryHeadId() {
		return secondaryHeadId;
	}

	public void setSecondaryHeadId(Long secondaryHeadId) {
		this.secondaryHeadId = secondaryHeadId;
	}

	@JsonIgnore
	public void setSecondaryHeadId(
		UnsafeSupplier<Long, Exception> secondaryHeadIdUnsafeSupplier) {

		try {
			secondaryHeadId = secondaryHeadIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long secondaryHeadId;

	@Schema
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@JsonIgnore
	public void setSubject(
		UnsafeSupplier<String, Exception> subjectUnsafeSupplier) {

		try {
			subject = subjectUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String subject;

	@Schema
	public Long getTertiaryHeadId() {
		return tertiaryHeadId;
	}

	public void setTertiaryHeadId(Long tertiaryHeadId) {
		this.tertiaryHeadId = tertiaryHeadId;
	}

	@JsonIgnore
	public void setTertiaryHeadId(
		UnsafeSupplier<Long, Exception> tertiaryHeadIdUnsafeSupplier) {

		try {
			tertiaryHeadId = tertiaryHeadIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long tertiaryHeadId;

	@Schema
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonIgnore
	public void setType(UnsafeSupplier<String, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String type;

	@Schema
	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	@JsonIgnore
	public void setYear(UnsafeSupplier<Long, Exception> yearUnsafeSupplier) {
		try {
			year = yearUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long year;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileRsModel)) {
			return false;
		}

		FileRsModel fileRsModel = (FileRsModel)object;

		return Objects.equals(toString(), fileRsModel.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (basicHeadId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"basicHeadId\": ");

			sb.append(basicHeadId);
		}

		if (fileCodeId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileCodeId\": ");

			sb.append(fileCodeId);
		}

		if (fileNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileNumber\": ");

			sb.append("\"");

			sb.append(_escape(fileNumber));

			sb.append("\"");
		}

		if (groupId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(groupId);
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (nature != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nature\": ");

			sb.append("\"");

			sb.append(_escape(nature));

			sb.append("\"");
		}

		if (primaryHeadId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"primaryHeadId\": ");

			sb.append(primaryHeadId);
		}

		if (secondaryHeadId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"secondaryHeadId\": ");

			sb.append(secondaryHeadId);
		}

		if (subject != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subject\": ");

			sb.append("\"");

			sb.append(_escape(subject));

			sb.append("\"");
		}

		if (tertiaryHeadId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tertiaryHeadId\": ");

			sb.append(tertiaryHeadId);
		}

		if (type != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(type));

			sb.append("\"");
		}

		if (year != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"year\": ");

			sb.append(year);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "jet.process.rs.dto.v1_0.FileRsModel",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}