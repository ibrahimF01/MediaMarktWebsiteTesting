package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class mMarktMembershipSteps {
    DialogContent dc=new DialogContent();
    Parent parent=new Parent();


    @When("come to the top of the page")
    public void comeToTheTopOfThePage() {
        parent.scrollToElement(dc.cinsiyet);

    }
    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {
        List<String> listElement=elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            dc.findAndClick(listElement.get(i));

        }

    }


    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);

        for(int i=0;i<listElement.size();i++)
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));

    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {

        dc.findAndContainsText("hesapDogrulama","Hoşgeldiniz");
    }


}
