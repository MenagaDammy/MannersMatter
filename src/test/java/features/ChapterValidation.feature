Feature: KidsApp Validation

Scenario Outline: Verify if question is added successfully
Given Add question Payload with "<chapter>"  "<questions>" "<choices>" "<goldAnswer>" "<silverAnswer>" "<bronzeAnswer>"
When user calls "addQuestionAPI" with "Post" http request
Then the API call got success with status code 201
And "message" in response body is "Chapter created"
And  delete added question "<questions>" using  "deleteQuestionAPI" with "delete" http request 
And the API call got success with status code 201

Examples:

|chapter     | questions                               | choices       |goldAnswer    |silverAnswer    |bronzeAnswer |
|chapter3    | Where do you draw if you want to paint? | --            |draw on paper |draw on floor   |draw on wall|

@deleteQuestionAPI
Scenario Outline: Verify if question is deleted successfully 
When delete added question "<questions>" using  "deleteQuestionAPI" with "delete" http request 
Then the API call got success with status code 201
And "message" in response body is "Question deleted"

Examples:

| questions     | 
| Test Question | 


Scenario: Verify get all question endpoint is working
Given Base uri endpoint
When user calls "getAllQuestionAPI" with "Post" http request
Then the API call got success with status code 201

@Test
Scenario: verify if get list of all chapter call is working
Given Base uri endpoint
When user calls "getAllChapterListAPI" argument "listAllChapters" with "GET" http request
Then the API call got success with status code 200

@Test
Scenario: Verify if Not found chapter is working
Given Base uri endpoint
When user calls "getNotFoundChapterAPI" argument "chapterxzy123" with "GET" http request
Then the API call got success with status code 404
And "message" in response body is "chapterxzy123questions are not available"

@Test
Scenario: Verify if chapter wise call is working
Given Base uri endpoint
When user calls "getChapterQuestionAPI" argument "chapter1" with "GET" http request
Then the API call got success with status code 200



