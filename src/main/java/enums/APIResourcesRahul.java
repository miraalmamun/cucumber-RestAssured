package enums;

public enum APIResourcesRahul {

	/**
	 * Declare methods and call it in stepdefination in dynamically
	 * APIResourcesRahul.valueOf();-->Use this in stepdefination
	 * If you call .valueOf() method then constructor will execute
	 */

	// Define Enum class with constants to centralize all resources details
	// Send dynamic way post,get,put,delete in step defination
	// Enum is special class in java which has collection of constants or methods
	// In Enum, there is no body for logic
	// If you want to work with method then have to declare constructor

	ADDPLACEAPI("/maps/api/place/add/json"), 
	GETPLACEAPI("/maps/api/place/get/json"),
	DELETEPLACEAPI("/maps/api/place/delete/json");

	private String resource;
	
	
    //You have to declare one constructor in the Enum when
	//you are working with methods. 
	//We are defined methods here in such a way that every method accepte
	//one argument. So if that is the case, In Enum also we have to
	//define one constructor exactly same way(How method accept inputs)
	//Above all method taking one string input so in constructor we have
	//to take one String input
	APIResourcesRahul(String resource) {

		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
