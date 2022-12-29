<%@page import="io.jetprocess.model.ReceiptMovement"%>
<%@page import="io.jetprocess.service.ReceiptMovementLocalServiceUtil"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>


<%
String backURL = themeDisplay.getURLCurrent();

String backURL1 = backURL+"&a=12";

String readStatus = ParamUtil.getString(renderRequest, "readStatus");
String readResult = ParamUtil.getString(renderRequest, "readResult");
String receiveStatus = ParamUtil.getString(renderRequest,"receiveStatus");
String receiveResult = ParamUtil.getString(renderRequest,"receiveResult");
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
.tableSender th{
vertical-align: top;
}

.bold {
	font-size: 15px;
	font-weight: bold;
}
</style>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/inbox.jsp" />
</liferay-portlet:renderURL>


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

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="no record found" id="assignmentEntries"
			total="${inboxReceiptCount}"
			iteratorURL="${receiptInboxManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${receiptInboxList}" />
			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.ReceiptMovementDTO"
				keyProperty="receiptMovementId" modelVar="receiptMovementDTO">


				<portlet:renderURL var="sendURL">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND%>" />
					<portlet:param name="receiptId"
						value="${receiptMovementDTO.getReceiptId()}" />
						<portlet:param name="backPageURL" value="<%=backURL1 %>"></portlet:param>						
						
				</portlet:renderURL>

				<portlet:actionURL name="receiptReceiveAction"
					var="receiptReceiveAction">
					<portlet:param name="receiptId"
						value="${receiptMovementDTO.receiptId}" />
							<portlet:param name="rmId"
						value="${receiptMovementDTO.receiptMovementId}" />
				</portlet:actionURL>
				<portlet:actionURL name="receiptReadAction" var="receiptReadAction">
					<portlet:param name="receiptId1"
						value="${receiptMovementDTO.receiptId}" />
					<portlet:param name="rmId"
						value="${receiptMovementDTO.receiptMovementId}" />
							
				</portlet:actionURL>

				<portlet:renderURL var="receiptInnerView">
					<portlet:param name="mvcRenderCommandName" value="/receiptView" />
					<portlet:param name="receiptId"
						value="${receiptMovementDTO.getReceiptId()}" />
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
										name="label-receipt-inbox-receiptno" cssClass="bold"
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

							<liferay-ui:search-container-column-text
								value="<%=receiptMovementDTO.getSubject() != null ? receiptMovementDTO.getSubject() : ""%>"
								orderable="true" orderableProperty="subject"
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

							<%
								SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
													simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
							%>

							<liferay-ui:search-container-column-text cssClass="bold"
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="label-receipt-inbox-senton" />



							<liferay-ui:search-container-column-text property="dueDate"
								cssClass="bold"
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="label-receipt-inbox-dueon" />

							<liferay-ui:search-container-column-text
								cssClass="hover-tips bold" name="label-receipt-inbox-remarks"
								value="<%=receiptMovementDTO.getRemark() != null
											? receiptMovementDTO.getRemark()
											: ""%>">
								<%-- <c:if test="${not empty fileinboxDtoList.getRemark()}">
									<%=receiptMovementDTO.getRemark() != null ? receiptMovementDTO.getRemark() : ""%>
								</c:if> --%>
							</liferay-ui:search-container-column-text>

							<c:choose>
								<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text cssClass="bold"
										name="label-receipt-inbox-actions" align="center">
										<%-- <span><a href="#" class="button open"
											onclick="receiptReadModal(${receiptMovementDTO.getReceiptId()})">
												<liferay-ui:message key="label-receipt-inbox-action-read" />
										</a></span> --%>
										<span><a href="${sendURL}"> <liferay-ui:message
													key="label-receipt-inbox-action-send" />
										</a></span>
									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text cssClass="bold"
										name="label-receipt-inbox-actions" align="center">
										<span><a href="#" class="button open"
											onclick="receiptReceiveModal(${receiptMovementDTO.getReceiptId()},${receiptMovementDTO.getReceiptMovementId()} )">
												<liferay-ui:message key="label-receipt-inbox-action-receive" />
										</a></span>
										<span><a href="${sendURL}"> <liferay-ui:message
													key="label-receipt-inbox-action-send" />
										</a></span>
									</liferay-ui:search-container-column-text>
								</c:otherwise>
							</c:choose>

						</c:if>
						<c:if
							test="${receiptMovementDTO.getReadOn()!=null || receiptMovementDTO.getReceivedOn()!=null}">

							<liferay-ui:search-container-column-text name="">
								<%=receiptMovementDTO.getNature().charAt(0)%>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text property="receiptNumber"
								orderableProperty="receiptNumber" href="<%=receiptInnerView%>"
								name="label-receipt-inbox-receiptno" />

							<liferay-ui:search-container-column-text property="subject"
								orderableProperty="subject" name="label-receipt-inbox-subject" />

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

							<%
								SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
													simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
							%>

							<liferay-ui:search-container-column-text
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="label-receipt-inbox-senton" />

							<%-- <liferay-ui:search-container-column-text property="readOn"
					value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
					name="Read On" /> --%>

							<liferay-ui:search-container-column-text property="dueDate"
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="label-receipt-inbox-dueon" />

							<liferay-ui:search-container-column-text
								value="<%=receiptMovementDTO.getRemark() != null ? receiptMovementDTO.getRemark() : ""%>"
								name="label-receipt-inbox-remarks" />
							<%-- <c:if test="${not empty fileinboxDtoList.getRemark()}">
									<%=receiptMovementDTO.getRemark()%>
								</c:if> 
							</liferay-ui:search-container-column-text>--%>

							<c:choose>
								<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text
										name="label-receipt-inbox-actions" align="center">
										<span><a href="${sendURL}"> <liferay-ui:message
													key="label-receipt-inbox-action-send" />
										</a></span>
									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text
										name="label-receipt-inbox-actions" align="center">
										<span><a href="${sendURL}"> <liferay-ui:message
													key="label-receipt-inbox-action-send" />
										</a></span>
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

