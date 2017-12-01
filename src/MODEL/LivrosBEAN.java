
package MODEL;

public class LivrosBEAN {
    private int idlivros;
    private String titulo;
    private String subtitulo;
    private int paginas;
    private int generos_idgeneros;
    private int status;
    private int idautor;
    
    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public LivrosBEAN(int idlivros, String titulo, String subtitulo, int paginas, int generos_idgeneros, int status, int idautor) {
        this.idlivros = idlivros;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.paginas = paginas;
        this.generos_idgeneros = generos_idgeneros;
        this.status = status;
        this.idautor = idautor;
    }
    public LivrosBEAN(String titulo, String subtitulo, int paginas, int generos_idgeneros, int status, int idautor) {
        
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.paginas = paginas;
        this.generos_idgeneros = generos_idgeneros;
        this.status = status;
        this.idautor = idautor;
    }
    public LivrosBEAN(String titulo, String subtitulo, int paginas, int generos_idgeneros){
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.paginas = paginas;
        this.generos_idgeneros = generos_idgeneros;
    }
    public LivrosBEAN(int idlivros, String titulo, String subtitulo, int paginas, int status){
        this.idlivros = idlivros;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.paginas = paginas;
        this.status = status;
    }
        
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public int getIdlivros() {
        return idlivros;
    }

    public void setIdlivros(int idlivros) {
        this.idlivros = idlivros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getGeneros_idgeneros() {
        return generos_idgeneros;
    }

    public void setGeneros_idgeneros(int generos_idgeneros) {
        this.generos_idgeneros = generos_idgeneros;
    }
    
    
    
}
