package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetPetition extends RestInteraction {

    private String resource;

    public GetPetition(String resource) {
        this.resource = resource;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().get(as(actor).resolve(resource)).then().log().all();

    }
    public static GetPetition resource (String resource) {
        return instrumented(GetPetition.class,resource);
    }
}

