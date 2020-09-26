package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.QuestionDetails;
import resources.APIResources;
import resources.QuestionData;
import resources.TestData;
import resources.Utils;

public class KidsAppStepDefinition extends Utils {
	
	 RequestSpecification req;
	 ResponseSpecification res;
	 QuestionData quesData = new QuestionData();
	 TestData td = new TestData();
	 APIResources apiRes;
	 Response response;
	 String question;
	 
	
	@Given("^Add question Payload with \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_question_Payload_with(String chapter, String questions, String choices, String goldAnswer, String silverAnswer, String bronzeAnswer) throws Throwable 
	{
		
		req = given().spec(reqSpecification()).body(quesData.getQuesDetails(chapter, questions, choices, goldAnswer, silverAnswer, bronzeAnswer));
	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_calls_with_http_request(String apitype, String reqtype) throws Throwable 
	{
		if(reqtype.equalsIgnoreCase("POST"))
		{
			response = req.when().post((td.getResourceValue(apitype)).getResource()).then().spec(resSpecification()).extract().response();
		}
		else
		{
			response = req.when().get(apiRes.getResource()).then().extract().response();
		}
	}

	@Then("^the API call got success with status code (\\d+)$")
	public void the_API_call_got_success_with_status_code(int expectedCode) throws Throwable 
	{
		assertEquals(response.getStatusCode(),expectedCode);
	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String key, String value) throws Throwable 
	{
		assertEquals(getJsonPathString(response,key),value);
	}
	
	@When("^delete added question \"([^\"]*)\" using  \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void delete_added_question_using_with_http_request(String question, String apitype, String reqtype) throws Throwable
	{
	    response = given().spec(reqSpecification()).body(td.getDeleteBody(question)).when().delete((td.getResourceValue(apitype)).getResource()).then().extract().response();
	}

	@Given("^Base uri endpoint$")
	public void base_uri_endpoint() throws Throwable 
	{
	    req = given().spec(reqSpecification());
	}
	
	@When("^user calls \"([^\"]*)\" argument \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_calls_argument_with_http_request(String apitype, String resource, String reqtype) throws Throwable 
	{  
		response = req.when().get((td.getResourceValue(apitype)).getResource() + resource ).then().extract().response();  
	}
	
	  
}
