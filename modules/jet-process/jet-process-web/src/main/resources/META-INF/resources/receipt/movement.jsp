<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementListDTO"%>
<%@ include file="../init.jsp"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/created-file-list.jsp" />
</liferay-portlet:renderURL>

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
			 List<ReceiptMovementDTO> receiptMovementList = MasterdataLocalServiceUtil.getReceiptMovementDTOListByUserPostId(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
			 int count = receiptMovementList.size();
			%>
			<div class="m-2 border boredr border-dark">
				<liferay-ui:search-container total="<%= count %>" delta="2" iteratorURL="<%=iteratorURL%>">
					<liferay-ui:search-container-results results="<%= receiptMovementList%>" />
					<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.ReceiptMovementListDTO" modelVar="receiptMovementListDTO" keyProperty="receiptMovementId">
						<liferay-ui:search-container-column-text property="createdDate" name="Created Date"/>
						<liferay-ui:search-container-column-text property="remark" name="Remarks"/>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>
