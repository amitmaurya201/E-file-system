<%@ include file="../init.jsp"%>

<style>
.lfr-search-container-wrapper a:not(.component-action):not(.btn) {
  color: #000000;
}
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

<%
String backPageURL = (String) request.getAttribute("backPageURL");
%>

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

		<h2
			style="text-align: center; text-decoration: underline; margin-top: 20px;">
			<liferay-ui:message key="label-file-movement-heading" />
		</h2>
		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="label-no-record-found"
			total="${fileMovementCount}"
			iteratorURL="${fileMovementDisplayContext.getCurrentURL()}">
			<liferay-ui:search-container-results results="${fileMovementList}" />


			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.FileMovementDTO"
				modelVar="fileMovementDTO" keyProperty="fileMovementId">
				<liferay-ui:search-container-column-text
					value="<%=fileMovementDTO.getSentOn() != null ? simpleformat.format(fileMovementDTO.getSentOn())
							: ""%>"
					name="label-sent-on" />
				<liferay-ui:search-container-column-text
					value="<%=fileMovementDTO.getSentBy() != null ? fileMovementDTO.getSentBy() : ""%>"
					name="label-sent-by" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					value="<%=fileMovementDTO.getSentTo() != null ? fileMovementDTO.getSentTo() : ""%>"
					name="label-sent-to" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					value="<%=fileMovementDTO.getRemark() != null ? fileMovementDTO.getRemark() : ""%>"
					name="label-remarks" cssClass="hover-tips" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>

