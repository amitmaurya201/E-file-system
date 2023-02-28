<%@ include file="../init.jsp"%>
<%
	String currentURL = themeDisplay.getURLCurrent();
	String backPageURL = currentURL + "&a=12";
%>

<style>

html:not (#__ ):not (#___ ) .cadmin .modal-header, html:not (#__ ):not(#___) .cadmin.modal-header {
	background: #007bFF;
	color: white;
}

html:not (#__ ):not (#___ ) .cadmin .close {
	color: white;
}

.lfr-search-container-wrapper a:not(.component-action):not(.btn) {
    color : #000000;
}

.table thead th {
	border-right: 1px solid white;
}

.popup, .receive-popup {
	position: absolute;
	background: #96b4d6;
	border: 3px solid #666666;
	margin-top: -30%;
	left: 30%;
	display: none;
}

.filesend {
	cursor: pointer;
}

.popup {
	width: 50%;
	height: 50%;
}

.receive-popup {
	width: 30%;
	height: 30%;
	left: 40%;
	background: #bcd0e7;
}

.popup.active, .receive-popup.active {
	text-align: center;
	display: block;
	border-radius: 5px;
	border: double;
}

#file_inbox.active {
	pointer-events: none;
	opacity: 0.5;
}

.button {
	border: none;
}

.tableSender {
	border-collapse: separate;
	border-spacing: 0 15px;
}

.tableSender td {
	text-align: left;
	background-color: white;
}

.tableSender th {
	vertical-align: top;
}

.bold {
	font-size: 15px;
	font-weight: bold;
}

.btn-secondary {
	background-color: #f2f2f2;
	border-color: #f2f2f2;
	color: #000;
}
</style>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/inbox.jsp" />
</liferay-portlet:renderURL>

