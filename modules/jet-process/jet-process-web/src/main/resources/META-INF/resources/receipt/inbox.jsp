<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>


<style>
.table thead th {
	border-right: 1px solid white;
}
.popup{
  /*Hides pop-up when there is no "active" class*/
  visibility: hidden; 
  position: absolute;
  background: #ffffff;
  border: 3px solid #666666;
  width: 50%;
  height: 50%;
margin-top: -22%;
    left: 25%;
  
  
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
  border:none;
  /*margin-bottom:-40px;*/
  
  
}
</style>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/inbox.jsp" />
</liferay-portlet:renderURL>

<%
	List<ReceiptMovementDTO> receiptInboxList = MasterdataLocalServiceUtil
			.getReceiptInboxList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
	int count = receiptInboxList.size();
%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">Receipt InBox</h1>

		<liferay-ui:search-container total="<%=count%>" delta="5"
			iteratorURL="<%=iteratorURL%>">
			<liferay-ui:search-container-results results="<%=receiptInboxList %>" />
			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.ReceiptMovementDTO"
				keyProperty="receiptMovementId" modelVar="receiptMovementDTO">
			
				
				<portlet:renderURL var="sendURL">
					<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND %>" />
					<portlet:param name="receiptId" value="${receiptMovementDTO.getReceiptId()}" />
				</portlet:renderURL>

<portlet:actionURL name="receiveAction" var="formAction">
				</portlet:actionURL>
				<portlet:actionURL name="readAction" var="formAction1">
				</portlet:actionURL>

				<liferay-ui:search-container-column-text name="">
					<%=receiptMovementDTO.getNature().charAt(0)%>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text property="receiptNumber"
					name="Receipt No." />
					
				<liferay-ui:search-container-column-text property="subject"
					name="Subject" />
					
				<liferay-ui:search-container-column-text name="Sent By" cssClass="hover-tips" >
					<a href="#" class="button open"
						onclick=" showModal(${receiptMovementDTO.getReceiptId()})"><%=receiptMovementDTO.getSentBy()%></a>				</liferay-ui:search-container-column-text>

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
					
				<liferay-ui:search-container-column-text property="remark" name="Remarks">
					<c:if test="${not empty fileinboxDtoList.getRemark()}">
						<%=receiptMovementDTO.getRemark() %>
					</c:if>
				</liferay-ui:search-container-column-text>
				 
				<c:choose>
					<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
						<liferay-ui:search-container-column-text name="Action"
							align="center">
							<span><a href="#" class="button open"
								onclick="readModal(${receiptMovementDTO.getReceiptId()})">Read</a></span>
							<span><a href="${sendURL}">Send</a></span>
						</liferay-ui:search-container-column-text>
					</c:when>
					<c:otherwise>
						<liferay-ui:search-container-column-text name="Action"
							align="center">
							<span><a href="#" class="button open"
								onclick="receiveModal(${receiptMovementDTO.getReceiptId()})">Receive</a></span>
							<span><a href="${sendURL}">Send</a></span>
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
			<input type="text" name='<portlet:namespace/>receiptId'
				id="receive-receiptId" />
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
			<input type="text" name='<portlet:namespace/>receiptId'
				id="read-receiptId" />
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
			<input type="text" name="receiptId" id="dtls-receiptId" readOnly>
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

 function receiveModal(receiptId){
	alert(receiptId);
	document.getElementById("receive-receiptId").value=receiptId;
	$("#receive, .receive").addClass("active");
	$(".close").on("click", function() {
		  $("#receive, .receive").removeClass("active");
		});

		
	}

function readModal(receiptId){
	alert(receiptId);
	document.getElementById("read-receiptId").value=receiptId;
	$("#read, .read").addClass("active");
	$(".close").on("click", function() {
		  $("#read, .read").removeClass("active");
		});

		
	}

function showModal(receiptId){
	alert(receiptId);
	document.getElementById("dtls-receiptId").value=receiptId;
	$("#sender-dtls, .dtls").addClass("active");
	$(".close").on("click", function() {
		  $("#sender-dtls, .dtls").removeClass("active");
		});

		
	}


</script>

<!--end  -->