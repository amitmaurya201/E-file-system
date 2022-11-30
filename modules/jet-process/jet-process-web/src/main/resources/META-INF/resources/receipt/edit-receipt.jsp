<%@page
	import="io.jetprocess.masterdata.service.MasterdataLocalServiceUtil"%>
<%@page import="io.jetprocess.service.ReceiptLocalServiceUtil"%>
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
<liferay-util:include page="/receipt/receipt-view-nav.jsp"
	servletContext="<%=application%>">
	<liferay-util:param name="selectedNav" value="home" />
	<%-- <liferay-util:param name="userPostId" value="${id}" /> --%>
</liferay-util:include>
<%
	ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
	String setURl = serviceContext.getPortalURL();
%>
<div class=" mr-1 receipt">
	<aui:container cssClass="row">

		<aui:form cssClass="col-6">
			<aui:col cssClass="border">
				<div id="targetDiv" class="targetDiv">
					<aui:input id="document" label="" name="document" type="file">
					<embed id="editpdfurl" type="application/pdf" src="${receipt.viewPdfUrl}"  width="100%" height="450">
						<aui:validator name="required" />
						<aui:validator name="acceptFiles"
							errorMessage="Please enter a file with a valid extension (pdf)and 25 MB PDF file sizeAllowed">'pdf'</aui:validator>
					</aui:input>
					<%-- <c:if test="${receipt.viewPdfUrl != null}">
						<embed id="pdfurl" type="application/pdf" 
							src="${receipt.viewPdfUrl}" width="100%" height="450">
					</c:if> --%>
				</div>
			</aui:col>
		</aui:form>

		<aui:form cssClass="col-6" name="receiptForm" id="receiptForm">
			<c:if test="${receipt.receiptId != 0}">
				<aui:input name="receiptId" id="receiptId" type="hidden"
					value="${receipt.receiptId}" />
				<%-- <aui:input name="userpostId" id="userpostId" 
				value="${receipt.userPostId}" /> --%>
			</c:if>
			<aui:row>
				<aui:col cssClass="border">
					<div class="scroll">
						<div class="border heading">
							<h4>
								<aui:icon cssClass="fas fa-file-alt icon" />
								Diary Details
							</h4>
						</div>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Created On</label>
									<aui:input label="" name="createdOn" id="createdOn"
										value="${receipt.createDate}" disabled="true" />
										
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
									<label>Type<span class='text-danger'>*</span></label>
									<aui:select label="" name="typeId" id="typeId">
										<c:if test="${receipt.typeId != null}">
											<aui:option value="${receipt.typeId}">${typeValue}</aui:option>
										</c:if>
										<aui:option value="">Select</aui:option>
										<aui:validator name="required" />
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Delivery Mode<span class='text-danger'>*</span></label>
									<aui:input label="" name="deliveryModeId" id="deliveryModeId" value="${deliveryModeValue}"
										disabled="true"/>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Letter Date</label>
									<aui:input type="date" label="" name="letterDate"
										id="letterDate" value="${receipt.letterDate}">
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
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Received on<span class='text-danger'>*</span></label>
									<aui:input type="date" label="" name="receivedOn"
										id="receivedOn" value="${receipt.receivedOn}">
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
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Reference Number</label>
									<aui:input label="" name="referenceNumber" id="referenceNumber"
										value="${receipt.referenceNumber}"/>
										<aui:input label="" name="dmFileId" id="dmFileId"
										value="${receipt.dmFileId}" type = "hidden"/>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Mode Number</label>
									<aui:input label="" name="modeNumber" id="modeNumber"
										value="${receipt.modeNumber}" />
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
										<c:if test="${receipt.organizationId != null}">
											<aui:option value="${receipt.organizationId}">${organizationValue}</aui:option>
										</c:if>
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
										<c:if test="${receipt.subOrganizationId != null}">
											<aui:option value="${receipt.subOrganizationId}">${subOrganizationValue}</aui:option>
										</c:if>
										<aui:option value="">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Name<span class='text-danger'>*</span></label>
									<aui:input label="" name="name" id="name"
										value="${receipt.name}">
										<aui:validator name="required" />
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Designation<span class='text-danger'>*</span></label>
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
									<label>Mobile</label>
									<aui:input label="" name="mobile" id="mobile"
										value="${receipt.mobile}">
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
									<aui:input label="" name="email" id="email"
										value="${receipt.email}">
										<aui:validator name=""></aui:validator>
										<aui:validator name="custom"
											errorMessage="please enter valid email">
											function(val){
												var regex=new RegExp(/^(.+)@([\w-]+\.)(.+)$/);
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
									<aui:input type="textarea" label="" name="address" id="address"
										value="${receipt.address}">
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
										<c:if test="${receipt.countryId != null}">
											<aui:option value="${receipt.countryId}">${countryValue}</aui:option>
										</c:if>
										<aui:option value="">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>State</label>
									<aui:select label="" name="stateId" id="stateId">
										<c:if test="${receipt.stateId != null}">
											<aui:option value="${receipt.stateId}">${stateValue}</aui:option>
										</c:if>
										<aui:option value="">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>City/District</label>
									<aui:input label="" name="city" id="city"
										value="${receipt.city}" />
								</div>
							</aui:col>
							<aui:col md="6" cssClass="mt-3">
								<div class="textOnInput">
									<label>Pin Code</label>
									<aui:input label="" name="pinCode" id="pinCode"
										value="${receipt.pinCode}">
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
										<c:if test="${receipt.receiptCategoryId != null}">
											<aui:option value="${receipt.receiptCategoryId}">${receiptCategoryValue}</aui:option>
										</c:if>
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
										<c:if test="${receipt.receiptSubCategoryId != null}">
											<aui:option value="${receipt.receiptSubCategoryId}">${receiptSubCategoryValue}</aui:option>
										</c:if>
										<aui:option value="">Select</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col cssClass="mt-3">
								<div class="textOnInput">
									<label>Subject<span class='text-danger'>*</span></label>
									<aui:input type="textarea" label="" name="subject" id="subject"
										value="${receipt.subject}">
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
									<aui:input label="" name="remarks" id="remarks"
										value="${receipt.remarks}" />
								</div>
							</aui:col>
						</aui:row>
					</div>
					<%--	Action Buttons--%>
					<aui:button-row>
						<aui:button cssClass="btn btn-primary button" type="submit"
							name="Save" value="Save" />
					</aui:button-row>
				</aui:col>
			</aui:row>
		</aui:form>
	</aui:container>
</div>
</div>