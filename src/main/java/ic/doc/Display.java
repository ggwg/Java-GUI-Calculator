package ic.doc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Display {

    private static final int MAX_BUTTON_NUMBER = 9;

    final JTextField textField = new JTextField(20);
    final JTextField stackField = new JTextField(20);
    final Font font = new Font("SansSerif", Font.BOLD, 20);

    public Display(GuiApp.Controller controller) {
        JFrame frame = new JFrame("Reverse Polish Calculator");
        frame.setSize(400, 300);

        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        stackField.setFont(font);
        textField.setPreferredSize(new Dimension(400, 50));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(textField, BorderLayout.PAGE_START);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));

        /* Initialize MAX_BUTTON_NUMBER buttons */
        for (int i = 1; i <= MAX_BUTTON_NUMBER; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(controller.getNumberController(i));
            buttonPanel.add(button);
        }

        /* Initialize all operand buttons */
        for (Operand operand : Operand.values()) {
            JButton button = new JButton(operand.getSymbol());
            button.addActionListener(controller.getOperandController(operand));
            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(stackField, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    public void update(ReversePolishCalculatorModel model) {
        String value = model.getTop().toString();
        textField.setText(value);
        stackField.setText(model.getAllValues());
    }
}
