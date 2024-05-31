package examen3;

public class Statue extends Figure {
    private String franchise;

    public Statue(String name, int year, double basePrice, State state, String franchise) {
        super(name, year, basePrice, state);
        this.franchise = franchise;
    }
    @Override
    public double getRealPrice() {
        return _getRealPrice();
    }

    // No se pedía pero ayuda a depurar
    @Override
    public String toString(){
        return "Nombre: " + getName() + "\n" +
                "Año de lanzamiento: " + getYear() + "\n" +
                "Precio base: " + getBasePrice() + "\n" +
                "Estado: " + getState() + "\n" +
                "Precio real: " + getRealPrice() + "\n" +
                "Franquicia: " + franchise;
    }
}
