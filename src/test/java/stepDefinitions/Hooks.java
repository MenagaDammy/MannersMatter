package stepDefinitions;

import cucumber.api.java.Before;

public class Hooks {
	
	@Before("@deleteQuestionAPI")
	public void deleteBeforeScenarion() throws Throwable
	{
		KidsAppStepDefinition kapp = new KidsAppStepDefinition();
		kapp.add_question_Payload_with("chapter10", "Test Question", "choices", "Option A", "Option B", "Option C");
		kapp.user_calls_with_http_request("addQuestionAPI", "POST");
		kapp.in_response_body_is("message", "Chapter created");
	}
	
	
	

	

}
