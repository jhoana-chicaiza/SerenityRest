package stepdefinitions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static utils.Constants.ACTOR;

public class SetUpServicesStepDefinition {
    protected static final Actor actor = new Actor(ACTOR);
    protected void setUpServices(String urlBase) {
        actor.can(CallAnApi.at(urlBase));
    }
}
