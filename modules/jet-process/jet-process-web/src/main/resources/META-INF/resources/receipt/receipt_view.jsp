<%@page import="com.liferay.portal.kernel.util.SessionParamUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="../init.jsp"%>
<%@ include file="/js/receipt-id.js"%>

<%--  <%
 if(themeDisplay.isSignedIn()){
 List<UserPost> userPostList =UserPostLocalServiceUtil.getUserPostList(user.getUserId());
 for(UserPost userPosts:userPostList){
 long id=userPosts.getUserPostId();
 /* String name=userPosts.getShortName(); */
  out.println("userPostId--> "+id);
  /* out.println("userPostName--> "+name); */

 %> --%>



<liferay-util:include page="/receipt/receipt-view-nav.jsp"
	servletContext="<%=application%>">
	<liferay-util:param name="selectedNav" value="home" />
	<%-- <liferay-util:param name="userPostId" value="${id}" /> --%>
</liferay-util:include>
<%-- <%}

}%>
 --%>
<%-- <%@ include file="receipt-view-nav.jsp"%> --%>



<%-- receipt view --%>

<div class="receipt">
	<aui:container>
		<aui:input name="receiptId" id="receiptId" value="${receiptId}" />
		<aui:input name="userPostId" id="userPostId" type="hidden" />
		<aui:row>
			<aui:col lg="6" cssClass="border">
				<h1>pdf</h1>
			</aui:col>
			<aui:col lg="6" cssClass="border">
				<div class="border heading">
					<h4>
						<aui:icon cssClass="fas fa-file-alt icon" />
						Diary Details
					</h4>
				</div>
				<aui:row>
					<aui:col lg="6">
						<label>Comp No.<span><aui:input label="" name=""
									id="" readonly="true" /> </span></label>
					</aui:col>
					<aui:col lg="6">
						<label>Receipt No.<span><aui:input label=""
									name="receiptNumber" id="receiptNumber" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="6">
						<label>Nature<span><aui:input label=""
									name="nature" id="nature" readonly="true" /> </span></label>
					</aui:col>
					<aui:col lg="6">
						<label>File No.<span><aui:input label=""
									name="fileNumber" id="fileNumber" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="6">
						<label>Category<span><aui:input label=""
									name="receiptCategoryId" id="receiptCategoryId" readonly="true" />
						</span></label>
					</aui:col>
					<aui:col lg="6">
						<label>Sub Category<span><aui:input label=""
									name="receiptSubCategoryId" id="receiptSubCategoryId"
									readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="6">
						<label>Organization<span><aui:input label=""
									name="organizationId" id="organizationId" readonly="true" /> </span></label>
					</aui:col>
					<aui:col lg="6">
						<label>Sub Organization<span><aui:input label=""
									name="subOrganizationId" id="subOrganizationId" readonly="true" />
						</span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="6">
						<label>Form<span><aui:input label="" name="name"
									id="name" readonly="true" /> </span></label>
					</aui:col>
					<aui:col lg="6">
						<label>Designation<span><aui:input label=""
									name="designation" id="designation" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="6">
						<label>Type<span><aui:input label="" name="typeId"
									id="typeId" readonly="true" /> </span></label>
					</aui:col>

					<aui:col lg="6">
						<label>Delivery Mode<span><aui:input label=""
									name="deliveryModeId" id="deliveryModeId" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>

				<aui:row>
					<aui:col lg="6">
						<label>Reference Number<span><aui:input label=""
									name="referenceNumber" id="referenceNumber" readonly="true" />
						</span></label>
					</aui:col>

					<aui:col lg="6">
						<label>ModeNumber<span><aui:input label=""
									name="modeNumber" id="modeNumber" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="6">
						<label>Received On<span><aui:input label=""
									name="receivedOn" id="receivedOn" readonly="true" /> </span></label>
					</aui:col>
					<aui:col lg="6">
						<label>Letter Date<span><aui:input label=""
									name="letterDate" id="letterDate" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="6">
						<label>Created On<span><aui:input label=""
									name="createOn" id="createOn" readonly="true" /> </span></label>
					</aui:col>
					<aui:col lg="6">
						<label>Diarised By<span><aui:input label="" name=""
									readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="12">
						<label>Subject<span><aui:input label=""
									name="subject" id="subject" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="12">
						<label>Remarks<span><aui:input label=""
									name="remarks" id="remarks" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col lg="12">
						<label>Address<span><aui:input label=""
									name="address" id="address" readonly="true" /> </span></label>
					</aui:col>
				</aui:row>
			</aui:col>
		</aui:row>
	</aui:container>
</div>
