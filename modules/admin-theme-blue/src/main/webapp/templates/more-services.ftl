<!-- <div class="dropdown ml-4 app-more-dropdown">
        <span id="dropdownMenuButton" title="Comnet Applications" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-qrcode font-sm"></i>
        </span>
        <div class="dropdown-menu service-dropdown p-3" aria-labelledby="dropdownMenuButton">
-->                     
           <#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />

        <@liferay.navigation_menu
          default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap)
          instance_id="service_navigation_menu"
        />
            
<!--       </div>
        
         
        
      </div>
-->      
      
     