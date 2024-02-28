package examen2;

public abstract class Product {
    private String name;
    private boolean free;
    protected double price;

    public Product(String name, boolean free, double price) {
        this.name = name;
        this.free = free;
        this.price = price;
    }

    public String getConcept() {
        return name;
    }

    public double getPrice() {
        double price = this.price;
        if (free) {
            price = 0;
        }
        return price;
    }
    public boolean isFree() {
        return free;
    }
}
