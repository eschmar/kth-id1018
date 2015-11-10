import java.util.Arrays;

/**
 * Created by eschmar on 10/11/15.
 */
public class Polyline {
    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    public Polyline() {
        this.vertices = new Point[];
    }

    public Polyline(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    @Override
    public String toString() {
        return "";
    }

    public Point[] getVertices() {
        return vertices;
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

    public double length() {
        return this.vertices.length;
    }

    public void addLast(Point vertex) {
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0;
        for (i = 0; i < this.vertices.length; i++) {
            h[i] = this.vertices[i];
        }

        h[i] = new Point(vertex);
        this.vertices = h;
    }

    public void addBefore(Point vertex, String vertexName) {
        // TODO
    }

    public void remove(String vertexName) {
        // TODO
    }
}
