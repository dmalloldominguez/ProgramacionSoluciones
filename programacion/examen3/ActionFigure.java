package examen3;

import java.util.ArrayList;
import java.util.List;

public class ActionFigure extends Figure {
    private List<Accessory> accessories;

    public ActionFigure(String name, int year, double basePrice, State state) {
        super(name, year, basePrice, state);
        this.accessories = new ArrayList<>();
    }

    public void addAccessory(Accessory accessory){
        accessories.add(accessory);
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
                "Accesorios: " + accessories;
    }
}
