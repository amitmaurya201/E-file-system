package io.jetprocess.list.model;

import java.util.Date;

public class FileCorrespondenceReceiptDTO {

	private long receiptId;
	private long receiptMovementId;
	private String receiptNumber;
	private String subject;
	private String category;
	private Date createDate;
	private String remark;
	private String viewPdfUrl;
	private String nature;
	private String correspondenceType;

	public FileCorrespondenceReceiptDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileCorrespondenceReceiptDTO(long receiptId, long receiptMovementId, String receiptNumber, String subject,
			String category, Date createDate, String remark, String viewPdfUrl, String nature,
			String correspondenceType) {
		super();
		this.receiptId = receiptId;
		this.receiptMovementId = receiptMovementId;
		this.receiptNumber = receiptNumber;
		this.subject = subject;
		this.category = category;
		this.createDate = createDate;
		this.remark = remark;
		this.viewPdfUrl = viewPdfUrl;
		this.nature = nature;
		this.correspondenceType = correspondenceType;
	}

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public long getReceiptMovementId() {
		return receiptMovementId;
	}

	public void setReceiptMovementId(long receiptMovementId) {
		this.receiptMovementId = receiptMovementId;
	}

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

	public String getViewPdfUrl() {
		return viewPdfUrl;
	}

	public void setViewPdfUrl(String viewPdfUrl) {
		this.viewPdfUrl = viewPdfUrl;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getCorrespondenceType() {
		return correspondenceType;
	}

	public void setCorrespondenceType(String correspondenceType) {
		this.correspondenceType = correspondenceType;
	}

	@Override
	public String toString() {
		return "FileCorrespondenceReceiptDTO [receiptId=" + receiptId + ", receiptMovementId=" + receiptMovementId
				+ ", receiptNumber=" + receiptNumber + ", subject=" + subject + ", category=" + category
				+ ", createDate=" + createDate + ", remark=" + remark + ", viewPdfUrl=" + viewPdfUrl + ", nature="
				+ nature + ", correspondenceType=" + correspondenceType + "]";
	}

}
