<%@ include file="../init.jsp"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">

<%
	ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
	String setURl = serviceContext.getPortalURL();
%>
<portlet:renderURL var="createdListReceipt">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_RECEIPT_LIST_RENDER_COMMAND%>" />
</portlet:renderURL>

<portlet:renderURL var="editReceipt">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.EDIT_RECEIPT_RENDER_COMMAND%>" />
	<portlet:param name="receiptId" value="${receipt.receiptId}" />
</portlet:renderURL>

<style>
<!--
.datepicker {
	overflow: hidden;
}

.datepicker-days .table-condensed {
	width: 100%;
}

.datepicker-days .table-condensed tr {
	border: 1px solid black;
}

.datepicker-days .table-condensed td {
	border: 1px solid black;
}
-->
</style>

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
				<aui:form id="dropfile" cssClass="col-6 p-2 ">
					<aui:row>
						<aui:col cssClass="border  ">
							<button class="btn text-danger" id="removeFileUpload"
								style="display: none">
								<liferay-ui:message key="receipt-remove-button" />
							</button>
							<c:set var="removeFlag" value="${true} }"></c:set>
							<div id="targetDiv" class="targetDiv text-center">
								<div class="dropzone-wrapper ">
									<i class="glyphicon glyphicon-download-alt"></i>
									<p>
										<liferay-ui:message key="label-receipt-pdf-drag" />
									</p>
									<span class="btn btn-info" style="font-size: 15px;"
										id="doc-select-btn"><liferay-ui:message
											key="label-receipt-pdf-file" /></span> <input name="doc-input"
										id="doc-input" type="file" hidden accept=".pdf" />
									<p id="error" class="text-danger" style = "display:none">This field is required
									<p>
								</div>
							</div>
						</aui:col>

					</aui:row>
				</aui:form>
				<aui:form cssClass="scroll border border-dark col"
					name="receiptForm">
					<div class="pr-2">
						<div class="border heading">
							<h5>
								<aui:icon cssClass="fas fa-file-alt view_icon mr-1" />
								<liferay-ui:message key="label-receipt-diary-details" />
							</h5>
						</div>

						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-receipt-createdon" /></label>
									<aui:input label="" name="createdOn" id="createdOn"
										disabled="true" />
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message key="label-receipt-nature" /><span
										class='text-danger'>*</span></label>
									<aui:select label="" name="nature" id="nature">
										<aui:option value="">
											<liferay-ui:message key="receipt-default-option" />
										</aui:option>
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
											key="label-receipt-delivery-mode" /><span
										class='text-danger'>*</span></label>
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
										id="letterDate" placeholder="dd/mm/yyyy" >
										<aui:validator name="custom"
											errorMessage="error-receipt-letter-date-message">
											function(val){
												let d = val.split("/");
    											let date = new Date(d[2] + '/' + d[1] + '/' + d[0]);		
												var createdOn = (document.getElementById("<portlet:namespace />createdOn").value);
												let createdOnSplit = createdOn.split("/");
    											let createdOnDate = new Date(createdOnSplit[2] + '/' + createdOnSplit[1] + '/' + createdOnSplit[0]);		
												return (createdOnDate >= date);
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
										id="receivedOn" placeholder="dd/mm/yyyy">
										<aui:validator name="required" />
										<aui:validator name="custom"
											errorMessage="error-receipt-received-on-message1">
											function(val){
													var letterDate = (document.getElementById("<portlet:namespace />letterDate").value);
													let letterDateSplit = letterDate.split("/");
    												let letterDateValue = new Date(letterDateSplit[2] + '/' + letterDateSplit[1] + '/' + letterDateSplit[0]);		
													let d = val.split("/");
    												let receivedDate = new Date(d[2] + '/' + d[1] + '/' + d[0]);
													if(letterDate != ""){
														var newLetterDate=new Date(letterDate);
														return (letterDateValue <= receivedDate);
													}
													return "letter date null";
												}
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="error-receipt-received-on-message2">
											function(val){
												let d = val.split("/");
    											let date = new Date(d[2] + '/' + d[1] + '/' + d[0]);		
												var createdOn = (document.getElementById("<portlet:namespace />createdOn").value);
												let createdOnSplit = createdOn.split("/");
    											let createdOnDate = new Date(createdOnSplit[2] + '/' + createdOnSplit[1] + '/' + createdOnSplit[0]);		
												return (createdOnDate >= date);
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
									<aui:input label="" name="referenceNumber" id="referenceNumber">
										<aui:validator name="maxLength">
											<liferay-ui:message key="receipt-input-maxlength" />
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="receipt-input-not-special-char-allowed">
											function(val){
												var regex=new RegExp(/^[a-z\d\-_\s]+$/i);
												return regex.test(val);
											}
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message key="label-receipt-mode-no" /></label>
									<aui:input label="" name="modeNumber" id="modeNumber">
										<aui:validator name="maxLength">
											<liferay-ui:message key="receipt-input-maxlength" />
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="receipt-input-not-special-char-allowed">
											function(val){
												var regex=new RegExp(/^[a-z\d\-_\s]+$/i);
												return regex.test(val);
											}
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<div class="border heading"
							style="padding-right: -20px !important; padding-left: -10px !important;">
							<h5>
								<aui:icon cssClass="fas fa-envelope view_icon mr-1" />
								<liferay-ui:message key="label-receipt-sender-details" />
							</h5>
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
										<aui:validator name="maxLength">
											<liferay-ui:message key="receipt-input-maxlength" />
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="receipt-input-not-special-char-allowed">
											function(val){
												var regex=new RegExp(/^[a-z\d\-_\s]+$/i);
												return regex.test(val);
											}
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-receipt-designation" /><span class='text-danger'>*</span></label>
									<aui:input label="" name="designation" id="designation">
										<aui:validator name="required" />
										<aui:validator name="maxLength">
											<liferay-ui:message key="receipt-input-maxlength" />
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="receipt-input-not-special-char-allowed">
											function(val){
												var regex=new RegExp(/^[a-z\d\-_\s]+$/i);
												return regex.test(val);
											}
										</aui:validator>
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
												var regex=new RegExp(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]+$/);
												return regex.test(val);
											}
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row style="padding-left:15px !important;">
							<aui:col cssClass="mt-3 ">
								<div class="textOnInput">
									<label><liferay-ui:message key="label-receipt-address" /><span
										class='text-danger'>*</span></label>
									<aui:input type="textarea" label="" name="address" id="address"
										style="height:70px;">
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
									<aui:input label="" name="city" id="city">
										<aui:validator name="maxLength">
											<liferay-ui:message key="receipt-input-maxlength" />
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="receipt-input-not-special-char-allowed">
											function(val){
												var regex=new RegExp(/^[a-z\d\-_\s]+$/i);
												return regex.test(val);
											}
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message key="label-receipt-pincode" /></label>
									<aui:input label="" name="pinCode" id="pinCode">
										<aui:validator name="minLength">
											<liferay-ui:message key="receipt-pincode-minlength" />
										</aui:validator>
										<aui:validator name="maxLength">
											<liferay-ui:message key="receipt-pincode-maxlength" />
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="receipt-input-not-special-char-allowed">
											function(val){
												var regex=new RegExp(/^[a-z\d\-_\s]+$/i);
												return regex.test(val);
											}
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<div class="border heading"
							style="padding-right: -20px !important; padding-left: -10px !important;">
							<h5>
								<aui:icon cssClass="fas fa-receipt view_icon mr-1" />
								<liferay-ui:message key="label-receipt-receipt-details" />
							</h5>
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
						<aui:row style="padding-left:15px !important;">
							<aui:col cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message key="label-receipt-subject" /><span
										class='text-danger'>*</span></label>
									<aui:input type="textarea" label="" name="subject" id="subject"
										style="height:70px;">
										<aui:validator name="required" />
										<aui:validator name="maxLength">
											<liferay-ui:message key="receipt-subject-maxlength" />
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row style="padding-left:15px !important;">
							<aui:col cssClass="mt-3 ">
								<div class="textOnInput">
									<label><liferay-ui:message key="label-receipt-remark" /></label>
									<aui:input label="" name="remarks" id="remarks">
										<aui:validator name="maxLength">
											<liferay-ui:message key="receipt-remarks-maxlength" />
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<%--	Action Buttons--%>
						<aui:button-row>
							<aui:button cssClass="btn btn-primary button" type="button"
								name="generate" value="receipt-submit-button" />
						</aui:button-row>
					</div>
				</aui:form>
			</aui:container>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		 $("#<portlet:namespace/>letterDate").datepicker({
			format : 'dd/mm/yyyy'
		});
 
		$("#<portlet:namespace/>receivedOn").datepicker({
			format : 'dd/mm/yyyy'
		});
	});
</script>
<%@ include file="/js/receipt.js"%>