package tasks;

import interactions.GetPetition;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ConsumeServicesGet implements Task {

    public ConsumeServicesGet consumeServices(String resource) {
        this.resource = resource;
        return this;
    }

    private String resource;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetPetition.resource(resource)
                        .with(
                                requestSpecification->requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )

        );

    }
    public static ConsumeServicesGet makeConsumeGet () {
        return instrumented(ConsumeServicesGet.class);
    }
}
