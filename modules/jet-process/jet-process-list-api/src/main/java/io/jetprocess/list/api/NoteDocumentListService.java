package io.jetprocess.list.api;

import java.util.List;
import io.jetprocess.list.model.NoteDocumentDTO;

public interface NoteDocumentListService {
	
	public List<NoteDocumentDTO> getNoteDocumentCreatedList(long createdBy, String keyword, int start, int end , String orderBy, String order);
	
	public int getNoteDocumentListCount(long createdBy, String keyword);

}
