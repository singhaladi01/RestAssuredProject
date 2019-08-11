package restAssuredAPITests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 * given()
 * when() with()
 * then()
 */
public class Get_Request {
	
	@Test
	public void getWeatherDetails() {
		
		given()
		.when()
			.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("City",equalTo("Hyderabad"))
			.header("Contet-Type","application/json");
	}

}
