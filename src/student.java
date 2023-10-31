public class Estudiante {
    private String id;
    private String nombre;
    private String apellido;
    private String genero;
    private String carrera_a_estudiar;
    private int puntaje_matematicas;

    public Estudiante(String id, String nombre, String apellido, String genero, String carrera_a_estudiar, int puntaje_matematicas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.carrera_a_estudiar = carrera_a_estudiar;
        this.puntaje_matematicas = puntaje_matematicas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public String getCarrera_a_estudiar() {
        return carrera_a_estudiar;
    }

    public int getPuntaje_matematicas() {
        return puntaje_matematicas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCarrera_a_estudiar(String carrera_a_estudiar) {
        this.carrera_a_estudiar = carrera_a_estudiar;
    }

    public void setPuntaje_matematicas(int puntaje_matematicas) {
        this.puntaje_matematicas = puntaje_matematicas;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", genero='" + genero + '\'' +
                ", carrera_a_estudiar='" + carrera_a_estudiar + '\'' +
                ", puntaje_matematicas=" + puntaje_matematicas +
                '}';
    }
}
