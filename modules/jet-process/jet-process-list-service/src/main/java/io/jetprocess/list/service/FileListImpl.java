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

import io.jetprocess.list.api.FileList;
import io.jetprocess.list.model.FileCorrespondenceReceiptDTO;
import io.jetprocess.list.model.FileListViewDto;
import io.jetprocess.list.model.FileMovementDTO;


@Component(immediate = true, service = FileList.class)
public class FileListImpl implements FileList {
	
	private static Log logger = LogFactoryUtil.getLog(FileListImpl.class);
	public int getFileCreatedListCount(long userPostId, String keyword) {
		logger.info("Getting created file list count");
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select PUBLIC.get_file_created_list_count(?,?)");
			prepareCall.setLong(1, userPostId);
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
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		logger.info("created file list count : "+count);
		return count;
	}

	public List<FileListViewDto> getFileList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		List<FileListViewDto> fileList = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("SELECT * from PUBLIC.get_file_created_list(?,?,?,?,?,?)");
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
					FileListViewDto file = new FileListViewDto();
					file.setCategory(rs.getString("category"));
					file.setCreateDate(rs.getTimestamp("createdon"));
					file.setDocFileId(rs.getLong("docfileid"));
					file.setFileNumber(rs.getString("filenumber"));
					file.setNature(rs.getString("nature"));
					file.setRemark(rs.getString("remark"));
					file.setSubject(rs.getString("subject"));
					fileList.add(file);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);

		}
		return fileList;
	}

	@Override
	public int getFileInboxListCount(long userpostId, String keyword) {
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select get_file_inbox_lists_count(?,?)");
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
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		logger.info("File inbox list count : "+count);
		return count;
	}

	@Override
	public List<FileMovementDTO> getFileInboxList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		List<FileMovementDTO> fileMovementDTOList = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("SELECT * from public.get_file_inbox_list(?,?,?,?,?,?)");
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
					FileMovementDTO fileMovementDTO = new FileMovementDTO();
					fileMovementDTO.setFileMovementId(rs.getLong("filemovementid"));
					fileMovementDTO.setFileNumber(rs.getString("filenumber"));
					fileMovementDTO.setSubject(rs.getString("subject"));
					fileMovementDTO.setSentBy(rs.getString("sentby"));
					fileMovementDTO.setSentTo(rs.getString("sentto"));
					fileMovementDTO.setSentOn(rs.getTimestamp("senton"));				
					fileMovementDTO.setReadOn(rs.getString("readon"));
					fileMovementDTO.setDueDate(rs.getString("duedate"));
					fileMovementDTO.setRemark(rs.getString("remark"));
					fileMovementDTO.setReceivedOn(rs.getString("receivedon"));
					fileMovementDTO.setCurrentlyWith(rs.getLong("currentlywith"));
					fileMovementDTO.setNature(rs.getString("nature"));
					fileMovementDTO.setFileId(rs.getLong("fileid"));
					fileMovementDTO.setSenderId(rs.getLong("senderid"));
					fileMovementDTO.setCurrentState(rs.getInt("currentstate"));
					fileMovementDTO.setDocFileId(rs.getLong("docfileid"));
					fileMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));
					fileMovementDTO.setCurrentlyWithUserName(rs.getString("currentlywithusername"));
					fileMovementDTOList.add(fileMovementDTO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		return fileMovementDTOList;
	}

	@Override
	public int getFileSentListCount(long postId, String keyword) {
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select get_file_sent_lists_count(?,?)");
			prepareCall.setLong(1, postId);
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
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		return count;
	}

	@Override
	public List<FileMovementDTO> getFileSentList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		List<FileMovementDTO> fileMovementDTOList = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("SELECT * from public.get_file_sent_list(?,?,?,?,?,?)");
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
					FileMovementDTO fileMovementDTO = new FileMovementDTO();
					fileMovementDTO.setFileMovementId(rs.getLong("filemovementid"));
					fileMovementDTO.setFileNumber(rs.getString("filenumber"));
					fileMovementDTO.setSubject(rs.getString("subject"));
					fileMovementDTO.setSentBy(rs.getString("sentby"));
					fileMovementDTO.setSentTo(rs.getString("sentto"));
					fileMovementDTO.setSentOn(rs.getTimestamp("senton"));
					fileMovementDTO.setReadOn(rs.getString("readon"));
					fileMovementDTO.setDueDate(rs.getString("duedate"));
					fileMovementDTO.setRemark(rs.getString("remark"));
					fileMovementDTO.setReceivedOn(rs.getString("receivedon"));
					fileMovementDTO.setCurrentlyWith(rs.getLong("currentlywith"));
					fileMovementDTO.setNature(rs.getString("nature"));
					fileMovementDTO.setFileId(rs.getLong("fileid"));
					fileMovementDTO.setSenderId(rs.getLong("senderid"));
					fileMovementDTO.setCurrentState(rs.getInt("currentstate"));
					fileMovementDTO.setDocFileId(rs.getLong("docfileid"));
					fileMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));
					fileMovementDTO.setCurrentlyWithUserName(rs.getString("currentlywithusername"));
					fileMovementDTOList.add(fileMovementDTO);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		return fileMovementDTOList;
	}

	@Override
	public List<FileMovementDTO> getFileMovementList(long fileMovementId , long docfileId, String keyword, int start, int end,
			String orderBy, String order) {
		List<FileMovementDTO> fileMovementDTOList = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_file_movement_list_new(?,?,?,?,?,?,?)");
			prepareCall.setLong(1, fileMovementId);
			prepareCall.setLong(2, docfileId);
			prepareCall.setString(3, keyword);
			prepareCall.setInt(4, start);
			prepareCall.setInt(5, end);
			prepareCall.setString(6, orderBy);
			prepareCall.setString(7, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					FileMovementDTO fileMovementDTO = new FileMovementDTO();
					fileMovementDTO.setFileMovementId(rs.getLong("filemovementid"));
					fileMovementDTO.setFileNumber(rs.getString("filenumber"));
					fileMovementDTO.setSubject(rs.getString("subject"));
					fileMovementDTO.setSentBy(rs.getString("sentby"));
					fileMovementDTO.setSentTo(rs.getString("sentto"));
					fileMovementDTO.setSentOn(rs.getTimestamp("senton"));
					fileMovementDTO.setReadOn(rs.getString("readon"));
					fileMovementDTO.setDueDate(rs.getString("duedate"));
					fileMovementDTO.setRemark(rs.getString("remark"));
					fileMovementDTO.setReceivedOn(rs.getString("receivedon"));
					fileMovementDTO.setCurrentlyWith(rs.getLong("currentlywith"));
					fileMovementDTO.setNature(rs.getString("nature"));
					fileMovementDTO.setFileId(rs.getLong("fileid"));
					fileMovementDTO.setSenderId(rs.getLong("senderid"));
					fileMovementDTO.setCurrentState(rs.getInt("currentstate"));
					fileMovementDTO.setDocFileId(rs.getLong("docfileid"));
					fileMovementDTO.setPullBackRemark(rs.getString("pullbackremark"));
					fileMovementDTO.setCurrentlyWithUserName(rs.getString("currentlywithusername"));
					fileMovementDTOList.add(fileMovementDTO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		return fileMovementDTOList;
	}
	@Override
	public int getFileMovementListCount(long filemovementId ,  long fileId, String keyword) {
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select public.get_file_movement_list_count_new(?,?,?)");
			prepareCall.setLong(1, filemovementId);
			prepareCall.setLong(2, fileId);
			prepareCall.setString(3, keyword);
			boolean execute = prepareCall.execute();

			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		return count;
	}

	@Override
	public int getFileCorrespondenceCount(long fileId, String keyword) {
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select public.get_file_correspondence_list_count(?,?)");
			prepareCall.setLong(1, fileId);
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
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		return count;
	}

	@Override
	public List<FileCorrespondenceReceiptDTO> getFileCorrespondence(long filemovementId ,  long docfileId, String keyword, int start, int end,
			String orderBy, String order) {
		List<FileCorrespondenceReceiptDTO> fileCorrespondenceReceiptDTO = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_file_correspondence_list_new(?,?,?,?,?,?,?)");
			prepareCall.setLong(1, filemovementId);
			prepareCall.setLong(2, docfileId);
			prepareCall.setString(3, keyword);
			prepareCall.setInt(4, start);
			prepareCall.setInt(5, end);
			prepareCall.setString(6, orderBy);
			prepareCall.setString(7, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					FileCorrespondenceReceiptDTO filCorrespondenceDTO = new FileCorrespondenceReceiptDTO();
					filCorrespondenceDTO.setReceiptId(rs.getLong("receiptid"));
					filCorrespondenceDTO.setReceiptNumber(rs.getString("receiptnumber"));
					filCorrespondenceDTO.setSubject(rs.getString("subject"));
					filCorrespondenceDTO.setCategory(rs.getString("category"));
					filCorrespondenceDTO.setCreateDate(rs.getTimestamp("createdate"));
					filCorrespondenceDTO.setRemark(rs.getString("remark"));
					filCorrespondenceDTO.setViewPdfUrl(rs.getString("viewPdfUrl"));
					filCorrespondenceDTO.setNature(rs.getString("nature"));
					filCorrespondenceDTO.setCorrespondenceType(rs.getString("correspondenceType"));
					fileCorrespondenceReceiptDTO.add(filCorrespondenceDTO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
		}
		return fileCorrespondenceReceiptDTO;
	}
}
