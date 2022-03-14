package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	 static RequestSpecification reqSpec;
	 static ResponseSpecification resSpec;
	 private static final Logger LOGGER = LoggerFactory.getLogger(SpecBuilder.class);

	public static RequestSpecification requestSpecification() {
      LOGGER.info("In SpecBuilder");
		if (reqSpec == null) {

			PrintStream log = null;
			try {
				log = new PrintStream(new FileOutputStream("logging.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();

			return reqSpec;

		}
		return reqSpec;
	}

	public static ResponseSpecification responseSpecification() {

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return resSpec;
	}

}
