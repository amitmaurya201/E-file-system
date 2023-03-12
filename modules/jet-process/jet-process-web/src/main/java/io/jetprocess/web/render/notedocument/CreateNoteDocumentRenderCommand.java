package io.jetprocess.web.render.notedocument;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.CREATE_NOTE_DOCUMENT_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class CreateNoteDocumentRenderCommand  implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("CreateNoteDocumentRenderCommand------>");
		List<Masterdata> subjectCategoryList = masterdataLocalService.getSubjectCategory();
		renderRequest.setAttribute("subjectCategoryList", subjectCategoryList);
		return "/note-document/create-note-document.jsp";
	}
	private Log logger = LogFactoryUtil.getLog(CreateNoteDocumentRenderCommand.class);

	@Reference
	private MasterdataLocalService masterdataLocalService;

}
