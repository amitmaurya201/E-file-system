<%@ include file="../init.jsp"%>
<%
	String backURL = themeDisplay.getURLCurrent();
	String backURL1 = backURL + "&a=12";
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/inbox.jsp" />
</liferay-portlet:renderURL>

<style>
.lfr-search-container-wrapper a:not(.component-action):not(.btn) {
  color: #000000;
}

.table thead th {
	border-right: 1px solid white;
}

.filesend{
cursor: pointer;

}
.popup, .read-popup, .receive-popup {
	position: absolute;
	background: #96b4d6;
	border: 3px solid #666666;
	margin-top: -30%;
	left: 30%;
	display: none;
}

.popup {
	width: 50%;
	/* height: 60%; */
}

.read-popup, .receive-popup {
	width: 30%;
	/* height: 30%; */
	left: 40%;
	background: #bcd0e7;
}

.popup.active, .read-popup.active, .receive-popup.active {
	text-align: center;
	display: block;
	border-radius: 5px;
	border: double;
}

#rec_inbox.active {
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

<div id="rec_inbox" class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">
			<liferay-ui:message key="label-receipt-inbox-heading" />
		</h1>

		<clay:management-toolbar disabled="${inboxReceiptCount eq 0}"
			displayContext="${receiptInboxManagementToolbarDisplayContext}"
			itemsTotal="${inboxReceiptCount}"
			searchContainerId="assignmentEntries"
			managementToolbarDisplayContext="${receiptInboxManagementToolbarDisplayContext}" />



		<portlet:renderURL var="receiptSendURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND_POP_UP%>" />
		</portlet:renderURL>

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="No Results Found" id="assignmentEntries"
			total="${inboxReceiptCount}"
			iteratorURL="${receiptInboxManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${receiptInboxList}" />
			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ReceiptMovementDTO"
				keyProperty="receiptMovementId" modelVar="receiptMovementDTO">

				<%-- <portlet:actionURL var="sendReceiptURL"
					name="<%=MVCCommandNames.RECEIPT_SEND_CHECKER_ACTION_COMMAND%>">
					<portlet:param name="userPostId" value="<%=selectedUserPostId%>" />
					<portlet:param name="receiptId"
						value="${receiptMovementDTO.getReceiptId()}" />
					<portlet:param name="backPageURL" value="<%=backURL1%>"></portlet:param>
				</portlet:actionURL> --%>

				<portlet:actionURL var="receiptReceiveAction"
					name="<%=MVCCommandNames.RECEIPT_INBOX_RECEIVE_ACTION_COMMAND%>">
					<portlet:param name="receiptId"
						value="${receiptMovementDTO.receiptId}" />
					<portlet:param name="rmId"
						value="${receiptMovementDTO.receiptMovementId}" />
					<portlet:param name="backPageURL" value="<%=backURL1%>"></portlet:param>

				</portlet:actionURL>
				<portlet:actionURL var="receiptReadAction"
					name="<%=MVCCommandNames.RECEIPT_INBOX_READ_ACTION_COMMAND%>">
					<portlet:param name="receiptId1"
						value="${receiptMovementDTO.receiptId}" />
					<portlet:param name="rmId"
						value="${receiptMovementDTO.receiptMovementId}" />
					<portlet:param name="backPageURL" value="<%=backURL1%>"></portlet:param>
				</portlet:actionURL>

				<portlet:renderURL var="receiptDetails">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.RECEIPT_DETAILS_RENDER_COMMAND%>" />
					<portlet:param name="receiptId"
						value="${receiptMovementDTO.getReceiptId()}" />
					<portlet:param name="rmId"
						value="${receiptMovementDTO.receiptMovementId}" />
					<portlet:param name="backPageURL" value="<%=backURL1%>"></portlet:param>
				</portlet:renderURL>
				<c:choose>
					<c:when
						test="${receiptMovementDTO.getNature()=='Electronic' || receiptMovementDTO.getNature()=='Physical'}">
						<c:if
							test="${receiptMovementDTO.getReadOn()==null && receiptMovementDTO.getReceivedOn()==null}">

							<liferay-ui:search-container-column-text name="" cssClass="bold">
								<%=receiptMovementDTO.getNature().charAt(0)%>
							</liferay-ui:search-container-column-text>
							<c:choose>
								<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text
										href="${receiptReadAction }"
										name="label-receipt-inbox-receiptno" cssClass="bold hyberlink-css"
										orderableProperty="receiptNumber" orderable="true"
										value="<%=receiptMovementDTO.getReceiptNumber() != null ? receiptMovementDTO.getReceiptNumber() : ""%>" />
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text
										name="label-receipt-inbox-receiptno" cssClass="bold"
										orderableProperty="receiptNumber" orderable="true"
										value="<%=receiptMovementDTO.getReceiptNumber() != null
												? receiptMovementDTO.getReceiptNumber()
												: ""%>" />
								</c:otherwise>
							</c:choose>
							<liferay-ui:search-container-column-text orderable="true"
								orderableProperty="subject"
								value="<%=receiptMovementDTO.getSubject() != null ? receiptMovementDTO.getSubject() : ""%>"
								cssClass="hover-tips bold" name="label-receipt-inbox-subject" />
							<%
								ReceiptMovement receiptMvmt = ReceiptMovementLocalServiceUtil
															.getReceiptMovement(receiptMovementDTO.getReceiptMovementId());
													long senderId = receiptMvmt.getSenderId();
							%>
							<liferay-ui:search-container-column-text
								name="label-receipt-inbox-sentby" cssClass="hover-tips bold">
								<a href="#" class="button open"
									onclick=" showModal(<%=senderId%>)"><%=receiptMovementDTO.getSentBy()%></a>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text cssClass="bold"
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="label-receipt-inbox-senton" orderableProperty="sentOn"
								orderable="true" />

							<liferay-ui:search-container-column-text cssClass="bold"
								value="<%=simpleFormat.format(receiptMovementDTO.getDueDate())%>"
								name="label-receipt-inbox-dueon" orderableProperty="dueOn"
								orderable="true" />

							<liferay-ui:search-container-column-text
								cssClass="hover-tips bold" name="label-receipt-inbox-remarks"
								value="<%=receiptMovementDTO.getRemark() != null
											? receiptMovementDTO.getRemark()
											: ""%>">
							</liferay-ui:search-container-column-text>

							<c:choose>
								<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text cssClass="bold"
										name="label-receipt-inbox-actions" align="center">
										<%-- <span><a href="${sendReceiptURL}"> <liferay-ui:message
													key="label-receipt-inbox-action-send" />
										</a></span> --%>
										<a class="filesend" id="sendReceipt" name="sendReceipt"
											onClick="OpenSendPopUp(${receiptMovementDTO.getReceiptId()},${receiptMovementDTO.getReceiptMovementId()})">Send</a>

									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text cssClass="bold"
										name="label-receipt-inbox-actions" align="center">
										<span><a href="#" class="button open"
											onclick="receiptReceiveModal(${receiptMovementDTO.getReceiptId()},${receiptMovementDTO.getReceiptMovementId()})">
												<liferay-ui:message key="label-receipt-inbox-action-receive" />
										</a></span>
										<a class="filesend" id="sendReceipt" name="sendReceipt"
											onClick="OpenSendPopUp(${receiptMovementDTO.getReceiptId()},${receiptMovementDTO.getReceiptMovementId()})">Send</a>
										<%-- <span><a href="${sendReceiptURL}"> <liferay-ui:message
													key="label-receipt-inbox-action-send" />
										</a></span> --%>
									</liferay-ui:search-container-column-text>
								</c:otherwise>
							</c:choose>
						</c:if>
						<c:if
							test="${receiptMovementDTO.getReadOn()!=null || receiptMovementDTO.getReceivedOn()!=null}">

							<liferay-ui:search-container-column-text name="">
								<%=receiptMovementDTO.getNature().charAt(0)%>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text property="receiptNumber" cssClass="hyberlink-css"
								orderableProperty="receiptNumber" orderable="true"
								href="<%=receiptDetails%>" name="label-receipt-inbox-receiptno" />

							<liferay-ui:search-container-column-text property="subject"
								cssClass="hover-tips" orderableProperty="subject"
								orderable="true" name="label-receipt-inbox-subject" />

							<%
								ReceiptMovement receiptMvmt = ReceiptMovementLocalServiceUtil
															.getReceiptMovement(receiptMovementDTO.getReceiptMovementId());
													long senderId = receiptMvmt.getSenderId();
							%>

							<liferay-ui:search-container-column-text
								name="label-receipt-inbox-sentby" cssClass="hover-tips">
								<a href="#" class="button open"
									onclick=" showModal(<%=senderId%>)"><%=receiptMovementDTO.getSentBy()%></a>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="label-receipt-inbox-senton" orderableProperty="sentOn"
								orderable="true" />
							<liferay-ui:search-container-column-text
								value="<%=simpleFormat.format(receiptMovementDTO.getDueDate())%>"
								name="label-receipt-inbox-dueon" orderableProperty="dueOn"
								orderable="true" />

							<liferay-ui:search-container-column-text cssClass="hover-tips"
								value="<%=receiptMovementDTO.getRemark() != null ? receiptMovementDTO.getRemark() : ""%>"
								name="label-receipt-inbox-remarks" />

							<c:choose>
								<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text
										name="label-receipt-inbox-actions" align="center">
										<%-- <span><a href="${sendReceiptURL}"> <liferay-ui:message
													key="label-receipt-inbox-action-send" />
										</a></span> --%>
												<a class="filesend" id="sendFile" name="sendFile"
											onClick="OpenSendPopUp(${receiptMovementDTO.getReceiptId()},${receiptMovementDTO.getReceiptMovementId()})">Send</a>
								
									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text
										name="label-receipt-inbox-actions" align="center">
										<%-- <span><a href="${sendReceiptURL}"> <liferay-ui:message
													key="label-receipt-inbox-action-send" />
										</a></span> --%>
											<a class="filesend" id="sendFile" name="sendFile"
											onClick="OpenSendPopUp(${receiptMovementDTO.getReceiptId()},${receiptMovementDTO.getReceiptMovementId()})">Send</a>
								
									</liferay-ui:search-container-column-text>
								</c:otherwise>
							</c:choose>
						</c:if>
					</c:when>
				</c:choose>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>

