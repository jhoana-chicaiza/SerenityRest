package com.sofkau.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;


public class PostPetition extends RestInteraction {

    public PostPetition(String resource, String body) {
        this.resource = resource;
        this.body = body;
    }
    private static final Logger logger = LoggerFactory.getLogger(PostPetition.class);
    private final String resource;
    private final String body;

    @Override
    @Step("Send a POST request to the resource {resource}")
    public <T extends Actor> void performAs(T actor) {
        logger.info("Sending POST request to resource: {}", resource);
        rest().log().all().post(as(actor).resolve(resource)).then().log().all();
        logger.info("POST request to resource {} completed", resource);
    }

    public static PostPetition resource(String resource, String body) {
        return instrumented(PostPetition.class, resource, body);
    }
}
