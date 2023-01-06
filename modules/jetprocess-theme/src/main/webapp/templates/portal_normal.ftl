<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	
	<@liferay.css file_name="${css_folder}/custom/style.css" />
	<@liferay.css file_name="${css_folder}/custom/stylesheet.css" />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

		<#assign roleLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.RoleLocalService")/>
		<#assign userLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService")/>
		<#assign owner = roleLocalService.getRole(company_id, "Owner")/>
		<#assign site_owner = roleLocalService.getRole(company_id, "Site Owner")/>
		<#assign site_admin = roleLocalService.getRole(company_id, "Administrator")/>
		<#assign isAdmin = userLocalService.hasRoleUser(site_admin.getRoleId(), user_id)/>
		<#if isAdmin>
			<@liferay.control_menu />
		</#if>
		


<#--<div class="container-fluid position-relative" id="wrapper"> -->

	
	

		<#include "${full_templates_path}/header.ftl" />

	
	<section id="content">
		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<#--<footer id="footer" role="contentinfo">
		<div id="footer-panel" >
			<@liferay_util["include"] page=body_bottom_include />
			<@liferay_util["include"] page=bottom_include />
		</div>
	</footer>
</div>-->

<#--<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include /> -->

</body>

</html>