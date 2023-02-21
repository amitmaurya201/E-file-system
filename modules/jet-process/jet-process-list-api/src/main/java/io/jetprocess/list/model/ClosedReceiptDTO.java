package io.jetprocess.list.model;

import java.util.Date;

public class ClosedReceiptDTO {

	private long closedReceiptId;
	private long receiptId;
	private String nature;
	private String receiptNumber;
	private String subject;
	private Date closedOn;
	private String closingRemarks;

	public ClosedReceiptDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ClosedReceiptDTO [closedReceiptId=" + closedReceiptId + ", receiptId=" + receiptId + ", nature="
				+ nature + ", receiptNumber=" + receiptNumber + ", subject=" + subject + ", closedOn=" + closedOn
				+ ", closingRemarks=" + closingRemarks + "]";
	}

	public ClosedReceiptDTO(long closedReceiptId, long receiptId, String nature, String receiptNumber, String subject,
			Date closedOn, String closingRemarks) {
		super();
		this.closedReceiptId = closedReceiptId;
		this.receiptId = receiptId;
		this.nature = nature;
		this.receiptNumber = receiptNumber;
		this.subject = subject;
		this.closedOn = closedOn;
		this.closingRemarks = closingRemarks;
	}

	public long getClosedReceiptId() {
		return closedReceiptId;
	}

	public void setClosedReceiptId(long closedReceiptId) {
		this.closedReceiptId = closedReceiptId;
	}

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
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

	public Date getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}

	public String getClosingRemarks() {
		return closingRemarks;
	}

	public void setClosingRemarks(String closingRemarks) {
		this.closingRemarks = closingRemarks;
	}

}
