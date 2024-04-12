import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        IndexProductos selectorProducto = new IndexProductos();
        GestorProveedores gestorProveedores = new GestorProveedores();
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        int respuesta = 0;
        boolean bucle = true;

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=== BIENVENIDO ===");

        do {
            bucle = true;
            try {
                System.out.println(" ");
                System.out.println("_MENU PRINCIPAL_");
                System.out.println(" ");
                System.out.println("1.- Productos");
                System.out.println("2.- Ventas");
                System.out.println("3.- Proveedores");
                System.out.println("4.- SALIR");
                System.out.println(" ");
                System.out.print("¿Qué menú desea abrir?: ");
                respuesta = leerTeclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("=== ERROR ===");
                System.out.println("Debe ingresar un número entero válido.");
                leerTeclado.nextLine();
            }

            switch (respuesta) {
                case 1:
                    selectorProducto.mostrarMenuProductos();
                    break;
                case 3:
                    gestorProveedores.mostrarMenuProveedores();
                    break;
                case 4:
                    bucle = false;
                    break;    
                default:
                    break;
            }

        } while (bucle);
    }
}

