/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

public class LivrosBEAN {
    private int idlivros;
    private String titulo;
    private String subtitulo;
    private int paginas;
    private int generos_idgeneros;

    public LivrosBEAN(int idlivros, String titulo, String subtitulo, int paginas, int generos_idgeneros) {
        this.idlivros = idlivros;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.paginas = paginas;
        this.generos_idgeneros = generos_idgeneros;
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
