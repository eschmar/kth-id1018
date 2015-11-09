import java.lang.Math;

/**
 * Created by eschmar on 09/11/15.
 */
public class Triangle {

    /**
     * Calculates the area of the triangle.
     * @param a
     * @param b
     * @param c
     * @return double
     */
    public static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Calculates the perimeter of the triangle.
     * @param a
     * @param b
     * @param c
     * @return double
     */
    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    /**
     * Calculates the hypothenuse for a right triangle.
     * @param a
     * @param b
     * @return double
     */
    public static double hypothenuse(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /**
     * Calculates a single bisector.
     * @param b
     * @param c
     * @param alpha
     * @return double
     */
    public static double bisector(double b, double c, double alpha) {
        double p = 2 * b * c * Math.cos(alpha / 2);
        double bis = p / (b + c);
        return bis;
    }

    /**
     * Calculates all bisectors for a given triangle with all variables known.
     * @param a
     * @param b
     * @param c
     * @param alpha
     * @param beta
     * @param gamma
     * @return double[]
     */
    public static double[] bisectors(double a, double b, double c, double alpha, double beta, double gamma) {
        double sides[] = {a,b,c};
        double angles[] = {alpha, beta, gamma};
        double bis[] = new double[3];

        for (int i = 0; i < bis.length; i++) {
            bis[i] = bisector(sides[i], sides[i % sides.length], angles[i]);
        }

        return bis;
    }

    /**
     * Calculates the radius of the circumcircle.
     * @param a
     * @param b
     * @param c
     * @return double
     */
    public static double circumcircleRadius(double a, double b, double c) {
        return (a * b * c) / (4 * area(a, b, c));
    }

    /**
     * Calculates the radius of the incircle.
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static double incircleRadius(double a, double b, double c) {
        return (2 * area(a, b, c)) / perimeter(a, b ,c);
    }
}
