package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BoneBuilderProductPage {
	WebDriver driver;
	JavascriptExecutor js;

	public BoneBuilderProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(className="ac-button")
	WebElement add_to_cart_button;


	public void clickAddToCartButton() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1104)");

		add_to_cart_button.click();
	}
}
