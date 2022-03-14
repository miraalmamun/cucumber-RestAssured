package pojo.payload;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.place.AddPlace;
import pojo.place.Location;

public class AddPlacePOJO {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddPlacePOJO.class);
	
	public static AddPlace addPayLoad() {

		LOGGER.info("In Payload");
		AddPlace add = new AddPlace();

		Location l = new Location();
		l.setLat(-38.383494D);
		l.setLng(33.427362D);
		add.setLocation(l);

		add.setAccuracy(50);
		add.setName("Frontline house");
		add.setPhone_number("9176356542");
		add.setAddress("29, side layout, cohen 09");

		add.setTypes(Arrays.asList("shoe park", "shop"));

		add.setWebsite("https://rahulshettyacademy.com");
		add.setLanguage("French-IN");

		return add;

	}
	
	public static AddPlace addPayLoad(String name, String phone, String address ) {

		AddPlace add = new AddPlace();

		Location l = new Location();
		l.setLat(-38.383494D);
		l.setLng(33.427362D);
		add.setLocation(l);

		add.setAccuracy(50);
		add.setName(name);
		add.setPhone_number(phone);
		add.setAddress(address);

		add.setTypes(Arrays.asList("shoe park", "shop"));

		add.setWebsite("https://rahulshettyacademy.com");
		add.setLanguage("French-IN");

		return add;

	}


}
