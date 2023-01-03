<%@page import="io.jetprocess.list.model.FileMovementDTO"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>

<style>
<!--
.text-secondary {
	color: #0c5460;
	background-color: #d1ecf1;
	border-color: #bee5eb;
	font-size: 25px;
	margin-right: 15px;
}
-->
</style>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/created-file-list.jsp" />
</liferay-portlet:renderURL>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="movement" />
		</liferay-util:include>
		<%-- <%@ include file="file-view.jsp" %> --%>

		<%
			SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
			simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		%>
		<h2 style="text-align: center; text-decoration: underline; margin-top: 20px;">
			<liferay-ui:message key="label-file-movement-heading" />
		</h2>
		<liferay-ui:search-container delta="4"
			emptyResultsMessage="label-no-record-found"
			iteratorURL="${fileMovementDisplayContext.getCurrentURL()}">
			<liferay-ui:search-container-results>
				<%
					List<FileMovementDTO> fileMovementList = new ArrayList();
							fileMovementList = (List<FileMovementDTO>) request.getAttribute("fileMovementList");
							searchContainer.setResultsAndTotal(fileMovementList);
							searchContainer.setTotalVar("" + fileMovementList.size() + "");
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.FileMovementDTO"
				modelVar="fileMovementDTO" keyProperty="fileMovementId">
				<liferay-ui:search-container-column-text
						value="<%=fileMovementDTO.getSentOn() != null ? simpleformat.format(fileMovementDTO.getSentOn())
							: ""%>"
						name="label-sent-on" />
				<liferay-ui:search-container-column-text
					value="<%=fileMovementDTO.getSentBy() != null ? fileMovementDTO.getSentBy() : ""%>"
					name="label-sent-by"  cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					value="<%=fileMovementDTO.getSentTo() != null ? fileMovementDTO.getSentTo() : ""%>"
					name="label-sent-to"  cssClass="hover-tips"  />
				<liferay-ui:search-container-column-text
					value="<%=fileMovementDTO.getRemark() != null ? fileMovementDTO.getRemark() : ""%>"
					name="label-remarks"  cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					value="<%=fileMovementDTO.getPullBackRemark() != null ? fileMovementDTO.getPullBackRemark() : ""%>"
					name="label-pullback-remark"  cssClass="hover-tips" />

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>

