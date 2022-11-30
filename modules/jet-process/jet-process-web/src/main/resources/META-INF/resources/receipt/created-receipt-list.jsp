<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp" %>
<%@ include file="/css/main.scss" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import= "java.util.TimeZone"%>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/created-receipt-list.jsp" />
</liferay-portlet:renderURL>

<style>
     .invisible{
       visibility: hidden !important;
     }
      .visible{
       visibility: visible !important;
     }
     
     
     
     .btn-close {
	    border-radius: 50%;
	    position: absolute;
	    top: 0px;
	    right: 0px;
	    padding: 1px;
	    /* z-index: 999999; */
	}
     
     .modal-body{
        position: relative;
     }
     
     
</style>

<div class="row">
	<div class="col-3">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-9">

<%
	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol");

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;
	//Logic for toggle asc and desc
	if (orderByType.equals("desc")) {
		orderByType = "asc";
	} else {
		orderByType = "desc";
	}

	if (Validator.isNull(orderByType)) {
		orderByType = "desc";
	}
%>
<h1 class=" text-center">Receipt Created List</h1>
<% int count = MasterdataLocalServiceUtil.getReceiptListCount(selectedUserPostId  != null ? Integer.parseInt(selectedUserPostId) : 1); %>


<liferay-ui:search-container orderByType="<%=orderByType %>" delta="5" total="<%=count%>" iteratorURL="<%=iteratorURL%>">

	<liferay-ui:search-container-results >
		<%
			//Get all the results  from file created list
					List<ReceiptListViewDto> fileList = MasterdataLocalServiceUtil.getReceiptList(selectedUserPostId  != null ? Integer.parseInt(selectedUserPostId) : 1);
				
					List<ReceiptListViewDto> listPerPage = ListUtil.subList(fileList, searchContainer.getStart(),
							searchContainer.getEnd());

					List<ReceiptListViewDto> sortableList = new ArrayList<ReceiptListViewDto>(listPerPage);
					if (Validator.isNotNull(orderByCol)) {
						//Pass the column name to BeanComparator to get comparator object
						BeanComparator comparator = new BeanComparator(orderByCol);
						if (sortingOrder.equalsIgnoreCase("asc")) {

							//It will sort in ascending order
							Collections.sort(sortableList, comparator);
						} else {
							//It will sort in descending order
							Collections.reverse(sortableList);
						}

					}

					pageContext.setAttribute("results", sortableList);
		%>
	</liferay-ui:search-container-results>


	<liferay-ui:search-container-row
		className="io.jetprocess.masterdata.model.ReceiptListViewDto"
		keyProperty="receiptNumber" modelVar="receipt" cssClass="colour" >

		<portlet:renderURL var="receiptInnerView">
			<portlet:param name="mvcPath" value="/receipt/receipt-view-nav.jsp" />
			 <portlet:param name="receiptId" value="${receipt.receiptId }" />
		<%--	<portlet:param name="userPostId" value="${receipt.userPostId }" /> --%>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text href="<%=receiptInnerView%>"
			property="receiptNumber" name="label-receipt-list-receiptno"  orderable="true" />

		<liferay-ui:search-container-column-text cssClass="hover-tips" property="subject" name="label-receipt-list-subject" />

		<liferay-ui:search-container-column-text property="category" name="label-receipt-list-category"/>
<%
			SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
                simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		%>

		<liferay-ui:search-container-column-text value="<%=simpleformat.format(receipt.getCreateDate())%>"
			orderable="true" name="label-receipt-list-create-date" orderableProperty="createDate"  />

		<liferay-ui:search-container-column-text property="remark" cssClass="remark"
			name="label-receipt-list-remark"  />
		
			
		<liferay-ui:search-container-column-text property="viewPdfUrl" cssClass="openPdf fa fa-file-pdf-o" name="label-receipt-list-pdf"  />


	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>


<portlet:renderURL var="viewPdf"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcPath" value="/receipt/pdf_view.jsp" />
			<portlet:param name="pdfUrl" value="${receipt.viewPdfUrl }" />
		</portlet:renderURL>
		
		
<div id="popup" class="modal invisible" tabindex="-1" >
  <div class="modal-dialog">
    <div class="modal-content" style="max-width: 70rem; margin: 0 auto;">
      <div class="modal-body" style="padding: 0">
      <button type="button" class="btn btn-white btn-close" data-bs-dismiss="modal" aria-label="Close">&#10005;</button>
          <div id="pdf">
          </div>
      </div>
      
	 </div>
  </div>
</div>



</div>
</div>



<script type="text/javascript">

$(document).ready(function(){
	
	
	/* let pdf= $(".openPdf").text();
	if (pdf !== ""){
		$(".openPdf").append('<i class="fa fa-file-pdf"></i>');
	} */
	
	
	$('.btn-close').on('click', function(e){
		//$('#popup').removeClass('visible').addClass('invisible');
		$('#popup').modal('hide');
	});
	
	$(".openPdf").on('click', function(e){
		
		//let url = 'http://localhost:8080'.trim()+encodeURIComponent((e.target.innerText).trim());
		let url = themeDisplay.getPortalURL()+(e.target.innerText).trim();
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
	
	setUserPostId();
	
});

</script>
