import java.util.ArrayList;
import java.util.Scanner;

public class Producto_PlusVX extends Producto{
    private String volumen;
    private ArrayList<String> personalizado = new ArrayList<>();

    Producto_PlusVX() {
    }

    public Producto_PlusVX(String marca, String nombre, String volumen, ArrayList<String> personalizado,float precio) {
        this.marca = marca;
        this.nombre = nombre;
        this.volumen = volumen;
        this.personalizado = personalizado;
        this.precio = precio;
    }

    public void addPersonalizado(String dato) {
        this.personalizado.add(dato);
    }

    public void imprimirDatos() {
        System.out.println(" ");
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Volumen: " + this.getVolumen());
        System.out.println("Datos Personalizados:");
        for (String datoPersonalizado : this.getPersonalizado()) {
            System.out.println("\t" + "- " + datoPersonalizado);
        } 
        System.out.println("Precio: " + this.getPrecio());
    }

    public Producto_PlusVX pedirDatosAgregar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusVX objProducto_PlusVX = new Producto_PlusVX();
        boolean bucleFor = true;

        for (int i = 0; i < 6 || bucleFor; i++) {
            String peticion = "";
            String dato = "";
            boolean bucleDatosPersonalizsdos = true;

            if ((i == 3) && (bucleDatosPersonalizsdos == true)) {
                i--;
            }

            switch (i) {
                case 0:
                    peticion = "Ingrese la Marca del producto: ";
                    break;
                case 1:
                    objProducto_PlusVX.setMarca(dato);
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 2:
                    objProducto_PlusVX.setNombre(dato);
                    peticion = "Ingrese el Volumen del producto: ";
                    break;
                case 3:
                    objProducto_PlusVX.setVolumen(dato);
                    peticion = "Ingrese los Datos Personalizados del producto (Ejemplo: 'Categoria: Dato'): ";
                    break;
                case 4:
                    for (String n : objProducto_PlusVX.getPersonalizado()) {
                        if (n.equals(dato)) {
                            System.out.println(" ");
                            System.out.println("=== ERROR ===");
                            System.out.println("Producto repetido");
                            System.out.println("Intentelo de nuevo");
                            System.out.println(" ");
                        } else {
                            this.addPersonalizado(dato);
                        }
                    }

                    boolean buclePreguntaS_N = false;
                    do {
                        System.out.println(" ");
                        System.out.print("¿Desea agregar otro Dato Personalizado?(s/n): ");
                        dato = leerTeclado.nextLine();

                        if (!(dato.equals("s") || dato.equals("n"))) {
                            buclePreguntaS_N = true;

                            System.out.println(" ");
                            System.out.println("=== ERROR ===");
                            System.out.println("Valor no valido");
                            System.out.println(" ");
                        }
                    } while (buclePreguntaS_N);

                    if (dato.equals("n")) {
                        bucleDatosPersonalizsdos = false;
                    }

                    if (!bucleDatosPersonalizsdos) {
                        peticion = "Ingrese el Precio del producto: ";
                    }
                    break;
                case 5:
                    objProducto_PlusVX.setPrecio(precio);
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

        return objProducto_PlusVX;
    }

    public Producto_PlusVX pedirDatosBuscar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusVX objProducto_PlusVX = new Producto_PlusVX();
        boolean bucleFor = true;

        for (int i = 0; i < 4 || bucleFor; i++) {
            String peticion = "";
            String dato = "";
            boolean bucleDatosPersonalizsdos = true;

            switch (i) {
                case 0:
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 1:
                    objProducto_PlusVX.setNombre(dato);
                    peticion = "Ingrese el Volumen del producto: ";
                    break;
                case 2:
                    objProducto_PlusVX.setVolumen(dato);
                    peticion = "Ingrese los Datos Personalizados del producto: ";
                    break;
                case 3:

                    for (String n : objProducto_PlusVX.getPersonalizado()) {
                        if (n.equals(dato)) {
                            System.out.println(" ");
                            System.out.println("=== ERROR ===");
                            System.out.println("Producto repetido");
                            System.out.println("Intentelo de nuevo");
                            System.out.println(" ");
                        } else {
                            this.addPersonalizado(dato);
                        }
                    }

                    boolean buclePreguntaS_N = false;
                    do {
                        System.out.println(" ");
                        System.out.print("¿Desea agregar otro Dato Personalizado?(s/n): ");
                        dato = leerTeclado.nextLine();

                        if (!(dato.equals("s") || dato.equals("n"))) {
                            buclePreguntaS_N = true;

                            System.out.println(" ");
                            System.out.println("=== ERROR ===");
                            System.out.println("Valor no valido");
                            System.out.println(" ");
                        }
                    } while (buclePreguntaS_N);

                    if (dato.equals("n")) {
                        bucleDatosPersonalizsdos = false;
                    }

                    if (!bucleDatosPersonalizsdos) {
                        bucleFor = false;
                    }
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

        return objProducto_PlusVX;
    }

    public boolean revisarRepeticionProducto(Producto objProducto_PlusVX, ArrayList<Producto> listaProductos) {
        for (Producto producto : listaProductos) {

            if (producto instanceof Producto_PlusVX) {

                boolean matchPersonalizado = false;

                int i = 0;
                do {
                    String datoPersonalizadoBuscar = ((Producto_PlusVX) objProducto_PlusVX).getPersonalizado().get(i);

                    if (!((Producto_PlusVX) producto).getPersonalizado().contains(datoPersonalizadoBuscar)) {
                        matchPersonalizado = false;
                    }

                    i++;
                } while ((matchPersonalizado) && (i < ((Producto_PlusVX) objProducto_PlusVX).getPersonalizado().size()));

                if ((producto.getNombre().equals(objProducto_PlusVX.getNombre()))
                        && (((Producto_PlusVX)producto).getVolumen().equals(((Producto_PlusVX)objProducto_PlusVX).getVolumen()))
                        && matchPersonalizado) {

                    return true;
                }
            }
        }

        return false;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }
    public void setPersonalizado(ArrayList<String> personalizado) {
        this.personalizado = personalizado;
    }

    public String getVolumen() {
        return volumen;
    }
    public ArrayList<String> getPersonalizado() {
        return personalizado;
    }
}

