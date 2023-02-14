<%@ include file="../init.jsp"%>
<style>
.lfr-search-container-wrapper a:not (.component-action ):not (.btn ) {
	color: #000000;
}

.details-color {
	background-color: gainsboro;
	width: 100%;
	vertical-align: top;
	padding-left: 3px;
}

.file-dtls th {
	background-color: gainsboro;
	width: 20%;
	font-size: 14px;
	vertical-align: top;
	padding-left: 10px;
}

.file-dtls td {
	font-size: 14px;
	width: 25%;
	padding-left: 5px !important;
	text-overflow: ellipsis;
	max-width: 30ch;
}

.line_height {
	line-height: 2;
}

.border a {
	border-right: 1px solid #a19c9c;
	font-weight: 700;
}

@media all and (min-width: 992px) {
	.navbar .nav-item .dropdown-menu {
		display: none;
	}
	.navbar .nav-item:hover .nav-link {
		
	}
	.navbar .nav-item:hover .dropdown-menu {
		display: block;
	}
	.navbar .nav-item .dropdown-menu {
		margin-top: 0;
	}
}

.angled {
	width: 300px !important;
	height: 30px !important;
	margin-top: 10px !important;
	margin-left: auto;
	background-color: #e1e1e1 !important;
	font-size: calc(1rem * 1.25) !important;
	border-right: 50px solid white !important;
	border-bottom: 50px solid transparent !important;
}

.container-view {
	padding-top: 1px;
}

#popup {
	pointer-events: none;
}
</style>
<%
	Receipt receipt = (Receipt) request.getAttribute("receipt");
%>
<div class="row mt-2 p-2 border border-dark  "
	style="width: 100%; padding: 20px !important; marging: 20px; !important">
	<div class="col-md-12 mr-2 details-color">
		<h5>
			<aui:icon cssClass="fas fa-file-alt view_icon " />
			<liferay-ui:message key="label-receipt-diary-details" />
		</h5>
	</div>
	<div class="col-6">
		<table class="mt-2 mb-2 file-dtls">
			<tr>
				<th><liferay-ui:message key="label-receipt-createdon" />:</th>
				<td><%=simpleformat.format(receipt.getCreateDate())%></td>
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
				<td><%=simpleFormat.format(receipt.getReceivedOn())%></td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-reference-no" />:</th>
				<td>${receipt.referenceNumber}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-category" />:</th>
				<td>${receiptCategoryValue}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-view-created-by" />:</th>
				<td>${userPost.getUserName()}(${userPost.getPostMarking()})${userPost.getSectionName()},${userPost.getDepartmentName()}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-remark" />:</th>
				<td>${receipt.remarks}</td>
			</tr>
		</table>
	</div>

	<div class="col-6">
		<table class="mt-2 file-dtls">
			<tr>
				<th><liferay-ui:message key="label-receipt-list-receiptno" />:</th>
				<td>${receipt.receiptNumber}<c:if
						test="${not empty receipt.viewPdfUrl}">
						<i style="cursor: pointer;" class="fa fa-file-pdf openPdf"
							data-url="${receipt.viewPdfUrl}"></i>
					</c:if>
				</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-file-list-fileno" />:</th>
				<td>${fileNumber }</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-delivery-mode" />:</th>
				<td>${deliveryModeValue}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-letter-date" />:</th>
				<td>${letterDate}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-mode-no" />:</th>
				<td>${receipt.modeNumber}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-sub-category" />:</th>
				<td>${receiptSubCategoryValue}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-subject" />:</th>
				<td>${receipt.subject}</td>
			</tr>
		</table>
	</div>

	<div class="col-md-12 mr-2 details-color">
		<h5>
			<aui:icon cssClass="fas fa-envelope view_icon" />
			<liferay-ui:message key="label-receipt-sender-details" />
		</h5>
	</div>
	<div class="col-6">
		<table class="mt-2 file-dtls">
			<tr>
				<th style="padding-right: 53.54px;"><liferay-ui:message
						key="label-receipt-view-sender" />:</th>
				<td>${receipt.name}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-organization" />:</th>
				<td>${organizationValue}</td>
			</tr>
		</table>
	</div>

	<div class="col-6">
		<table class="mt-2 file-dtls">
			<tr>
				<th><liferay-ui:message key="label-receipt-designation" />:</th>
				<td>${receipt.designation}</td>
			</tr>
			<tr>
				<th><liferay-ui:message key="label-receipt-sub-organization" />:</th>
				<td>${subOrganizationValue}</td>
			</tr>
		</table>
	</div>
	<div class="col-12">
		<table class="file-dtls">
			<tr>
				<th style="padding-right: 47.5px;"><liferay-ui:message
						key="label-receipt-address" />:</th>
				<td>${receipt.address}</td>
			</tr>
		</table>
	</div>


	<portlet:renderURL var="viewPdf"
		windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcPath" value="/receipt/pdf_view.jsp" />
		<portlet:param name="pdfUrl" value="${receipt.viewPdfUrl }" />
	</portlet:renderURL>

	<div id="popup" class="modal invisible" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content"
				style="max-width: 70rem; margin: -21px auto;">
				<div class="modal-body" style="padding: 0">
					<button type="button" class="btn btn-white btn-close"
						data-bs-dismiss="modal" aria-label="Close"
						style="color: black; margin-right: 9px; margin-top: -3px; float: right;">&#10005;</button>
					<br>
					<div id="pdf"></div>
				</div>

			</div>
		</div>
	</div>


	<%-- <portlet:renderURL var="movement">
	<portlet:param name="mvcPath" value="/movement.jsp" />
