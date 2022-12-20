<%@page import="io.jetprocess.model.DocFile"%>
<%@ include file="../init.jsp"%>
         
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet" />
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="send" />
		</liferay-util:include>


		<portlet:actionURL name="sendFile" var="send" />

		<%
			//DocFile docFile = (DocFile) session.getAttribute("DocFile"); 
			DocFile docFile =(DocFile) renderRequest.getAttribute("docFile");
			
		
			String type = (String) docFile.getNature();
			char firstChar = type.charAt(0);
		%>
		<div class="container-fluid m-1" style="background-color: #E8E8E8;">
			<span><%=firstChar%> | <%=docFile.getFileNumber()%> | <%=docFile.getSubject()%></span><br />

		</div>

		<aui:form action="${send}">
			<input type="hidden" name="<portlet:namespace/>senderId"
				value="<%=selectedUserPostId%>">
			<%-- <%
			long fileId=(long)request.getAttribute("docFileId");
				out.println(fileId);
				if(docFile.getDocFileId()==fileId){
			
			%> --%>
			<input type="hidden" name="<portlet:namespace/>fileId"
				value="<%=docFile.getDocFileId()%>">
			<%-- 	<%} %> --%>
			<div class="row">
				<div class="col-6">
					<aui:fieldset-group>
						<div class="fieldset" style="background-color: #f1f2f5;">
							<h1>
								<span><b>To<span class="text-danger">*</span></b></span>
							</h1>

							<select name='<portlet:namespace/>receiverId' id="receiverId"
								class="form-control" required="required">

								<option value="chooseOne">choose One</option>
								<%
									List<UserPost> userPostList = UserPostLocalServiceUtil.getUserPosts(-1, -1);
									List<UserPost> newUserPostList = new ArrayList<>(userPostList);
									UserPost selectedUserPost =  UserPostLocalServiceUtil.getUserPost(Long.parseLong(selectedUserPostId));
									boolean isUserPostAvailable = newUserPostList.contains(selectedUserPost);
									if(isUserPostAvailable){
										newUserPostList.remove(selectedUserPost);
									}	
									if (newUserPostList != null) {
										for (UserPost userPost : newUserPostList) {
								%>
								<option value="<%=userPost.getUserPostId()%>"><%= userPost.getUserName()%>&nbsp;<%=userPost.getShortName()%>&nbsp;<%=userPost.getSectionName() %>&nbsp;<%=userPost.getDepartmentName() %></option>
								<%
									}
									}
											
								%>
							
							</select>

						</div>
						<div class="fieldset">
							<h1>
								<span><b>Duedate<span class="text-danger">*</span></b></span>
							</h1>
							<aui:input type="date" class="form-control"
								name="dueDate" data-date="" data-date-format="DD/MM/YYYY" label="">
								<aui:validator name="required"/>
								<aui:validator name="custom"
										errorMessage="Don't past date">
											function(val){
												var date=new Date(val);
												console.log("select value----> "+date);
												var today = new Date();
												console.log("current value----> "+today);
												if(today=date){
												console.log("equal date");
												return date;
												}
												else if(today < date){
												console.log("date is greater than");
												return date;
												}
											}
										</aui:validator>
							</aui:input>
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
							<textarea rows="4" class="form-control"
								name="<portlet:namespace/>remark"></textarea>
						</div>
					</aui:fieldset-group>
				</div>
			</div>
			<aui:button-row>
				<button type="submit" class="btn btn-primary ml-5">Send</button>
			</aui:button-row>
		</aui:form>

	</div>
</div>

<script>
	$('#receiverId').select2({
		width : '100%',
		placeholder : "Select an Option",
		 required:true,
		allowClear : true
	});
</script>




















