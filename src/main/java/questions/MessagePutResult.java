package questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MessagePutResult implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        JsonPath jsonPath = SerenityRest.lastResponse().jsonPath();
        return jsonPath.getString("message");
    }

    public static MessagePutResult putResult() {
        return new MessagePutResult();
    }

}

