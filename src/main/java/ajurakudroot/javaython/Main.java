package ajurakudroot.javaython;

import javax.script.ScriptEngineManager;

public class Main {

    public static void main(String[] args) {
        javascriptWindowWidget();
    }

    private static void javascriptWindowWidget() {
        ScriptEngineManager manager = new ScriptEngineManager();
        new WindowWidget("Javascript", "function jsFunction() {   \n   let a = 15;\n\n" +
                "   return eval(2+3+a) + \"s\";\n}", new CodeRunner("jsFunction", manager.getEngineByName("graal.js")));
    }

}
