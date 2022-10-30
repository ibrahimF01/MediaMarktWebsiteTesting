package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Media Markt']")
    private WebElement verifyHomePage;

    @FindBy(name = "query")
    private WebElement searchInput;

    @FindBy(xpath = "//p[@class='product-categories']/following-sibling::a/child::p[@class='product-title'][starts-with(@title,'Jbl')]")
    private List<WebElement> productSelection;

    @FindBy(name = "2")
    private WebElement additionalInsurance;

    @FindBy(id = "sepete-ekle-devam-et")
    private WebElement AddAndContinueButton;


    @FindBy(xpath = "//span[text()='Devam']")
    private WebElement continueButton;

    @FindBy(id = "without_member1")
    private WebElement withoutRegistrationButton;

    @FindBy(id = "userForm-email")
    private WebElement withoutRegistrationEmailInput;

    @FindBy(id = "nextButton")
    public WebElement continueButton2; //kaydet butonu ile aynı

    @FindBy(id = "radio-male")
    private WebElement radioButtonMale;

    @FindBy(name = "taxId")
    private WebElement taxIdInput;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(name = "street")
    private WebElement streetInput;

    @FindBy(name = "addressAddition")
    private WebElement addressAdditionInput;

    @FindBy(xpath = "(//select[@name='remoteOptions'])[1]")
    public WebElement selectOptions1;

    @FindBy(xpath = "(//select[@name='remoteOptions'])[2]")
    public WebElement selectOptions2;

    @FindBy(xpath = "(//select[@name='remoteOptions'])[3]")
    public WebElement selectOptions3;

    @FindBy(name = "mobile")
    private WebElement mobileInput;

    @FindBy(xpath = "(//select[@ng-model='vm.value'])[1]")
    public WebElement selectDay;

    @FindBy(xpath = "(//select[@ng-model='vm.value'])[2]")
    public WebElement selectMonth;

    @FindBy(xpath = "(//select[@ng-model='vm.value'])[3]")
    public WebElement selectYear;

    @FindBy(name = "customerContract")
    private WebElement contractCheckButton;

    @FindBy(name = "customerContract")
    private WebElement saveButton;

    @FindBy(css = "button[class$='cobutton-next']")
    public WebElement continueButton3;

    @FindBy(className = "cproduct-actions-remove")
    private WebElement removeProductButton;

    @FindBy(xpath = "//h3[text()='Sepetinizde ürün bulunmuyor']")
    public WebElement verifyNoItems;

    @FindBy(xpath = "//button[@data-identifier='searchButton']")
    public WebElement searchButton;

    @FindBy(xpath ="//div[@class='samsung-esis-container']//a [@href=\"https://www.mediamarkt.com.tr/tr/category/_samsung-tv-793009.html\"]")
    public WebElement TVsearch;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {

        switch (strElement) {

            case "searchInput":
                myElement = searchInput;
                break;

            case "withoutRegistrationEmailInput":
                myElement = withoutRegistrationEmailInput;
                break;

            case "taxIdInput":
                myElement = taxIdInput;
                break;

            case "firstNameInput":
                myElement = firstNameInput;
                break;

            case "lastNameInput":
                myElement = lastNameInput;
                break;

            case "streetInput":
                myElement = streetInput;
                break;

            case "addressAdditionInput":
                myElement = addressAdditionInput;
                break;
            case "mobileInput":
                myElement = mobileInput;
                break;


        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {
        int rnd = (int) (Math.random() * productSelection.size());

        switch (strElement) {

            case "productSelection":
                myElement = productSelection.get(rnd);
                break;

            case "additionalInsurance":
                myElement = additionalInsurance;
                break;

            case "AddAndContinueButton":
                myElement = AddAndContinueButton;
                break;


            case "continueButton":
                myElement = continueButton;
                break;


            case "withoutRegistrationButton":
                myElement = withoutRegistrationButton;
                break;


            case "continueButton2":
                myElement = continueButton2;
                break;


            case "radioButtonMale":
                myElement = radioButtonMale;
                break;

            case "contractCheckButton":
                myElement = contractCheckButton;
                break;

            case "continueButton3":
                myElement = continueButton3;
                break;

            case "removeProductButton":
                myElement = removeProductButton;
                break;

            case "searchButton":
                myElement = searchButton;
                break;

            case "TVsearch":
               myElement = TVsearch;
                break;


        }

        clickFunction(myElement);

    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {

            case "verifyHomePage":
                myElement = verifyHomePage;
                break;
            case "verifyNoItems":
                myElement = verifyNoItems;
                break;

        }

        verifyContainsText(myElement, text);
    }
    public void ScrollToElementClickFunction(String strElement){

//        switch (strElement) {
//
//            case "TVsearch":
//                myElement = TVsearch;
//                break;
//        }
//      clickFunction(myElement);
   }

}
