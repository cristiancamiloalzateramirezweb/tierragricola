
package modelo.DTO;

public class DTOMunicipio {

    private int id_municipio;
    private int id_departamento;
    private String municipio;

    public DTOMunicipio() {
    }

    public DTOMunicipio(int id_municipio, int id_departamento, String municipio) {
        this.id_municipio = id_municipio;
        this.id_departamento = id_departamento;
        this.municipio = municipio;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "DTOMunicipio{" + "id_municipio=" + id_municipio + ", id_departamento=" + id_departamento + ", municipio=" + municipio + '}';
    }

}
