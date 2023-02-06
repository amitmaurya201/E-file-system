<%@ include file="../init.jsp"%>

<%
	Receipt receipt = (Receipt) renderRequest.getAttribute("receipt");
	ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
	String setURl = serviceContext.getPortalURL();
%>
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
	<div class="col-10">
		<liferay-util:include page="/receipt/receipt-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="edit" />
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
						<button class="btn text-danger" id="removeFileUpload"
							style="display: none">
							<liferay-ui:message key="receipt-remove-button" />
						</button>
						<div id="targetDiv" class="targetDiv text-center">

							<embed id="editpdfurl" type="application/pdf"
								src="${receipt.viewPdfUrl}" width="100%" height="450"
								style="display: none">

							</embed>
							<div class="dropzone-wrapper" style="display: none">
								<i class="glyphicon glyphicon-download-alt"></i>
								<p>
									<liferay-ui:message key="label-receipt-pdf-drag" />
								</p>
								<span class="btn btn-info" style="font-size: 15px;"
									id="doc-select-btn"><liferay-ui:message
										key="label-receipt-pdf-file" /></span> <input name="doc-input"
									id="doc-input" type="file" hidden accept=".pdf" />
								<p id="error" class="text-danger" style="display:none">This field is required
								</p>
								<p id="sizeValidation" style="display: none; color: red;">size
									must be less then 25 mb</p>
							</div>
						</div>

					</aui:col>
				</aui:form>

				<aui:form cssClass="scroll border border-dark col"
					style="padding-right:5px !important;" name="receiptForm">
					<aui:input name="receiptId" id="receiptId" type="hidden"
						value="${receipt.receiptId}" />
					<div class="border heading">
						<h5>
							<aui:icon cssClass="fas fa-file-alt icon" />
							<liferay-ui:message key="label-receipt-diary-details" />
						</h5>
					</div>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-createdon" /></label>
								<aui:input label="" name="createdon" id="createdon"
									value="<%=simpleFormat.format(receipt.getCreateDate())%>"
									disabled="true" />
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-nature" /></label>
								<aui:input label="" name="nature" id="nature"
									value="${receipt.nature}" readOnly="true" />
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-type" /><span
									class='text-danger'>*</span></label>
								<aui:select cssClass="master_drop_type" label="" name="typeId"
									id="typeId">
									<c:if test="${receipt.typeId != null}">
										<aui:option value="${receipt.typeId}">${typeValue}</aui:option>
									</c:if>
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
									id="letterDate" value="<%=simpleFormat.format(receipt.getLetterDate())%>"
									placeholder="dd/mm/yyyy">
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
									id="receivedOn" value="<%=simpleFormat.format(receipt.getReceivedOn())%>"
									placeholder="dd/mm/yyyy">
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
								<aui:input label="" name="referenceNumber" id="referenceNumber"
									value="${receipt.referenceNumber}">
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
								<aui:input label="" name="modeNumber" id="modeNumber"
									value="${receipt.modeNumber}">
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
					<div class="border heading">
						<h5>
							<aui:icon cssClass="fas fa-envelope icon" />
							<liferay-ui:message key="label-receipt-sender-details" />
						</h5>
					</div>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message
										key="label-receipt-organization" /><span class='text-danger'>*</span></label>
								<aui:select cssClass="master_drop_organization" label=""
									name="organizationId" id="organizationId">

									<c:if test="${receipt.organizationId != null}">
										<aui:option value="${receipt.organizationId}">${organizationValue}</aui:option>
									</c:if>
									<aui:validator name="required" />
								</aui:select>
							</div>

						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput" id="editOrganizationDiv">
								<label><liferay-ui:message
										key="label-receipt-sub-organization" /></label>
								<aui:select label="" name="subOrganizationId"
									id="subOrganizationId">
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
								<aui:input label="" name="designation" id="designation"
									value="${receipt.designation}">
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
												var regex=new RegExp(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]+$/);
												return regex.test(val);
											}
										</aui:validator>
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<aui:row style="padding-left:15px !important;">
						<aui:col cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-address" /><span
									class='text-danger'>*</span></label>
								<aui:input type="textarea" label="" name="address" id="address"
									value="${receipt.address}" style="height:70px;">
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
								<aui:select cssClass="master_drop_country" label=""
									name="countryId" id="countryId">
								</aui:select>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-state" /></label>
								<aui:select label="" name="stateId" id="stateId">
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-city" /></label>
								<aui:input label="" name="city" id="city"
									value="${receipt.city}">
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
								<aui:input label="" name="pinCode" id="pinCode"
									value="${receipt.pinCode}">
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
					<div class="border heading">
						<h5>
							<aui:icon cssClass="fas fa-receipt icon" />
							<liferay-ui:message key="label-receipt-receipt-details" />
						</h5>
					</div>
					<aui:row>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-category" /><span
									class='text-danger'>*</span></label>
								<aui:select cssClass="master_drop_receipt_category" label=""
									name="receiptCategoryId" id="receiptCategoryId">
									<c:if test="${receipt.receiptCategoryId != null}">
										<aui:option value="${receipt.receiptCategoryId}">${receiptCategoryValue}</aui:option>
									</c:if>

									<aui:validator name="required" />
								</aui:select>
							</div>
						</aui:col>
						<aui:col md="6" cssClass="mt-3">
							<div class="textOnInput" id="editReceiptSubCategoryDiv">
								<label><liferay-ui:message
										key="label-receipt-sub-category" /></label>
								<aui:select label="" name="receiptSubCategoryId"
									id="receiptSubCategoryId">
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
									value="${receipt.subject}" style="height:70px;">
									<aui:validator name="required" />
									<aui:validator name="maxLength">
										<liferay-ui:message key="receipt-subject-maxlength" />
									</aui:validator>
								</aui:input>
							</div>
						</aui:col>
					</aui:row>
					<aui:row style="padding-left:15px !important;">
						<aui:col cssClass="mt-3">
							<div class="textOnInput">
								<label><liferay-ui:message key="label-receipt-remark" /></label>
								<aui:input label="" name="remarks" id="remarks"
									value="${receipt.remarks}">
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
							name="update" value="receipt-edit-button" />
					</aui:button-row>
				</aui:form>
			</aui:container>

		</div>
	</div>
</div>

<script type="text/javascript">
	$(".master_drop_type").on("click", function() {
		$(".master_drop_type").find("option").eq(0).hide();
	});

	$(".master_drop_receipt_category").on("click", function() {
		$(".master_drop_receipt_category").find("option").eq(0).hide();

	});
	$(".master_drop_organization").on("click", function() {

		$(".master_drop_organization").find("option").eq(0).hide();
	});

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