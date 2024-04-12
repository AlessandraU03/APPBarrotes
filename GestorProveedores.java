import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorProveedores {
    private ArrayList<Proveedor> proveedores = new ArrayList<>();

    public GestorProveedores() {
    }

    public void setGestorProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void addProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void mostrarMenuProveedores() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                System.out.println("\nMenú de Gestión de Proveedores");
                System.out.println("1. Añadir Proveedor");
                System.out.println("2. Eliminar Proveedor");
                System.out.println("3. Modificar Proveedor");
                System.out.println("4. Buscar Proveedor");
                System.out.println("5. Mostrar Proveedores");
                System.out.println("6. REGRESAR");
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("=== ERROR ===");
                System.out.println("Debe ingresar un número entero válido.");
                scanner.nextLine(); // Consume newline character
            }

            switch (opcion) {
                case 1:
                    añadirProveedor();
                    break;
                case 2:
                    eliminarProveedor();
                    break;
                case 3:
                    modificarProveedor();
                    break;
                case 4:
                    buscarProveedor();
                    break;
                case 5:
                    mostrarProveedores();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }

        } while (opcion != 6);
    }

    public void añadirProveedor() {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
    
        do {
            Proveedor objProveedor = new Proveedor();
            String peticion = "Ingrese el nombre del proveedor y el producto que surte: ";
            String dato;
    
            System.out.println("\n(___Escriba 'exit' para cancelar la operación___)");
    
            System.out.println(peticion);
            dato = scanner.nextLine();
    
            if (dato.equalsIgnoreCase("exit")) {
                System.out.println("\n=== CANCEL ===");
                System.out.println("Se ha cancelado la operación\n");
                return;
            }
    
            objProveedor.setNombre(dato);
    
            for (int i = 0; i < 2; i++) {
                String[] inputs = {"contacto", "horarios"};
    
                System.out.println("\n(___Escriba 'exit' para cancelar la operación___)");
                peticion = "Ingrese el " + inputs[i] + " del proveedor: ";
                System.out.println(peticion);
                
    
                if (dato.equalsIgnoreCase("exit")) {
                    System.out.println("\n=== CANCEL ===");
                    System.out.println("Se ha cancelado la operación\n");
                    return;
                }
    
                switch (i) {
                    case 0:
                        dato = scanner.nextLine();
                        objProveedor.setContacto(dato);
                        break;
                    case 1:
                        System.out.println("Ingrese los días de la semana en que estará disponible el proveedor (Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo), separados por comas:");
                        dato = scanner.nextLine();
                        String[] horarios = dato.split(",");
                        objProveedor.setHorarios(horarios);
                        break;
                }
            }
    
            boolean proveedorRepetido = false;
            for (Proveedor proveedorExistente : proveedores) {
                if (proveedorExistente.equals(objProveedor)) {
                    proveedorRepetido = true;
                    System.out.println("\n=== ERROR ===");
                    System.out.println("Proveedor repetido");
                    System.out.println("Inténtelo de nuevo\n");
                    break;
                }
            }
    
            if (!proveedorRepetido) {
                proveedores.add(objProveedor);
                System.out.println("\n=== ÉXITO ===");
                System.out.println("Proveedor agregado\n");
            }
    
            do {
                System.out.print("¿Desea agregar otro proveedor? (s/n): ");
                respuesta = scanner.nextLine();
    
                if (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
                    System.out.println("=== ERROR ===");
                    System.out.println("Valor no válido");
                }
            } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));
    
        } while (respuesta.equalsIgnoreCase("s"));
    }
    
    


    public void eliminarProveedor() {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        Proveedor proveedorEliminar = new Proveedor();

        boolean bucle;
        do {
            bucle = false;
            if (proveedores == null || proveedores.size() == 0) {
                System.out.println("No hay proveedores registrados.");
                return;
            }

            System.out.println("Ingrese el nombre del proveedor a eliminar:");
            proveedorEliminar.setNombre(scanner.nextLine());

            boolean encontrado = false;
            for (int i = 0; i < proveedores.size(); i++) {
                if (proveedores.get(i).getNombre().equalsIgnoreCase(proveedorEliminar.getNombre())) {
                    proveedorEliminar = proveedores.get(i);
                    encontrado = true;

                    System.out.println("¿Está seguro/a de eliminar al proveedor permanentemente? (s/n):");
                    respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        proveedores.remove(i);
                        System.out.println("Proveedor eliminado correctamente.");
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Proveedor no encontrado.");
            }


            do {
                System.out.print("¿Desea eliminar otro proveedor? (s/n): ");
                respuesta = scanner.nextLine();

                if (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
                    System.out.println("=== ERROR ===");
                    System.out.println("Valor no válido");
                }
            } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));

            if (respuesta.equalsIgnoreCase("s")) {
                bucle = true;
            }

        } while (bucle);
    }


    public void modificarProveedor() {
        Scanner scanner = new Scanner(System.in);
        boolean bucle;
        String respuesta;
        do {
            bucle = false;
            if (proveedores == null || proveedores.size() == 0) {
                System.out.println("No hay proveedores registrados.");
                return;
            }
    
            boolean encontrado = false;
            Proveedor proveedorModificar = new Proveedor();
            System.out.println("Ingrese el nombre del proveedor a modificar:");
            String nombreProveedor = scanner.nextLine();
            for (Proveedor proveedor : proveedores) {
                if (proveedor.getNombre().equalsIgnoreCase(nombreProveedor)) {
                    encontrado = true;
                    System.out.println("Ingrese el nuevo nombre del proveedor:");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Ingrese el nuevo contacto del proveedor:");
                    String nuevoContacto = scanner.nextLine();
                    System.out.println("Ingrese los nuevos días de la semana en que estará disponible el proveedor (Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo), separados por comas:");
                    String nuevoDia = scanner.nextLine();
                    
                    // Modificar los datos del proveedor
                    proveedor.setNombre(nuevoNombre);
                    proveedor.setContacto(nuevoContacto);
                    proveedor.setHorarios(new String[]{nuevoDia});
                    
                    System.out.println("Proveedor modificado correctamente.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Proveedor no encontrado.");
            }
    
            do {
                System.out.print("¿Desea modificar otro proveedor? (s/n): ");
                respuesta = scanner.nextLine();
    
                if (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
                    System.out.println("=== ERROR ===");
                    System.out.println("Valor no válido");
                }
            } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));
    
            if (respuesta.equalsIgnoreCase("s")) {
                bucle = true;
            }
    
        } while (bucle);
    }
    

    public void buscarProveedor() {
        Scanner scanner = new Scanner(System.in);
        boolean bucle;
        String respuesta;

        do {
            bucle = false;

            if (proveedores == null || proveedores.size() == 0) {
                System.out.println("No hay proveedores registrados.");
                return;
            }
            Proveedor proveedorBuscar = new Proveedor();
            System.out.println("Ingrese el nombre del proveedor a buscar:");
            proveedorBuscar.setNombre(scanner.nextLine());
            boolean encontrado = false;

            for (int i = 0; i < proveedores.size(); i++) {
                Proveedor proveedor = proveedores.get(i);
                if (proveedor.getNombre().equalsIgnoreCase(proveedorBuscar.getNombre())) {
                    encontrado = true;
                    System.out.println("Proveedor encontrado:");
                    System.out.println("Nombre: " + proveedor.getNombre());
                    System.out.println("Contacto: " + proveedor.getContacto());
                    System.out.print("Días de disponibilidad: ");
                    String[] horarios = proveedor.getHorarios();
                    for (int j = 0; j < horarios.length; j++) {
                        System.out.print(horarios[j]);
                        if (j < horarios.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Proveedor no encontrado.");
            }

            do {
                System.out.print("¿Desea buscar otro proveedor? (s/n): ");
                respuesta = scanner.nextLine();

                if (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
                    System.out.println("=== ERROR ===");
                    System.out.println("Valor no válido");
                }
            } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));

            if (respuesta.equalsIgnoreCase("s")) {
                bucle = true;
            }

        } while (bucle);
    }

    public void mostrarProveedores() {
        if (proveedores == null || proveedores.size() == 0) {
            System.out.println("No hay proveedores registrados.");
            return;
        }
        System.out.println("Proveedores:");
        for (Proveedor proveedor : proveedores) {
            System.out.println("Nombre y producto: " + proveedor.getNombre());
            System.out.println("Contacto: " + proveedor.getContacto());
            System.out.print("Días de disponibilidad: ");
            String[] horarios = proveedor.getHorarios();
            for (int j = 0; j < horarios.length; j++) {
                System.out.print(horarios[j]);
                if (j < horarios.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
    
}
