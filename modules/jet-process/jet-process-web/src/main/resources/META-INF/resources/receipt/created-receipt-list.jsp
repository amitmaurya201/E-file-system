<%@ include file="../init.jsp"%>
<%@ include file="../navigation.jsp"%>

<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="io.jetprocess.masterdata.model.ReceiptListViewDto"%>
<%@ page import="io.jetprocess.masterdata.service.MasterdataLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
 

<portlet:renderURL var="receiptInnerView">
    <portlet:param name="mvcPath" value="/receipt/receipt_view.jsp"/>
</portlet:renderURL>

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
<h1 class=" text-center">Receipt Created List</h1>
<liferay-ui:search-container  orderByType="<%=orderByType %>"  delta="15" deltaConfigurable="true" iteratorURL="${iteratorURL}" total="${totalUsers}" >
 
<liferay-ui:search-container-results >
    <%
    //Get all the results  from file created list
      List<ReceiptListViewDto> fileList = MasterdataLocalServiceUtil.getReceiptList(1);

    //usersPerPage is unmodifyable list. It can not be sorted.
    List<ReceiptListViewDto> usersPerPage = ListUtil.subList(fileList, searchContainer.getStart(),searchContainer.getEnd());
  
     
    //From usersPerPage a new list sortableUsers is created. For sorting we will use this list
    List<ReceiptListViewDto> sortableUsers = new ArrayList<ReceiptListViewDto>(usersPerPage);
    if(Validator.isNotNull(orderByCol)){
        //Pass the column name to BeanComparator to get comparator object
        BeanComparator comparator = new BeanComparator(orderByCol);
        if(sortingOrder.equalsIgnoreCase("asc")){
             
            //It will sort in ascending order
            Collections.sort(sortableUsers, comparator);
        }else{
            //It will sort in descending order
            Collections.reverse(sortableUsers);
        }
 
    }
 
    //sortableUsers list is sorted on the basis of condition. When page load it wont be sorted
    //It will be sorted only when a header of coulmn is clicked for sorting
    pageContext.setAttribute("results", sortableUsers);
  
    %>
</liferay-ui:search-container-results>
 
   <liferay-ui:search-container-row 
            className="io.jetprocess.masterdata.model.ReceiptListViewDto"
            keyProperty="receiptNumber">
     
   
        <liferay-ui:search-container-column-text  href="<%=receiptInnerView%>" property="receiptNumber" name="Receipt No." orderable="true" />
 
        <liferay-ui:search-container-column-text property="subject" />
 
        <liferay-ui:search-container-column-text property="category"  />
 
        <liferay-ui:search-container-column-text property="createDate" orderable="true" name="Create On" orderableProperty="createDate"/>
 
        <liferay-ui:search-container-column-text property="remark" name="Remarks" />
 
         
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator  />
</liferay-ui:search-container>
