package com.acision.oam.hook.events;

public class Resource {

	private static Resource INSTANCE;
	
	public Resource(String msg)
    {
        if(INSTANCE!=null)
        {
            throw new IllegalStateException("Instance have been already created!");
        }
        
        System.out.println("@@@ ctor Resource(" + msg + ")");
        INSTANCE = this;
    }
	
	public static Resource getInstance(String msg)
    {
        if(INSTANCE==null)
        {
            INSTANCE = new Resource("initialization");
        }
        
        System.out.println("@@@ Resource getInstance(" + msg + ")");
        
        return INSTANCE;
    }
	
	public long getResourceId(String id) {
		
		Long ret = null;
		
		try 
		{
			ret = new Long(id);//Long.parseLong(id);
		}
		catch (RuntimeException e) 
		{
			System.out.println("### getResourceId: " + e);
		}
		
		return ret;
	}

}
