package ic.doc;

import java.util.Stack;

class ReversePolishCalculatorModel {

    private final Stack<Integer> values;

    public ReversePolishCalculatorModel() {
        this.values = new Stack<>();
    }

    public void pushValue(int value) {
        values.push(value);
    }

    private boolean validateStackSize(int size) {
        return values.size() >= size;
    }

    public void applyOperand(Operand op) {
        switch (op) {
            case PLUS:
                if (validateStackSize(2)) {
                    int valueToAdd = values.pop() + values.pop();
                    values.push(valueToAdd);
                }
                break;
            case MINUS:
                if (validateStackSize(2)) {
                    int value1 = values.pop();
                    int valueToPush = values.pop() - value1;
                    values.push(valueToPush);
                }
                break;
            case MULTIPLY:
                if (validateStackSize(2)) {
                    int valueToPush = values.pop() * values.pop();
                    values.push(valueToPush);
                }
                break;
            default:
                System.err.println("Invalid operand detected.");
        }
    }

    public Integer getTop() {
        if (!values.empty()) {
            return values.peek();
        }
        return 0;
    }

    public String getAllValues() {
        return values.toString().replaceAll("(^\\[|\\]$)", "");
    }

}
