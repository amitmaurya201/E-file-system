	 package io.jetprocess.list.model;

import java.util.Date;

public class ClosedFileDTO {
	
	private long closedFileId;
	private long fileId;
	private long closedBy;
	private String closingRemarks;
	private Date reopenDate;
	private String reopenRemaks;
	private long closingMovementId;
	private long reopenBy;
	private Date closedOn;
	private String nature;
	private String fileNumber;
	private String subject;
	private long dealingHeadSectionId;
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
	public long getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(long closedBy) {
		this.closedBy = closedBy;
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
	public String getReopenRemaks() {
		return reopenRemaks;
	}
	public void setReopenRemaks(String reopenRemaks) {
		this.reopenRemaks = reopenRemaks;
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
	public Date getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
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
	public long getDealingHeadSectionId() {
		return dealingHeadSectionId;
	}
	public void setDealingHeadSectionId(long dealingHeadSectionId) {
		this.dealingHeadSectionId = dealingHeadSectionId;
	}
	public ClosedFileDTO(long closedFileId, long fileId, long closedBy, String closingRemarks, Date reopenDate,
			String reopenRemaks, long closingMovementId, long reopenBy, Date closedOn, String nature, String fileNumber,
			String subject, long dealingHeadSectionId) {
		super();
		this.closedFileId = closedFileId;
		this.fileId = fileId;
		this.closedBy = closedBy;
		this.closingRemarks = closingRemarks;
		this.reopenDate = reopenDate;
		this.reopenRemaks = reopenRemaks;
		this.closingMovementId = closingMovementId;
		this.reopenBy = reopenBy;
		this.closedOn = closedOn;
		this.nature = nature;
		this.fileNumber = fileNumber;
		this.subject = subject;
		this.dealingHeadSectionId = dealingHeadSectionId;
	}
	public ClosedFileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ClosedFileDTO [closedFileId=" + closedFileId + ", fileId=" + fileId + ", closedBy=" + closedBy
				+ ", closingRemarks=" + closingRemarks + ", reopenDate=" + reopenDate + ", reopenRemaks=" + reopenRemaks
				+ ", closingMovementId=" + closingMovementId + ", reopenBy=" + reopenBy + ", closedOn=" + closedOn
				+ ", nature=" + nature + ", fileNumber=" + fileNumber + ", subject=" + subject
				+ ", dealingHeadSectionId=" + dealingHeadSectionId + "]";
	}
	
	
	

}
