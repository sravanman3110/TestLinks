package CaptureObjects.ObjectList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsBypage {
	
	void findelements(WebDriver driver)
	{
		  WebElement ab;
		  Map<WebElement, Object> vars = new HashMap<WebElement,Object>();
		  FindElementsBypage f = new FindElementsBypage();
		List<WebElement> elementName = driver.findElements(By.tagName("*"));
//		List<String> texts = links.stream().map(WebElement::getText).collect(Collectors.toList());
		System.out.println("The total number of elements are" + elementName.size());
		int count = 0;
		for ( WebElement e : elementName ) {
			
		if (e.getTagName().equals("input") && e.getAttribute("id").equals("edit-query"))
		{
			String newName = e.getAttribute("placeholder").replaceAll(" ", "_");
 
		
            System.out.println( "The TagName is "+e.getTagName()+"  Text inside the tag is  "+newName);
     //       a = "//"+e.getTagName();
      //     vars.put(toString() newName.getBytes()., driver.findElement(By.id(e.getAttribute("id"))));
        //  ab = driver.findElement(By.id(e.getAttribute("id")));
         // ab.sendKeys("This is a test Value");

            count++;
		}
           }

	}
	

}
