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
        String query = "INSERT INTO LIVROS (, status) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, autor.getNome(), autor.getStatus());
    }

    public void update(LivrosBEAN livro) {
        String query = "UPDATE EDITORAS SET Nome=?, status=? WHERE idAutor = ?";
        MySQLDAO.executeQuery(query, autor.getNome(), autor.getStatus(), autor.getIdAutor());
    }
    
    public void delete(LivrosBEAN livro){
        String query = "DELETE FROM AUTORES WHERE idAutor = ?";
        MySQLDAO.executeQuery(query, autor.getIdAutor());
    }
    
    public ArrayList<LivrosBEAN> findAllLivros(){
        return listaAutores ("SELECT * FROM AUTORES ORDER BY Nome");
    }
    
    public ArrayList<AutoresBEAN> listaAutores(String query) {
        ArrayList<AutoresBEAN> lista = new ArrayList<AutoresBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new AutoresBEAN(rs.getInt("idAutor"), rs.getString("Nome"), rs.getInt("status")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public LivrosBEAN findLivro(int idAutor) {
        AutoresBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTORES WHERE idAutor=?", idAutor);
        try {
            if (rs.next()) {
                result = new AutoresBEAN(rs.getInt("idAutor"), rs.getString("Nome"), rs.getInt("status"));
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
