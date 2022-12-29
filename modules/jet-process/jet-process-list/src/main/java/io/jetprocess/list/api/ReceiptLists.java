package io.jetprocess.list.api;

import java.util.List;

import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.ReceiptListViewDto;

public interface ReceiptLists {

	public  int getReceiptListCount(long postId, String keyword);
	
	public List<ReceiptListViewDto> getReceiptList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);
	
	public  int getFileInboxListCount(long postId, String keyword);
	
	public List<FileMovementDTO> getReceiptInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);


	public  int getReceiptSentListCount(long postId, String keyword);
	
	public List<FileMovementDTO> getReceiptSentList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);
}
