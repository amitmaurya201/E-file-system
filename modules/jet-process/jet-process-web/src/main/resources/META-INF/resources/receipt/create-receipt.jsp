<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="../init.jsp"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file="/js/receipt.js"%>
<%@ include file="/js/common.js"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<%@ include file="/navigation.jsp"%>
<%
	ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
	String setURl = serviceContext.getPortalURL();

	/* for current date*/
	DateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
%>
<div class=" mr-1 receipt">
	<aui:container cssClass="row">
		<aui:form cssClass="col-6">
			<aui:col cssClass="border">
				<div id="targetDiv" class="targetDiv">
					<aui:input id="document" label="" name="document" type="file">
					<!-- <embed id="pdfurl" type="application/pdf" width="100%" height="450"> 
 -->						<aui:validator name="required" />
						<aui:validator name="acceptFiles"
							errorMessage="label-receipt-upload-error-message">'pdf'</aui:validator>
					</aui:input>
				</div>
			</aui:col>
		</aui:form>

		<aui:form cssClass="col-6" name="receiptForm" id="receiptForm">
			<%--  <aui:input name="receiptId" id="receiptId" value="${receiptId}" /> --%>
			<aui:row>
				<aui:col cssClass="border">
					<div class="scroll">
						<div class="border heading">
							<h4>
								<aui:icon cssClass="fas fa-file-alt icon" />
								<liferay-ui:message key="label-receipt-diary-details" />
							</h4>
						</div>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-receipt-createdon" /></label>
									<aui:input label="" name="createdOn" id="createdOn"
										value="<%=currentDate.format(new Date())%>" disabled="true" />
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Nature</label>
									<aui:select label="" name="nature" id="nature">
										<aui:option value="Electronic">Electronic</aui:option>
										<aui:option value="Physical">Physical</aui:option>
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
											<liferay-ui:message key="label-receipt-deafult-option" />
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
											<liferay-ui:message key="label-receipt-deafult-option" />
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
									<aui:input type="date" label="" name="letterDate"
										id="letterDate">
										<aui:validator name="custom"
											errorMessage="label-receipt-letter-date-erroe-message">
											function(val){
												var date=new Date(val);
												var today = new Date();
												return (date < today);
											}
										</aui:validator>
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-receipt-received-on" /><span class='text-danger'>*</span></label>
									<aui:input type="date" label="" name="receivedOn"
										id="receivedOn">
										<aui:validator name="required" />
										<aui:validator name="custom"
											errorMessage="label-receipt-received-on-error-message1">
											function(val){
												var letterDate = (document.getElementById("<portlet:namespace />letterDate").value);
												return (val >= letterDate);
											}
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="label-receipt-received-on-error-message2">
											function(val){
												var date=new Date(val);
												var today = new Date();
												return (date < today);
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
											<liferay-ui:message key="label-receipt-deafult-option" />
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
										<aui:option value="">
											<liferay-ui:message key="label-receipt-deafult-option" />
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
											errorMessage="label-receipt-mobile-error-message">
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
											errorMessage="label-receipt-email-error-message">
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
											<liferay-ui:message key="label-receipt-address-maxlength" />
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
										<aui:option value="">
											<liferay-ui:message key="label-receipt-deafult-option" />
										</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label><liferay-ui:message key="label-receipt-state" /></label>
									<aui:select label="" name="stateId" id="stateId">
										<aui:option value="">
											<liferay-ui:message key="label-receipt-deafult-option" />
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
											<liferay-ui:message key="label-receipt-pincode-maxlength" />
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
											<liferay-ui:message key="label-receipt-deafult-option" />
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
										<aui:option value="">
											<liferay-ui:message key="label-receipt-deafult-option" />
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
											<liferay-ui:message key="label-receipt-subject-maxlength" />
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
					</div>
					<%--	Action Buttons--%>
					<aui:button-row>
						<aui:button cssClass="btn btn-primary button" type="submit"
							name="generate" value="Generate" />
					</aui:button-row>
				</aui:col>
			</aui:row>
		</aui:form>
	</aui:container>
</div>
</div>