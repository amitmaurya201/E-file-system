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
<div class="container">
	<input name="receiptId" id="receiptId" value="${receiptId}" /> <input
		name="userPostId" id="userPostId" type="hidden" />
	<div class="row">
		<div class="col-md-6" Class="border">
			<h1>pdf</h1>
		</div>
		<div class="col-md-6" Class="border">
			<div class="border heading">
				<h4>
					<aui:icon cssClass="fas fa-file-alt icon" />
					Diary Details
				</h4>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Created On :<span><input name="createOn"
							id="createOn" readonly="readonly"> </span></label>
				</div>
				<div class="col-md-6">
					<label>Receipt No. :<span><input
							name="receiptNumber" id="receiptNumber" readonly="readonly">
					</span></label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Nature :<span><input name="nature"
							id="nature" readonly="readonly"> </span></label>
				</div>
				<div class="col-md-6">
					<label>File No. :<span><input name="fileNumber"
							id="fileNumber" readonly="readonly"> </span></label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Type :<span><input name="typeId" id="typeId"
							readonly="readonly"> </span></label>
				</div>

				<div class="col-md-6">
					<label>Delivery Mode :<span><input
							name="deliveryModeId" id="deliveryModeId" readonly="readonly">
					</span></label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Received On :<span><input name="receivedOn"
							id="receivedOn" readonly="readonly"> </span></label>
				</div>
				<div class="col-md-6">
					<label>Letter Date :<span><input name="letterDate"
							id="letterDate" readonly="readonly"> </span></label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Reference Number :<span><input
							name="referenceNumber" id="referenceNumber" readonly="readonly">
					</span></label>
				</div>
				<div class="col-md-6">
					<label>ModeNumber :<span><input name="modeNumber"
							id="modeNumber" readonly="readonly"> </span></label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Category :<span><input name="receiptCategoryId"
							id="receiptCategoryId" readonly="readonly"> </span></label>
				</div>
				<div class="col-md-6">
					<label>Sub Category :<span><input
							name="receiptSubCategoryId" id="receiptSubCategoryId"
							readonly="readonly"> </span></label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<label>Diarised By :<span><input name=""
							readonly="readonly"> </span></label>
				</div>
				<div class="col-md-12">
					<label>Subject :<span><input name="subject"
							id="subject" readonly="readonly"> </span></label>
				</div>
				<div class="col-md-12">
					<label>Remarks :<span><input name="remarks"
							id="remarks" readonly="readonly"> </span></label>
				</div>
			</div>

			<div class="border heading">
				<h4>
					<aui:icon cssClass="fas fa-envelope icon" />
					Sender Details
				</h4>
			</div>

			<div class="row">
				<div class="col-md-6">
					<label>Organization :<span><input
							name="organizationId" id="organizationId" readonly="readonly">
					</span></label>
				</div>
				<div class="col-md-6">
					<label>Sub Organization :<span><input
							name="subOrganizationId" id="subOrganizationId"
							readonly="readonly"> </span></label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Form :<span><input name="name" id="name"
							readonly="readonly"> </span></label>
				</div>
				<div class="col-md-6">
					<label>Designation :<span><input name="designation"
							id="designation" readonly="readonly"> </span></label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<label>Address :<span><input name="address"
							id="address" readonly="readonly"> </span></label>
				</div>
			</div>
		</div>
	</div>
</div>
</div>