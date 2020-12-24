package ic.doc;

import java.awt.event.ActionListener;

public class GuiApp {

    private final Display display = new Display(new Controller());
    private final ReversePolishCalculatorModel calculatorModel = new ReversePolishCalculatorModel();

    class Controller {

        public ActionListener getNumberController(int number) {
            return e -> {
                calculatorModel.pushValue(number);
                updateDisplay();
            };
        }

        public ActionListener getOperandController(Operand operand) {
            return e -> {
                calculatorModel.applyOperand(operand);
                updateDisplay();
            };
        }

    }

    public void updateDisplay() {
        display.update(calculatorModel);
    }

    public static void main(String[] args) {
        new GuiApp();
    }
}

