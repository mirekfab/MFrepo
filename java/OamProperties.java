package com.acision.oam.hook.events;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class OamProperties extends Properties
{
    private static final long serialVersionUID = 1L;
    
    public String getAdmin()
    {
        return getProperty("oam-admin");
    }
    
    public String getAdminPasswd()
    {
        return getProperty("oam-admin-passwd");
    }
    
    public String getCommunity()
    {
        return getProperty("oam-community");
    }
    
    public String getCommunityUrl()
    {
        return getProperty("oam-community-url");
    }
    
    public String getCommunityDesc()
    {
        return getProperty("oam-community-desc");
    }
    
    public String getSecurityTagset()
    {
        return getProperty("oam-security-tagset");
    }
    
    public String getOamTheme()
    {
        return getProperty("oam-theme-id");
    }

    public String getWelcomeText()
    {
        return getProperty("oam-welcome-text");
    }
    
    public List<String> getPortletsToDisable()
    {
        return Arrays.asList(getProperty("disabled-portlets").split(","));
    }
    
    public List<String> getComunityRoles()
    {

        return Arrays.asList(getProperty("system.community.roles").split(","));

    } 

    public String getComunityRoleDesc(String roleName)
    {
        return getProperty("system.community.role." + roleName + ".description");
    } 
    
    public String[] getComunityRoleActions(String role)
    {
        return getProperty("system.community.role." + role + (".actions")).split(",");
    }
    
}
