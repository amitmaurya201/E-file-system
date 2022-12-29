<%@page import="io.jetprocess.service.FileMovementLocalServiceUtil"%>
<%@page import="io.jetprocess.model.FileMovement"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="io.jetprocess.model.DocFile"%>
<%@page import="java.util.TimeZone"%>
<%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page
	import="io.jetprocess.masterdata.service.MasterdataLocalServiceUtil"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>

<%
String backURL = themeDisplay.getURLCurrent();

String backURL1 = backURL+"&a=12";
String status = ParamUtil.getString(renderRequest, "status");
String result = ParamUtil.getString(renderRequest, "result");

%>


<style>
.table thead th {
	border-right: 1px solid white;
}

.popup, .read-popup, .receive-popup {
	/*Hides pop-up when there is no "active" class*/
	/* visibility: hidden; */
	position: absolute;
	background: #96b4d6;
	border: 3px solid #666666;
	margin-top: -30%;
	left: 30%;
	display: none;
}

.popup {
	width: 50%;
	height: 50%;
}

.read-popup, .receive-popup {
	width: 30%;
	height: 30%;
	left: 40%;
	background: #bcd0e7;
}

.popup.active, .read-popup.active, .receive-popup.active {
	/*displays pop-up when "active" class is present*/
	/* visibility: visible; */
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

		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="No record found" id="FileInboxEntries"
			total="${fileInboxCount}"
			iteratorURL="${fileInboxManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${fileInboxList}" />


			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.FileMovementDTO"
				keyProperty="fileMovementId" modelVar="fileinboxDtoList">

				<portlet:renderURL var="sendURL">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.FILE_SEND_RENDER_COMMAND%>" />
					<portlet:param name="docFileId"
						value="${fileinboxDtoList.getFileId()}" />
						 <portlet:param name="backPageURL" value="<%=backURL1 %>"></portlet:param>						
						
				</portlet:renderURL>

				<portlet:actionURL name="fileReceiveAction" var="fileReceiveAction">
					<portlet:param name="fileId"
						value="${fileinboxDtoList.getFileId()}" />
				</portlet:actionURL>
				<portlet:actionURL name="fileReadAction" var="fileReadAction">
					<portlet:param name="fileId1"
						value="${fileinboxDtoList.getFileId()}" />
                         <portlet:param name="fmId" value="${fileinboxDtoList.getFileMovementId()}" />
                        
				</portlet:actionURL>

				<portlet:renderURL var="fileInnerView">
					<portlet:param name="mvcRenderCommandName" value="/FileViewDetails" />
					<portlet:param name="docFileId"
						value="${fileinboxDtoList.getFileId()}" />
				</portlet:renderURL>
				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
							simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>
				<%
					SimpleDateFormat simpleformat1 = new SimpleDateFormat("dd-MM-yy hh:mm aa");
							simpleformat1.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>

				<c:choose>
					<c:when
						test="${fileinboxDtoList.getNature()=='Electronic' || fileinboxDtoList.getNature()=='Physical'}">
						<c:if
							test="${fileinboxDtoList.getReadOn()==null && fileinboxDtoList.getReceivedOn()==null }">

							<liferay-ui:search-container-column-text name="" cssClass="bold">
								<%=fileinboxDtoList.getNature().charAt(0)%>
							</liferay-ui:search-container-column-text>

							<c:choose>
								<c:when test="${fileinboxDtoList.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text
										href="${fileReadAction }" name="label-file-inbox-fileno"
										cssClass="bold" orderableProperty="fileNumber"
										orderable="true"
										value="<%=fileinboxDtoList.getFileNumber() != null ? fileinboxDtoList.getFileNumber() : ""%>" />
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text
										name="label-file-inbox-fileno" cssClass="bold phfile"
										orderableProperty="fileNumber" orderable="true"
										value="<%=fileinboxDtoList.getFileNumber() != null
												? fileinboxDtoList.getFileNumber()
												: ""%>" />

								</c:otherwise>
							</c:choose>

							<liferay-ui:search-container-column-text orderable="true"
								orderableProperty="subject"
								value="<%=fileinboxDtoList.getSubject() != null ? fileinboxDtoList.getSubject() : ""%>"
								name="label-file-inbox-subject" cssClass="hover-tips bold" />
							<liferay-ui:search-container-column-text
								name="label-file-inbox-sentby" cssClass="hover-tips bold">
								<%
									FileMovement fileMvmt = FileMovementLocalServiceUtil
																	.getFileMovement(fileinboxDtoList.getFileMovementId());
															long senderId = fileMvmt.getSenderId();
								%>
								<a href="#" class="button open"
									onclick=" showModal(<%=senderId%>)"><%=fileinboxDtoList.getSentBy()%></a>

							</liferay-ui:search-container-column-text>



							<liferay-ui:search-container-column-text
								value="<%=fileinboxDtoList.getSentOn() != null
										? simpleformat.format(fileinboxDtoList.getSentOn())
										: ""%>"
								name="label-file-inbox-senton" cssClass="bold" />

							<liferay-ui:search-container-column-text property="dueDate"
								name="label-file-inbox-dueon" cssClass="bold" />
							<liferay-ui:search-container-column-text
								name="label-file-inbox-remarks" cssClass="hover-tips bold">
								<c:if test="${not empty fileinboxDtoList.getRemark()}">
									<%=fileinboxDtoList.getRemark()%>
								</c:if>
							</liferay-ui:search-container-column-text>

							<c:choose>
								<c:when test="${fileinboxDtoList.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text
										name="label-file-inbox-actions" align="center" cssClass="bold">
										<%-- <span><a href="#" class="button open"
											onclick="readModal(${fileinboxDtoList.getFileId()})"> <liferay-ui:message
													key="label-file-inbox-action-read" />
										</a></span>&nbsp;	 --%>
										<span><a href="${sendURL}"> <liferay-ui:message
													key="label-file-inbox-action-send" />
										</a></span>

									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text
										name="label-file-inbox-actions" align="center" cssClass="bold">
										<span><a href="#" class="button open"
											onclick="receiveModal(${fileinboxDtoList.getFileId()})">
												<liferay-ui:message key="label-file-inbox-action-receive" />
										</a></span>&nbsp;
											<span><a href="${sendURL}"> <liferay-ui:message
													key="label-file-inbox-action-send" />
										</a></span>

									</liferay-ui:search-container-column-text>
								</c:otherwise>
							</c:choose>

						</c:if>
						<c:if
							test="${fileinboxDtoList.getReadOn()!=null || fileinboxDtoList.getReceivedOn()!=null}">

							<liferay-ui:search-container-column-text name="">
								<%=fileinboxDtoList.getNature().charAt(0)%>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text
								href="<%=fileInnerView%>" orderableProperty="fileNumber"
								orderable="true"
								value="<%=fileinboxDtoList.getFileNumber() != null
										? fileinboxDtoList.getFileNumber()
										: ""%>"
								name="File number" />
							<liferay-ui:search-container-column-text
								value="<%=fileinboxDtoList.getSubject() != null ? fileinboxDtoList.getSubject() : ""%>"
								orderableProperty="subject" name="label-file-inbox-subject"
								cssClass="hover-tips" />
							<liferay-ui:search-container-column-text
								name="label-file-inbox-sentby" cssClass="hover-tips">
								<%
									FileMovement fileMvmt = FileMovementLocalServiceUtil
																	.getFileMovement(fileinboxDtoList.getFileMovementId());
															long senderId = fileMvmt.getSenderId();
								%>
								<a href="#" class="button open"
									onclick=" showModal(<%=senderId%>)"><%=fileinboxDtoList.getSentBy()%></a>

							</liferay-ui:search-container-column-text>


							<liferay-ui:search-container-column-text
								value="<%=simpleformat.format(fileinboxDtoList.getSentOn())%>"
								name="label-file-inbox-senton" />

							<liferay-ui:search-container-column-text property="dueDate"
								name="label-file-inbox-dueon" />
							<liferay-ui:search-container-column-text
								name="label-file-inbox-remarks" cssClass="hover-tips">
								<c:if test="${not empty fileinboxDtoList.getRemark()}">
									<%=fileinboxDtoList.getRemark()%>
								</c:if>
							</liferay-ui:search-container-column-text>

							<c:choose>
								<c:when test="${fileinboxDtoList.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text
										name="label-file-inbox-actions" align="center">
										<span><a href="${sendURL}"> <liferay-ui:message
													key="label-file-inbox-action-send" />
										</a></span>

									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text
										name="label-file-inbox-actions" align="center">
										<span><a href="${sendURL}"> <liferay-ui:message
													key="label-file-inbox-action-send" />
										</a></span>

									</liferay-ui:search-container-column-text>
								</c:otherwise>
							</c:choose>
						</c:if>

					</c:when>

					<c:otherwise>
					</c:otherwise>
				</c:choose>


			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />


		</liferay-ui:search-container>

	</div>

</div>

<% if(status.equalsIgnoreCase("error")){ %>
		 <div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong><%= result %></strong>
  </div>
		<%} %>


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
			<h3 class="text-center">Are you sure to receive?</h3>
			<aui:form action="${fileReceiveAction}" method="POST" name="fm">
				<!-- <text>Receipt Number </text> -->
				<input type="text" hidden name='<portlet:namespace/>fileId'
					id="file-receive-fileId" />
				<button class="mt-3 btn btn-primary" type="submit"
					style="width: 90px;">Receive</button>
				<div class="mt-3 btn btn-primary cancel" style="width: 90px;">Cancel</div>
			</aui:form>
		</div>
	</div>
</div>

<!-- Read pop up -->
<%-- <div id="file-read" class="read-popup">
	<!--   Creates the popup content-->
	<div class="">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -6%; margin-right: -2%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<div class="container mt-3">
			<h3 class="text-center">Are you sure to read ?</h3>
			<aui:form action="${fileReadAction}" method="POST" name="fm">
				<text>Receipt Number </text>
				<input type="text" readonly name='<portlet:namespace/>fileId1'
					id="file-read-fileId" />
				<button class="mt-3 btn btn-success" type="submit">Read</button>
			</aui:form>
		</div>
	</div>
</div> --%>

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
		<div class="container mt-5 border"
			style="background-color: white;">
			<div class="row ">
				<div class="col-6">
					<table class="tableSender">
						<tr>
							<th class="col-3">Name :</th>
							<td id="name" class="col-3"></td>
						</tr>
						<tr>
							<th class="col-3">Marking Abbr :</th>
							<td id="marking" class="col-3"></td>
						</tr>
						<tr>
							<th class="col-3">Section :</th>
							<td id="section" class="col-3"></td>
						</tr>
						<tr>
							<th class="col-3">Email :</th>
							<td id="email" class="col-3"></td>
						</tr>
					</table>
				</div>
				<div class="col-6">
					<table class="tableSender">
						<tr>
							<th class="col-3">Designation :</th>
							<td class="col-3" id="design"></td>
						</tr>
						<tr>
							<th class="col-3">Post :</th>
							<td class="col-3" id="post"></td>
						</tr>
						<tr>
							<th class="col-3">Department :</th>
							<td class="col-3" id="dept"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">

 function receiveModal(fileId){
	 
	document.getElementById("file-receive-fileId").value=fileId;
	$("#file-receive").addClass("active");
	$("#file_inbox").addClass("active");
	$(".close, .cancel").on("click", function() {
		$("#file-receive").removeClass("active");
		  $("#file_inbox").removeClass("active");
		});

		
	}

/* function readModal(fileId){
	
	document.getElementById("file-read-fileId").value=fileId;
	$("#file-read").addClass("active");
	$(".close").on("click", function() {
		  $("#file-read").removeClass("active");
		});

		
	} */

function showModal(id){
	Liferay.Service(
			'/masterdata.userpost/get-user-post-by-id',
			{
			    userPostId: id
			},
			function(obj) {
			    console.log(obj);
							
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
				email.append(obj.email);
				design.append(obj.designation);
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


</script>

<!--end  -->