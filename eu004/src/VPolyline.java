import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by eschmar on 18/11/15.
 */
public class VPolyline implements Polyline {
    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    /**
     * Empty constructor.
     */
    public VPolyline() {
        this.vertices = new Point[0];
    }

    /**
     * Initialise the polyline with vertices.
     * @param vertices
     */
    public VPolyline(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(this.vertices) + ", " + this.colour + ", " + this.width + "}";
    }

    public Point[] getVertices() {
        return this.vertices;
    }

    public String getColour() {
        return colour;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Returns the length of the line.
     * @return double
     */
    public double length() {
        double sum = 0;
        for (int i = 0; i < this.vertices.length-1; i++) {
            sum += this.vertices[i].distance(this.vertices[i+1]);
        }

        return sum;
    }

    /**
     * Append a new vertex.
     * @param vertex
     */
    public void add(Point vertex) {
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0;
        for (i = 0; i < this.vertices.length; i++) {
            h[i] = this.vertices[i];
        }

        h[i] = new Point(vertex);
        this.vertices = h;
    }

    /**
     * Embed a new vertex in front of another named vertex.
     * @param vertex
     * @param vertexName
     */
    public void insertBefore(Point vertex, String vertexName) {
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0, j = 0;
        for (i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].getName().equals(vertexName)) {
                h[j] = vertex;
                j++;
            }

            h[j] = this.vertices[i];
            j++;
        }

        this.vertices = h;
    }

    /**
     * Removes a vertex by name.
     * @param vertexName
     */
    public void remove(String vertexName) {
        Point[] h = new Point[this.vertices.length - 1];
        int i = 0, j = 0;
        for (i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].getName().equals(vertexName)) {
                continue;
            }

            h[j] = this.vertices[i];
            j++;
        }

        this.vertices = h;
    }

    public Iterator<Point> iterator() {
    }
}