<%@ include file="../init.jsp"%>
<%
	String backPageURL = themeDisplay.getURLCurrent();
%>
<style>
.modal-box {
	display: none;
	position: fixed;
	top: 42% !important;
	left: 50% !important;
	transform: translate(-50%, -50%) !important;
	margin: 10px;
	padding-top: 0px;
	padding-bottom: 10px;
	z-index: 1000;
	width: 500px !important;
	height: 410px !important;
	background: white;
	border-bottom: 1px solid #aaa;
	border-radius: 4px;
	box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	border: 1px solid rgba(0, 0, 0, 0.1);
	background-clip: padding-box;
}

.modal-box header, .modal-box .modal-header {
	background-color: #007bff;
	padding: 1.25em 1.5em;
}

.modal-box header h3, .modal-box header h4, .modal-box .modal-header h3,
	.modal-box .modal-header h4 {
	color: #FFFFFF;
	margin: 0;
}

.modal-box footer, .modal-box .modal-footer {
	padding: 1.25em 1.5em;
	padding-bottom: 1.5em;
	border-top: 1px solid #ddd;
	text-align: right;
}

.modal-overlay {
	opacity: 0;
	filter: alpha(opacity = 0);
	position: absolute;
	top: 0;
	left: 0;
	z-index: 900;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.3) !important;
}

a.close {
	line-height: 1;
	font-size: 1.5em;
	position: absolute;
	top: 5%;
	right: 2%;
	text-decoration: none;
	color: #FFFFFF;
}

a.close:hover {
	color: #FFFFFF;
	-webkit-transition: color 1s ease;
	-moz-transition: color 1s ease;
	transition: color 1s ease;
}

@media ( min-width : 32em) {
	.modal-box {
		width: 70%;
	}
}
</style>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<h1 class="text-center">Created NoteDocument List</h1>
		<clay:management-toolbar disabled="${noteDocumentCount eq 0}"
			displayContext="${NoteDocumentManagementToolbarDisplayContext}"
			itemsTotal="${noteDocumentCount}" searchContainerId="noteDocumentId" />

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="message-record-not-found" id="noteDocumentId"
			total="${noteDocumentCount}"
			iteratorURL="${NoteDocumentManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${noteDocumentList}" />
			<%
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			%>

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.NoteDocumentDTO"
				keyProperty="noteDocumentNumber" modelVar="noteDocument"
				cssClass="colour">



				<portlet:renderURL var="innerViewDetail">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.NOTE_DOCUMENT_INNER_VIEW_RENDER_COMMAND%>" />
					<portlet:param name="noteId"
						value="<%=String.valueOf(noteDocument.getNoteId())%>" />
					<portlet:param name="noteDocumentId"
						value="<%=String.valueOf(noteDocument.getNoteDocumentId())%>" />
					<portlet:param name="subjectCategoryValue"
						value="<%=noteDocument.getCategoryValue()%>" />
					<portlet:param name="backPageURL" value="<%=backPageURL%>" />
				</portlet:renderURL>


				<liferay-ui:search-container-column-text href="<%=innerViewDetail%>"
					value="<%=noteDocument.getNoteDocumentNumber() != null ? noteDocument.getNoteDocumentNumber() : ""%>"
					name="label-notedocument-list-notedocumentnumber"
					cssClass="hyperlink-css" orderableProperty="noteDocumentNumber"
					orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="<%=noteDocument.getSubject() != null ? noteDocument.getSubject() : ""%>"
					name="label-notedocument-list-subject" orderableProperty="subject" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					name="label-notedocument-list-subjectcategory"
					value="<%=noteDocument.getCategoryValue() != null ? noteDocument.getCategoryValue() : ""%>" />


				<liferay-ui:search-container-column-text orderable="true"
					name="label-notedocument-list-createdon"
					orderableProperty="createDate">
					<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${noteDocument.getCreatedOn()}" />
				</liferay-ui:search-container-column-text>



				<liferay-ui:search-container-column-text
					name="label-notedocument-createdlist-actions" align="center">
					<a id="sendnoteDocument" data-toggle="send_noteDocument"
						data-target="#send_noteDocument" style="cursor: pointer"
						onclick="openModal(${noteDocument.noteDocumentId})">Send</a>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>



	</div>
