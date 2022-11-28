<%@page import="io.jetprocess.model.DocFile"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ include file="../init.jsp"%>
<%@ include file="../navigation.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet"/>

<liferay-util:include page="/file/file-view-nav.jsp" servletContext="<%=application%>">
	<liferay-util:param name="selectedNav" value="send" />
</liferay-util:include>







<portlet:actionURL name="sendFile" var="send"/>

<%-- <%
	//DynamicQuery dqQuery=UserPostLocalServiceUtil.dynamicQuery();
	List<UserPost> userPostList1 = UserPostLocalServiceUtil.searchUserPost("FD");
	for (UserPost userPost1 : userPostList1) {
		out.println(userPost1 + "<br/>");
	}
%> --%>
<% DocFile docFile = (DocFile) session.getAttribute("DocFileObj"); %>


<portlet:resourceURL var="populateSoldTo"/>

<aui:form action="${send}">
	<input type="hidden" name="<portlet:namespace/>senderId" value="<%=docFile.getUserPostId()%>">
	<input type="hidden" name="<portlet:namespace/>fileId" value="<%=docFile.getDocFileId() %>">
	<div class="row">
		<div class="col-6">
			<aui:fieldset-group>
				<div class="fieldset" style="background-color: #f1f2f5;">
					<h1>
						<span><b>To</b></span>
					</h1>
					<%--  <div class="col-lg-4 col-md-6 col-12 enach-rsp">
						<aui:input   placeholder="Choose here.." autocomplete="off"
						type="text" name="receiverId" onKeyUp="receiverId()"></aui:input>
						<aui:input id="selectDeliveryTown" name="selectDeliveryTown" type="hidden"></aui:input>
					</div> --%>
					 
					 <!--  dropdown list -->
					 <%-- <div class="dropdown">
						  <input type="button" onclick="myFunction()" class="dropbtn" placeholder="Choose here">	
						  			  <div id="myDropdown" class="dropdown-content">
						    <input type="text" placeholder="Search.." id="myInput" onkeyup="filterFunction()">
						   
						    	<%
							List<UserPost> userPostList = UserPostLocalServiceUtil.getUserPosts(-1, -1);
									if (userPostList != null) {
										for (UserPost userPost : userPostList) {
						%>
						<a><%=userPost.getShortName()%></a>

						<%
							}
									}
						%>
						   
						  </div>
						</div>		 
					 
					  --%>
					 
					 
					<select  name='<portlet:namespace/>receiverId' id="receiverId"  class="form-control">
											
						<!-- <option value="chooseOne">choose One</option> -->
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
 
 /*  $("#res").on('change', function(){
	
			var receiverId = $("#res").val();
			console.log("before autocomplete=====> "+receiverId);
				$("#receiverId").autocomplete({
				source: function(request, response) {
					$.ajax({
						method: "GET",
						url: "http://localhost:8080/api/jsonws/masterdata.userpost/get-user-post-searched-data/data/"+receiverId+"?p_auth=" + Liferay.authToken,
						data: {
							//searchField: fieldName,
							//className: className,
							inputField: request.term
						},
						success: function(data) {
							console.log(`printing the getAutoCompleteSoruceData : ${data}`);
							response(data);
						},
						error: (error) => {
							console.log(error);
						}
					});
				},
				/* minLength: 1,
				select: function(event, ui) {
					console.log(ui.item ? "Selected: " + ui.item.label : "Nothing selected, input was " + this.value);
				},
				open: function() {
					//$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
				},
				close: function() {
					//$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
				} 
			});
  }); */
</script>




































