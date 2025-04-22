package Arrays;

public class Circle implements Comparable<Circle> {
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int r) {
        this.radius = r;
    }
    @Override
    public int compareTo(Circle o) {
        return this.radius - o.radius; 
    }

    @Override
    public String toString() {
        return "Circle [radius = " + radius + "]"; 
    }
}
