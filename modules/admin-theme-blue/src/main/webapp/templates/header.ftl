<!-- Header -->

  <div class="theme-header row">
	<!-- Logo -->
	<div class="col-md-8">
	    <div class="header-left">
	        <a href="#" class="logo">
				<img src="${site_logo}" width="40" height="40" alt="">
			</a>
	    </div>
		<a id="navbartoggle">
			<span class="bar-icon">
				<span></span>
				<span></span>
				<span></span>
			</span>
		</a>
		
		<!-- Header Title -->
	    <div class="page-title-box">
	        <#if show_site_name>
				<h3>${site_name}</h3>
			</#if>
	    </div>
	    <div id="thard-party-applications" class="control-bar d-flex align-items-center mr-auto" style="margin-top: -40px;padding-left: 30px">
			<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
	
	        <@liferay.navigation_menu
	          default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap)
	          instance_id="service_navigation_menu"
	        />
		</div>	
    </div>
    
	<!-- /Header Title -->
	
	<a id="mobile_btn" class="mobile_btn" href="#sidebar"><i class="fa fa-bars"></i></a>
	<div class="col-md-4">
		<!-- Header Menu -->
		<ul class="nav user-menu flex-row pr-4">
		
			<!-- Search -->
	                                               <#--  <li class="nav-item">
				<div class="top-nav-search">
					<a href="javascript:void(0);" class="responsive-search">
						<i class="fa fa-search"></i>
				   </a>
					<form action="#">
			<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone", "destination": "/search"}) />
						 <@liferay.search_bar default_preferences="${preferences}" />
					</form>
				</div>
			</li>-->
			
			<!-- /Search -->
		
			<!-- Flag -->
			<li class="nav-item dropdown has-arrow flag-nav">
				
	                           <!-- <@liferay_portlet["runtime"]
			defaultPreferences=default_preferences
			portletProviderAction=portletProviderAction.VIEW
			portletProviderClassName="com.liferay.portal.kernel.servlet.taglib.ui.LanguageEntry"
			/>-->
	                              
			</li>
			<!-- /Flag -->
		
			<!-- Notifications -->
	                            <#assign user = themeDisplay.getUser() />
	                            <#assign notificationService = serviceLocator.findService("com.liferay.portal.kernel.service.UserNotificationEventLocalService")/>
	                            <#assign notificationCount = notificationService.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(),false)/>
	
	   		
				<span class="badge badge-pill badge-danger badge-up badge-glow"></span>
		   	
	   
		   	
	  			<li class="nav-item dropdown">
	                                            <#if notificationCount == 0>
	                   <a href="#" class="dropdown-toggle nav-link" data-bs-toggle="dropdown">
					<i class="fa fa-bell-o"></i> <span class="badge rounded-pill"></span>
				</a>
	                                           <#else> 
				<a href="${site_default_url}/manage?p_p_id=com_liferay_notifications_web_portlet_NotificationsPortlet&p_p_lifecycle=0" class="dropdown-toggle                                                  nav-link" data-bs-toggle="dropdown">
					<i class="fa fa-bell" aria-hidden="true" style='color: white'></i> <span class="badge rounded-pill">${notificationCount}</span>
				</a>
	                                          </#if>
	
				<div class="dropdown-menu notifications">
					<div class="topnav-dropdown-header">
						<span class="notification-title">Notifications</span>
						<a href="javascript:void(0)" class="clear-noti"> Clear All </a>
					</div>
					
					<div class="topnav-dropdown-footer">
						<a href="${site_default_url}/manage?p_p_id=com_liferay_notifications_web_portlet_NotificationsPortlet&p_p_lifecycle=0"                                                                    class="dropdown-toggle nav-link">View all Notifications</a>
					</div>
				</div>
			</li>
	
			<!-- /Notifications -->
	
			
			<!-- Message Notifications -->
	
			<!--<li class="nav-item dropdown">
				<a href="#" class="dropdown-toggle nav-link" data-bs-toggle="dropdown">
					<i class="fa fa-comment-o"></i> <span class="badge rounded-pill">8</span>
				</a>
				<div class="dropdown-menu notifications">
					<div class="topnav-dropdown-header">
						<span class="notification-title">Messages</span>
						<a href="javascript:void(0)" class="clear-noti"> Clear All </a>
					</div>
					<div class="noti-content">
						<ul class="notification-list">
							<li class="notification-message">
								<a href="chat.html">
									<div class="list-item">
										<div class="list-left">
											<span class="avatar">
												<img alt="" src="assets/img/profiles/avatar-09.jpg">
											</span>
										</div>
										<div class="list-body">
											<span class="message-author">Richard Miles </span>
											<span class="message-time">12:28 AM</span>
											<div class="clearfix"></div>
											<span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
										</div>
									</div>
								</a>
							</li>
							<li class="notification-message">
								<a href="chat.html">
									<div class="list-item">
										<div class="list-left">
											<span class="avatar">
												<img alt="" src="assets/img/profiles/avatar-02.jpg">
											</span>
										</div>
										<div class="list-body">
											<span class="message-author">John Doe</span>
											<span class="message-time">6 Mar</span>
											<div class="clearfix"></div>
											<span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
										</div>
									</div>
								</a>
							</li>
							
							
						</ul> 
					</div>
					<div class="topnav-dropdown-footer">
						<a href="chat.html">View all Messages</a>
					</div>
				</div>
			</li>-->
			<!-- /Message Notifications -->
	
			<li class="nav-item dropdown main-drop d-flex align-items-center text-white">
	        	<#if themeDisplay.isSignedIn()>
	        	 <#assign  userPostService = serviceLocator.findService("io.jetprocess.masterdata.service.UserPostLocalService")/> 
	        		         
              <#assign userPostList =userPostService.getUserPostList(user.getUserId())/>
                          
		        	  <label for="cars">Select Post:</label>
                          <select name="post" id="value">
		        <#list userPostList as userpost>
		        	  	  <option value=${userpost.getUserPostId()}>${userpost.getShortName()}</option>
                   </#list>
                           </select>		          
		            
	        	
					<span style="margin-right: 10px" class="text-danger">    </span>
		        </#if>
				<#if themeDisplay.getPermissionChecker().isOmniadmin()>
					<@liferay.user_personal_bar /> 
				<#else>
					<span class="user-avatar-link">
						<div class="personal-menu-dropdown" id="qtgo_personal_menu_dropdown">
							<div class="dropdown">
								<button class="dropdown-toggle btn btn-unstyled" type="button" aria-label="Personal Menu" id="personal-menu-user-icon">
									<span>
										<span>
											<span>
												<#assign profilePic = user.getPortraitURL(themeDisplay)/>
												<#if profilePic??>
													<@liferay.user_personal_bar /> 
												<#else>
													<svg class="lexicon-icon lexicon-icon-user" role="presentation"><use xlink:href="${themeDisplay.getPortalURL()}/o/admin-theme-blue/images/clay/icons.svg#user"></use></svg>
												</#if>
											</span>
										</span>
									</span>
								</button>
								<#--<div class="dropdown-menu dropdown-menu-personal-menu dropdown-menu-indicator-end" id="dropdown-menu-personal-menu-employee" style="min-width:200px; left:-160px">
									<ul class="list-unstyled">
										<li class="dropdown-subheader" role="presentation">${user.getFirstName()} ${user.getLastName()}</li>
										<ul class="list-unstyled">
											<li aria-selected="false"><a class="dropdown-item" href="/group${layout.getGroup().getFriendlyURL()}/my-profile">My Profile</a></li>
											<li aria-hidden="true" class="dropdown-divider" role="presentation"></li>
											<li aria-selected="false"><a class="dropdown-item" href="/c/portal/logout">Sign Out</a></li>
										</ul>
									</ul>
								</div>-->
							</div>
						</div>
					</span>
				</#if>
			</li>
		</ul>
	</div>
	<!-- /Header Menu -->
	
	<!-- Mobile Menu -->
	<#--<div class="dropdown mobile-user-menu">
		<@liferay.user_personal_bar /> 
		<#if themeDisplay.isSignedIn()>
			<span> Welcome ${user.getFirstName()} ${user.getLastName()} </span>
		</#if>
	</div>-->
	<!-- /Mobile Menu -->
	
</div>
<!-- /Header -->