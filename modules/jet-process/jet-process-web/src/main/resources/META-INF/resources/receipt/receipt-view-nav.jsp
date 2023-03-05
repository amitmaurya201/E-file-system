<%@ include file="../init.jsp"%>

<style>
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

.border li a {
	border-right: 1px solid #a19c9c;
	font-weight: 700;
}
</style>

<%
	String receiptId = renderRequest.getParameter("receiptId");
	String backPageURL = (String) renderRequest.getAttribute("backPageURL");

	long receiptMovementId = (long)renderRequest.getAttribute("receiptMovementId");
	
	String viewMode = renderRequest.getParameter("viewMode");
	
	
	
 
%>
<portlet:renderURL var="receiptDetails">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.RECEIPT_DETAILS_RENDER_COMMAND%>" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
	<portlet:param name="rmId"
		value="<%=String.valueOf(receiptMovementId)%>" />
	<portlet:param name="viewMode" value="<%=viewMode%>" />
</portlet:renderURL>

<portlet:renderURL var="receiptMovement">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.RECEIPT_MOVEMENT_RENDER_COMMAND%>" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
	<portlet:param name="receiptMovementId"
		value="<%=String.valueOf(receiptMovementId)%>" />
	<portlet:param name="viewMode" value="<%=viewMode%>" />
</portlet:renderURL>

<portlet:renderURL var="sendReceipt">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND%>" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
	<portlet:param name="receiptMovementId"
		value="<%=String.valueOf(receiptMovementId)%>" />

</portlet:renderURL>
<portlet:renderURL var="sendBack">
	<portlet:param name="mvcPath" value="/receipt/send_back.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editReceipt">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.EDIT_RECEIPT_RENDER_COMMAND%>" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
	<portlet:param name="receiptMovementId"
		value="<%=String.valueOf(receiptMovementId)%>" />
	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
</portlet:renderURL>
 <portlet:renderURL var="putInFile" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.PUTINFILE_RENDER_COMMAND%>" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
	<portlet:param name="receiptMovementId"
		value="<%=String.valueOf(receiptMovementId)%>" />	
		<portlet:param name="backPageURL" value="<%=backPageURL%>" />	
</portlet:renderURL>
<portlet:renderURL var="actionDetails">
	<portlet:param name="mvcPath" value="/receipt/action_details.jsp" />
</portlet:renderURL>
<portlet:renderURL var="attach">
	<portlet:param name="mvcPath" value="/receipt/attach.jsp" />
</portlet:renderURL>

<portlet:renderURL var="closeReceiptURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	 	<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.RECEIPT_CLOSE_POP_UP%>" />
				<portlet:param name="backPageURL" value="<%=backPageURL%>" /> 
		</portlet:renderURL>
 


<nav class="navbar navbar-expand-lg navbar-light mt-1"
	style="background-color: #ddd; border-top: 2px solid #a19c9c; border-top-left-radius: 5px; border-top-right-radius: 5px;">
	<!-- <div class="container-fluid"> -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#main_nav" aria-controls="main_nav" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class=" navbar-collapse" id="main_nav">
		<ul class="navbar-nav border">
			<li class="nav-item "><a id="details" class="nav-link "
				href="<%=receiptDetails%>">Details </a></li>
			<li class="nav-item"><a id="movement" class="nav-link "
				href="<%=receiptMovement%>"> Movement </a></li>
			<li class="nav-item"><a id="send" class="nav-link "
				href="<%=sendReceipt%>"> Send </a></li>
			<li class="nav-item"><a id="sendback" class="nav-link "
				href="#"> Send Back </a></li>
			 <li class="nav-item"><a class="nav-link add_receipt" id="putInFile"
				href="#"> Put in a file </a></li>			 
			<li class="nav-item"><a id="edit" class="nav-link "
				href="<%=editReceipt%>"> Edit </a></li>
			<li class="nav-item"><a id="actionDetails" class="nav-link "
				href="#"> Action Details </a></li>
			<li class="nav-item dropdown"><a
				class="nav-link  dropdown-toggle" href="#" data-bs-toggle="dropdown">Attach<i
					class="fa fa-caret-down"></i>

			</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#"> Submenu
							item 1</a></li>
					<li><a class="dropdown-item" href="#"> Submenu item 2 </a></li>
					<li><a class="dropdown-item" href="#"> Submenu item 3 </a></li>
				</ul></li>
				
			 <li class="nav-item border"><a id="closeReceipt"  href="#" onClick="OpenCloseReceiptPopUp(<%=receiptId %>,<%=String.valueOf(receiptMovementId)%>)" class="nav-link">Close</a></li>
            

		</ul>
		<div class="nav-item d-flex ">
			<a class="nav-link  align-end bg-primary" Style="border-radius: 5px;"
				href="#"><i class="fa fa-print" style="color: white;"
				aria-hidden="true"></i></a>
		</div>
	</div>
	<!-- </div> -->
</nav>

<script>
	var navId = "${param.selectedNav}";
	var nav = document.getElementById(navId);
	nav.style.color = 'blue';

	var viewMode = "${param.viewMode}";
	if (viewMode == 'ViewModeFromSentRecipt') {
		$('#edit').addClass('disabled');
		$('#send').addClass('disabled');
		$('#sendback').addClass('disabled');
		$('#closeReceipt').addClass('disabled');
		$('#putInFile').addClass('disabled');
		
	}
	/*  For open CloseReceipt Pop up */
	function OpenCloseReceiptPopUp(receiptId,receiptMovementId){
	 	var receiptURL = '<%=closeReceiptURL%>&<portlet:namespace/>receiptId='+receiptId+'&<portlet:namespace/>rmId='+receiptMovementId;
			Liferay.Util.openWindow({
				dialog: {
					centered: true,
					height: 265,
					destroyOnClose: true,														 
					destroyOnHide: true, 
					modal: true,
					width: 500
				},
				id: '<portlet:namespace/>dialog',
				title: 'Closing Remarks',
				uri: receiptURL
				
			});
		}


	
</script>

<aui:script>

$(".add_receipt").click(()=>{
	var title="<liferay-ui:message key='title-attach-in-file'/>";
	
	 Liferay.Util.openWindow({ 
		dialog: { 														 
			height: 550,														 
			destroyOnClose: true,														 
			destroyOnHide: true, 														 
			modal: true, 														 
			width: 1200,
											 
		}, 														 
		id: '<portlet:namespace />dialog',														 
		title: title, 																 
		uri: '<%=putInFile%>'			
		}); 
});
	
	
		
	
	
</aui:script>
