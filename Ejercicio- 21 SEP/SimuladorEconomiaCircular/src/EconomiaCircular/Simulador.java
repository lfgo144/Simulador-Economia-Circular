package EconomiaCircular;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {
    private List<Producto> productos;
    private List<Recurso> recursos;
    private Scanner scanner;

    public Simulador() {
        productos = new ArrayList<>();
        recursos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\nSimulador de Economía Circular");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Agregar Recurso");
            System.out.println("3. Reciclar Producto");
            System.out.println("4. Mostrar Recursos");
            System.out.println("5. Contar Productos");  // Nueva opción
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    agregarRecurso();
                    break;
                case 3:
                    reciclarProducto();
                    break;
                case 4:
                    mostrarRecursos();
                    break;
                case 5:
                    System.out.println("Cantidad de productos agregados: " + contarProductos()); // Mostrar conteo
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private int contarProductos() {
        return productos.size();
    }

    private void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("¿Es reciclable? (true/false): ");
        boolean reciclable = scanner.nextBoolean();
        productos.add(new Producto(nombre, cantidad, reciclable));
        System.out.println("Producto agregado.");
    }

    private void agregarRecurso() {
        System.out.print("Nombre del recurso: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        recursos.add(new Recurso(nombre, cantidad));
        System.out.println("Recurso agregado.");
    }

    private void reciclarProducto() {
        System.out.print("Nombre del producto a reciclar: ");
        String nombre = scanner.nextLine();
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.reciclar();
                System.out.println("Producto reciclado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    private void mostrarRecursos() {
        System.out.println("Recursos:");
        for (Recurso recurso : recursos) {
            System.out.println(recurso.getNombre() + ": " + recurso.getCantidad());
        }
    }

    public static void main(String[] args) {
        Simulador simulador = new Simulador();
        simulador.iniciar();
    }
}
