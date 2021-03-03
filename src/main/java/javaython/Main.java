package javaython;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {

    public static void main(String[] args) {
        javascriptWindowWidget();
    }

    private static void javascriptWindowWidget() {
        ScriptEngineManager manager = new ScriptEngineManager();
        new WindowWidget("Javascript", "function jsFunction() {\n\n\n}", new CodeRunner("jsFunction", manager.getEngineByName("javascript")));
    }

}
