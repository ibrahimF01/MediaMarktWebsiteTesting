package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Duration;

public class MediaMarketAddingOA {

    DialogContent dc=new DialogContent();
    Actions actions=new Actions(GWD.getDriver());
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));

    @And("Using the Action class, go to All categories, then to Computer and from within the computer to computer accessories.")
    public void usingTheActionClassGoToAllCategoriesThenToComputerAndFromWithinTheComputerToComputerAccessories() {

        dc.findAndClick("cookieOk");

        actions.moveToElement(dc.AllCategories).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Bilgisayar')])[1]")));
        actions.moveToElement(dc.Computer01).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Laptop Aksesuarları')])[1]")));
        actions.moveToElement(dc.laptopAccesiors).build().perform();
        dc.findAndClick("laptopAccesiors");


    }

    @And("Select DAYTONA brand from computer accessories and DAYTONA DYT'i secin")
    public void selectDAYTONABrandFromComputerAccessoriesAndDAYTONADYTISecin() {


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='facet-search'])[1]")));
        dc.findAndSend("brandSearch","daytona");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@value,'filterbrand=DAYTONA')]")));
        dc.findAndClick("daytona");

        GWD.Bekle(2);
        dc.DAYTONADYT803.click();


    }

    @And("Check the stock status of the product and exit after viewing")
    public void checkTheStockStatusOfTheProductAndExitAfterViewing() {

        GWD.Bekle(2);
        dc.findAndClick("stokStation");
        GWD.Bekle(1);
        GWD.getDriver().switchTo().frame(dc.frameStokMap);
        GWD.Bekle(1);
        dc.scrollToElement(dc.ozdilekAVM);

    }

    @And("Add the product to the cart and save the price of the product")
    public void addTheProductToTheCartAndSaveThePriceOfTheProduct() {

        GWD.Bekle(1);
        GWD.getDriver().switchTo().defaultContent();
        GWD.getDriver().manage().window().fullscreen();
        dc.findAndClick("closedStok");
        GWD.getDriver().manage().window().maximize();

        GWD.Bekle(1);
        dc.findAndClick("addToCartDayota");

        GWD.Bekle(2);
        System.out.println("dc.productPrice.getText() = " + dc.productPrice.getText());
        try{

            File dosya = new File("src/test/java/Resources/productInfo.txt");
            FileWriter yazici = new FileWriter(dosya,true);
            BufferedWriter yaz = new BufferedWriter(yazici);
            yaz.write("  Information  :  " + dc.productPrice.getText());
            yaz.close();
            System.out.println("Successfully");
        }
        catch (Exception hata){
            hata.printStackTrace();
        }
    }

    @And("Press the Continue button and proceed from the section -Continue without a member- on the page that opens.")
    public void pressTheContinueButtonAndProceedFromTheSectionOnThePageThatOpens() {

        dc.findAndClick("continueButton");
        dc.findAndClick("withoutRegistrationButton");
        dc.findAndSend("withoutRegistrationEmailInput","AliHaydarChopen@gmail.com");
        dc.findAndClick("continueButton2");
        dc.findAndClick("radioButtonMale");
        dc.findAndSend("taxIdInput","11111111111");
        dc.findAndSend("firstNameInput","AliHaydar");
        dc.findAndSend("lastNameInput","Chopengil");
        dc.findAndSend("streetInput","test techno");
        dc.findAndSend("addressAdditionInput","test park");
        GWD.Bekle(2);
        Select city=new Select(dc.selectOptions1);
        city.selectByVisibleText("Adana");
        GWD.Bekle(2);
        Select district=new Select(dc.selectOptions2);
        district.selectByVisibleText("Çukurova");
        GWD.Bekle(2);
        Select locality=new Select(dc.selectOptions3);
        locality.selectByVisibleText("Beyazevler Mh.");

        GWD.Bekle(2);
        dc.findAndSend("mobileInput","+905000000001");
        dc.scrollToElement(dc.littleCheck);
        dc.findAndClick("littleCheck");

        dc.scrollToElement(dc.continueButton2);
        dc.findAndClick("continueButton2");

        GWD.Bekle(1);


    }

}
