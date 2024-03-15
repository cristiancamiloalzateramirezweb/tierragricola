
package modelo.DTO;

public class DTODepartamento {

    private int id_departamento;
    private String departamento;

    public DTODepartamento() {
    }

    public DTODepartamento(int id_departamento, String departamento) {
        this.id_departamento = id_departamento;
        this.departamento = departamento;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "DTODepartamento{" + "id_departamento=" + id_departamento + ", departamento=" + departamento + '}';
    }

}
