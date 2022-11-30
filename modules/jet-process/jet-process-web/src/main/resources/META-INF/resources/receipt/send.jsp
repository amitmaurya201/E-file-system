<%@page import="io.jetprocess.model.Receipt"%>
<%@ include file="../init.jsp"%>
<%@ include file="../navigation.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet"/>

<liferay-util:include page="/receipt/receipt-view-nav.jsp" servletContext="<%=application%>">
	<liferay-util:param name="selectedNav" value="send" />
</liferay-util:include>

<portlet:actionURL name="sendReceipt" var="send"/>


<% Receipt receipt = (Receipt) session.getAttribute("receipt"); %>

<aui:form action="${send}">
	<input type="hidden" name="<portlet:namespace/>senderId" value="<%=receipt.getUserPostId() %>">
	<input type="hidden" name="<portlet:namespace/>receiptId" value="<%= receipt.getReceiptId()%>">
	<div class="row">
		<div class="col-6">
			<aui:fieldset-group>
				<div class="fieldset" style="background-color: #f1f2f5;">
					<h1>
						<span><b>To</b></span>
					</h1>		
					 
					<select  name='<portlet:namespace/>receiverId' id="receiverId"  class="form-control">
											
						<%
							List<UserPost> userPostList = UserPostLocalServiceUtil.getUserPosts(-1, -1);
									if (userPostList != null) {
										for (UserPost userPost : userPostList) {
						%>
						<option value="<%=userPost.getUserPostId()%>"><%=userPost.getShortName()%></option>

						<%
							}
						}
						%>
						
					</select>
				
				</div>
				
				<div class="fieldset">
					<h1>
						<span><b>SetDueDate</b></span>
					</h1>
					<input type="date" class="form-control" name="<portlet:namespace/>dueDate">
				</div>
				<div class="fieldset">
					<h1>
						<span><b>Priority</b></span>
					</h1>
					<select class="form-control" name="<portlet:namespace/>priorty">
						<option>Choose One</option>
						<option>Highest</option>
						<option>High</option>
						<option>Medium</option>
						<option>Low</option>
					</select>
				</div>
				<div class="fieldset">
					<h1>
						<span><b>Remarks</b></span>
					</h1>
					<textarea rows="4" class="form-control" name="<portlet:namespace/>remark"></textarea>
				</div>
			</aui:fieldset-group>
		</div>
	</div>
	<aui:button-row>
		<button type="submit"  class="btn btn-primary ml-5">Send</button>
	</aui:button-row>
</aui:form>

<script>
$('#receiverId').select2({ width: '100%', placeholder: "Select an Option", allowClear: true });
 
</script>
