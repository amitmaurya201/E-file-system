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

<style>
.table thead th {
	border-right: 1px solid white;
}

.popup {
	/*Hides pop-up when there is no "active" class*/
	visibility: hidden;
	position: absolute;
	background: #ffffff;
	border: 3px solid #666666;
	width: 50%;
	height: 50%;
	margin-top: -22%;
	left: 30%;
}

.popup.active {
	/*displays pop-up when "active" class is present*/
	visibility: visible;
	text-align: center;
}

.popup-content {
	/*Hides pop-up content when there is no "active" class */
	visibility: hidden;
}

.popup-content.active {
	/*Shows pop-up content when "active" class is present */
	visibility: visible;
}

.button {	
	border: none;
}

.tableSender{
border-collapse: separate;
  border-spacing: 0 15px;
}

.bold{
font-size: 15px;
font-weight: bold;
}
</style>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/inbox.jsp" />
</liferay-portlet:renderURL>



<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

	
 
 

		
 
 
 

	<div class="col-10">
		<h1 class=" text-center">File Inbox</h1>
		 <clay:management-toolbar
        disabled="${fileInboxCount eq 0}"
        displayContext="${fileInboxManagementToolbarDisplayContext}"
        itemsTotal="${fileInboxCount}"
        searchContainerId="FileInboxEntries"
        managementToolbarDisplayContext="${fileInboxManagementToolbarDisplayContext}"
    />
		
		<liferay-ui:search-container
		delta="4"
        emptyResultsMessage="No-File-List"
        id="FileInboxEntries"
        total="${fileInboxCount}" iteratorURL="${fileInboxManagementToolbarDisplayContext._getCurrentURL()}"
        >
        <liferay-ui:search-container-results results="${fileInboxList}" />


			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.FileMovementDTO"
				keyProperty="fileMovementId" modelVar="fileinboxDtoList">
				
				<portlet:renderURL var="sendURL">
					<portlet:param name="mvcRenderCommandName"	value="<%=MVCCommandNames.FILE_SEND_RENDER_COMMAND%>" />
					<portlet:param name="docFileId"	value="${fileinboxDtoList.getFileId()}" />
				</portlet:renderURL>

				<portlet:actionURL name="receiveAction" var="formAction"/>
				<portlet:actionURL name="readAction" var="formAction1"/>
				
				<portlet:renderURL var="fileInnerView">
						<portlet:param name="mvcRenderCommandName" value="/FileInnerViewDetails" />
						<portlet:param name="docFileId" value="${fileinboxDtoList.getFileId()}" />
						</portlet:renderURL>
					<%
						SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
							simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
					%>
				
					<c:choose>
						<c:when test="${fileinboxDtoList.getNature()=='Electronic' || fileinboxDtoList.getNature()=='Physical'}">
							<c:if test="${fileinboxDtoList.getReadOn()==null && fileinboxDtoList.getReceivedOn()==null}">
														
							<liferay-ui:search-container-column-text name="" cssClass="bold">
								<%=fileinboxDtoList.getNature().charAt(0)%>
							</liferay-ui:search-container-column-text>
							
							<liferay-ui:search-container-column-text orderable="true"  property="fileNumber"
								name="fileNumber" cssClass="bold"/>
							<liferay-ui:search-container-column-text orderable="true"  property="subject"
								name="subject" cssClass="bold"/>
							<liferay-ui:search-container-column-text name="Sent By"
							cssClass="hover-tips bold">
								<%
								FileMovement fileMvmt=FileMovementLocalServiceUtil.getFileMovement(fileinboxDtoList.getFileMovementId());
								long senderId=fileMvmt.getSenderId();
								
								%>
								<a href="#" class="button open"  onclick=" showModal(<%=senderId%>)"><%=fileinboxDtoList.getSentBy() %></a>
													
								</liferay-ui:search-container-column-text>
								
								<liferay-ui:search-container-column-text
								value="<%=simpleformat.format(fileinboxDtoList.getSentOn())%>"
								name="Send On" cssClass="bold"/>
								
								<liferay-ui:search-container-column-text property="dueDate"
									name="Due On" cssClass="bold" />
								<liferay-ui:search-container-column-text
									name="Remark" cssClass="bold">
									<c:if test="${not empty fileinboxDtoList.getRemark()}">
										<%=fileinboxDtoList.getRemark() %>
									</c:if>
								</liferay-ui:search-container-column-text>
								
								<c:choose>
									<c:when test="${fileinboxDtoList.getNature()=='Electronic'}">
										<liferay-ui:search-container-column-text name="Action"
											align="center" cssClass="bold">
											<span><a href="#" class="button open"
								onclick="readModal(${fileinboxDtoList.getFileId()})">read</a></span>&nbsp;	
												<span><a href="${sendURL}">send</a></span>
						
										</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text name="Action"
										align="center" cssClass="bold">
											<span><a href="#" class="button open"
								onclick="receiveModal(${fileinboxDtoList.getFileId()})">receive</a></span>&nbsp;
											<span><a href="${sendURL}">send</a></span>
					
									</liferay-ui:search-container-column-text>
									</c:otherwise>
									</c:choose>
									
							</c:if>
								<c:if test="${fileinboxDtoList.getReadOn()!=null || fileinboxDtoList.getReceivedOn()!=null}">
						
							<liferay-ui:search-container-column-text name="" >
							<%=fileinboxDtoList.getNature().charAt(0)%>
						</liferay-ui:search-container-column-text>						
						
							<liferay-ui:search-container-column-text href="<%=fileInnerView %>" property="fileNumber"
							name="File No." />
						<liferay-ui:search-container-column-text property="subject"
							name="Subject" />
							<liferay-ui:search-container-column-text name="Sent By"
						cssClass="hover-tips">
						<%
						FileMovement fileMvmt=FileMovementLocalServiceUtil.getFileMovement(fileinboxDtoList.getFileMovementId());
						long senderId=fileMvmt.getSenderId();
						
						%>
						<a href="#" class="button open"  onclick=" showModal(<%=senderId%>)"><%=fileinboxDtoList.getSentBy() %></a>
						
						</liferay-ui:search-container-column-text>					
					
	
					<liferay-ui:search-container-column-text
						value="<%=simpleformat.format(fileinboxDtoList.getSentOn())%>"
						name="Send On" />
						
						<liferay-ui:search-container-column-text property="dueDate"
						name="Due On" />
						<liferay-ui:search-container-column-text
							name="Remark">
							<c:if test="${not empty fileinboxDtoList.getRemark()}">
								<%=fileinboxDtoList.getRemark() %>
							</c:if>
							</liferay-ui:search-container-column-text>
							
							<c:choose>
									<c:when test="${fileinboxDtoList.getNature()=='Electronic'}">
										<liferay-ui:search-container-column-text name="Action"
											align="center">
												<span><a href="${sendURL}">send</a></span>
						
										</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text name="Action"
										align="center">
											<span><a href="${sendURL}">send</a></span>
					
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
        <liferay-ui:search-paginator searchContainer="<%=new SearchContainer() %>" markupView="lexicon" />


		</liferay-ui:search-container>

	</div>

