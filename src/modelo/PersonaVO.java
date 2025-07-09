package modelo;

public class PersonaVO {
    private String documento;
    private String nombre;
    private String telefono;
    private String direccion;

    public PersonaVO() {}

    public PersonaVO(String documento, String nombre, String telefono, String direccion) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "Documento: " + documento + "\n" +
               "Nombre: " + nombre + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Dirección: " + direccion;
    }
}
