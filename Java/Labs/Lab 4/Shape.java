import java.util.ArrayList;

class Solution{
    public static void main(String[] args){
        Rectangle r = new Rectangle(3.14, 9,5);
        Triangle t = new Triangle(3.14,10,8);
        Circle c = new Circle(3.14, 5, 5);
        Ellipse e = new Ellipse(3.14,7,7);
        Square s = new Square(3.14, 6,6);
        ArrayList<Shape> shapeArrayList = new ArrayList<>();
        shapeArrayList.add(r);
        shapeArrayList.add(t);
        shapeArrayList.add(c);
        shapeArrayList.add(e);
        shapeArrayList.add(s);
        for (Shape figref : shapeArrayList){
            System.out.println("Area is " + figref.getArea());
        }

    }
}
abstract class Shape{
    double dim1;
    double dim2;
    final double pi;
    Shape(double pi, double dim1, double dim2){

        this.pi = pi;
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract double getArea();


}
class Rectangle extends Shape{
    Rectangle(double pi, double dim1, double dim2) {
        super(pi, dim1, dim2);
    }

    @Override
    double getArea() {
        System.out.println("Inside Area for Rectangle.");
        return dim1 * dim2;
    }
}
class Triangle extends Shape{
    Triangle(double pi, double dim1, double dim2) {
        super(pi, dim1, dim2);
    }

    @Override
    double getArea() {
        System.out.println("Inside Area for Triangle.");
        return 0.5 * dim1 * dim2;
    }
}
class Circle extends Shape{
    Circle(double pi, double dim1, double dim2) {
        super(pi, dim1, dim2);
    }

    @Override
    double getArea() {
        System.out.println("Inside Area for Circle.");
        return pi * dim1 * dim1;
    }
}
class Ellipse extends Shape{
    Ellipse(double pi, double dim1, double dim2) {
        super(pi, dim1, dim2);
    }

    @Override
    double getArea() {
        System.out.println("Inside Area for Ellipse.");
        return pi * dim1 * dim2;
    }
}
class Square extends Shape{
    Square(double pi,double dim1, double dim2){
        super(pi,dim1,dim2);
    }

    @Override
    double getArea() {
        System.out.println("Inside Area for Square.");
        return dim1 * dim2;
    }
}