</portlet:renderURL> --%>



	<div class="col-md-12 mt-5">
		<div class="row">
			<div class="col-md-12 ">
				<h5 class="mb-2 p-2 details-color ">
					<i class="fa-solid fa-timer"
						style="color: blue; font-size: 16px; margin-left: 5px;"></i><liferay-ui:message key="corr-info-detail-receipt-heading" />
				</h5>
				<div class="col-md-12 details-color">
					<nav class="navbar navbar-expand-lg navbar-light  mt-1 "
						style="background-color: #ddd; border-top: 2px solid #a19c9c; border-top-left-radius: 5px; border-top-right-radius: 5px;">

						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item border"><a id="movement"
									class="nav-link" href="#" style="color: black;">Movement</a></li>
								<li class="nav-item border "><a id="attached-detached"
									class="nav-link" href="#">Attached/Detached</a></li>
								<li class="nav-item border "><a id="dispatch"
									class="nav-link" href="#">Dispatch</a></li>
								<li class="nav-item border "><a id="close" class="nav-link"
									href="#">Close</a></li>
							</ul>
						</div>
					</nav>
				</div>

				<div class="col-md-12 angled"
					style="margin-top: 10px !important; background: #96b4d6 !important">
					<h5 class="align-baseline"
						style="padding-top: 10px !important; padding-left: 7px !important;"><liferay-ui:message key="corr-info-detail-receipt-movement-heading" /></h5>
				</div>

				<liferay-ui:search-container delta="${delta }"
					emptyResultsMessage="label-no-record-found"
					total="${receiptMovementCount }"
					iteratorURL="${correspondencesInfoManagementToolbarDisplayContext._getCurrentURL()}">
					<liferay-ui:search-container-results
						results="${receiptMovementList}" />
					<liferay-ui:search-container-row
						className="io.jetprocess.list.model.ReceiptMovementDTO"
						modelVar="receiptMovementDTO" keyProperty="receiptMovementId">
						<liferay-ui:search-container-column-text
							value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
							name="label-sent-on" />
						<liferay-ui:search-container-column-text
							value="${receiptMovementDTO.sentBy}" name="label-sent-by"
							cssClass="hover-tips" />
						<liferay-ui:search-container-column-text
							value="${receiptMovementDTO.sentTo}" name="label-sent-to"
							cssClass="hover-tips" />
						<liferay-ui:search-container-column-text
							value="${receiptMovementDTO.remark}" name="label-remarks"
							cssClass="hover-tips" />
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				$('.btn-close').on('click', function(e) {
					$('#popup').modal('hide');
				});
				$(".openPdf").on(
						'click',
						function(e) {
							let url = themeDisplay.getPortalURL()
									+ ($(this).attr('data-url')).trim();
							$('#popup').modal({
								keyboard : false
							});
							$('#popup').removeClass('invisible').addClass(
									'visible');
							$('#popup').find('div#pdf').empty();
							let embeded = $('<embed/>', {
								type : 'application/pdf',
								width : '100%',
								height : '430'
							}).appendTo($('#popup').find('div#pdf'));
							embeded.attr('src', url);
						});
			});
</script>