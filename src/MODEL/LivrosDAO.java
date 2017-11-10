/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LivrosDAO {
    private static LivrosDAO instance;
    
    private LivrosDAO(){
        MySQLDAO.getConnection();
    }
    
    public static LivrosDAO getInstance() {
        if (instance == null) {
            instance = new LivrosDAO();
        }
        return instance;
    }
    
    public long create(LivrosBEAN livro) {
        String query = "INSERT INTO LIVROS (idlivros, titulo, subtitulo, paginas, generos_idgeneros ) VALUES (?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, livro.getIdlivros(), livro.getTitulo(), livro.getSubtitulo(),
                                        livro.getPaginas(), livro.getGeneros_idgeneros());
    }

    public void update(LivrosBEAN livro) {
        String query = "UPDATE LIVROS SET titulo=?, subtitulo=?, paginas=?, generos_idgerenors WHERE idlivros = ?";
        MySQLDAO.executeQuery(query,livro.getTitulo(), livro.getSubtitulo(), livro.getPaginas(), livro.getGeneros_idgeneros(), livro.getIdlivros());
    }
    
    public void delete(LivrosBEAN livro){
        String query = "DELETE FROM LIVROS WHERE idAutor = ?";
        MySQLDAO.executeQuery(query, livro.getIdlivros());
    }
    
    public ArrayList<LivrosBEAN> findAllLivros(){
        return listaLivros ("SELECT * FROM LIVROS ORDER BY Titulo");
    }
    
    public ArrayList<LivrosBEAN> listaLivros(String query) {
        ArrayList<LivrosBEAN> lista = new ArrayList<LivrosBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new LivrosBEAN(rs.getInt("idlivros"), rs.getString("Titulo"), rs.getString("subtitulo"),
                                            rs.getInt("paginas"), rs.getInt("generos_idgeneros")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public LivrosBEAN findLivro(int idLivro) {
        LivrosBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM LIVROS WHERE idlivros=?", idLivro);
        try {
            if (rs.next()) {
                result = new LivrosBEAN(rs.getInt("idlivros"), rs.getString("Titulo"), rs.getString("subtitulo"),
                                            rs.getInt("paginas"), rs.getInt("generos_idgeneros"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int findIdAutor(AutoresBEAN autor) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(
        "SELECT * FROM AUTORES WHERE Nome= ? and status= ? "
                ,autor.getNome(), autor.getStatus());

        try {
            if (rs.next()) {
                result = rs.getInt("idAutor");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public Boolean isExist(int idAutor) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTORES WHERE idAutor= ?", idAutor);
        try {
            if (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
