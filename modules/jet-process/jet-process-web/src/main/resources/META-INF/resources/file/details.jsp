

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
 session.setAttribute("BasicHeadValue",basicHeadValue);
 session.setAttribute("PrimaryHeadValue", primaryHeadValue);
 session.setAttribute("SecondaryHeadValue",secondaryHeadValue);
 session.setAttribute("TertiaryHeadValue", tertiaryHeadValue);
 session.setAttribute("FileCodeValue",fileCodeValue);
 session.setAttribute("CategoryVaue", categoryValue);
 session.setAttribute("SubCategoryValue",subCategoryValue);
 
 %>

<% String type = (String) docFile.getNature();
    char firstChar = type.charAt(0);   

%>

<div class="container-fluid m-1" style="background-color: #E8E8E8;" >
<span><%= firstChar %>  |  <%= docFile.getFileNumber() %>  |  <%=docFile.getSubject() %></span><br/>

</div>

<div class="container-fluid m-1" style="background-color: #E8E8E8;" >
<span><b>File Details</b></span><br/>
</div>

<div class="row m-1" >
  <div class="column" style="background-color:#E8E8E8;">
   <h4>FileNumber:</h4>
   <h4>Category:</h4>
   <h4>Reference:</h4>
   <h4>Nature:</h4>
  </div>
  <div class="column" style="background-color: #F8F8F8;">
  <h4><%= docFile.getFileNumber() %></h4>
  <h4><%= categoryValue  %></h4>
  <h4><%= docFile.getReference() %></h4>
  <h4><%= docFile.getNature() %></h4> 
  </div>
  <div class="column" style="background-color:#E8E8E8;">
  <h4>Subject:</h4>
  <h4>SubCategory:</h4>
  <h4>Remarks:</h4>
  </div>
  <div class="column" style="background-color:#F8F8F8;">
  <h4><%= docFile.getSubject() %></h4>
  <h4><%= subCategoryValue %></h4>
  <h4><%= docFile.getRemarks() %></h4>
  </div>
</div>
</div>
<style>
* {
  box-sizing: border-box;
}

h4{
font-weight:500;
}
/* Create four equal columns that floats next to each other */
.column {
  float: left;
  width: 25%;
  padding: 10px;
  height: 200px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>

