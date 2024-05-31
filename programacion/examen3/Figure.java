package examen3;

enum State {
    SEALED, ORIGINAL_PACKAGE, WITHOUT_ORIGINAL_PACKAGE
}
public abstract class Figure {
    private String name;
    private int year;
    private double basePrice;
    private State state;

    public Figure(String name, int year, double basePrice, State state) {
        this.name = name;
        this.year = year;
        this.basePrice = basePrice;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public State getState() {
        return state;
    }

    abstract public double getRealPrice();

    protected double _getRealPrice() {
        double realPrice = switch (getState()) {
            case SEALED -> getBasePrice() * 2;
            case WITHOUT_ORIGINAL_PACKAGE -> getBasePrice() / 2;
            default -> getBasePrice();
        };
        return realPrice;
    }
}
