package MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenerosDAO {
    private static GenerosDAO instance;

    private GenerosDAO() {
        MySQLDAO.getConnection();
    }

    public static GenerosDAO getInstance() {
        if (instance == null) {
            instance = new GenerosDAO();
        }
        return instance;
    }
    
    public long create(GenerosBEAN genero) {
        String query = "INSERT INTO GENEROS (GENERO) VALUES (?)";
        return MySQLDAO.executeQuery(query, genero.getGenero());
    }

    public void update(GenerosBEAN genero) {
        String query = "UPDATE GENEROS SET GENERO = ? WHERE idgeneros  = ?";
        MySQLDAO.executeQuery(query, genero.getIdGenero(), genero.getGenero());
    }

    public void delete(GenerosBEAN genero) {
        MySQLDAO.executeQuery("DELETE FROM GENEROS WHERE idgeneros = ?", genero.getIdGenero());
    }

    public ArrayList<GenerosBEAN> findAllGeneros() {
        return listaGeneros("SELECT * FROM GENEROS ORDER BY genero");
    }

    public ArrayList<GenerosBEAN> listaGeneros(String query) {
        ArrayList<GenerosBEAN> lista = new ArrayList<GenerosBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new GenerosBEAN(rs.getString("genero")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public GenerosBEAN findGenero(int id) {
        GenerosBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM GENEROS WHERE idgenero=?", id);
        try {
            if (rs.next()) {
                result = new GenerosBEAN(rs.getInt("idgenero"), rs.getString("genero"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int findId(GenerosBEAN genero) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(
        "SELECT * FROM GENEROS WHERE genero = ?"
                ,genero.getGenero());

 try {
            if (rs.next()) {
                result = rs.getInt("idgeneros");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int id) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM GENEROS WHERE idgeneros= ?", id);
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
