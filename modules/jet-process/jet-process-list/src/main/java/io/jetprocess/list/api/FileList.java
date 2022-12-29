package io.jetprocess.list.api;

import java.util.List;

import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.FileMovementDTO;


public interface FileList {


	public  int getCountOfFileList(long postId, String keyword);
	
	public List<FileListViewDto> getFileList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);
	
	public  int getFileInboxListCount(long postId, String keyword);
	
	public List<FileMovementDTO> getFileInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);


	public  int getFileSentListCount(long postId, String keyword);
	
	public List<FileMovementDTO> getFileSentList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);
	
}
