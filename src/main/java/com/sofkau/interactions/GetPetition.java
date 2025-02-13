package com.sofkau.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetPetition extends RestInteraction {

    private static final Logger logger = LoggerFactory.getLogger(GetPetition.class);
    private String resource;

    public GetPetition(String resource) {
        this.resource = resource;
    }
    @Override
    @Step("Send a GET request to the resource {resource}")
    public <T extends Actor> void performAs(T actor) {
        logger.info("Sending GET request to resource: {}", resource);
        rest().log().all().get(as(actor).resolve(resource)).then().log().all();
        logger.info("GET request to resource {} completed", resource);
    }

    public static GetPetition resource (String resource) {
        return instrumented(GetPetition.class,resource);
    }
}

