package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReversePolishCalculatorModelTest {

    private final ReversePolishCalculatorModel calculatorModelTest
            = new ReversePolishCalculatorModel();

    @Test
    public void pushValueAddsElementToTopOfStack() {
        calculatorModelTest.pushValue(5);
        assertThat(calculatorModelTest.getTop(), is(5));
    }

    @Test
    public void applyOperandWithPlusCorrectlyAddsTopTwoElementsOfStack() {
        calculatorModelTest.pushValue(5);
        calculatorModelTest.pushValue(10);
        calculatorModelTest.applyOperand(Operand.PLUS);
        assertThat(calculatorModelTest.getTop(), is(15));
    }

    @Test
    public void applyOperandWithMinusCorrectlySubtractsTopTwoElementsOfStack() {
        calculatorModelTest.pushValue(20);
        calculatorModelTest.pushValue(8);
        calculatorModelTest.applyOperand(Operand.MINUS);
        assertThat(calculatorModelTest.getTop(), is(12));
    }

    @Test
    public void applyOperandWithMultiplyCorrectlySubtractsTopTwoElementsOfStack() {
        calculatorModelTest.pushValue(15);
        calculatorModelTest.pushValue(28);
        calculatorModelTest.applyOperand(Operand.MULTIPLY);
        assertThat(calculatorModelTest.getTop(), is(420));
    }


    @Test
    public void getAllValues() {
        calculatorModelTest.pushValue(1);
        calculatorModelTest.pushValue(2);
        calculatorModelTest.pushValue(3);
        calculatorModelTest.pushValue(4);
        assertThat(calculatorModelTest.getAllValues(), is("1, 2, 3, 4"));
    }
}