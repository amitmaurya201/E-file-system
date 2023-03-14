<%@ include file="../init.jsp"%>

<%
	long noteDocumentId = (long) renderRequest.getAttribute("noteDocumentId");
    long noteId = (long) renderRequest.getAttribute("noteId");
%>
<style>
.border a {
	border-right: 1px solid #a19c9c;
	font-weight: 700;
}

@media all and (min-width: 992px) {
	.navbar .nav-item .dropdown-menu {
		display: none;
	}
	.navbar .nav-item:hover .nav-link {
		
	}
	.navbar .nav-item:hover .dropdown-menu {
		display: block;
	}
	.navbar .nav-item .dropdown-menu {
		margin-top: 0;
	}
}
</style>

<portlet:renderURL var="home">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.NOTE_DOCUMENT_INNER_VIEW_RENDER_COMMAND%>" />
	<portlet:param name="noteDocumentId" value="<%=noteDocumentId + ""%>" />
	<portlet:param name="noteId" value="<%=noteId + ""%>" />
</portlet:renderURL>

<portlet:renderURL var="send">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.NOTE_DOCUMENT_SEND_RENDER_COMMAND%>" />
	<portlet:param name="noteDocumentId" value="<%=noteDocumentId + ""%>" />
	<portlet:param name="noteId" value="<%=noteId + ""%>" />
</portlet:renderURL>
<portlet:renderURL var="movement">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.NOTE_DOCUMENT_MOVEMENT_LIST_RENDER_COMMAND%>" />
		<portlet:param name="noteDocumentId" value="<%=noteDocumentId + ""%>" />
		<portlet:param name="noteId" value="<%=noteId + ""%>" />
</portlet:renderURL>

<nav class="navbar navbar-expand-lg navbar-light  mt-1 "
	style="background-color: #ddd; border-top: 2px solid #a19c9c; border-top-left-radius: 5px; border-top-right-radius: 5px;">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav">
			<li class="nav-item border"><a id="navhome" class="nav-link"
				href="<%=home%>"><i class="fa fa-home"></i>Home</a></li>
			<li class="nav-item border "><a id="send" class="nav-link"
				href="<%=send%>">Send</a></li>
			<li class="nav-item border "><a id="movement" class="nav-link"
				href="<%=movement%>">Movement</a></li>
		</ul>
	</div>
</nav>
<script>
	var navId = "${param.selectedNav}";
	var nav = document.getElementById(navId);
	nav.style.color = 'blue';
</script>
