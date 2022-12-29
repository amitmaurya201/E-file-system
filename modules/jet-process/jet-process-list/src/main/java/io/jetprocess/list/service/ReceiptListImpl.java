package io.jetprocess.list.service;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.list.api.ReceiptLists;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.ReceiptListViewDto;

@Component(
		immediate = true,
		service=ReceiptLists.class
		)
public class ReceiptListsImpl implements ReceiptLists {

	@Override
	public int getReceiptListCount(long postId, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReceiptListViewDto> getReceiptList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFileInboxListCount(long postId, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FileMovementDTO> getReceiptInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getReceiptSentListCount(long postId, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FileMovementDTO> getReceiptSentList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
