<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />


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



.angled{
	
	width:300px !important;
	height:30px !important;
	margin-top:10px !important;
	margin-left:auto;
    background-color: #e1e1e1 !important;
	font-size: calc(1rem * 1.25) !important;
    border-right: 50px solid white !important;
    border-bottom: 50px solid transparent !important;
    
}


</style>



<div class="row mt-2 p-2 border border-dark  "
	style="width: 100%; padding: 20px !important; marging: 20px; !important">
	<div class="col-md-12 mr-2 details-color">
		<h5><i class="fa-regular fa-file-invoice" style="color:blue;font-size:16px;"></i> Basic Details</h5>
	</div>
	<div class="col-6">
		<table class="mt-2 file-dtls">
			<tr>
				<th class="">Comp. No. :</th>
				<td class="">${receipt.companyId }</td>
			</tr>
			<tr>
				<th>Nature :</th>
				<td>${receipt.nature }</td>
			</tr>
			<tr>
				<th>Main Category :</th>
				<td>${receipt.receiptCategoryId }</td>
			</tr>
			<tr>
				<th>From :</th>
				<td>${receipt.name }</td>
			</tr>
			<tr>
				<th>From of Communications :</th>
				<td></td>
			</tr>
			<tr>
				<th>Sender Type :</th>
				<td></td>
			</tr>
			<tr>
				<th>Letter Date :</th>
				<td></td>
			</tr>
			<tr>
				<th>Dairy Date :</th>
				<td>${receipt.receivedOn }</td>
			</tr>
			<tr>
				<th>Subject :</th>
				<td>${receipt.subject }</td>
			</tr>
			<tr>
				<th>Enclosure/Remarks :</th>
				<td></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td>${receipt.address }</td>
			</tr>
		</table>
	</div>

	<div class="col-6">
		<table class="mt-2 file-dtls">
			<tr>
				<th class="category">Receipt No. :</th>
				<td>${receipt.receiptNumber }</td>
			</tr>
			<tr>
				<th>File No. :</th>
				<td>${receipt.dmFileId }</td>
			</tr>
			<tr>
				<th>Sub Category :</th>
				<td></td>
			</tr>
			<tr>
				<th>Designation :</th>
				<td>${receipt.designation}</td>
			</tr>
			<tr>
				<th class="category">Delivery Mode :</th>
				<td>${receipt.deliveryModeId}</td>
			</tr>
			<tr>
				<th>Letter Ref. No. :</th>
				<td></td>
			</tr>
			<tr>
				<th>Received Date :</th>
				<td>${receipt.receivedOn }</td>
			</tr>
			<tr>
				<th>Diarised By :</th>
				<td>${receipt.name}</td>
			</tr>
		</table>
	</div>

	<div class="col-md-12 mt-5">

		<div class="row">
			<div class="col-md-12 ">
				<h5 class="mb-2 p-2 details-color ">
					<i class="fa-solid fa-timer" style="color:blue;font-size:16px;"></i>Receipt(s)
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

				<div class="col-md-12 angled" style="margin-top: 10px !important" >
					<h5 class="align-middle"> 
						Movement History
					</h5>
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
								value="${receiptMovementDTO.sentOn}" name="label-sent-on" />
							<liferay-ui:search-container-column-text
								value="${receiptMovementDTO.sentBy}" name="label-sent-by"
								cssClass="hover-tips" />
							<liferay-ui:search-container-column-text
								value="${receiptMovementDTO.sentTo}" name="label-sent-to"
								cssClass="hover-tips" />
							<liferay-ui:search-container-column-text
								value="${receiptMovementDTO.remark}" name="label-remarks"
								cssClass="hover-tips" />
							<liferay-ui:search-container-column-text
								value="${receiptMovementDTO.pullBackRemark}"
								name="label-pullback-remark" cssClass="hover-tips" />
						</liferay-ui:search-container-row>
						<liferay-ui:search-iterator markupView="lexicon" />
					</liferay-ui:search-container>

				</div>
			</div>
		</div>
	</div>
</div>

