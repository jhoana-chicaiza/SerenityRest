package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.CodePostResult;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.hamcrest.Matchers.equalTo;
import  questions.MessagePostResult;
import static tasks.ConsumeServicesPost.makeConsumePost;
import static utils.Constants.BASE_URL;

public class PostStepDefinition extends SetUpServicesStepDefinition {
    @Given("the user has access to the products API")
    public void theUserHasAccessToTheProductsAPI() {
        OnStage.setTheStage(new OnlineCast());
        setUpServices(BASE_URL);
    }

    @When("the user sends a POST request to {string}")
    public void theUserSendsAPOSTRequestTo(String resource) {
        actor.attemptsTo(
                makeConsumePost().consumeServices(resource)
        );
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe() {
        actor.should(
                seeThat("code result: ",
                        CodePostResult.postResult(), equalTo(SC_METHOD_NOT_ALLOWED))
        );
    }


    @And("the response message for POST should be error message")
    public void theResponseMessageForPostShouldBeErrorMessage() {
        actor.should(
                seeThat("response message", MessagePostResult.postResult(), equalTo("This request method is not supported."))
        );

    }


}
