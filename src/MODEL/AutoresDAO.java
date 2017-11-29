package MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutoresDAO {
    private static AutoresDAO instance;
    
    private AutoresDAO(){
        MySQLDAO.getConnection();
    }
    
    public static AutoresDAO getInstance() {
        if (instance == null) {
            instance = new AutoresDAO();
        }
        return instance;
    }
    
    public long create(AutoresBEAN autor) {
        String query = "INSERT INTO AUTORES (Nome, status) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, autor.getNome(), autor.getStatus());
    }

    public void update(AutoresBEAN autor) {
        String query = "UPDATE AUTORES SET Nome=?, status=? WHERE idAutor = ?";
        MySQLDAO.executeQuery(query, autor.getNome(), autor.getStatus(), autor.getIdAutor());
    }
    
    public void delete(AutoresBEAN autor){
        String query = "DELETE FROM AUTORES WHERE idAutor = ?";
        MySQLDAO.executeQuery(query, autor.getIdAutor());
    }
    
    public ArrayList<AutoresBEAN> findAllAutores(){
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
    
    public AutoresBEAN findAutor(int idAutor) {
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
        "SELECT * FROM AUTORES WHERE Nome= ? and status= ?"
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
    
    public AutoresBEAN findIdAutorNome(String nomeAutor){
        AutoresBEAN result = null;
        ResultSet rs = null;
        nomeAutor = "%"+nomeAutor+"%";
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTORES WHERE Nome like ?", nomeAutor);
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
