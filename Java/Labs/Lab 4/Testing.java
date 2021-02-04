import java.util.ArrayList;

class Animal {
    String name;
    int age;
    String color;

    public Animal() {
        System.out.println("In animal constructor");
    }
    public Animal(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
        System.out.println("In animal constructor");
    }



    public void greetings(){

    }

    public void printInfo(){
        System.out.print(name + " is " + age + " years old and is of " + color + " color ");
    }
}

class Dog extends Animal{
    public Dog(){
        super("Milo", 2, "Brown");
        System.out.println("In dog constructor");


    }
    public void greetings(){
        System.out.print("Woof woof\n");
    }

    public void printInfo(){
        System.out.print("Dog " + name + " is " + age + " years old and is of " + color + " color ");
    }
}

class Cat extends Animal{
    public Cat(){
        super("Whiskey", 3, "Brown");
        System.out.println("In cat constructor");


    }

    public void greetings(){
        System.out.print("Meow\n");
    }

    public void printInfo(){
        System.out.print("Cat " + name + " is " + age + " years old and is of " + color + " color ");
    }
}
class Duck extends Animal{
    public Duck(){
        super("Do", 1, "White");
        System.out.println("In duck constructor");


    }

    public void greetings(){
        System.out.print("Quack\n");
    }

    public void printInfo(){
        System.out.print("Duck " + name + " is " + age + " years old and is of " + color + " color ");
    }
}
class Pig extends Animal{
    public Pig(){
        super("Po", 10, "Pink");
        System.out.println("In pig constructor");


    }

    public void greetings(){
        System.out.print("Oink\n");
    }
    public void printInfo(){
        System.out.print("Pig " + name + " is " + age + " years old and is of " + color + " color ");
    }
}

public class Testing{
    public static void main(String[] args){
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        animalArrayList.add(new Dog());
        animalArrayList.add(new Cat());
        animalArrayList.add(new Duck());
        animalArrayList.add(new Pig());
        for (Animal p : animalArrayList){
            p.printInfo();
            p.greetings();
        }
    }
}