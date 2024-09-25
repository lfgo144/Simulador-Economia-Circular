package EconomiaCircular;

public class Producto {
    private String nombre;
    private int cantidad;
    private boolean reciclable;

    public Producto(String nombre, int cantidad, boolean reciclable) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.reciclable = reciclable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isReciclable() {
        return reciclable;
    }

    public void reciclar() {
        if (reciclable) {
            cantidad = 0; // Se recicla el producto
        }
    }
}

