package CheckURLs;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class HTTPClient {
	
	private String failedURLS ="";
	private String succeededURLS ="";
	private String incorrectURLS = "";
	WebDriver Chdriver;
	WebElement url;
	
	@Test
	void checkURL()
	{	
	
	
	try {
		HTTPClient myClient = new HTTPClient();
	     myClient.validateUrl();
	      System.out.println("\n Valid URLS that have successfully connected :");
	      System.out.println(myClient.succeededURLS);
	      System.out.println("\n--------------\n\n"); 
	      System.out.println("Broken URLS that did not successfully connect :");
	      System.out.println(myClient.failedURLS);
	      
	    } catch (Exception e) {
	    	System.out.println("\n I am in the Catch block");
	        System.out.print(e.getMessage()); }
	      
	  }
	
	@AfterClass
	void closingTest()
	{
	
	}
	
	private boolean verifyUrl(String url) {
        String urlRegex = "^(http|https)://[-a-zA-Z0-9+&@#/%?=~_|,!:.;]*[-a-zA-Z0-9+@#/%=&_|]";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher m = pattern.matcher(url);
        if (m.matches()) {
            return true;
        } else {
            return false;
         }
	}
	 void validateUrl() throws Exception 
	 
	 {
		 System.setProperty("webdriver.chrome.driver", "/Users/e5110612/Downloads/chromedriver");
		 Chdriver = new ChromeDriver();
	//    Path filePath = Paths.get("src/url-list.txt");
	  //  List<String> myURLArrayList = Files.readAllLines(filePath);
	    Chdriver.get("http://www.google.com.au");
	    List<WebElement> LinkElements = Chdriver.findElements(By.tagName("a"));
	    System.out.println("The total urls on the page are: "+LinkElements.size());
	    int TotalSize=LinkElements.size();
	    int CountValidUrls = 0;
	    int CountInvalidUrls=0;
	    int CountT=0;
	    for(WebElement url : LinkElements)
	    	{
	    	CountT++;
	    	
	    	System.out.print((100/TotalSize)*CountT+"%");
	    	  System.out.print("\b \b \b");
              Thread.sleep(100);
	    	
	    		String SingleURL = url.getAttribute("href");
	    		
	    if (SingleURL!= null && verifyUrl(SingleURL)) 
	    			{ 
	    	CountValidUrls++;
	    				try
	    					{
	    						URL myURL= new URL(SingleURL);
	    						HttpURLConnection myConnection = (HttpURLConnection) myURL.openConnection();
	
	    						if (myConnection.getResponseCode() == URLStatus.HTTP_OK.getStatusCode()) 
	    							{
	    							// succeededURLS = succeededURLS + "\n" + SingleURL + "****** Status message is : "+ URLStatus.getStatusMessageForStatusCode(myConnection.getResponseCode());
	    							} 
	    						else 
	    							{
	    								failedURLS = failedURLS + "\n" + SingleURL + "****** Status message is : "+ URLStatus.getStatusMessageForStatusCode(myConnection.getResponseCode());
	    							}
	    					}
	    				catch (Exception e) 
	    					{
	    			           System.out.print("For url- " + SingleURL+ "" +e.getMessage());
	    			           Chdriver.quit();
	    					}
	
	    			}
	    else
	    {
	    	CountInvalidUrls++;
	    }
	    	}
	    System.out.println("\n Total valid URLs are: "+CountValidUrls);
	    System.out.print("\n Total Invalid URLS are: "+CountInvalidUrls);
		Chdriver.close();
	 }
}
