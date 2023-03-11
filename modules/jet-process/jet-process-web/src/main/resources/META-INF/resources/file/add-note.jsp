<%@page import="javax.portlet.RenderRequest"%>
<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor"%>
<liferay-editor:resources editorName="ckeditor" />
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<style>
.saveButton {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 2px 6px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 50%;
}
.note-list{
word-wrap :break-word;

}

.note-list img {
  width : 100%;
  
}

.deleteButton {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 2px 6px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 50%;
}
</style>


<!-- -------------Add Green Note----------------- -->
<div style="background-color: #bef8c7; height: 400px" id="mydiv">
	<img src='<%=request.getContextPath() + "/image/note.png"%>' width="8%"
		id="note" height="30"
		class="shadow m-1 bg-white rounded-circle addtoggle " />
	<div id="notes" class="g" style="display: none;">
		<img src='<%=request.getContextPath() + "/image/green-note.jpg"%>'
			width="8%" height="30" class="shadow m-1 bg-white rounded-circle"
			onclick="openGreenNote()" /> <br />
		<img src='<%=request.getContextPath() + "/image/yellow-note.jpg"%>'
			width="8%" height="30" class="shadow m-1 bg-white rounded-circle"
			onclick="openYellowNote()" />
	</div>
	
	<aui:form name="addNote">
	<div>
	<%@ include file = "green-note.jsp" %>
	</div>
	<div>
	<%@ include file = "yellow-note.jsp" %>
	</div>
	</aui:form>
	
	<!-- -------------------------Note List------------------------ -->
	<c:forEach items="${noteList}" var="note" varStatus="theCount">
		<c:if test= "${note.hasYellowNote }">
		<div style="height: auto; border-color: gray; box-shadow: 1px 2px yellow;">
		</c:if>
			<c:if test = "${!note.hasYellowNote }">
			<div style="height: auto; border-color: gray; box-shadow: 1px 2px green;">
			</c:if>
			<b><liferay-ui:message key="label-add-note-note" /> # </b>
			<c:out value="${theCount.count }"></c:out>
			<div class="container note-list">${note.content}</div>
			<div class="mt-1">
				<c:set var="now" value="${note.getCreateDate()}" />
				<fmt:formatDate type="both" pattern="dd/MM/yyyy  hh:mm aa"
					timeZone="Asia/Calcutta" value="${now}" />
				<span style="float: right;"> ${note.getSignature("userName")}</span>
				<p style="text-align: right;">
					<span>${note.getSignature("departmentName")}(${note.getSignature("postMarking")})${ note.getSignature("sectionName")}</span>
				</p>
			</div>
		</div>
	</c:forEach>
	
	
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header" style="background-color: #007bff";>
				<h5 class="modal-title" style="color: #FFFFFF"
					id="exampleModalLabel">
					<liferay-ui:message key="label-add-note-discard-title" />
				</h5>
				<button type="button" class="close" style="color: #FFFFFF"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>
					<liferay-ui:message key="label-add-note-discard-boday" />
				</p>
			</div>
			<div class="modal-footer" style="justify-content: end !important;">
				<div>
					<button type="button" class="btn btn-primary" id="deleteGreenNote">
						<liferay-ui:message key="label-add-note-discard-ok-button" />
					</button>
					<button type="button" class="btn btn-primary" id="deleteYellowNote">
						<liferay-ui:message key="label-add-note-discard-ok-button" />
					</button>
					<button type="button" class="btn btn-primary mr-auto" id="cancel"
						data-dismiss="modal">
						<liferay-ui:message key="label-add-note-discard-close-button" />
					</button>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/js/note.js"%>
<script>
	var viewMode = "${param.viewMode}";
	console.log("viewMode" + viewMode);
	if (viewMode == 'ViewModeFromSentFile') {
		$('#note').removeClass("addtoggle");
	}
	jQuery('#mydiv').css("overflow-y", "scroll");

	/* for toggle note icon  */
	$(document).ready(function() {
		$(".addtoggle").click(function() {
			$("#notes").toggle();
		});
	});
	
</script>
