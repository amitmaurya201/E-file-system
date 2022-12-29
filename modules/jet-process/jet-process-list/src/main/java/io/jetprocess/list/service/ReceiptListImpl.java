package io.jetprocess.list.service;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.list.api.ReceiptList;
import io.jetprocess.masterdata.model.ReceiptListViewDto;

@Component(
		immediate = true,
		service=ReceiptList.class
		)
public class ReceiptListImpl implements ReceiptList {

	@Override
	public int getReceiptListCount(long userpostId, String keyword) {
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
	public int getReceiptInboxListCount(long userpostId, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReceiptListViewDto> getReceiptInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getReceiptSentListCount(long userpostId, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReceiptListViewDto> getReceiptSentList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
		// TODO Auto-generated method stub
		return null;
	}


}
