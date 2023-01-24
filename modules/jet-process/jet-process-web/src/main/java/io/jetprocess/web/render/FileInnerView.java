package io.jetprocess.web.render;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
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
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.FileList;
import io.jetprocess.list.model.FileCorrespondenceReceiptDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.Note;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.service.persistence.NotePersistence;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.display.context.FileCorrespondenceManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=/PutInFile" }, service = MVCRenderCommand.class)
public class FileInnerView implements MVCRenderCommand {
	@Reference
	private MasterdataLocalService masterdataLocalService;

	@Reference
	private DocFileLocalService docFileLocalService;
	
	long fileMovementId = 0;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		String currentURL = ParamUtil.getString(renderRequest, "backPageURL");
		 fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");


		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession sessionPutInFileId = themeDisplay.getRequest().getSession();
		sessionPutInFileId.setAttribute("putInFileId", docFileId);
		
		   String UpostId = (String) sessionPutInFileId.getAttribute("userPostId"); 
		   long userPostId = Long.parseLong(UpostId);
		   System.out.println("UpostId"+userPostId);
		


			try {
				DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
				renderRequest.setAttribute("nature",docFile.getNature() );
				renderRequest.setAttribute("docFileId",docFileId);
				renderRequest.setAttribute("docFileObj", docFile);
				renderRequest.setAttribute("CurrentURL", currentURL);
				renderRequest.setAttribute("fileMovementId", fileMovementId);
				Note note = noteLocalService.getNoteByUserPostId(userPostId);
				renderRequest.setAttribute("noteId", note.getNoteId());
				renderRequest.setAttribute("noteObj", note);

			} catch (PortalException e) {
			   e.printStackTrace();
			}
			setCorrespondenceListAttributes(renderRequest);
			setCorrespondenceToolbarAttributes(renderRequest,renderResponse);
		
		return "/file/file-inner-view.jsp";
	}
	 
	private void setCorrespondenceListAttributes(RenderRequest renderRequest) {
		logger.info("setting Correspondence list Attribute...");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		HttpSession session = themeDisplay.getRequest().getSession();
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		long fileId = docFileId;
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "modifiedDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
		int count = fileLists.getFileCorrespondenceCount(fileId, keywords);
		logger.info("Count of File list : "+count);
		int preDelta = 0;
		String d = (String) session.getAttribute("preDelta");
		if (d != null) {
			preDelta = Integer.parseInt(d);
			
		}
		Map<String, Integer> paginationConfig=Pagination.getOffset(delta, currentPage, count, preDelta);
		start=paginationConfig.get("start");
		currentPage=paginationConfig.get("currentPage");
		
		session.setAttribute("preDelta", "" + delta + "");
		List<FileCorrespondenceReceiptDTO> fileCorrespondence = fileLists.getFileCorrespondence(fileMovementId,fileId, keywords, start, end, orderByCol, orderByType);
		
		
		logger.info("File Correspondence list------> : "+fileCorrespondence);
		renderRequest.setAttribute("fileCorrespondence", fileCorrespondence);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("fileCorrespondenceCount", count);
	}
	

	private void setCorrespondenceToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		FileCorrespondenceManagementToolbarDisplayContext fileCorrespondenceManagementToolbarDisplayContext = new FileCorrespondenceManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("fileCorrespondenceManagementToolbarDisplayContext",
				fileCorrespondenceManagementToolbarDisplayContext);

	}
	 
	private static Log logger = LogFactoryUtil.getLog(FileInnerView.class);
	
	@Reference
	private Portal _portal;
	@Reference
	private FileList fileLists;
	@Reference
	private NoteLocalService noteLocalService;

	 
	

}