<div id="file_inbox" class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

	<div class="col-10">
		<h1 class=" text-center">
			<liferay-ui:message key="label-file-inbox-heading" />
		</h1>
		<clay:management-toolbar disabled="${fileInboxCount eq 0}"
			displayContext="${fileInboxManagementToolbarDisplayContext}"
			itemsTotal="${fileInboxCount}" searchContainerId="FileInboxEntries" />


		<portlet:renderURL var="fileSendURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.FILE_SEND_RENDER_COMMAND_POP_UP%>" />
		</portlet:renderURL>

		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="message-record-not-found" id="FileInboxEntries"
			total="${fileInboxCount}"
			iteratorURL="${fileInboxManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${fileInboxList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.FileMovementDTO"
				keyProperty="fileMovementId" modelVar="fileInboxList">

				<portlet:actionURL var="fileReceiveAction"
					name="<%=MVCCommandNames.FILE_INBOX_RECEIVE_ACTION_COMMAND%>">
					<portlet:param name="fileId" value="${fileInboxList.getFileId()}" />
					<portlet:param name="fileMovementId"
						value="${fileInboxList.getFileMovementId()}" />
					<portlet:param name="backPageURL" value="<%=backPageURL%>"></portlet:param>

				</portlet:actionURL>
				<portlet:actionURL var="fileReadAction"
					name="<%=MVCCommandNames.FILE_INBOX_READ_ACTION_COMMAND%>">
					<portlet:param name="fileId" value="${fileInboxList.getFileId()}" />
					<portlet:param name="fileMovementId"
						value="${fileInboxList.getFileMovementId()}" />
					<portlet:param name="backPageURL" value="<%=backPageURL%>"></portlet:param>
				</portlet:actionURL>

				<portlet:renderURL var="fileInnerView">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.FILEINNERVIEW_RENDER_COMMAND%>" />
					<portlet:param name="docFileId"
						value="${fileInboxList.getFileId()}" />
					<portlet:param name="fileMovementId"
						value="${fileInboxList.getFileMovementId()}" />
					<portlet:param name="backPageURL" value="<%=backPageURL%>"></portlet:param>

				</portlet:renderURL>
				<c:if
					test="${fileInboxList.getReadOn()==null && fileInboxList.getReceivedOn()==null }">

					<liferay-ui:search-container-column-text
						name="label-file-inbox-nature" cssClass="bold">
						<span title="${fileInboxList.nature }"><%=fileInboxList.getNature().charAt(0)%></span>
					</liferay-ui:search-container-column-text>
					<c:choose>
						<c:when test="${fileInboxList.getNature()=='Electronic'}">
							<liferay-ui:search-container-column-text
								href="${fileReadAction }" name="label-file-inbox-fileno"
								cssClass="bold hyperlink-css" orderableProperty="fileNumber"
								orderable="true"
								value="<%=fileInboxList.getFileNumber() != null ? fileInboxList.getFileNumber() : ""%>" />
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text
								name="label-file-inbox-fileno"
								cssClass="bold hyperlink-css phfile"
								orderableProperty="fileNumber" orderable="true"
								value="<%=fileInboxList.getFileNumber() != null ? fileInboxList.getFileNumber() : ""%>" />
						</c:otherwise>
					</c:choose>
					<liferay-ui:search-container-column-text orderable="true"
						orderableProperty="subject"
						value="<%=fileInboxList.getSubject() != null ? fileInboxList.getSubject() : ""%>"
						name="label-file-inbox-subject" cssClass="hover-tips bold" />
					<liferay-ui:search-container-column-text
						name="label-file-inbox-sentby" cssClass="hover-tips bold">

						<c:set value="${fileInboxList.getFileMovementId()}" var="senderId"></c:set>

						<a href="#" class="button open"
							onclick=" showModal(<%=fileInboxList.getSenderId()%>)">${fileInboxList.getSentBy()}</a>

					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						value="<%=fileInboxList.getSentOn() != null
								? simpleformat.format(fileInboxList.getSentOn())
								: ""%>"
						name="label-file-inbox-senton" cssClass="bold"
						orderableProperty="sentOn" orderable="true" />

					<liferay-ui:search-container-column-text
						name="label-file-inbox-dueon" cssClass="bold"
						orderableProperty="dueDate" orderable="true">
						<fmt:formatDate type="both" pattern="dd/MM/yyyy"
							timeZone="Asia/Calcutta" value="${fileInboxList.dueDate}" />
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="label-file-inbox-remarks" cssClass="hover-tips bold">
						<c:if test="${not empty fileInboxList.getRemark()}">
							<%=fileInboxList.getRemark()%>
						</c:if>
					</liferay-ui:search-container-column-text>

					<c:choose>
						<c:when test="${fileInboxList.getNature()=='Electronic'}">
							<liferay-ui:search-container-column-text
								name="label-file-inbox-actions" align="center" cssClass="bold">

								<a class="filesend" id="sendFile" name="sendFile"
									onClick="OpenSendPopUp(${fileInboxList.getFileId()},${fileInboxList.getFileMovementId()})">Send</a>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text
								name="label-file-inbox-actions" align="center" cssClass="bold">
								<span><a href="#" class="button open"
									onclick="receiveModal(${fileInboxList.getFileId()},${fileInboxList.getFileMovementId()} )">
										<liferay-ui:message key="label-file-inbox-action-receive" />
								</a></span>&nbsp;
										
										<a class="filesend" id="sendFile" name="sendFile"
									onClick="OpenSendPopUp(${fileInboxList.getFileId()},${fileInboxList.getFileMovementId()})">Send</a>
							</liferay-ui:search-container-column-text>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if
					test="${fileInboxList.getReadOn()!=null || fileInboxList.getReceivedOn()!=null}">

					<liferay-ui:search-container-column-text
						name="label-file-inbox-nature">
						<span title="${fileInboxList.nature }"><%=fileInboxList.getNature().charAt(0)%></span>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text href="<%=fileInnerView%>"
						orderableProperty="fileNumber" orderable="true"
						cssClass="hyperlink-css"
						value="<%=fileInboxList.getFileNumber() != null ? fileInboxList.getFileNumber() : ""%>"
						name="label-file-inbox-fileno" />
					<liferay-ui:search-container-column-text
						value="<%=fileInboxList.getSubject() != null ? fileInboxList.getSubject() : ""%>"
						orderableProperty="subject" orderable="true"
						name="label-file-inbox-subject" cssClass="hover-tips" />
					<liferay-ui:search-container-column-text
						name="label-file-inbox-sentby" cssClass="hover-tips">


						<a href="#" class="button open"
							onclick=" showModal(<%=fileInboxList.getSenderId()%>)">${fileInboxList.getSentBy()}</a>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="label-file-inbox-senton" orderableProperty="sentOn"
						orderable="true">
						<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
							timeZone="Asia/Calcutta" value="${fileInboxList.getSentOn()}" />
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="label-file-inbox-dueon" orderableProperty="dueDate"
						orderable="true">
						<fmt:formatDate type="both" pattern="dd/MM/yyyy"
							timeZone="Asia/Calcutta" value="${fileInboxList.dueDate}" />
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text
						name="label-file-inbox-remarks" cssClass="hover-tips">
						<c:if test="${not empty fileInboxList.getRemark()}">
							<%=fileInboxList.getRemark()%>
						</c:if>
					</liferay-ui:search-container-column-text>

					<c:choose>
						<c:when test="${fileInboxList.getNature()=='Electronic'}">
							<liferay-ui:search-container-column-text
								name="label-file-inbox-actions" align="center">
								<a class="filesend" id="sendFile" name="sendFile"
									onClick="OpenSendPopUp(${fileInboxList.getFileId()},${fileInboxList.getFileMovementId()})">Send</a>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text
								name="label-file-inbox-actions" align="center">
								<a class="filesend" id="sendFile" name="sendFile"
									onClick="OpenSendPopUp(${fileInboxList.getFileId()},${fileInboxList.getFileMovementId()})">Send</a>
							</liferay-ui:search-container-column-text>
						</c:otherwise>
					</c:choose>
				</c:if>


				<liferay-ui:search-container-column-text name=""
					cssClass="hover-tips">
					<c:if test="${fileInboxList.hasNote}">
						<img src='<%=request.getContextPath() + "/image/green-note.jpg"%>'
							width="60%" height="25"
							class="shadow m-1 bg-white rounded-circle" />
					</c:if>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>

