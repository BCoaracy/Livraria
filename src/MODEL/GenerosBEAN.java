package MODEL;


public class GenerosBEAN {
    private int idGenero;
    private String genero;
    
    public GenerosBEAN(int idGenero, String genero){
        this.idGenero=idGenero;
        this.genero=genero;
    }
    public GenerosBEAN(String genero){
        this.genero = genero;
    }
    
    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
