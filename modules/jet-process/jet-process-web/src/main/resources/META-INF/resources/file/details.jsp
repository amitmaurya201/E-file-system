<%@page import="java.util.ArrayList"%>
<%@page import="io.jetprocess.model.DocFile"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>

<div class="row">
	<div class="col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">


		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="edit" />
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


		<h3>FileNo:</h3><%=docFile.getFileNumber()%>

		<table>
			<tr>
				<th>File Details</th>

			</tr>
			<tr>
				<td>File No.</td>
				<td><%=docFile.getFileNumber()%></td>
			</tr>

			<tr>
				<td>Type</td>
				<td><%=docFile.getType()%></td>
			</tr>
			<tr>
				<td>Nature</td>
				<td><%=docFile.getNature()%></td>
			</tr>
			<tr>
				<td>BasicHeadValue</td>
				<td><%=basicHeadValue%></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><%=docFile.getSubject()%></td>
			</tr>

		</table>

	</div>
</div>
