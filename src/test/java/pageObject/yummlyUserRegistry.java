package pageObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;


public class yummlyUserRegistry {

	Properties prop=new Properties();

	@BeforeTest

	public void getData() throws IOException

	{


	FileInputStream fis=new FileInputStream("C:\\Users\\mbarthelom\\workspace\\HQLink2\\env.properties");

	prop.load(fis);


	}


	@Test

	public void getUserinfo()

	{

    
			/*
			 * 
			 * Verify the Status code of the response
			 * Verify the Content type  as Json
			 * Verify the Body comtain test user
			 * Verify the  Header responses gas server info example is it a yummly server.
			 */
			
		

	RestAssured.baseURI= prop.getProperty("HOST");

	given().


			queryParam("email",prop.getProperty("email").

	        header("x-yummly-locale","en-US").

	         when().

	        get(resources.placegetData()).

	        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().

	         body("status",equalTo("OK")).and().
	         header("Server","yummly");




	}

	}