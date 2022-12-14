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

.popup-overlay {
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

.popup-overlay.active {
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
	<portlet:param name="mvcPath" value="/file/inbox.jsp" />
</liferay-portlet:renderURL>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	



	<div class="col-10">
		<h1 class=" text-center">File Inbox</h1>
		
		<clay:management-toolbar
        disabled="${fileInboxList eq 0}"
        displayContext="${fileInboxManagementToolbarDisplayContext}"
        itemsTotal="${fileInboxList}"
        searchContainerId="FileInboxEntries"
        managementToolbarDisplayContext="${fileInboxManagementToolbarDisplayContext}"
    />
		
		<liferay-ui:search-container
		delta="1"
        emptyResultsMessage="No-File-List"
        id="FileInboxEntries"
        total="${fileInboxList}" iteratorURL="${fileInboxManagementToolbarDisplayContext._getCurrentURL()}"
        >
        <liferay-ui:search-container-results results="${fileInboxList}" />
			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.FileMovementDTO"
				keyProperty="fileMovementId" modelVar="fileinboxDtoList">
				<portlet:renderURL var="sendURL">
					<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.FILE_SEND_RENDER_COMMAND %>"/>
					<portlet:param name="docFileId" value="${fileinboxDtoList.getFileId()}"/>
				</portlet:renderURL>

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
					<a href="#" class="button open" onclick=" showModal(${fileinboxDtoList.getFileId()})"><%=fileinboxDtoList.getSentBy() %></a>
						
					
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
					<span><a href="#">read</a></span>&nbsp;						
						<span><a href="${sendURL}">send</a></span>

				</liferay-ui:search-container-column-text>
				</c:when>
				<c:otherwise>
				<liferay-ui:search-container-column-text name="Action"
					align="center">
					
						<span><a href="#">received</a></span>&nbsp;
						<span><a href="${sendURL}">send</a></span>

				</liferay-ui:search-container-column-text>
				</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-row>
 
			<liferay-ui:search-iterator markupView="lexicon" />
			
		</liferay-ui:search-container>



	</div>

</div>





<!--popup code start  -->

<!--Creates the popup body-->
 <div class="popup-overlay"> 
<!--   Creates the popup content-->  
<div class="popup-content">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="float: right; margin-top: -5%;font-size: 25px;">
          <span aria-hidden="true">&times;</span>
     </button>
    
   <div class="container mt-5">
			<input type="text" name="fileId" id="fileId" readOnly>
			<%
				
			
			%>
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

function showModal(fileId){
	alert(fileId);
	document.getElementById("fileId").value=fileId;
	$(".popup-overlay, .popup-content").addClass("active");
	$(".close, .popup-overlay").on("click", function() {
		  $(".popup-overlay, .popup-content").removeClass("active");
		});

		
	}

/* 
//appends an "active" class to .popup and .popup-content when the "Open" button is clicked
$(".open").on("click", function() {
  $(".popup-overlay, .popup-content").addClass("active");
});

//removes the "active" class to .popup and .popup-content when the "Close" button is clicked 
$(".close, .popup-overlay").on("click", function() {
  $(".popup-overlay, .popup-content").removeClass("active");
});
 */
</script>


<!--end  -->


















