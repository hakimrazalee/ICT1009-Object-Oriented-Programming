public class CircleWithException {

    int radius;
    double pi = Math.PI;

    CircleWithException(){

    }

    CircleWithException(int radius) throws IllegalArgumentException, Exception{
        this.radius = radius;
        if(getCircleArea() > 1000){
            throw new Exception("area cannot be bigger than 1000");
        }

        if(radius < 0){
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        setCircleRadius(radius);

    }

    void setCircleRadius(int radius) throws Exception{
        this.radius = radius;
    }
    int getCircleRadius(){
        return this.radius;
    }
    double getCircleArea(){
        return pi * radius * radius;
    }
    int getCircleDiameter(){
        return radius*2;
    }

    public static void main(String[] args){

//        try {
//            CircleWithException c = new CircleWithException(5); // create a circle for radius 5
//        } catch (Exception e) {
//            System.out.println("Exception thrown " +e);
//        } finally {
//            System.out.println("this is from finally");
//        }
        try {
            CircleWithException d = new CircleWithException(1000); // create a circle for radius 1000
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("this is from finally");
        }
        try {
            CircleWithException e = new CircleWithException(-5); // create a circle for radius -5
        } catch (Exception e) {
          System.out.println(e);
        } finally {
            System.out.println("this is from finally");
        }
    }
}
