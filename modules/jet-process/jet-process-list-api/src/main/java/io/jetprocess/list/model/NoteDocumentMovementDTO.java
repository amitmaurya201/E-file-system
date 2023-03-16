package io.jetprocess.list.model;

import java.util.Date;

public class NoteDocumentMovementDTO {
	
	private long noteDocumentId;
	private String noteDocumentNumber;
    private String subject;
    private String sentBy;
    private Date sentOn;
    private String sentTo;
    private String remarks;
    private long currentlyWith;
    private String currentlyWithUserName;
	public NoteDocumentMovementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoteDocumentMovementDTO(long noteDocumentId, String noteDocumentNumber, String subject, String sentBy,
			Date sentOn, String sentTo, String remarks, long currentlyWith, String currentlyWithUserName) {
		super();
		this.noteDocumentId = noteDocumentId;
		this.noteDocumentNumber = noteDocumentNumber;
		this.subject = subject;
		this.sentBy = sentBy;
		this.sentOn = sentOn;
		this.sentTo = sentTo;
		this.remarks = remarks;
		this.currentlyWith = currentlyWith;
		this.currentlyWithUserName = currentlyWithUserName;
	}
	public long getNoteDocumentId() {
		return noteDocumentId;
	}
	public void setNoteDocumentId(long noteDocumentId) {
		this.noteDocumentId = noteDocumentId;
	}
	public String getNoteDocumentNumber() {
		return noteDocumentNumber;
	}
	public void setNoteDocumentNumber(String noteDocumentNumber) {
		this.noteDocumentNumber = noteDocumentNumber;
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
	public Date getSentOn() {
		return sentOn;
	}
	public void setSentOn(Date sentOn) {
		this.sentOn = sentOn;
	}
	public String getSentTo() {
		return sentTo;
	}
	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public long getCurrentlyWith() {
		return currentlyWith;
	}
	public void setCurrentlyWith(long currentlyWith) {
		this.currentlyWith = currentlyWith;
	}
	public String getCurrentlyWithUserName() {
		return currentlyWithUserName;
	}
	public void setCurrentlyWithUserName(String currentlyWithUserName) {
		this.currentlyWithUserName = currentlyWithUserName;
	}
	@Override
	public String toString() {
		return "NoteDocumentMovementDTO [noteDocumentId=" + noteDocumentId + ", noteDocumentNumber="
				+ noteDocumentNumber + ", subject=" + subject + ", sentBy=" + sentBy + ", sentOn=" + sentOn
				+ ", sentTo=" + sentTo + ", remarks=" + remarks + ", currentlyWith=" + currentlyWith
				+ ", currentlyWithUserName=" + currentlyWithUserName + "]";
	}
    
    
    
    
   
}
