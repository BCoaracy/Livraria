/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Bruno
 */
public class AutoresBEAN {
    
    private int idAutor;
    private String Nome;
    private int status;
    
    public AutoresBEAN(){
        
    }
    
    public AutoresBEAN(int idAutor, String Nome, int status){
        this.idAutor = idAutor;
        this.Nome = Nome;
        this.status = status;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
