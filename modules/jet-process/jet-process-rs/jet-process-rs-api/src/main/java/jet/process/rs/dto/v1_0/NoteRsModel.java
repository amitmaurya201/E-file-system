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
	description = "Contains all the data for note creation.",
	value = "NoteRsModel"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "NoteRsModel")
public class NoteRsModel implements Serializable {

	public static NoteRsModel toDTO(String json) {
		return ObjectMapperUtil.readValue(NoteRsModel.class, json);
	}

	public static NoteRsModel unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(NoteRsModel.class, json);
	}

	@Schema
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonIgnore
	public void setContent(
		UnsafeSupplier<String, Exception> contentUnsafeSupplier) {

		try {
			content = contentUnsafeSupplier.get();
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
	protected String content;

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
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	@JsonIgnore
	public void setFileId(
		UnsafeSupplier<Long, Exception> fileIdUnsafeSupplier) {

		try {
			fileId = fileIdUnsafeSupplier.get();
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
	protected Long fileId;

	@Schema
	public Long getFileMovementId() {
		return fileMovementId;
	}

	public void setFileMovementId(Long fileMovementId) {
		this.fileMovementId = fileMovementId;
	}

	@JsonIgnore
	public void setFileMovementId(
		UnsafeSupplier<Long, Exception> fileMovementIdUnsafeSupplier) {

		try {
			fileMovementId = fileMovementIdUnsafeSupplier.get();
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
	protected Long fileMovementId;

	@Schema
	public Boolean getHasYellowNote() {
		return hasYellowNote;
	}

	public void setHasYellowNote(Boolean hasYellowNote) {
		this.hasYellowNote = hasYellowNote;
	}

	@JsonIgnore
	public void setHasYellowNote(
		UnsafeSupplier<Boolean, Exception> hasYellowNoteUnsafeSupplier) {

		try {
			hasYellowNote = hasYellowNoteUnsafeSupplier.get();
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
	protected Boolean hasYellowNote;

	@Schema
	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	@JsonIgnore
	public void setNoteId(
		UnsafeSupplier<Long, Exception> noteIdUnsafeSupplier) {

		try {
			noteId = noteIdUnsafeSupplier.get();
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
	protected Long noteId;

	@Schema
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@JsonIgnore
	public void setSignature(
		UnsafeSupplier<String, Exception> signatureUnsafeSupplier) {

		try {
			signature = signatureUnsafeSupplier.get();
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
	protected String signature;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NoteRsModel)) {
			return false;
		}

		NoteRsModel noteRsModel = (NoteRsModel)object;

		return Objects.equals(toString(), noteRsModel.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (content != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"content\": ");

			sb.append("\"");

			sb.append(_escape(content));

			sb.append("\"");
		}

		if (createdBy != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdBy\": ");

			sb.append(createdBy);
		}

		if (fileId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileId\": ");

			sb.append(fileId);
		}

		if (fileMovementId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileMovementId\": ");

			sb.append(fileMovementId);
		}

		if (hasYellowNote != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hasYellowNote\": ");

			sb.append(hasYellowNote);
		}

		if (noteId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"noteId\": ");

			sb.append(noteId);
		}

		if (signature != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"signature\": ");

			sb.append("\"");

			sb.append(_escape(signature));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "jet.process.rs.dto.v1_0.NoteRsModel",
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