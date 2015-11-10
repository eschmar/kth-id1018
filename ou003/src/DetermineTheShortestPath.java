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

        // read in all inputs
        System.out.print("Amount of stations in zone 2: ");
        int m = in.nextInt();
        System.out.print("Amount of stations in zone 3: ");
        int n = in.nextInt();

        System.out.println("\n");

        double[] a = new double[m];
        double[][] b = new double[m][n];
        double[] c = new double[n];

        System.out.println("Distances between zone 1 and 2:");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("Distance between X and U(%d): ", i+1);
            a[i] = in.nextDouble();
        }

        System.out.println("\nDistances between zone 2 and 3:");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.printf("Distance between U(%d) and V(%d): ", i+1, j+1);
                b[i][j] = in.nextDouble();
            }
        }

        System.out.println("\nDistances between zone 3 and 4:");
        for (int i = 0; i < c.length; i++) {
            System.out.printf("Distance between V(%d) and Y: ", i+1);
            c[i] = in.nextDouble();
        }

        // result
        int[] stations = TheShortestPath.intermediateStations(a, b, c);
        System.out.println("\nThe shortest path uses the stations:");
        System.out.printf("X --> U%d --> V%d --> Y", stations[0]+1, stations[1]+1);
        System.out.println("\nLength: " + TheShortestPath.length(a, b, c));
    }
}
