package io.jetprocess.model;

import java.util.Date;

public class SendFileDTO {
	

	long receiverId;
	long senderId;
	long fileId;
	String priority;
	@JetFormDate(format = "dd/MM/yyyy")
	Date dueDate;
	String remark;
	boolean active;
	int currentState;
	long movementType;
	public long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}
	public long getSenderId() {
		return senderId;
	}
	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCurrentState() {
		return currentState;
	}
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
	public long getMovementType() {
		return movementType;
	}
	public void setMovementType(long movementType) {
		this.movementType = movementType;
	}
	public SendFileDTO(long receiverId, long senderId, long fileId, String priority, Date dueDate, String remark,
			boolean active, int currentState, long movementType) {
		super();
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.fileId = fileId;
		this.priority = priority;
		this.dueDate = dueDate;
		this.remark = remark;
		this.active = active;
		this.currentState = currentState;
		this.movementType = movementType;
	}
	public SendFileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SendFileDTO [receiverId=" + receiverId + ", senderId=" + senderId + ", fileId=" + fileId + ", priority="
				+ priority + ", dueDate=" + dueDate + ", remark=" + remark + ", active=" + active + ", currentState="
				+ currentState + ", movementType=" + movementType + "]";
	}
	
	
}
