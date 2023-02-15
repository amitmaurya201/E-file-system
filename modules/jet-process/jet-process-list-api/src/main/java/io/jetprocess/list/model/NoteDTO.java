package io.jetprocess.list.model;

import java.util.Date;

public class NoteDTO {
	private long noteId;
	private String signature;
	private Date createDate;
	private String content;

	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NoteDTO(long noteId, String signature, Date createDate, String content) {
		super();
		this.noteId = noteId;
		this.signature = signature;
		this.createDate = createDate;
		this.content = content;
	}

	public NoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
