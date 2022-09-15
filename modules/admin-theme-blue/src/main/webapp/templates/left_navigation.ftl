<div id="sidebar" >
	<div class="slimScrollDiv" >
		<div class="sidebar-inner slimscroll">
			<div id="sidebar-menu" class="sidebar-menu-left">
				<#if has_navigation && is_setup_complete>
					<button aria-controls="navigationCollapse" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler navbar-toggler-right" data-target="#navigationCollapse" data-toggle="liferay-collapse" type="button">
						<span class="navbar-toggler-icon"></span>
					</button>
				
					<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone", "destination": "/search"}) />
				    <@liferay.navigation_menu default_preferences="${preferences}" />
				</#if>
			</div>
		</div>
	</div>
</div>

