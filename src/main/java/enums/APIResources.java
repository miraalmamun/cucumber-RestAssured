package enums;

public enum APIResources {

	/**
	 * Declare methods and call it in stepdefination in dynamically
	 * APIResources.valueOf();-->Use this in stepdefination
	 */
	ADDPLACEAPI("/map/api/place/add"), 
	GETPLACEAPI("/map/api/place/get"), 
	DELETEPLACEAPI("/map/api/place/delete");

	private String resource;

	APIResources(String resource) {

		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
