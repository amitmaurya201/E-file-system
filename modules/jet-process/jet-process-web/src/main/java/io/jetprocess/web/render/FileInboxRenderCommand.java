package io.jetprocess.web.render;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
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

import io.jetprocess.list.api.FileList;
import io.jetprocess.list.model.FileMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.masterdata.service.MasterdataService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileInboxManagementToolbarDisplayContext;
import io.jetprocess.web.display.context.FileManagementToolbarDisplayContext;
import io.jetprocess.web.display.context.SendFileManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name="+MVCCommandNames.FILE_INBOX_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FileInboxRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		addFileInboxListAttributes(renderRequest);
		addFileInboxToolbarAttributes(renderRequest, renderResponse );
		
		return "/file/inbox.jsp";
	}
	
	
	private void addFileInboxListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		HttpSession session = themeDisplay.getRequest().getSession();
		long userPostId = Long.parseLong((String) session.getAttribute("userPostId"));
		String tt = (String) session.getAttribute("userPostId");
		long userPost = Long.parseLong(tt);
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "modifieddate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
//		int fileInboxCount=masterdataLocalService.getFileInboxList(userPost, keywords);
		int fileInboxCount=_fileList.getFileInboxListCount(userPostId, keywords);
		System.out.println("-0-0-0-0-00-0--00--> count"+fileInboxCount);
		int preDelta=0;
		String d=(String) session.getAttribute("oldDelta");
		if(d!=null) {
			preDelta=Integer.parseInt(d);
			
		}
		if(delta !=preDelta) {
			if(delta*currentPage  > fileInboxCount) {
				if(delta*(currentPage-1)  > fileInboxCount) {
					currentPage = getCurrentPage(currentPage, preDelta, fileInboxCount);
				}
				start = delta*(currentPage-1);
			} else if(delta <preDelta) {
					start = delta*(currentPage-1);
			}else {
				
				start=0;
			}
			
		} else if(delta*(currentPage-1)  > fileInboxCount) {
			currentPage = getCurrentPage(currentPage, preDelta, fileInboxCount);
			start = delta*(currentPage-1);
		}
		
		if(start < 0) {
			start = 0;
		}
		
		session.setAttribute("oldDelta", ""+delta+"");
//		 List<FileMovementDTO> fileInboxList = masterdataLocalService.getFileInboxList(userPost, keywords, start, end,orderByCol, orderByType);
		List<FileMovementDTO> fileInboxList =_fileList.getFileInboxList(userPostId, keywords, start, end, orderByCol, orderByType);
		 renderRequest.setAttribute("fileInboxList",fileInboxList);
		renderRequest.setAttribute("fileInboxCount",+fileInboxCount);
		renderRequest.setAttribute("delta",delta);
	}
	
	private static int getCurrentPage(int currentPage, int delta, int count) {
		currentPage = currentPage-1;
		
		if(delta*currentPage  < count) {
			return currentPage;
		} else {
			return getCurrentPage(currentPage, delta, count);
		}
	
}

	/**
	 * Adds Clay management toolbar context object to the request.*
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addFileInboxToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		FileInboxManagementToolbarDisplayContext fileInboxManagementToolbarDisplayContext = new FileInboxManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("fileInboxManagementToolbarDisplayContext", fileInboxManagementToolbarDisplayContext);

	}
	
	
	
	private static Log logger = LogFactoryUtil.getLog(FileInboxRenderCommand.class);
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal _portal;
	
	@Reference
	FileList _fileList;
	
}


