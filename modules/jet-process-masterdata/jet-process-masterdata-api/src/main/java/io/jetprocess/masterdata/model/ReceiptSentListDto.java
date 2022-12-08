package io.jetprocess.masterdata.model;

import java.util.Date;

public class ReceiptSentListDto {
	private String receiptNumber;
	private String subject;
	private String sender;
	private String userName;
	private String postMarking;
	private String sectionName;
	private String departmentName;
	private Date sentOn;
	private String readOn;
	private String dueDate;
	private String remark;
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPostMarking() {
		return postMarking;
	}
	public void setPostMarking(String postMarking) {
		this.postMarking = postMarking;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Date getSentOn() {
		return sentOn;
	}
	public void setSentOn(Date sentOn) {
		this.sentOn = sentOn;
	}
	public String getReadOn() {
		return readOn;
	}
	public void setReadOn(String readOn) {
		this.readOn = readOn;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ReceiptSentListDto(String receiptNumber, String subject, String sender, String userName, String postMarking,
			String sectionName, String departmentName, Date sentOn, String readOn, String dueDate, String remark) {
		super();
		this.receiptNumber = receiptNumber;
		this.subject = subject;
		this.sender = sender;
		this.userName = userName;
		this.postMarking = postMarking;
		this.sectionName = sectionName;
		this.departmentName = departmentName;
		this.sentOn = sentOn;
		this.readOn = readOn;
		this.dueDate = dueDate;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "ReceiptSentListDto [receiptNumber=" + receiptNumber + ", subject=" + subject + ", sender=" + sender
				+ ", userName=" + userName + ", postMarking=" + postMarking + ", sectionName=" + sectionName
				+ ", departmentName=" + departmentName + ", sentOn=" + sentOn + ", readOn=" + readOn + ", dueDate="
				+ dueDate + ", remark=" + remark + "]";
	}
	public ReceiptSentListDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
