<%@page import="io.jetprocess.model.ReceiptMovement"%>
<%@page import="io.jetprocess.service.ReceiptMovementLocalServiceUtil"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
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

.button {
	border: none;
}

.tableSender {
	border-collapse: separate;
	border-spacing: 0 15px;
}

.bold {
	font-size: 15px;
	font-weight: bold;
}
</style>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/inbox.jsp" />
</liferay-portlet:renderURL>


<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">Receipt InBox</h1>

		<clay:management-toolbar
		        disabled="${inboxReceiptCount eq 0}"
		        displayContext="${receiptInboxManagementToolbarDisplayContext}"
		        itemsTotal="${inboxReceiptCount}"
		        searchContainerId="assignmentEntries"
		        managementToolbarDisplayContext="${receiptInboxManagementToolbarDisplayContext}"
		    />
			
		<liferay-ui:search-container
		delta="4"
        emptyResultsMessage="No-RECEIPT-INBOX"
        id="assignmentEntries"
        total="${inboxReceiptCount}" iteratorURL="${receiptInboxManagementToolbarDisplayContext._getCurrentURL()}"
        >
        <liferay-ui:search-container-results results="${receiptInboxList}" />
			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.ReceiptMovementDTO"
				keyProperty="receiptMovementId" modelVar="receiptMovementDTO">


				<portlet:renderURL var="sendURL">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND%>" />
					<portlet:param name="receiptId"
						value="${receiptMovementDTO.getReceiptId()}" />
				</portlet:renderURL>

				<portlet:actionURL name="receiveActionreceipt" var="formAction">
				</portlet:actionURL>
				<portlet:actionURL name="readActionreceipt" var="formAction1">
				</portlet:actionURL>
				
				<portlet:renderURL var="receiptInnerView">
						<portlet:param name="mvcRenderCommandName" value="/receiptView" />
						<portlet:param name="receiptId" value="${receiptMovementDTO.getReceiptId()}" />
						</portlet:renderURL>
				<c:choose>
					<c:when
						test="${receiptMovementDTO.getNature()=='Electronic' || receiptMovementDTO.getNature()=='Physical'}">
						<c:if
							test="${receiptMovementDTO.getReadOn()==null && receiptMovementDTO.getReceivedOn()==null}">

							<liferay-ui:search-container-column-text name="" cssClass="bold">
								<%=receiptMovementDTO.getNature().charAt(0)%>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text property="receiptNumber" orderable="true"  cssClass="bold"
								name="receiptNumber" />

							<liferay-ui:search-container-column-text property="subject" orderable="true" cssClass="bold"
								name="subject" />

							<%
								ReceiptMovement receiptMvmt = ReceiptMovementLocalServiceUtil
															.getReceiptMovement(receiptMovementDTO.getReceiptMovementId());
													long senderId = receiptMvmt.getSenderId();
							%>

							<liferay-ui:search-container-column-text name="Sent By"
								cssClass="hover-tips bold">
								<a href="#" class="button open"
									onclick=" showModal(<%=senderId%>)"><%=receiptMovementDTO.getSentBy()%></a>
							</liferay-ui:search-container-column-text>

							<%
								SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
													simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
							%>

							<liferay-ui:search-container-column-text cssClass="bold"
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="Sent On" />

							<%-- <liferay-ui:search-container-column-text cssClass="bold" property="readOn"
					value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
					name="Read On" /> --%>

							<liferay-ui:search-container-column-text property="dueDate" cssClass="bold"
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="Due On" />

							<liferay-ui:search-container-column-text cssClass="bold" property="remark"
								name="Remarks">
								<c:if test="${not empty fileinboxDtoList.getRemark()}">
									<%=receiptMovementDTO.getRemark()%>
								</c:if>
							</liferay-ui:search-container-column-text>

							<c:choose>
								<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text cssClass="bold" name="Action"
										align="center">
										<span><a href="#" class="button open"
											onclick="readModal(${receiptMovementDTO.getReceiptId()})">Read</a></span>
										<span><a href="${sendURL}">Send</a></span>
									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text cssClass="bold" name="Action"
										align="center">
										<span><a href="#" class="button open"
											onclick="receiveModal(${receiptMovementDTO.getReceiptId()})">Receive</a></span>
										<span><a href="${sendURL}">Send</a></span>
									</liferay-ui:search-container-column-text>
								</c:otherwise>
							</c:choose>

						</c:if>
						<c:if
							test="${receiptMovementDTO.getReadOn()!=null || receiptMovementDTO.getReceivedOn()!=null}">

							<liferay-ui:search-container-column-text name="">
								<%=receiptMovementDTO.getNature().charAt(0)%>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text property="receiptNumber" href="<%=receiptInnerView %>"
								name="Receipt No." />

							<liferay-ui:search-container-column-text property="subject"
								name="Subject" />

							<%
								ReceiptMovement receiptMvmt = ReceiptMovementLocalServiceUtil
															.getReceiptMovement(receiptMovementDTO.getReceiptMovementId());
													long senderId = receiptMvmt.getSenderId();
							%>

							<liferay-ui:search-container-column-text name="Sent By"
								cssClass="hover-tips">
								<a href="#" class="button open"
									onclick=" showModal(<%=senderId%>)"><%=receiptMovementDTO.getSentBy()%></a>
							</liferay-ui:search-container-column-text>

							<%
								SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
													simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
							%>

							<liferay-ui:search-container-column-text
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="Sent On" />

							<%-- <liferay-ui:search-container-column-text property="readOn"
					value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
					name="Read On" /> --%>

							<liferay-ui:search-container-column-text property="dueDate"
								value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
								name="Due On" />

							<liferay-ui:search-container-column-text property="remark"
								name="Remarks">
								<c:if test="${not empty fileinboxDtoList.getRemark()}">
									<%=receiptMovementDTO.getRemark()%>
								</c:if>
							</liferay-ui:search-container-column-text>

							<c:choose>
								<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
									<liferay-ui:search-container-column-text name="Action"
										align="center">
										<span><a href="${sendURL}">Send</a></span>
									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<liferay-ui:search-container-column-text name="Action"
										align="center">
										<span><a href="${sendURL}">Send</a></span>
									</liferay-ui:search-container-column-text>
								</c:otherwise>
							</c:choose>

						</c:if>
					</c:when>
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
		<div class="container mt-5">
			<aui:form action="${formAction}" method="POST" name="fm">

				<input type="text" name='<portlet:namespace/>receiptId'
					id="receive-receiptId" />
				<button type="submit">Receive</button>
			</aui:form>
		</div>
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
		<div class="container mt-5">
			<aui:form action="${formAction1}" method="POST" name="fm">

				<input type="text" name='<portlet:namespace/>receiptId1'
					id="read-receiptId" />
				<button type="submit">Read</button>
			</aui:form>
		</div>
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
		<div class="container mt-5 border">
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

/* $(document).ready(function(){
	console.log("----");
	if(${fileinboxDtoList.getReadOn()==null && fileinboxDtoList.getReceivedOn()==null}){
		console.log("--inside--");
		//var elem = document.getElementsByTagName("liferay-ui:search-container-column-text");
		$("liferay-ui:search-container-column-text").attr("cssClass","bold");
	}
}
 */
 function receiveModal(receiptId){
	alert(receiptId);
	document.getElementById("receive-receiptId").value=receiptId;
	$("#receive").addClass("active");
	$(".close").on("click", function() {
		  $("#receive").removeClass("active");
		});

		
	}

function readModal(receiptId){
	alert(receiptId);
	document.getElementById("read-receiptId").value=receiptId;
	$("#read").addClass("active");
	$(".close").on("click", function() {
		  $("#read").removeClass("active");
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
	$("#sender-dtls").addClass("active");
	$(".close").on("click", function() {
		  $("#sender-dtls").removeClass("active");
		});
		
	}


</script>

<!--end  -->