<div class="ml-3" id="alert-receive-remove"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); margin-right: 74%; margin-top: -40px;">
	<liferay-ui:error key="receive-not-available"
		message="file-receive-inbox-error" />
</div>
<div class="ml-3" id="alert-read-remove"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); margin-right: 74%; margin-top: -40px;">
	<liferay-ui:error key="read-not-available"
		message="file-read-inbox-error" />
</div>
<div class="ml-3" id="alert-remove"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); margin-right: 74%; margin-top: -40px;">
	<liferay-ui:error key="send-not-available"
		message="file-already-pullbacked-inbox-error" />
</div>

<!-- Receive pop up -->
<div id="file-receive" class="receive-popup">
	<!--   Creates the popup content-->
	<div class="">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -4%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<div class="container mt-3">
			<h3 class="text-center">
				<liferay-ui:message key="label-file-inbox-receive-popup-heading" />
			</h3>
			<aui:form action="${fileReceiveAction}" method="POST" name="fm">
				<!-- <text>Receipt Number </text> -->
				<input type="text" name='<portlet:namespace/>fileId'
					id="file-receive-fileId" hidden />
				<input type="text" name='<portlet:namespace/>fileMovementId' id="fileMovementId" hidden />
				<button class="mt-3 btn btn-primary" type="submit"
					style="width: 90px;">
					<liferay-ui:message
						key="label-file-inbox-receive-popup-receive-button" />
				</button>
				<div class="mt-3 btn btn-primary cancel" style="width: 90px;">
					<liferay-ui:message
						key="label-file-inbox-receive-popup-cancel-button" />
				</div>
			</aui:form>
		</div>
	</div>
</div>

