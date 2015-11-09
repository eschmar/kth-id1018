import java.util.Locale;
import java.util.Scanner;


/**
 * Created by eschmar on 09/11/15.
 */
public class TriangleAndItsCircles {
    public static void main(String[] args) {
        System.out.println("TRIANGLES\n");

        // input tools
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // read the lengths of all sides
        System.out.print("Lenght of side a: ");
        double a = in.nextDouble();
        System.out.print("Lenght of side b: ");
        double b = in.nextDouble();
        System.out.print("Lenght of side c: ");
        double c = in.nextDouble();

        Triangle t = new Triangle();
        //System.out.print("\nThe area of the triangle is " + t.area(a, b, c) + ".");
        System.out.print("\nThe radius of the circumcircle is " + t.circumcircleRadius(a, b, c) + ".");
        System.out.print("\nThe radius of the incircle is " + t.incircleRadius(a, b, c) + ".");

    }
}
