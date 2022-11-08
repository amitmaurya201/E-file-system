<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	
		<@liferay.css file_name="${css_folder}/custom/jquery-ui.css" />
		<@liferay.css file_name="${css_folder}/custom/fonts/font-awesome/css/font-awesome.min.css" />
		<@liferay.css file_name="${css_folder}/custom/stylesheet.css" />
		<@liferay.css file_name="${css_folder}/custom/fullcalendar-5.10.2.css" />
		<@liferay.css file_name="${css_folder}/custom/style.css" />
		
		
		<@liferay.css file_name="${css_folder}/icon/all.css" />
		<@liferay.css file_name="${css_folder}/fonts/stylesheet.css" />
		<@liferay.css file_name="${css_folder}/owl-carousel/owl.theme.default.min.css" />
		<@liferay.css file_name="${css_folder}/owl-carousel/animate.min.css" />
		<@liferay.css file_name="${css_folder}/owl-carousel/owl.carousel.css" />
		<@liferay.css file_name="${css_folder}/magnify-image-hover/jquery.jqZoom.css" />
		
		<@liferay.js file_name = "${javascript_folder}/popper.min.js" />
	    <@liferay.js file_name = "${javascript_folder}/owl-carousel/owl.carousel.js" />
	    <@liferay.js file_name = "${javascript_folder}/chart/chart.min.js" />
	    <@liferay.js file_name = "${javascript_folder}/magnify-image-hover/jquery.jqZoom.js" />
		
		<@liferay.js file_name = "${javascript_folder}/custom/jquery.slimscroll.min.js" />
		<@liferay.js file_name = "${javascript_folder}/custom/jquery-ui.min.js" />
		<@liferay.js file_name = "${javascript_folder}/custom/fullcalendar-5.10.2.js" /> 
</head>


<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<div id="header" class="row">
	<div id="liferay-control-menu" class="col col-md-12">
		<#assign roleLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.RoleLocalService")/>
		<#assign userLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService")/>
		<#assign owner = roleLocalService.getRole(company_id, "Owner")/>
		<#assign site_owner = roleLocalService.getRole(company_id, "Site Owner")/>
		<#assign site_admin = roleLocalService.getRole(company_id, "Administrator")/>
		<#assign isAdmin = userLocalService.hasRoleUser(site_admin.getRoleId(), user_id)/>
		<#if isAdmin>
			<@liferay.control_menu />
		</#if>
	</div>
	<div id="custom-control-menu" class="col col-md-12"><#include "${full_templates_path}/header.ftl" /></div>
</div>
<#if isAdmin>
	<@liferay_util["include"] page=body_top_include />
</#if> 




<div id="content" class="row">
	<div id="left-panel" class="float-left p-0" style="width:17%; transition: all 1s ease-in-out;"><#include "${full_templates_path}/left_navigation.ftl" /></div>
	<div id="portlet-area" class="float-left pl-4 pr-4" style="width:83%; transition: all 1s ease-in-out;">
		<section class="${portal_content_css_class}" >
			<h2 class="sr-only" role="heading" aria-level="1">${the_title}</h2>
 
			<#if selectable>
				<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}

				${portletDisplay.setTitle(the_title)}

				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
		</section>
	</div>
	<#-- <div id="right-panel" class="float-right p-0" style="width:5%; transition: all 1s ease-in-out;"><#include "${full_templates_path}/right_navigation.ftl" /></div> -->
</div>
<div id="footer" class="row">
	<div id="footer-panel" class="col col-md-12">
		<@liferay_util["include"] page=body_bottom_include />
		<@liferay_util["include"] page=bottom_include />
	</div>
</div>
<#assign isAdmin= themeDisplay.getPermissionChecker().isOmniadmin()>
</body>
<script>
	$(document).ready(function() {
		if("${isAdmin?string}"=="true"){
			$("#control-menu-right").show();
		}
	});
</script>
<@liferay.js file_name = "${javascript_folder}/custom/app.js" />
</html>