<% if(readStatus.equalsIgnoreCase("error")){ %>
		 <div class="alert alert-danger alert-dismissible" id="error-alert">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong><%= readResult %></strong>
  </div>
		<%} %>

<% if(receiveStatus.equalsIgnoreCase("error")){ %>
		 <div class="alert alert-danger alert-dismissible" id="error-alert">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong><%= receiveResult %></strong>
  </div>
		<%} %>

<!-- Receive pop up -->
<div id="receive" class="receive-popup">
	<!--   Creates the popup content-->
	<div class="receive popup-content">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -4%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<div class="container mt-3">
			<h3 class="text-center">Are you sure to receive?</h3>
			<aui:form action="${receiptReceiveAction}" method="POST" name="fm" style=" margin-top: -5%;">
				<!-- <text>Receipt Number </text> -->
				<input type="text" hidden name='<portlet:namespace/>receiptId'
					id="receive-receiptId" />
				<br>
				<input type="text"  name='<portlet:namespace/>rmId'
					id="rmId"  />
				<button class="mt-3 btn btn-primary " style="width: 90px;"
					type="submit">Receive</button>
				<div class="mt-3 btn btn-primary cancel" style="width: 90px;">Cancel</div>
			</aui:form>
		</div>
	</div>
</div>


<!-- Read pop up -->
<%-- <div id="read" class="read-popup">
	<!--   Creates the popup content-->
	<div class="">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close"
			style="float: right; margin-top: -6%; margin-right: -2%; font-size: 25px;">
			<span aria-hidden="true">&times;</span>
		</button>
		<div class="container mt-3">
			<h3 class="text-center">Are you sure to read ?</h3>
			<aui:form action="${receiptReadAction}" method="POST" name="fm">
				<!-- <text>Receipt Number </text> -->
				<input type="text" hidden name='<portlet:namespace/>receiptId1'
					id="read-receiptId" />
				<br>
				<button class="mt-3 btn btn-success" style="width: 90px;"
					type="submit">Read</button>
				<div class="mt-3 btn btn-danger cancle" style="width: 90px;">Cancle</div>
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

 function receiptReceiveModal(receiptId,rmId){
	document.getElementById("receive-receiptId").value=receiptId;
	document.getElementById("rmId").value=rmId;
	$("#receive").addClass("active");
	$("#rec_inbox").addClass("active");
	$(".close, .cancel").on("click", function() {
		  $("#receive").removeClass("active");
		  $("#rec_inbox").removeClass("active");
		});
	}

/* function receiptReadModal(receiptId){
	document.getElementById("read-receiptId").value=receiptId;
	$("#read").addClass("active");
	$("#rec_inbox").addClass("active");
	$(".close, .cancle").on("click", function() {
		  $("#read").removeClass("active");
		  $("#rec_inbox").removeClass("active");
		});

		
	} */
	

	 /* auto close alert */
	 
	$("#error-alert").fadeTo(2000, 500).slideUp(500, function(){
	    $("#error-alert").slideUp(500);
	});

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
	$("#rec_inbox").addClass("active");
	$(".close").on("click", function() {
		  $("#sender-dtls").removeClass("active");
		  $("#rec_inbox").removeClass("active");
		});
		
	}


</script>

<!--end  -->