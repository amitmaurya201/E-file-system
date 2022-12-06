
<%@page import="java.util.ArrayList"%>
<%@page import="io.jetprocess.model.DocFile"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file="../init.jsp"%>
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
		<div class="container-fluid m-1" style="background-color: #E8E8E8;">
			<span><%=firstChar%> | <%=docFile.getFileNumber()%> | <%=docFile.getSubject()%></span><br />

		</div>

		<div class="container-fluid m-1" style="background-color: #E8E8E8;">
			<span style="font-weight: 500"><liferay-ui:message key="file-details-heading" /></span><br />
		</div>


 <div class="row m-1">       
<table>

  <tr >
    <th><liferay-ui:message key="label-file-fileno" />:</th>
    <td><%=docFile.getFileNumber()%></td>
    <th class="category"><liferay-ui:message key="label-file-categoryid" />:</th>
    <td><%=categoryValue%></td>
  </tr>
 
  <tr>
   <th><liferay-ui:message key="label-file-reference" />:</th>
    <td><%=docFile.getReference()%></td>
    <th><liferay-ui:message key="label-file-nature" />:</th>
    <td><%=docFile.getNature()%></td>
  </tr>
  <tr>
    <th><liferay-ui:message key="label-file-subject" />:</th>
    <td><%=docFile.getSubject()%></td>
    <th><liferay-ui:message key="label-file-sub-categoryid" />:</th>
    <td><%=subCategoryValue%></td>
  </tr>
  <tr>
    <th><liferay-ui:message key="label-file-remark" />:</th>
    <td><%=docFile.getRemarks()%></td>
    <th><liferay-ui:message key="label-file-nature-type" />:</th>
    <td><%=docFile.getType()%></td>
  </tr>
 
</table>
</div>
        
<style>
table{
border-collapse: separate;
  border-spacing: 0 15px;
}

</style>

<!-- <script type="text/javascript">

$(".category").hover(function() {

	$(this).attr('title', $(this).text());

});

</script> -->
		<%-- <div class="row m-1">
			<div class="column" style="background-color: #E8E8E8;">
				<h5><liferay-ui:message key="label-file-fileno" />:</h5>
				<h5><liferay-ui:message key="label-file-categoryid" />:</h5>
				<h5><liferay-ui:message key="label-file-reference" />:</h5>
				<h5><liferay-ui:message key="label-file-nature" />:</h5>
			</div>
			<div class="column" style="background-color: #F8F8F8;">
				<h5><%=docFile.getFileNumber()%></h5>
				<h5 class="category"><%=categoryValue%></h5>
				<h5><%=docFile.getReference()%></h5>
				<h5><%=docFile.getNature()%></h5>
			</div>
			<div class="column" style="background-color: #E8E8E8;">
				<h5><liferay-ui:message key="label-file-subject" />:</h5>
				<h5><liferay-ui:message key="label-file-sub-categoryid" />:</h5>
				<h5><liferay-ui:message key="label-file-remark" />:</h5>
				<h5><liferay-ui:message key="label-file-nature-type" />:</h5>
			</div>
			<div class="column" style="background-color: #F8F8F8;">
				<h5><%=docFile.getSubject()%></h5>
				<h5><%=subCategoryValue%></h5>
				<h5><%=docFile.getRemarks()%></h5>
				<h5><%=docFile.getType()%></h5>
			</div>
		</div>
	</div> --%>
	<!-- <style>
* {
	box-sizing: border-box;
}

.category {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	max-width: 30ch;
}

h4 {
	font-weight: 500;
}
/* Create four equal columns that floats next to each other */
.column {
	float: left;
	width: 25%;
	padding: 10px;
	height: 150px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>

	<script>
		$(".category").hover(function() {

			$(this).attr('title', $(this).text());

		});
	</script> -->