package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReUsableMethods {

	public static String getJsonPathValue(Response res, String key) {
		String response = res.asString();
		JsonPath jsp = new JsonPath(response);
		return jsp.get(key).toString();
	}

	public static JsonPath getJsonPath(String response) {
		return new JsonPath(response);
	}

	public static String getNumericString(int n) {

		String NumericString = "0123456789";

		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			int index = (int) (NumericString.length() * Math.random());

			sb.append(NumericString.charAt(index));
		}

		return sb.toString();
	}

	public static String getAlphaString(int n) {

		// chose a Character random from this String
		String AlphaStringSmall = "abcdefghijklmnopqrstuvwxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaStringSmall.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaStringSmall.charAt(index));
		}

		return sb.toString();
	}
}
