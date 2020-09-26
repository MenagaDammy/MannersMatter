package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	
	public static RequestSpecification req;
	public ResponseSpecification res;
	 APIResources apires;
	 APIBase apibs;
	
	public RequestSpecification reqSpecification() throws FileNotFoundException 
	{
		if(req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		apibs = APIBase.valueOf("KIdsBase");
		
		req= new RequestSpecBuilder().setBaseUri(apibs.getBase()).setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return req;
		}
		return req;
	}
	
	public ResponseSpecification resSpecification()
	{
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		return res;
	}
	
	public String getJsonPathString(Response response,String key)
	{
		String resfinal = response.asString();
		JsonPath jp = new JsonPath(resfinal);
	   return jp.getString(key);
	}

}
