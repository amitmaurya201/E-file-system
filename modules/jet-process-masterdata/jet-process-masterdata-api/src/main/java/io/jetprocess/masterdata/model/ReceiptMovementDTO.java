package io.jetprocess.masterdata.model;

import java.util.Date;

public class ReceiptMovementDTO {

	private long receiptMovementId;
	private String receiptNumber;
	private String subject;
	private String sender;
	private String sentBy;
	private String sentTo;
	private Date sentOn;
	private String readOn;
	private String dueDate;
	private String remark;
	private String receivedOn;
	private String nature;
	private String currentlyWith;
	private String active;
	private String receiptId;

	public ReceiptMovementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public long getReceiptMovementId() {
		return receiptMovementId;
	}

	public void setReceiptMovementId(long receiptMovementId) {
		this.receiptMovementId = receiptMovementId;
	}

	public String getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(String receivedOn) {
		this.receivedOn = receivedOn;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getCurrentlyWith() {
		return currentlyWith;
	}

	public void setCurrentlyWith(String currentlyWith) {
		this.currentlyWith = currentlyWith;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	@Override
	public String toString() {
		return "ReceiptMovementDTO [receiptMovementId=" + receiptMovementId + ", receiptNumber=" + receiptNumber
				+ ", subject=" + subject + ", sender=" + sender + ", sentBy=" + sentBy + ", sentTo=" + sentTo
				+ ", sentOn=" + sentOn + ", readOn=" + readOn + ", dueDate=" + dueDate + ", remark=" + remark
				+ ", receivedOn=" + receivedOn + ", nature=" + nature + ", currentlyWith=" + currentlyWith + ", active="
				+ active + ", receiptId=" + receiptId + "]";
	}

	public ReceiptMovementDTO(long receiptMovementId, String receiptNumber, String subject, String sender,
			String sentBy, String sentTo, Date sentOn, String readOn, String dueDate, String remark, String receivedOn,
			String nature, String currentlyWith, String active, String receiptId) {
		super();
		this.receiptMovementId = receiptMovementId;
		this.receiptNumber = receiptNumber;
		this.subject = subject;
		this.sender = sender;
		this.sentBy = sentBy;
		this.sentTo = sentTo;
		this.sentOn = sentOn;
		this.readOn = readOn;
		this.dueDate = dueDate;
		this.remark = remark;
		this.receivedOn = receivedOn;
		this.nature = nature;
		this.currentlyWith = currentlyWith;
		this.active = active;
		this.receiptId = receiptId;
	}

}