<!--popup code start  -->
<!--Creates the popup body-->
<div id="sender-dtls" class="popup">
	<!--   Creates the popup content-->
	<div class="">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -7%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<div class="container mt-5 border" style="background-color: white;">
			<div class="row ">
				<div class="col-6">
					<table class="tableSender">
						<tr>
							<th class="col-3"><liferay-ui:message
									key="label-file-inbox-user-name" /> :</th>
							<td id="name" class="col-3"></td>
						</tr>
						<tr>
							<th class="col-3"><liferay-ui:message
									key="label-file-inbox-user-marking-abbr" /> :</th>
							<td id="marking" class="col-3"></td>
						</tr>
						<tr>
							<th class="col-3"><liferay-ui:message
									key="label-file-inbox-user-section" /> :</th>
							<td id="section" class="col-3"></td>
						</tr>
						<tr>
							<th class="col-3"><liferay-ui:message
									key="label-file-inbox-user-email" /> :</th>
							<td id="email" class="col-3"></td>
						</tr>
					</table>
				</div>
				<div class="col-6">
					<table class="tableSender">
						<tr>
							<th class="col-3"><liferay-ui:message
									key="label-file-inbox-user-designation" /> :</th>
							<td class="col-3" id="design"></td>
						</tr>
						<tr>
							<th class="col-3"><liferay-ui:message
									key="label-file-inbox-user-post" /> :</th>
							<td class="col-3" id="post"></td>
						</tr>
						<tr>
							<th class="col-3"><liferay-ui:message
									key="label-file-inbox-user-department" /> :</th>
							<td class="col-3" id="dept"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">

 function receiveModal(fileId,fileMovementId){
	document.getElementById("file-receive-fileId").value=fileId;
	document.getElementById("fileMovementId").value=fileMovementId;
	$("#file-receive").addClass("active");
	$("#file_inbox").addClass("active");
	$(".close, .cancel").on("click", function() {
		$("#file-receive").removeClass("active");
		  $("#file_inbox").removeClass("active");
		});
	}

 /* auto close alert */
$("#error-alert").fadeTo(2000, 500).slideUp(500, function(){
    $("#error-alert").slideUp(500);
});

	/* Remove read error  message */
$("#alert-read-remove").fadeTo(2000, 700).slideUp(700, function(){
    $("#alert-read-remove").slideUp(700);
});

	/* Remove receive error message */
$("#alert-receive-remove").fadeTo(2000, 700).slideUp(700, function(){
    $("#alert-receive-remove").slideUp(500);
});

/* Remove error message */
$("#alert-remove").fadeTo(2000, 500).slideUp(500, function(){
	$("#alert-remove").slideUp(500);
});
	
function showModal(id){
	Liferay.Service(
			'/masterdata.userpost/get-user-post-by-id',
			{
			userPostId: id
			},
			function(obj) {
				var name=document.getElementById("name");
				var marking=document.getElementById("marking");
				var section=document.getElementById("section");
				var email=document.getElementById("email");
				var design=document.getElementById("design");
				var post=document.getElementById("post");
				var dept=document.getElementById("dept");
				name.innerHTML="";
				marking.innerHTML="";
				section.innerHTML="";
				email.innerHTML="";
				design.innerHTML="";
				post.innerHTML="";
				dept.innerHTML="";
				name.append(obj.userName);
				marking.append(obj.postMarking);
				section.append(obj.sectionName);
				email.append();
				design.append();
				post.append(obj.postName);
				dept.append(obj.departmentName);
			}
			);
	$("#sender-dtls").addClass("active");
	$("#file_inbox").addClass("active");
	$(".close").on("click", function() {
		  $("#sender-dtls").removeClass("active");
		  $("#file_inbox").removeClass("active");
		});
	}
	
function OpenSendPopUp(fileId,fileMovementId){
	var fileURL = '<%=fileSendURL%>&<portlet:namespace/>fileId='+fileId+'&<portlet:namespace/>fileMovementId='+fileMovementId;
		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				height: 500,
				destroyOnClose: true,														 
				destroyOnHide: true, 
				modal: true,
				width: 500
			},
			id: '<portlet:namespace/>dialog',
			title: 'Send',
			uri: fileURL
		});
	}
</script>

<!--end  -->