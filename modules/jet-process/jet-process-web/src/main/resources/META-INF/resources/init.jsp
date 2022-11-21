<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="java.util.List"%>
<%@page import="io.jetprocess.model.Receipt"%>
<%@page import="io.jetprocess.service.ReceiptLocalServiceUtil"%>
<%@page import ="io.jetprocess.masterdata.service.UserPostLocalServiceUtil" %>
<%@ page import="io.jetprocess.masterdata.model.UserPost" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<link rel="stylesheet" 
  href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
  