package com.sofkau.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MessagePostResult implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
       JsonPath jsonPath = SerenityRest.lastResponse().jsonPath();
        return jsonPath.getString("message");

    }

    public static MessagePostResult postResult() {
        return new MessagePostResult();
    }

}



