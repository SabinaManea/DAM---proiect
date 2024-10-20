package ro.ase.grupa1094;
enum ColorDog {BROWN, WHITE, BLACK, MIXED}
public class Dog {
    private String name;
    private float weight;
    private ColorDog color;

    public Dog(String name, float weight, ColorDog color) {
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

    public ColorDog getColor() {
        return color;
    }

    public void setColor(ColorDog color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", color=" + color +
                '}';
    }
}
