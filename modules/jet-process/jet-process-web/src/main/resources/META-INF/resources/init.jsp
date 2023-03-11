<%@page import="io.jetprocess.web.util.ViewHelper"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<%@taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.time.OffsetDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page
	import="io.jetprocess.masterdata.service.MasterdataLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="io.jetprocess.model.DocFile"%>
<%@page import="io.jetprocess.model.FileMovement"%>
<%@page import="io.jetprocess.masterdata.model.FileListViewDto"%>
<%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page import="io.jetprocess.service.FileMovementLocalServiceUtil"%>
<%@page import="io.jetprocess.model.Receipt"%>
<%@page import="io.jetprocess.service.ReceiptLocalServiceUtil"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptListViewDto"%>
<%@page import="io.jetprocess.model.ReceiptMovement"%>
<%@page import="io.jetprocess.service.ReceiptMovementLocalServiceUtil"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@page import="com.liferay.portal.kernel.util.SessionParamUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page
	import="io.jetprocess.masterdata.service.UserPostLocalServiceUtil"%>
<%@page import="io.jetprocess.masterdata.model.UserPost"%>
<%@page
	import="com.liferay.portal.kernel.servlet.PortalSessionThreadLocal"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page
	import="io.jetprocess.web.display.context.FileManagementToolbarDisplayContext"%>
<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page
	import="io.jetprocess.web.display.context.FileCorrespondenceManagementToolbarDisplayContext"%>
<%@page
	import="io.jetprocess.web.display.context.AddCorrespondenceManagementToolbarDisplayContext"%>
<%@page import="io.jetprocess.model.FileNote"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="io.jetprocess.list.model.NoteDTO"%>
<%@page import="io.jetprocess.list.model.ClosedReceiptDTO"%>
<%@page import="io.jetprocess.model.Note"%>
<%@page import="io.jetprocess.model.NoteDocument"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<!-- Includes -->
<%@include file="/common/common.jsp"%>
<!-- link element -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/datepicker/bootstrap-datepicker.min.css" />

<!-- Script Element -->
<script
	src="<%=request.getContextPath()%>/datepicker/bootstrap-datepicker.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

<!-- Getting the User Post Id from the session -->
<%
	String selectedUserPostId = "1";
	HttpSession httpSession = themeDisplay.getRequest().getSession();
	if (httpSession != null) {
		selectedUserPostId = (String) httpSession.getAttribute("userPostId");
	}
	SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
	simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));

	SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
	simpleFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
%>

<!-- editor -->
<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>
<liferay-editor:resources editorName="ckeditor" />