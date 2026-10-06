package AmazonAutomationScript.AmazonAutomationScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseClass {
	
public WebDriver driver;	
	
	@BeforeClass
	public void Launch() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=815461296140&hvpos=&hvnetw=g&hvrand=2903458837558323720&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9303870&hvtargid=kwd-64107830&hydadcr=14452_2462829&mcid=e9c68a2d0f333bcaacd29ec00843c329&hvocijid=2903458837558323720--&hvexpln=nav&gad_source=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		
	}
	
	@Test
	public void login() throws InterruptedException {
		
		FindingElements fin = new FindingElements(driver);

		
		fin.Loginscreen();
		fin.Username("harsh95199@gmail.com");
		fin.Clickcontinuebtn();
		Thread.sleep(3000);
		fin.password("Harsh@9519");
		fin.Clicksignbtn();
		Thread.sleep(3000);
		fin.Searchelement("Boat Speakers");
		Thread.sleep(3000);
		fin.list("boat speakers bluetooth");
		Thread.sleep(2000);
		fin.selectproduct();
		Thread.sleep(5000);
		fin.selectwitchtowindow();;
		Thread.sleep(4000);
		fin.clickqtylink();
		Thread.sleep(4000);
		fin.setqty("1");
		Thread.sleep(5000);
		fin.clickcart();
		Thread.sleep(4000);
		fin.selectsecondwitchtowindow();
		Thread.sleep(4000);
		fin.Movecartpage();
		Thread.sleep(5000);
		fin.ProceedtoCheckout();
		Thread.sleep(2000);
		fin.goback();
		Thread.sleep(2000);
		fin.openaccountAndListmenu();
		Thread.sleep(2000);
		fin.signout("Sign Out");
	}

	@AfterClass
	public void termination() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.quit();
	}
	
	
	

}
