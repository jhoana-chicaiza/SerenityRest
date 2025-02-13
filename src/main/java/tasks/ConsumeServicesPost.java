package tasks;

import interactions.PostPetition;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServicesPost implements Task {

    private String resource;
    private String body;

    public ConsumeServicesPost consumeServices(String resource) {
        this.resource = resource;

        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                PostPetition.resource(resource,body)
                        .with(
                                requestSpecification->requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServicesPost makeConsumePost() {
        return instrumented(ConsumeServicesPost.class);
    }
}

