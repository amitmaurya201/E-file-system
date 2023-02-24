package io.jetprocess.list.api;

import java.util.List;

import io.jetprocess.list.model.FileCorrespondenceReceiptDTO;
import io.jetprocess.list.model.FileListViewDto;
import io.jetprocess.list.model.FileMovementDTO;
import io.jetprocess.list.model.NoteDTO;

public interface FileListService {

	public int getFileCreatedListCount(long userPostId, String keyword);

	public List<FileListViewDto> getFileList(long userPostId, String keyword, int start, int end, String orderBy,
			String order);

	public int getFileInboxListCount(long userPostId, String keyword);

	public List<FileMovementDTO> getFileInboxList(long userPostId, String keyword, int start, int end, String orderBy,
			String order);

	public int getFileSentListCount(long postId, String keyword);

	public List<FileMovementDTO> getFileSentList(long userPostId, String keyword, int start, int end, String orderBy,
			String order);

	public int getFileMovementListCount(long filemovementId, long userPostId, String keyword);

	public List<FileMovementDTO> getFileMovementList(long filemovementId, long docfileId, String keyword, int start,
			int end, String orderBy, String order);

	public int getFileCorrespondenceCount(String mode, long filemovementId, long userPostId, String keyword);

	public List<FileCorrespondenceReceiptDTO> getFileCorrespondence(String mode, long filemovementId, long docfileId,
			String keyword, int start, int end, String orderBy, String order);

	public List<NoteDTO> getAttachedNoteList(String mode, long filemovementId, long docfileId);
	
	public List<FileListViewDto> getPutInFileReceipt(String type , long userPostId, String keyword, int start, int end,
			String orderBy, String order);
	
	public int getPutInFileReceiptCount(String type , long userPostId, String keyword);

}
