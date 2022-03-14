package jsonpayload;

public class PayLoadFactory {
	
	
	
	public static String addPlace()
	{
		String payload="{\r\n"
				+ "	\"location\": {\r\n"
				+ "		\"lat\": -38.383494,\r\n"
				+ "		\"lng\": 33.427362\r\n"
				+ "	},\r\n"
				+ "	\"accuracy\": 50,\r\n"
				+ "	\"name\": \"Frontline house\",\r\n"
				+ "	\"phone_number\": \"9176356542\",\r\n"
				+ "	\"address\": \"29, side layout, cohen 09\",\r\n"
				+ "	\"types\": [\r\n"
				+ "		\"shoe park\",\r\n"
				+ "		\"shop\"\r\n"
				+ "	],\r\n"
				+ "	\"website\": \"https://rahulshettyacademy.com\",\r\n"
				+ "	\"language\": \"French-IN\"\r\n"
				+ "}";
		
		return payload;
	}
	
	
	
	public static String update(String placeId, String ... st)
	{
		return "{\r\n"
				+ "  \"place_id\": \""+placeId+"\",\r\n"
				+ "  \"address\": \""+st[0]+"\",\r\n"
				+ "  \"language\": \""+st[1]+"\",\r\n"
				+ "  \"key\": \"qaclick123\"\r\n"
				+ "}";
	}
	
	
	public static String coursePrice()
	{
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	
	
	
	public static String addBookInLibrary(String isbn, String aisle)
	{
		String payLoadForPost = "{\r\n"
				+ "    \"name\": \"Mir JavaJ\",\r\n"
				+ "    \"isbn\": \""+isbn+"\",\r\n"
				+ "    \"aisle\": \""+aisle+"\",\r\n"
				+ "    \"author\": \"Mir Mamun\"\r\n"
				+ "}";
		
		return payLoadForPost;
	}
	
	
	public static String deleteBookFromLibrary(String id)
	{
		return "{\r\n"
				+ "    \"ID\": \""+id+"\"\r\n"
				+ "}";
	}
	
	
	
	public static String placeById(String id)
	{
		return "{\r\n"
				+ "    \"place_id\": \""+id+"\"\r\n"
				+ "}";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
