package ajurakudroot.daterbaser;

import ajurakudroot.javaython.CodeRunner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChakaLakaDB {

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("graal.js");

        JsonObject jsonObject = new Gson().fromJson(new JsonLoaderClass().getJsonAsString_FromThisDirectory(), JsonObject.class);

        runMethodAndPrintResult(engine, jsonObject.get("method_0").getAsString(), "main");
        runMethodAndPrintResult(engine, jsonObject.get("method_1").getAsString(), "fibonacci", "10");
    }

    private static void runMethodAndPrintResult(ScriptEngine engine, String function, String methodName, Object... params) {
        try {
            engine.eval(function);
            Invocable inv = (Invocable) engine;
            System.out.println(inv.invokeFunction(methodName, params).toString());
        } catch (ScriptException | NoSuchMethodException e) {
            // No time for exceptions, everything must work
        }
    }

}

class JsonLoaderClass {
    public String getJsonAsString_FromThisDirectory() {
        try {
            String path = "/src/main/java/ajurakudroot/daterbaser/ChakaLaka.json";
            Scanner myReader = new Scanner(new File(System.getProperty("user.dir") + path));
            StringBuilder data = new StringBuilder();
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine());
            }
            myReader.close();
            return data.toString();
        } catch (FileNotFoundException e) {
            // No time for exceptions, everything must work
            return "";
        }
    }
}
