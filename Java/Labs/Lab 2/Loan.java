import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Main{
    private static DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args){
        System.out.print("Enter annual interest rate, for example, 8.25:");
        Scanner input = new Scanner(System.in); //Create a Scanner object
        double userAIR = input.nextDouble();
        System.out.print("\nEnter number of years as an integer:");
        int noOfYears = input.nextInt();
        System.out.print("\nEnter loan amount, for example, 120000. 95:");
        double loanAmt = input.nextDouble();

        Loan newLoan = new Loan();
        System.out.print("\nThe loan was created:");
        df.setRoundingMode(RoundingMode.UP);
        System.out.print("\nThe monthly payment is " + df.format(newLoan.getMonthlyPayment(userAIR, noOfYears, loanAmt)));
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.print("\nThe total payment is " + df.format(newLoan.getAnnualPayment(userAIR, noOfYears, loanAmt)));

    }
}

class Loan {
    double annualInterestRate;
    int numberOfYears;
    double loanAmount;

    public Loan(){}

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        annualInterestRate = this.annualInterestRate;
        numberOfYears = this.numberOfYears;
        loanAmount = this.loanAmount;
    }

    public double getMonthlyPayment(double a, int b, double c){
        this.annualInterestRate = a;
        this.numberOfYears = b;
        this.loanAmount = c;
        //to get monthly interest rate:
        double mRate = this.annualInterestRate / 100 / 12;
        //numerator at the top of the eqn
        double num1 = this.loanAmount * mRate;
        //denom of second layer fraction
        double num2 = 1+mRate;
        int exp = this.numberOfYears * 12;
        double total = Math.pow(num2, exp);
        double denom = 1 - (1/total);
        return num1/denom;
    }
    public double getAnnualPayment(double a, int b, double c){
        this.annualInterestRate = a;
        this.numberOfYears = b;
        this.loanAmount = c;
        double mPayment = getMonthlyPayment(this.annualInterestRate,this.numberOfYears,this.loanAmount);
        return mPayment * this.numberOfYears * 12;
    }

}
