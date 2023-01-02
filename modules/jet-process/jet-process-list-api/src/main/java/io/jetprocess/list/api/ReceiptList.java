package io.jetprocess.list.api;

import java.util.List;

import io.jetprocess.list.model.ReceiptListViewDto;
import io.jetprocess.list.model.ReceiptMovementDTO;



public interface ReceiptList {

	public  int getReceiptListCount(long userpostId, String keyword);
	
	public List<ReceiptListViewDto> getReceiptList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);
	
	public  int getReceiptInboxListCount(long userpostId, String keyword);
	
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);


	public  int getReceiptSentListCount(long userpostId, String keyword);
	
	public List<ReceiptMovementDTO> getReceiptSentList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);
	
	
	public List<ReceiptMovementDTO> getReceiptMovementList(long receiptId, String keyword, int start, int end,
			String orderBy, String order);
	
	public int getReceiptMovementListCount(long userpostId, String keyword);
	
	
	public List<ReceiptListViewDto> getPutInFileList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);
	
	public int getPutInFileListCount(long postId, String keyword);
			
	
	
}
