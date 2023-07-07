public class HeightConverter extends Converter {

    public HeightConverter(int startingUnit, double startingAmount) {
        super(startingUnit, startingAmount);
    }

    @Override
    public void conversion() {
        if (startingUnit == 1) {
            result = startingAmount * 34.8;
            symbol = "cm";
        } else if (startingUnit == 2) {
            result = startingAmount / 30.48;
            symbol = "ft";
        }
    }
}
