package ApiTest;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Auth {
 int id=10;	
	@Test
	public void getcall() {
		
		given()
		
		
		.when().get("https://reqres.in/api/users?page=2")
		
		
		.then().statusCode(200).log().all();
		
	}
	
	@Test
	public void postcall() {
		
		HashMap payload = new HashMap();
		payload.put("name", "vinit");
		payload.put("job", "Sr.QA");
		
		given().contentType("application/json").body(payload)
		
		
		.when().post("https://reqres.in/api/users")
		
		
		.then().statusCode(201).log().all();
		
		
	}
	
	@Test
	
	public void putcall() {
		
		HashMap payload = new HashMap();
		payload.put("name", "vinit");
		payload.put("job", "QA Lead");
		
		given().contentType("application/json").body(payload)
		.when().put("https://reqres.in/api/users/"+id)
		.then().statusCode(200).log().all();
	
	
	} 
	
	@Test
	
	public void deletecall() {
		
		
		given()
		.when().delete("https://reqres.in/api/users/" +id)
		.then().statusCode(204).log().all();
	}
	
	
	
	@Test
	public void basicauth() {
		
		given().auth().basic("postman", "password")
		
		.when().get("https://postman-echo.com/basic-auth")
		
		.then().statusCode(200).log().all();
	}

	@Test
	
	public void bearertoken() {
		
		String Token = "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";
		
		given().header("Authentication", "Bearer " +Token)
		
		
		.when().get("https://api.github.com/user/repos")
		
		
		.then().statusCode(200).log().all();
	}
	
}
