import java.util.Scanner;
public class Zodiac {
    public static void main (String[] args){
       Scanner CalculateResult = new Scanner(System.in);
       System.out.print("Enter a year: ");

       String result = CalculateResult.nextLine();
       int Zodiac = Integer.parseInt(result) % 12;

        switch (Zodiac) {
            case 0:
                System.out.println("\nmonkey");
                break;
            case 1:
                System.out.println("\nrooster");
                break;
            case 2:
                System.out.println("\ndog");
                break;
            case 3:
                System.out.println("\npig");
                break;
            case 4:
                System.out.println("\nrat");
                break;
            case 5:
                System.out.println("\nox");
                break;
            case 6:
                System.out.println("\ntiger");
                break;
            case 7:
                System.out.println("\nrabbit");
                break;
            case 8:
                System.out.println("\ndragon");
                break;
            case 9:
                System.out.println("\nsnake");
                break;
            case 10:
                System.out.println("\nhorse");
                break;
            case 11:
                System.out.println("\nsheep");
                break;
        }
    }
}
