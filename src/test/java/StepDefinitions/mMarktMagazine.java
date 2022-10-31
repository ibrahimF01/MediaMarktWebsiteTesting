package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import io.cucumber.java.en.*;
import org.testng.Assert;
import java.util.Set;
import static Utilities.GWD.*;

public class mMarktMagazine extends Parent {

    DialogContent dc = new DialogContent();

    @And("Click the media trend")
    public void clickTheMediaTrend() {

        dc.findAndClick("mediaTrendImg");
    }


    @Then("Click the download media trend magazine and assert it")
    public void clickTheDownloadMediaTrendMagazineAndAssertIt() {

        String anaSayfaId = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String ChildWindow : allWindowHandles) {
            if (!anaSayfaId.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }

        dc.findAndClick("downloadMagazineImg");
        System.out.println("url : " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("mediatrend"));

    }
}
