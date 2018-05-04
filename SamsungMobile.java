package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class SamsungMobile {

	public static void main(String[] args) throws InterruptedException {
		//Set property for StartApp
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		//Launch Chrome Driver
		ChromeDriver driver= new ChromeDriver();
		//Maximzie the window
		driver.manage().window().maximize();
		//Load the URL
		driver.get("https://www.amazon.in/");
		//Search samsung in the search box
		driver.findElementById("twotabsearchtextbox").sendKeys("samsung",Keys.ENTER);
		//Select the mobile
		driver.findElementByXPath("//h2[text()='Samsung On7 Pro (Gold)']").click();
		Thread.sleep(4000);
		//Add to cart
		Set<String> winhandles = driver.getWindowHandles();
		List<String> winlist=new ArrayList<String>();
		winlist.addAll(winhandles);
		driver.switchTo().window(winlist.get(1));
		driver.findElementById("add-to-cart-button").click();
		driver.findElementById("hlb-view-cart-announce").click();
		//Verify the content in the cart
		String verifyCart=driver.findElementByXPath(" //span[@class='a-size-medium sc-product-title a-text-bold']").getText();
		System.out.println(verifyCart);
		}

}
