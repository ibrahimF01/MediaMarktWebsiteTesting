package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddingSamsungSteps {
    DialogContent dc=new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    @And("Type Samsung the search box and click enter")
    public void AddingSamsungSteps() {
        dc.findAndSend("searchInput","Samsung akilli saat");
        dc.findAndClick("searchButton");
    }

    @And("Click on the random Saat samsung product")
    public void clickOnTheRandomSaatSamsungProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(" p[class='product-title'][title*='Saat']")));
        List<WebElement> productList=GWD.getDriver().findElements(By.cssSelector(" p[class='product-title'][title*='Saat']"));
        int rnd = (int) (Math.random() * productList.size());
        //wait.until(ExpectedConditions.elementToBeClickable(productList.get(rnd))).click();
        System.out.println(productList.size());
        productList.get(rnd).click();
    }
//    @And("click on tvs")
//    public void clickontvs(){
//        dc.findAndClick("TVsearch");
//    }

}
