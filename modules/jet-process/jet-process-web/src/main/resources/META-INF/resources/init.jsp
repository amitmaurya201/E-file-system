<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<link rel="stylesheet" 
  href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
  
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="io.jetprocess.masterdata.model.FileListViewDto"%>
<%@ page import="io.jetprocess.masterdata.model.ReceiptListViewDto"%>
<%@ page import="io.jetprocess.masterdata.service.MasterdataLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>

<%@page import ="io.jetprocess.masterdata.service.UserPostLocalServiceUtil" %>
<%@ page import="io.jetprocess.masterdata.model.UserPost" %>

<%@page import="com.liferay.portal.kernel.servlet.PortalSessionThreadLocal"%>
 <%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<!-- Getting the User Post Id from the session -->
<%
String selectedUserPostId = "1";
HttpSession httpSession = themeDisplay.getRequest().getSession();
if(httpSession != null){
	selectedUserPostId = (String)httpSession.getAttribute("userPostId");
}
%>



<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
