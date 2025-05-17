package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.googleSearchPage.GoogleSearchPageHelper;

public class searchStepDef {

    GoogleSearchPageHelper googleSearchPageHelper = new GoogleSearchPageHelper();

    @Given("User opens google search")
    public void user_opens_google_search() {
        googleSearchPageHelper.openGoogle();
    }
    @When("User search for Mercedes A Class")
    public void user_search_for_mercedes_a_class() throws InterruptedException {
        googleSearchPageHelper.typeIntoSearch();
    }

    @Then("Validate User can see engine specifications or mentions horsepower for the Mercedes A Class")
    public void validateUserCanSeeEngineSpecificationsOrMentionsHorsepowerForTheMercedesAClass() throws InterruptedException {
        googleSearchPageHelper.searchForSpecificKeyWords();
    }
}