</div>


<portlet:actionURL
	name="<%=MVCCommandNames.NOTE_DOCUMENT_SEND_ACTION_COMMAND%>"
	var="sendNoteDocument" />

<!-- send popup -->
<div id="sendPopup" class="modal-box">
	<header>
		<a href="#" class="js-modal-close close">&times;</a>
		<h4>
			<liferay-ui:message key="label-send-notedocument-heading" />
		</h4>
	</header>
	<aui:form action="${sendNoteDocument}" method="post"
		name="sendNoteDocument">
		<div class="modal-body">
			<aui:input type="hidden" name="noteDocId" />
			<aui:input type="hidden" name="pageURL"
					value="<%=backPageURL%>"/>
			<aui:input type="hidden" name="senderId" value="<%=userPostsVal%>" />
			<aui:select label="label-send-notedocument-to" name="receiverId"
				id="receiverId">
				<aui:option value=''>
					<liferay-ui:message key="label-send-notedocument-default-option" />
				</aui:option>
				<c:forEach var="userPost" items="${userPostList}">
					<aui:option value="${userPost.getUserPostId()}">${userPost.getUserName() }(${userPost.getPostMarking()})${userPost.getSectionName()}</aui:option>
				</c:forEach>

				<aui:validator name="required" />
			</aui:select>
			<aui:input label="label-sent-notedocument-remark" name="remarks"
				id="remarks" type="textarea" style="height:70px;">
				<aui:validator name="required"></aui:validator>
				<aui:validator name="maxLength">
					<liferay-ui:message key="sent-notedocument-remark-maxlength" />
				</aui:validator>
			</aui:input>

		</div>
		<footer>
			<div class="float-right">
				<aui:button type="submit" cssClass="btn btn-primary"
					value="label-send-notedocument-submit-button"></aui:button>
				<aui:button type="button" cssClass="ml-2 js-modal-close btn-primary"
					value="label-send-notedocument-cancel-button" data-dismiss="modal"
					onclick="close"></aui:button>
			</div>
		</footer>
	</aui:form>
</div>

<a class="js-open-modal" id="sendNoteDocumentPopup" hidden
	data-modal-id="sendPopup"> </a>

<script type="text/javascript">
	function openModal(noteDocumentId) {
		$("#<portlet:namespace />noteDocId").val(noteDocumentId);
		$('#sendNoteDocumentPopup').trigger('click');
	
	}
	$('#<portlet:namespace />sendNoteDocument').submit(function() { 
		let remarks = $('#<portlet:namespace />remarks').val();
		let receiverId = $('#<portlet:namespace />receiverId').val();
		if(remarks != '' && receiverId != ''){
			$(".modal-overlay").css("opacity","");
		} 
	}); 
	
	/* ******************* Jquery Popup **************************  */
$(function() {
var appendthis = ("<div class='modal-overlay js-modal-close'></div>");
	$("a[data-modal-id]").click(function(e) {
		e.preventDefault();
		$('body').css('overflow', 'hidden');
		$("body").append(appendthis);
		$(".modal-overlay").fadeTo(500, 0.7);
		//$(".js-modalbox").fadeIn(500);
		var modalBox = $(this).attr('data-modal-id');
		$("#" + modalBox).fadeIn($(this).data());
	});

	$(".js-modal-close, .modal-overlay").click(function() {
		
		$(".modal-box, .modal-overlay").fadeOut(500, function() {
			$(".modal-overlay").remove();
			$(this).find('form').trigger('reset');
		});
	});

	$(window).resize(function() {
		$(".modal-box").css({
			top: ($(window).height() - $(".modal-box").outerHeight()) / 2,
			left: ($(window).width() - $(".modal-box").outerWidth()) / 2
		});
	});

	$(window).resize();

});
</script>
