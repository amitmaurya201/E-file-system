<%@page import="java.util.ArrayList"%>
<%@page import="io.jetprocess.model.DocFile"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file="../init.jsp"%>
<div class="row">
	<div class="col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="details" />
		</liferay-util:include>


		<%
			DocFile docFile = (DocFile) request.getAttribute("DocFile");
			String basicHeadValue = (String) request.getAttribute("BasicHeadValue");
			String primaryHeadValue = (String) request.getAttribute("PrimaryHeadValue");
			String secondaryHeadValue = (String) request.getAttribute("SecondaryHeadValue");
			String tertiaryHeadValue = (String) request.getAttribute("TertiaryHeadValue");
			String fileCodeValue = (String) request.getAttribute("FileCodeValue");
			String categoryValue = (String) request.getAttribute("CategoryValue");
			String subCategoryValue = (String) request.getAttribute("SubCategoryValue");

			session.setAttribute("DocFile", docFile);
			session.setAttribute("BasicHeadValue", basicHeadValue);
			session.setAttribute("PrimaryHeadValue", primaryHeadValue);
			session.setAttribute("SecondaryHeadValue", secondaryHeadValue);
			session.setAttribute("TertiaryHeadValue", tertiaryHeadValue);
			session.setAttribute("FileCodeValue", fileCodeValue);
			session.setAttribute("CategoryVaue", categoryValue);
			session.setAttribute("SubCategoryValue", subCategoryValue);
		%>


		<div class="container-fluid" style="background-color: #E8E8E8;">

			<span>FileNumber :<%=docFile.getFileNumber()%></span><br />

		</div>
		<div class="container-fluid p-3 mb-2 bg-light text-dark">
			<div class="row">
				<b> File Details </b>
			</div>
		</div>
		<div class="container-fluid p-3 mb-2 bg-light text-dark">
			<table>
				<tr>

					<td><b>FileNumber :</b></td>
					<td><%= docFile.getFileNumber() %></td>
				</tr>

				<tr>

					<td><b>Type :</b></td>
					<td><%=docFile.getType()%></td>
				</tr>
				<tr>
					<td><b>Nature :</b></td>
					<td><%=docFile.getNature()%></td>
				</tr>
				<tr>
					<td><b>Subject :</b></td>
					<td><%=docFile.getSubject()%></td>
				</tr>
				<tr>
					<td><b>Remarks :</b></td>
					<td><%=docFile.getRemarks()%></td>
				</tr>
				<tr>
					<td><b>Reference :</b></td>
					<td><%=docFile.getReference()%></td>
			</table>
		</div>