</div>



<!-- Receive pop up -->
<div id="receive" class="popup">
	<!--   Creates the popup content-->
	<div class="receive popup-content">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -5%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<aui:form action="${formAction}" method="POST" name="fm" cssClass="mt-5">
			<!-- <button type="button" class="close" data-dismiss="modal"
				aria-label="Close"
				style="float: right; margin-top: -5%; font-size: 25px;">
				<span aria-hidden="true">&times;</span>
			</button> -->
			<input type="text" name='<portlet:namespace/>fileId'
				id="receive-fileId" />
			<button type="submit">Receive</button>
		</aui:form>
	</div>
</div>


<!-- Read pop up -->
<div id="read" class="popup">
	<!--   Creates the popup content-->
	<div class="read popup-content">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -5%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<aui:form action="${formAction1}" method="POST" name="fm" cssClass="mt-5">
			<!-- <button type="button" class="close" data-dismiss="modal"
				aria-label="Close"
				style="float: right; margin-top: -5%; font-size: 25px;">
				<span aria-hidden="true">&times;</span>
			</button> -->
			<input type="text" name='<portlet:namespace/>fileId1'
				id="read-fileId" />
			<button type="submit">Read</button>
		</aui:form>
	</div>
</div>

<!--popup code start  -->
<!--Creates the popup body-->
<div id="sender-dtls" class="popup">
	<!--   Creates the popup content-->
	<div class="dtls popup-content">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -5%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<div class="container mt-5">		
			<div class="row ">
				<div class="col-6">
					<table class="tableSender">
						<tr class="mt-1">
							<th class="col-3">Name :</th>
							<td id="name" class="col-3"></td>
						</tr>
						<tr class="mt-1">
							<th class="col-3">Marking Abbr :</th>
							<td id="marking" class="col-3"></td>
						</tr>
						<tr>
							<th class="col-3">Section :</th>
							<td id="section" class="col-3"></td>
						</tr>
						<tr>
							<th class="col-3">Email :</th>
							<td id="email"></td>
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
	alert(fileId);
	document.getElementById("receive-fileId").value=fileId;
	$("#receive, .receive").addClass("active");
	$(".close").on("click", function() {
		  $("#receive, .receive").removeClass("active");
		});

		
	}

function readModal(fileId){
	alert(fileId);
	document.getElementById("read-fileId").value=fileId;
	$("#read, .read").addClass("active");
	$(".close").on("click", function() {
		  $("#read, .read").removeClass("active");
		});

		
	}

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
				email.append("");
				design.append("");
				post.append(obj.postName);
				dept.append(obj.departmentName);
				
			}
			);
	$("#sender-dtls, .dtls").addClass("active");
	$(".close").on("click", function() {
		  $("#sender-dtls, .dtls").removeClass("active");
		});

		
	}


</script>

<!--end  -->


















