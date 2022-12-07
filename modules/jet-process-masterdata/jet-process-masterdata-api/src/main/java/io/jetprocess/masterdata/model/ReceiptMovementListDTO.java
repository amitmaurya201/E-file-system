package io.jetprocess.masterdata.model;

import java.util.Date;

public class ReceiptMovementListDTO {

	private String dueDate;
	private String remark;
	private long senderID;
	private long receiptID;
	private String readOn;
	private String receivedOn;
	private Date createdDate;
	private long receiverId;
	public ReceiptMovementListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReceiptMovementListDTO(String dueDate, String remark, long senderID, long receiptID, String readOn,
			String receivedOn, Date createdDate, long receiverId) {
		super();
		this.dueDate = dueDate;
		this.remark = remark;
		this.senderID = senderID;
		this.receiptID = receiptID;
		this.readOn = readOn;
		this.receivedOn = receivedOn;
		this.createdDate = createdDate;
		this.receiverId = receiverId;
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
	public long getSenderID() {
		return senderID;
	}
	public void setSenderID(long senderID) {
		this.senderID = senderID;
	}
	public long getReceiptID() {
		return receiptID;
	}
	public void setReceiptID(long receiptID) {
		this.receiptID = receiptID;
	}
	public String getReadOn() {
		return readOn;
	}
	public void setReadOn(String readOn) {
		this.readOn = readOn;
	}
	public String getReceivedOn() {
		return receivedOn;
	}
	public void setReceivedOn(String receivedOn) {
		this.receivedOn = receivedOn;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}
	@Override
	public String toString() {
		return "ReceiptMovementListDTO [dueDate=" + dueDate + ", remark=" + remark + ", senderID=" + senderID
				+ ", receiptID=" + receiptID + ", readOn=" + readOn + ", receivedOn=" + receivedOn + ", createdDate="
				+ createdDate + ", receiverId=" + receiverId + "]";
	}
	
}
