package io.jetprocess.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;


@Component(
			immediate = true,
			property = {
					"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
				"mvc.command.name="+MVCCommandNames.VIEW_FILELIST
			},
			service = MVCRenderCommand.class
		)

public class ViewPageRenderCommand implements MVCRenderCommand{
	

	

		@Override
		public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
			System.out.println("view/home page --called");
			return "/file/created-file-list.jsp";
		}

		
		
	}

