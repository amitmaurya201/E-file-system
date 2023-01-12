<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.OffsetDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="io.jetprocess.model.Receipt"%>
<%@page import="com.liferay.portal.kernel.util.SessionParamUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>


<%
	String currentURL = (String) renderRequest.getAttribute("CurrentURL");

	session.setAttribute("currentURL", currentURL);
%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<liferay-util:include page="/receipt/receipt-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="details" />
			<%-- <liferay-util:param name="userPostId" value="${id}" /> --%>
		</liferay-util:include>
		<%-- <%}

}%>
 --%>
		<%-- <%@ include file="receipt-view-nav.jsp"%> --%>

		<%
			Receipt receipt = (Receipt) request.getAttribute("receipt");
			session.setAttribute("receipt", receipt);
			String nature = receipt.getNature();
			char currentNature = nature.charAt(0);
			SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			simpleFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		%>
		
		<div class="container-fluid" style="background-color: #E8E8E8;">
			<div class="hover-tips"><%=currentNature%> | ${receipt.receiptNumber} | ${receipt.subject}</div>
		</div>
		<div class="receipt_view">
			<div class="container">
				<div class="row border border-dark scroll"
					style="height: 440px; overflow: overlay">
					<div class="col-5" class="border">
						<c:choose>
							<c:when test="${receipt.viewPdfUrl != ''}">
								<embed id="pdfurl" type="application/pdf"
									src="${receipt.viewPdfUrl} " width="100%" height="450" />
							</c:when>
							<c:otherwise>
								<img alt="physical_pdf"
									src='<%=request.getContextPath() + "/image/physical_pdf.png"%>'
									width="100%" height="450" />
							</c:otherwise>
						</c:choose>

					</div>
					<div class="border col-7 mb-2 ">
						<div class="row border heading" >
							<h5>
								<aui:icon cssClass="fas fa-file-alt view_icon " />
								<liferay-ui:message key="label-receipt-diary-details" />
							</h5>
						</div>
						<div class="row">
							<div class="col-6">
								<table class="line_height">
									<tr>
										<th><liferay-ui:message key="label-receipt-createdon" />:</th>
										<td><%=simpleFormat.format(receipt.getCreateDate())%></td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-nature" />:</th>
										<td><%=receipt.getNature()%></td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-type" />:</th>
										<td>${typeValue}</td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-received-on" />:</th>
										<td>${receipt.receivedOn}</td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-reference-no" />:</th>
										<td>${receipt.referenceNumber}</td>
									</tr>
								</table>
							</div>
							<div class="col-6">
								<table class="line_height">
									<tr>
										<th><liferay-ui:message
												key="label-receipt-list-receiptno" />:</th>
										<td>${receipt.receiptNumber}</td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-file-list-fileno" />:</th>
										<td></td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-delivery-mode" />:</th>
										<td>${deliveryModeValue}</td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-letter-date" />:</th>
										<td>${receipt.letterDate}</td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-mode-no" />:</th>
										<td>${receipt.modeNumber}</td>
									</tr>

								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-12">
								<table class="col-12 line_height">
									<tr>
										<th><liferay-ui:message key="label-receipt-category" />:</th>
										<td>${receiptCategoryValue}</td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-sub-category" />:</th>
										<td>${receiptSubCategoryValue}</td>
									</tr>
									<tr>
										<th><liferay-ui:message
												key="label-receipt-view-created-by" />:</th>
										<td>${userPost.getUserName()}(${userPost.getPostMarking()})${userPost.getSectionName()},${userPost.getDepartmentName()}</td>
									</tr>


									<tr>
										<th><liferay-ui:message key="label-receipt-subject" />:</th>
										<td>${receipt.subject}</td>
									</tr>

									<tr>
										<th><liferay-ui:message key="label-receipt-remark" />:</th>
										<td>${receipt.remarks}</td>
									</tr>

								</table>
							</div>
						</div>
						<div class="border row heading"  >
							<h5>
								<aui:icon cssClass="fas fa-envelope view_icon" />
								<liferay-ui:message key="label-receipt-sender-details" />
							</h5>
						</div>
						<div class="row">
							<div class="col-6">
								<table class="line_height">
									<tr>
										<th><liferay-ui:message key="label-receipt-organization" />:</th>
										<td>${organizationValue}</td>
									</tr>
									<tr>
										<th><liferay-ui:message
												key="label-receipt-sub-organization" />:</th>
										<td>${subOrganizationValue}</td>
									</tr>
								</table>
							</div>
							<div class="col-6">
								<table class="line_height">
									<tr>
										<th><liferay-ui:message key="label-receipt-view-sender" />:</th>
										<td>${receipt.name}</td>
									</tr>
									<tr>
										<th><liferay-ui:message key="label-receipt-designation" />:</th>
										<td>${receipt.designation}</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-12">
								<table class="line_height">
									<tr>
										<th><liferay-ui:message key="label-receipt-address" />:</th>
										<td>${receipt.address}</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>







