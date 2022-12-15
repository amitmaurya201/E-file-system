<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="io.jetprocess.model.Receipt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%-- <%@ include file="../init.jsp"%> --%>
<%
	long corrFileId = (long) request.getAttribute("docFileId");
  	List<ReceiptListViewDto> receiptCorrList=MasterdataLocalServiceUtil.getFileCorrespondenceReceipt(corrFileId);
%>
<style>
.crList th{
	display: inline-block;
    width: max-content;
}
</style>

<portlet:renderURL var="fileInnerViewPopup" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName" value="/addCorrespondence"/>
</portlet:renderURL>

<h3>List Of Correspondences</h3>
 <table class="table">
	<thead>
		<!-- <tr class="crList row">
			<th class="col">
				<div class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></div>
			</th> -->
			<th></th>
			<th>Receipt No.</th>
			<th>Subject</th>
			<th>Type</th>
		<!-- 	<th>Marked On</th> -->
			<!-- <th>Attached</th> -->
			<!-- <th>Issued On</th> -->
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
	<td>${correspondenceList.nature }</td>
	<td>${correspondenceList.receiptNumber }</td>
	<td>${correspondenceList.subject }</td>
	<td>${correspondenceList.createDate}</td>
	<td>${correspondenceList.remark }</td> 
	</tr>
</c:if>
	</c:forEach>
	</tbody>
</table> 
<div>
<aui:button name="add_receipt"  id="add_receipt" value="Add Receipt"> </aui:button>
</div>
<aui:script>
  AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',
   function(A) {
     A.one('#<portlet:namespace />add_receipt').on('click', function(event){
	var url = '<%= fileInnerViewPopup %>&<portlet:namespace/>corrFileId=<%= corrFileId %>';
	alert('URL --> '+url);
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


