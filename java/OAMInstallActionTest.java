package com.acision.oam.hook.events;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class OAMInstallActionTest
{
    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    private Resource resourceMock = mock(Resource.class);
    private OamProperties properties;

    @Before
    public void setUp() throws Exception
    {
        properties = new OamProperties();
        properties.load(getClass().getClassLoader().getResourceAsStream("users" + 
                                                             File.separator + "oam.properties"));
    }

    private void prepareResourceService()
    {
        
//        when(resourceMock.getInstance("Ahoj")).thenReturn(resourceMock);
        when(resourceMock.getResourceId(anyString())).thenReturn(1L).thenReturn(2L);
}

    @Test
    public void testRunOnlyOnce() throws Exception
    {
    	prepareResourceService();
    	File f = tmpFolder.getRoot();
    	System.out.println("f.getAbsolutePath(): " + f.getAbsolutePath());
    	
    	verify(resourceMock, times(0)).getResourceId(anyString());    	
    	System.out.println(Resource.getInstance("").getResourceId("201") + " nepocita se to");
    	System.out.println("Mock se pocita :" + resourceMock.getResourceId("101"));
//    	System.out.println("Mock se pocita :" + resourceMock.getResourceId("101")); 
        verify(resourceMock, times(1)).getResourceId(anyString());
    }

}
