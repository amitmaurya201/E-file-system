package io.jetprocess.list.model;

import java.util.Date;

public class NoteDocumentDTO {
	
	private String categoryValue;
	private String content;
	private long noteDocumentId;
	private Date createdOn;
	private String noteDocumentNumber;
	private String subject;
	private long createdBy;
	private long subjectCategoryId;
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
	public NoteDocumentDTO(String categoryValue, String content, long noteDocumentId, Date createdOn,
			String noteDocumentNumber, String subject, long createdBy, long subjectCategoryId) {
		super();
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
		return "NoteDocumentDTO [categoryValue=" + categoryValue + ", content=" + content + ", noteDocumentId="
				+ noteDocumentId + ", createdOn=" + createdOn + ", noteDocumentNumber=" + noteDocumentNumber
				+ ", subject=" + subject + ", createdBy=" + createdBy + ", subjectCategoryId=" + subjectCategoryId
				+ "]";
	}

	


}
