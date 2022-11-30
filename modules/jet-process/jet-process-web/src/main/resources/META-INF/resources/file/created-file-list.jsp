<%@ include file="../init.jsp"%>
<%@ include file="../navigation.jsp"%>
<%@ include file="/common/common.jsp" %> 

 <%-- 
 <portlet:renderURL var="fileInnerView">
    <portlet:param name="mvcPath" value="/file/details.jsp"/>
    <portlet:param name="fileNumber" value="${ posting}" />
</portlet:renderURL>
  --%>


<%
//orderByCol is the column name passed in the request while sorting
String orderByCol = ParamUtil.getString(request, "orderByCol"); 
 
//orderByType is passed in the request while sorting. It can be either asc or desc
String orderByType = ParamUtil.getString(request, "orderByType");
String sortingOrder = orderByType;
//Logic for toggle asc and desc
if(orderByType.equals("desc")){
    orderByType = "asc";
}else{
    orderByType = "desc";
}
 
if(Validator.isNull(orderByType)){
    orderByType = "desc";
}
 
%>
<h1 class=" text-center">File Created List</h1>
<% int count = MasterdataLocalServiceUtil.getFileListCount(selectedUserPostId  != null ? Integer.parseInt(selectedUserPostId) : 1); %>
<liferay-ui:search-container  orderByType="<%=orderByType %>"  delta="2" deltaConfigurable="true"  total="<%=count%>" >
 
<liferay-ui:search-container-results >
    <%
    //Get all the results  from file created list
      List<FileListViewDto> fileList = MasterdataLocalServiceUtil.getFileList(selectedUserPostId  != null ? Integer.parseInt(selectedUserPostId) : 1);

    List<FileListViewDto> filePerPage = ListUtil.subList(fileList, searchContainer.getStart(),searchContainer.getEnd());
  
     
    List<FileListViewDto> sortableList = new ArrayList<FileListViewDto>(filePerPage);
    if(Validator.isNotNull(orderByCol)){
        //Pass the column name to BeanComparator to get comparator object
        BeanComparator comparator = new BeanComparator(orderByCol);
        if(sortingOrder.equalsIgnoreCase("asc")){
             
            //It will sort in ascending order
            Collections.sort(sortableList, comparator);
        }else{
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
            keyProperty="fileNumber"
            modelVar="filedto">
     
     
 <portlet:renderURL var="fileInnerView">
    <portlet:param name="mvcRenderCommandName" value="/FileViewDetails"/>
    <portlet:param name="docFileId" value="${filedto.docFileId}"/>
 </portlet:renderURL>
  
     
        <liferay-ui:search-container-column-text href="<%=fileInnerView%>" name="" property="fileNumber" orderable="true" />
 
        <liferay-ui:search-container-column-text property="subject"  name="Subject" />
 
        <liferay-ui:search-container-column-text property="category"  />
 
        <liferay-ui:search-container-column-text property="createDate" orderable="true" name="Create On" orderableProperty="createDate"/>
 
        <liferay-ui:search-container-column-text property="remark"  name="Remarks" />
 
         
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator  />
</liferay-ui:search-container>

<script>
$(document).ready(function(){
	setUserPostId();
});
</script>
