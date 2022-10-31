package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class ListControl {

    DialogContent dc=new DialogContent();
    SoftAssert sft=new SoftAssert();
    Actions actions=new Actions(GWD.getDriver());
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    @And("List Control")
    public void listControl() {
        System.out.println(dc.list.size());
        actions.moveToElement(dc.categories).build().perform();
        for (int i = 0; i < 344; i++) {
//            GWD.Bekle(1);
            wait.until(ExpectedConditions.elementToBeClickable(dc.list.get(i)));
            actions.moveToElement(dc.list.get(i)).build().perform();
            sft.assertTrue(dc.compare1.getText().contains(dc.list.get(i).getText()));
            System.out.println(dc.list.get(i).getText());

        }
        System.out.println("The result is correct completely, All Clear!");




        
        
    }
}
