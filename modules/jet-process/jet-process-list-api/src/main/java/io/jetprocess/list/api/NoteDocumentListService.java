package io.jetprocess.list.api;

import java.util.List;
import io.jetprocess.list.model.NoteDocumentDTO;
import io.jetprocess.list.model.NoteDocumentMovementDTO;

public interface NoteDocumentListService {
	
	public List<NoteDocumentDTO> getNoteDocumentCreatedList(long createdBy, String keyword, int start, int end , String orderBy, String order);
	
	public int getNoteDocumentListCount(long createdBy, String keyword);
	
	public List<NoteDocumentMovementDTO> getNoteDocumentMovementList(long notedocumentId, String keyword, int start, int end , String orderBy, String order);

	public int getNoteDocumentMovementListCount(long notedocumentId, String keyword);

	public List<NoteDocumentMovementDTO> getNoteDocumentSentList(long senderId, String keyword, int start, int end , String orderBy, String order);

	public int getNoteDocumentSentListCount(long senderId, String keyword);
	
    public List<NoteDocumentMovementDTO> getNoteDocumentInboxList(long receiverId, String keyword, int start, int end , String orderBy, String order);
	
	public int getNoteDocumentInboxListCount(long notedocumentId, String keyword);
	
	
	


}
