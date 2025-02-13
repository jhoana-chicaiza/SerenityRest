package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Step;
import questions.CodeGetResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static tasks.ConsumeServicesGet.makeConsumeGet;
import static utils.Constants.BASE_URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GetStepDefinition extends SetUpServicesStepDefinition {
    private static final Logger logger = LoggerFactory.getLogger(GetStepDefinition.class);

    @Given("the user has access to the product API")
    @Step("Set up the stage and access the product API at {0}")
    public void theUserHasAccessToTheProductAPI() {
        logger.info("Setting up the stage with access to the product API at {}", BASE_URL);
        OnStage.setTheStage(new OnlineCast());
        setUpServices(BASE_URL);
    }

    @When("they send a GET request with the resource {string}")
    @Step("Send GET request to the resource: {0}")
    public void theySendAGETRequestWithTheResource(String resource) {
        logger.info("Sending GET request with resource: {}", resource);
        actor.attemptsTo(
                makeConsumeGet().consumeServices(resource)
        );
    }

    @Then("the response message should be the product list")
    @Step("Verify the response is successful and contains the product list")
    public void theResponseMessageShouldBeTheProductList() {
        logger.info("Verifying response for product list...");
        actor.should(
                seeThat("code result: ",
                        CodeGetResult.getResult(), equalTo(SC_OK)
                )
        );
    }
}
