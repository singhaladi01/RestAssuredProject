package restAssuredAPITests;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicValidations_XML {

	//verifying single content in XML Response
	
	@Test(priority=1)
	public void testSingleContent() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		//XML Path <CUSTOMER><ID>
			.body("CUSTOMER.ID",equalTo("15"))
			.log().all();
	}
	
	@Test(priority=2)
	public void testMultipleContents() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		//XML Path <CUSTOMER><ID>
			.body("CUSTOMER.ID",equalTo("15"))
			.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
			.body("CUSTOMER.LASTNAME",equalTo("Clancy"))
			.body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY",equalTo("Seattle"))
			.log().all();
	}
	
	@Test(priority=3)
	public void testMultipleContentsInOneGo() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"));
	}
	
	
	//FInd values using XML Path in XML Response
	@Test(priority=4)
	public void testUsingXPath1() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")))
			.log().all();
	}
	
	@Test(priority=5)
	public void testUsingXPath2() {
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
	}
}
