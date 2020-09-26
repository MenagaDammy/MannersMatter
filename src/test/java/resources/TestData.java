package resources;

public class TestData {
	
	APIResources apiRes;
	
	public String getDeleteBody(String questionname)
	{
		return "{\r\n    \"questions\":\""+questionname+"\"\r\n}";
	}
	
	public APIResources getResourceValue(String apitype)
	{
		apiRes = APIResources.valueOf(apitype);
		return apiRes;
	}

}
