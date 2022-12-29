package io.jetprocess.list;

import com.liferay.admin.kernel.util.Omniadmin;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * @author 12345
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = Omniadmin.class
)
public class JetProcessList implements Omniadmin {

	@Override
	public boolean isOmniadmin(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOmniadmin(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	// TODO enter required service methods

}