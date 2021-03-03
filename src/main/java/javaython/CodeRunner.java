package javaython;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodeRunner implements ActionListener {

    public String code;
    public JTextArea result;

    private final String functionName;
    private final ScriptEngine engine;

    public CodeRunner(String functionName, ScriptEngine engine) {
        this.functionName = functionName;
        this.engine = engine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            engine.eval(code);
            Invocable inv = (Invocable) engine;
            result.setText(inv.invokeFunction(functionName).toString());
        } catch (ScriptException | NoSuchMethodException scriptException) {
            scriptException.printStackTrace();
        }
    }
}
