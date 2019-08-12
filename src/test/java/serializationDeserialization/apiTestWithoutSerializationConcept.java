package serializationDeserialization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.Test;


//post and get request without using serialization and deserialization
//request and response in JSON format


/*
 * Request body:
 * {
 * 	"id":101,
 * 	"firstName":"Aditi",
 * 	"lastname":"Singhal",
 * 	"email":"abc@gmc.com",
 * 	"programme":"Manager",
 * 	"courses": [
 * 				"Java",
 * 				"JavaScript"
 * 			   ]
 * }
 * */

public class apiTestWithoutSerializationConcept {

	public HashMap map = new HashMap();
	
	@Test(priority=1)
	//POST Request
	public void createNewStudent() {
		map.put("id",101);
		map.put("firstName", "Aditi");
		map.put("lastName", "Singhal");
		map.put("email", "abc@gmc.com");
		map.put("programme", "Manager");
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("JavaScript");
		
		map.put("courses", coursesList);
		

		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg",equalTo("Student added"));
	}
	
	@Test(priority=2)
	//GET Request
	public void getStudentRecord() {
		
		given()
		.when()
			.get("http://localhost:8085/student/101")
		.then()
			.statusCode(200)
			.assertThat()
			.body("id",equalTo(101))
			.log().all();
	}
	
}
