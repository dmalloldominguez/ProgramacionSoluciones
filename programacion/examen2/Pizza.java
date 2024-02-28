package examen2;

public class Pizza extends Product{
    private String[] ingredients;

    public Pizza(String name, boolean free, String[] ingredients) {
        super(name, free, 8 + ingredients.length);
        this.ingredients = ingredients;
    }

    public String[] getIngredients() {
        return ingredients;
    }
}
