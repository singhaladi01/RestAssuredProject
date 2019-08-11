package restAssuredAPITests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

/*
 * Test status code
 * Log Response
 * Verify single/multiple content in response body
 * Setting parameters and headers
 */


public class BasicValidations_JSON {
	

	
	@Test(priority = 1)
	public void testStatusCode() {
		//public static void main(String[] args) {
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com/posts/5";
		
		given()
		.when()
			.get()
		.then()	.statusCode(200)
		.log().all();
	}
	
	@Test(priority =2)
	public void testLogging() {
		
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()	
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority =3)
	public void testSingleContent() {
		
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()	
			.statusCode(200)
			.body("RestResponse.result.name", equalTo("India"))
			.log().all();
	}
	
	@Test(priority =4)
	public void testMultiplesContent() {
		
		given()
		.when()
			.get("http://services.groupkt.com/country/get/all")
		.then()	
			.statusCode(200)
			.body("RestResponse.result.name", hasItems("India","Australia","United States of America"))
			.log().all();
	}
	
	@Test(priority =5)
	public void testParamsAndHeaders() {
		
		given()
			//passing parameters and headers key,value as part of my request
			.param("MyName","Aditi")
			.header("MyHeader","Indian")
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()	
			.statusCode(200)
			.log().all();
	}
}
