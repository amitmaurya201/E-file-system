<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="../init.jsp"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file="/js/receipt.js"%>
<div class="row">
	<div class="col-2">
		<%@ include file="/navigation.jsp"%>
	</div>
	<%
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		String setURl = serviceContext.getPortalURL();
		DateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
	%>
	<div class="col mr-2 receipt">
		<aui:container fluid="1200">
			<aui:form name="receiptForm">
				<aui:input name="userPostId" id="userPostId" value="1" />
				<aui:row>
					<aui:col lg="6" cssClass="border">
						<div id= "targetDiv">
							<aui:input id="document" name="document" type="file" />
							<aui:input id="tempFileId" name="tempFileId" type="hidden" />

						</div>
					</aui:col>
					<aui:col lg="6" cssClass="border">
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
									<label>Type</label>
									<aui:select label="" name="typeId" id="typeId">
										<aui:option value="0">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="4" cssClass="mt-3">
								<div class="textOnInput">
									<label>Delivery Mode</label>
									<aui:select label="" name="deliveryModeId" id="deliveryModeId">
										<aui:option value="0">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Received on</label>
									<aui:input type="date" label="" name="receivedOn"
										id="receivedOn" />
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Letter Date</label>
									<aui:input type="date" label="" name="letterDate"
										id="letterDate" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Reference Number</label>
									<aui:input label="" name="referenceNumber" id="referenceNumber" />
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
									<label>Organization</label>
									<aui:select label="" name="organizationId" id="organizationId">
										<aui:option value="0">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Sub Organization</label>
									<aui:select label="" name="subOrganizationId"
										id="subOrganizationId">
										<aui:option value="0">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Name</label>
									<aui:input label="" name="name" id="name" />
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Designation</label>
									<aui:input label="" name="designation" id="designation" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Mobile</label>
									<aui:input label="" name="mobile" id="mobile" />
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Email</label>
									<aui:input label="" name="email" id="email" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col cssClass="mt-3">
								<div class="textOnInput">
									<label>Address</label>
									<aui:input type="textarea" label="" name="address" id="address" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Country</label>
									<aui:select label="" name="countryId" id="countryId">
										<aui:option value="0">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>State</label>
									<aui:select label="" name="stateId" id="stateId">
										<aui:option value="0">Select</aui:option>
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
									<aui:input label="" name="pinCode" id="pinCode" />
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
									<label>Category</label>
									<aui:select label="" name="receiptCategoryId"
										id="receiptCategoryId">
										<aui:option value="0">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Sub Category</label>
									<aui:select label="" name="receiptSubCategoryId"
										id="receiptSubCategoryId">
										<aui:option value="0">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col cssClass="mt-3">
								<div class="textOnInput">
									<label>Subject</label>
									<aui:input type="textarea" label="" name="subject" id="subject" />
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