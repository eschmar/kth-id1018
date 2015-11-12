import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by eschmar on 12/11/15.
 */
public class SelectPolyline {
    public static final Random rand = new Random();
    public static final int NOF_POLYLINES = 10;

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        // create a random number of polylines
        Polyline[] polylines = new Polyline[NOF_POLYLINES];
        for (int i = 0; i < NOF_POLYLINES; i++) {
            polylines[i] = randomPolyline();
        }

        // show the polylines
        for (int i = 0; i < NOF_POLYLINES; i++) {
            out.println("Polyline " + (i+1) + ":");
            out.println(polylines[i] + "\n");
        }

        // determine the shortest yellow polyline
        Polyline shortestPolyline = null;
        for (Polyline pl : polylines) {
            if (pl.getColour() == "yellow" && (shortestPolyline == null || shortestPolyline.length() < pl.length())) {
                shortestPolyline = pl;
            }
        }

        // show the selected polyline
        if (shortestPolyline != null) {
            out.println("The shortest yellow line with length " + shortestPolyline.length() + " is:");
            out.println(shortestPolyline);
        }else {
            out.println("Could not find a yellow line.");
        }
    }

    /**
     * The randomPoint method returns a new Point with a name
     * randomly chosen from the single letters A--Z. Coordinates
     * are random.
     * @return Point
     */
    public static Point randomPoint() {
        String n = "" + (char) (65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);

        return new Point(n, x, y);
    }

    /**
     * The method randomPolyline returns a random polyline,
     * with a colour either blue, red, or yellow. The names
     * of the vertices are single letters from the set A--Z.
     * Two vertices can not have the same name.
     * @return Polyline
     */
    public static Polyline randomPolyline() {
        // create an empty polyline and add vertices
        Polyline polyline = new Polyline();
        int nofVertices = 2 + rand.nextInt(7);
        int nofSelectedVertices = 0;
        boolean[] selectedNames = new boolean[26];

        // two vertices can not have the same name
        Point chosenPoint = null;
        char chosenChar = 0;
        while (nofSelectedVertices < nofVertices) {
            Point temp = randomPoint();
            int intName = temp.getName().charAt(0) - 'A';

            if (!selectedNames[intName]) {
                selectedNames[intName] = true;
                polyline.addLast(temp);
                nofSelectedVertices++;
            }
        }

        // assign a colour.
        String[] colours = {"blue", "red", "yellow"};
        polyline.setColour(colours[rand.nextInt(3)]);

        return polyline;
    }
}
