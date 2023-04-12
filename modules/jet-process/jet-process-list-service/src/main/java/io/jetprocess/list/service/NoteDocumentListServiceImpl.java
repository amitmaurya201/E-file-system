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

import io.jetprocess.list.api.NoteDocumentListService;
import io.jetprocess.list.model.NoteDocumentDTO;
import io.jetprocess.list.model.NoteDocumentMovementDTO;

@Component(immediate = true, service = NoteDocumentListService.class)
public class NoteDocumentListServiceImpl implements NoteDocumentListService {
	
private static Log logger = LogFactoryUtil.getLog(NoteDocumentListServiceImpl.class);

	
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
	public List<NoteDocumentDTO> getNoteDocumentCreatedList(long createdBy, String keyword, int start, int end,
			String orderBy, String order) {
		
		logger.info("getting data------------------------------");
		List<NoteDocumentDTO> noteDocumentList = new ArrayList<>();
		CallableStatement prepareCall=null;
		try {
			
			 prepareCall = con.prepareCall("SELECT * from PUBLIC.get_notedocument_created_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, createdBy);
			prepareCall.setString(2, keyword);
			prepareCall.setInt(3, start);
			prepareCall.setInt(4, end);
			prepareCall.setString(5, orderBy);
			prepareCall.setString(6, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
				NoteDocumentDTO noteDocument = new NoteDocumentDTO();
				noteDocument.setMovementId(rs.getLong("movementid"));
				noteDocument.setModifiedDate(rs.getTimestamp("modifieddate"));
				noteDocument.setNoteId(rs.getLong("noteid"));
				noteDocument.setCategoryValue(rs.getString("categoryvalue"));	
				noteDocument.setContent(rs.getString("content"));	
				noteDocument.setNoteDocumentId(rs.getLong("notedocumentid"));
				noteDocument.setCreatedOn(rs.getTimestamp("createdon"));
				noteDocument.setNoteDocumentNumber(rs.getString("notedocumentnumber"));
				noteDocument.setSubject(rs.getString("subject"));					
				noteDocument.setCreatedBy(rs.getLong("createdBy"));
				noteDocument.setSubjectCategoryId(rs.getLong("subjectcategoryid"));
				noteDocumentList.add(noteDocument);	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(prepareCall);

		}

		// TODO Auto-generated method stub
		return noteDocumentList;
	}


	@Override
	public int getNoteDocumentListCount(long createdBy, String keyword) {
		
		logger.info("Getting NoteDocument  List Count...");
		int count = 0;
		CallableStatement prepareCall = null;
		try {
			prepareCall = con.prepareCall("select public.get_notedocument_list_count(?, ?)");
			prepareCall.setLong(1, createdBy);
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


	@Override
	public List<NoteDocumentMovementDTO> getNoteDocumentMovementList(long notedocumentId, String keyword, int start,
			int end, String orderBy, String order) {
		logger.info("getting data----------NoteDocument Movement List--------------------");
		List<NoteDocumentMovementDTO> noteDocumentMovementList = new ArrayList<>();
		CallableStatement prepareCall=null;
		try {
			
			 prepareCall = con.prepareCall("select * from public.get_notedocument_movement_list(?, ?, ?, ?, ?, ?)");
			prepareCall.setLong(1, notedocumentId);
			prepareCall.setString(2, keyword);
			prepareCall.setInt(3, start);
			prepareCall.setInt(4, end);
			prepareCall.setString(5, orderBy);
			prepareCall.setString(6, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
				NoteDocumentMovementDTO noteDocument = new NoteDocumentMovementDTO();
				noteDocument.setNoteDocumentNumber(rs.getString("notedocumentnumber"));
				noteDocument.setSubject(rs.getString("subject"));
				noteDocument.setSentBy(rs.getString("sentby"));	
				noteDocument.setSentOn(rs.getTimestamp("senton"));
				noteDocument.setSentTo(rs.getString("sentto"));
				noteDocument.setRemarks(rs.getString("remarks"));
				noteDocument.setCurrentlyWith(rs.getLong("currentlywith"));
				noteDocument.setCurrentlyWithUserName(rs.getString("currentlywithusername"));
				noteDocumentMovementList.add(noteDocument);	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(prepareCall);

		}

		// TODO Auto-generated method stub
		return noteDocumentMovementList;

	}


	@Override
	public int getNoteDocumentMovementListCount(long notedocumentId, String keyword) {
		
		logger.info("Getting NoteDocument Movement List Count...");
		int count = 0;
		CallableStatement prepareCall = null;
		try {
			prepareCall = con.prepareCall("select public.get_notedocumentmovement_list_count(?,?)");
			prepareCall.setLong(1, notedocumentId);
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
@Override
	public List<NoteDocumentMovementDTO> getNoteDocumentSentList(long senderId, String keyword, int start,
			int end, String orderBy, String order) {
		logger.info("getting data----------NoteDocument sent List--------------------");
		List<NoteDocumentMovementDTO> noteDocumentMovementList = new ArrayList<>();
		CallableStatement prepareCall = null;
		try {

			prepareCall = con.prepareCall("select * from public.get_notedocument_sent_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, senderId);
			prepareCall.setString(2, keyword);
			prepareCall.setInt(3, start);
			prepareCall.setInt(4, end);
			prepareCall.setString(5, orderBy);
			prepareCall.setString(6, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					NoteDocumentMovementDTO noteDocument = new NoteDocumentMovementDTO();
					noteDocument.setNoteDocumentId(rs.getLong("notedocumentid"));
					noteDocument.setNoteDocumentNumber(rs.getString("notedocumentnumber"));
					noteDocument.setSubject(rs.getString("subject"));
					noteDocument.setSentBy(rs.getString("sentby"));
					noteDocument.setSentOn(rs.getTimestamp("senton"));
					noteDocument.setSentTo(rs.getString("sentto"));
					noteDocument.setRemarks(rs.getString("remarks"));
					noteDocument.setCurrentlyWith(rs.getLong("currentlywith"));
					noteDocument.setCurrentlyWithUserName(rs.getString("currentlywithusername"));
					System.out.println(noteDocument);
					noteDocumentMovementList.add(noteDocument);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(prepareCall);

		}

		return noteDocumentMovementList;
	}

	@Override
	public int getNoteDocumentSentListCount(long senderId, String keyword) {
		logger.info("Getting NoteDocument sent List Count...");
		int count = 0;
		CallableStatement prepareCall = null;
		try {
			prepareCall = con.prepareCall("select public.get_notedocument_sent_list_count(?, ?)");
			prepareCall.setLong(1, senderId);
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



	@Override
	public List<NoteDocumentMovementDTO> getNoteDocumentInboxList(long receiverId, String keyword, int start, int end,
			String orderBy, String order) {


		logger.info("Getting file inbox list");
		List<NoteDocumentMovementDTO> noteDocumentInboxDTOList = new ArrayList<>();
		CallableStatement prepareCall=null;
		try {
			 prepareCall = con.prepareCall("SELECT * from public.get_notedocuement_inbox_list(?,?,?,?,?,?)");
			prepareCall.setLong(1, receiverId);
			prepareCall.setString(2, keyword);
			prepareCall.setInt(3, start);
			prepareCall.setInt(4, end);
			prepareCall.setString(5, orderBy);
			prepareCall.setString(6, order);
			boolean execute = prepareCall.execute();
			if (execute) {
				ResultSet rs = prepareCall.getResultSet();
				while (rs.next()) {
					NoteDocumentMovementDTO noteDocumentMovementDTO = new NoteDocumentMovementDTO();
					noteDocumentMovementDTO.setNoteDocumentNumber(rs.getString("notedocumentnumber"));
					noteDocumentMovementDTO.setSubject(rs.getString("subject"));
					noteDocumentMovementDTO.setSentBy(rs.getString("sentby"));
					noteDocumentMovementDTO.setSentOn(rs.getDate("senton"));
					noteDocumentMovementDTO.setSentTo(rs.getString("sentto"));
					noteDocumentMovementDTO.setRemarks(rs.getString("remarks"));
					noteDocumentMovementDTO.setCurrentlyWith(rs.getLong("currentlywith"));
					noteDocumentMovementDTO.setCurrentlyWithUserName(rs.getString("currentlywithusername"));
					noteDocumentInboxDTOList.add(noteDocumentMovementDTO);	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up connection");
		}
		return noteDocumentInboxDTOList;		
	}



	@Override
	public int getNoteDocumentInboxListCount(long receiverId, String keyword) {
		logger.info("Getting file sent list count");
		CallableStatement prepareCall=null;
		int count = 0;
		try {
			
			 prepareCall = con.prepareCall("select public.get_notedocument_inbox_list_count(?,?)");
			prepareCall.setLong(1, receiverId);
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
			DataAccess.cleanUp(prepareCall);
			logger.info("Cleaning up connection");
		}
		return count;
		
	}

}
