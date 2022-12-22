<%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@page import= "java.util.TimeZone"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
.table thead th {
	border-right: 1px solid white;
}
	
	#myModal .modal-dialog .modal-content .modal-body .textOnInput {
	position: relative;
	background-color: #fff;
}

#myModal .modal-dialog .modal-content .modal-body .textOnInput label {
	position: absolute;
	background-color: #fff;
	top: -15px;
	left: 10px;
	padding: 2px;
	z-index: 1;
}

#myModal .modal-dialog .modal-content .modal-body .textOnInput label:after
	{
	content: " ";
	width: 100%;
	height: 13px;
	position: absolute;
	left: 0;
	bottom: 0;
	z-index: -1;
}

#myModal .modal-dialog .modal-content .modal-body label {
	font-size: 16px;
	font-weight: 500;
	display: inline-block;
	margin-bottom: .5rem;
}

</style>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>



<div class="col-10">

<h1 class=" text-center">File Sent List</h1>

<clay:management-toolbar
        disabled="${sendFileCount eq 0}"
        displayContext="${sendFileManagementToolbarDisplayContext}"
        itemsTotal="${sendFileCount}"
        searchContainerId="sendFileListEntries"
        managementToolbarDisplayContext="${sendFileManagementToolbarDisplayContext}"
    />

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/sent-file-list.jsp" />
</liferay-portlet:renderURL>

		
<liferay-ui:search-container
		delta="4"
        emptyResultsMessage="No-Sent-File-List"
        id="sendFileListEntries"
        total="${sendFileCount}" iteratorURL="${sendFileManagementToolbarDisplayContext._getCurrentURL()}" >
        <liferay-ui:search-container-results results="${sentFileList}" />

	<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.FileMovementDTO" modelVar="sentFileListDTO" keyProperty="fileMovementId">
	<portlet:actionURL var="fileSentActionUrl" name="sentActionUrl">
	<%-- <portlet:param name="docFileId" value="${sentFileListDTO.docFileId}" /> --%>
				</portlet:actionURL>
	<liferay-ui:search-container-column-text name=""><%= sentFileListDTO.getNature().charAt(0) %></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="File Number" value="<%=sentFileListDTO.getFileNumber() != null ? sentFileListDTO.getFileNumber() : ""%>" orderableProperty="fileNumber" orderable="true" />
				<liferay-ui:search-container-column-text value="<%=sentFileListDTO.getSubject() != null ? sentFileListDTO.getSubject() : ""%>" cssClass="hover-tips"  name="Subject" />
				<liferay-ui:search-container-column-text value="<%=sentFileListDTO.getSentTo() != null ? sentFileListDTO.getSentTo() : ""%>" cssClass="hover-tips" name="Sent To" />
				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
	                simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>
				<liferay-ui:search-container-column-text value="<%=simpleformat.format(sentFileListDTO.getSentOn())%>" orderable="true" name="Sent On" orderableProperty="sentOn" />
				<liferay-ui:search-container-column-text property="sentTo" cssClass="hover-tips" name="Currently With" />
				<liferay-ui:search-container-column-text property="dueDate" cssClass="hover-tips" name="Due Date" />
				<liferay-ui:search-container-column-text name="Action">	  
			<c:if test="${(empty sentFileListDTO.getReadOn()) and (empty sentFileListDTO.getReceivedOn())}">

						<button type="button" class="btn" onClick="getId(${sentFileListDTO.docFileId} , ${sentFileListDTO.fileMovementId} )" data-toggle="modal"
							data-target="#myModal">
							<i class="icon-indent-left"></i>
						</button>
					</c:if>
				
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	
	 <liferay-ui:search-iterator paginate="false" />
        <liferay-ui:search-paginator  searchContainer="${searchContainer}" markupView="lexicon" />
	
</liferay-ui:search-container>
</div>
</div>



<!-- The Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header"
				style="background-color: #96b4d6 !important;">
				<h4 class="modal-title">
					Reason for Pull-Back
				</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<aui:form action="${fileSentActionUrl}" name="sentActionUrl" method="POST" >
				
					
					<div class="textOnInput"> 
						<label>Remarks
						<span class='text-danger'>*</span></label>
						<aui:input label="" name="pullBackRemark" id="pullBackRemark" type="textarea" onkeypress="textareaLengthCheck(this)">
							<aui:validator name="required"></aui:validator>
							<aui:validator name="maxLength">
								<liferay-ui:message key="file-sent-remarks-maxlength" />
							</aui:validator>
						</aui:input>
						<p id="lblRemainingCount"></p>
					</div>
                     <input type="text" name="<portlet:namespace />docFileId" id="docFileId" hidden />
                     		<input type="text" name="<portlet:namespace />fileMovementId"
						id="fileMovementId" hidden >

					<hr style="margin: 1rem -14px;" />
					<div style="text-align: right;">
						<button type="submit" class="btn btn-primary" name="sentActionUrl"
							id="sentActionUrl">
							OK
						</button>
						<button type="button" class="btn btn-primary"
							data-bs-dismiss="modal">
					 	Cancel
						</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">

function getId(docFileId,fileMovementId){
	textField = document.getElementById("docFileId");
	  textField.value = docFileId;
		fileMovementIdField = document.getElementById("fileMovementId");
		  fileMovementIdField.value = fileMovementId; 
}

	$("#sentActionUrl").click(function() {
		$("#myModal").modal("hide");
		
	});
	

	function textareaLengthCheck(el) {
		  var textArea = el.value.length;
		  var charactersLeft = 500 - textArea;
		  var count = document.getElementById('lblRemainingCount');
		  count.innerHTML = "Total 500 " + " | " + charactersLeft + " Characters left ";
		}
	
	
	
</script>







    

