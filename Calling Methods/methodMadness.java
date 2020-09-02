
/**
 * Demonstrate calling methods and debugging
 * 
 * @author Mr. Middler
 * @version 1
 */

public class methodMadness
{
    public static void main()
    {
        double radius = 4.0;
        double area = circleArea(radius);

        System.out.println("Area = " + area);

        
        double vol = cylinderVolume(radius, 20);
        
        System.out.println("Volume = " + vol);
        
    }
    
    // given the radius, calculate the area of a circle
    public static double circleArea(double radius)
    {
        double pi = 3.1416;
        double area = pi * Math.pow(radius, 2);
        return area;
    }
    
    // given the radius and height, calculate the volume of a cylinder
    public static double cylinderVolume(double radius, double height)
    {
        double area = circleArea(radius);
        double volume = area * height;
        
        return volume;
    }
}
