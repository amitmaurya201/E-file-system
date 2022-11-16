package jet.process.rs.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import jet.process.rs.client.function.UnsafeSupplier;
import jet.process.rs.client.serdes.v1_0.FileRsModelSerDes;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class FileRsModel implements Cloneable, Serializable {

	public static FileRsModel toDTO(String json) {
		return FileRsModelSerDes.toDTO(json);
	}

	public Long getBasicHeadId() {
		return basicHeadId;
	}

	public void setBasicHeadId(Long basicHeadId) {
		this.basicHeadId = basicHeadId;
	}

	public void setBasicHeadId(
		UnsafeSupplier<Long, Exception> basicHeadIdUnsafeSupplier) {

		try {
			basicHeadId = basicHeadIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long basicHeadId;

	public Long getFileCodeId() {
		return fileCodeId;
	}

	public void setFileCodeId(Long fileCodeId) {
		this.fileCodeId = fileCodeId;
	}

	public void setFileCodeId(
		UnsafeSupplier<Long, Exception> fileCodeIdUnsafeSupplier) {

		try {
			fileCodeId = fileCodeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long fileCodeId;

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public void setFileNumber(
		UnsafeSupplier<String, Exception> fileNumberUnsafeSupplier) {

		try {
			fileNumber = fileNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fileNumber;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public void setGroupId(
		UnsafeSupplier<Long, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long groupId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public void setNature(
		UnsafeSupplier<String, Exception> natureUnsafeSupplier) {

		try {
			nature = natureUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String nature;

	public Long getPrimaryHeadId() {
		return primaryHeadId;
	}

	public void setPrimaryHeadId(Long primaryHeadId) {
		this.primaryHeadId = primaryHeadId;
	}

	public void setPrimaryHeadId(
		UnsafeSupplier<Long, Exception> primaryHeadIdUnsafeSupplier) {

		try {
			primaryHeadId = primaryHeadIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long primaryHeadId;

	public Long getSecondaryHeadId() {
		return secondaryHeadId;
	}

	public void setSecondaryHeadId(Long secondaryHeadId) {
		this.secondaryHeadId = secondaryHeadId;
	}

	public void setSecondaryHeadId(
		UnsafeSupplier<Long, Exception> secondaryHeadIdUnsafeSupplier) {

		try {
			secondaryHeadId = secondaryHeadIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long secondaryHeadId;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setSubject(
		UnsafeSupplier<String, Exception> subjectUnsafeSupplier) {

		try {
			subject = subjectUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String subject;

	public Long getTertiaryHeadId() {
		return tertiaryHeadId;
	}

	public void setTertiaryHeadId(Long tertiaryHeadId) {
		this.tertiaryHeadId = tertiaryHeadId;
	}

	public void setTertiaryHeadId(
		UnsafeSupplier<Long, Exception> tertiaryHeadIdUnsafeSupplier) {

		try {
			tertiaryHeadId = tertiaryHeadIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long tertiaryHeadId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setType(UnsafeSupplier<String, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String type;

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public void setYear(UnsafeSupplier<Long, Exception> yearUnsafeSupplier) {
		try {
			year = yearUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long year;

	@Override
	public FileRsModel clone() throws CloneNotSupportedException {
		return (FileRsModel)super.clone();
	}

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
		return FileRsModelSerDes.toJSON(this);
	}

}