import java.util.Locale;
import java.util.Scanner;

/**
 * Created by eschmar on 10/11/15.
 */
public class DetermineTheShortestPath {
    public static void main(String[] args) {
        System.out.println("THE SHORTEST PATH\n");

        // input tools
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // read the lengths of all sides
        System.out.print("Input a: ");
        double a = in.nextDouble();
    }
}
