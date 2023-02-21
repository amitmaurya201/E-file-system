package io.jetprocess.list.service;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.list.api.ReceiptList;
import io.jetprocess.list.model.ClosedReceiptDTO;
import io.jetprocess.list.model.ReceiptListViewDto;
import io.jetprocess.list.model.ReceiptMovementDTO;

@Component(immediate = true, service = ReceiptList.class)
public class ReceiptListImpl implements ReceiptList {

	private static Log logger = LogFactoryUtil.getLog(ReceiptListImpl.class);
	static Connection con = null;
	static {
		try {
			con = DataAccess.getConnection();
			logger.info("Getting connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getReceiptListCount(long userpostId, String keyword) {

		int count = 0;
		CallableStatement prepareCall = null;
		try {
			logger.info("Getting Receipt List Count...");

			prepareCall = con.prepareCall("select  public.get_receipt_created_list_count(?,?)");
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
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");
		}
		return count;
	}

	@Override
	public List<ReceiptListViewDto> getReceiptList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		logger.info("Getting Receipt List");
		List<ReceiptListViewDto> receiptList = new ArrayList<>();
		CallableStatement prepareCall = null;
		try {

			prepareCall = con.prepareCall("select * from public.get_receipt_created_list(?,?,?,?,?,?)");
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
					receipt.setReceiptMovementId(rs.getLong("receiptmovementid"));
					receipt.setReceiptId(rs.getLong("receiptId"));
					receipt.setReceiptNumber(rs.getString("receiptnumber"));
					receipt.setSubject(rs.getString("subject"));
					receipt.setCategory(rs.getString("category"));
					receipt.setCreateDate(rs.getTimestamp("createdate"));
					receipt.setNature(rs.getString("nature"));
					receipt.setRemark(rs.getString("remark"));
					receipt.setViewPdfUrl(rs.getString("viewpdfurl"));
					receiptList.add(receipt);
				}

			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			logger.info("Cleaning up statement");
			DataAccess.cleanUp(prepareCall);
		}
		return receiptList;
	}

	@Override
	public int getReceiptInboxListCount(long userpostId, String keyword) {

		logger.info("Getting Receipt inbox");
		CallableStatement prepareCall = null;
		int count = 0;
		try {

			prepareCall = con.prepareCall("select * from public.get_receipt_inbox_list_count(?,?)");
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

			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			logger.info("Cleaning up statement");
			DataAccess.cleanUp(prepareCall);
		}
		return count;
	}

