import java.util.ArrayList;
import java.util.Scanner;

public class Producto_PlusSX extends Producto {
    private String sabor;
    private ArrayList<String> personalizado = new ArrayList<>();

    Producto_PlusSX() {
    }

    public Producto_PlusSX(String marca, String nombre, String sabor, ArrayList<String> personalizado, float precio) {
        this.marca = marca;
        this.nombre = nombre;
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
        System.out.println("Sabor: " + this.getSabor());
        System.out.println("Datos Personalizados:");
        for (String datoPersonalizado : this.getPersonalizado()) {
            System.out.println("\t" + "- " + datoPersonalizado);
        }
        System.out.println("Precio: " + this.getPrecio());
    }

    public Producto_PlusSX pedirDatosAgregar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusSX objProducto_PlusSX = new Producto_PlusSX();
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
                    objProducto_PlusSX.setMarca(dato);
                    peticion = "Ingrese el Nombre del producto: ";
                    break;
                case 2:
                    objProducto_PlusSX.setNombre(dato);
                    peticion = "Ingrese el Sabor del producto: ";
                    break;
                case 3:
                    objProducto_PlusSX.setSabor(dato);
                    peticion = "Ingrese los Datos Personalizados del producto (Ejemplo: 'Categoria: Dato'): ";
                    break;
                case 4:
                    for (String n : objProducto_PlusSX.getPersonalizado()) {
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
                    int precio = Integer.parseInt(dato);
                    objProducto_PlusSX.setPrecio(precio);
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

        return objProducto_PlusSX;
    }

    public Producto_PlusSX pedirDatosBuscar() {
        @SuppressWarnings("resource")
        Scanner leerTeclado = new Scanner(System.in);
        Producto_PlusSX objProducto_PlusSX = new Producto_PlusSX();
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
                    objProducto_PlusSX.setNombre(dato);
                    peticion = "Ingrese el Sabor del producto: ";
                    break;
                case 2:
                    objProducto_PlusSX.setSabor(dato);
                    peticion = "Ingrese los Datos Personalizados del producto: ";
                    break;
                case 3:

                    for (String n : objProducto_PlusSX.getPersonalizado()) {
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

        return objProducto_PlusSX;
    }

    public boolean revisarRepeticionProducto(Producto objProducto_PlusSX, ArrayList<Producto> listaProductos) {
        for (Producto producto : listaProductos) {

            if (producto instanceof Producto_PlusSX) {

                boolean matchPersonalizado = false;

                int i = 0;
                do {
                    String datoPersonalizadoBuscar = ((Producto_PlusSX) objProducto_PlusSX).getPersonalizado().get(i);

                    if (!((Producto_PlusSX) producto).getPersonalizado().contains(datoPersonalizadoBuscar)) {
                        matchPersonalizado = false;
                    }

                    i++;
                } while ((matchPersonalizado)
                        && (i < ((Producto_PlusSX) objProducto_PlusSX).getPersonalizado().size()));

                if ((producto.getNombre().equals(objProducto_PlusSX.getNombre()))
                        && (((Producto_PlusSX) producto).getSabor().equals(((Producto_PlusSX) objProducto_PlusSX).getSabor()))
                        && matchPersonalizado) {

                    return true;
                }
            }
        }

        return false;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setPersonalizado(ArrayList<String> personalizado) {
        this.personalizado = personalizado;
    }

    public String getSabor() {
        return sabor;
    }

    public ArrayList<String> getPersonalizado() {
        return personalizado;
    }
}