package io.jetprocess.masterdata.model;

import java.util.Date;

public class ReceiptMovementListDTO {

	private String dueDate;
	private String remark;
	private long receiptId;
	private long senderId;
	private long receiverId;
	private Date createdDate;
	private String readOn;
	private String receivedOn;
	public ReceiptMovementListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReceiptMovementListDTO(String dueDate, String remark, long receiptId, long senderId, long receiverId,
			Date createdDate, String readOn, String receivedOn) {
		super();
		this.dueDate = dueDate;
		this.remark = remark;
		this.receiptId = receiptId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.createdDate = createdDate;
		this.readOn = readOn;
		this.receivedOn = receivedOn;
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

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	@Override
	public String toString() {
		return "ReceiptMovementListDTO [dueDate=" + dueDate + ", remark=" + remark + ", receiptId=" + receiptId
				+ ", senderId=" + senderId + ", receiverId=" + receiverId + ", createdDate=" + createdDate + ", readOn="
				+ readOn + ", receivedOn=" + receivedOn + "]";
	}
}