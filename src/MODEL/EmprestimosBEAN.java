package MODEL;

import java.sql.Date;


public class EmprestimosBEAN {
    private int idEmprestimo;
    private Date dataLocacao;
    private Date dataDevolucao;
    private int idCliente;
    private int Status;

    public EmprestimosBEAN(Date dataLocacao, Date dataDevolucao, int idCliente, int Status) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.idCliente = idCliente;
        this.Status = Status;
    }
    
    public EmprestimosBEAN(int idEmprestimo, Date dataLocacao, Date dataDevolucao, int idCliente, int Status) {
        this.idEmprestimo = idEmprestimo;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.idCliente = idCliente;
        this.Status = Status;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
