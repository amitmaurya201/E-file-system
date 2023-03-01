package io.jetprocess.list.model;

import java.util.Date;

public class ClosedFileDTO {
	
	private long closedFileId;
	private long fileId;
	private String nature;
	private String fileNumber;
	private String subject;
	private Date closedOn;
	private String closingRemarks;
	private Date reopenDate;
	private long closingMovementId;
	private long reopenBy;
	private String reopenRemaks;
	private long closedBy;
	private long sectionId;
	public long getClosedFileId() {
		return closedFileId;
	}
	public void setClosedFileId(long closedFileId) {
		this.closedFileId = closedFileId;
	}
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
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
	public Date getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}
	public String getClosingRemarks() {
		return closingRemarks;
	}
	public void setClosingRemarks(String closingRemarks) {
		this.closingRemarks = closingRemarks;
	}
	public Date getReopenDate() {
		return reopenDate;
	}
	public void setReopenDate(Date reopenDate) {
		this.reopenDate = reopenDate;
	}
	public long getClosingMovementId() {
		return closingMovementId;
	}
	public void setClosingMovementId(long closingMovementId) {
		this.closingMovementId = closingMovementId;
	}
	public long getReopenBy() {
		return reopenBy;
	}
	public void setReopenBy(long reopenBy) {
		this.reopenBy = reopenBy;
	}
	public String getReopenRemaks() {
		return reopenRemaks;
	}
	public void setReopenRemaks(String reopenRemaks) {
		this.reopenRemaks = reopenRemaks;
	}
	public long getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(long closedBy) {
		this.closedBy = closedBy;
	}
	public long getSectionId() {
		return sectionId;
	}
	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}
	public ClosedFileDTO(long closedFileId, long fileId, String nature, String fileNumber, String subject,
			Date closedOn, String closingRemarks, Date reopenDate, long closingMovementId, long reopenBy,
			String reopenRemaks, long closedBy, long sectionId) {
		super();
		this.closedFileId = closedFileId;
		this.fileId = fileId;
		this.nature = nature;
		this.fileNumber = fileNumber;
		this.subject = subject;
		this.closedOn = closedOn;
		this.closingRemarks = closingRemarks;
		this.reopenDate = reopenDate;
		this.closingMovementId = closingMovementId;
		this.reopenBy = reopenBy;
		this.reopenRemaks = reopenRemaks;
		this.closedBy = closedBy;
		this.sectionId = sectionId;
	}
	public ClosedFileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ClosedFileDTO [closedFileId=" + closedFileId + ", fileId=" + fileId + ", nature=" + nature
				+ ", fileNumber=" + fileNumber + ", subject=" + subject + ", closedOn=" + closedOn + ", closingRemarks="
				+ closingRemarks + ", reopenDate=" + reopenDate + ", closingMovementId=" + closingMovementId
				+ ", reopenBy=" + reopenBy + ", reopenRemaks=" + reopenRemaks + ", closedBy=" + closedBy
				+ ", sectionId=" + sectionId + "]";
	}
	
	

}
