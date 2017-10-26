package yummly;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class yummlyUserAPITest {

	@Test
public void getPlaceAPI()
{
		// TODO Auto-generated method stub
	       
	     
		/*
		 * 
		 * Verify the Status code of the response
		 * Verify the Content type  as Json
		 * Verify the Body comtain test user
		 * Verify the  Header responses gas server info example is it a yummly server.
		 */
		
		//BaseURL or Host
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
		queryParam("email","“testuser@gmail.com").
		header("x-yummly-locale","en-US").
		 when().
		       get("mapi/v16/user/is-registered").
		       then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		       body("results[0].name",equalTo("testuser")).and().
		       header("Server","yummly");
	
	
}

}
