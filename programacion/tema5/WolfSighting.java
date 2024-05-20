package tema5;

public class WolfSighting extends Sighting{
    int number;
    String observation;

    public WolfSighting(int hour, int number, String observation) {
        super(hour);
        this.number = number;
        this.observation = observation;
    }
    public String toString() {
        return super.toString() + ", Número: " + number + ", Observación: " + observation + ", Tipo: Lobo";
    }
}
