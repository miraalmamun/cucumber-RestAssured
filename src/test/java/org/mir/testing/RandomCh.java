package org.mir.testing;

public class RandomCh {

	public static void main(String[] args) {

	}

	static String getAlphaString(int n) {

		// chose a Character random from this String
		String AlphaStringSmall = "abcdefghijklmnopqrstuvwxyz" ;

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
	
	static String getNumericString(int n) {

		String NumericString = "0123456789" ;

		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			int index = (int) (NumericString.length() * Math.random());

			sb.append(NumericString.charAt(index));
		}

		return sb.toString();
	}
	
	
}
