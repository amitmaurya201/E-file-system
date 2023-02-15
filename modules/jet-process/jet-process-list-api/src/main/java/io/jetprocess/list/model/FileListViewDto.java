package io.jetprocess.list.model;

import java.util.Date;

public class FileListViewDto {

	private long filemovementId;
	private long docFileId;
	private String fileNumber;
	private String subject;
	private String category;
	private String remark;
	private Date createDate;
	private String nature;

	public long getFilemovementId() {
		return filemovementId;
	}

	public void setFilemovementId(long filemovementId) {
		this.filemovementId = filemovementId;
	}

	public long getDocFileId() {
		return docFileId;
	}

	public void setDocFileId(long docFileId) {
		this.docFileId = docFileId;
	}

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public FileListViewDto(long filemovementId, long docFileId, String fileNumber, String subject, String category,
			String remark, Date createDate, String nature) {
		super();
		this.filemovementId = filemovementId;
		this.docFileId = docFileId;
		this.fileNumber = fileNumber;
		this.subject = subject;
		this.category = category;
		this.remark = remark;
		this.createDate = createDate;
		this.nature = nature;
	}

	public FileListViewDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
