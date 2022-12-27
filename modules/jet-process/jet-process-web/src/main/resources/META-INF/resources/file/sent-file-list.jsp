<%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@page import= "java.util.TimeZone"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.popup, .pull_back-popup {
	position: absolute;
	background: #bebec1;
	border: 3px solid #666666;
	margin-top: -30%;
	left: 30%;
	display: none;
}

.popup {
	width: 50%;
	height: 50%;
}

.pull_back-popup {
	width: 35%;
	height: 54%;
	left: 37%;
	background: #afc6e0;
}

.popup.active, .pull_back-popup.active {
	text-align: center;
	display: block;
}

#rec_inbox.active {
	pointer-events: none;
	opacity: 0.5;
}

.button {
	border: none;
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
				<liferay-ui:search-container-column-text name="Actions">	  
			<c:if test="${(empty sentFileListDTO.getReadOn()) and (empty sentFileListDTO.getReceivedOn())}">

						<button type="button" class="btn" onClick="getId(${sentFileListDTO.docFileId} , ${sentFileListDTO.fileMovementId} )" 
							>
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

<!-- pull_back pop up -->
<div id="pull_back" class="pull_back-popup">
	<!--   Creates the popup content-->
	<div class="container mt-3">
		<div>
			<button type="button" class="close popup_close"
				style="float: right; font-size: 25px; color:white;font-weight: bold;">
				<span aria-hidden="true">&times;</span>
			</button>
			<h3 style="color:white; text-align: left;">
				<liferay-ui:message key="label-file-sent-popup-heading" />
			</h3>
		</div>
		<hr style="margin: 1rem -14px;" />
		<aui:form action="${fileSentActionUrl}" method="post" name="sentActionUrl">
			
			<div style="text-align: left; height: 100px;">
				<aui:input label="label-file-remark" name="pullBackRemark" id="pullBackRemarks"
					type="textarea" onkeyup="countChar(this)">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="maxLength">
						<liferay-ui:message key="file-sent-remarks-maxlength" />
					</aui:validator>
					
				</aui:input>
				<p>Total 500 | <span id="lblRemainingCount">500</span><span> Character left</span></p>
				
			</div>
                   <input type="text" name="<portlet:namespace />docFileId" id="docFileId" hidden />
                     		<input type="text" name="<portlet:namespace />fileMovementId"
						id="fileMovementId" hidden >
                  
			<hr style="margin: 1.4rem -14px;" />
			<div style="text-align: right;">
				<button type="submit" class="btn btn-primary" id="submit_pull_back">
					<liferay-ui:message key="label-file-sent-button-submit" />
				</button>
				<button type="button" class="btn btn-primary popup_close" id="close">
					<liferay-ui:message key="label-file-sent-button-cancel" />
				</button>
			</div>
		</aui:form>
	</div>
</div>



<script type="text/javascript">

function getId(docFileId,fileMovementId){
	textField = document.getElementById("docFileId");
	  textField.value = docFileId;
		fileMovementIdField = document.getElementById("fileMovementId");
		  fileMovementIdField.value = fileMovementId; 
		  $("#<portlet:namespace />pullBackRemarks").val("");
		  $("#pull_back").addClass("active");
			$("#rec_inbox").addClass("active");
			$(".popup_close").on("click", function() {
				  $("#pull_back").removeClass("active");
				  $("#rec_inbox").removeClass("active");
				});
}
	// set total character 
	function countChar(val) {
		  var len = val.value.length;
		  if (len >= 500) {
			
		    val.value = val.value.substring(0, 500);
		  } else {
		   var count = $('#lblRemainingCount').text(500 - len);
		  }
		};

		
		
		
</script>







    

