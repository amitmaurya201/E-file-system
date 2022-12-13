<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@ include file="../init.jsp"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
#myModal .modal-dialog .modal-content .modal-body .textOnInput {
	position: relative;
	background-color: #fff;
}

#myModal .modal-dialog .modal-content .modal-body .textOnInput label {
	position: absolute;
	background-color: #fff;
	top: -15px;
	left: 10px;
	padding: 2px;
	z-index: 1;
}

#myModal .modal-dialog .modal-content .modal-body .textOnInput label:after
	{
	content: " ";
	width: 100%;
	height: 13px;
	position: absolute;
	left: 0;
	bottom: 0;
	z-index: -1;
}

#myModal .modal-dialog .modal-content .modal-body label {
	font-size: 16px;
	font-weight: 500;
	display: inline-block;
	margin-bottom: .5rem;
}
</style>




<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">


		<liferay-portlet:renderURL varImpl="iteratorURL">
			<portlet:param name="mvcPath" value="/receipt/sent_list.jsp" />
		</liferay-portlet:renderURL>

		<liferay-portlet:renderURL var="pullBackURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcPath" value="/receipt/pull_back.jsp" />
		</liferay-portlet:renderURL>

		<h1 class=" text-center">Receipt Sent List</h1>

		<div class="m-2 border boredr border-dark">
			<%
				List<ReceiptMovementDTO> receiptMovementList = MasterdataLocalServiceUtil
						.getReceiptSentList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
				int count = receiptMovementList.size();
				SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
				simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
			%>
			<div class="m-2 border boredr border-dark">
				<liferay-ui:search-container total="<%=count%>" delta="2"
					iteratorURL="<%=iteratorURL%>">
					<liferay-ui:search-container-results
						results="<%= receiptMovementList%>" />

					<liferay-ui:search-container-row
						className="io.jetprocess.masterdata.model.ReceiptMovementDTO"
						modelVar="receiptSentMovement" keyProperty="receiptMovementId">
						<%
							String nature = receiptSentMovement.getNature();
									char currentNature = nature.charAt(0);
						%>
						<liferay-ui:search-container-column-text name="Nature"
							value="<%=Character.toString(currentNature)%>" />
						<liferay-ui:search-container-column-text property="receiptNumber"
							name="Receipt Number" />
						<liferay-ui:search-container-column-text property="subject"
							name="Subject" />
						<liferay-ui:search-container-column-text property="sender"
							name="Sender" />
						<liferay-ui:search-container-column-text property="sentTo"
							name="Sent To" />
						<liferay-ui:search-container-column-text name="Sent On"
							value="<%=simpleformat.format(receiptSentMovement.getSentOn())%>" />
						<liferay-ui:search-container-column-text property="dueDate"
							name="Due Date" />
						<liferay-ui:search-container-column-text property="remark"
							name="Remark" />
						<liferay-ui:search-container-column-text name="Action">
							<c:if
								test="${(empty receiptSentMovement.getReadOn()) and (empty receiptSentMovement.getReceivedOn())}">

								<button type="button" class="btn" data-bs-toggle="modal"
									data-bs-target="#myModal">
									<i class="icon-indent-left"></i>
								</button>

							</c:if>
						</liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>

<%-- 

			</div> -->
	<aui:form>
		<div class="receipt textOnInput">
			<label><liferay-ui:message key="label-receipt-remark" /><span
				class='text-danger'>*</span></label>
			<aui:input label="" name="remarks" id="remarks">
				<aui:validator name="required"></aui:validator>
				<aui:validator name="maxLength">
					<liferay-ui:message key="receipt-input-maxlength" />
				</aui:validator>
			</aui:input>
		</div>
		<aui:button-row>
			<aui:button type="cancel" value="Cancel" />
			<aui:button type="submit" value="Ok" />
		</aui:button-row>
	</aui:form>
</aui:container> --%>






<!-- The Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header"
				style="background-color: #96b4d6 !important;">
				<h4 class="modal-title">Reason For Pull-Back</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<aui:form>
					<div class="textOnInput">
						<label><liferay-ui:message key="label-receipt-remark" /><span
							class='text-danger'>*</span></label>
						<aui:input label="" name="remarks" id="remarks">
							<aui:validator name="required"></aui:validator>
							<aui:validator name="maxLength">
								<liferay-ui:message key="receipt-input-maxlength" />
							</aui:validator>
						</aui:input>
					</div>

					<hr style="margin: 1rem -14px;" />
					<div style="text-align: right;">
						<button type="submit" class="btn btn-primary">Ok</button>
						<button type="button" class="btn btn-primary"
							data-bs-dismiss="modal">Close</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>