<!-- checker of read  -->
<div class="ml-3" id="alert-remove-read"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); margin-right: 74%; margin-top: -40px;">
	<liferay-ui:error key="read-not-available"
		message="receipt-read-inbox-error" />
</div>
<!-- checker of receive  -->
<div class="ml-3" id="alert-remove-receive"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); margin-right: 73%; margin-top: -40px;">
	<liferay-ui:error key="receive-not-available"
		message="receipt-receive-inbox-error" />
</div>

<!-- checker of send  -->
<liferay-ui:success key="send-available"
	message="receipt-send-inbox-success" />
<div class="ml-3" id="alert-remove-send"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); margin-right: 74%; margin-top: -40px;">
	<liferay-ui:error key="send-not-available"
		message="receipt-send-inbox-error" />
</div>


<!-- Receive pop up -->
<div id="receive" class="receive-popup">
	<!--   Creates the popup content-->
	<div class="receive popup-content">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -4%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<div class="container mt-3 mb-3">
			<h3 class="text-center">Are you sure to receive?</h3>
			<aui:form action="${receiptReceiveAction}" method="POST" name="fm"
				style=" margin-top: -5%;">
				<!-- <text>Receipt Number </text> -->
				<input type="text" hidden name='<portlet:namespace/>receiptId'
					id="receive-receiptId" />
				<input type="text" name='<portlet:namespace/>rmId' id="rmId" hidden />
				<br>
				<button class="mt-3 btn btn-primary " style="width: 90px;"
					type="submit">Receive</button>
				<div class="mt-3 btn btn-primary cancel" style="width: 90px;">Cancel</div>
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
		<div class="container mt-5 mb-5 border"
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
/* auto close alert for read */
$("#alert-remove-read").fadeTo(2000, 500).slideUp(500, function(){
    $("#alert-remove-read").slideUp(500);
});
/* auto close alert for receive */
$("#alert-remove-receive").fadeTo(2000, 500).slideUp(500, function(){
    $("#alert-remove-receive").slideUp(500);
});
/* auto close alert for send */
$("#alert-remove-send").fadeTo(2000, 500).slideUp(500, function(){
    $("#alert-remove-send").slideUp(500);
});

 function receiptReceiveModal(receiptId,rmId){
	document.getElementById("receive-receiptId").value=receiptId;
	document.getElementById("rmId").value=rmId;
	$("#receive").addClass("active");
	$("#rec_inbox").addClass("active");
	$(".close, .cancel").on("click", function() {
		  $("#receive").removeClass("active");
		  $("#rec_inbox").removeClass("active");
		});

 };
	
	
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
	$("#rec_inbox").addClass("active");
	$(".close").on("click", function() {
		  $("#sender-dtls").removeClass("active");
		  $("#rec_inbox").removeClass("active");
		});
	}
	
	
	
function OpenSendPopUp(receiptId,receiptmovementId){
	var receiptURL = '<%=receiptSendURL%>&<portlet:namespace/>receiptId='+receiptId+'&<portlet:namespace/>receiptmovementId='+receiptmovementId;
	
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
			uri: receiptURL
			
		});
	}

	
	
	
	
	
	
	
	
	
</script>

<!--end  -->