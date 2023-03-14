<%@ include file="../init.jsp"%>

<div class="row send">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<portlet:actionURL
		name="<%=MVCCommandNames.NOTE_DOCUMENT_SEND_ACTION_COMMAND%>"
		var="sendNoteDocument" />
	<div class="col-10">
		<liferay-util:include
			page="/note-document/note-document-navigation.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="send" />
		</liferay-util:include>

		<aui:container cssClass="row">
			<aui:form action="${sendNoteDocument}"
				cssClass="border border-dark col-6" style="padding: 1% !important">
				<aui:input type="hidden" name="senderId"
					value="<%=selectedUserPostId%>" />
				<aui:input type="hidden" name="noteDocId" value="${noteDocumentId}" />
				<aui:input type="hidden" name="pageURL"
					value="${backPageURL}"/>
				<aui:col cssClass="mt-3">
					<h2 style="text-align: center; text-decoration: underline;">
						<liferay-ui:message key="label-send-notedocument-heading" />
					</h2>
				</aui:col>
				<aui:col cssClass="mt-3">
					<div class="textOnInput">
						<label><liferay-ui:message
								key="label-send-notedocument-to" /><span class="text-danger">*</span></label>
						<aui:select label="" name="receiverId" id="receiverId">
							<aui:option value=''>
								<liferay-ui:message key="label-send-notedocument-default-option" />
							</aui:option>
							<c:forEach var="userPost" items="${userPostList}">
								<aui:option value="${userPost.getUserPostId()}">${userPost.getUserName() }(${userPost.getPostMarking()})${userPost.getSectionName()}</aui:option>
							</c:forEach>
							<aui:validator name="required" />
						</aui:select>
					</div>
				</aui:col>
				<aui:col cssClass="mt-3">
					<div class="textOnInput">
						<label><liferay-ui:message
								key="label-sent-notedocument-remark" /><span
							class="text-danger">*</span></label>
						<aui:input type="textarea" label="" name="remarks" id="remarks"
							style="height:70px;">
							<aui:validator name="required" />
							<aui:validator name="maxLength">
								<liferay-ui:message key="sent-notedocument-remark-maxlength" />
							</aui:validator>
						</aui:input>
					</div>
				</aui:col>
				<aui:button-row>
					<aui:button type="submit" class="btn btn-primary"
						style=" margin: auto 40%;"
						value="label-send-notedocument-submit-button" />
				</aui:button-row>
			</aui:form>
		</aui:container>
	</div>
</div>