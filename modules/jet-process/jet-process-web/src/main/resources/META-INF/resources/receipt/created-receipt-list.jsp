<%@ include file="/init.jsp"%>
<%@ include file="/navigation.jsp"%>

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
 
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

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
    int totalUsers =  MasterdataLocalServiceUtil.getMasterdatasCount() ;
     
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
    pageContext.setAttribute("total", totalUsers);
    %>
</liferay-ui:search-container-results>
 
   <liferay-ui:search-container-row 
            className="io.jetprocess.masterdata.model.ReceiptListViewDto"
            keyProperty="receiptNumber"
            modelVar="posting">
     
        <!-- orderableProperty="userId" this means that when this column is sorted orderByCol=userId is passed in the request-->
        <!-- if orderableProperty attribute is not mentioned then orderByCol=User Id is passed in request parameter at the time of sorting -->
        <!--orderable="true" means this column is sortable -->
        <!--Using name="User Id" we are saying that header should be User Id. If its not mentioned the header would be userId -->
        <%-- <liferay-ui:search-container-column-text  property="userId" orderable="true" name="User Id" orderableProperty="userId" /> --%>
 
        <liferay-ui:search-container-column-text property="receiptNumber" orderable="true" />
 
        <liferay-ui:search-container-column-text property="subject" orderable="true" name="" orderableProperty="subject"/>
 
        <liferay-ui:search-container-column-text property="category" orderable="true" />
 
        <liferay-ui:search-container-column-text property="createDate" orderable="true" name="" orderableProperty="createDate"/>
 
        <liferay-ui:search-container-column-text property="remark" orderable="true" name="" orderableProperty="remark"/>
 
         
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator  />
</liferay-ui:search-container>
