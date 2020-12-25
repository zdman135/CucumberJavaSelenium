package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.BoneBuilderProductPage;
import pages.CheckoutPage;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class PurchasingBundlesSteps {
	WebDriver driver = null;
	BoneBuilderProductPage boneBuilderProductPage;
	CheckoutPage checkoutPage;

	String baseUrl = "https://www.algaecal.com/";

	@Before
	public void browserSetup() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver");	

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver(options);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	@Given("I am on the pricing bundle page")
	public void i_am_on_the_pricing_bundle_page() {
		driver.navigate().to(baseUrl + "product/bone-builder-packs/");
	}

	@When("I add a bundle to the cart")
	public void i_add_a_bundle_to_the_cart() {
		boneBuilderProductPage.clickAddToCartButton();
	}

	@Then("I should see the product bundle added to the cart")
	public void i_should_see_the_product_bundle_added_to_the_cart() {
		assertThat(checkoutPage.totalAmount(), equalsTo("599.32"));
	}

	@And("I am on the checkout page")
	public void i_am_on_the_checkout_page() {
		assertThat(checkoutPage.shoppingCartTitleText(), equalsTo("Your Shopping Cart"));
	}


	@Given("I have items in my shopping cart")
	public void i_have_items_in_my_shopping_cart() {
		driver.navigate().to(baseUrl + "product/bone-builder-packs/");
		boneBuilderProductPage.clickAddToCartButton();		
	}

	@When("I exit the checkout page")
	public void i_exit_the_checkout_page() {
		checkoutPage.exit_checkout();
	}

	@Then("I will see I confirmation to exit the checkout page")
	public void i_will_see_i_confirmation_to_exit_the_checkout_page() {
		assertThat(checkoutPage.confirm_exit(), equalsTo(true));
	}

	@When("I accept the coupon presented")
	public void i_accept_the_coupon_presented() {
		checkoutPage.acceptCoupon();
	}

	@Then("I will see the prices updated in the cart")
	public void i_will_see_the_prices_updated_in_the_cart() {
		assertThat(checkoutPage.totalAmount(), equalsTo("$349.23"));
	}	
}
