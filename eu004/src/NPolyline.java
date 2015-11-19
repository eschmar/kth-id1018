import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by eschmar on 18/11/15.
 */
public class NPolyline implements Polyline {
    private static class Node {
        public Point vertex;
        public Node nextNode;

        public Node(Point vertex) {
            this.vertex = vertex;
            nextNode = null;
        }
    }

    private Node vertices;
    private String colour = "black";
    private int width = 1; //pixels

    public NPolyline() {
        this.vertices = null;
    }

    public NPolyline(Point[] vertices) {
        if (vertices.length > 0) {
            Node node = new Node(new Point(vertices[0]));
            this.vertices = node;
            int pos = 1;
            while (pos < vertices.length) {
                node.nextNode = new Node(new Point(vertices[pos++]));
                node = node.nextNode;
            }
        }
    }

    @Override
    public String toString() {
        String output = "{[";
        Node current = vertices;
        while (current.nextNode != null) {
            output += current.vertex + ", ";
            current = current.nextNode;
        }

        return output + current.vertex + "], " + this.colour + ", " + this.width + "}";
    }

    @Override
    public Point[] getVertices() {
        //TODO
        return new Point[0];
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double length() {
        double sum = 0;
        Node current = vertices;
        while (current.nextNode != null) {
            sum += current.vertex.distance(current.nextNode.vertex);
            current = current.nextNode;
        }

        return sum;
    }

    @Override
    public void add(Point vertex) {
        Node current = vertices;
        while (current.nextNode != null) {
            current = current.nextNode;
        }

        Node node = new Node(new Point(vertex));
        current.nextNode = node;
    }

    @Override
    public void insertBefore(Point vertex, String vertexName) {
        Node current = vertices;
        while (current.nextNode != null && current.nextNode.vertex.getName() != vertexName) {
            current = current.nextNode;
        }

        Node temp = current.nextNode;
        current.nextNode = new Node(vertex);
        current.nextNode.nextNode = temp;
    }

    @Override
    public void remove(String vertexName) {
        Node current = vertices;
        while (current.nextNode != null && current.nextNode.vertex.getName() != vertexName) {
            current = current.nextNode;
        }

        current.nextNode = current.nextNode.nextNode;
    }

    @Override
    public Iterator<Point> iterator() {
    }
}
