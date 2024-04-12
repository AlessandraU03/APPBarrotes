import java.util.ArrayList;

public abstract class Producto {
    protected String marca;
    protected String nombre;
    protected String volumen;
    protected float precio;
    
    Producto() {}

    Producto(String marca, String nombre, String volumen, float precio) {
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

    public abstract Producto pedirDatosAgregar();

    public abstract Producto pedirDatosBuscar();

    public abstract boolean revisarRepeticionProducto(Producto producto, ArrayList<Producto> listaProductos);


    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }
    public String getNombre() {
        return nombre;
    }
    public String getVolumen() {
        return volumen;
    }
    public float getPrecio() {
        return precio;
    }
}
