package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.CodeGetResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static tasks.ConsumeServicesGet.makeConsumeGet;
import static utils.Constants.BASE_URL;

public class GetStepDefinition extends SetUpServicesStepDefinition {
    @Given("the user has access to the product API")
    public void theUserHasAccessToTheProductAPI() {
        OnStage.setTheStage(new OnlineCast());
        setUpServices(BASE_URL);
    }

    @When("they send a GET request with the resource {string}")
    public void theySendAGETRequestWithTheResource(String resource) {
        actor.attemptsTo(
                makeConsumeGet().consumeServices(resource)
        );
    }

    @Then("the response message should be the product list")
    public void theResponseMessageShouldBeTheProductList() {
        actor.should(
                seeThat("code result: ",
                        CodeGetResult.getResult(), equalTo(SC_OK)
                )
        );

    }
}
