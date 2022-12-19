<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="io.jetprocess.web.display.context.FileManagementToolbarDisplayContext"%>
<%@ include file="../init.jsp"%>
  <%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
  <%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/common/common.jsp"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import= "java.util.TimeZone"%>

 

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
	
	<h1 class="text-center">File Created List</h1>
<clay:management-toolbar
        disabled="${fileCount eq 0}"
        displayContext="${fileManagementToolbarDisplayContext}"
        itemsTotal="${fileCount}"
        searchContainerId="assignmentEntries"
    />

<liferay-ui:search-container
		delta="${delta}"
        emptyResultsMessage="No-File-List"
        id="assignmentEntries"
        total="${fileCount}" iteratorURL="${fileManagementToolbarDisplayContext._getCurrentURL()}"
        >
        <liferay-ui:search-container-results results="${fileList}" />

        <liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.FileListViewDto"
				keyProperty="fileNumber" modelVar="filedto">


				<%-- <portlet:renderURL var="fileInnerView">
					<portlet:param name="mvcRenderCommandName" value="/FileViewDetails" />
					<portlet:param name="docFileId" value="${filedto.docFileId}" />
				</portlet:renderURL> --%>
				<portlet:renderURL var="fileInnerView">
					<portlet:param name="mvcRenderCommandName" value="/EditedView" />
					<portlet:param name="docFileId" value="${filedto.docFileId}" />
				</portlet:renderURL>

	<liferay-ui:search-container-column-text name=""  ><%= filedto.getNature().charAt(0) %></liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text href="<%=fileInnerView%>"
					name="label-file-list-fileno" property="fileNumber" orderableProperty="fileNumber" orderable="true" />

				<liferay-ui:search-container-column-text property="subject" orderable="true" orderableProperty="subject" cssClass="hover-tips"
					name="label-file-list-subject" />

				<liferay-ui:search-container-column-text property="category" name="category" cssClass="hover-tips" />

<%
			SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
                simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		%>
		
				<liferay-ui:search-container-column-text value="<%=simpleformat.format(filedto.getCreateDate())%>"
					 name="label-file-list-createon"  />

				<liferay-ui:search-container-column-text property="remark" 
					name="label-file-list-remark" />


			</liferay-ui:search-container-row>

        <%-- Iterator / Paging --%>
        
        <liferay-ui:search-iterator paginate="false" />
        <liferay-ui:search-paginator searchContainer="<%=new SearchContainer() %>" markupView="lexicon" />
        
    </liferay-ui:search-container>
	</div>
</div>

