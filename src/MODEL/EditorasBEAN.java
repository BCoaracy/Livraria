
package MODEL;

public class EditorasBEAN {

    private int id;
    private String razao;
    private String endereco;
    private String telefone;

    public EditorasBEAN(int id, String razao, String endereco, String telefone) {
        this.id = id;
        this.razao = razao;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }
    
}
