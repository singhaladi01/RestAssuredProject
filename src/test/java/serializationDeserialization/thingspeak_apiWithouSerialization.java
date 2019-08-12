package serializationDeserialization;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


//post and get request without using serialization and deserialization
//request and response in JSON format


/*
 * Request body:
 * {
 * 	"field1":100,
 * 	"field2":200
 * }
 * */


public class thingspeak_apiWithouSerialization {

	
	static HashMap map = new HashMap();
	
	@Test(priority=1)
	public void postDataToThingSpeak() {
		map.put("field1",100);
		map.put("field2",200);
		
//		RequestSpecification httprequest = RestAssured.given().contentType(ContentType.JSON).body(map);
//		Response response = httprequest.post("https://staging-api.thingspeak.com/update?api_key=10E4MY1FHQBHMNHR");
//		ResponseBody body = response.getBody();
//		
//		System.out.println(body.asString());
//		Assert.assertEquals(body.asString(), "213");
		
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("https://staging-api.thingspeak.com/update?api_key=10E4MY1FHQBHMNHR")
		.then()
			.contentType(ContentType.HTML)
			.statusCode(200)
			.log().all();
	}
	
	
	@Test(priority=2)
	public void getThingSpeakData() {
		given()
		.when()
			.get("https://staging-api.thingspeak.com/channels/450474/feeds.json?results=1")
		.then()
			.statusCode(200)
			.assertThat()
			.body("channel.last_entry_id",equalTo(213))
			.log().all();
	}
}
