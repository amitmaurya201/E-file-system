package io.jetprocess.list.model;

import java.util.Date;

public class NoteDocumentDTO {
	
	private long movementId;
	private Date modifiedDate;
	private long noteId;
	private String categoryValue;
	private String content;
	private long noteDocumentId;
	private Date createdOn;
	private String noteDocumentNumber;
	private String subject;
	private long createdBy;
	private long subjectCategoryId;
	public long getMovementId() {
		return movementId;
	}
	public void setMovementId(long movementId) {
		this.movementId = movementId;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getNoteId() {
		return noteId;
	}
	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}
	public String getCategoryValue() {
		return categoryValue;
	}
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getNoteDocumentId() {
		return noteDocumentId;
	}
	public void setNoteDocumentId(long noteDocumentId) {
		this.noteDocumentId = noteDocumentId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public long getSubjectCategoryId() {
		return subjectCategoryId;
	}
	public void setSubjectCategoryId(long subjectCategoryId) {
		this.subjectCategoryId = subjectCategoryId;
	}
	public NoteDocumentDTO(long movementId, Date modifiedDate, long noteId, String categoryValue, String content,
			long noteDocumentId, Date createdOn, String noteDocumentNumber, String subject, long createdBy,
			long subjectCategoryId) {
		super();
		this.movementId = movementId;
		this.modifiedDate = modifiedDate;
		this.noteId = noteId;
		this.categoryValue = categoryValue;
		this.content = content;
		this.noteDocumentId = noteDocumentId;
		this.createdOn = createdOn;
		this.noteDocumentNumber = noteDocumentNumber;
		this.subject = subject;
		this.createdBy = createdBy;
		this.subjectCategoryId = subjectCategoryId;
	}
	public NoteDocumentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NoteDocumentDTO [movementId=" + movementId + ", modifiedDate=" + modifiedDate + ", noteId=" + noteId
				+ ", categoryValue=" + categoryValue + ", content=" + content + ", noteDocumentId=" + noteDocumentId
				+ ", createdOn=" + createdOn + ", noteDocumentNumber=" + noteDocumentNumber + ", subject=" + subject
				+ ", createdBy=" + createdBy + ", subjectCategoryId=" + subjectCategoryId + "]";
	}
	
}
