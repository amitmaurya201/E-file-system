package io.jetprocess.web.render;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.MasterdataService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileManagementToolbarDisplayContext;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
			"mvc.command.name="+MVCCommandNames.VIEW_FILELIST,
			"mvc.command.name=/"
			
			
		},
		service = MVCRenderCommand.class
	)
public class CreatedFileListRenderCommand implements MVCRenderCommand {
	
	
	private static Log logger = LogFactoryUtil.getLog(CreatedFileListRenderCommand.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		// Add assignment list related attributes.
logger.info("View Render...");
	String keywords = ParamUtil.getString(renderRequest, "keywords");
	System.out.println("CreatedFileListRenderCommand.render() keywords : " + keywords);
		addAssignmentListAttributes(renderRequest);
		addManagementToolbarAttributes(renderRequest, renderResponse);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		
		// Add Clay management toolbar related attributes.
//		logger.info("======>View Render...2"+userPost);

		return "/file/created-file-list.jsp";
	}

	/***
	 * 
	 * Adds assigment list related attributes to the request.**
	 * 
	 * @param renderRequest
	 */
	private void addAssignmentListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				2);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;

		HttpSession session = themeDisplay.getRequest().getSession();
		 String userPostId =  (String) session.getAttribute("userPostId");
		 long userPost = 1;  
		// Get sorting options.
		// Notice that this doesn't really sort on title because the field is
		// stored in XML. In real world this search would be integrated to the
		// search engine
		// to get localized sort options.
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "subject");

		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		// Create comparator
		OrderByComparator<?> comparator = OrderByComparatorFactoryUtil.create("DocFile", orderByCol,
				!("asc").equals(orderByType));
		// Get keywords.
		// Notice that cleaning keywords is not implemented.
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		// Call the service to get the list of assignments.
//		List<FileListViewDto>  assignments = masterdataLocalService.getFileCreatedByKeywords(userPost,
//				keywords, start, end, orderByCol,orderByType);
		
		
		System.out.println("keywords on create render : "+keywords);
		List<FileListViewDto>  assignments = masterdataLocalService.getFileCreatedByKeywords(userPost,
				keywords, start, end, orderByCol,orderByType);  
		
		
		
		// Set request attributes.
		logger.info("assignments :=============== "+assignments.size());
//		logger.info("assignments : "+assignments);
		renderRequest.setAttribute("assignments", assignments);
		
		renderRequest.setAttribute("assignmentCount",+masterdataLocalService.getFileCreatedByKeywordCount(userPost,
				keywords, start, end, "docfileid","asc"));
		logger.info("count : "+masterdataLocalService.getFileCreatedByKeywordCount(userPost,
				keywords, start, end, "docfileid","asc"));
	}

	/**
	 * Adds Clay management toolbar context object to the request.*
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		FileManagementToolbarDisplayContext fileManagementToolbarDisplayContext = new FileManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("fileManagementToolbarDisplayContext",
				fileManagementToolbarDisplayContext);
		
	}
	
	@Reference
	private MasterdataService masterData;
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal _portal;
}
