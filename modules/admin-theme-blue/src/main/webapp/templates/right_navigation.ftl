<aside class="newSideBarRight float-right">            

			
				<ul class="profile list-unstyled">
                    <#if themeDisplay.isSignedIn()==false>
	                    <li class="mt-2 mb-2">
	                     	<a href="#"  class="list-item text-white" data-bs-toggle="tooltip" title="User" data-bs-placement="auto"><i class="fas fa-user-circle" aria-hidden="true" style='color: white'></i></i></a>
	   					</li>
                    </#if>
                    <#if themeDisplay.getPermissionChecker().isOmniadmin()>   
	                    <li class="mt-2 mb-2">                 
		                     <a id="control-panel" class="list-item text-white" data-bs-toggle="tooltip" title="control penal" data-bs-placement="auto">
		                     	<svg class="lexicon-icon lexicon-icon-grid text-white fs-5" role="presentation"><use xlink:href="${themeDisplay.getPortalURL()}/o/admin-theme-blue/images/clay/icons.svg#grid"></use></svg>
		                     </a>
		                </li>
					</#if>
					<li class="mt-2 mb-2">
						<a id="portlet-list" class="list-item text-white" data-bs-toggle="tooltip" title="Setting" data-bs-placement="auto"><i class="fa fa-cog" aria-hidden="true" style='color: white'></i></i></a>
					</li>
					<li class="mt-2 mb-2">
						<a id="add-page" class="list-item text-white" data-bs-toggle="tooltip" title="User" data-bs-placement="auto"><i class="fas fa-tablet-alt" aria-hidden="true" style='color: white'></i></a>
                    </li>                 
				</ul>
			</aside>

			<div id="application-view" style="position: absolute;right: 12px;width: 280px; display: none;" class="coloverlay">
			<@liferay_portlet["runtime"]
			   defaultPreferences="${freeMarkerPortletPreferences}"
			   portletProviderAction=portletProviderAction.VIEW
			   portletName="com_adj_application_ApplicationPortlet_INSTANCE_application" />
			</div>
     
           <div id="addpage-view">
			<@liferay_portlet["runtime"]
			   defaultPreferences="${freeMarkerPortletPreferences}"
			   portletProviderAction=portletProviderAction.VIEW
			   portletName="com_adj_addpage_AddPagePortlet_INSTANCE_addpage" />
			
			</div>

<script>

$("#control-panel").click(function(){
	var sideNavWidth = $(".sidenav-menu").width();
	$(".control-menu-container").toggle();
	if($(".sidenav-fixed.sidenav-menu-slider.open").is(":visible") || $(".lfr-add-panel.open-admin-panel.sidenav-menu-slider").is(":visible")){
		$(".product-menu").toggle(function(){
			var isSideNavVisible = $(this).is(":visible");
			if(isSideNavVisible){
	        	$("#content").attr("style","margin-left:"+sideNavWidth+"px !important; transition: all 0.3s ease;");
	        	$("#custom-control-menu").find(".theme-header").attr("style","margin-left:"+sideNavWidth+"px !important; transition: all 0.3s ease;");
	        } else{
	        	$("#content").attr("style","margin-left:0px !important; transition: all 0.3s ease;");
	        	$("#custom-control-menu").find(".theme-header").attr("style","margin-left:0px !important; transition: all 0.3s ease;");
	        }
		});
	}
})

$("#portlet-list").click(function(){
	$("#application-view").toggle();
})
$("#addpage-view").dialog({
    autoOpen: false,
});
$("#add-page").click(function(){
	$("#addpage-view").dialog("open");
	$(".ui-dialog-title").text('Create Personalized Dashboard'); 
});
</script>