<%@page import="java.util.ArrayList"%>
<%@ include file="../navigation.jsp" %>
<%@page import="io.jetprocess.model.DocFile"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page 
import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
 <liferay-util:include page="/file/file-view-nav.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedNav" value="edit" />
</liferay-util:include>

<div class="m-2 border boredr border-dark">	
</div>


 
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

<table>
  <tr>
    <th>File Details Title</th>
    <th>File Details</th>
  </tr>
  <tr>
    <td>FileNumber</td>
    <td><%= docFile.getFileNumber() %></td>
  </tr> 
  <tr>
    <td>DocFileId</td>
    <td><%= docFile.getDocFileId() %></td>
  </tr> 
  <tr>
    <td>Type</td>
    <td><%= docFile.getType() %></td>
   </tr> 
   <tr> 
    <td>Nature</td>
    <td><%= docFile.getNature() %></td>
   </tr> 
    <tr>
    <td>BasicHeadValue</td>
    <td><%= basicHeadValue %></td>
   </tr>
   <tr> 
    <td>PrimaryHeadValue</td>
    <td><%= primaryHeadValue%></td>
   </tr>
   <tr> 
    <td>SecondaryHeadValue</td>
    <td><%= secondaryHeadValue %></td>
   </tr> 
    <tr> 
    <td>TertiaryHeadValue</td>
    <td><%= tertiaryHeadValue%></td>
   </tr>
   <tr> 
    <td>FileCodeValue</td>
    <td><%= fileCodeValue %></td>
   </tr>
   <tr> 
     <td>CategoryValue</td>
    <td><%= categoryValue  %></td>
   </tr>
   <tr> 
    <td>SubCategoryValue</td>
    <td><%= subCategoryValue%></td>
    </tr>
    <tr>
    <td>Subject</td>
    <td><%= docFile.getSubject() %></td>
   </tr> 
   <tr>  
    <td>Remarks</td>
    <td><%= docFile.getRemarks()%></td>
    </tr>
    <tr>
    <td>Reference</td>
    <td><%= docFile.getReference() %></td>
     <tr>
    <td>UserPostId</td>
    <td><%= docFile.getUserPostId() %></td>
 
  </tr>
</table>
