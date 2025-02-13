package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.CodePutResult;
import questions.MessagePutResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.hamcrest.Matchers.equalTo;
import static tasks.ConsumeServicesPut.makeConsumePut;
import static utils.Constants.BASE_URL;

public class PutStepDefinition extends SetUpServicesStepDefinition {
    @Given("the user has access to the brands API")
    public void theUserHasAccessToTheBrandsAPI() {
        OnStage.setTheStage(new OnlineCast());
        setUpServices(BASE_URL);
    }

    @When("the user sends a PUT request to {string}")
    public void theUserSendsAPUTRequestTo(String resource) {
        actor.attemptsTo(
                makeConsumePut().consumeServices(resource)
        );
    }

    @Then("the response status code should {int}")
    public void theResponseStatusCodeShould() {
        actor.should(
                seeThat("code result: ",
                        CodePutResult.putResult(), equalTo(SC_METHOD_NOT_ALLOWED))
        );
    }

    @And("the response message for PUT should be error message")
    public void theResponseMessageForPutShouldBeErrorMessage() {
        actor.should(
                seeThat("response message", MessagePutResult.putResult(), equalTo("This request method is not supported."))
        );
    }
}
