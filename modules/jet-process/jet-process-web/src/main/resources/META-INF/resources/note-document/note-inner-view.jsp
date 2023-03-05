<%@ include file="../init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

 
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
	<liferay-util:include page="/note-document/note-document-navigation.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="navhome" />
		</liferay-util:include>
	
	
	
		<portlet:actionURL var="postContent"></portlet:actionURL>
		
		Note Inner View
	<br>
	<form>
  <div class="form-row">
    <div class="col-md-2">
      <input type="text" class="form-control" placeholder="">
    </div>
    <div class="col-md-2">
      <input type="text" class="form-control" placeholder="State">
    </div>
    <div class="col-md-2">
      <input type="text" class="form-control" placeholder="Zip">
    </div>
     <div class="col-md-2">
      <input type="text" class="form-control" placeholder="Zip">
    </div>
  </div>
</form>
	<br><br>
<aui:form action="<%=postContent %>">
 <liferay-ui:input-editor name="content" initMethod="initEditor" width="70" height="300" 
  resizable="true" ></liferay-ui:input-editor>
</aui:form>
	 </div>
	 
</div>



<aui:script>
 function <portlet:namespace/>initEditor(){
 return  "Sample CKEDITOR";
 }
</aui:script>