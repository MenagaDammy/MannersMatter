package resources;

public enum APIResources {
	
	addQuestionAPI("/qna"),
	deleteQuestionAPI("/qna"),
	getAllQuestionAPI("/qna"),
	getChapterQuestionAPI("/qna/"),
	getAllChapterListAPI("/qna/"),
	getNotFoundChapterAPI("/qna/");
	
	String resource;
	
	
	APIResources(String resource) 
	{
		this.resource = resource;
	}
	
    public String getResource()
    {
    	return resource;
    }
}