	@Override
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
		logger.info("Getting Receipt Inbox list");
		List<ReceiptMovementDTO> receiptMovementDTOList = new ArrayList<>();
		CallableStatement prepareCall = null;
		try {

			prepareCall = con.prepareCall("select * from public.get_receipt_inbox_list(?,?,?,?,?,?)");
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
					receiptMovementDTO.setSenderId(rs.getLong("senderId"));
					receiptMovementDTO.setReceiptMovementId(rs.getLong("receiptmovementid"));
					receiptMovementDTO.setReceiptNumber(rs.getString("receiptnumber"));
					receiptMovementDTO.setSubject(rs.getString("subject"));
					receiptMovementDTO.setSender(rs.getString("sender"));
					receiptMovementDTO.setSentBy(rs.getString("sentby"));
					receiptMovementDTO.setSentTo(rs.getString("sentto"));
					receiptMovementDTO.setSentOn(rs.getTimestamp("senton"));
					receiptMovementDTO.setReadOn(rs.getString("readon"));
					receiptMovementDTO.setDueDate(rs.getTimestamp("duedate"));
					receiptMovementDTO.setRemark(rs.getString("remark"));
					receiptMovementDTO.setReceivedOn(rs.getString("receiveon"));
					receiptMovementDTO.setNature(rs.getString("nature"));
					receiptMovementDTO.setReceiptId(rs.getLong("receiptid"));
					receiptMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));
					receiptMovementDTOList.add(receiptMovementDTO);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			logger.info("Cleaning up statement");
			DataAccess.cleanUp(prepareCall);

		}
		return receiptMovementDTOList;

	}

	@Override
	public int getReceiptSentListCount(long userpostId, String keyword) {
		logger.info("Getting Receipt sent count");
		CallableStatement prepareCall = null;
		int count = 0;
		try {

			prepareCall = con.prepareCall("select public.get_receipt_sent_list_count(?,?)");
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
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			logger.info("Cleaning up statement");
			DataAccess.cleanUp(prepareCall);
		}
		return count;
	}

	@Override
	public List<ReceiptMovementDTO> getReceiptSentList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
		logger.info("Getting Receipt sent list ");
		List<ReceiptMovementDTO> receiptMovementDTOList = new ArrayList<>();
		CallableStatement prepareCall = null;
		try {

			prepareCall = con.prepareCall("select * from public.get_receipt_sent_list(?,?,?,?,?,?)");
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
					receiptMovementDTO.setReceiptMovementId(rs.getLong("receiptmovementid"));
					receiptMovementDTO.setReceiptNumber(rs.getString("receiptnumber"));
					receiptMovementDTO.setSubject(rs.getString("subject"));
					receiptMovementDTO.setSender(rs.getString("sender"));
					receiptMovementDTO.setSentBy(rs.getString("sentby"));
					receiptMovementDTO.setSentTo(rs.getString("sentto"));
					receiptMovementDTO.setSentOn(rs.getTimestamp("senton"));
					receiptMovementDTO.setReadOn(rs.getString("readon"));
					receiptMovementDTO.setDueDate(rs.getTimestamp("duedate"));
					receiptMovementDTO.setRemark(rs.getString("remark"));
					receiptMovementDTO.setReceivedOn(rs.getString("receivedon"));
					receiptMovementDTO.setNature(rs.getString("nature"));
					receiptMovementDTO.setReceiptId(rs.getLong("receiptid"));
					receiptMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));
					receiptMovementDTOList.add(receiptMovementDTO);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");
		}
		return receiptMovementDTOList;
	}

	@Override
	public List<ReceiptMovementDTO> getReceiptMovementList(long receiptMovementId, long receiptId, String keyword,
			int start, int end, String orderBy, String order) {
		List<ReceiptMovementDTO> receiptMovementDTOList = new ArrayList<>();
		CallableStatement prepareCall = null;
		try {
			logger.info("Getting Receipt Movement list");

			prepareCall = con.prepareCall("select * from public.get_receipt_movement_list(?,?,?,?,?,?,?)");
			prepareCall.setLong(1, receiptMovementId);
			prepareCall.setLong(2, receiptId);
			prepareCall.setString(3, keyword);
			prepareCall.setInt(4, start);
			prepareCall.setInt(5, end);
			prepareCall.setString(6, orderBy);
			prepareCall.setString(7, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					ReceiptMovementDTO receiptMovementDTO = new ReceiptMovementDTO();
					receiptMovementDTO.setReceiptMovementId(rs.getLong("receiptmovementid"));
					receiptMovementDTO.setReceiptNumber(rs.getString("receiptnumber"));
					receiptMovementDTO.setSubject(rs.getString("subject"));
					receiptMovementDTO.setSender(rs.getString("sender"));
					receiptMovementDTO.setSentBy(rs.getString("sentby"));
					receiptMovementDTO.setSentTo(rs.getString("sentto"));
					receiptMovementDTO.setSentOn(rs.getTimestamp("senton"));
					receiptMovementDTO.setReadOn(rs.getString("readon"));
					receiptMovementDTO.setDueDate(rs.getTimestamp("duedate"));
					receiptMovementDTO.setRemark(rs.getString("remark"));
					receiptMovementDTO.setReceivedOn(rs.getString("receivedon"));
					receiptMovementDTO.setNature(rs.getString("nature"));
					receiptMovementDTO.setReceiptId(rs.getLong("receiptid"));
					receiptMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));
					receiptMovementDTOList.add(receiptMovementDTO);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");
		}
		return receiptMovementDTOList;

	}

	@Override
	public List<ReceiptMovementDTO> getAttachReceiptMovementList(long receiptId, String keyword, int start, int end,
			String orderBy, String order) {
		logger.info("Getting Attach receipt movement list ");
		List<ReceiptMovementDTO> receiptMovementDTOList = new ArrayList<>();
		CallableStatement prepareCall = null;
		try {

			prepareCall = con.prepareCall("select * from public.get_attach_receipt_movement_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, receiptId);
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
					receiptMovementDTO.setReceiptMovementId(rs.getLong("receiptmovementid"));
					receiptMovementDTO.setReceiptNumber(rs.getString("receiptnumber"));
					receiptMovementDTO.setSubject(rs.getString("subject"));
					receiptMovementDTO.setSender(rs.getString("sender"));
					receiptMovementDTO.setSentBy(rs.getString("sentby"));
					receiptMovementDTO.setSentTo(rs.getString("sentto"));
					receiptMovementDTO.setSentOn(rs.getTimestamp("senton"));
					receiptMovementDTO.setReadOn(rs.getString("readon"));
					receiptMovementDTO.setDueDate(rs.getTimestamp("duedate"));
					receiptMovementDTO.setRemark(rs.getString("remark"));
					receiptMovementDTO.setReceivedOn(rs.getString("receivedon"));
					receiptMovementDTO.setNature(rs.getString("nature"));
					receiptMovementDTO.setReceiptId(rs.getLong("receiptid"));
					receiptMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));
					receiptMovementDTOList.add(receiptMovementDTO);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();

		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");
		}
		return receiptMovementDTOList;
	}

	@Override
	public int getReceiptMovementListCount(long receiptmovementId, long userpostId, String keyword) {
		logger.info("Getting Receipt Movement count ");
		CallableStatement prepareCall = null;
		int count = 0;
		try {

			prepareCall = con.prepareCall("SELECT public.get_receipt_movement_list_count(?,?,?)");
			prepareCall.setLong(1, receiptmovementId);
			prepareCall.setLong(2, userpostId);
			prepareCall.setString(3, keyword);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");
		}
		return count;
	}

	@Override
	public int getAttachReceiptMovementListCount(long receiptId, String keyword) {
		logger.info("Getting attach receipt movement count");
		CallableStatement prepareCall = null;
		int count = 0;
		try {

			prepareCall = con.prepareCall("SELECT public.get_attach_receipt_movement_list_count(?,?)");
			prepareCall.setLong(1, receiptId);
			prepareCall.setString(2, keyword);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");
		}
		return count;
	}

	@Override
	public List<ReceiptListViewDto> getPutInFileList(String type, long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
		logger.info("Getting put in file list");
		List<ReceiptListViewDto> receiptMovementDTOList = new ArrayList<>();
		CallableStatement prepareCall = null;
		try {

			prepareCall = con.prepareCall("select * from public.get_put_in_file_list(?,?,?,?,?,?,?)");
			prepareCall.setString(1, type);
			prepareCall.setLong(2, userPostId);
			prepareCall.setString(3, keyword);
			prepareCall.setInt(4, start);
			prepareCall.setInt(5, end);
			prepareCall.setString(6, orderBy);
			prepareCall.setString(7, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					ReceiptListViewDto receiptList = new ReceiptListViewDto();
					receiptList.setReceiptId(rs.getLong("receiptid"));
					receiptList.setReceiptNumber(rs.getString("receiptnumber"));
					receiptList.setSubject(rs.getString("subject"));
					receiptList.setCategory(rs.getString("category"));
					receiptList.setCreateDate(rs.getTimestamp("createdate"));
					receiptList.setRemark(rs.getString("remark"));
					receiptList.setViewPdfUrl(rs.getString("viewpdfurl"));
					receiptList.setNature(rs.getString("nature"));
					receiptList.setRead(rs.getBoolean("isread"));
					receiptList.setReceiptMovementId(rs.getLong("receiptmovementid"));
					receiptMovementDTOList.add(receiptList);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");

		}
		return receiptMovementDTOList;
	}

	@Override
	public int getPutInFileListCount(String type, long userPostId, String keyword) {
		logger.info("Getting put in file count");
		CallableStatement prepareCall = null;
		int count = 0;
		try {

			prepareCall = con.prepareCall("select  public.get_put_in_file_list_count(?,?,?)");
			prepareCall.setString(1, type);
			prepareCall.setLong(2, userPostId);
			prepareCall.setString(3, keyword);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");
		}
		return count;
	}

	@Override
	public List<ClosedReceiptDTO> getClosedReceiptList(long closedBy, String keyword, int start, int end,
			String orderBy, String order) {
		logger.info("closed dto called ");
		List<ClosedReceiptDTO> closeList = new ArrayList<>();
		CallableStatement prepareCall = null;
		try {
			prepareCall = con.prepareCall("SELECT * from public.get_closed_receipt_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, closedBy);
			prepareCall.setString(2, keyword);
			prepareCall.setInt(3, start);
			prepareCall.setInt(4, end);
			prepareCall.setString(5, orderBy);
			prepareCall.setString(6, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					ClosedReceiptDTO closedDTO = new ClosedReceiptDTO();
					closedDTO.setClosedReceiptId(rs.getLong("receiptclosedid"));
					closedDTO.setNature(rs.getString("nature"));
					closedDTO.setReceiptNumber(rs.getString("receiptnumber"));
					closedDTO.setSubject(rs.getString("subject"));
					closedDTO.setClosedOn(rs.getDate("closedon"));
					closedDTO.setClosingRemarks(rs.getString("closingRemarks"));
					closedDTO.setReceiptId(rs.getLong("receiptid"));
					closeList.add(closedDTO);
				}
			}
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up connection");
		}
		return closeList;
	}

	@Override
	public int getClosedReceiptListCount(long closedBy, String keyword) {
		logger.info("Getting Closed Receipt List Count...");
		int count = 0;
		CallableStatement prepareCall = null;
		try {
			prepareCall = con.prepareCall("select public.get_closed_receipt_list_count(?, ?)");
			prepareCall.setLong(1, closedBy);
			prepareCall.setString(2, keyword);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet resultSet = prepareCall.getResultSet();
				if (resultSet.next()) {
					count = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection" + e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up statement");
		}
		return count;
	}

}
