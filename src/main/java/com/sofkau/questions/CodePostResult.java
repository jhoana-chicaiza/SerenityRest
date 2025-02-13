package com.sofkau.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodePostResult implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
       JsonPath jsonPath = SerenityRest.lastResponse().jsonPath();
        return jsonPath.getInt("responseCode");

    }

    public static CodePostResult postResult() {
        return new CodePostResult();
    }

}



