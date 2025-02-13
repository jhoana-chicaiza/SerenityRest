package tasks;

import interactions.PutPetition;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServicesPut implements Task {

    private String resource;
    private String body;

    public ConsumeServicesPut consumeServices(String resource) {
        this.resource = resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutPetition.resource(resource,body)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServicesPut makeConsumePut() {
        return instrumented(ConsumeServicesPut.class);
    }
}

