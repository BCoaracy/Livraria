package MODEL;


public class ClientesBEAN {

    private int idCliente;
    private String nome;
    private String CPF;

    public ClientesBEAN(int idCliente, String nome, String CPF) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.CPF = CPF;
    }
    public ClientesBEAN(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
    
}
