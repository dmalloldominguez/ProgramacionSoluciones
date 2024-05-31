package examen3;

import java.time.LocalDate;

public class FunkoPop extends Figure {
    boolean edicionLimitada;

    public FunkoPop(String name, int year, double basePrice, State state, boolean limitedEdition) {
        super(name, year, basePrice, state);
        this.edicionLimitada = limitedEdition;
    }

    public boolean getEdicionLimitada(){
        return edicionLimitada;
    }
    @Override
    public double getRealPrice() {
        double precioReal = getBasePrice();
        if (edicionLimitada){
            precioReal = getBasePrice() + ((LocalDate.now().getYear() - getYear()) * 10);
        }
        return precioReal;
    }

    // No se pedía pero ayuda a depurar
    @Override
    public String toString(){
        return "Nombre: " + getName() + "\n" +
                "Año de lanzamiento: " + getYear() + "\n" +
                "Precio base: " + getBasePrice() + "\n" +
                "Estado: " + getState() + "\n" +
                "Edición limitada: " + (getEdicionLimitada() ? "SÍ" : "NO") + "\n" +
                "Precio real: " + getRealPrice();
    }

}
