package io.jetprocess.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
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

import io.jetprocess.web.constants.MVCCommandNames;

/**
 * Assigments management toolbar display context.
 *
 * This class passes contextual information to the user interface for the Clay
 * management toolbar.
 *
 * @author liferay
 */
public class FileManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {

	public FileManagementToolbarDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, HttpServletRequest httpServletRequest) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Returns the creation menu for the toolbar (plus sign on the management
	 * toolbar).
	 *
	 * @return creation menu
	 */
	
	/*
	 * public CreationMenu getCreationMenu() { //Create the menu. CreationMenu
	 * creationMenu=new CreationMenu() { { addDropdownItem(dropdownItem -> {
	 * 
	 * 
	 * dropdownItem.setHref(liferayPortletResponse.createRenderURL(),
	 * "mvcRenderCommandName", MVCCommandNames.EDIT_ASSIGNMENT, "redirect",
	 * currentURLObj.toString()); dropdownItem.setLabel(LanguageUtil.get(request,
	 * "add-assignment"));
	 * 
	 * }); } };
	 * 
	 * return creationMenu; }
	 */
	 

	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}

	
	/**
	 * Returns the sort order column.
	 * 
	 * @return sort column
	 */
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

		PortletURL searchURL = liferayPortletResponse.createActionURL();

//		searchURL.setProperty("mvcRenderCommandName", MVCCommandNames.VIEW_FILELIST);
		
		System.out.println("Search IN ");
		String navigation = ParamUtil.getString(request, "navigation", "entries");
		searchURL.setParameter("navigation", navigation);
		searchURL.setParameter("mvcPath,","./file/created-file-list.jsp" );
//		searchURL.setParameter("mvcPath", "./file/created-file-list.jsp");
		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());

		return searchURL.toString();
	}
 
	
	
	@Override
	protected List<DropdownItem> getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				add(dropdownItem -> {
					dropdownItem.setActive("subject".equals(getOrderByCol()));
					dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "subject");
					dropdownItem.setLabel(LanguageUtil.get(request, "subject", "subject"));
				});

				add(dropdownItem -> {
					dropdownItem.setActive("remarks".equals(getOrderByCol()));
					dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "remarks");
					dropdownItem.setLabel(LanguageUtil.get(request, "remarks", "remarks"));
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

		sortingURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_FILELIST);

		// Reset current page.

		sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");
		String keywords = ParamUtil.getString(request, "keywords");
		System.out.println("Request for searching.. "+keywords);

		if (Validator.isNotNull(keywords)) {
			sortingURL.setParameter("keywords", keywords);
		}

		return sortingURL;
	}
	
	public PortletURL _getCurrentURL() throws PortletException {
		PortletURL sortingURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);

		sortingURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_FILELIST);

		return sortingURL;
	}

	private final PortalPreferences _portalPreferences;
	private final ThemeDisplay _themeDisplay;

}