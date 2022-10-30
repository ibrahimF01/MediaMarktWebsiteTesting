package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.And;

public class AddingSamsungSteps {
    DialogContent dc=new DialogContent();
    @And("Type Samsung the search box and click enter")
    public void AddingSamsungSteps() {
        dc.findAndSend("searchInput","Samsung Tv");
        dc.findAndClick("searchButton");
    }
//    @And("click on tvs")
//    public void clickontvs(){
//        dc.findAndClick("TVsearch");
//    }

}
