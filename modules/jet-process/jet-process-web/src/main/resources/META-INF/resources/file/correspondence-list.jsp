<%@page import="io.jetprocess.masterdata.model.FileCorrespondenceReceiptDTO"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="io.jetprocess.model.Receipt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import= "java.util.TimeZone"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%@ include file="../init.jsp"%> --%>
<%
	long corrFileId = (long) request.getAttribute("docFileId");
  	List<FileCorrespondenceReceiptDTO> receiptCorrList=MasterdataLocalServiceUtil.getFileCorrespondenceReceipteDetail(corrFileId);
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
             simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));	
%>
<style>
.crList th{
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
  float:right;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>

<portlet:renderURL var="fileInnerViewPopup" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName" value="/addCorrespondence"/>
</portlet:renderURL>

<h3>List Of Correspondences</h3>
<div class="dropdown">
  <i class="fa fa-bars " style="border: 3px solid black;font-size:26px">TOC</i>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>
<liferay-ui:search-container total="<%=receiptCorrList.size()%>"
		delta="5" deltaConfigurable="true"
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

 <%-- <table class="table">
	<thead>
		<!-- <tr class="crList row">
			<th class="col">
				<div class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></div>
			</th> -->
			<th><i class="fa fa-window-maximize" style="font-size:24px"></i></th>
			<th></th>
			<th></th>
			<th>Receipt No.</th>
			<th>Subject</th>
			<th>Type</th>
			<th>Marked On</th>
			<th>Attached</th>
			<th>Issued On</th>
			<th>Remarks</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items = "<%=receiptCorrList%>" var = "correspondenceList">
	
 <c:if test = "${empty correspondenceList}">
	<tr><td>No Records Found</td></tr> 
	</c:if> 
 <c:if test= "${not empty correspondenceList}">
 
	<tr>
	<td></td>
	<td><i class="fa fa-info-circle" style="color:blue;font-size:16px"></i></td>
	<c:if test = "${correspondenceList.nature == 'Electronic'}"> <td>E</td></c:if>
	<c:if test = "${correspondenceList.nature == 'Physical'}"> <td>P</td></c:if>
	<td>${correspondenceList.receiptNumber }</td>
	<td>${correspondenceList.subject }</td>
	<td>${correspondenceList.correspondenceType}</td>
	<td><fmt:formatDate type = "both" pattern= "dd-MM-yy hh:mm aa" timeZone = "Asia/Calcutta" value = "${correspondenceList.createDate}" /></td>
	
	<td>${correspondenceList.remark }</td> 
	</tr>
</c:if>
	</c:forEach>
	</tbody>
</table>  --%>
<!-- <div style="float: right;" >
<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="javascript:prevPage()" id="btn_prev" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="javascript:nextPage()" id="btn_next"aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>
</div> -->
<div>
<aui:button  cssClass="btn btn-primary" style="float: right;" name="add_receipt"  id="add_receipt" value="Add Receipt"> </aui:button>
</div>
<aui:script>
  AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',
   function(A) {
     A.one('#<portlet:namespace />add_receipt').on('click', function(event){
	var url = '<%= fileInnerViewPopup %>&<portlet:namespace/>corrFileId=<%= corrFileId %>';
	<!-- alert('URL --> '+url); -->
	var popUpWindow=Liferay.Util.Window.getWindow(
		{
		dialog: {
		centered: true,
		modal: true,
		height:800,
		width: 900
				}
		}
		).plug(
		A.Plugin.IO,
		{
		autoLoad: false
		}).render();
		popUpWindow.show();
		popUpWindow.titleNode.html("Put in file");
		popUpWindow.io.set('uri',url);
		popUpWindow.io.start();

		});
	});
</aui:script>


