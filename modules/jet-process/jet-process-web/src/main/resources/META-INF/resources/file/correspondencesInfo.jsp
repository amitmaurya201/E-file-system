<%@ include file="../init.jsp"%>
<style>
.details-color {
	background-color: gainsboro;
	width: 100%;
	font-size: 14px;
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
				<td>${receipt.receivedOn}</td>
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
				<td>${receipt.receiptNumber}</td>
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
				<td>${receipt.letterDate}</td>
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
				<th><liferay-ui:message key="label-receipt-view-sender" />:</th>
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



	<div class="col-md-12 mt-5">
		<div class="row">
			<div class="col-md-12 ">
				<h5 class="mb-2 p-2 details-color ">
					<i class="fa-solid fa-timer" style="color: blue; font-size: 16px; margin-left:5px;"></i>Receipt(s)
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
								<li class="nav-item border "><a id="movement"
									class="nav-link" href="#">Movement</a></li>
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

				<div class="col-md-12 angled" style="margin-top: 10px !important">
					<h5 class="align-baseline" style="padding-top: 10px !important; padding-left: 7px !important;">Movement History</h5>
				</div>

				<div class="col-md-12">

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
</div>

