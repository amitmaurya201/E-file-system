<!-- Header -->

  <div class="theme-header row" >
	<!-- Logo -->
	<div class="col-8">
	    <div class="header-left">
	        <a href="#" class="logo">
				<img src="${site_logo}" width="40" height="40" alt="">
			</a>
	    </div>
		
		<!-- Header Title -->
	    <div class="page-title-box">
	        <#if show_site_name>
				<h3>${site_name}</h3>
			</#if>
	    </div>
	    <!-- /Header Title -->
    </div>
    
	<!-- Header Menu -->
	<div class="col-4">
		<ul class="mt-2 mr-2 nav user-menu flex-row">

			<!-- User Post & user -->
			<li class=" nav-item dropdown main-drop d-flex align-items-center text-white">
		        
		        <@liferay_portlet["runtime"]
						    instanceId="userPost"
						    portletName="io_jet_process_user_post_web_JetProcessUserPostWebPortlet"
						/> 	
		          
				<#if themeDisplay.getPermissionChecker().isOmniadmin()>
					<@liferay.user_personal_bar /> 
				<#else>
					<span class="pl-2 user-avatar-link">
						<div class="personal-menu-dropdown" id="qtgo_personal_menu_dropdown">
							<div class="dropdown">
								<button class="dropdown-toggle btn btn-unstyled" type="button" aria-label="Personal Menu" id="personal-menu-user-icon">
									<span>
										<#assign profilePic = user.getPortraitURL(themeDisplay)/>
										<#if profilePic??>
											<@liferay.user_personal_bar /> 
										<#else>
											<svg class="lexicon-icon lexicon-icon-user" role="presentation"><use xlink:href="${themeDisplay.getPortalURL()}/o/admin-theme-blue/images/clay/icons.svg#user"></use></svg>
										</#if>
									</span>
								</button>
							</div>
						</div>
					</span>
				</#if>
			</li>
		</ul>
	</div>
	<!-- /Header Menu -->
		
</div>

<!-- /Header -->
