<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@include file="../init.jsp"%>

<portlet:renderURL var="urlForData">
     <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.RECEIPT_MOVEMENT_RENDER_COMMAND %>" />
     <portlet:param name="redirect" value="${currentURL}" />
 </portlet:renderURL>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/file/file-view-nav.jsp" servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="movement" />
		</liferay-util:include>
		<div class="m-2 border boredr border-dark">
			<%
			 SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
			 simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
			%>
			<div class="m-2 border boredr border-dark">
				<liferay-ui:search-container delta="5" emptyResultsMessage="No Record Found" iteratorURL="${receiptMovementDisplayContext.getCurrentURL()}" >
					<liferay-ui:search-container-results>
						<%
							List<ReceiptMovementDTO> receiptMovementList = (List<ReceiptMovementDTO>) request.getAttribute("receiptMovementList");
							searchContainer.setResultsAndTotal(receiptMovementList);
							searchContainer.setTotalVar("" + receiptMovementList.size() + "");
						%>
					</liferay-ui:search-container-results>
					<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.ReceiptMovementDTO" modelVar="receiptMovementDTO" keyProperty="receiptMovementId">
						<liferay-ui:search-container-column-text value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>" name="label-sent-on"/>
						<liferay-ui:search-container-column-text property="sentBy" name="label-sent-by"/>
						<liferay-ui:search-container-column-text property="sentTo" name="label-sent-to"/>
						<liferay-ui:search-container-column-text property="remark" name="label-remarks"/>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>
