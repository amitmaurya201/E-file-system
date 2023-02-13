<%@page import="io.jetprocess.core.constant.util.FileConstants"%>
<%@ include file="../init.jsp"%>

<style>
.file-dtls th {
	background-color: gainsboro;
	width: 20%;
	font-size: 14px;
	vertical-align: top;
	padding-left: 3px;
}

.file-dtls td {
	font-size: 14px;
	width: 25%;
	padding-left: 5px !important;
	text-overflow: ellipsis;
	max-width: 30ch;
}
</style>

<%
String backPageURL = (String) request.getAttribute("backPageURL");
%>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="details" />
		</liferay-util:include>

		<%
			DocFile docFile = (DocFile) request.getAttribute("DocFile");
			session.setAttribute("DocFile", docFile);
			String categoryValue;
			String subCategoryValue;
			String basicHeadValue;
			if (docFile.getType().equalsIgnoreCase(FileConstants.NON_SFS_TYPE)) {
				basicHeadValue = (String) request.getAttribute("BasicHeadValue");
				String primaryHeadValue = (String) request.getAttribute("PrimaryHeadValue");
				String secondaryHeadValue = (String) request.getAttribute("SecondaryHeadValue");
				String tertiaryHeadValue = (String) request.getAttribute("TertiaryHeadValue");
				String fileCodeValue = (String) request.getAttribute("FileCodeValue");
				categoryValue = (String) request.getAttribute("CategoryValue");
				subCategoryValue = (String) request.getAttribute("SubCategoryValue");

				renderRequest.setAttribute("BasicHeadValue", basicHeadValue);
				renderRequest.setAttribute("PrimaryHeadValue", primaryHeadValue);
				renderRequest.setAttribute("SecondaryHeadValue", secondaryHeadValue);
				renderRequest.setAttribute("TertiaryHeadValue", tertiaryHeadValue);
				renderRequest.setAttribute("FileCodeValue", fileCodeValue);
				renderRequest.setAttribute("CategoryVaue", categoryValue);
				renderRequest.setAttribute("SubCategoryValue", subCategoryValue);
			} else {
				categoryValue = (String) request.getAttribute("SfsCategoryValue");
				subCategoryValue = (String) request.getAttribute("SfsSubCategoryValue");

				renderRequest.setAttribute("SfsCategoryValue", categoryValue);
				renderRequest.setAttribute("SfsSubCategoryValue", subCategoryValue);
			}
		%>

		<%
			String type = (String) docFile.getNature();
			char firstChar = type.charAt(0);
		%>

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
	</div>
</div>