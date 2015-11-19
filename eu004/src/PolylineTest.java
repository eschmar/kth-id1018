import java.io.PrintWriter;

/**
 * Created by eschmar on 19/11/15.
 */
public class PolylineTest {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        // init
        Point p1 = new Point("A", 3, 4);
        Point p2 = new Point("B", 5, 6);
        Point p3 = new Point("C", 1, 7);

        Point[] pointList = {p1, p2, p3};
        NPolyline nLine = new NPolyline(pointList);
        VPolyline vLine = new VPolyline(pointList);

        Point p4 = new Point("X", 4, 1);
        Point p5 = new Point("Y", 3, 2);
        Point p6 = new Point("Z", 1, 3);

        out.println("Init");
        out.println(nLine);
        out.println(vLine);

        // add point
        nLine.add(p4);
        vLine.add(p4);

        out.println("Point 'X' added");
        out.println(nLine);
        out.println(vLine);

        // insert before
        nLine.insertBefore(p5, "C");
        vLine.insertBefore(p5, "C");

        out.println("Point 'Y' inserted before 'C'");
        out.println(nLine);
        out.println(vLine);

        // remove
        nLine.remove("C");
        vLine.remove("C");

        out.println("Remove 'C'");
        out.println(nLine);
        out.println(vLine);

        // iterator
//        out.println("Iterator");
//        for (Point vertex : nLine) {
//            out.print(vertex);
//        }
//        out.println("\n");
//
//        for (Point vertex : vLine) {
//            out.print(vertex);
//        }
//        out.println("\n");
    }
}
