class GeometricObject {
    String color;
    boolean filled;

    GeometricObject(){}

    GeometricObject(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public void setColor(String col){
        color = col;
    }

    public String getColor() {
        return this.color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public String toString(){
        return "created";
    }

}

class Circle extends GeometricObject{
    double radius;

    Circle(){};

    Circle(double radius){
        this.radius = radius;
    }

    Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * (this.radius * this.radius);
    }

    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public double getDiameter(){
        return this.radius*2;
    }
}

class Rectangle extends GeometricObject{
    double width;
    double height;

    Rectangle(){}
    Rectangle(double width, double height){
        this.height = height;
        this.width = width;
    }
    Rectangle(double width, double height, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return this.width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getArea(){
        return width*height;
    }

    public double getPerimeter(){
        return (width*2) + (height *2);
    }
}

public class TestCircleRectangle {
    public static void main(String[] args){
        Circle circle =
                new Circle(1);
        System.out.println("A circle " + circle.toString());
        circle.setColor("white");
        System.out.println("The color is " + circle.getColor());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The diameter is " + circle.getDiameter());

        Rectangle rectangle =
                new Rectangle(2, 4);
        System.out.println("A rectangle " + rectangle.toString());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " + rectangle.getPerimeter());

    }


}
