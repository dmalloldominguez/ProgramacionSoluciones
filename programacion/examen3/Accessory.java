package examen3;

public class Accessory {
    private String nombre;
    private String material;
    private String descripcion;

    public Accessory(String nombre, String material, String descripcion) {
        this.nombre = nombre;
        this.material = material;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

}
