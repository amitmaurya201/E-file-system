<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%-- <%@ include file="/css/main.scss" %> --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.TimeZone"%>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>


 <%
String backURL = themeDisplay.getURLCurrent();


%> 
 
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/created-receipt-list.jsp" />
</liferay-portlet:renderURL>

<style>
.invisible {
	visibility: hidden !important;
}

.visible {
	visibility: visible !important;
}

.btn-close {
	/* border-radius: 50%; */
	position: absolute;
	top: 0px;
	right: 0px;
	padding: 1px;
	/* z-index: 999999; */
}

.modal-body {
	position: relative;
}
</style>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<h1 class="text-center">Created Receipt List</h1>
		<clay:management-toolbar disabled="${receiptCount eq 0}"
			displayContext="${receiptManagementToolbarDisplayContext}"
			itemsTotal="${receiptCount}" searchContainerId="recieptId" />

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="no-Receipt-List" id="recieptId"
			total="${receiptCount}"
			iteratorURL="${receiptManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${receiptFileList}" />


			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.ReceiptListViewDto"
				keyProperty="receiptNumber" modelVar="receipt" cssClass="colour">

				<portlet:renderURL var="receiptInnerView">
					<portlet:param name="mvcRenderCommandName" value="/receiptView" />
					<portlet:param name="receiptId" value="${receipt.receiptId }" />
					<portlet:param name="backPageURL" value="<%= backURL %>"></portlet:param>
					
				</portlet:renderURL>

				<c:set var="firstLetterOfNature" value="${ receipt.nature}" />
				<c:set var="nature"
					value="${fn:substring(firstLetterOfNature, 0, 1)}" />
				<liferay-ui:search-container-column-text name="" value="${nature }" />


				<liferay-ui:search-container-column-text
					href="<%=receiptInnerView%>"
					value="<%=receipt.getReceiptNumber() != null ? receipt.getReceiptNumber() : ""%>"
					name="label-receipt-list-receiptno"
					orderableProperty="receiptNumber" orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="<%=receipt.getSubject() != null ? receipt.getSubject() : ""%>"
					name="label-receipt-list-subject" orderableProperty="subject"
					orderable="true" />

				<liferay-ui:search-container-column-text
					value="<%=receipt.getCategory() != null ? receipt.getCategory() : ""%>"
					cssClass="hover-tips" name="label-receipt-list-category" />
				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
							simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>

				<liferay-ui:search-container-column-text
					value="<%=receipt.getCreateDate() != null ? simpleformat.format(receipt.getCreateDate()) : ""%>"
					orderable="true" name="label-receipt-list-create-date"
					orderableProperty="createDate" />

				<liferay-ui:search-container-column-text
					value="<%=receipt.getRemark() != null ? receipt.getRemark() : ""%>"
					cssClass="hover-tips remark" name="label-receipt-list-remark" />

				<liferay-ui:search-container-column-text cssClass="text-center"
					name="label-receipt-list-pdf">
					<c:if test="${not empty receipt.viewPdfUrl}">
						<i style="cursor: pointer;" class="fa fa-file-pdf openPdf"
							data-url="${receipt.viewPdfUrl}"></i>
					</c:if>
				</liferay-ui:search-container-column-text>


			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator searchContainer="${searchContainer}"
				markupView="lexicon" />
		</liferay-ui:search-container>


		<portlet:renderURL var="viewPdf"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcPath" value="/receipt/pdf_view.jsp" />
			<portlet:param name="pdfUrl" value="${receipt.viewPdfUrl }" />
		</portlet:renderURL>


		<div id="popup" class="modal invisible" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="max-width: 70rem; margin: 0 auto;">
					<div class="modal-body" style="padding: 0">
						<button type="button" class="btn btn-white btn-close"
							data-bs-dismiss="modal" aria-label="Close">&#10005;</button>
						<div id="pdf"></div>
					</div>

				</div>
			</div>
		</div>



	</div>
</div>



<script type="text/javascript">

$(document).ready(function(){
	
	$('.btn-close').on('click', function(e){
		//$('#popup').removeClass('visible').addClass('invisible');
		$('#popup').modal('hide');
	});
	
	$(".openPdf").on('click', function(e){
		
		//let url = 'http://localhost:8080'.trim()+encodeURIComponent((e.target.innerText).trim());
		
		console.log($(this).attr('data-url'))
		let url = themeDisplay.getPortalURL()+($(this).attr('data-url')).trim();
		//let url = themeDisplay.getPortalURL()+(e.target.innerText).trim();
		
		//e.target.innerText="";
		console.log(url);
	<%--     var pdfUrl = '<%= viewPdf %>'; 
		console.log(pdfUrl);
 --%>		$('#popup').modal({
			  keyboard: false
	     });
		$('#popup').removeClass('invisible').addClass('visible');
		//console.log(${pdfUrl});
	 $('#popup').find('div#pdf').empty();
	 
	 let embeded= $('<embed/>',{type:'application/pdf',width:'100%',height:'500'}).appendTo($('#popup').find('div#pdf'));
	 //$('#popup').find('.modal-body').load(url);
		embeded.attr('src',url);
		
		
	});
	
});

</script>
