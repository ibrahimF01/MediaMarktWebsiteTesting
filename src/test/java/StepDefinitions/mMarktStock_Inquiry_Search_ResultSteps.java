package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class mMarktStock_Inquiry_Search_ResultSteps {
    DialogContent dc=new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    @Given("Click on Personal Care products")
    public void clickOnPersonalCareProducts() {
        //dc.findAndClick("kisiselBakim");
        dc.findAndClick("anladim");
        wait.until(ExpectedConditions.visibilityOf(dc.kisiselBakim)).click();
    }

    @And("Click on Male Grooming products")
    public void clickOnMaleGroomingProducts() {
        //dc.findAndClick("erkekBakimUrunleri");
        wait.until(ExpectedConditions.visibilityOf(dc.erkekBakimUrunleri)).click();
    }

    @And("Sort products from most expensive to least expensive")
    public void sortProductsFromMostExpensiveToLeastExpensive() {
        wait.until(ExpectedConditions.visibilityOf(dc.enYuksekFiyat)).click();
    }

    @And("Choose the most expensive product")
    public void chooseTheMostExpensiveProduct() {
        //GWD.Bekle(5);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[@id='hidden-pdp-add-to-cart']"),1));
        wait.until(ExpectedConditions.visibilityOf(dc.enPahaliErkekBakimUrunu)).click();
    }


    String sSeriNo;
    @And("Get Item No \\(serial number)")
    public void getItemNoSerialNumber() {
        WebElement wSeriNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[itemprop='sku']")));
        System.out.println("<--------------->");
        System.out.println("Ürün no= "+wSeriNo.getText());
        System.out.println("<--------------->");
        sSeriNo=wSeriNo.getText();
    }

    @And("Click on Stock Inquiry Button")
    public void clickOnStockInquiryButton() {
        dc.findAndClick("stokSorgulamaBtn");
    }

    @And("Make a stock inquiry of the product")
    public void makeAStockInquiryOfTheProduct() {
        GWD.getDriver().get("https://ux.mediamarkt.com.tr/stock/stock/"+sSeriNo);

    }

    @And("Stock information")
    public void stockInformation() {

        WebElement urunIsim = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='container'] h3")));
        String urunisim=urunIsim.getText().substring(19);
        System.out.println("<---------------------------------------------------------------------------------------->");
        System.out.println("Şuan ürün nosu "+sSeriNo+" olan, adı: "+urunisim+" olan ürünün stok bilgilerini görmektesiniz.");
        System.out.println("<---------------------------------------------------------------------------------------->");
        List<WebElement> sizeListStokVar=GWD.getDriver().findElements(By.cssSelector("div[class='branch-stock in-stock has-stock']"));
        System.out.println(sizeListStokVar.size()+" farklı mağazada stoklarımız mevcut.");
        List<WebElement> sizeListSinirli=GWD.getDriver().findElements(By.cssSelector("div[class='branch-stock limited-stock has-stock']"));
        System.out.println(sizeListSinirli.size()+" farklı mağazada sınırlı stoklarımız var.");
        List<WebElement> sizeListTukenmekUzere=GWD.getDriver().findElements(By.cssSelector("div[class='branch-stock low-stock has-stock']"));
        System.out.println(sizeListTukenmekUzere.size()+" farklı mağazamızda ise maalesef tükenmek üzere.");
        List<WebElement> sizeListStokYok=GWD.getDriver().findElements(By.cssSelector("div[class='branch-stock out-of-stock']"));
        System.out.println(sizeListStokYok.size()+" mağazamızda ise stok bulunmadığı için ürünün satışını yapamamaktayız.");
        System.out.println("<---------------------------------------------------------------------------------------->");


    }
}
