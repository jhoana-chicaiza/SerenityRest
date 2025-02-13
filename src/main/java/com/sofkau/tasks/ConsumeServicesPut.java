package com.sofkau.tasks;

import com.sofkau.interactions.PutPetition;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServicesPut implements Task {

    private static final Logger logger = LoggerFactory.getLogger(ConsumeServicesPut.class);
    private String resource;
    private String body;

    public ConsumeServicesPut consumeServices(String resource) {
        this.resource = resource;
        return this;
    }

    @Override
    @Step("Consume a PUT request to the resource {0} with JSON content type")
    public <T extends Actor> void performAs(T actor) {

        logger.info("Preparing to consume PUT service for resource: {}", resource);
        actor.attemptsTo(
                PutPetition.resource(resource,body)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
        logger.info("PUT service request completed for resource: {}", resource);
    }

    public static ConsumeServicesPut makeConsumePut() {
        return instrumented(ConsumeServicesPut.class);
    }
}

