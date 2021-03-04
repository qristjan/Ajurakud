package ajurakudroot.javaython;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WindowWidget extends JPanel {

    public WindowWidget(String engine, String defaultCode, CodeRunner actionListener) {
        createLayout(defaultCode, actionListener);

        JFrame frame = new JFrame(engine);
        frame.add(this);
        frame.setVisible(true);
        frame.setSize(1280 , 720);
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
        var code = new JTextArea();
        Font f = new Font("consolas", Font.PLAIN, 18);
        code.setFont(f);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        code.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        Dimension cod = new Dimension(800, 500);
        code.setMaximumSize(cod);
        code.setPreferredSize(cod);
        code.setMinimumSize(cod);
        code.setWrapStyleWord(true);
        code.setLineWrap(true);

        code.setText(defaultCode);
        add(code, gbc);
        //gbc.gridx++;
        gbc.gridy++;
        add(new JLabel("Result: "), gbc);
        gbc.gridy++;
        JTextArea result = new JTextArea();
        result.setFont(f);
        Dimension resultsize = new Dimension(800, 50);
        result.setMaximumSize(resultsize);
        result.setPreferredSize(resultsize);
        result.setMinimumSize(resultsize);


        result.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        result.setPreferredSize(new Dimension(400,400));
        add(result, gbc);
        gbc.gridy++;

        JButton actionButton = new JButton("Run (ALT + R)");
        actionButton.setMnemonic('R');
        actionButton.addActionListener(e -> {
            codeRunner.code = code.getText();
            codeRunner.result = result;
            codeRunner.actionPerformed(e);
        });
        add(actionButton, gbc);
    }
}
