package io.jetprocess.list.service;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.list.api.ReceiptList;
import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.ReceiptListViewDto;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;

@Component(immediate = true, service = ReceiptList.class)
public class ReceiptListImpl implements ReceiptList {

	@Override
	public int getReceiptListCount(long userpostId, String keyword) {

		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_receipt_created_list_count(?,?)" );
			prepareCall.setLong(1, userpostId);
			prepareCall.setString(2, keyword);
			boolean execute = prepareCall.execute();
			System.out.println("receipt list count");
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				if (rs.next()) {
					System.out.println("receipt list count"+rs.getInt(1));
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con);
		}

		return count;

	}

	@Override
	public List<ReceiptListViewDto> getReceiptList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {

		List<ReceiptListViewDto> receiptList = new ArrayList<>();

		Connection con = null;

		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_receipt_created_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, userPostId);
			prepareCall.setString(2, keyword);
			prepareCall.setInt(3, start);
			prepareCall.setInt(4, end);
			prepareCall.setString(5, orderBy);
			prepareCall.setString(6, order);
			boolean execute = prepareCall.execute();

			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					ReceiptListViewDto receipt = new ReceiptListViewDto();

					System.out.println("category : " + rs.getString("category") + ", created on : "
							+ rs.getDate("createdate") + ", receiptId : " + rs.getLong("receiptId") + ", receiptnumber : "
							+ rs.getString("receiptnumber")

					);
					receipt.setReceiptId(rs.getLong("receiptId"));
					receipt.setReceiptNumber(rs.getString("receiptnumber"));
					receipt.setSubject(rs.getString("subject"));
					receipt.setCategory(rs.getString("category"));
					receipt.setCreateDate(rs.getDate("createdate"));
					receipt.setNature(rs.getString("nature"));
					receipt.setRemark(rs.getString("remark"));
					receipt.setViewPdfUrl(rs.getString("viewpdfurl"));
					receiptList.add(receipt);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con);

		}

		return receiptList;

	}

	@Override
	public int getReceiptInboxListCount(long userpostId, String keyword) {

		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_receipt_inbox_list_count(?,?)");
			prepareCall.setLong(1, userpostId);
			prepareCall.setString(2, keyword);
			boolean execute = prepareCall.execute();

			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con);
		}

		return count;

	}

	@Override
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {

		List<ReceiptMovementDTO> receiptMovementDTOList = new ArrayList<>();

		Connection con = null;

		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_receipt_inbox_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, userPostId);
			prepareCall.setString(2, keyword);
			prepareCall.setInt(3, start);
			prepareCall.setInt(4, end);
			prepareCall.setString(5, orderBy);
			prepareCall.setString(6, order);
			boolean execute = prepareCall.execute();

			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					ReceiptMovementDTO receiptMovementDTO = new ReceiptMovementDTO();

					System.out.println("receiptmovementid : " + rs.getString("receiptmovementid") + ", receiptnumber : "
							+ rs.getString("receiptnumber") + ", subject : " + rs.getString("subject") + ", sender : "
							+ rs.getString("sender") + ", sentby : " + rs.getString("sentby") + ", sentto : "
							+ rs.getString("sentto") + ", senton : " + rs.getDate("senton") + ", readon : "
							+ rs.getString("readon") + ", duedate : " + rs.getString("duedate") + ", remark : "
							+ rs.getString("remark") + ", receivedon : " + rs.getString("receiveon") + ", nature : "
							+ rs.getString("nature") + ", receiptid : " + rs.getLong("receiptid") + ", pullbackremark : "
							+ rs.getString("pullbackremark")

					);

					receiptMovementDTO.setReceiptMovementId(rs.getLong("receiptmovementid"));
					receiptMovementDTO.setReceiptNumber(rs.getString("receiptnumber"));
					receiptMovementDTO.setSubject(rs.getString("subject"));
					receiptMovementDTO.setSender(rs.getString("sender"));
					receiptMovementDTO.setSentBy(rs.getString("sentby"));
					receiptMovementDTO.setSentTo(rs.getString("sentto"));
					receiptMovementDTO.setSentOn(rs.getDate("senton"));
					receiptMovementDTO.setReadOn(rs.getString("readon"));
					receiptMovementDTO.setDueDate(rs.getString("duedate"));
					receiptMovementDTO.setRemark(rs.getString("remark"));
					receiptMovementDTO.setReceivedOn(rs.getString("receiveon"));
					receiptMovementDTO.setNature(rs.getString("nature"));
					receiptMovementDTO.setReceiptId(rs.getLong("receiptid"));
					receiptMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));

					receiptMovementDTOList.add(receiptMovementDTO);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con);

		}

		return receiptMovementDTOList;

	}

	@Override
	public int getReceiptSentListCount(long userpostId, String keyword) {

		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select public.get_receipt_sent_list_count(?,?)");
			prepareCall.setLong(1, userpostId);
			prepareCall.setString(2, keyword);
			boolean execute = prepareCall.execute();

			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con);
		}

		return count;
	}

	@Override
	public List<ReceiptMovementDTO> getReceiptSentList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {

		List<ReceiptMovementDTO> receiptMovementDTOList = new ArrayList<>();

		Connection con = null;

		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_receipt_sent_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, userPostId);
			prepareCall.setString(2, keyword);
			prepareCall.setInt(3, start);
			prepareCall.setInt(4, end);
			prepareCall.setString(5, orderBy);
			prepareCall.setString(6, order);
			boolean execute = prepareCall.execute();

			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					ReceiptMovementDTO receiptMovementDTO = new ReceiptMovementDTO();

					System.out.println("receiptmovementid : " + rs.getString("receiptmovementid") + ", receiptnumber : "
							+ rs.getString("receiptnumber") + ", subject : " + rs.getString("subject") + ", sender : "
							+ rs.getString("sender") + ", sentby : " + rs.getString("sentby") + ", sentto : "
							+ rs.getString("sentto") + ", senton : " + rs.getDate("senton") + ", readon : "
							+ rs.getString("readon") + ", duedate : " + rs.getString("duedate") + ", remark : "
							+ rs.getString("remark") + ", receivedon : " + rs.getString("receivedon") + ", nature : "
							+ rs.getString("nature") + ", receiptid : " + rs.getLong("receiptid") + ", pullbackremark : "
							+ rs.getString("pullbackremark")

					);

					receiptMovementDTO.setReceiptMovementId(rs.getLong("receiptmovementid"));
					receiptMovementDTO.setReceiptNumber(rs.getString("receiptnumber"));
					receiptMovementDTO.setSubject(rs.getString("subject"));
					receiptMovementDTO.setSender(rs.getString("sender"));
					receiptMovementDTO.setSentBy(rs.getString("sentby"));
					receiptMovementDTO.setSentTo(rs.getString("sentto"));
					receiptMovementDTO.setSentOn(rs.getDate("senton"));
					receiptMovementDTO.setReadOn(rs.getString("readon"));
					receiptMovementDTO.setDueDate(rs.getString("duedate"));
					receiptMovementDTO.setRemark(rs.getString("remark"));
					receiptMovementDTO.setReceivedOn(rs.getString("receivedon"));
					receiptMovementDTO.setNature(rs.getString("nature"));
					receiptMovementDTO.setReceiptId(rs.getLong("receiptid"));
					receiptMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));

					receiptMovementDTOList.add(receiptMovementDTO);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con);

		}

		return receiptMovementDTOList;

	}
}
