public abstract class Converter {

    protected int startingUnit;
    protected double startingAmount;
    protected double result;
    protected String symbol;

    public Converter(int startingUnit, double startingAmount) {
        this.startingUnit = startingUnit;
        this.startingAmount = startingAmount;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    abstract void conversion();

}
