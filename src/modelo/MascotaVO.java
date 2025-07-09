package modelo;

public class MascotaVO {
    private int id; 
    private String nombreMascota;  
    private String especie;
    private String raza;
    private int edad;
    private String documentoDueño;

    public MascotaVO() {}

    // Constructor sin id (para registrar)
    public MascotaVO(String nombreMascota, String especie, String raza, int edad, String documentoDueño) {
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.documentoDueño = documentoDueño;
    }

    // Constructor con id (para actualizar)
    public MascotaVO(int id, String nombreMascota, String especie, String raza, int edad, String documentoDueño) {
        this.id = id;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.documentoDueño = documentoDueño;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreMascota() { return nombreMascota; }
    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getDocumentoDueño() { return documentoDueño; }
    public void setDocumentoDueño(String documentoDueño) { this.documentoDueño = documentoDueño; }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Nombre Mascota: " + nombreMascota + "\n" +
               "Especie: " + especie + "\n" +
               "Raza: " + raza + "\n" +
               "Edad: " + edad + "\n" +
               "Documento dueño: " + documentoDueño;
    }
}
