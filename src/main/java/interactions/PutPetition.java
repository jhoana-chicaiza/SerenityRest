package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;


public class PutPetition extends RestInteraction {

    public PutPetition(String resource, String body) {
        this.resource = resource;
        this.body = body;
    }
    private final String resource;
    private final String body;

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().put(as(actor).resolve(resource)).then().log().all();
    }

    public static PutPetition resource(String resource, String body) {
        return instrumented(PutPetition.class, resource, body);
    }
}

