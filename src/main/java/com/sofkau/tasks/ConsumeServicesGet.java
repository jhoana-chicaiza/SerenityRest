package com.sofkau.tasks;

import com.sofkau.interactions.GetPetition;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ConsumeServicesGet implements Task {

    public ConsumeServicesGet consumeServices(String resource) {
        this.resource = resource;
        return this;
    }
    private static final Logger logger = LoggerFactory.getLogger(ConsumeServicesGet.class);
    private String resource;

    @Override
    @Step("Consume a GET request to the resource {0} with JSON content type")
    public <T extends Actor> void performAs(T actor) {
        logger.info("Preparing to consume GET service for resource: {}", resource);
        actor.attemptsTo(
                GetPetition.resource(resource)
                        .with(
                                requestSpecification->requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )

        );
        logger.info("GET service request completed for resource: {}", resource);
    }
    public static ConsumeServicesGet makeConsumeGet () {
        return instrumented(ConsumeServicesGet.class);
    }
}
