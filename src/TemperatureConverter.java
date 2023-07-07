public class TemperatureConverter extends Converter{

    public TemperatureConverter(int startingUnit, double startingAmount) {
        super(startingUnit, startingAmount);
    }


    @Override
    public void conversion() {
        if(startingUnit == 1) {
            result = (startingAmount - 32) * 5/9;
            symbol = "°C";
        } else if (startingUnit == 2) {
            result = (startingAmount * 9/5) + 32;
            symbol = "°F";
        }

    }
}
