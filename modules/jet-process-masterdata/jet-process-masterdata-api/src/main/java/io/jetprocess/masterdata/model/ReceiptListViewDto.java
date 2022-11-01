package io.jetprocess.masterdata.model;

import java.util.Date;

public class ReceiptListViewDto {
	
	private String receiptNumber;
	private String subject;
	private String category;
	private Date createDate;
	private String remark;
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ReceiptListViewDto(String receiptNumber, String subject, String category, Date createDate, String remark) {
		super();
		this.receiptNumber = receiptNumber;
		this.subject = subject;
		this.category = category;
		this.createDate = createDate;
		this.remark = remark;
	}
	public ReceiptListViewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
	
	
}
