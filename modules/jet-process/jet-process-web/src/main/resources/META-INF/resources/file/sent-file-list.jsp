<%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@page import= "java.util.TimeZone"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/sent-file-list.jsp" />
</liferay-portlet:renderURL>

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

<%
List<FileMovementDTO> sentFileList = MasterdataLocalServiceUtil.getFileSentListByUserPostId(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
int count = sentFileList.size();
%>


<div class="col-10">
		<h1 class=" text-center">SentFileList</h1>
<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" delta = "4" deltaConfigurable="true" total="<%= count %>">
<liferay-ui:search-container-results results="<%= sentFileList%>" />
	<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.FileMovementDTO" modelVar="sentFileListDTO" keyProperty="fileMovementId">
	<portlet:actionURL var="fileSentActionUrl" name="sentActionUrl">
	<portlet:param name="docFileId" value="${sentFileListDTO.docFileId}" />
				</portlet:actionURL>
				${sentFileListDTO.docFileId}
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
				<liferay-ui:search-container-column-text property="fileId" cssClass="hover-tips" name="FileId" />
				
				<liferay-ui:search-container-column-text name="Action">
				
			    	  
			<c:if test="${(empty sentFileListDTO.getReadOn()) and (empty sentFileListDTO.getReceivedOn())}">

						<button type="button" class="btn" data-bs-toggle="modal"
							data-bs-target="#myModal">
							<i class="icon-indent-left"></i>
						</button>
					</c:if>
				
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	
	<liferay-ui:search-iterator markupView="lexicon" />
	
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
						<aui:input label="" name="pullBackRemark" id="pullBackRemark" type="textarea">
							<aui:validator name="required"></aui:validator>
							<aui:validator name="maxLength">
								<liferay-ui:message key="receipt-sent-remarks-maxlength" />
							</aui:validator>
						</aui:input>
						
					</div>

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
	$("#sentActionUrl").click(function() {
		$("#myModal").modal("hide");
		
	});
</script>








    

