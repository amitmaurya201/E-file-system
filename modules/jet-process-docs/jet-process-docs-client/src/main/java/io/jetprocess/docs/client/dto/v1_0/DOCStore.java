package io.jetprocess.docs.client.dto.v1_0;

import io.jetprocess.docs.client.function.UnsafeSupplier;
import io.jetprocess.docs.client.serdes.v1_0.DOCStoreSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class DOCStore implements Cloneable, Serializable {

	public static DOCStore toDTO(String json) {
		return DOCStoreSerDes.toDTO(json);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public String getDocumentStream() {
		return documentStream;
	}

	public void setDocumentStream(String documentStream) {
		this.documentStream = documentStream;
	}

	public void setDocumentStream(
		UnsafeSupplier<String, Exception> documentStreamUnsafeSupplier) {

		try {
			documentStream = documentStreamUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String documentStream;

	public Number getFileId() {
		return fileId;
	}

	public void setFileId(Number fileId) {
		this.fileId = fileId;
	}

	public void setFileId(
		UnsafeSupplier<Number, Exception> fileIdUnsafeSupplier) {

		try {
			fileId = fileIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Number fileId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileName(
		UnsafeSupplier<String, Exception> fileNameUnsafeSupplier) {

		try {
			fileName = fileNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fileName;

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public void setFolderName(
		UnsafeSupplier<String, Exception> folderNameUnsafeSupplier) {

		try {
			folderName = folderNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String folderName;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setGroupId(
		UnsafeSupplier<String, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String groupId;

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

	@Override
	public DOCStore clone() throws CloneNotSupportedException {
		return (DOCStore)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DOCStore)) {
			return false;
		}

		DOCStore docStore = (DOCStore)object;

		return Objects.equals(toString(), docStore.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DOCStoreSerDes.toJSON(this);
	}

}