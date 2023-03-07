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
		
		<h2 style="text-align: center; text-decoration: underline;">
			<liferay-ui:message key="label-inner-note-document-heading" />
		</h2>

<aui:row>
		<aui:col md="2" cssClass="col-md-2	">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-inner-note-document-subject" /></label>
									<aui:input label="" name="" id="">
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-create-note-document-subject-category" /></label>
									<aui:input label="" name="" id="">
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-create-note-document-createdOn" /></label>
									<aui:input label="" name="" id="">
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-create-note-document-note-document-no" /></label>
									<aui:input label="" name="" id="">
										
									</aui:input>
								</div>
							</aui:col>
							
							</aui:row>

	<div class="m-3">
				<liferay-editor:editor contents="" editorName="ckeditor"
					name="content" />
			</div>
	 </div>
	 
</div>



