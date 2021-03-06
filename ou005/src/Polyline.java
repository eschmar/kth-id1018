import java.util.Arrays;

/**
 * Created by eschmar on 10/11/15.
 */
public class Polyline {
    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    /**
     * Empty constructor.
     */
    public Polyline() {
        this.vertices = new Point[0];
    }

    /**
     * Initialise the polyline with vertices.
     * @param vertices
     */
    public Polyline(Point[] vertices) {
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
        return Arrays.copyOf(this.vertices, this.vertices.length);
//        Point[] h = new Point[this.vertices.length + 1];
//        int i = 0;
//        for (i = 0; i < this.vertices.length; i++) {
//            h[i] = this.vertices[i];
//        }
//
//        return h;
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
    public double distance() {
        double sum = 0;
        for (int i = 0; i < this.vertices.length-1; i++) {
            sum += this.vertices[i].distance(this.vertices[i+1]);
        }

        return sum;
    }

    /**
     * Returns the amount of vertices.
     * @return int
     */
    public int length() {
        return this.vertices.length;
    }

    /**
     * Append a new vertex.
     * @param vertex
     */
    public void addLast(Point vertex) {
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
    public void addBefore(Point vertex, String vertexName) {
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

    public class PolylineIterator {
        private int current = -1;

        public PolylineIterator() {
            if (Polyline.this.vertices.length > 0) {
                current = 0;
            }
        }

        public boolean hasVertex() {
            return current != -1;
        }

        public Point vertex() throws java.util.NoSuchElementException {
            if (!this.hasVertex()) {
                throw new java.util.NoSuchElementException("end of iteration");
            }

            Point vertex = Polyline.this.vertices[current];
            return vertex;
        }

        public void advance() {
            if (current >= 0 && current < Polyline.this.vertices.length - 1) {
                current++;
            }else {
                current = -1;
            }
        }
    }
}
