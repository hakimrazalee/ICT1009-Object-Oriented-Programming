import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BMI {
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args){
        Scanner CalculateBMI = new Scanner(System.in);
        System.out.print("Enter weight in pounds:");
        double pounds = CalculateBMI.nextDouble();
        double weight = pounds * 0.45359237;

        System.out.print("\nEnter height in inches:");
        double inches = CalculateBMI.nextDouble();
        double height = inches * 0.0254;

        df.setRoundingMode(RoundingMode.UP);
        double squared = height * height;
        double BMI = weight/squared;
        System.out.println("\nThe BMI is " + df.format(BMI));

        if (BMI < 18.5){
            System.out.print("Underweight");
        } else if (BMI < 25.0) {
            System.out.print("Normal");
        } else if (BMI < 30.0) {
            System.out.print("Overweight");
        } else if (BMI >= 30.0) {
            System.out.print("Obese");
        } else {
            System.out.print("Invalid BMI");
        }
    }
}
