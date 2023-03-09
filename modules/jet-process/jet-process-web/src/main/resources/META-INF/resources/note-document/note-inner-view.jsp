<%@page import="io.jetprocess.model.NoteDocument"%>
<%@ include file="../init.jsp"%>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<% 

String content = (String)renderRequest.getAttribute("content");
String categoryValue = (String)renderRequest.getAttribute("categoryValue");
String noteDocumentNumber = (String)renderRequest.getAttribute("noteDocumentNumber");
String subject = (String)renderRequest.getAttribute("subject");
String date = (String)renderRequest.getAttribute("date");


%>

 
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
		
		<h2 style="text-align: center; text-decoration: underline;">
			<liferay-ui:message key="label-note-document-heading" />
		</h2>

<aui:row>
		<aui:col md="2" cssClass="col-md-2	">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-note-subject" /></label>
									<aui:input label="" name="" id="" value="<%=subject%>" disabled="true">
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-note-subject-category" /></label>
									<aui:input label="" name="" id="" value="<%=categoryValue %>" disabled="true">
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-note-created-on" /></label>
									<aui:input label="" name="" id="" value="<%=date%>" disabled="true">
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-note-document-no" /></label>
									<aui:input label="" name="" id="" value="<%=noteDocumentNumber%>" disabled="true">
										
									</aui:input>
								</div>
							</aui:col>
							
							</aui:row>

	<div class="m-3">
				<liferay-editor:editor contents="<%=content %>" editorName="ckeditor"
					name="content"   />
			</div>
	 </div>
	 
</div>



