package ro.ase.grupa1094;
enum ColorBird {WHITE, BLACK, RED, GREEN, MIXED, BLUE}
public class Bird {
    private String name;
    private float weight;
    private ColorBird color;

    public Bird(String name, float weight, ColorBird color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ColorBird getColor() {
        return color;
    }

    public void setColor(ColorBird color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", color=" + color +
                '}';
    }
}
