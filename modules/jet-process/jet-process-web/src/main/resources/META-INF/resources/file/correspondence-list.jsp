<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<%
	//long corrFileId = (long) request.getAttribute("docFileId");
 HttpSession docFileIdValue = themeDisplay.getRequest().getSession();
 long corrFileId  = (long) docFileIdValue.getAttribute("putInFileId"); 	
	//List<FileCorrespondenceReceiptDTO> receiptCorrList = MasterdataLocalServiceUtil.getFileCorrespondenceReceipteDetail(corrFileId);
	
%>
<style>
.crList th {
	display: inline-block;
	width: max-content;
}

.dropbtn {
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
	float: right;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.put-heading {
	background-color: #96b4d6;
	color: white;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>
<portlet:renderURL var="fileInnerViewPopup"
		windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.CORRESPONCE_FILE_RENDER %>" />
	</portlet:renderURL>
	
	<portlet:renderURL var="correspondencesinfoViewPopup"
		windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="mvcRenderCommandName" value="<%="/correspondencesInfo" %>"/>
	</portlet:renderURL>
	
	<portlet:renderURL var="receiptDetailsPopup" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.CORRESPONDENCES_RECEIPT_DETAIL_RENDER_COMMAND%>" />
				</portlet:renderURL>

<div>
	<div class="" style="font-size: 18px">
		<text class="pr-4 float-left put-heading" style="border-radius:0px 100px 0px 0px; ">List Of Correspondences     </text>
		<div class="pl-2 pr-2 dropdown float-right put-heading" style="border-radius:100px 0px 0px 100px;">
			<i class="fa fa-bars " >TOC</i>
			<div class="dropdown-content">
				<a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link 3</a>
			</div>
		</div>
	</div>
	<liferay-ui:search-container total="${fileCorrespondenceCount }"
		delta="${delta }" deltaConfigurable="true"  iteratorURL="${fileCorrespondenceManagementToolbarDisplayContext._getCurrentURL()}"
		emptyResultsMessage="No Results Found">
		<liferay-ui:search-container-results
			results="${fileCorrespondence}" />

		<liferay-ui:search-container-row
			className="io.jetprocess.list.model.FileCorrespondenceReceiptDTO"
			modelVar="aFileCorrespondenceReceiptDTO">
			<liferay-ui:search-container-column-text>
			<a class="Info" onclick="infoPopup(${aFileCorrespondenceReceiptDTO.receiptId }, ${aFileCorrespondenceReceiptDTO.receiptMovementId })">
				<i class="fa fa-info-circle"  style="color:blue;font-size:16px; cursor:help"></i>
			</a>
			</liferay-ui:search-container-column-text>
		
			<liferay-ui:search-container-column-text ><%=aFileCorrespondenceReceiptDTO.getNature().charAt(0)%></liferay-ui:search-container-column-text>
			
			
			
			<liferay-ui:search-container-column-text  name =" Receipt No.">
				<a class="Info" onclick="receiptDetailPopup(${aFileCorrespondenceReceiptDTO.receiptId })" style="cursor:pointer">
					${aFileCorrespondenceReceiptDTO.receiptNumber }
				</a>
			</liferay-ui:search-container-column-text>
				
			<liferay-ui:search-container-column-text property="subject" />
		
		<liferay-ui:search-container-column-text  name="type" property="correspondenceType"/>
		
		<liferay-ui:search-container-column-text  name="Attached On" value="<%=simpleformat.format(aFileCorrespondenceReceiptDTO.getCreateDate())%>"/>
			<liferay-ui:search-container-column-text name = "Remarks" property="remark" />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>


	<div>
		<aui:button cssClass="btn btn-primary" style="float: right;"
			name="add_receipt" id="add_receipt" value="Add Receipt" >
		</aui:button>
		
	</div>

</div>

<aui:script use="liferay-util-window">	

var viewMode = "${param.viewMode}";
if (viewMode == 'ViewModeFromSentFile') {
		$('#<portlet:namespace />add_receipt').addClass('disabled');
		$('.dropdown-content').css("display", "none");
}


	$("#<portlet:namespace />add_receipt").click(()=>{
		Liferay.Util.openWindow({ 
					dialog: { 														 
							height: 800,														 
							destroyOnClose: true,														 
							destroyOnHide: true, 														 
							modal: true, 														 
							width: 900,
							on: {
               			 	destroy: function() { 
                    		parent.location.reload();                   
                    		 	}
           					 }													 
						}, 														 
						id: '<portlet:namespace />dialog',														 
						title: 'Put In File', 														 
						uri: '<%= fileInnerViewPopup %>&<portlet:namespace/>corrFileId=<%=corrFileId %>',			
						});
					});	
					
					
	
	
	
	</aui:script>
	
	<script>
	
	function infoPopup(receiptId, receiptMovementId){
	 Liferay.Util.openWindow({ 
				dialog: { 														 
						height: 550,														 
						destroyOnClose: true,														 
						destroyOnHide: true, 														 
						modal: true, 														 
						width: 1200,
						on: {
          			 	destroy: function() { 
               		parent.location.reload();                   
               		 	}
      					 }													 
					}, 														 
					id: '<portlet:namespace />dialog',														 
					title: 'Correspondence Details', 														 
					uri: '<%= correspondencesinfoViewPopup %>&<portlet:namespace />receiptId='+receiptId+'&<portlet:namespace />receiptMovementId='+receiptMovementId+'&<portlet:namespace/>corrFileId=<%=corrFileId %>',			
					});
				 
	
	}
	
	function receiptDetailPopup(receiptId){
		
		  Liferay.Util.openWindow({ 
					dialog: { 														 
							height: 550,														 
							destroyOnClose: true,														 
							destroyOnHide: true, 														 
							modal: true, 														 
							width: 1200,
							on: {
	          			 	destroy: function() { 
	               		parent.location.reload();                   
	               		 	}
	      					 }													 
						}, 														 
						id: '<portlet:namespace />dialog',														 
						title: 'Receipt Details', 														 
						uri: '<%= receiptDetailsPopup %>&<portlet:namespace />receiptId='+receiptId+'&<portlet:namespace/>corrFileId=<%=corrFileId %>',			
						});
					  
		
		}
	</script>
	