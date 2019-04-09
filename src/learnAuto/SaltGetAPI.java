package learnAuto;

import org.json.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.internal.support.FileReader;
import io.restassured.internal.util.IOUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class SaltGetAPI 
{
  @BeforeTest
  	public void BaseUrl()
  		{
	  		RestAssured.baseURI = "http://api.na.travelex.net.st.salt";
	  		
  		}
  @Test
	public void PostApi() 
		{
	  	String line="",str="";
	  	String link = "US_HD.xml";
	  	  		try
	  			{
	  			
					Reader fr = new java.io.FileReader(link);
					BufferedReader br =  new BufferedReader(fr);
					while ((line = br.readLine()) != null) 
						{   
							str+=line;  
						}
				    JSONObject jsondata = XML.toJSONObject(str);
				    System.out.println("Json data is : "+jsondata);
	  		
	  	  			RequestSpecification request = RestAssured.given().log().all();
	  	  			JSONObject requestParams = new JSONObject();
	  	  			System.out.println("Response : " + request);
	  	  			//requestParams.put(jsondata); 
	  	  			request.header("Content-Type", "application/json")
		            .body(jsondata.toString());
	  	  			Response response = request.post("/salt/order/eval?key=Travelex&site=%2Fus");
	  	  			
	  	  		 	            
		            /*.then()
		            .contentType(ContentType.JSON)
		            .extract().response();*/
	  	  	
	  	  			int statusCode = response.getStatusCode();
	  	  		System.out.println("Response : " + response.toString());
	  	  			Assert.assertEquals(statusCode, "200");
		  	  		//Assert.assertEquals (Request1.statusCode(), 200);
  			}
	  			
		  	  	catch (Exception e)
	      		{
	   	   			e.printStackTrace();
	      		}
	           
	}
  
  @Test
  	public void GetPaymentApi() throws InterruptedException 
  		{
	  		//RestAssured.baseURI = "http://api.na.travelex.net.st.salt";
	  		RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.given()
		    .param ("key","Travelex")
		    .when()
		    .get ("/salt/config/payment")
			  	.then()
			     .contentType(ContentType.JSON)
			     .extract().response();
			 Assert.assertEquals (response.statusCode (), 200);
   
           System.out.println("Response Body is =>  " + response.asString());
    
           String statusLine = response.getStatusLine();
           Assert.assertEquals(response.statusLine() , "HTTP/1.1 200 OK" );
           
           String contentType = response.header("Content-Type");
           System.out.println("Content-Type value: " + contentType);
           
           Headers allHeaders = response.headers();
           
           // Iterate over all the Headers
           for(Header header : allHeaders)
           	{
        	   System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
           	}
           
           ResponseBody body = response.getBody();
           System.out.println("Response Body is: " + body.asString());
           	try
           		{
           			JsonPath jsonPathEvaluator = response.jsonPath();
           			ArrayList<Object> cardtype = jsonPathEvaluator.get("cardOptions");
           			System.out.println("Card type from Response " + cardtype);
           		}
           catch (Exception e)
           		{
        	   		e.printStackTrace();
           		}
           
           }


}
