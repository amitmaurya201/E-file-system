<%@ include file="../init.jsp"%>
<%@ include file="../navigation.jsp"%>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>


<style>
	.tips{
		white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        max-width: 50ch;
        
	}
	.tips[title]:hover::after {
	  background-color: #fcf4ca;
	}
	
	
</style>



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
<% int count = MasterdataLocalServiceUtil.getReceiptListCount(1); %>
<liferay-ui:search-container orderByType="<%=orderByType %>" delta="2"
	deltaConfigurable="true" 
	total="<%=count%>">

	<liferay-ui:search-container-results>
		<%
			//Get all the results  from file created list
					List<ReceiptListViewDto> fileList = MasterdataLocalServiceUtil.getReceiptList(1);
				
					List<ReceiptListViewDto> listPerPage = ListUtil.subList(fileList, searchContainer.getStart(),
							searchContainer.getEnd());

					//From usersPerPage a new list sortableUsers is created. For sorting we will use this list
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
		keyProperty="receiptNumber" modelVar="receipt">

		<portlet:renderURL var="receiptInnerView">
			<portlet:param name="mvcPath" value="/receipt/receipt-view-nav.jsp" />
			 <portlet:param name="receiptId" value="${receipt.receiptId }" />
		<%--	<portlet:param name="userPostId" value="${receipt.userPostId }" /> --%>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text href="<%=receiptInnerView%>"
			property="receiptNumber" name="Receipt No." orderable="true" />

		<liferay-ui:search-container-column-text cssClass="tips" property="subject" />

		<liferay-ui:search-container-column-text property="category" />

		<liferay-ui:search-container-column-text property="createDate"
			orderable="true" name="Create On" orderableProperty="createDate" />

		<liferay-ui:search-container-column-text property="remark" cssClass="remark"
			name="Remarks" />
		
			
		<liferay-ui:search-container-column-text cssClass="openPdf fa fa-file-pdf-o" name="pdf" />


	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<portlet:renderURL var="viewPdf"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcPath" value="/receipt/pdf_view.jsp" />
			<portlet:param name="pdfUrl" value="${receipt.viewPdfUrl }" />
		</portlet:renderURL>
		
		
<script type="text/javascript">


$(".tips").hover(function() {
	
    $(this).attr('title', $(this).text());
    
    $("title").css('background-color','#fcf4ca');
});


$(".openPdf").on('click', function(e){
	
	var pdfUrl = '<%= viewPdf %>';
	Liferay.Util.openWindow({
		dialog:{

		height:900,
		modal: true,
		width:900,
		destroyOnHide: true,
		destroyOnClose: true
		},
		title:'View Pdf',
		
		uri:pdfUrl
		});
});
</script>
