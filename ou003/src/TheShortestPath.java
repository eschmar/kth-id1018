/**
 * Created by eschmar on 10/11/15.
 */
public class TheShortestPath {
    /**
     * The method intermediateStations returns a vector of the
     * intermediate stations that are on the shortest path.
     * The ordinal number of the first station is located in
     * index 1 of the vector, and the second station on index 2.
     * @param a
     * @param b
     * @param c
     * @return int[]
     */
    public static int[] intermediateStations(double[] a, double[][] b, double[] c) {
        int[] result = {0,0};

        // get the closest station in zone 2
        for (int i = 0; i < a.length; i++) {
            double temp;

            // get the closest station in zone 3
            for (int j = 0; j < b[result[0]].length; j++) {
                temp = a[i] + b[i][j] + c[j];
                if (temp < (a[result[0]] + b[result[0]][result[1]] + c[result[1]])) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    /**
     * The method length returns the length of the shortest path.
     * @param a
     * @param b
     * @param c
     * @return double
     */
    public static double length(double[] a, double[][] b, double[] c) {
        int[] s = intermediateStations(a, b, c);
        return a[s[0]] + b[s[0]][s[1]] + c[s[1]];
    }
}