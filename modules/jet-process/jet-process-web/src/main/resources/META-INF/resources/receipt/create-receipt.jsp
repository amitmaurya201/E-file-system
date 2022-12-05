<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="../init.jsp"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file="/common/common.jsp"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<style>
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
	ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
	String setURl = serviceContext.getPortalURL();

	/* for current date*/
	DateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
%>
<portlet:renderURL var="createdListReceipt">
	<portlet:param name="mvcRenderCommandName" value="/createdListReceipt" />
</portlet:renderURL>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10 border border-dark"
		style="border: 2px solid #a19c9c;">
		<div>
			<h2 style="text-align: center; text-decoration: underline;">
				<liferay-ui:message key="receipt-create-heading" />
			</h2>
		</div>
		<div class=" receipt" style="border: 2px solid #a19c9c">
			<aui:container cssClass="row">
				<aui:form cssClass="col">
					<div id="targetDiv" class="targetDiv">
						<aui:input id="document" label="" name="document" type="file"
							style="float: left; width: 200px;">
							<aui:validator name="required" />
							<aui:validator name="acceptFiles"
								errorMessage="error-receipt-upload-message"></aui:validator>
						</aui:input>
						<button class="btn" id="removeFileUpload"
							style="font-size: 15px; margin: 1px; float: left;">
							<i class="fa fa-close"></i>
						</button>
					</div>
				</aui:form>
				<aui:form cssClass="scroll border border-dark col"
					name="receiptForm" id="receiptForm">

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
									value="<%=currentDate.format(new Date())%>" disabled="true" />
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-nature" /><span
									class='text-danger'>*</span></label>
								<aui:select label="" name="nature" id="nature">
									<aui:option value="Electronic">
										<liferay-ui:message key="receipt-nature-option1" />
									</aui:option>
									<aui:option value="Physical">
										<liferay-ui:message key="receipt-nature-option2" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-type" /><span
									class='text-danger'>*</span></label>
								<aui:select label="" name="typeId" id="typeId">
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
										key="label-receipt-delivery-mode" /><span class='text-danger'>*</span></label>
								<aui:select label="" name="deliveryModeId" id="deliveryModeId">
									<aui:option value="">
										<liferay-ui:message key="receipt-default-option" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-letter-date" /></label>
								
								<aui:input type="text" label="" name="letterDate"
									id="letterDate" placeholder="dd-mm-yyyy" >
									<aui:icon cssClass="fas fa-calendar-alt date-icon"></aui:icon>
									<aui:validator name="custom"
										errorMessage="error-receipt-letter-date-message">
											function(val){
											var created = (document.getElementById("<portlet:namespace />createdOn").value);
											var date=new Date(val);
											var today = new Date();
											console.log(date);
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
									id="receivedOn" placeholder="dd-mm-yyyy">
									<aui:icon cssClass="fas fa-calendar-alt date-icon"></aui:icon>
									<aui:validator name="required" />
									<aui:validator name="custom"
										errorMessage="error-receipt-received-on-message1">
											function(val){
												var letterDate = (document.getElementById("<portlet:namespace />letterDate").value);
												return (letterDate <= val);
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
								<aui:input label="" name="referenceNumber" id="referenceNumber" />
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-mode-no" /></label>
								<aui:input label="" name="modeNumber" id="modeNumber" />
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
									<aui:option value='0'>
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
								<aui:input label="" name="name" id="name">
									<aui:validator name="required" />
								</aui:input>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-designation" /><span class='text-danger'>*</span></label>
								<aui:input label="" name="designation" id="designation">
									<aui:validator name="required" />
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-mobile" /></label>
								<aui:input label="" name="mobile" id="mobile">
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
								<aui:input label="" name="email" id="email">
									<aui:validator name=""></aui:validator>
									<aui:validator name="custom"
										errorMessage="error-receipt-email-message">
											function(val){
												var regex=new RegExp(/^(.+)@(.+)$/);
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
								<aui:input type="textarea" label="" name="address" id="address">
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
									<aui:option value='0'>
										<liferay-ui:message key="receipt-default-option" />
									</aui:option>
								</aui:select>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-state" /></label>
								<aui:select label="" name="stateId" id="stateId">
									<aui:option value='0'>
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
								<aui:input label="" name="city" id="city" />
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-pincode" /></label>
								<aui:input label="" name="pinCode" id="pinCode">
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
									<aui:option value='0'>
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
								<aui:input type="textarea" label="" name="subject" id="subject">
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
								<aui:input label="" name="remarks" id="remarks" />
							</div>
						</aui:col>
					</aui:row>
					<%--	Action Buttons--%>
					<aui:button-row>
						<aui:button cssClass="btn btn-primary button" type="submit"
							name="generate" value="receipt-submit-button"  />
					</aui:button-row>
				</aui:form>
			</aui:container>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		setUserPostId();
	});
</script>
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