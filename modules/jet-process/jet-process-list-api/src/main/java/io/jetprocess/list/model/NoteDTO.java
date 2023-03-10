package io.jetprocess.list.model;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Date;

public class NoteDTO {
	private long noteId;
	private String signature;
	private Date createDate;
	private String content;
	private boolean hasYellowNote;

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

	public String getSignature(String field) throws JSONException {
		 JSONObject  object = JSONFactoryUtil.createJSONObject(getSignature()); 
		 return object.getString(field); 
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
	
	public boolean isHasYellowNote() {
		return hasYellowNote;
	}

	public void setHasYellowNote(boolean hasYellowNote) {
		this.hasYellowNote = hasYellowNote;
	}


	public NoteDTO(long noteId, String signature, Date createDate, String content, boolean hasYellowNote) {
		super();
		this.noteId = noteId;
		this.signature = signature;
		this.createDate = createDate;
		this.content = content;
		this.hasYellowNote = hasYellowNote;
	}

	public NoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
