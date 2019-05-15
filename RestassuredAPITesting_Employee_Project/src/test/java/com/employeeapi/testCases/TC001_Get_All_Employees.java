/******************************************************
Test Name:Get all employees data
URI: http://dummy.restapiexample.com/api/v1/employees
Request Type: GET
Request Payload(Body): NA

********* Validations **********
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : text/html; charset=UTF-8
Server Type :  nginx/1.14.1
Content Encoding : gzip
Content Length <800
 *********************************************************/

package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC001_Get_All_Employees extends TestBase{

		
	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
	
	logger.info("*********Started TC001_Get_All_Employees **********");
		
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	httpRequest = RestAssured.given();
	response = httpRequest.request(Method.GET,"/employees");
	
	Thread.sleep(5);
	}
			
	@Test
	void checkResposeBody()
	{
		logger.info("***********  Checking Respose Body **********");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
		
	}
		
	@Test
	void checkStatusCode()
	{
		logger.info("***********  Checking Status Code **********");
		
		int statusCode = response.getStatusCode(); // Gettng status code
		logger.info("Status Code is ==>" + statusCode); //200
		Assert.assertEquals(statusCode, 200);
		
	}
		
	@Test
	void checkResponseTime()
	{
		logger.info("***********  Checking Response Time **********");
		
		long responseTime = response.getTime(); // Getting status Line
		logger.info("Response Time is ==>" + responseTime);
		
		if(responseTime>2000)
			logger.warn("Response Time is greater than 2000");
		
		Assert.assertTrue(responseTime<10000);
		
			
	}
	
	@Test
	void checkstatusLine()
	{
		logger.info("***********  Checking Status Line **********");
		
		String statusLine = response.getStatusLine(); // Getting status Line
		logger.info("Status Line is ==>" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	
		
	}
	
	
	@Test
	void checkContentType()
	{
		logger.info("***********  Checking Content Type **********");
		
		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test
	void checkserverType()
	{
		logger.info("***********  Checking Server Type **********");
		
		String serverType = response.header("Server");
		logger.info("Server Type is =>" +serverType); 
		Assert.assertEquals(serverType, "nginx/1.14.1");
	
	}

	@Test
	void checkcontentEncoding()
	{
		logger.info("***********  Checking Content Encoding**********");
		
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding is==>" +contentEncoding); 
		Assert.assertEquals(contentEncoding, "gzip");
		
		
	}

	@Test
	void checkContentLenght()
	{
		logger.info("***********  Checking Content Lenght**********");
		
		String contentLength = response.header("Content-Length");
		logger.info("Content Length is==>" +contentLength); 
		
		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content Length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
		
	}
		
	@Test
	void checkCookies()
	{
		logger.info("***********  Checking Cookies **********");

		String cookie = response.getCookie("PHPSESSID");
		//Assert.assertEquals(cookie,"1esuvsfslcmiee2bfrsgnijtg0");
		
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC001_Get_All_Employees **********");
	}
				 	
}
