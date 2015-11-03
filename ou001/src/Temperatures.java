import java.util.*;

/**
 * Created by eschmar on 03/11/15.
 */
public class Temperatures {
    public static void main (String[] args) {
        System.out.println("TEMPERATURES\n");

        // input tools
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // enter the number of weeks and measurements
        System.out.print("number of weeks: ");
        int nofWeeks = in.nextInt();

        System.out.print("number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();

        // storage space for temperature data
        double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];

        // read the temperatures
        for (int week = 1; week <= nofWeeks; week++) {
            System.out.println("temperatures - week " + week + ":");
            for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++) {
                t[week][reading] = in.nextDouble();
            }
        }

        System.out.println();

        // show the temperatures
        System.out.println("the temperatures:");
        for (int week = 1; week <= nofWeeks; week++) {
            for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++) {
                System.out.print(t[week][reading] + " ");
            }

            System.out.println();
        }

        System.out.println();

        // the least, greatest and average temperature - weekly
        double[] minT = new double[nofWeeks + 1];
        double[] maxT = new double[nofWeeks + 1];
        double[] sumT = new double[nofWeeks + 1];
        double[] avgT = new double[nofWeeks + 1];

        // compute and store the least, greatest and average
        // temperature for each week.
        // *** TODO

        // show the least, greatest and average temperature for
        // each week
        // *** TODO

        // the least, greatest and average temperature - whole period
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double avgTemp = 0;

        // compte and store the least, greatest and average
        // temperature for the whole period
        // *** TODO

        // show the least, greatest and average temperature for
        // the whole period
        // *** TODO


    }
}