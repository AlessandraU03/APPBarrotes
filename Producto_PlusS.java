import java.util.ArrayList;
import java.util.Scanner;

public class Producto_PlusS extends Producto {

    private String sabor;

    Producto_PlusS() {}

    Producto_PlusS(String marca, String nombre, String sabor, float precio) {
        this.marca = marca;
        this.nombre = nombre;
        this.sabor = sabor;
        this.precio = precio;
    }

    public void imprimirDatos() {
        System.out.println(" ");
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Sabor: " + this.getSabor());
        System.out.println("Precio: " + this.getPrecio());
    }

    public Producto_PlusS pedirDatosAgregar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusS objProducto_PlusS = new Producto_PlusS();
        boolean bucleFor = true;

        for (int i = 0; i < 5 || bucleFor; i++) {
            String peticion = "";
            String dato = "";

            switch (i) {
                case 0:
                    peticion = "Ingrese la Marca del producto: ";
                    break;
                case 1:
                    objProducto_PlusS.setMarca(dato);
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 2:
                    objProducto_PlusS.setNombre(dato);
                    peticion = "Ingrese el Sabor del producto: ";
                    break;
                case 3:
                    objProducto_PlusS.setSabor(dato);
                    peticion = "Ingrese el Precio del producto: ";
                    break;
                case 4:
                    int precio = Integer.parseInt(dato);
                    objProducto_PlusS.setPrecio(precio);
                    bucleFor = false;
                    break;
            }

            System.out.println(" ");
            System.out.println("(___Escriba 'exit' para cancelar la operacion___)");
            System.out.print(peticion);
            dato = leerTeclado.nextLine();

            if (dato.equals("exit")) {
                System.out.println(" ");
                System.out.println("=== CANCEL ===");
                System.out.println("Se ha cancelado la operacion");
                System.out.println(" ");

                return null;
            }

        }

        return objProducto_PlusS;
    }

    public Producto_PlusS pedirDatosBuscar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusS objProducto_PlusS = new Producto_PlusS();
        boolean bucleFor = true;

        for (int i = 0; i < 4 || bucleFor; i++) {
            String peticion = "";
            String dato = "";

            switch (i) {
                case 0:
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 1:
                    objProducto_PlusS.setNombre(dato);
                    peticion = "Ingrese el Sabor del producto: ";
                    break;
                case 3:
                    objProducto_PlusS.setSabor(dato);
                    bucleFor = false;
                    break;
            }

            System.out.println(" ");
            System.out.println("(___Escriba 'exit' para cancelar la operacion___)");
            System.out.print(peticion);
            dato = leerTeclado.nextLine();

            if (dato.equals("exit")) {
                System.out.println(" ");
                System.out.println("=== CANCEL ===");
                System.out.println("Se ha cancelado la operacion");
                System.out.println(" ");

                return null;
            }
        }

        return objProducto_PlusS;
    }

    public boolean revisarRepeticionProducto(Producto objProducto_PlusS, ArrayList<Producto> listaProductos) {

        for (Producto producto : listaProductos) {

            if (producto instanceof Producto_PlusS) {

                if ((producto.getNombre().equals(objProducto_PlusS.getNombre()))
                        && (((Producto_PlusS) producto).getSabor() == ((Producto_PlusS) objProducto_PlusS).getSabor())) {

                    return true;
                }
            }
        }

        return false;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getSabor() {
        return sabor;
    }
}