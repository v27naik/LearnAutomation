package learnAuto;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTest 
{
  @Test
  public void GetAPI() 
  {
	  System.out.println("Test");
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.request(Method.GET, "/mumbai");
	  
	  String responseBody = response.getBody().asString();
	  System.out.println("Response Body is =>  " + responseBody);
	  
	  int statusCode = response.getStatusCode();
	  
	  // Assert that correct status code is returned.
	  Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	  
	  String statusLine = response.getStatusLine();
	  Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
	  
	// Header named Content-Type
	  String contentType = response.header("Content-Type");
	  System.out.println("Content-Type value: " + contentType);
	  Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
	  
	// Header named Server
	  String serverType =  response.header("Server");
	  System.out.println("Server value: " + serverType);
	  Assert.assertEquals(serverType /* actual value */, "nginx/1.12.1" /* expected value */);
	  
	  // Header named Content-Encoding
	  String acceptLanguage = response.header("Content-Encoding");
	  System.out.println("Content-Encoding: " + acceptLanguage);
	  Assert.assertEquals(acceptLanguage /* actual value */, "gzip" /* expected value */);
	  
	  
	// Get all the headers. Return value is of type Headers.
	  Headers allHeaders = response.headers();
	  
	  // Iterate over all the Headers
	  for(Header header : allHeaders)
	  {
	  System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
	  }
	  
	  
  }
  
  @Test
  public void postAPI() 
  {
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.request(Method.POST, "/Hyderabad");
  
  }

}
