package com.sofkau.stepdefinitions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.sofkau.utils.Constants.ACTOR;

public class SetUpServicesStepDefinition {
    protected static final Actor actor = new Actor(ACTOR);
    protected void setUpServices(String urlBase) {
        actor.can(CallAnApi.at(urlBase));
    }
}
