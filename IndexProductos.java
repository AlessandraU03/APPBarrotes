import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IndexProductos {
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    IndexProductos() {
    }

    IndexProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void addListaProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void mostrarMenuProductos() {
        Scanner leerTeclado = new Scanner(System.in);
        int respuesta = 0;
        boolean bucle = true;

        do {
            bucle = true;

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("_MENU PRODUCTOS_");
            System.out.println(" ");
            System.out.println("1.- Añadir Producto");
            System.out.println("2.- Eliminar Producto");
            System.out.println("3.- Modificar Producto");
            System.out.println("4.- Buscar Producto");
            System.out.println("5.- Imprimir Lista Productos");
            System.out.println("6.- REGRESAR");
            System.out.println(" ");
            System.out.print("¿Qué desea hacer?: ");
            try {
                respuesta = leerTeclado.nextInt();
                switch (respuesta) {
                    case 1:
                        añadirProducto();
                        break;
                    case 2:
                        eliminarProducto();
                        break;
                    case 3:
                        modificarProducto();
                        break;
                    case 4:
                        buscarProducto();
                        break;
                    case 5:
                        imprimirListaProductos();
                        break;
                    case 6:
                        bucle = false;
                        break;
                    default:
                        System.out.println(" ");
                        System.out.println("=== ERROR ===");
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        System.out.println(" ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(" ");
                System.out.println("=== ERROR ===");
                System.out.println("Debe ingresar un número entero válido.");
                System.out.println(" ");
                leerTeclado.nextLine(); // Limpiar el buffer del scanner
            }

        } while (bucle);

    }

    public void añadirProducto() {
        Scanner leerTeclado = new Scanner(System.in);
        String respuesta = "";
        int respuestaInt = 0;
        boolean continuar = true; // Variable para controlar si se debe continuar con el bucle principal
    
        do {
            try {
    
                System.out.println("=== SELECCIÓN ===");
                System.out.println("¿Qué datos son relevantes para el producto que desea agregar?");
                System.out.println("(Excluyendo Marca, Nombre y Precio)");
                System.out.println("1.- Volumen");
                System.out.println("2.- Sabor");
                System.out.println("3.- Personalizado");
                System.out.println("4.- Volumen, Sabor");
                System.out.println("5.- Volumen, Personalizado");
                System.out.println("6.- Sabor, Personalizado");
                System.out.println("7.- Volumen, Sabor, Personalizado");
                System.out.println("8.- NINGUNO");
                System.out.println("9.- = cancelar =");
                System.out.println(" ");
                System.out.print("R: ");
    
                if (leerTeclado.hasNextInt()) {
                    respuestaInt = leerTeclado.nextInt();
    
                    switch (respuestaInt) {
                        case 1:
                                Producto_PlusV productoPlusV = new Producto_PlusV();
                                Producto_PlusV productoV = productoPlusV.pedirDatosAgregar();
                                this.addListaProducto(productoV);
                            break;
                            case 2:
                                Producto_PlusS productoPlusS = new Producto_PlusS();
                                Producto_PlusS productoS = productoPlusS.pedirDatosAgregar();
                                this.addListaProducto(productoS);
                            break;
                            case 3:
                                Producto_PlusX productoPlusX = new Producto_PlusX();
                                Producto_PlusX productoX = productoPlusX.pedirDatosAgregar();
                                this.addListaProducto(productoX);
                                break;
                            case 4:
                                Producto_PlusVS productoPlusVS = new Producto_PlusVS();
                                Producto_PlusVS productoVS = productoPlusVS.pedirDatosAgregar();
                                this.addListaProducto(productoVS);
                            break;
                            case 5:
                                Producto_PlusSX productoPlusSX = new Producto_PlusSX();
                                Producto_PlusSX productoSX = productoPlusSX.pedirDatosAgregar();
                                this.addListaProducto(productoSX);
                            break;
                            case 6:
                                Producto_PlusVX productoPlusVX = new Producto_PlusVX();
                                Producto_PlusVX productoVX = productoPlusVX.pedirDatosAgregar();
                                this.addListaProducto(productoVX);
                            break;
                        case 7:
                                Producto_PlusVSX productoPlusVSX = new Producto_PlusVSX();
                                Producto_PlusVSX productoVSX = productoPlusVSX.pedirDatosAgregar();
                                this.addListaProducto(productoVSX);
                            break;
                        case 8:
                                System.out.println(" ");
                                System.out.println("=== CANCELADO ===");
                                System.out.println("No se agregará ningún producto.");
                                System.out.println(" ");
                            break;
                        case 9:
                                System.out.println(" ");
                                System.out.println("=== CANCELADO ===");
                                System.out.println("Operación cancelada por el usuario.");
                                System.out.println(" ");
                            return;
                        default:
                                System.out.println(" ");
                                System.out.println("=== ERROR ===");
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                                System.out.println(" ");
                            break;
                    }
    
                    System.out.println(" ");
                    System.out.println("=== ÉXITO ===");
                    System.out.println("Producto agregado");
                    System.out.println(" ");
    
                } else {
                    // Manejo de caso en el que no se proporciona un entero válido
                    System.out.println(" ");
                    System.out.println("=== ERROR ===");
                    System.out.println("Debe ingresar un número entero.");
                    System.out.println(" ");
    
                    // Limpiar el buffer del scanner
                    leerTeclado.nextLine();
                }
    
            } catch (Exception e) {
                // Manejo de otras excepciones no previstas
                System.out.println(" ");
                System.out.println("=== ERROR ===");
                System.out.println("Se ha producido un error inesperado.");
                System.out.println(" ");
            }
    
            // Preguntar al usuario si desea agregar otro producto
            do {
                System.out.println(" ");
                System.out.print("¿Desea agregar otro producto? (s/n): ");
                respuesta = leerTeclado.next();
    
                if (!(respuesta.equals("s") || respuesta.equals("n"))) {
                    System.out.println(" ");
                    System.out.println("=== ERROR ===");
                    System.out.println("Debe ingresar 's' para sí o 'n' para no.");
                    System.out.println(" ");
    
                } else if (respuesta.equals("n")) {
                    continuar = false; // Si la respuesta es 'n', se detiene el bucle principal
                }
    
            } while (!(respuesta.equals("s") || respuesta.equals("n")));
    
        } while (continuar); // Continuar con el bucle principal mientras 'continuar' sea verdadero
    
        leerTeclado.close();
    }
    


    public void eliminarProducto() {
        Producto productoEliminar;
        Scanner leerTeclado = new Scanner(System.in);
        String respuesta;

        do {
            String nombreEliminar;

            System.out.println(" ");
            System.out.println("(___Escriba 'exit' para cancelar la operación___)");
            System.out.print("Ingrese el nombre del producto a eliminar: ");
            nombreEliminar = leerTeclado.nextLine();

            if (nombreEliminar.equals("exit")) {
                System.out.println(" ");
                System.out.println("=== CANCEL ===");
                System.out.println("Se ha cancelado la operación");
                System.out.println(" ");
                leerTeclado.close();
                return;
            }

            // Buscar el producto en la lista y eliminarlo si se encuentra
            productoEliminar = null;
            for (Producto producto : listaProductos) {
                if (producto.getNombre().equals(nombreEliminar)) {
                    productoEliminar = producto;
                    break;
                }
            }

            if (productoEliminar != null) {
                listaProductos.remove(productoEliminar);
                System.out.println(" ");
                System.out.println("=== ÉXITO ===");
                System.out.println("Producto eliminado");
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println("=== ERROR ===");
                System.out.println("Producto no encontrado");
                System.out.println(" ");
            }

            do {
                System.out.println(" ");
                System.out.print("¿Desea eliminar otro producto? (s/n): ");
                respuesta = leerTeclado.nextLine();

                if (!(respuesta.equals("s") || respuesta.equals("n"))) {
                    System.out.println(" ");
                    System.out.println("=== ERROR ===");
                    System.out.println("Valor no válido");
                    System.out.println(" ");

                }

            } while (!(respuesta.equals("s") || respuesta.equals("n")));

        } while (respuesta.equals("s"));

        leerTeclado.close();
    }


    public void modificarProducto() {
        Scanner leerTeclado = new Scanner(System.in);
        Producto productoModificar = null;
        String nombreModificar = "";
        String respuesta = "";
        boolean bucle = true;

        do {
            System.out.println(" ");
            System.out.println("(___Escriba 'exit' para cancelar la operación___)");
            System.out.print("Ingrese el nombre del producto a modificar: ");
            nombreModificar = leerTeclado.nextLine();

            if (nombreModificar.equals("exit")) {
                System.out.println(" ");
                System.out.println("=== CANCEL ===");
                System.out.println("Se ha cancelado la operación");
                System.out.println(" ");
                leerTeclado.close();
                return;
            }

            // Buscar el producto en la lista
            for (Producto producto : listaProductos) {
                if (producto.getNombre().equals(nombreModificar)) {
                    productoModificar = producto;
                    break;
                }
            }

            if (productoModificar != null) {
                System.out.println(" ");
                System.out.println("=== ÉXITO ===");
                System.out.println("Producto encontrado");
                System.out.println(" ");

                // Aquí puedes agregar la lógica para modificar el producto según tus requisitos

            } else {
                System.out.println(" ");
                System.out.println("=== ERROR ===");
                System.out.println("Producto no encontrado");
                System.out.println(" ");
            }

            do {
                System.out.println(" ");
                System.out.print("¿Desea modificar otro producto? (s/n): ");
                respuesta = leerTeclado.nextLine();

                if (!(respuesta.equals("s") || respuesta.equals("n"))) {
                    System.out.println(" ");
                    System.out.println("=== ERROR ===");
                    System.out.println("Valor no válido");
                    System.out.println(" ");

                }

            } while (!(respuesta.equals("s") || respuesta.equals("n")));

        } while (respuesta.equals("s"));

        leerTeclado.close();
    }

    public void buscarProducto() {
        Scanner leerTeclado = new Scanner(System.in);
        String respuesta = "";
        boolean bucle = true;
    
        do {
            System.out.println(" ");
            System.out.print("Ingrese el nombre del producto a buscar: ");
            final String nombreBuscar = leerTeclado.nextLine(); // Variable final auxiliar
    
            // Buscar el producto en la lista
            Producto productoBuscar = listaProductos.stream()
                    .filter(producto -> producto.getNombre().equalsIgnoreCase(nombreBuscar))
                    .findAny()
                    .orElse(null);
    
            if (productoBuscar != null) {
                System.out.println(" ");
                System.out.println("==========");
                productoBuscar.imprimirDatos();
                System.out.println(" ");
                System.out.println("==========");
            } else {
                System.out.println(" ");
                System.out.println("=== ERROR ===");
                System.out.println("Producto no encontrado");
                System.out.println(" ");
            }
    
            do {
                System.out.println(" ");
                System.out.print("¿Desea buscar otro producto?(s/n): ");
                respuesta = leerTeclado.nextLine();
    
                if (!(respuesta.equals("s") || respuesta.equals("n"))) {
                    System.out.println(" ");
                    System.out.println("=== ERROR ===");
                    System.out.println("Valor no válido");
                    System.out.println(" ");
                }
    
            } while (!(respuesta.equals("s") || respuesta.equals("n")));
    
            if (respuesta.equals("s")) {
                bucle = true;
            } else {
                bucle = false;
            }
    
        } while (bucle);
    
        leerTeclado.close();
    }
    

    public void imprimirListaProductos() {
        System.out.println(" ");
        System.out.println("LISTA DE PRODUCTOS:");
        for (Producto producto : listaProductos) {
            producto.imprimirDatos();
        }
    }
    
    // ===============================================================================================================================================
    // ===============================================================================================================================================

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    // ................................................................................................................................................
    // ................................................................................................................................................

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
}
