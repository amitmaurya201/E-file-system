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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.FileListService;
import io.jetprocess.list.model.FileCorrespondenceReceiptDTO;
import io.jetprocess.list.model.NoteDTO;
import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.FileNote;
import io.jetprocess.model.Note;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileNoteLocalService;
import io.jetprocess.service.NoteLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.FileCorrespondenceManagementToolbarDisplayContext;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILEINNERVIEW_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class FileInnerViewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");
		renderRequest.setAttribute("putInFileId", docFileId);
		String viewMode = ParamUtil.getString(renderRequest, "viewMode");
		
		List<NoteDTO> noteList = fileLists.getAttachedNoteList(viewMode, fileMovementId, docFileId);
		 renderRequest.setAttribute("noteList", noteList); 
		// renderRequest.setAttribute("sectionId", sectionId);
		try {
			DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
			allowToCloseFile(renderRequest, docFile);
			renderRequest.setAttribute("nature", docFile.getNature());
			renderRequest.setAttribute("docFileId", docFileId);
			renderRequest.setAttribute("docFileObj", docFile);
			renderRequest.setAttribute("fileMovementId", fileMovementId);
			renderRequest.setAttribute("backPageURL", backPageURL);
			FileNote fileNote = fileNoteLocalService.getFileNoteByFilemovementId(fileMovementId);
			System.out.println("fileNoteObj"+fileNote);
			if (fileNote != null) {
				Note note = noteLocalService.getNote(fileNote.getNoteId());
				renderRequest.setAttribute("noteContent", note.getContent());
				renderRequest.setAttribute("modifiedDate", note.getModifiedDate());
				System.out.println("note.getModifiedDate()"+note.getModifiedDate());
				renderRequest.setAttribute("fileNoteObj", fileNote);

			}
		
		} catch (PortalException e) {
			e.printStackTrace();
		}
		setCorrespondenceListAttributes(renderRequest);
		setCorrespondenceToolbarAttributes(renderRequest, renderResponse);

		return "/file/file-inner-view.jsp";
	}

	private void allowToCloseFile(RenderRequest renderRequest, DocFile docFile) {
		long postId= UserPostUtil.getUserIdUsingSession(renderRequest);
		UserPost userPost = userPostLocalService.getUserPostById(postId);
		if(docFile.getDealingHeadSectionId()==userPost.getSectionId()) {
			renderRequest.setAttribute("closeAccess", true);
		}
	}

	private void setCorrespondenceListAttributes(RenderRequest renderRequest) {
		logger.info("setting Correspondence list Attribute...");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		long fileMovementId = ParamUtil.getLong(renderRequest, "fileMovementId");
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		int count = 0;
		long docFileId = ParamUtil.getLong(renderRequest, "docFileId");
		long fileId = docFileId;
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "modifiedDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		String viewMode = ParamUtil.getString(renderRequest, "viewMode");
		if (Validator.isNull(viewMode)) {
			count = fileLists.getFileCorrespondenceCount(viewMode, fileMovementId, fileId, keywords);
		} else {

			count = fileLists.getFileCorrespondenceCount(viewMode, fileMovementId, fileId, keywords);
		}
		logger.info("Count of File list : " + count);
		
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");

		if (Validator.isNull(viewMode)) {
			List<FileCorrespondenceReceiptDTO> fileCorrespondence = fileLists.getFileCorrespondence(viewMode,
					fileMovementId, fileId, keywords, start, end, orderByCol, orderByType);
			renderRequest.setAttribute("fileCorrespondence", fileCorrespondence);
			renderRequest.setAttribute("delta", delta);
			renderRequest.setAttribute("fileCorrespondenceCount", count);
		} else {
			List<FileCorrespondenceReceiptDTO> fileCorrespondence = fileLists.getFileCorrespondence(viewMode,
					fileMovementId, fileId, keywords, start, end, orderByCol, orderByType);
			renderRequest.setAttribute("fileCorrespondence", fileCorrespondence);
			renderRequest.setAttribute("delta", delta);
			renderRequest.setAttribute("fileCorrespondenceCount", count);
		}
	}

	private void setCorrespondenceToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		FileCorrespondenceManagementToolbarDisplayContext fileCorrespondenceManagementToolbarDisplayContext = new FileCorrespondenceManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("fileCorrespondenceManagementToolbarDisplayContext",
				fileCorrespondenceManagementToolbarDisplayContext);
	}

	private static Log logger = LogFactoryUtil.getLog(FileInnerViewRenderCommand.class);

	@Reference
	private Portal _portal;

	@Reference
	private FileListService fileLists;

	@Reference
	private NoteLocalService noteLocalService;

	@Reference
	private FileNoteLocalService fileNoteLocalService;

	@Reference
	private DocFileLocalService docFileLocalService;
	@Reference
	private UserPostLocalService userPostLocalService;

}
