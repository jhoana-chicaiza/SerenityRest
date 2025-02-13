package com.sofkau.tasks;

import com.sofkau.interactions.PostPetition;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServicesPost implements Task {

    private static final Logger logger = LoggerFactory.getLogger(ConsumeServicesPost.class);
    private String resource;
    private String body;

    public ConsumeServicesPost consumeServices(String resource) {
        this.resource = resource;

        return this;
    }

    @Override
    @Step("Consume a POST request to the resource {0} with JSON content type")
    public <T extends Actor> void performAs(T actor) {
        logger.info("Preparing to consume POST service for resource: {}", resource);
        actor.attemptsTo(
                PostPetition.resource(resource,body)
                        .with(
                                requestSpecification->requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
        logger.info("POST service request completed for resource: {}", resource);
    }

    public static ConsumeServicesPost makeConsumePost() {
        return instrumented(ConsumeServicesPost.class);
    }
}

