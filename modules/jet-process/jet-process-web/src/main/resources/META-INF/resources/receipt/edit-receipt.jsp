<%@ include file="../init.jsp"%>
<%@page import="io.jetprocess.model.Receipt"%>
<%@page import="java.util.TimeZone"%>
<%@page
	import="io.jetprocess.masterdata.service.MasterdataLocalServiceUtil"%>
<%@page import="io.jetprocess.service.ReceiptLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file="/common/common.jsp"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<style>
input[type='file'] {
	color: rgba(0, 0, 0, 0)
}

.date-icon{
            position: absolute;
            right: 5px;
           /* bottom: 14px; */
           margin-top: 15px;
           z-index: 9;
           }
   &.date-input-width{
              width: 48%;
    }
</style>
<%
	Receipt receipt = (Receipt) session.getAttribute("receipt");
	ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
	String setURl = serviceContext.getPortalURL();
	SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
	simpleFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
%>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/receipt/receipt-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="edit" />
			<%-- <liferay-util:param name="userPostId" value="${id}" /> --%>
		</liferay-util:include>
		<div>
			<h2 style="text-align: center; text-decoration: underline;">
				<liferay-ui:message key="receipt-edit-heading" />
			</h2>
		</div>
		<div class="border border-dark m-1 receipt">
			<aui:container cssClass="row">
				<aui:form cssClass="col-6">
					<aui:col cssClass="border ">
						<button class="btn text-danger" id="removeFileUpload">
								<liferay-ui:message key="receipt-remove-button" />
							</button>
						<div id="targetDiv" class="targetDiv text-center">
							
							
							
						
							<div class="dropzone-wrapper" style="display:none">
							<i class="glyphicon glyphicon-download-alt"></i>
               				 	<p><liferay-ui:message key="label-receipt-pdf-drag" /></p>
               					 <span class="btn btn-info" style="font-size:15px;" id="doc-select-btn"><liferay-ui:message key="label-receipt-pdf-file" /></span>
								<input name="doc-input" id="doc-input" type="file" hidden />
								
								</div> 

							<embed id="editpdfurl" type="application/pdf"
								src="${receipt.viewPdfUrl}" width="100%" height="450">
						</div>
					</aui:col>
				</aui:form>
				<aui:form cssClass="scroll border border-dark col-6"
					name="receiptForm" id="receiptForm">
					<aui:input name="receiptId" id="receiptId" type="hidden"
						value="${receipt.receiptId}" />
					<div class="border heading">
						<h4>
							<aui:icon cssClass="fas fa-file-alt icon" />
							<liferay-ui:message key="label-receipt-diary-details" />
						</h4>
					</div>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-createdon" /></label>
								<aui:input label="" name="createdOn" id="createdOn"
									value="<%=simpleFormat.format(receipt.getCreateDate())%>"
									disabled="true" />
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-nature" /></label>
								<aui:input label="" name="nature" id="nature"
									value="${receipt.nature}" disabled="true" />
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-type" /><span
									class='text-danger'>*</span></label>
								<aui:select label="" name="typeId" id="typeId">
									<c:if test="${receipt.typeId != null}">
										<aui:option value="${receipt.typeId}">${typeValue}</aui:option>
									</c:if>
									<aui:option value="">
										<liferay-ui:message key="receipt-deafult-option" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-delivery-mode" /><span class='text-danger'>*</span></label>
								<aui:input label="" name="deliveryModeId" id="deliveryModeId"
									value="${deliveryModeValue}" disabled="true" />
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-letter-date" /></label>
								<aui:input type="text" label="" name="letterDate"
									id="letterDate" value="${receipt.letterDate}"placeholder="dd-mm-yyyy">
									<aui:icon cssClass="fas fa-calendar-alt date-icon"></aui:icon>
									<aui:validator name="custom"
										errorMessage="error-receipt-letter-date-message">
											function(val){
												var date=new Date(val);
												var today = new Date();
												return (today > date);
											}
										</aui:validator>
								</aui:input>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-received-on" /><span class='text-danger'>*</span></label>
								<aui:input type="text" label="" name="receivedOn"
									id="receivedOn" value="${receipt.receivedOn}"placeholder="dd-mm-yyyy">
									<aui:icon cssClass="fas fa-calendar-alt date-icon"></aui:icon>
									<aui:validator name="required" />
									<aui:validator name="custom"
										errorMessage="error-receipt-received-on-message1">
											function(val){
												var letterDate = (document.getElementById("<portlet:namespace />letterDate").value);
												var letterDateFmt=new Date(letterDate);
												var valFrt=new Date(val);	
												return (letterDateFmt <= valFrt);
											}
										</aui:validator>
									<aui:validator name="custom"
										errorMessage="error-receipt-received-on-message2">
											function(val){
												var date=new Date(val);
												var today = new Date();
												return (today > date);
											}
										</aui:validator>
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-reference-no" /></label>
								<aui:input label="" name="referenceNumber" id="referenceNumber"
									value="${receipt.referenceNumber}" />
								<aui:input label="" name="dmFileId" id="dmFileId"
									value="${receipt.dmFileId}" type="hidden" />
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-mode-no" /></label>
								<aui:input label="" name="modeNumber" id="modeNumber"
									value="${receipt.modeNumber}" />
							</div>
						</aui:col>
					</aui:row>
					<div class="border heading">
						<h4>
							<aui:icon cssClass="fas fa-envelope icon" />
							<liferay-ui:message key="label-receipt-sender-details" />
						</h4>
					</div>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-organization" /><span class='text-danger'>*</span></label>
								<aui:select label="" name="organizationId" id="organizationId">
									<c:if test="${receipt.organizationId != null}">
										<aui:option value="${receipt.organizationId}">${organizationValue}</aui:option>
									</c:if>
									<aui:option value="">
										<liferay-ui:message key="receipt-default-option" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-sub-organization" /></label>
								<aui:select label="" name="subOrganizationId"
									id="subOrganizationId">
									<c:if test="${receipt.subOrganizationId != null}">
										<aui:option value="${receipt.subOrganizationId}">${subOrganizationValue}</aui:option>
									</c:if>
									<aui:option value="">
										<liferay-ui:message key="receipt-default-option" />
									</aui:option>
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-name" /><span
									class='text-danger'>*</span></label>
								<aui:input label="" name="name" id="name"
									value="${receipt.name}">
									<aui:validator name="required" />
								</aui:input>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-designation" /><span class='text-danger'>*</span></label>
								<aui:input label="" name="designation" id="designation"
									value="${receipt.designation}">
									<aui:validator name="required" />
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-mobile" /></label>
								<aui:input label="" name="mobile" id="mobile"
									value="${receipt.mobile}">
									<aui:validator name="custom"
										errorMessage="error-receipt-mobile-message">
											function(val){
												var regex=new RegExp(/^[0-9]{10}$/);
												return regex.test(val);
											}
										</aui:validator>
								</aui:input>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-email" /></label>
								<aui:input label="" name="email" id="email"
									value="${receipt.email}">
									<aui:validator name=""></aui:validator>
									<aui:validator name="custom"
										errorMessage="error-receipt-email-message">
											function(val){
												var regex=new RegExp(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
												return regex.test(val);
											}
										</aui:validator>
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-address" /><span
									class='text-danger'>*</span></label>
								<aui:input type="textarea" label="" name="address" id="address"
									value="${receipt.address}">
									<aui:validator name="required" />
									<aui:validator name="maxLength">
										<liferay-ui:message key="receipt-address-maxlength" />
									</aui:validator>
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-country" /></label>
								<aui:select label="" name="countryId" id="countryId">
									<c:if test="${receipt.countryId != null}">
										<aui:option value="${receipt.countryId}">${countryValue}</aui:option>
									</c:if>
									<aui:option value="">
										<liferay-ui:message key="receipt-default-option" />
									</aui:option>
								</aui:select>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-state" /></label>
								<aui:select label="" name="stateId" id="stateId">
									<c:if test="${receipt.stateId != null}">
										<aui:option value="${receipt.stateId}">${stateValue}</aui:option>
									</c:if>
									<aui:option value="">
										<liferay-ui:message key="receipt-default-option" />
									</aui:option>
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-city" /></label>
								<aui:input label="" name="city" id="city"
									value="${receipt.city}" />
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-pincode" /></label>
								<aui:input label="" name="pinCode" id="pinCode"
									value="${receipt.pinCode}">
									<aui:validator name="maxLength">
										<liferay-ui:message key="receipt-pincode-maxlength" />
									</aui:validator>
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<div class="border heading">
						<h4>
							<aui:icon cssClass="fas fa-receipt icon" />
							<liferay-ui:message key="label-receipt-receipt-details" />
						</h4>
					</div>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-category" /><span
									class='text-danger'>*</span></label>
								<aui:select label="" name="receiptCategoryId"
									id="receiptCategoryId">
									<c:if test="${receipt.receiptCategoryId != null}">
										<aui:option value="${receipt.receiptCategoryId}">${receiptCategoryValue}</aui:option>
									</c:if>
									<aui:option value="">
										<liferay-ui:message key="receipt-default-option" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-sub-category" /></label>
								<aui:select label="" name="receiptSubCategoryId"
									id="receiptSubCategoryId">
									<c:if test="${receipt.receiptSubCategoryId != null}">
										<aui:option value="${receipt.receiptSubCategoryId}">${receiptSubCategoryValue}</aui:option>
									</c:if>
									<aui:option value="">
										<liferay-ui:message key="receipt-default-option" />
									</aui:option>
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-subject" /><span
									class='text-danger'>*</span></label>
								<aui:input type="textarea" label="" name="subject" id="subject"
									value="${receipt.subject}">
									<aui:validator name="required" />
									<aui:validator name="maxLength">
										<liferay-ui:message key="receipt-subject-maxlength" />
									</aui:validator>
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-remark" /></label>
								<aui:input label="" name="remarks" id="remarks"
									value="${receipt.remarks}" />
							</div>
						</aui:col>
					</aui:row>

					<%--	Action Buttons--%>
					<aui:button-row>
						<aui:button cssClass="btn btn-primary button" type="submit"
							name="update" value="receipt-edit-button" />
					</aui:button-row>
				</aui:form>
			</aui:container>

		</div>
	</div>
</div>

<script type="text/javascript">



$(document).ready(function() {
	$("#<portlet:namespace/>letterDate").datepicker({
		format : 'dd-M-yyyy'		
	});

	 $("#<portlet:namespace/>receivedOn").datepicker({
		format : 'dd-M-yyyy'
	});

});
</script>
<%@ include file="/js/receipt.js"%>