
<%@page import="java.util.ArrayList"%>
<%@page import="io.jetprocess.model.DocFile"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
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
			if (docFile.getType().equalsIgnoreCase("NON-SFS")) {
				basicHeadValue = (String) request.getAttribute("BasicHeadValue");
				String primaryHeadValue = (String) request.getAttribute("PrimaryHeadValue");
				String secondaryHeadValue = (String) request.getAttribute("SecondaryHeadValue");
				String tertiaryHeadValue = (String) request.getAttribute("TertiaryHeadValue");
				String fileCodeValue = (String) request.getAttribute("FileCodeValue");
				categoryValue = (String) request.getAttribute("CategoryValue");
				subCategoryValue = (String) request.getAttribute("SubCategoryValue");

				session.setAttribute("BasicHeadValue", basicHeadValue);
				session.setAttribute("PrimaryHeadValue", primaryHeadValue);
				session.setAttribute("SecondaryHeadValue", secondaryHeadValue);
				session.setAttribute("TertiaryHeadValue", tertiaryHeadValue);
				session.setAttribute("FileCodeValue", fileCodeValue);
				session.setAttribute("CategoryVaue", categoryValue);
				session.setAttribute("SubCategoryValue", subCategoryValue);
			} else {
				categoryValue = (String) request.getAttribute("SfsCategoryValue");
				subCategoryValue = (String) request.getAttribute("SfsSubCategoryValue");

				session.setAttribute("SfsCategoryValue", categoryValue);
				session.setAttribute("SfsSubCategoryValue", subCategoryValue);
			}
		%>



		<%
			String type = (String) docFile.getNature();
			char firstChar = type.charAt(0);
		%>
		<div class=" m-1" style="background-color: #E8E8E8;">
			<span><%=firstChar%> | <%=docFile.getFileNumber()%> | <%=docFile.getSubject()%></span><br />

		</div>

		<%-- <div class="container-fluid m-1" style="background-color: #E8E8E8;">
			<span style="font-weight: 500"><liferay-ui:message
					key="file-details-heading" /></span><br />
		</div> --%>


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
						<td><%= subCategoryValue !=null ? subCategoryValue : "" %></td>
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