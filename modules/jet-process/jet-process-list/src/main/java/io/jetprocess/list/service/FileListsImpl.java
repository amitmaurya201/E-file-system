package io.jetprocess.list.service;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.list.api.FileLists;
import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.FileMovementDTO;

@Component(immediate = true, service=FileLists.class)
public class FileListsImpl implements FileLists{


public  int getCountOfFileList(long postId, String keyword) {
		
		Connection con=null;
		int count=0;
		 try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("select file_count_by_keyword(?,?)");
			prepareCall.setLong(1, postId);
			prepareCall.setString(2, keyword);
			boolean execute = prepareCall.execute();
			
			if(execute) {
				ResultSet rs=prepareCall.getResultSet();
				if (rs.next()) {
				    count= rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
			 DataAccess.cleanUp(con);
		 }
		 
		 
		
		return count;
	}


public List<FileListViewDto> getFileList(long userPostId, String keyword, int start, int end,
		String orderBy, String order){
	
	
	List<FileListViewDto> fileList=new ArrayList<>();
	
	Connection con=null;
	
	 try {
		con = DataAccess.getConnection();
		CallableStatement prepareCall = con.prepareCall("SELECT * from public.get_file_list(?,?,?,?,?,?)");
		prepareCall.setLong(1, userPostId);
		prepareCall.setString(2, keyword);
		prepareCall.setInt(3, start);
		prepareCall.setInt(4, end);
		prepareCall.setString(5, orderBy);
		prepareCall.setString(6, order);
		boolean execute = prepareCall.execute();
		
		if(execute) {
			ResultSet rs=prepareCall.getResultSet();
			while (rs.next()) {
				FileListViewDto file=new FileListViewDto();
				
				System.out.println("category : "+rs.getString("category")+
						", created on : "+rs.getDate("createdon")+", doc File : "+
						rs.getLong("docfileid")+", File number : "+rs.getString("filenumber")
								
								);
			    file.setCategory(rs.getString("category"));
			    file.setCreateDate(rs.getDate("createdon"));
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
	}finally {
		 DataAccess.cleanUp(con);
		 
	 }
	
	
	return fileList;
}


@Override
public int getFileInboxListCount(long postId, String keyword) {
	Connection con=null;
	int count=0;
	 try {
		con = DataAccess.getConnection();
		CallableStatement prepareCall = con.prepareCall("select get_file_inbox_lists_count(?,?)");
		prepareCall.setLong(1, postId);
		prepareCall.setString(2, keyword);
		boolean execute = prepareCall.execute();
		
		if(execute) {
			ResultSet rs=prepareCall.getResultSet();
			if (rs.next()) {
			    count= rs.getInt(1);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 finally {
		 DataAccess.cleanUp(con);
	 }
	 
	 
	
	return count;
}


@Override
public List<FileMovementDTO> getFileInboxList(long userPostId, String keyword, int start, int end, String orderBy,
		String order) {
	Connection con=null;
	
	 try {
		con = DataAccess.getConnection();
		CallableStatement prepareCall = con.prepareCall("SELECT * from public.get_file_list(?,?,?,?,?,?)");
		prepareCall.setLong(1, userPostId);
		prepareCall.setString(2, keyword);
		prepareCall.setInt(3, start);
		prepareCall.setInt(4, end);
		prepareCall.setString(5, orderBy);
		prepareCall.setString(6, order);
		boolean execute = prepareCall.execute();
		
		if(execute) {
			ResultSet rs=prepareCall.getResultSet();
			while (rs.next()) {
				FileMovementDTO fileInbox=new FileMovementDTO();
				
			
				
				
			}
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		 DataAccess.cleanUp(con);
		 
	 }
	
	return null;
}


@Override
public int getFileSentListCount(long postId, String keyword) {
	Connection con=null;
	int count=0;
	 try {
		con = DataAccess.getConnection();
		CallableStatement prepareCall = con.prepareCall("select get_file_sent_lists_count(?,?)");
		prepareCall.setLong(1, postId);
		prepareCall.setString(2, keyword);
		boolean execute = prepareCall.execute();
		
		if(execute) {
			ResultSet rs=prepareCall.getResultSet();
			if (rs.next()) {
			    count= rs.getInt(1);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 finally {
		 DataAccess.cleanUp(con);
	 }
	return count;
	 
}


@Override
public List<FileMovementDTO> getFileSentList(long userPostId, String keyword, int start, int end, String orderBy,
		String order) {
	// TODO Auto-generated method stub
	return null;
}

}
