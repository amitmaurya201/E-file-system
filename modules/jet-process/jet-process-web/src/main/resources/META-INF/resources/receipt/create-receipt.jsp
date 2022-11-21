<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="../init.jsp"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file="/js/receipt.js"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<div class="row">
	<div class="col-2">
		<%@ include file="/navigation.jsp"%>
	</div>
	<%
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		String setURl = serviceContext.getPortalURL();

		/* for current date*/
		DateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");

	%>
	<div class="col mr-2 receipt">
		<aui:container fluid="1200">
			<aui:form name="receiptForm" id="receiptForm">
				<aui:input name="receiptId" id="receiptId"  type="hidden" value="${receiptId}" />
				<aui:input name="userPostId" id="userPostId"  type="hidden" />
				<aui:row>
					<aui:col lg="6" cssClass="border" >
						<div id="targetDiv" class="targetDiv" >
							<aui:input id="document" name="document" type="file" >
								<aui:validator name="required" />
								<aui:validator name="acceptFiles" errorMessage="Please enter a file with a valid extension (pdf)and 25 MB PDF file sizeAllowed">'pdf'</aui:validator>
							</aui:input>
							<aui:input id="tempFileId" name="tempFileId" type="hidden" />

						</div>
					</aui:col>
					<aui:col lg="6" cssClass="border">
					<div class="scroll">
						<div class="border heading">
							<h4>
								<aui:icon cssClass="fas fa-file-alt icon" />
								Diary Details
							</h4>
						</div>
						<aui:row>
							<aui:col md="4" cssClass="mt-3">
								<div class="textOnInput">
									<label>Created On</label>
									<aui:input label="" name="createdOn" id="createdOn"
										value="<%=currentDate.format(new Date())%>" disabled="true" />
								</div>
							</aui:col>
							<aui:col md="4" cssClass="mt-3">
								<div class="textOnInput">
									<label>Type<span class='text-danger'>*</span></label>
									<aui:select label="" name="typeId" id="typeId">
										<aui:option value="">Select</aui:option>
										<aui:validator name="required" />
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="4" cssClass="mt-3">
								<div class="textOnInput">
									<label>Delivery Mode<span class='text-danger'>*</span></label>
									<aui:select label="" name="deliveryModeId" id="deliveryModeId">
										<aui:option value="">Select</aui:option>
										<aui:validator name="required" />
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Received on<span class='text-danger'>*</span></label>
									<aui:input type="date" label="" name="receivedOn"
										id="receivedOn">
										<aui:validator name="required" />
										<aui:validator name="custom"
											errorMessage="Received Date should be greater than or equal to Letter Date">
											function(val){
												var letterDate = (document.getElementById("<portlet:namespace />letterDate").value);
												return (val >= letterDate);
											}
										</aui:validator>
										<aui:validator name="custom"
											errorMessage="Received Date should not be greater than Created On">
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
									<label>Letter Date</label>
									<aui:input type="date" label="" name="letterDate"
										id="letterDate">
										<aui:validator name="custom"
											errorMessage="Letter Date should not be greater than Created On">
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
									<label>Reference Number<span class='text-danger'>*</span></label>
									<aui:input label="" name="referenceNumber" id="referenceNumber" >
									<aui:validator name="required" />
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Mode Number</label>
									<aui:input label="" name="modeNumber" id="modeNumber" />
								</div>
							</aui:col>
						</aui:row>
						<div class="border heading">
							<h4>
								<aui:icon cssClass="fas fa-envelope icon" />
								Sender Details
							</h4>
						</div>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Organization<span class='text-danger'>*</span></label>
									<aui:select label="" name="organizationId" id="organizationId">
										<aui:option value="">Select</aui:option>
										<aui:validator name="required" />
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Sub Organization</label>
									<aui:select label="" name="subOrganizationId"
										id="subOrganizationId">
										<aui:option value="">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Name<span class='text-danger'>*</span></label>
									<aui:input label="" name="name" id="name">
										<aui:validator name="required" />
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Designation<span class='text-danger'>*</span></label>
									<aui:input label="" name="designation" id="designation">
										<aui:validator name="required" />
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Mobile</label>
									<aui:input label="" name="mobile" id="mobile">
										<aui:validator name="custom"
											errorMessage="Mobile should be maximum 10 numeric characters">
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
									<label>Email</label>
									<aui:input label="" name="email" id="email">
										<aui:validator name=""></aui:validator>
										<aui:validator name="custom"
											errorMessage="please enter valid email">
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
									<label>Address<span class='text-danger'>*</span></label>
									<aui:input type="textarea" label="" name="address" id="address">
										<aui:validator name="required" />
										<aui:validator name="maxLength">500</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Country</label>
									<aui:select label="" name="countryId" id="countryId">
										<aui:option value="">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>State</label>
									<aui:select label="" name="stateId" id="stateId">
										<aui:option value="">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>City</label>
									<aui:input label="" name="city" id="city" />
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Pin Code</label>
									<aui:input label="" name="pinCode" id="pinCode">
										<aui:validator name="maxLength">8</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<div class="border heading">
							<h4>
								<aui:icon cssClass="fas fa-receipt icon" />
								Receipt Details
							</h4>
						</div>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Category<span class='text-danger'>*</span></label>
									<aui:select label="" name="receiptCategoryId"
										id="receiptCategoryId">
										<aui:option value="">Select</aui:option>
										<aui:validator name="required" />
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Sub Category</label>
									<aui:select label="" name="receiptSubCategoryId"
										id="receiptSubCategoryId">
										<aui:option value="">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col cssClass="mt-3">
								<div class="textOnInput">
									<label>Subject<span class='text-danger'>*</span></label>
									<aui:input type="textarea" label="" name="subject" id="subject">
										<aui:validator name="required" />
										<aui:validator name="maxLength">500</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col cssClass="mt-3">
								<div class="textOnInput">
									<label>Remarks</label>
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