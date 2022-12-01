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
		%>


		<h6 >${receipt.nature}-${receipt.receiptNumber}</h6>

		<%-- receipt view --%>
		<div class="receipt_view border border-dark">
			<div class="container">
				<div class="row">
					<div class="col-md-6" class="border">
						<embed id="pdfurl" type="application/pdf"
							src="${receipt.viewPdfUrl} " width="100%" height="450">
					</div>
					<div class="col-md-6" class="border border-dark">
						<div class="border heading">
							<h4>
								<aui:icon cssClass="fas fa-file-alt icon" />
								Diary Details
							</h4>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Created On :</label><span>${receipt.createDate}</span>
							</div>
							<div class="col-md-6">
								<label>Receipt No. :</label><span>${receipt.receiptNumber}</span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Nature :</label><span>${receipt.nature} </span>
							</div>
							<div class="col-md-6">
								<label>File No. :</label><span> </span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Type :</label><span>${ typeValue}</span>
							</div>

							<div class="col-md-6">
								<label>Delivery Mode :</label><span>${deliveryModeValue}
								</span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Received On :</label><span>${receipt.receivedOn} </span>
							</div>
							<div class="col-md-6">
								<label>Letter Date :</label><span>${receipt.letterDate} </span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Reference Number :</label><span>${receipt.referenceNumber}
								</span>
							</div>
							<div class="col-md-6">
								<label>ModeNumber :</label><span>${receipt.modeNumber} </span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Category :</label><span>${receiptCategoryValue}</span>
							</div>
							<div class="col-md-6">
								<label>Sub Category :</label><span>${receiptSubCategoryValue}</span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label>Diarised By :</label><span>${userPost.getUserName()},${userPost.getSectionName()}_${userPost.getDepartmentName()},${userPost.getPostMarking()}</span>
							</div>
							<div class="col-md-12">
								<label>Subject :</label><span>${receipt.subject} </span>
							</div>
							<div class="col-md-12">
								<label>Remarks :</label><span>${receipt.remarks} </span>
							</div>
						</div>

						<div class="border heading">
							<h4>
								<aui:icon cssClass="fas fa-envelope icon" />
								Sender Details
							</h4>
						</div>

						<div class="row">
							<div class="col-md-6">
								<label>Organization :</label><span>${organizationValue}</span>
							</div>
							<div class="col-md-6">
								<label>Sub Organization :</label><span>${subOrganizationValue}</span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Sender :</label><span>${receipt.name}</span>
							</div>
							<div class="col-md-6">
								<label>Designation :</label><span>${receipt.designation}</span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label>Address :</label><span>${receipt.address} </span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>