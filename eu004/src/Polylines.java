import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by eschmar on 19/11/15.
 */
public class Polylines {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        Random rand = new Random();

        // init

        Point[] points = {new Point("A", 3, 4), new Point("B", 5, 6), new Point("C", 1, 7), new Point("D", 4, 1), new Point("E", 3, 2), new Point("F", 1, 3), new Point("G", 8, 8), new Point("H", 9, 16), new Point("I", 11, 17), new Point("J", 14, 11), new Point("K", 13, 12), new Point("L", 11, 23)};

        Polyline[] lines = new Polyline[10];
        NPolyline[] nLines = new NPolyline[5];
        Point[] tempPoints = new Point[4];
        for (int i = 0; i < nLines.length; i++) {
            for (int j = 0; j < 4; j++) {
                tempPoints[j] = points[rand.nextInt(points.length)];
            }
            nLines[i] = new NPolyline(tempPoints);
            lines[i] = new NPolyline(tempPoints);
        }

        VPolyline[] vLines = new VPolyline[5];
        tempPoints = new Point[4];
        for (int i = 0; i < vLines.length; i++) {
            for (int j = 0; j < 4; j++) {
                tempPoints[j] = points[rand.nextInt(points.length)];
            }
            vLines[i] = new VPolyline(tempPoints);
            lines[5+i] = new NPolyline(tempPoints);
        }

        out.println("FIND SHORTEST POLYLINE:");
        out.println(findShortestPolyline(vLines));
        out.println(findShortestPolyline(nLines));
        out.println(findShortestPolyline(lines));

    }

    public static Polyline findShortestPolyline(Polyline[] lines) {
        Polyline current = null;
        for (Polyline temp : lines) {
            if (current == null || (temp.length() < current.length())) {
                current = temp;
            }
        }

        return current;
    }
}
