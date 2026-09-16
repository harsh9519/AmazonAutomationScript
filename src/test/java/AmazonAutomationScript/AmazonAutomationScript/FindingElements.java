package AmazonAutomationScript.AmazonAutomationScript;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FindingElements {
	
	WebDriver driver;
	
	FindingElements(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
		//Login flow 
	@FindBy (xpath = "//div[@class='nav-line-1-container']") WebElement Loginpage;
	@FindBy (xpath = "//input[@name='email']") WebElement Enterusername;
	@FindBy (xpath = "//input[@type='submit']") WebElement Continuebtn;
	@FindBy (xpath = "//input[@name='password']") WebElement Enterpwd;
	@FindBy (xpath = "//input[@id='signInSubmit']") WebElement Signingbtn;
	
		//product searching flow
	@FindBy (xpath = "//input[@role='searchbox']") WebElement Searchbox;
	@FindBy (xpath = "//div[@class='left-pane-results-container']//div") List<WebElement> Autosuggested;
	
		//Move product to cart flow
	//@FindBy (xpath = "//span[contains(text(),'boAt Stone 352/358 Bluetooth Speaker with 10W RMS ')]") WebElement Selectedproduct;
	@FindBy (xpath = "//span[@id='a-autoid-6']//input[@name='submit.addToCart']") WebElement Selectedproductcart;
	
		//Go to cart page flow
	@FindBy (xpath = "//span[@id='nav-cart-count']") WebElement cartpage;
		//Processed to buy
	@FindBy (xpath = "//input[@name='proceedToRetailCheckout']") WebElement processedtobuy;
	
	@FindBy (xpath = "//body/div[@id='a-page']/div[@class='a-section a-spacing-none']/div[@class='a-container checkout-experience-page-content']/div[@id='checkout-experience-container']/div[@id='checkout-experience-left-column']/div[@id='checkout-experience-left-column-deck']/div[@id='checkout-payment-option-panel']/div[@id='checkout-paymentOptionPanel']/div[@class='a-row']/div[@class='a-column a-span12 a-spacing-base']/div[@id='pagelet-layout-section']/div[@class='a-section a-spacing-none pmts-widget-section pmts-portal-root-6SLZMVRe5BPJ pmts-portal-component pmts-portal-components-pp-U6VFIx-1 pmts-class-40e072b0']/form[@id='pp-U6VFIx-107']/div[@class='a-box-group']/div[@class='a-box']/div[@class='a-box-inner']/div[@class='a-section pmts-portal-component pmts-portal-components-pp-U6VFIx-18 pmts-class-d337e153']/div[@id='pp-U6VFIx-147']/div[@class='a-box pmts-instrument-box']/div[@class='a-box-inner a-padding-small']/div[@class='a-fixed-left-grid']/div[@class='a-fixed-left-grid-inner']/div[@class='a-fixed-left-grid-col a-col-right']/div[1]/div[1]") WebElement COD;
	
	
	
	
	public void Loginscreen() {
		
		Loginpage.click();
	}
	
	public void Username(String name) {
		
		Enterusername.sendKeys(name);
	}
	
	public void Clickcontinuebtn() {
		
		Continuebtn.click();
	}
	
	public void password(String pwd) {
		
		Enterpwd.sendKeys(pwd);
	}
	
	public void Clicksignbtn() {
		
		Signingbtn.click();
		
	}

	public void Searchelement(String Entertext) {
		
		Searchbox.sendKeys(Entertext);
			
	}	
	
	public void list(String matchingtext) {
		
	    for (int attempt = 1; attempt <= 5; attempt++) {

	        try {
		Autosuggested.size();
	
		for(WebElement suggest: Autosuggested) {
			
			System.out.println(suggest.getText());
		
			
			if(suggest.getText().equalsIgnoreCase(matchingtext)) {
			suggest.click();
			return;
			
			}}}catch (StaleElementReferenceException e) {

		            System.out.println(
		                    "Stale element found. Retrying attempt: "
		                    + attempt);
		}
        }		
		}				
		/*public void selectproduct(){

		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.elementToBeClickable(Selectedproduct));
		Selectedproduct.click();}}*/		
	
	public void MoveProducttocartt() {
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(4000));
		WebElement Productmovetocart = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(Selectedproductcart)));
		Productmovetocart.click();	
	}
	
	public void Movecartpage() {
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(4000));
		WebElement cartbtn = wait.until(ExpectedConditions.elementToBeClickable(cartpage));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",cartbtn);

		
	}
	
	public void ProceedtoCheckout() {
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(4000));
		WebElement Proceed = wait.until(ExpectedConditions.elementToBeClickable(processedtobuy));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Proceed);
		
		
	}
	
}
	
	

	
		
	
	



	
		
	
	


