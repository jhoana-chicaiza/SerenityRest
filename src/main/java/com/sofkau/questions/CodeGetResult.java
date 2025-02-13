package com.sofkau.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodeGetResult implements Question<Integer> {


    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();

    }

    public static CodeGetResult getResult() {
        return new CodeGetResult();
    }
}
