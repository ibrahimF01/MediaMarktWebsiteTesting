package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class mMarktAddProdSteps{
    DialogContent dc=new DialogContent();
    Actions actions=new Actions(GWD.getDriver());
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    @Given("Navigate to MediaMarkt")
    public void navigateToMediaMarkt() {
        GWD.getDriver().manage().deleteAllCookies();
        GWD.getDriver().get("https://www.mediamarkt.com.tr/");
        GWD.getDriver().manage().window().maximize();

    }

    @When("Verify that you are on the home page")
    public void verifyThatYouAreOnTheHomePage() throws AWTException {
        dc.findAndContainsText("verifyHomePage","Media Markt");
        Robot rbt=new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

    }

    @And("Type the product in the search box and click enter")
    public void typeTheProductInTheSearchBoxAndClickEnter() {
        dc.findAndSend("searchInput","jbl kulak içi kulaklık");
        actions.keyDown(Keys.ENTER);
        actions.keyUp(Keys.ENTER);
    }

    @And("Click on the random product")
    public void clickOnTheRandomProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='product-categories']/following-sibling::a/child::p[@class='product-title'][starts-with(@title,'Jbl')]")));
        dc.findAndClick("productSelection");

    }

    @And("Click add to cart")
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("pdp-add-to-cart"))).click();
    }

    @And("Click on the additional insurance")
    public void clickOnTheAdditionalInsurance() {
        dc.findAndClick("additionalInsurance");

    }

    @And("Add to cart and click continue")
    public void addToCartAndClickContinue() {
        dc.findAndClick("AddAndContinueButton");
    }

    @And("Click on the go to cart")
    public void clickOnTheGoToCart() {
        dc.findAndClick("AddAndContinueButton");
    }

    @And("Click on the continue")
    public void clickOnTheContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Devam']"))).click();
        // dc.findAndClick("continueButton");
    }

    @And("Click on the continue without registration")
    public void clickOnTheContinueWithoutRegistration() {
        int rndx=(int)(Math.random()*1000);
        String str="ref"+rndx+"@gmail.com";
        dc.findAndClick("withoutRegistrationButton");
        dc.findAndSend("withoutRegistrationEmailInput",str);
        dc.findAndClick("continueButton2");
    }

    @And("Fill in the address form and save")
    public void fillInTheAddressFormAndSave() {
        dc.findAndClick("radioButtonMale");
        dc.findAndSend("taxIdInput","11111111111");
        dc.findAndSend("firstNameInput","test firstname");
        dc.findAndSend("lastNameInput","test lastname");
        dc.findAndSend("streetInput","test techno");
        dc.findAndSend("addressAdditionInput","test park");

        Select city=new Select(dc.selectOptions1);
        city.selectByVisibleText("Ankara");
        GWD.Bekle(1);
        Select district=new Select(dc.selectOptions2);
        district.selectByVisibleText("Gölbaşı");
        GWD.Bekle(1);
        Select locality=new Select(dc.selectOptions3);
        locality.selectByVisibleText("Bağiçi Mh.");

        dc.findAndSend("mobileInput","+905000000000");

        Select day=new Select(dc.selectDay);
        day.selectByIndex(1);
        GWD.Bekle(1);
        Select month=new Select(dc.selectMonth);
        month.selectByIndex(5);
        GWD.Bekle(1);
        Select year=new Select(dc.selectYear);
        year.selectByIndex(17);

        WebElement element=GWD.driver.findElement(By.xpath("//*[@name='customerContract']"));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        dc.findAndClick("continueButton2");//kaydetme adımı
        //Not:Arka arkaya test edildiğinde sistem robot olarak algılayıp resimdeki yazıyı girmemizi istiyor. O kısmı manuel geçiniz.

    }

    @And("Click on the payment method")
    public void clickOnThePaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(dc.continueButton3));
        dc.findAndClick("continueButton3");
        dc.findAndClick("continueButton3");//again..
    }

    @And("Click on the remove product from cart")
    public void clickOnTheRemoveProductFromCart() {

        dc.findAndClick("removeProductButton");

    }

    @Then("Verify that there are no items in the cart")
    public void verifyThatThereAreNoItemsInTheCart() {
        wait.until(ExpectedConditions.visibilityOf(dc.verifyNoItems));
        Assert.assertTrue(dc.verifyNoItems.getText().toLowerCase().contains("ürün bulunmuyor"));
    }
}