package io.jetprocess.masterdata.model;

import java.util.Date;

public class FileListViewDto {

	private String fileNumber;
	private String subject;
	private String category;
	private String remark;
	private Date createDate;
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
	public FileListViewDto(String fileNumber, String subject, String category, String remark, Date createDate) {
		super();
		this.fileNumber = fileNumber;
		this.subject = subject;
		this.category = category;
		this.remark = remark;
		this.createDate = createDate;
	}
	
	
	
}