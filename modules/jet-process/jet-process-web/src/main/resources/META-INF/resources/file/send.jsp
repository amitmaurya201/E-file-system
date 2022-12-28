<%@page import="io.jetprocess.model.DocFile"%>
<%@ include file="../init.jsp"%>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css"
	rel="stylesheet" />

<div class="send row">
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
			DocFile docFile = (DocFile) renderRequest.getAttribute("docFile");

			String type = (String) docFile.getNature();
			char firstChar = type.charAt(0);
		%>
		<div class="container-fluid m-1" style="background-color: #E8E8E8;">
			<span><%=firstChar%> | <%=docFile.getFileNumber()%></span><br />

		</div>
		<aui:container cssClass="row">
			<aui:form action="${send}" cssClass="border border-dark col-6">
				<input type="hidden" name="<portlet:namespace/>senderId"
					value="<%=selectedUserPostId%>">
				<input type="hidden" name="<portlet:namespace/>fileId"
					value="<%=docFile.getDocFileId()%>">
				<aui:col cssClass="mt-3">
					<div>
						<h2 style="text-align: center; text-decoration: underline;">
							<liferay-ui:message key="label-send-heading" />
						</h2>
					</div>
				</aui:col>
				<aui:col cssClass="mt-3">
					<div class="textOnInput">
						<label><liferay-ui:message key="label-send-to" /><span
							class="text-danger">*</span></label>
						<aui:select label="" name="receiverId" id="receiverId">
							<aui:option value=''>
								<liferay-ui:message key="label-send-default-option" />
							</aui:option>
							<%
								List<UserPost> userPostList = UserPostLocalServiceUtil.getUserPosts(-1, -1);
												List<UserPost> newUserPostList = new ArrayList<>(userPostList);
												UserPost selectedUserPost = UserPostLocalServiceUtil
														.getUserPost(Long.parseLong(selectedUserPostId));
												boolean isUserPostAvailable = newUserPostList.contains(selectedUserPost);
												if (isUserPostAvailable) {
													newUserPostList.remove(selectedUserPost);
												}
												if (newUserPostList != null) {
													for (UserPost userPost : newUserPostList) {
							%>
							<aui:option value="<%=userPost.getUserPostId()%>"><%=userPost.getShortName()%></aui:option>
							<%
								}
												}
							%>
							<aui:validator name="required" />
						</aui:select>
					</div>
				</aui:col>
				<aui:col cssClass="mt-3">
					<div class="textOnInput">
						<label><liferay-ui:message key="label-send-due-date" /><span
							class="text-danger">*</span></label>
						<aui:input type="text" name="dueDate" id="dueDate" label=""
							placeholder="dd-mm-yyyy">
							<aui:validator name="required" />
							<aui:validator name="custom" errorMessage="error-send-due-date">
											function(val){
												function formatDate() {
												    var d = new Date(),
												        month = '' + (d.getMonth() + 1),
												        day = '' + d.getDate(),
												        year = d.getFullYear();
												
												    if (month.length < 2) 
												        month = '0' + month;
												    if (day.length < 2) 
												        day = '0' + day;
												
												    return [day, month,year].join('-');
												}
												var today =formatDate(new Date)
												return (today <= val);
											}
										</aui:validator>
						</aui:input>
					</div>
				</aui:col>
				<aui:col cssClass="mt-3">
					<div class="textOnInput">
						<label><liferay-ui:message key="label-send-priorty" /></label>
						<aui:select label="" name="priorty" id="priorty">
							<aui:option value=''>
								<liferay-ui:message key="label-send-default-option" />
							</aui:option>
							<aui:option value='Highest'>
								<liferay-ui:message key="label-send-option-highest" />
							</aui:option>
							<aui:option value='High'>
								<liferay-ui:message key="label-send-option-high" />
							</aui:option>
							<aui:option value='Medium'>
								<liferay-ui:message key="label-send-option-medium" />
							</aui:option>
							<aui:option value='Low'>
								<liferay-ui:message key="label-send-option-low" />
							</aui:option>
						</aui:select>
					</div>
				</aui:col>
				<aui:col cssClass="mt-3">
					<div class="textOnInput">
						<label><liferay-ui:message key="label-sent-remark" /></label>
						<aui:input type="textarea" label="" name="remark" id="remark"
							rows="3">
							<aui:validator name="maxLength">
								<liferay-ui:message key="sent-remark-maxlength" />
							</aui:validator>
						</aui:input>
					</div>
				</aui:col>
				<aui:button-row>
					<aui:button type="submit" class="btn btn-primary"
						style=" margin: auto 40%;" value="label-send-submit-button" />
				</aui:button-row>
			</aui:form>
		</aui:container>
	</div>
</div>

<!-- <script>
	$('#<portlet:namespace/>receiverId').select2({
		width : '100%',
		placeholder : "Select an Option",
		required : true,
		allowClear : true
	});
</script>
 -->
<aui:script>
	AUI().use(
        'aui-datepicker',
        function(A) {
            new A.DatePicker({
                trigger: '#<portlet:namespace />dueDate',
                mask: '%d-%m-%Y',
                popover: {
                    zIndex: 1000
                }
            });
        }
    );
</aui:script>