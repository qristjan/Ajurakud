package javaython;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WindowWidget extends JPanel {

    public WindowWidget(String engine, String defaultCode, CodeRunner actionListener) {
        createLayout(defaultCode, actionListener);

        JFrame frame = new JFrame(engine);
        frame.add(this);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createLayout(String defaultCode, CodeRunner codeRunner) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        add(new JLabel("Write code here: "), gbc);
        gbc.gridy++;
        JTextArea code = new JTextArea();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        code.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        code.setPreferredSize(new Dimension(200, 200));
        code.setText(defaultCode);
        add(code, gbc);
        gbc.gridx++;
        gbc.gridy--;
        add(new JLabel("Result: "), gbc);
        gbc.gridy++;
        JTextArea result = new JTextArea();
        result.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        result.setPreferredSize(new Dimension(200, 200));
        add(result, gbc);
        gbc.gridy++;

        JButton actionButton = new JButton("Run");
        actionButton.addActionListener(e -> {
            codeRunner.code = code.getText();
            codeRunner.result = result;
            codeRunner.actionPerformed(e);
        });
        add(actionButton, gbc);
    }
}
