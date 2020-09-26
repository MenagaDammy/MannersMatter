package resources;

public enum APIBase 
{
	
	KIdsBase("http://34.75.105.197:8080");
	
	String base;
	
	APIBase (String base)
	{
		this.base = base;
	}
	
	public String getBase()
	{
		return base;
	}

}
