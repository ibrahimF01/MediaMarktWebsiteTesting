package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class MediaMrktMostExpensiveTV {
    DialogContent dc=new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    @Given("Type Smart TV to the search box and click enter")
    public void typeSmartTVToTheSearchBoxAndClickEnter() {

        dc.findAndSend("searchInput","Smart TV");
        dc.findAndClick("searchButton");
    }

    @And("Click Most Expensive Price")
    public void clickMostExpensivePrice() {
        dc.findAndClick("mostExpensivePrice");
    }

    @And("Click the First Product on the List")
    public void clickTheFirstProductOnTheList() {
        dc.findAndClick("mostExpensiveTV");
    }

    @And("Close popup")
    public void closePopup() {
        dc.findAndClick("pupup");
    }

    @And("Click on Continue button")
    public void clickOnContinueButton() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='js-cart-app']/div[5]/div/div/a"))).click();
    }

    @And("Fill in the address form")
    public void fillInTheAddressForm() {
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


    }

    @And("Accept privacy policy and save the form")
    public void acceptPrivacyPolicyAndSaveTheForm() {
        WebElement element=GWD.driver.findElement(By.xpath("//*[@name='customerContract']"));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        dc.findAndClick("continueButton3");
    }
}
