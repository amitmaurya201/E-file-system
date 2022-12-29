package io.jetprocess.list.api;

import java.util.List;

import io.jetprocess.masterdata.model.ReceiptListViewDto;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;

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
}
