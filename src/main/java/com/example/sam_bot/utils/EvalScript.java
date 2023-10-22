package com.example.sam_bot.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvalScript {

    public static Object evaluateJavascript(String script) {
        // create a script engine manager
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            return engine.eval(script);
        } catch (final ScriptException se) {
            se.printStackTrace();
        }
        return null;
    }
}
