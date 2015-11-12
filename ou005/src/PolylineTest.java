import java.io.PrintWriter;

/**
 * Created by eschmar on 11/11/15.
 */
public class PolylineTest {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        // init
        Point p1 = new Point("A", 3, 4);
        Point p2 = new Point("B", 5, 6);
        Point p3 = new Point("C", 1, 7);

        // constructors
        out.println("\nCONSTRUCTORS:");
        Polyline l1 = new Polyline();
        Polyline l2 = new Polyline(new Point[]{p1, p2, p3});

        out.println(l1);
        out.println(l2);

        // colour
        out.println("\nCOLOUR:");
        l1.setColour("purple");
        out.println(l1);

        // width
        out.println("\nWIDTH:");
        l2.setWidth(5);
        out.println(l2);

        // length
        out.println("\nLENGTH:");
        out.println(l2.length());

        // add/remove
        out.println("\nADD/REMOVE:");
        l2.addLast(new Point("X", 5, 6));
        l2.addBefore(new Point("Y", 1, 7), "B");
        out.println(l2);

        l2.remove("C");
        out.println(l2);

        // iterable
        out.println("\nITERABLE:");
        Polyline.PolylineIterator iterator = l2.new PolylineIterator();
        while (iterator.hasVertex()) {
            out.println(iterator.vertex());
            iterator.advance();
        }
    }
}
