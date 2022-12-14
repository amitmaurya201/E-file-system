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
	margin-top: -35%;
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
	/*   display: inline-block;
  vertical-align: middle;
  border-radius: 30px;
  margin: .20rem;
  font-size: 1rem;
  color: #666666; */
	border: none;
	/*margin-bottom:-40px;*/
}
</style>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/inbox.jsp" />
</liferay-portlet:renderURL>

<%-- <liferay-portlet:actionURL name="inbox" var="formAction">
							
	                    </liferay-portlet:actionURL> --%>


<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

	<%
		List<FileMovementDTO> fileInboxList = MasterdataLocalServiceUtil
				.getFileInboxList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
		int count = fileInboxList.size();
	%>


	<div class="col-10">
		<h1 class=" text-center">File Inbox</h1>
		<liferay-ui:search-container total="<%=count%>" delta="5"
			iteratorURL="<%=iteratorURL%>">
			<liferay-ui:search-container-results results="<%=fileInboxList %>" />


			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.FileMovementDTO"
				keyProperty="fileMovementId" modelVar="fileinboxDtoList">
				<portlet:renderURL var="sendURL">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.FILE_SEND_RENDER_COMMAND%>" />
					<portlet:param name="docFileId"
						value="${fileinboxDtoList.getFileId()}" />
				</portlet:renderURL>


				<%-- <portlet:actionURL name="receiveAction" var="formAction">
				</portlet:actionURL>
				<portlet:actionURL name="readAction" var="formAction1">
				</portlet:actionURL> --%>


				<liferay-ui:search-container-column-text name="">
					<%=fileinboxDtoList.getNature().charAt(0)%>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text property="fileNumber"
					name="File No." />
				<liferay-ui:search-container-column-text property="subject"
					name="Subject" />
				<%-- <%
				String a=fileinboxDtoList.getSentBy();				
				String[] s=a.split(",");					
					
					
				%> --%>
				<liferay-ui:search-container-column-text name="Sent By"
					cssClass="hover-tips">

					<a href="#" class="button open"
						onclick=" showModal(${fileinboxDtoList.getFileId()})"><%=fileinboxDtoList.getSentBy()%></a>


				</liferay-ui:search-container-column-text>



				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
							simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>

				<liferay-ui:search-container-column-text
					value="<%=simpleformat.format(fileinboxDtoList.getSentOn())%>"
					name="Send On" />
				<liferay-ui:search-container-column-text property="dueDate"
					name="Due On" />
				<liferay-ui:search-container-column-text name="Remark">
					<c:if test="${not empty fileinboxDtoList.getRemark()}">
						<%=fileinboxDtoList.getRemark()%>
					</c:if>
				</liferay-ui:search-container-column-text>
				<c:choose>
					<c:when test="${fileinboxDtoList.getNature()=='Electronic'}">
						<liferay-ui:search-container-column-text name="Action"
							align="center">
							<span><a href="#" class="button open"
								onclick="readModal(${fileinboxDtoList.getFileId()})">read</a></span>
							<span><a href="${sendURL}">send</a></span>
						</liferay-ui:search-container-column-text>
					</c:when>
					<c:otherwise>
						<liferay-ui:search-container-column-text name="Action"
							align="center">
							<span><a href="#" class="button open"
								onclick="receiveModal(${fileinboxDtoList.getFileId()})">receive</a></span>
							<span><a href="${sendURL}">send</a></span>
						</liferay-ui:search-container-column-text>
					</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator markupView="lexicon" />


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
		<aui:form action="${formAction}" method="POST" name="fm">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close"
				style="float: right; margin-top: -5%; font-size: 25px;">
				<span aria-hidden="true">&times;</span>
			</button>
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
		<aui:form action="${formAction1}" method="POST" name="fm">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close"
				style="float: right; margin-top: -5%; font-size: 25px;">
				<span aria-hidden="true">&times;</span>
			</button>
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
			<input type="text" name="fileId" id="dtls-fileId" readOnly>
			<div class="row ">
				<div class="col-6">
					<table>
						<tr class="mt-1">
							<th>Name :</th>
							<td></td>
						</tr>
						<tr class="mt-1">
							<th>Marking Abbr. :</th>
							<td></td>
						</tr>
						<tr>
							<th>Section :</th>
							<td></td>
						</tr>
						<tr>
							<th>Email :</th>
							<td></td>
						</tr>
					</table>
				</div>
				<div class="col-6">
					<table>
						<tr>
							<th>Designation :</th>
							<td></td>
						</tr>
						<tr>
							<th>Post :</th>
							<td></td>
						</tr>
						<tr>
							<th>Department :</th>
							<td></td>
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

function showModal(fileId){
	alert(fileId);
	document.getElementById("dtls-fileId").value=fileId;
	$("#sender-dtls, .dtls").addClass("active");
	$(".close").on("click", function() {
		  $("#sender-dtls, .dtls").removeClass("active");
		});

		
	}


</script>

<!--end  -->


















