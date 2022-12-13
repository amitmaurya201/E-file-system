package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
"mvc.command.name=/fileSentBox" }, service = MVCRenderCommand.class)
public class FileSentBoxRenderCommand implements MVCRenderCommand{

	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
	List<FileMovementDTO> sentList =	masterdataLocalService.getFileSentListByUserPostId(1);
		
	System.out.println("List --->"+sentList);
		return "/file/sent-file-list.jsp";
	}

}
