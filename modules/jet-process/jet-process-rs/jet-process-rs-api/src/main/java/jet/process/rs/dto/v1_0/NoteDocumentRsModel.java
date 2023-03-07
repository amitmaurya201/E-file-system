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
	description = "Contains all the data for note Document creation.",
	value = "NoteDocumentRsModel"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "NoteDocumentRsModel")
public class NoteDocumentRsModel implements Serializable {

	public static NoteDocumentRsModel toDTO(String json) {
		return ObjectMapperUtil.readValue(NoteDocumentRsModel.class, json);
	}

	public static NoteDocumentRsModel unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			NoteDocumentRsModel.class, json);
	}

	@Schema
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@JsonIgnore
	public void setCreateDate(
		UnsafeSupplier<String, Exception> createDateUnsafeSupplier) {

		try {
			createDate = createDateUnsafeSupplier.get();
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
	protected String createDate;

	@Schema
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore
	public void setCreatedBy(
		UnsafeSupplier<Long, Exception> createdByUnsafeSupplier) {

		try {
			createdBy = createdByUnsafeSupplier.get();
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
	protected Long createdBy;

	@Schema
	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@JsonIgnore
	public void setModifiedDate(
		UnsafeSupplier<String, Exception> modifiedDateUnsafeSupplier) {

		try {
			modifiedDate = modifiedDateUnsafeSupplier.get();
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
	protected String modifiedDate;

	@Schema
	public Long getNoteDocumentId() {
		return noteDocumentId;
	}

	public void setNoteDocumentId(Long noteDocumentId) {
		this.noteDocumentId = noteDocumentId;
	}

	@JsonIgnore
	public void setNoteDocumentId(
		UnsafeSupplier<Long, Exception> noteDocumentIdUnsafeSupplier) {

		try {
			noteDocumentId = noteDocumentIdUnsafeSupplier.get();
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
	protected Long noteDocumentId;

	@Schema
	public String getNoteDocumentNumber() {
		return noteDocumentNumber;
	}

	public void setNoteDocumentNumber(String noteDocumentNumber) {
		this.noteDocumentNumber = noteDocumentNumber;
	}

	@JsonIgnore
	public void setNoteDocumentNumber(
		UnsafeSupplier<String, Exception> noteDocumentNumberUnsafeSupplier) {

		try {
			noteDocumentNumber = noteDocumentNumberUnsafeSupplier.get();
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
	protected String noteDocumentNumber;

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
	public Long getSubjectCategoryId() {
		return subjectCategoryId;
	}

	public void setSubjectCategoryId(Long subjectCategoryId) {
		this.subjectCategoryId = subjectCategoryId;
	}

	@JsonIgnore
	public void setSubjectCategoryId(
		UnsafeSupplier<Long, Exception> subjectCategoryIdUnsafeSupplier) {

		try {
			subjectCategoryId = subjectCategoryIdUnsafeSupplier.get();
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
	protected Long subjectCategoryId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NoteDocumentRsModel)) {
			return false;
		}

		NoteDocumentRsModel noteDocumentRsModel = (NoteDocumentRsModel)object;

		return Objects.equals(toString(), noteDocumentRsModel.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (createDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(_escape(createDate));

			sb.append("\"");
		}

		if (createdBy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdBy\": ");

			sb.append(createdBy);
		}

		if (modifiedDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(_escape(modifiedDate));

			sb.append("\"");
		}

		if (noteDocumentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"noteDocumentId\": ");

			sb.append(noteDocumentId);
		}

		if (noteDocumentNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"noteDocumentNumber\": ");

			sb.append("\"");

			sb.append(_escape(noteDocumentNumber));

			sb.append("\"");
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

		if (subjectCategoryId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subjectCategoryId\": ");

			sb.append(subjectCategoryId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "jet.process.rs.dto.v1_0.NoteDocumentRsModel",
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