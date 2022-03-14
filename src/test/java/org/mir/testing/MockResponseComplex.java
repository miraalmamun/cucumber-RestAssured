package org.mir.testing;

import java.io.File;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import jsonpayload.PayLoadFactory;

public class MockResponseComplex {
	
	
	
	
	static  String filepath = "C:/Users/miraa/STS4Project/BddCucumberRestNote/src/main/resources/alljsonfiles/ResponseMockComplexJson.json";
	
	public static void main(String[] args) {
		
		JsonPath jsp = new JsonPath(new File(filepath));
		
		System.out.println("jsp---> "+jsp.getString("dashboard.website"));
		
		JsonPath jsp2 = new JsonPath(PayLoadFactory.coursePrice());
		
		System.out.println("jsp2--> "+jsp2.getString("dashboard.website"));
		
		//Print No of Courses returned by API
		
		int noCourses = jsp2.getInt("courses.size()");
		System.out.println(noCourses);
		
		System.out.println("Printing Courses: ");
		
		for(int i = 0; i < noCourses; i++)
		{
			System.out.print(jsp2.getString("courses["+i+"].title")+", ");
		}
		
		//Print Purchase Amount
		
		int purchaseAmount = jsp2.getInt("dashboard.purchaseAmount");
		System.out.println();
		System.out.println("\nPurchase Amount: "+purchaseAmount);
		
		//Print Title of the first course
		
		if(noCourses > 0)
		{
			System.out.println("\nPrint Title of the first course: "+jsp2.getString("courses[0].title"));
		}
		
		
		//Print All course titles and their respective Prices
		
		
		for(int i = 0; i < noCourses; i++)
		{
			String title = jsp2.getString("courses["+i+"].title");
			int price = jsp2.getInt("courses["+i+"].price");
			
			System.out.println("\nTile: "+title+" & price: "+price);
		}
		
		
		//Print No of copies sold by RPA Course
		
		
		
		for(int i = 0; i < noCourses; i++)
		{
			String title = jsp2.getString("courses["+i+"].title");
			int copy = jsp2.getInt("courses["+i+"].copies");
			
			if(title.equals("RPA"))
			{
				System.out.println("Printed No of copies sold by RPA Course: "+copy);
			}
		}
		
		
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		
		
		int totalPurchaseAmount = 0;
		
		
		
		for(int i = 0; i < noCourses; i++)
		{
			
			int price = jsp2.getInt("courses["+i+"].price");
			int copies = jsp2.getInt("courses["+i+"].copies");
			int totalPrice = price*copies;
			
			totalPurchaseAmount+=totalPrice;
			
		}
		
		
		System.out.println(purchaseAmount+" = "+totalPurchaseAmount);
		
		Assert.assertEquals(purchaseAmount, totalPurchaseAmount,"Price is not matching");
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
