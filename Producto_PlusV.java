import java.util.ArrayList;
import java.util.Scanner;

public class Producto_PlusV extends Producto{
    private String volumen;

    Producto_PlusV() {}

    Producto_PlusV(String marca, String nombre, String volumen, float precio) {
        this.marca = marca;
        this.nombre = nombre;
        this.volumen = volumen;
        this.precio = precio;
    }

    public void imprimirDatos() {
        System.out.println(" ");
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Volumen: " + this.getVolumen());
        System.out.println("Precio: " + this.getPrecio());
    }

    public Producto_PlusV pedirDatosAgregar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusV objProducto_PlusV = new Producto_PlusV();
        boolean bucleFor = true;

        for (int i = 0; i < 4 || bucleFor; i++) {
            String peticion = "";
            String dato = "";

            switch (i) {
                case 0:
                    peticion = "Ingrese la Marca del producto: ";
                    break;
                case 1:
                    objProducto_PlusV.setMarca(dato);
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 2:
                    objProducto_PlusV.setNombre(dato);
                    peticion = "Ingrese el Volumen del producto: ";
                    break;
                case 3:
                    objProducto_PlusV.setVolumen(dato);
                    peticion = "Ingrese el Precio del producto: ";
                    break;
                case 4:
                    objProducto_PlusV.setPrecio(precio);
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

        return objProducto_PlusV;
    }

    public Producto_PlusV pedirDatosBuscar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusV objProducto_PlusV = new Producto_PlusV();
        boolean bucleFor = true;

        for (int i = 0; i < 3 || bucleFor; i++) {
            String peticion = "";
            String dato = "";

            switch (i) {
                case 0:
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 1:
                    objProducto_PlusV.setNombre(dato);
                    peticion = "Ingrese el Volumen del producto: ";
                    break;
                case 3:
                    objProducto_PlusV.setVolumen(dato);
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

        return objProducto_PlusV;
    }

    public boolean revisarRepeticionProducto(Producto objProducto_PlusV, ArrayList<Producto> listaProductos) {

        for (Producto producto : listaProductos) {

            if (producto instanceof Producto_PlusV) {
                
                if ((producto.getNombre().equals(objProducto_PlusV.getNombre()))
                        && (((Producto_PlusV)producto).getVolumen() == ((Producto_PlusV)objProducto_PlusV).getVolumen())) {
    
                    return true;
                }
            }
        }

        return false;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getVolumen() {
        return volumen;
    }
}
