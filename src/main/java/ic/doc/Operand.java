package ic.doc;

public enum Operand {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("x");

    private final String symbol;

    Operand(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}