 <%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@page import= "java.util.TimeZone"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/sent-file-list.jsp" />
</liferay-portlet:renderURL>

<style>
.table thead th {
	border-right: 1px solid white;
}

.popup-overlay {
  visibility: hidden; 
  position: absolute;
  width: 30%;
  height: 30%;
  margin-top: -32%;
    left: 40%; 
}
.popup-overlay.active {
    visibility: visible;
  text-align: center;
}
.popup-content {
   visibility: hidden;
}
.popup-content.active {
    visibility: visible;
}
.button {
  border:none;  
}
</style>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

<%
List<FileMovementDTO> sentFileList = MasterdataLocalServiceUtil.getFileSentListByUserPostId(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
int count = sentFileList.size();
%>

<div class="col-10">
		<h1 class=" text-center">SentFileList</h1>
<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" delta = "4" deltaConfigurable="true" total="<%= count %>">
<liferay-ui:search-container-results results="<%= sentFileList%>" />
	<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.FileMovementDTO" modelVar="sentFileListDTO" keyProperty="fileMovementId">
	<liferay-ui:search-container-column-text name=""><%= sentFileListDTO.getNature().charAt(0) %></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="File No." property="fileNumber" orderable="true" />
				<liferay-ui:search-container-column-text property="subject" cssClass="hover-tips" name="Subject" />
				<liferay-ui:search-container-column-text property="sentTo" cssClass="hover-tips" name="Sent To" />
				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
	                simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>
				<liferay-ui:search-container-column-text value="<%=simpleformat.format(sentFileListDTO.getSentOn())%>" orderable="true" name="Sent On" orderableProperty="sentOn" />
				<liferay-ui:search-container-column-text property="sentTo" cssClass="hover-tips" name="Currently With" />
				<liferay-ui:search-container-column-text property="dueDate" cssClass="hover-tips" name="Due On" />
				<liferay-ui:search-container-column-text name="Action">
					<%-- <c:if test="${not empty FileMovementDTO.getReadOn() || not empty FileMovementDTO.getReceivedOn() }"> --%>
	                  <a href="#" class="button open"><i class="icon-indent-left"></i></a>
	
	
		
						<%-- 	</c:if> --%>
				</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	
	<liferay-ui:search-iterator markupView="lexicon" />
	
</liferay-ui:search-container>
</div>
</div>
	<!--Creates the popup body-->

 <div class="popup-overlay" id="pull-back-card"> 
<!--   Creates the popup content-->  
<div class="popup-content">
    

 <div class="card">
  <h4 class="card-header" style="background-color: #0074B7; text-align:left; margin-left:5px; padding-top:10px;color: white;">Reason for Pull-Back</h4>
    <label class="align-top " style="margin-right:320px; padding-top:10px;">Remarks<span class='text-danger'>*</span></label>
  <div class="card-body">
    <textarea rows="4" cols="50"></textarea>
    
  </div>
  <div class="card-footer"> 
  	<span><a href="#" class="btn btn-primary mr-4">OK</a>
<button type="button" class="btn btn-primary" aria-label="Close" id="cancel">Close</button></span>
  </div>
</div>
 
 </div>
 </div>





<script type="text/javascript">

$(".open").on("click", function() {
  $(".popup-overlay, .popup-content").addClass("active");
});

$("#cancel").on("click", function(){
	$("#pull-back-card").hide();
})

</script>





    

