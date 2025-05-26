package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SwagLabsPOM {

    public WebDriver lDriver;

    public  SwagLabsPOM(WebDriver rDriver){
        lDriver = rDriver;
        PageFactory.initElements(rDriver ,this);
    }


    @FindBy(xpath = "//div[@class='login_logo']")
    WebElement logo;

    @FindBy(xpath = "//div[@id='login_credentials']")
    List<WebElement> Verify_Username_Password_field;

    @FindBy(xpath = "//div[@class='login_password']")
    WebElement Password_field;

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement Username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement Password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement LogInButton;

    @FindBy(xpath=("//button[@id='react-burger-menu-btn']"))
    WebElement BurgerMenu;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement ShopCart;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement ProductContainer;

    @FindBy(xpath ="//a[text()='Twitter']")
    WebElement Twitter;

    @FindBy(xpath = "//a[text()='Facebook']")
    WebElement Facebook;

    @FindBy(xpath = "//a[text()='LinkedIn']")
    WebElement LinkedIn;

    public void Verify_Logo(){
        boolean LOGO= logo.isDisplayed();
        Assert.assertTrue(LOGO);
    }

    public void Verify_Username_Password(){
        for(WebElement allcred: Verify_Username_Password_field){
            boolean Allcred = allcred.isDisplayed();
            Assert.assertTrue(Allcred);
        }
        boolean ps = Password_field.isDisplayed();
        Assert.assertTrue(ps);
    }

    public void UsernameEle(String user){
        Username.sendKeys(user);
    }

    public void PasswordEle(String pass){
        Password.sendKeys(pass);
    }
    public void LoginButtonEle(){
        LogInButton.click();
    }
    public void ClickOnAbout() throws InterruptedException {
        BurgerMenu.click();
        Actions act1 = new Actions(lDriver);

        act1.moveToElement(BurgerMenu).click().build().perform();
        lDriver.findElement(By.xpath("//div[@class='bm-menu-wrap']//a[2]")).click();
        Assert.assertEquals(lDriver.getTitle() , "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
        Thread.sleep(3000);
        lDriver.navigate().back();
    }
    public void Burger_Menu() {
        BurgerMenu.click();
        int bgMenuList = lDriver.findElements(By.xpath("//div[@class='bm-menu-wrap']//a")).size();

        for (int list = 1; list <= bgMenuList; list++) {
            WebElement Burger_menu = BurgerMenu;

            Actions act1 = new Actions(lDriver);

            act1.moveToElement(Burger_menu).click().build().perform();

            Assert.assertTrue(Burger_menu.isDisplayed());


            boolean Getlist = lDriver.findElement(By.xpath("//div[@class='bm-menu-wrap']//a[" + list + "]")).isDisplayed();
            Assert.assertTrue(Getlist);

        }
    }
    public void Verify_Shop_Cart_Icon(){
        boolean icon = ShopCart.isDisplayed();
        Assert.assertTrue(icon);
    }
    public void VerifyProductCartIcon(){
        boolean ProductC =ProductContainer.isDisplayed();
        Assert.assertTrue(ProductC);
    }
    public void price_low_to_high() throws InterruptedException {
        ProductContainer.click();
        Select drpdownlist = new Select(ProductContainer);
        drpdownlist.selectByVisibleText("Price (low to high)");
        Thread.sleep(5000);
    }

    public void verify_All_SocialMedia_logo_visible() throws InterruptedException {
        lDriver.findElement(By.xpath("//button[@id='react-burger-cross-btn']")).click();

        boolean twitter =Twitter.isDisplayed();
        Assert.assertTrue(twitter);

        boolean face =Facebook.isDisplayed();
        Assert.assertTrue(face);

        boolean Link =LinkedIn.isDisplayed();
        Assert.assertTrue(Link);
        Thread.sleep(5000);
    }
    public void VerifyTwitter() throws InterruptedException {
        Thread.sleep(3000);
        Twitter.click();
    }
    public void VerifyFacebook() throws InterruptedException {
        Thread.sleep(3000);
        Facebook.click();
    }
    public void VerifyLinkdIn() throws InterruptedException {
        Thread.sleep(5000);
        LinkedIn.click();
    }
    public void LogOut() throws InterruptedException {
        BurgerMenu.click();
        Actions act2 = new Actions(lDriver);

        act2.moveToElement(BurgerMenu).click().build().perform();
        lDriver.findElement(By.xpath("//div[@class='bm-menu-wrap']//a[3]")).click();
        Thread.sleep(2000);
    }

}
