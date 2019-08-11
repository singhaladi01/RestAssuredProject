package restAssuredAPITests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class Put_Request {

	public static HashMap<String,String> map = new HashMap<String,String>();
	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	//existing employee id which we are updating via put request
	int empID = 11254;
	
	@BeforeClass
	public void postData() {
		map.put("name",empName);
		map.put("salary", empSalary);
		map.put("age", empAge);		
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath ="/update"+empID;
	}
	
	@Test
	public void testPut() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			//to log all statements, what new data is updated in database for given empID
			.log().all();
		
	
	}

}
