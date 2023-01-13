package io.jetprocess.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.web.constants.MVCCommandNames;

public class ReceiptInboxManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {


	public ReceiptInboxManagementToolbarDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, HttpServletRequest httpServletRequest) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	}

	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}

	public String getOrderByCol() {

		return ParamUtil.getString(request, "orderByCol", "subject");
	}

	/**
	 * Returns the sort type (ascending / descending).
	 * 
	 * @return sort type
	 */
	public String getOrderByType() {

		return ParamUtil.getString(request, "orderByType", "asc");
	}

	/**
	 * Returns the action URL for the search.
	 *
	 * @return search action URL
	 */
	@Override
	public String getSearchActionURL() {

		
		PortletURL searchURL = liferayPortletResponse.createRenderURL();
		searchURL.setParameter("mvcRenderCommandName", MVCCommandNames.RECEIPT_INBOX_RENDER_COMMAND);
		String navigation = ParamUtil.getString(request, "navigation", "entries");
		searchURL.setParameter("navigation", navigation);
		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());
		return searchURL.toString();
	}


	/**
	 * Return the option items for the sort column menu.
	 *
	 * @return options list for the sort column menu
	 */
	@Override
	protected List<DropdownItem> getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				add(dropdownItem -> {
					dropdownItem.setActive("subject".equals(getOrderByCol()));
					dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "subject");
					dropdownItem.setLabel(LanguageUtil.get(request, "subject", "Subject"));
				});

				
				add(dropdownItem -> {
					dropdownItem.setActive("remarks".equals(getOrderByCol()));
					dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "receiptNumber");
					dropdownItem.setLabel(LanguageUtil.get(request, "receiptNumber", "Receipt Number"));
				});
				
			
			}
		};
	}

	/**
	 * Returns the current sorting URL.
	 *
	 * @return current sorting portlet URL
	 *
	 * @throws PortletException
	 */
	private PortletURL _getCurrentSortingURL() throws PortletException {
		PortletURL sortingURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);

		sortingURL.setParameter("mvcRenderCommandName", MVCCommandNames.RECEIPT_INBOX_RENDER_COMMAND);

		// Reset current page.

		sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");
		String keywords = ParamUtil.getString(request, "keywords");

		if (Validator.isNotNull(keywords)) {
			sortingURL.setParameter("keywords", keywords);
		}

		return sortingURL;
	}
	
	@SuppressWarnings("deprecation")
	public PortletURL _getCurrentURL() throws PortletException {
		PortletURL sortingURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);

		sortingURL.setParameter("mvcRenderCommandName", MVCCommandNames.RECEIPT_INBOX_RENDER_COMMAND);

		return sortingURL;
	}
	private static Log logger = LogFactoryUtil.getLog(ReceiptManagementToolbarDisplayContext.class);
	@Reference
	private MasterdataLocalService masterdataLocalService;
	private final PortalPreferences _portalPreferences;
	private final ThemeDisplay _themeDisplay;
	
	
	
}
