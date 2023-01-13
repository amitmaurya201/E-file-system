package io.jetprocess.list.service;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.list.api.FileList;
import io.jetprocess.list.model.FileListViewDto;
import io.jetprocess.list.model.FileMovementDTO;


@Component(immediate = true, service = FileList.class)
public class FileListImpl implements FileList {

	public int getFileCreatedListCount(long userPostId, String keyword) {
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
		} finally {
			DataAccess.cleanUp(con);
		}
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
		} finally {
			DataAccess.cleanUp(con);
		}
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
		} finally {
			DataAccess.cleanUp(con);
		}
		return fileMovementDTOList;
	}

	@Override
	public List<FileMovementDTO> getFileMovementList(long docfileId, String keyword, int start, int end,
			String orderBy, String order) {
		List<FileMovementDTO> fileMovementDTOList = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_file_movement_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, docfileId);
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
		} finally {
			DataAccess.cleanUp(con);
		}
		return fileMovementDTOList;
	}
	@Override
	public int getFileMovementListCount(long postId, String keyword) {
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select public.get_file_movement_list_count(?,?)");
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
		} finally {
			DataAccess.cleanUp(con);
		}
		return count;
	}
}
