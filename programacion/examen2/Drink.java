package examen2;

public class Drink extends Product{
    enum Size {
        SMALL, MEDIUM, LARGE
    }
    private boolean alcoholic;

    public Drink(String name, boolean free, Size size, boolean alcoholic) {
        super(name, free, 0);
        price = 1;
        switch (size) {
            case MEDIUM:
                price = 2;
                break;
            case LARGE:
                price = 3;
                break;
        }
        if (alcoholic) {
            price += 0.5;
        }
        this.alcoholic = alcoholic;
    }

}
