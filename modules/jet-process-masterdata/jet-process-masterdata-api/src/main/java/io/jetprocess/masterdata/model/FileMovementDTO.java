package io.jetprocess.masterdata.model;

import java.util.Date;

public class FileMovementDTO {
	
	private long fileMovementId; // fmid from filemovement table
	private String fileNumber;  // filenumber form docfile table
	private String subject;     // subject form docfile table 
	private String sentBy;     // sender details from userpost table
	private String sentTo;    // receiver details from userpost table
	private Date sentOn;      // create date in filemovement table 
	private String readOn;    // readOn from filemovement table
	private String dueDate;  // duedate from filemovement table
	private String remark;    // remarks from filemovement table
	private String receivedOn;  // receiveOn from filemovement table
	private int currentlyWith;  // currentlyWith from docfile table
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
	public String getReceivedOn() {
		return receivedOn;
	}
	public void setReceivedOn(String receivedOn) {
		this.receivedOn = receivedOn;
	}
	public int getCurrentlyWith() {
		return currentlyWith;
	}
	public void setCurrentlyWith(int currentlyWith) {
		this.currentlyWith = currentlyWith;
	}
	public FileMovementDTO(long fileMovementId, String fileNumber, String subject, String sentBy, String sentTo,
			Date sentOn, String readOn, String dueDate, String remark, String receivedOn, int currentlyWith) {
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
	}
	@Override
	public String toString() {
		return "FileMovementDTO [fileMovementId=" + fileMovementId + ", fileNumber=" + fileNumber + ", subject="
				+ subject + ", sentBy=" + sentBy + ", sentTo=" + sentTo + ", sentOn=" + sentOn + ", readOn=" + readOn
				+ ", dueDate=" + dueDate + ", remark=" + remark + ", receivedOn=" + receivedOn + ", currentlyWith="
				+ currentlyWith + "]";
	}
	
	
	
	
	
	
	
	
}
