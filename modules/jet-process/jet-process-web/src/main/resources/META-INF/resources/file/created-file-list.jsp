<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%-- <%@ include file="/css/main.scss"%> --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import= "java.util.TimeZone"%>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/created-file-list.jsp" />
</liferay-portlet:renderURL>


<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
	
	<liferay-portlet:actionURL name="fileSearch" var="formAction">
	</liferay-portlet:actionURL>
 <%
 String keyword="";
 try{
	 System.out.println("On Jsp ");
	  keyword=(String)request.getAttribute("keywords");
	 System.out.println("On Jsp : "+keyword);
 }catch(Exception ex){
	 System.out.println("Error in jsp : "+ ex.getMessage());
 }
 %>
 <br><br>
<aui:form action="<%=formAction%>" method="post" name="fm">
    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input label="" name="keywords" class="keywords" size="30" title="search-entries" type="text" />
            <aui:button type="submit" value="search"/>
        </span>
    </div>
</aui:form>
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
		<h1 class=" text-center">File Created List</h1>
		<%
			int count = MasterdataLocalServiceUtil
					.getFileListCount(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
		%>
		<liferay-ui:search-container orderByType="<%=orderByType%>" delta="2" total="<%=count%>" iteratorURL="<%=iteratorURL%>">

			<liferay-ui:search-container-results>
				<%
					//Get all the results  from file created list
							 List<FileListViewDto> filePerList =null ;
    String data = "%"+keyword+"%";
    System.out.println("After data assigning :- "+data);
    if(data.equalsIgnoreCase("%%") || data.equalsIgnoreCase("%null%")){
    	List<FileListViewDto> fileList = MasterdataLocalServiceUtil.getFileList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
    	filePerList = ListUtil.subList(fileList, searchContainer.getStart(),searchContainer.getEnd());
    	  System.out.println("After data fetching inside if :- "+filePerList);
    }
    else{
    	List<FileListViewDto> fileList = MasterdataLocalServiceUtil.getFileCreatedListSearchedData(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1, data);
    	filePerList = ListUtil.subList(fileList, searchContainer.getStart(),searchContainer.getEnd());
    	 System.out.println("After data fetching inside else :- "+filePerList);
    }


							List<FileListViewDto> sortableList = new ArrayList<FileListViewDto>(filePerList);
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

							//It will be sorted only when a header of coulmn is clicked for sorting
							pageContext.setAttribute("results", sortableList);
				%>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.FileListViewDto"
				keyProperty="fileNumber" modelVar="filedto">


				<portlet:renderURL var="fileInnerView">
					<portlet:param name="mvcRenderCommandName" value="/FileViewDetails" />
					<portlet:param name="docFileId" value="${filedto.docFileId}" />
				</portlet:renderURL>


				<liferay-ui:search-container-column-text href="<%=fileInnerView%>"
					name="File Number" property="fileNumber" orderable="true" />

				<liferay-ui:search-container-column-text property="subject" cssClass="hover-tips"
					name="Subject" />

				<liferay-ui:search-container-column-text property="category" />

<%
			SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
                simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		%>
		
				<liferay-ui:search-container-column-text value="<%=simpleformat.format(filedto.getCreateDate())%>"
					orderable="true" name="Created On" orderableProperty="createDate" />

				<liferay-ui:search-container-column-text property="remark"
					name="Remarks" />


			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>
	</div>

</div>


<script>
	$(document).ready(function() {
		setUserPostId();
	});
</script>
