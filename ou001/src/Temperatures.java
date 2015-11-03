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

        // the least, greatest and average temperature - whole period
        double minTemp = t[1][1];
        double maxTemp = t[1][1];

        // compute and store the least, greatest and average
        // temperature for each week.
        for (int week = 1; week <= nofWeeks; week++) {
            double min = t[week][1], max = t[week][1], sum = 0, avg;
            for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++) {
                double currentReading = t[week][reading];
                sum += currentReading;

                if (currentReading < min) {
                    min = currentReading;
                }

                if (currentReading > max) {
                    max = currentReading;
                }
            }

            minT[week] = min;
            maxT[week] = max;
            sumT[week] = sum;
            avgT[week] = sum / nofMeasurementsPerWeek;

            // compte and store the least and greatest
            // temperature for the whole period
            if (min < minTemp) { minTemp = min; }
            if (max > maxTemp) { maxTemp = max; }
        }

        // show the least, greatest and average temperature for
        // each week
        System.out.println("#, minT, maxT, avgT");
        for (int week = 1; week <= nofWeeks; week++) {
            System.out.println(week + ", " + minT[week] + ", " + maxT[week] + ", " + avgT[week]);
        }

        // compte and store the average temperature for the whole period
        double sumTemp = 0;
        double avgTemp = 0;
        for (double current : avgT) {
            sumTemp += current;
        }

        avgTemp = sumTemp / nofWeeks;

        // show the least, greatest and average temperature for
        // the whole period
        System.out.println("\nWhole period [least, greatest, average]:");
        System.out.println(minTemp + ", " + maxTemp + ", " + avgTemp);


    }
}