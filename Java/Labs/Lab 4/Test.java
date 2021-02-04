import java.util.Scanner;

interface Pizza {
    void calculatePizzaCost();
}

abstract class PizzaTopping{
    int noOfToppings;

    abstract void assignToppings();

    void addToppings() {
        System.out.println("----+++++----");
    }

    void setNoOfToppings(int toppings){
        this.noOfToppings = toppings;
    }
}

class OrderPizza extends PizzaTopping implements Pizza {
    int noOfSlices;

    OrderPizza(){
        this.noOfToppings = 3;
        this.noOfSlices = 6;
    }

    OrderPizza(int slices, int toppings){
        this.noOfSlices = slices;
        this.noOfToppings = toppings;
    }

    public void placeOrder(){
        System.out.println("Placing Order");
        System.out.print("Putting ");
        assignToppings();
        System.out.println(" toppings");
        System.out.println("Processing Order");
        System.out.print("Cost of order:");
        calculatePizzaCost();
        System.out.println("\nBaking slices");
        for(int i = 0; i<noOfSlices; i++){
            int slice = i + 1;
            System.out.println("Adding topping on slice " + slice);
            addToppings();

        }
        System.out.println("Order Completed");
    }

    @Override
    public void calculatePizzaCost() {

        int cost = noOfToppings * noOfSlices;
        System.out.print(cost);
    }

    @Override
    void assignToppings() {
        System.out.print(noOfToppings);
    }
}

public class Test extends OrderPizza{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of slices");

        int slices = sc.nextInt();

        System.out.println("Enter number of toppings");

        int toppings = sc.nextInt();
        OrderPizza pp = new OrderPizza(slices,toppings);
        pp.placeOrder();
    }

}