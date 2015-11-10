/**
 * Created by eschmar on 10/11/15.
 */
public class Point {
    private String name;
    private int x, y;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Standard constructor with all inputs.
     * @param name
     * @param x
     * @param y
     */
    public Point(String name, int x, int y) {
        setName(name);
        setX(x);
        setY(y);
    }

    /**
     * String parsing constructor. Syntax: "(NAME X Y)".
     * @param str
     */
    public Point(String str) {
        String[] parsed = str.substring(1,-1).split(" ");
        setName(parsed[0]);
        setX(Integer.parseInt(parsed[1]));
        setY(Integer.parseInt(parsed[2]));
    }

    /**
     * Cloning constructor.
     * @param p
     */
    public Point(Point p) {
        setName(p.getName());
        setX(p.getX());
        setY(p.getY());
    }

    @Override
    public String toString() {
        return "(" + name + " " + x + " " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (getX() != point.getX()) return false;
        if (getY() != point.getY()) return false;
        return getName().equals(point.getName());
    }

    /**
     * Calculates the distance between two points.
     * @param p
     * @return double
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.getX() - this.x, 2) + Math.pow(p.getY() - this.y, 2));
    }
}
