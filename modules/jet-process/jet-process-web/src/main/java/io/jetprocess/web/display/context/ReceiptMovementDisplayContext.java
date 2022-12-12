package io.jetprocess.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import io.jetprocess.web.constants.MVCCommandNames;

public class ReceiptMovementDisplayContext extends BaseManagementToolbarDisplayContext {

	public ReceiptMovementDisplayContext(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, HttpServletRequest httpServletRequest) {
		super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);
		portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
	}
	
	public PortletURL getCurrentURL() throws PortletException {
		PortletURL currentURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);
		currentURL.setParameter("mvcRenderCommandName", MVCCommandNames.RECEIPT_MOVEMENT_RENDER_COMMAND);
		return currentURL;
	}
	
	private final PortalPreferences portalPreferences;
	private final ThemeDisplay themeDisplay;
}
