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
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>

<div class="row">
	<div class="col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<liferay-util:include page="/receipt/receipt-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="home" />
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
			SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yy hh:mm aa");
			simpleFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		%>
		<div class="receipt_view">
			<div class="container">
				<h5 Class="border hover-tips" style="margin-top: 3px;">
					<%=currentNature%>
					| ${receipt.receiptNumber} | ${receiptCategoryValue}
				</h5>
				<div class="row">
					<div class="col-5" class="border">
						<embed id="pdfurl" type="application/pdf"
							src="${receipt.viewPdfUrl} " width="100%" height="450">
					</div>
					<div class="border col-7 ">
						<div class="heading">
							<h4>
								<aui:icon cssClass="fas fa-file-alt icon " />
								Diary Details
							</h4>
						</div>
						<div class="row">
							<div class="col-6">
								<table>
									<tr>
										<th>Created On:</th>
										<td><%=simpleFormat.format(receipt.getCreateDate())%></td>
									</tr>
									<tr>
										<th>Nature:</th>
										<td>${receipt.nature}</td>
									</tr>
									<tr>
										<th>Type:</th>
										<td>${typeValue}</td>
									</tr>
									<tr>
										<th>Received On:</th>
										<td>${receipt.receivedOn}</td>
									</tr>
									<tr>
										<th>Reference Number:</th>
										<td>${receipt.referenceNumber}</td>
									</tr>
									<tr>
										<th>Category:</th>
										<td>${receiptCategoryValue}</td>
									</tr>
								</table>
							</div>
							<div class="col-6">
								<table>
									<tr>
										<th>Receipt Number:</th>
										<td>${receipt.receiptNumber}</td>
									</tr>
									<tr>
										<th>File Number:</th>
										<td>Linus</td>
									</tr>
									<tr>
										<th>Delivery Mode:</th>
										<td>${deliveryModeValue}</td>
									</tr>
									<tr>
										<th>Letter Date:</th>
										<td>${receipt.letterDate}</td>
									</tr>
									<tr>
										<th>Mode Number:</th>
										<td>${receipt.modeNumber}</td>
									</tr>
									<tr>
										<th>Sub Category:</th>
										<td>${receiptSubCategoryValue}</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-12">
								<table>
									<tr>
										<th>Created By:</th>
										<td>${userPost.getUserName()},${userPost.getSectionName()}_${userPost.getDepartmentName()},${userPost.getPostMarking()}</td>
									</tr>
								</table>
							</div>
							<div class="col-12">
								<table>
									<tr>
										<th>Subject:</th>
										<td>${receipt.subject}</td>
									</tr>
								</table>
							</div>
							<div class="col-12">
								<table>
									<tr>
										<th>Remarks:</th>
										<td>${receipt.remarks}</td>
									</tr>

								</table>
							</div>
						</div>
						<div class="border heading">
							<h4>
								<aui:icon cssClass="fas fa-envelope icon" />
								Sender Details
							</h4>
						</div>
						<div class="row">
							<div class="col-6">
								<table>
									<tr>
										<th>Organization:</th>
										<td>${organizationValue}</td>
									</tr>
									<tr>
										<th>Sub Organization:</th>
										<td>${subOrganizationValue}</td>
									</tr>
								</table>
							</div>
							<div class="col-6">
								<table>
									<tr>
										<th>Sender:</th>
										<td>${receipt.name}</td>
									</tr>
									<tr>
										<th>Designation:</th>
										<td>${receipt.designation}</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-12">
								<table>
									<tr>
										<th>Address:</th>
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