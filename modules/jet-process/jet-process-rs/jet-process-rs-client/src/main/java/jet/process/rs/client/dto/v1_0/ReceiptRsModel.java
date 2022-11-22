package jet.process.rs.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import jet.process.rs.client.function.UnsafeSupplier;
import jet.process.rs.client.serdes.v1_0.ReceiptRsModelSerDes;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class ReceiptRsModel implements Cloneable, Serializable {

	public static ReceiptRsModel toDTO(String json) {
		return ReceiptRsModelSerDes.toDTO(json);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddress(
		UnsafeSupplier<String, Exception> addressUnsafeSupplier) {

		try {
			address = addressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String address;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCity(UnsafeSupplier<String, Exception> cityUnsafeSupplier) {
		try {
			city = cityUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String city;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public void setCountryId(
		UnsafeSupplier<Long, Exception> countryIdUnsafeSupplier) {

		try {
			countryId = countryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long countryId;

	public Long getDeliveryModeId() {
		return deliveryModeId;
	}

	public void setDeliveryModeId(Long deliveryModeId) {
		this.deliveryModeId = deliveryModeId;
	}

	public void setDeliveryModeId(
		UnsafeSupplier<Long, Exception> deliveryModeIdUnsafeSupplier) {

		try {
			deliveryModeId = deliveryModeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long deliveryModeId;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setDesignation(
		UnsafeSupplier<String, Exception> designationUnsafeSupplier) {

		try {
			designation = designationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String designation;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String email;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public void setGroupId(
		UnsafeSupplier<Long, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long groupId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public String getLetterDate() {
		return letterDate;
	}

	public void setLetterDate(String letterDate) {
		this.letterDate = letterDate;
	}

	public void setLetterDate(
		UnsafeSupplier<String, Exception> letterDateUnsafeSupplier) {

		try {
			letterDate = letterDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String letterDate;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setMobile(
		UnsafeSupplier<String, Exception> mobileUnsafeSupplier) {

		try {
			mobile = mobileUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String mobile;

	public String getModeNumber() {
		return modeNumber;
	}

	public void setModeNumber(String modeNumber) {
		this.modeNumber = modeNumber;
	}

	public void setModeNumber(
		UnsafeSupplier<String, Exception> modeNumberUnsafeSupplier) {

		try {
			modeNumber = modeNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String modeNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public void setOrganizationId(
		UnsafeSupplier<Long, Exception> organizationIdUnsafeSupplier) {

		try {
			organizationId = organizationIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long organizationId;

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public void setPinCode(
		UnsafeSupplier<String, Exception> pinCodeUnsafeSupplier) {

		try {
			pinCode = pinCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String pinCode;

	public Long getReceiptCategoryId() {
		return receiptCategoryId;
	}

	public void setReceiptCategoryId(Long receiptCategoryId) {
		this.receiptCategoryId = receiptCategoryId;
	}

	public void setReceiptCategoryId(
		UnsafeSupplier<Long, Exception> receiptCategoryIdUnsafeSupplier) {

		try {
			receiptCategoryId = receiptCategoryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long receiptCategoryId;

	public Long getReceiptSubCategoryId() {
		return receiptSubCategoryId;
	}

	public void setReceiptSubCategoryId(Long receiptSubCategoryId) {
		this.receiptSubCategoryId = receiptSubCategoryId;
	}

	public void setReceiptSubCategoryId(
		UnsafeSupplier<Long, Exception> receiptSubCategoryIdUnsafeSupplier) {

		try {
			receiptSubCategoryId = receiptSubCategoryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long receiptSubCategoryId;

	public String getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(String receivedOn) {
		this.receivedOn = receivedOn;
	}

	public void setReceivedOn(
		UnsafeSupplier<String, Exception> receivedOnUnsafeSupplier) {

		try {
			receivedOn = receivedOnUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String receivedOn;

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public void setReferenceNumber(
		UnsafeSupplier<String, Exception> referenceNumberUnsafeSupplier) {

		try {
			referenceNumber = referenceNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String referenceNumber;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setRemarks(
		UnsafeSupplier<String, Exception> remarksUnsafeSupplier) {

		try {
			remarks = remarksUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String remarks;

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public void setStateId(
		UnsafeSupplier<Long, Exception> stateIdUnsafeSupplier) {

		try {
			stateId = stateIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long stateId;

	public Long getSubOrganizationId() {
		return subOrganizationId;
	}

	public void setSubOrganizationId(Long subOrganizationId) {
		this.subOrganizationId = subOrganizationId;
	}

	public void setSubOrganizationId(
		UnsafeSupplier<Long, Exception> subOrganizationIdUnsafeSupplier) {

		try {
			subOrganizationId = subOrganizationIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long subOrganizationId;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setSubject(
		UnsafeSupplier<String, Exception> subjectUnsafeSupplier) {

		try {
			subject = subjectUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String subject;

	public Long getTempFileId() {
		return tempFileId;
	}

	public void setTempFileId(Long tempFileId) {
		this.tempFileId = tempFileId;
	}

	public void setTempFileId(
		UnsafeSupplier<Long, Exception> tempFileIdUnsafeSupplier) {

		try {
			tempFileId = tempFileIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long tempFileId;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public void setTypeId(
		UnsafeSupplier<Long, Exception> typeIdUnsafeSupplier) {

		try {
			typeId = typeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long typeId;

	public Long getUserPostId() {
		return userPostId;
	}

	public void setUserPostId(Long userPostId) {
		this.userPostId = userPostId;
	}

	public void setUserPostId(
		UnsafeSupplier<Long, Exception> userPostIdUnsafeSupplier) {

		try {
			userPostId = userPostIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long userPostId;

	public String getViewPdfUrl() {
		return viewPdfUrl;
	}

	public void setViewPdfUrl(String viewPdfUrl) {
		this.viewPdfUrl = viewPdfUrl;
	}

	public void setViewPdfUrl(
		UnsafeSupplier<String, Exception> viewPdfUrlUnsafeSupplier) {

		try {
			viewPdfUrl = viewPdfUrlUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String viewPdfUrl;

	@Override
	public ReceiptRsModel clone() throws CloneNotSupportedException {
		return (ReceiptRsModel)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ReceiptRsModel)) {
			return false;
		}

		ReceiptRsModel receiptRsModel = (ReceiptRsModel)object;

		return Objects.equals(toString(), receiptRsModel.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ReceiptRsModelSerDes.toJSON(this);
	}

}