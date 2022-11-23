package jet.process.rs.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Admin
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Contains all the data for receipt creation.",
	value = "ReceiptRsModel"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ReceiptRsModel")
public class ReceiptRsModel implements Serializable {

	public static ReceiptRsModel toDTO(String json) {
		return ObjectMapperUtil.readValue(ReceiptRsModel.class, json);
	}

	public static ReceiptRsModel unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(ReceiptRsModel.class, json);
	}

	@Schema
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonIgnore
	public void setAddress(
		UnsafeSupplier<String, Exception> addressUnsafeSupplier) {

		try {
			address = addressUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String address;

	@Schema
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonIgnore
	public void setCity(UnsafeSupplier<String, Exception> cityUnsafeSupplier) {
		try {
			city = cityUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String city;

	@Schema
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@JsonIgnore
	public void setCountryId(
		UnsafeSupplier<Long, Exception> countryIdUnsafeSupplier) {

		try {
			countryId = countryIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long countryId;

	@Schema
	public String getCountryvalue() {
		return countryvalue;
	}

	public void setCountryvalue(String countryvalue) {
		this.countryvalue = countryvalue;
	}

	@JsonIgnore
	public void setCountryvalue(
		UnsafeSupplier<String, Exception> countryvalueUnsafeSupplier) {

		try {
			countryvalue = countryvalueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String countryvalue;

	@Schema
	public Long getDeliveryModeId() {
		return deliveryModeId;
	}

	public void setDeliveryModeId(Long deliveryModeId) {
		this.deliveryModeId = deliveryModeId;
	}

	@JsonIgnore
	public void setDeliveryModeId(
		UnsafeSupplier<Long, Exception> deliveryModeIdUnsafeSupplier) {

		try {
			deliveryModeId = deliveryModeIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long deliveryModeId;

	@Schema
	public String getDeliverymodevalue() {
		return deliverymodevalue;
	}

	public void setDeliverymodevalue(String deliverymodevalue) {
		this.deliverymodevalue = deliverymodevalue;
	}

	@JsonIgnore
	public void setDeliverymodevalue(
		UnsafeSupplier<String, Exception> deliverymodevalueUnsafeSupplier) {

		try {
			deliverymodevalue = deliverymodevalueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String deliverymodevalue;

	@Schema
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@JsonIgnore
	public void setDesignation(
		UnsafeSupplier<String, Exception> designationUnsafeSupplier) {

		try {
			designation = designationUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String designation;

	@Schema
	public Long getDmFileId() {
		return dmFileId;
	}

	public void setDmFileId(Long dmFileId) {
		this.dmFileId = dmFileId;
	}

	@JsonIgnore
	public void setDmFileId(
		UnsafeSupplier<Long, Exception> dmFileIdUnsafeSupplier) {

		try {
			dmFileId = dmFileIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long dmFileId;

	@Schema
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String email;

	@Schema
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@JsonIgnore
	public void setGroupId(
		UnsafeSupplier<Long, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long groupId;

	@Schema
	public String getLetterDate() {
		return letterDate;
	}

	public void setLetterDate(String letterDate) {
		this.letterDate = letterDate;
	}

	@JsonIgnore
	public void setLetterDate(
		UnsafeSupplier<String, Exception> letterDateUnsafeSupplier) {

		try {
			letterDate = letterDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String letterDate;

	@Schema
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@JsonIgnore
	public void setMobile(
		UnsafeSupplier<String, Exception> mobileUnsafeSupplier) {

		try {
			mobile = mobileUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String mobile;

	@Schema
	public String getModeNumber() {
		return modeNumber;
	}

	public void setModeNumber(String modeNumber) {
		this.modeNumber = modeNumber;
	}

	@JsonIgnore
	public void setModeNumber(
		UnsafeSupplier<String, Exception> modeNumberUnsafeSupplier) {

		try {
			modeNumber = modeNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String modeNumber;

	@Schema
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

	@Schema
	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@JsonIgnore
	public void setOrganizationId(
		UnsafeSupplier<Long, Exception> organizationIdUnsafeSupplier) {

		try {
			organizationId = organizationIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long organizationId;

	@Schema
	public String getOrganizationvalue() {
		return organizationvalue;
	}

	public void setOrganizationvalue(String organizationvalue) {
		this.organizationvalue = organizationvalue;
	}

	@JsonIgnore
	public void setOrganizationvalue(
		UnsafeSupplier<String, Exception> organizationvalueUnsafeSupplier) {

		try {
			organizationvalue = organizationvalueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String organizationvalue;

	@Schema
	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@JsonIgnore
	public void setPinCode(
		UnsafeSupplier<String, Exception> pinCodeUnsafeSupplier) {

		try {
			pinCode = pinCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String pinCode;

	@Schema
	public Long getReceiptCategoryId() {
		return receiptCategoryId;
	}

	public void setReceiptCategoryId(Long receiptCategoryId) {
		this.receiptCategoryId = receiptCategoryId;
	}

	@JsonIgnore
	public void setReceiptCategoryId(
		UnsafeSupplier<Long, Exception> receiptCategoryIdUnsafeSupplier) {

		try {
			receiptCategoryId = receiptCategoryIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long receiptCategoryId;

	@Schema
	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	@JsonIgnore
	public void setReceiptId(
		UnsafeSupplier<Long, Exception> receiptIdUnsafeSupplier) {

		try {
			receiptId = receiptIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long receiptId;

	@Schema
	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	@JsonIgnore
	public void setReceiptNumber(
		UnsafeSupplier<String, Exception> receiptNumberUnsafeSupplier) {

		try {
			receiptNumber = receiptNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String receiptNumber;

	@Schema
	public Long getReceiptSubCategoryId() {
		return receiptSubCategoryId;
	}

	public void setReceiptSubCategoryId(Long receiptSubCategoryId) {
		this.receiptSubCategoryId = receiptSubCategoryId;
	}

	@JsonIgnore
	public void setReceiptSubCategoryId(
		UnsafeSupplier<Long, Exception> receiptSubCategoryIdUnsafeSupplier) {

		try {
			receiptSubCategoryId = receiptSubCategoryIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long receiptSubCategoryId;

	@Schema
	public String getReceiptcategoryvalue() {
		return receiptcategoryvalue;
	}

	public void setReceiptcategoryvalue(String receiptcategoryvalue) {
		this.receiptcategoryvalue = receiptcategoryvalue;
	}

	@JsonIgnore
	public void setReceiptcategoryvalue(
		UnsafeSupplier<String, Exception> receiptcategoryvalueUnsafeSupplier) {

		try {
			receiptcategoryvalue = receiptcategoryvalueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String receiptcategoryvalue;

	@Schema
	public String getReceiptsubcategoryvalue() {
		return receiptsubcategoryvalue;
	}

	public void setReceiptsubcategoryvalue(String receiptsubcategoryvalue) {
		this.receiptsubcategoryvalue = receiptsubcategoryvalue;
	}

	@JsonIgnore
	public void setReceiptsubcategoryvalue(
		UnsafeSupplier<String, Exception>
			receiptsubcategoryvalueUnsafeSupplier) {

		try {
			receiptsubcategoryvalue =
				receiptsubcategoryvalueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String receiptsubcategoryvalue;

	@Schema
	public String getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(String receivedOn) {
		this.receivedOn = receivedOn;
	}

	@JsonIgnore
	public void setReceivedOn(
		UnsafeSupplier<String, Exception> receivedOnUnsafeSupplier) {

		try {
			receivedOn = receivedOnUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String receivedOn;

	@Schema
	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@JsonIgnore
	public void setReferenceNumber(
		UnsafeSupplier<String, Exception> referenceNumberUnsafeSupplier) {

		try {
			referenceNumber = referenceNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String referenceNumber;

	@Schema
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@JsonIgnore
	public void setRemarks(
		UnsafeSupplier<String, Exception> remarksUnsafeSupplier) {

		try {
			remarks = remarksUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String remarks;

	@Schema
	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	@JsonIgnore
	public void setStateId(
		UnsafeSupplier<Long, Exception> stateIdUnsafeSupplier) {

		try {
			stateId = stateIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long stateId;

	@Schema
	public String getStatevalue() {
		return statevalue;
	}

	public void setStatevalue(String statevalue) {
		this.statevalue = statevalue;
	}

	@JsonIgnore
	public void setStatevalue(
		UnsafeSupplier<String, Exception> statevalueUnsafeSupplier) {

		try {
			statevalue = statevalueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String statevalue;

	@Schema
	public Long getSubOrganizationId() {
		return subOrganizationId;
	}

	public void setSubOrganizationId(Long subOrganizationId) {
		this.subOrganizationId = subOrganizationId;
	}

	@JsonIgnore
	public void setSubOrganizationId(
		UnsafeSupplier<Long, Exception> subOrganizationIdUnsafeSupplier) {

		try {
			subOrganizationId = subOrganizationIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long subOrganizationId;

	@Schema
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@JsonIgnore
	public void setSubject(
		UnsafeSupplier<String, Exception> subjectUnsafeSupplier) {

		try {
			subject = subjectUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String subject;

	@Schema
	public String getSuborganizationvalue() {
		return suborganizationvalue;
	}

	public void setSuborganizationvalue(String suborganizationvalue) {
		this.suborganizationvalue = suborganizationvalue;
	}

	@JsonIgnore
	public void setSuborganizationvalue(
		UnsafeSupplier<String, Exception> suborganizationvalueUnsafeSupplier) {

		try {
			suborganizationvalue = suborganizationvalueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String suborganizationvalue;

	@Schema
	public Long getTempFileId() {
		return tempFileId;
	}

	public void setTempFileId(Long tempFileId) {
		this.tempFileId = tempFileId;
	}

	@JsonIgnore
	public void setTempFileId(
		UnsafeSupplier<Long, Exception> tempFileIdUnsafeSupplier) {

		try {
			tempFileId = tempFileIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long tempFileId;

	@Schema
	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	@JsonIgnore
	public void setTypeId(
		UnsafeSupplier<Long, Exception> typeIdUnsafeSupplier) {

		try {
			typeId = typeIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long typeId;

	@Schema
	public String getTypevalue() {
		return typevalue;
	}

	public void setTypevalue(String typevalue) {
		this.typevalue = typevalue;
	}

	@JsonIgnore
	public void setTypevalue(
		UnsafeSupplier<String, Exception> typevalueUnsafeSupplier) {

		try {
			typevalue = typevalueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String typevalue;

	@Schema
	public Long getUserPostId() {
		return userPostId;
	}

	public void setUserPostId(Long userPostId) {
		this.userPostId = userPostId;
	}

	@JsonIgnore
	public void setUserPostId(
		UnsafeSupplier<Long, Exception> userPostIdUnsafeSupplier) {

		try {
			userPostId = userPostIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long userPostId;

	@Schema
	public String getViewPdfUrl() {
		return viewPdfUrl;
	}

	public void setViewPdfUrl(String viewPdfUrl) {
		this.viewPdfUrl = viewPdfUrl;
	}

	@JsonIgnore
	public void setViewPdfUrl(
		UnsafeSupplier<String, Exception> viewPdfUrlUnsafeSupplier) {

		try {
			viewPdfUrl = viewPdfUrlUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String viewPdfUrl;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (address != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(address));

			sb.append("\"");
		}

		if (city != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(city));

			sb.append("\"");
		}

		if (countryId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"countryId\": ");

			sb.append(countryId);
		}

		if (countryvalue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"countryvalue\": ");

			sb.append("\"");

			sb.append(_escape(countryvalue));

			sb.append("\"");
		}

		if (deliveryModeId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"deliveryModeId\": ");

			sb.append(deliveryModeId);
		}

		if (deliverymodevalue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"deliverymodevalue\": ");

			sb.append("\"");

			sb.append(_escape(deliverymodevalue));

			sb.append("\"");
		}

		if (designation != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"designation\": ");

			sb.append("\"");

			sb.append(_escape(designation));

			sb.append("\"");
		}

		if (dmFileId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dmFileId\": ");

			sb.append(dmFileId);
		}

		if (email != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(email));

			sb.append("\"");
		}

		if (groupId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(groupId);
		}

		if (letterDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"letterDate\": ");

			sb.append("\"");

			sb.append(_escape(letterDate));

			sb.append("\"");
		}

		if (mobile != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mobile\": ");

			sb.append("\"");

			sb.append(_escape(mobile));

			sb.append("\"");
		}

		if (modeNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modeNumber\": ");

			sb.append("\"");

			sb.append(_escape(modeNumber));

			sb.append("\"");
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (organizationId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"organizationId\": ");

			sb.append(organizationId);
		}

		if (organizationvalue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"organizationvalue\": ");

			sb.append("\"");

			sb.append(_escape(organizationvalue));

			sb.append("\"");
		}

		if (pinCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pinCode\": ");

			sb.append("\"");

			sb.append(_escape(pinCode));

			sb.append("\"");
		}

		if (receiptCategoryId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiptCategoryId\": ");

			sb.append(receiptCategoryId);
		}

		if (receiptId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiptId\": ");

			sb.append(receiptId);
		}

		if (receiptNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiptNumber\": ");

			sb.append("\"");

			sb.append(_escape(receiptNumber));

			sb.append("\"");
		}

		if (receiptSubCategoryId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiptSubCategoryId\": ");

			sb.append(receiptSubCategoryId);
		}

		if (receiptcategoryvalue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiptcategoryvalue\": ");

			sb.append("\"");

			sb.append(_escape(receiptcategoryvalue));

			sb.append("\"");
		}

		if (receiptsubcategoryvalue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiptsubcategoryvalue\": ");

			sb.append("\"");

			sb.append(_escape(receiptsubcategoryvalue));

			sb.append("\"");
		}

		if (receivedOn != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receivedOn\": ");

			sb.append("\"");

			sb.append(_escape(receivedOn));

			sb.append("\"");
		}

		if (referenceNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"referenceNumber\": ");

			sb.append("\"");

			sb.append(_escape(referenceNumber));

			sb.append("\"");
		}

		if (remarks != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"remarks\": ");

			sb.append("\"");

			sb.append(_escape(remarks));

			sb.append("\"");
		}

		if (stateId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stateId\": ");

			sb.append(stateId);
		}

		if (statevalue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statevalue\": ");

			sb.append("\"");

			sb.append(_escape(statevalue));

			sb.append("\"");
		}

		if (subOrganizationId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subOrganizationId\": ");

			sb.append(subOrganizationId);
		}

		if (subject != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subject\": ");

			sb.append("\"");

			sb.append(_escape(subject));

			sb.append("\"");
		}

		if (suborganizationvalue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"suborganizationvalue\": ");

			sb.append("\"");

			sb.append(_escape(suborganizationvalue));

			sb.append("\"");
		}

		if (tempFileId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tempFileId\": ");

			sb.append(tempFileId);
		}

		if (typeId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeId\": ");

			sb.append(typeId);
		}

		if (typevalue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typevalue\": ");

			sb.append("\"");

			sb.append(_escape(typevalue));

			sb.append("\"");
		}

		if (userPostId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userPostId\": ");

			sb.append(userPostId);
		}

		if (viewPdfUrl != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"viewPdfUrl\": ");

			sb.append("\"");

			sb.append(_escape(viewPdfUrl));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "jet.process.rs.dto.v1_0.ReceiptRsModel",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}