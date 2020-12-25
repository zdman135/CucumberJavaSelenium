package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {
	WebDriver driver;
	JavascriptExecutor js;


	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="shopping-cart")
	WebElement shopping_cart_title;

	@FindBy(css="td[data-title='total']")
	WebElement total_amount;

	@FindBy(className="exit-checkout")
	WebElement exit_checkout;

	@FindBy(id="confirmation-exit")
	WebElement confirm_exit;

	public void shoppingCartTitleText() {
		shopping_cart_title.getText();
	}
	
	@FindBy(css="button[coupon='confirmation']")
	WebElement coupon_button;

	public void totalAmount() {
		total_amount.getText();
	}

	public void exit_checkout() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");

		exit_checkout.click();
	}

	public void confirm_exit() {
		confirm_exit.isDisplayed();
	}
	
	public void acceptCoupon() {
		confirm_exit.click();
	}
}
