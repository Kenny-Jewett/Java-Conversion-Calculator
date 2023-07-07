public class WeightConverter extends Converter {

    public WeightConverter(int startingUnit, double startingAmount) {
        super(startingUnit, startingAmount);
    }

    @Override
    void conversion() {
        if(startingUnit == 1) {
            result = startingAmount * 0.45359237;
            symbol = "kg";
        } else if (startingUnit == 2) {
            result = startingAmount * 2.204623;
            symbol = "lbs";
        }
    }


}
