<%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@ include file="../init.jsp"%>

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

		<div class="m-2 border boredr border-dark">
			<%
			 SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
			 simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
			%>
			<div class="m-2 border boredr border-dark">
				<liferay-ui:search-container delta="5" emptyResultsMessage="No Record Found" iteratorURL="${fileMovementDisplayContext.getCurrentURL()}" >
					<liferay-ui:search-container-results>
						<%
							List<FileMovementDTO> fileMovementList = new ArrayList();
							fileMovementList = (List<FileMovementDTO>) request.getAttribute("fileMovementList");
							searchContainer.setResultsAndTotal(fileMovementList);
							searchContainer.setTotalVar("" + fileMovementList.size() + "");
						%>
					</liferay-ui:search-container-results>
					<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.FileMovementDTO" modelVar="fileMovementDTO" keyProperty="fileMovementId">
						<liferay-ui:search-container-column-text value="<%=fileMovementDTO.getSentOn() != null ? simpleformat.format(fileMovementDTO.getSentOn()) : ""%>" name="label-sent-on"/>
						<liferay-ui:search-container-column-text value="<%=fileMovementDTO.getSentBy() != null ? fileMovementDTO.getSentBy() : ""%>" property="sentBy" name="label-sent-by"/>
						<liferay-ui:search-container-column-text value="<%=fileMovementDTO.getSentTo() != null ? fileMovementDTO.getSentTo() : ""%>" property="sentTo" name="label-sent-to"/>
						<liferay-ui:search-container-column-text value="<%=fileMovementDTO.getRemark() != null ? fileMovementDTO.getRemark() : ""%>" property="remark" name="label-remarks"/>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator markupView="lexicon"/>
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>

