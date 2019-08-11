package restAssuredAPITests;

import static io.restassured.RestAssured.when;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Request {
	
	public void deleteEmployeeRecord() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/11493";
		
		
		//To store response body , if we want to store response body
		
		Response response = 
		
		//we can skip writing given() if there is no pre-requisite
		//given()
		
		when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			//to log the messages
			.log().all()
			.extract().response();
		
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("successfully! deteted Records"),true);
	}

}
