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

@Component(
		immediate = true,
		service=ReceiptList.class
		)
public class ReceiptListImpl implements ReceiptList {

	@Override
	public int getReceiptListCount(long userpostId, String keyword) {
		
		Connection con=null;
		int count=0;
		 try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("-------paste the function----------");
			prepareCall.setLong(1, userpostId);
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
	public List<ReceiptListViewDto> getReceiptList(long userPostId, String keyword, int start, int end, String orderBy,
			String order) {
		List<ReceiptListViewDto> receiptList = new ArrayList<>();
		
		Connection con=null;
		
		 try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("-----paste function----------------");
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
					ReceiptListViewDto receipt = new ReceiptListViewDto();
					
					System.out.println("category : "+rs.getString("category")+
							", created on : "+rs.getDate("createdon")+", doc File : "+
							rs.getLong("docfileid")+", File number : "+rs.getString("filenumber")
									
									);
					receipt.setReceiptId(rs.getLong("receiptId"));
					receipt.setReceiptNumber(rs.getString("category"));
					receipt.setSubject(rs.getString("subject"));
					receipt.setCategory(rs.getString("category"));
					receipt.setCreateDate(rs.getDate("createdon"));
					receipt.setNature(rs.getString("nature"));
					receipt.setRemark(rs.getString("remark"));
					receipt.setViewPdfUrl(rs.getString("remark"));
				    receiptList.add(receipt);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			 DataAccess.cleanUp(con);
			 
		 }
		
		
		return receiptList;

	}

	@Override
	public int getReceiptInboxListCount(long userpostId, String keyword) {
		
		Connection con=null;
		int count=0;
		 try {
			con = DataAccess.getConnection();
			CallableStatement prepareCall = con.prepareCall("-------paste the function----------");
			prepareCall.setLong(1, userpostId);
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
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
	
		return null;
	}

	@Override
	public int getReceiptSentListCount(long userpostId, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReceiptMovementDTO> getReceiptSentList(long userPostId, String keyword, int start, int end,
			String orderBy, String order) {
		// TODO Auto-generated method stub
		return null;
	}


}
