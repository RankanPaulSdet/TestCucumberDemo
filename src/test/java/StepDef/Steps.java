package StepDef;

import PageObjectModel.SwagLabsPOM;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class Steps {
    WebDriver driver;
    SwagLabsPOM POM;
    @Given("User launch the Edge browser")
    public void user_launch_the_edge_browser() {
        driver = new EdgeDriver();
        POM = new SwagLabsPOM(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @When("User opens URL {string}")
    public void user_opens_url(String URL) {
        driver.get(URL);
    }

    @Then("User verify the title")
    public void user_verify_the_title() {
        POM.Verify_Logo();
    }

    @Then("User verify the username and password fields")
    public void user_verify_the_username_and_password_fields() {
        POM.Verify_Username_Password();
    }

    @When("Provide login {string} and Password {string}")
    public void provideLoginAndPassword(String user, String pass) {
        POM.UsernameEle(user);
        POM.PasswordEle(pass);
        POM.LoginButtonEle();
    }

    @Then("User Verify the Landing page logo and URL")
    public void user_verify_the_landing_page_logo_and_url() {
        String LandigPageUrl= driver.getCurrentUrl();
        boolean pageURL = LandigPageUrl.contains("https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(pageURL);
    }

    @Then("User Verify the PRODUCTS title and peek image visible on the home page")
    public void user_verify_the_products_title_and_peek_image_visible_on_the_home_page() {
        Assert.assertEquals(driver.getTitle() , "Swag Labs");

        boolean ProductTitle= driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
        Assert.assertTrue(ProductTitle);
    }

    @Then("Click about in the burger menu and back")
    public void clickAboutInTheBurgerMenuAndBack() throws InterruptedException {
        POM.ClickOnAbout();
    }
    @Then("User Verify all the options Burger menu item")
    public void user_verify_all_the_options_burger_menu_item() {
        POM.Burger_Menu();
    }
    @Then("User Verify the shopping cart icon and product sort container visible on the top right of the page")
    public void user_verify_the_shopping_cart_icon_and_product_sort_container_visible_on_the_top_right_of_the_page() {
        POM.Verify_Shop_Cart_Icon();
    }

    @Then("Verify the Inventory Product item list is visible")
    public void verify_the_inventory_product_item_list_is_visible() {
        POM.VerifyProductCartIcon();
    }

    @When("Select the Product sort container as Price low to high")
    public void selectTheProductSortContainerAsPriceLowToHigh() throws InterruptedException {
        POM.price_low_to_high();
    }

    @Then("Verify the Twitter, Facebook, Linkedin logo visible")
    public void verify_the_twitter_facebook_linkedin_logo_visible() throws InterruptedException {
        POM.verify_All_SocialMedia_logo_visible();

    }
    @Then("Click on Twitter social link and verify user is navigated to Twitter page")
    public void click_on_twitter_social_link_and_verify_user_is_navigated_to_twitter_page() throws InterruptedException {
        POM.VerifyTwitter();
    }

    @Then("Click on Facebook social link and verify user is navigated to Facebook page")
    public void click_on_facebook_social_link_and_verify_user_is_navigated_to_facebook_page() throws InterruptedException {
        POM.VerifyFacebook();
    }

    @Then("Click on LinkedIn social link and verify user is navigated to LinkedIn page")
    public void click_on_linked_in_social_link_and_verify_user_is_navigated_to_linked_in_page() throws InterruptedException {

        POM.VerifyLinkdIn();
    }

    @Then("User logout from the application and verify the login page")
    public void user_logout_from_the_application_and_verify_the_login_page() throws InterruptedException {
        POM.LogOut();
    }

    @Then("Close the tab")
    public void close_the_tab() {
        driver.quit();
    }
}
