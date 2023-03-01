<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="io.jetprocess.list.model.FileCorrespondenceReceiptDTO"%>
<%@ include file="../init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	io.jetprocess.list.model.FileCorrespondenceReceiptDTO filecorr = (io.jetprocess.list.model.FileCorrespondenceReceiptDTO) row
			.getObject();
/* 
	out.println(filecorr); */
%>

<style>
	.custom-icon{
		width:50px !important;
		height:50px !important;
	}
</style>

<portlet:renderURL var="corrDetachURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" >
			<portlet:param name="receiptId"
                value="<%= String.valueOf(filecorr.getReceiptId()) %>" />
			<portlet:param name="rmId"
                value="<%= String.valueOf(filecorr.getReceiptMovementId()) %>" />
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.Corr_RECEIPT_DETACH_RENDER_COMMAND%>" />
		</portlet:renderURL>
		
		
		
		<portlet:renderURL var="corrCloseURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" >
			<portlet:param name="receiptId"
                value="<%= String.valueOf(filecorr.getReceiptId()) %>" />
			<portlet:param name="rmId"
                value="<%= String.valueOf(filecorr.getReceiptMovementId()) %>" />
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.Corr_RECEIPT_CLOSE_RENDER_COMMAND %>" />
		</portlet:renderURL>

<portlet:renderURL var="corrReopenURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" >
			<portlet:param name="receiptId"
                value="<%= String.valueOf(filecorr.getReceiptId()) %>" />
			<portlet:param name="reopenMovementId"
                value="<%= String.valueOf(filecorr.getReceiptMovementId()) %>" />
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.RECEIPT_REOPEN_POP_UP %>" />
		</portlet:renderURL>


<%-- <liferay-ui:icon-menu useIconCaret="true" icon="<%=request.getContextPath() + "/image/pullback.png"%>" cssClass="custom-icon"  > --%>
<liferay-ui:icon-menu useIconCaret="true" cssClass="text-light" >

	<liferay-ui:icon image="delete_attachment" message="Detach" useDialog="true" url="<%=corrDetachURL.toString()%>" />

		
	<liferay-ui:icon image="folder_open" useDialog="true" message="Reopen"
		url="<%=corrReopenURL.toString()%>" />
		
		<liferay-ui:icon image="close" useDialog="true" message="Close"
		url="<%=corrCloseURL.toString()%>" />
		


</liferay-ui:icon-menu>



