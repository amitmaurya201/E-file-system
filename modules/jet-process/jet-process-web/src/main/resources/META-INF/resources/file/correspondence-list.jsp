<%@page import="io.jetprocess.model.Receipt"%>
<%@ page import="io.jetprocess.model.FileCorrReceipt" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<style>
.crList th{
	display: inline-block;
    width: max-content;
}
</style>
<portlet:renderURL var="fileInnerView" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName" value="/addCorrespondence"/>
</portlet:renderURL>
<%--  <% List<ReceiptListViewDto> receipt =(List<ReceiptListViewDto>)session.getAttribute("receiptCor"); 
 out.print(receipt);%>  --%>
 <%--  <% Receipt receipt =(Receipt)session.getAttribute("receiptCor");
  if(receipt!=null){
	  String nature = receipt.getNature();
	  out.print(nature);
  }
  out.print(receipt); %>  --%>
  <% List<FileCorrReceipt> fileCorrReceipt = (List<FileCorrReceipt>)session.getAttribute("fileCorrReceiptList"); 
  out.print(fileCorrReceipt);
  %>
<h3>List Of Correspondence</h3>
<table class="table col-12">
	<thead>
		<tr class="crList row">
			<th class="col">
				<div class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></div>
			</th>
			<th class="col" >Receipt No.</th>
			<th class="col">Subject</th>
			<th class="col">Type</th>
			<th class="col">Marked As</th>
			<th class="col">Attached On</th>
			<th class="col">Issued On</th>
			<th class="col">Remarks</th>
		</tr>
	</thead>
	<tbody>
	<tr><td>No Records Found</td></tr>
	<%-- <c:choose>
	<c:when test="${empty receipt}">
	<tr><td>No Records Found </td></tr>
	</c:when>
	<c:otherwise>
	<tr>
	<td>tytyty</td> 		
	</tr>
	</c:otherwise>
	</c:choose> --%>
	<%-- <c:if test = "${empty receipt}">
	     <tr><td>No Record Found </td></tr>
			</c:if>
			<c:if test="${not empty receipt }">
			<tr>
			
			<td><%=receipt%></td> 
			
			</tr>
			</c:if> --%>

	</tbody>
</table>
<div>
<aui:button name="add_receipt"  id="add_receipt" value="Add Receipt"> </aui:button>
</div>
<aui:script>
AUI().use('aui-base',
'aui-io-plugin-deprecated',
'liferay-util-window',
function(A) {
A.one('#<portlet:namespace />add_receipt').on('click', function(event){
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
popUpWindow.io.set('uri','<%=fileInnerView%>');
popUpWindow.io.start();

});
});
</aui:script>

