<%@ include file="../init.jsp"%>

<%
DocFile docFile = (DocFile)renderRequest.getAttribute("docFile");
String type = (String) docFile.getNature();
char firstChar = type.charAt(0);

String categoryValue;
String subCategoryValue;

categoryValue = (String) request.getAttribute("CategoryValue");
subCategoryValue = (String) request.getAttribute("SubCategoryValue");

%>

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

<div class="container-fluid" style="background-color: #E8E8E8;">
			<div class="hover-tips"><%=firstChar%> | <%=docFile.getFileNumber()%> | <%=docFile.getSubject()%></div>
		</div>


<div class="row mt-2 p-2 border border-dark">
			<div class="col-6">
				<table class="mt-2 file-dtls">
					<tr>
						<th class=""><liferay-ui:message key="label-file-fileno" />:</th>
						<td class=""><%=docFile.getFileNumber()%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-reference" />:</th>
						<td><%=docFile.getReference()%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-subject" />:</th>
						<td><%=docFile.getSubject()%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-remark" />:</th>
						<td><%=docFile.getRemarks()%></td>
					</tr>
				</table>
			</div>

			 <div class="col-6">
				<table class="mt-2 file-dtls">
					<tr>
						<th class="category"><liferay-ui:message
								key="label-file-categoryid" />:</th>
						<td><%=categoryValue%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-nature" />:</th>
						<td><%=docFile.getNature()%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-sub-categoryid" />:</th>
						<td><%=subCategoryValue != null ? subCategoryValue : ""%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-nature-type" />:</th>
						<td><%=docFile.getType()%></td>
					</tr>
				</table>
			</div> 
		</div>
		