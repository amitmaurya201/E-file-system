package io.jetprocess.list.model;

import java.util.Date;

public class FileMovementDTO {

	private long fileMovementId; // fmid from filemovement table
	private String fileNumber; // filenumber form docfile table
	private String subject; // subject form docfile table
	private String sentBy; // sender details from userpost table
	private String sentTo; // receiver details from userpost table
	private Date sentOn; // create date in filemovement table
	private String readOn; // readOn from filemovement table
	private Date dueDate; // duedate from filemovement table
	private String remark; // remarks from filemovement table
	private String receivedOn; // receiveOn from filemovement table
	private long currentlyWith; // currentlyWith from docfile table
	private String nature; // nature from docFile table
	private long fileId;
	private long senderId;
	private int currentState;
	private long docFileId;
	private String pullBackRemark;
	private String currentlyWithUserName;

	public FileMovementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileMovementDTO(long fileMovementId, String fileNumber, String subject, String sentBy, String sentTo,
			Date sentOn, String readOn, Date dueDate, String remark, String receivedOn, long currentlyWith,
			String nature, long fileId, long senderId, int currentState, long docFileId, String pullBackRemark,
			String currentlyWithUserName) {
		super();
		this.fileMovementId = fileMovementId;
		this.fileNumber = fileNumber;
		this.subject = subject;
		this.sentBy = sentBy;
		this.sentTo = sentTo;
		this.sentOn = sentOn;
		this.readOn = readOn;
		this.dueDate = dueDate;
		this.remark = remark;
		this.receivedOn = receivedOn;
		this.currentlyWith = currentlyWith;
		this.nature = nature;
		this.fileId = fileId;
		this.senderId = senderId;
		this.currentState = currentState;
		this.docFileId = docFileId;
		this.pullBackRemark = pullBackRemark;
		this.currentlyWithUserName = currentlyWithUserName;
	}

	public long getFileMovementId() {
		return fileMovementId;
	}

	public void setFileMovementId(long fileMovementId) {
		this.fileMovementId = fileMovementId;
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

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(String receivedOn) {
		this.receivedOn = receivedOn;
	}

	public long getCurrentlyWith() {
		return currentlyWith;
	}

	public void setCurrentlyWith(long currentlyWith) {
		this.currentlyWith = currentlyWith;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	public long getDocFileId() {
		return docFileId;
	}

	public void setDocFileId(long docFileId) {
		this.docFileId = docFileId;
	}

	public String getPullBackRemark() {
		return pullBackRemark;
	}

	public void setPullBackRemark(String pullBackRemark) {
		this.pullBackRemark = pullBackRemark;
	}

	public String getCurrentlyWithUserName() {
		return currentlyWithUserName;
	}

	public void setCurrentlyWithUserName(String currentlyWithUserName) {
		this.currentlyWithUserName = currentlyWithUserName;
	}

	@Override
	public String toString() {
		return "FileMovementDTO [fileMovementId=" + fileMovementId + ", fileNumber=" + fileNumber + ", subject="
				+ subject + ", sentBy=" + sentBy + ", sentTo=" + sentTo + ", sentOn=" + sentOn + ", readOn=" + readOn
				+ ", dueDate=" + dueDate + ", remark=" + remark + ", receivedOn=" + receivedOn + ", currentlyWith="
				+ currentlyWith + ", nature=" + nature + ", fileId=" + fileId + ", senderId=" + senderId
				+ ", currentState=" + currentState + ", docFileId=" + docFileId + ", pullBackRemark=" + pullBackRemark
				+ ", currentlyWithUserName=" + currentlyWithUserName + "]";
	}

}
