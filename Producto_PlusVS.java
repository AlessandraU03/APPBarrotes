import java.util.ArrayList;
import java.util.Scanner;

public class Producto_PlusVS extends Producto {
    private String volumen;
    private String sabor;

    Producto_PlusVS() {
    }

    Producto_PlusVS(String marca, String nombre, String volumen, String sabor, float precio) {
        this.marca = marca;
        this.nombre = nombre;
        this.volumen = volumen;
        this.sabor = sabor;
        this.precio = precio;
    }

    public void imprimirDatos() {
        System.out.println(" ");
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Volumen: " + this.getVolumen());
        System.out.println("Sabor: " + this.getSabor());
        System.out.println("Precio: " + this.getPrecio());
    }

    public Producto_PlusVS pedirDatosAgregar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusVS objProducto_PlusVS = new Producto_PlusVS();
        boolean bucleFor = true;

        for (int i = 0; i < 6 || bucleFor; i++) {
            String peticion = "";
            String dato = "";

            switch (i) {
                case 0:
                    peticion = "Ingrese la Marca del producto: ";
                    break;
                case 1:
                    objProducto_PlusVS.setMarca(dato);
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 2:
                    objProducto_PlusVS.setNombre(dato);
                    peticion = "Ingrese el Volumen del producto: ";
                    break;
                case 3:
                    objProducto_PlusVS.setVolumen(dato);
                    peticion = "Ingrese el Sabor del producto: ";
                    break;
                case 4:
                    objProducto_PlusVS.setSabor(dato);
                    peticion = "Ingrese el Precio del producto: ";
                    break;
                case 5:
                    objProducto_PlusVS.setPrecio(precio);
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

        return objProducto_PlusVS;
    }

    public Producto_PlusVS pedirDatosBuscar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusVS objProducto_PlusVS = new Producto_PlusVS();
        boolean bucleFor = true;

        for (int i = 0; i < 4 || bucleFor; i++) {
            String peticion = "";
            String dato = "";

            switch (i) {
                case 0:
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 1:
                    objProducto_PlusVS.setNombre(dato);
                    peticion = "Ingrese el Volumen del producto: ";
                    break;
                case 2:
                    objProducto_PlusVS.setVolumen(dato);
                    peticion = "Ingrese el Sabor del producto: ";
                    break;
                case 3:
                    objProducto_PlusVS.setSabor(dato);
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

        return objProducto_PlusVS;
    }

    public boolean revisarRepeticionProducto(Producto objProducto_PlusS, ArrayList<Producto> listaProductos) {

        for (Producto producto : listaProductos) {

            if (producto instanceof Producto_PlusVS) {

                if ((producto.getNombre().equals(objProducto_PlusS.getNombre()))
                        && (((Producto_PlusVS) producto).getSabor() == ((Producto_PlusVS) objProducto_PlusS).getSabor())
                        && (((Producto_PlusVS) producto).getVolumen() == ((Producto_PlusVS) objProducto_PlusS)
                                .getVolumen())) {

                    return true;
                }
            }
        }

        return false;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getVolumen() {
        return volumen;
    }

    public String getSabor() {
        return sabor;
    }
}
