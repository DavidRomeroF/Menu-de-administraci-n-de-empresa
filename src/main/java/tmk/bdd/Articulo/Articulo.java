package tmk.bdd.Articulo;

public class Articulo {
    private String nombre;
    private int precion;
    private String codigo;
    private int grupo;

    public Articulo(String nombre, int precion, String codigo, int grupo) {
        this.nombre = nombre;
        this.precion = precion;
        this.codigo = codigo;
        this.grupo = grupo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecion(int precion) {
        this.precion = precion;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }
    public int getPrecion() {
        return precion;
    }
    public String getCodigo() {
        return codigo;
    }
    public int getGrupo() {
        return grupo;
    }
}
