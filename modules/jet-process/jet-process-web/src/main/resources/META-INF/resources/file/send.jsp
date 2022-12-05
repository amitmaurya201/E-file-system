<%@page import="io.jetprocess.model.DocFile"%>
<%@ include file="../init.jsp"%>

         
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>
	
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css"
	rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>


<style>
.duedate {
        position: relative;
        width: 150px; height: 20px;
        color: white;
    }

   .duedate:before {
        position: absolute;
        top: 3px; left: 3px;
        content: attr(data-date);
        display: inline-block;
        color: black;
    }

    .duedate::-webkit-datetime-edit, .duedate::-webkit-inner-spin-button, .duedate::-webkit-clear-button {
        display: none;
    }

    .duedate::-webkit-calendar-picker-indicator {
        position: absolute;
        top: 3px;
        right: 0;
        color: black;
        opacity: 1;
    }

</style>


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
			DocFile docFile = (DocFile) session.getAttribute("DocFile");
		
			String type = (String) docFile.getNature();
			char firstChar = type.charAt(0);
		%>
		<div class="container-fluid m-1" style="background-color: #E8E8E8;">
			<span><%=firstChar%> | <%=docFile.getFileNumber()%> | <%=docFile.getSubject()%></span><br />

		</div>

		<aui:form action="${send}">
			<input type="hidden" name="<portlet:namespace/>senderId"
				value="<%=docFile.getUserPostId()%>">
			<input type="hidden" name="<portlet:namespace/>fileId"
				value="<%=docFile.getDocFileId()%>">
			<div class="row">
				<div class="col-6">
					<aui:fieldset-group>
						<div class="fieldset" style="background-color: #f1f2f5;">
							<h1>
								<span><b>To</b></span>
							</h1>

							<select name='<portlet:namespace/>receiverId' id="receiverId"
								class="form-control">

								<option value="chooseOne">choose One</option>
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
								<span><b>Duedate</b></span>
							</h1>
							<input type="date" class="form-control duedate"
								name="<portlet:namespace/>dueDate" data-date="" data-date-format="DD/MM/YYYY">
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

<!-- <script>
$(document).ready(function() {

     // set an element
     $("#duedate").val( moment().format('MMM D, YYYY') );

     // set a variable
     var today = moment().format('DD/MM/YYYY');
     console.log(today);

});
</script> -->

<script>
	$('#receiverId').select2({
		width : '100%',
		placeholder : "Select an Option",
		allowClear : true
	});
</script>

<<script type="text/javascript">
$("#duedate").on("change", function() {
    this.setAttribute(
        "data-date",
        moment(this.value, "YYYY-MM-DD")
        .format( this.getAttribute("data-date-format") )
    )
}).trigger("change")
</script>



















