<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<%@page
	import="io.jetprocess.masterdata.model.FileCorrespondenceReceiptDTO"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="io.jetprocess.model.Receipt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.TimeZone"%>
<%@page
	import="io.jetprocess.web.display.context.FileCorrespondenceManagementToolbarDisplayContext"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../init.jsp"%>  --%>
<%
	//long corrFileId = (long) request.getAttribute("docFileId");
 HttpSession docFileIdValue = themeDisplay.getRequest().getSession();
 long corrFileId  = (long) docFileIdValue.getAttribute("putInFileId"); 	
	List<FileCorrespondenceReceiptDTO> receiptCorrList = MasterdataLocalServiceUtil.getFileCorrespondenceReceipteDetail(corrFileId);
	SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
	simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
%>
<style>
.crList th {
	display: inline-block;
	width: max-content;
}

.dropbtn {
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
	float: right;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.put-heading {
	background-color: #96b4d6;
	color: white;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>
<portlet:renderURL var="fileInnerViewPopup"
		windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.CORRESPONCE_FILE_RENDER %>" />
	</portlet:renderURL>

<div>
	<div class="" style="font-size: 18px">
		<text class="pr-4 float-left put-heading" style="border-radius:0px 100px 0px 0px; ">List Of Correspondences     </text>
		<div class="pl-2 pr-2 dropdown float-right put-heading" style="border-radius:100px 0px 0px 100px;">
			<i class="fa fa-bars " >TOC</i>
			<div class="dropdown-content">
				<a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link 3</a>
			</div>
		</div>
	</div>
	<liferay-ui:search-container total="<%=receiptCorrList.size()%>"
		delta="2" deltaConfigurable="true"  iteratorURL="${fileCorrespondenceManagementToolbarDisplayContext._getCurrentURL()}"
		emptyResultsMessage="No Results Found">
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(receiptCorrList, searchContainer.getStart(), searchContainer.getEnd())%>" />

		<liferay-ui:search-container-row
			className="io.jetprocess.masterdata.model.FileCorrespondenceReceiptDTO"
			modelVar="aFileCorrespondenceReceiptDTO">
			<liferay-ui:search-container-column-text>
			<i class="fa fa-info-circle" style="color:blue;font-size:16px"></i>
			</liferay-ui:search-container-column-text>
		
			<liferay-ui:search-container-column-text ><%=aFileCorrespondenceReceiptDTO.getNature().charAt(0)%></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name = " Receipt No." property="receiptNumber" />
			<liferay-ui:search-container-column-text property="subject" />
		
		<liferay-ui:search-container-column-text  name="type" property="correspondenceType"/>
		
		<liferay-ui:search-container-column-text  name="Attached On" value="<%=simpleformat.format(aFileCorrespondenceReceiptDTO.getCreateDate())%>"/>
			<liferay-ui:search-container-column-text name = "Remarks" property="remark" />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>


	<div>
		<aui:button cssClass="btn btn-primary" style="float: right;"
			name="add_receipt" id="add_receipt" value="Add Receipt" >
		</aui:button>
		
	</div>

</div>

<aui:script use="liferay-util-window">	
	$("#<portlet:namespace />add_receipt").click(()=>{
		alert("calledd <%= fileInnerViewPopup %>");
		Liferay.Util.openWindow({ 
					dialog: { 														 
							height: 800,														 
							destroyOnClose: true,														 
							destroyOnHide: true, 														 
							modal: true, 														 
							width: 900 														 
						}, 														 
						id: '<portlet:namespace />dialog',														 
						title: 'My Title', 														 
						uri: '<%= fileInnerViewPopup %>&<portlet:namespace/>corrFileId=<%=corrFileId %>',			
																			 
		}); 
	});	
	
	</aui:script>
	
	
