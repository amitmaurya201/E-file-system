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
import io.jetprocess.list.model.NoteDTO;

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
		logger.info("created file list count : " + count);
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
					file.setFilemovementId(rs.getLong("fmid"));
					file.setCategory(rs.getString("category"));
					file.setCreateDate(rs.getTimestamp("createdon"));
					file.setDocFileId(rs.getLong("docfileid"));
					file.setFileNumber(rs.getString("filenumber"));
					file.setNature(rs.getString("nature"));
					file.setRemark(rs.getString("remark"));
					file.setSubject(rs.getString("subject"));
					file.setHasNote(rs.getBoolean("hasNote"));
					fileList.add(file);
					fileList.forEach(p ->System.out.println(p.isHasNote()));
				
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
			logger.info("Cleaning up connection");
			DataAccess.cleanUp(con);
		}
		logger.info("File inbox list count : " + count);
		return count;
	}

	@Override
	public List<FileMovementDTO> getFileInboxList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		logger.info("Getting file inbox list");
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
					fileMovementDTO.setDueDate(rs.getDate("duedate"));
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
			logger.info("Cleaning up connection");
		}
		return fileMovementDTOList;
	}

	@Override
	public int getFileSentListCount(long postId, String keyword) {
		logger.info("Getting file sent list count");
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
			logger.info("Cleaning up connection");
		}
		return count;
	}

	@Override
	public List<FileMovementDTO> getFileSentList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		logger.info("Getting file sent list count");
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
					fileMovementDTO.setDueDate(rs.getDate("duedate"));
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
			logger.info("Cleaning up connection");
		}
		return fileMovementDTOList;
	}

	@Override
	public List<FileMovementDTO> getFileMovementList(long fileMovementId, long docfileId, String keyword, int start,
			int end, String orderBy, String order) {
		logger.info("Getting file movement list");
		List<FileMovementDTO> fileMovementDTOList = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con
					.prepareCall("select * from public.get_file_movement_list(?,?,?,?,?,?,?)");
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
					fileMovementDTO.setDueDate(rs.getDate("duedate"));
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
			logger.info("Cleaning up connection");
		}
		return fileMovementDTOList;
	}

	@Override
	public int getFileMovementListCount(long filemovementId, long fileId, String keyword) {
		logger.info("Getting file movement list count");
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select public.get_file_movement_list_count(?,?,?)");
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
			logger.info("Cleaning up connection");
		}
		return count;
	}

	@Override
	public int getFileCorrespondenceCount(String mode, long filemovementId, long fileId, String keyword) {
		logger.info("Getting file correspondence count");
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con
					.prepareCall("select public.get_file_correspondence_list_count(?,?,?,?)");
			prepareCall.setString(1, mode);
			prepareCall.setLong(2, filemovementId);
			prepareCall.setLong(3, fileId);
			prepareCall.setString(4, keyword);
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
			logger.info("Cleaning up connection");
		}
		return count;
	}

	@Override
	public List<FileCorrespondenceReceiptDTO> getFileCorrespondence(String mode, long filemovementId, long docfileId,
			String keyword, int start, int end, String orderBy, String order) {
		logger.info("Getting file correspondencelist");
		List<FileCorrespondenceReceiptDTO> fileCorrespondenceReceiptDTO = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con
					.prepareCall("select * from public.get_file_correspondence_list(?,?,?,?,?,?,?,?)");
			prepareCall.setString(1, mode);
			prepareCall.setLong(2, filemovementId);
			prepareCall.setLong(3, docfileId);
			prepareCall.setString(4, keyword);
			prepareCall.setInt(5, start);
			prepareCall.setInt(6, end);
			prepareCall.setString(7, orderBy);
			prepareCall.setString(8, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					FileCorrespondenceReceiptDTO filCorrespondenceDTO = new FileCorrespondenceReceiptDTO();
					filCorrespondenceDTO.setReceiptId(rs.getLong("receiptid"));
					filCorrespondenceDTO.setReceiptMovementId(rs.getLong("receiptmovementid"));
					filCorrespondenceDTO.setReceiptNumber(rs.getString("receiptnumber"));
					filCorrespondenceDTO.setSubject(rs.getString("subject"));
					filCorrespondenceDTO.setCategory(rs.getString("category"));
					filCorrespondenceDTO.setCreateDate(rs.getTimestamp("createdate"));
					filCorrespondenceDTO.setRemark(rs.getString("remark"));
					filCorrespondenceDTO.setViewPdfUrl(rs.getString("viewPdfUrl"));
					filCorrespondenceDTO.setNature(rs.getString("nature"));
					filCorrespondenceDTO.setCorrespondenceType(rs.getString("correspondenceType"));
					filCorrespondenceDTO.setDetachable(rs.getBoolean("isdetachable"));
					fileCorrespondenceReceiptDTO.add(filCorrespondenceDTO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
			logger.info("Cleaning up connection");
		}
		return fileCorrespondenceReceiptDTO;
	}

	@Override
	public List<NoteDTO> getAttachedNoteList(String mode, long filemovementId, long docfileId) {
		logger.info("get Attached Note List");
		List<NoteDTO> noteDtoList = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_all_attached_note_list(?,?,?)");
			prepareCall.setString(1, mode);
			prepareCall.setLong(2, filemovementId);
			prepareCall.setLong(3, docfileId);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					NoteDTO noteDTO = new NoteDTO();
					noteDTO.setNoteId(rs.getLong("noteid"));
					noteDTO.setSignature(rs.getString("signature"));
					noteDTO.setCreateDate(rs.getTimestamp("createdate"));
					noteDTO.setContent(rs.getString("content"));
					noteDtoList.add(noteDTO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(con);
			logger.info("Cleaning up connection");
		}
		return noteDtoList;
	}

	
	@Override
	public List<FileListViewDto> getPutInFileReceipt(String type, long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
		logger.info("Getting put in file Receipt list");
		List<FileListViewDto> fileListViewDtoList = new ArrayList<>();
		Connection con = null;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select * from public.get_receipt_attach_in_file_list(?,?,?,?,?,?,?)");
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
					FileListViewDto fileListViewDto = new FileListViewDto();
					fileListViewDto.setDocFileId(rs.getLong("docfileid"));
					fileListViewDto.setFileNumber(rs.getString("filenumber"));
					fileListViewDto.setSubject(rs.getString("subject"));
					fileListViewDto.setCategory(rs.getString("category"));
					fileListViewDto.setCreateDate(rs.getTimestamp("createdate"));
					fileListViewDto.setRemark(rs.getString("remark"));
					fileListViewDto.setNature(rs.getString("nature"));
					fileListViewDto.setRead(rs.getBoolean("isread"));
					fileListViewDto.setFilemovementId(rs.getLong("filemovementid"));				
					fileListViewDtoList.add(fileListViewDto);
				}
			}
		} catch (SQLException e) {
			logger.error("Couldn't able to find connection"+e);
			e.printStackTrace();
		} finally {
			DataAccess.cleanUp(con);
			logger.info("Cleaning up connection");

		}
		return fileListViewDtoList;
		
	}

	@Override
	public int getPutInFileReceiptCount(String type , long userPostId, String keyword) {
		Connection con = null;
		int count = 0;
		try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select public.get_receipt_attach_in_file_list_count(?,?,?)");
			prepareCall.setString(1,type);		
			prepareCall.setLong(2,userPostId);			
			prepareCall.setString(3,keyword);
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
			logger.info("Cleaning up connection");
		}
		return count;
	}
}
