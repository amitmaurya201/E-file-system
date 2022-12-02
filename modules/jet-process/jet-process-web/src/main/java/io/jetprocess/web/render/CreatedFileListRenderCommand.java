package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
			"mvc.command.name=/createdFileList"
		},
		service = MVCRenderCommand.class
	)
public class CreatedFileListRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("created-file-list.jsp --called");
		
		String defaultKeyword="";
		System.out.println("created-file-list.jsp --called");
		try {
			String keyword =ParamUtil.getString(renderRequest, "keywords");
		System.out.println("In render "+defaultKeyword);
		if(!(keyword.isEmpty()||keyword==null))
		renderRequest.setAttribute("keywords", keyword);
		else
			renderRequest.setAttribute("keywords", defaultKeyword);
			
		}catch(Exception ex) {
			System.out.println("Error in CreatedFileListRenderCommand : "+ ex.getMessage());
		}	
		return "/file/created-file-list.jsp";
	}

	
	
}
