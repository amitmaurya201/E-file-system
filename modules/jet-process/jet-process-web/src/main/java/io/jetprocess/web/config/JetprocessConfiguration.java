package io.jetprocess.web.config;


import com.liferay.portal.configuration.metatype.annotations.ExtendedAttributeDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "jetprocess-configurations", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "io.jetprocess.web.config.JetprocessConfiguration", name = "label-jetprocess-configuration")
public interface JetprocessConfiguration {
	
	@ExtendedAttributeDefinition(descriptionArguments = "Required", requiredInput = true)
	@Meta.AD(required = false, deflt = "", description = "maximum-length", name="label-maximum-length")
	public String getMaximumLength();
}
