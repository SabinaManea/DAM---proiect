package ro.ase.grupa1094;

enum Color {WHITE, BROWN, BLACK, GINGER, MIXED}
public class Cat {
    private String name;
    private float weight;
    private Color color;

    public Cat(String name, float weight, Color color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", color=" + color +
                '}';
    }
}
