import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Output {

    static int conversionType;
    static int startingUnit;
    static ArrayList<String> supportedConversionTypes = new ArrayList<>(List.of("Weight", "Temperature", "Height"));

    public static double getValueToBeConverted() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount you would like to convert: ");
        try {
            return scanner.nextDouble();
        }
        catch (InputMismatchException ex) {
            System.out.println("Please only enter numbers e.g. 12");
            scanner.nextLine();
            return scanner.nextDouble();
        }
    }

    public static Converter createConverter(int num) {

        return num == 1 ? new WeightConverter(startingUnit, getValueToBeConverted()) :
                num == 2 ? new TemperatureConverter(startingUnit, getValueToBeConverted()) :
                new HeightConverter(startingUnit, getValueToBeConverted());

    }

    public static void getConversionType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the type of conversion you would like to perform e.g. 1");
        // Iterate over arraylist to display conversion options
        for(int i = 0; i < supportedConversionTypes.size(); i++) {
            System.out.println(i + 1 + ". " + supportedConversionTypes.get(i));
        }

        try {
            conversionType = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Please only input numbers e.g. 1");
            scanner.nextLine();
            conversionType = scanner.nextInt();
        }

        Converter converter = createConverter(conversionType);

// Still need to refactor these if/else statements into a couple higher order methods.
        if(conversionType > 0 && conversionType <= supportedConversionTypes.size()) {
            if(conversionType == 1){
                System.out.println("Please select a number option");
                System.out.println("1. lbs to kg");
                System.out.println("2. kg to lbs");
                try {
                    startingUnit = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Please only input numbers e.g. 1");
                    scanner.nextLine();
                    startingUnit = scanner.nextInt();
                }
                if(startingUnit > 2){
                    System.out.println("Please only select from option 1 and 2!");
                    System.out.println("Restart program.......");
                    Output.getConversionType();
                }
                converter.conversion();
                System.out.println("The result is " + converter.getResult() + converter.getSymbol());
            } else if (conversionType == 2) {
                System.out.println("Please select a number option");
                System.out.println("1. Fahrenheit to Celsius");
                System.out.println("2. Celsius to Fahrenheit");

                try {
                    startingUnit = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Please only input numbers e.g. 1");
                    scanner.nextLine();
                    startingUnit = scanner.nextInt();
                }
                if(startingUnit > 2){
                    System.out.println("Please only select from option 1 and 2!");
                    System.out.println("Restart program.......");
                    Output.getConversionType();
                }
                converter.conversion();
                System.out.println("The result is " + converter.getResult() + converter.getSymbol());
            } else if (conversionType == 3) {
                System.out.println("Please select a number option");
                System.out.println("1. Feet to Centimeters");
                System.out.println("2. Centimeters to Feet");
                try {
                    startingUnit = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Please only input numbers e.g. 1");
                    scanner.nextLine();
                    startingUnit = scanner.nextInt();
                }
                if(startingUnit > 2){
                    System.out.println("Please only select from option 1 and 2!");
                    System.out.println("Restart program.......");
                    Output.getConversionType();
                }
                converter.conversion();
                System.out.println("The result is " + converter.getResult() + converter.getSymbol());
            }

        } else {
            System.out.println("Only input numbers between 1 and " + supportedConversionTypes.size());
            Output.getConversionType();
        }

        System.out.println("Would you like to carry out another conversion?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int ans;

        try {
             ans = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Please only input numbers e.g. 1");
            scanner.nextLine();
            ans = scanner.nextInt();
        }
        if(ans == 1) Output.getConversionType();
        else System.out.println("Thanks for using my program!");
    }

}
