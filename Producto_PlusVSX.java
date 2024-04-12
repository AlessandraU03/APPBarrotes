import java.util.ArrayList;
import java.util.Scanner;

public class Producto_PlusVSX extends Producto{
    private String volumen;
    private String sabor;
    private ArrayList<String> personalizado = new ArrayList<>();

    Producto_PlusVSX() {
    }

    public Producto_PlusVSX(String marca, String nombre, String volumen, String sabor, ArrayList<String> personalizado,float precio) {
        this.marca = marca;
        this.nombre = nombre;
        this.volumen = volumen;
        this.sabor = sabor;
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

    public Producto_PlusVSX pedirDatosAgregar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusVSX objProducto_PlusVSX = new Producto_PlusVSX();
        boolean bucleFor = true;

        for (int i = 0; i < 7 || bucleFor; i++) {
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
                    objProducto_PlusVSX.setMarca(dato);
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 2:
                    objProducto_PlusVSX.setNombre(dato);
                    peticion = "Ingrese el Volumen del producto: ";
                    break;
                case 3:
                    objProducto_PlusVSX.setVolumen(dato);
                    peticion = "Ingrese el Sabor del producto: ";
                    break;
                case 4:
                    objProducto_PlusVSX.setSabor(dato);
                    peticion = "Ingrese los Datos Personalizados del producto (Ejemplo: 'Categoria: Dato'): ";
                    break;
                case 5:
                    for (String n : objProducto_PlusVSX.getPersonalizado()) {
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
                case 6:
                    int precio = Integer.parseInt(dato);
                    objProducto_PlusVSX.setPrecio(precio);
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

        return objProducto_PlusVSX;
    }

    public Producto_PlusVSX pedirDatosBuscar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusVSX objProducto_PlusVSX = new Producto_PlusVSX();
        boolean bucleFor = true;

        for (int i = 0; i < 6 || bucleFor; i++) {
            String peticion = "";
            String dato = "";
            boolean bucleDatosPersonalizsdos = true;

            switch (i) {
                case 0:
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 1:
                    objProducto_PlusVSX.setNombre(dato);
                    peticion = "Ingrese el Volumen del producto: ";
                    break;
                case 2:
                    objProducto_PlusVSX.setVolumen(dato);
                    peticion = "Ingrese el Sabor del producto: ";
                    break;
                case 3:
                    objProducto_PlusVSX.setPrecio(precio);
                    bucleFor = false;
                    break;
                case 4:
                    objProducto_PlusVSX.setSabor(dato);   
                    peticion = "Ingrese los Datos Personalizados del producto: ";
                    break;
                case 5:

                    for (String n : objProducto_PlusVSX.getPersonalizado()) {
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

        return objProducto_PlusVSX;
    }

    public boolean revisarRepeticionProducto(Producto objProducto_PlusVSX, ArrayList<Producto> listaProductos) {
        for (Producto producto : listaProductos) {

            if (producto instanceof Producto_PlusVSX) {

                boolean matchPersonalizado = false;

                int i = 0;
                do {
                    String datoPersonalizadoBuscar = ((Producto_PlusVSX) objProducto_PlusVSX).getPersonalizado().get(i);

                    if (!((Producto_PlusVSX) producto).getPersonalizado().contains(datoPersonalizadoBuscar)) {
                        matchPersonalizado = false;
                    }

                    i++;
                } while ((matchPersonalizado) && (i < ((Producto_PlusVSX) objProducto_PlusVSX).getPersonalizado().size()));

                if ((producto.getNombre().equals(objProducto_PlusVSX.getNombre()))
                        && (((Producto_PlusVSX)producto).getVolumen().equals(((Producto_PlusVSX)objProducto_PlusVSX).getVolumen()))
                        && (((Producto_PlusVSX)producto).getSabor().equals(((Producto_PlusVSX)objProducto_PlusVSX).getSabor()))
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
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public void setPersonalizado(ArrayList<String> personalizado) {
        this.personalizado = personalizado;
    }

    public String getVolumen() {
        return volumen;
    }
    public String getSabor() {
        return sabor;
    }
    public ArrayList<String> getPersonalizado() {
        return personalizado;
    }
}

