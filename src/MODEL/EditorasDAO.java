/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditorasDAO {

    private static EditorasDAO instance;

    private EditorasDAO() {
        MySQLDAO.getConnection();
    }

    public static EditorasDAO getInstance() {
        if (instance == null) {
            instance = new EditorasDAO();
        }
        return instance;
    }

    public long create(EditorasBEAN editora) {
        String query = "INSERT INTO EDITORAS (Razao, Endereco, Telefone) VALUES (?,?,?)";
        return MySQLDAO.executeQuery(query, editora.getRazao(), editora.getEndereco(), editora.getTelefone());
    }

    public void update(EditorasBEAN editora) {
        String query = "UPDATE EDITORAS SET Razao=?, Endereco=?, Telefone=? WHERE id = ?";
        MySQLDAO.executeQuery(query, editora.getRazao(), editora.getEndereco(),
                editora.getTelefone(), editora.getId());
    }

    public void delete(EditorasBEAN editora) {
        MySQLDAO.executeQuery("DELETE FROM EDITORAS WHERE id = ?", editora.getId());
    }

    public ArrayList<EditorasBEAN> findAllEditora() {
        return listaEditoras("SELECT * FROM Editoras ORDER BY Razao");
    }

    public ArrayList<EditorasBEAN> listaEditoras(String query) {
        ArrayList<EditorasBEAN> lista = new ArrayList<EditorasBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new EditorasBEAN(rs.getString("Razao"), rs.getString("Endereco"),
                        rs.getString("Telefone")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public EditorasBEAN findEditora(int id) {
        EditorasBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORAS WHERE id=?", id);
        try {
            if (rs.next()) {
                result = new EditorasBEAN(rs.getInt("id"), rs.getString("razao"), rs.getString("endereco"),
                        rs.getString("telefone"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int findId(EditorasBEAN editora) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(
        //"SELECT * FROM EDITORAS WHERE Razao= ? and Endereco= ? and Telefone=  ? "
        //        ,editora.getRazao(),editora.getEndereco(),editora.getTelefone());
        "SELECT * FROM EDITORAS WHERE RAZAO = ?", editora.getRazao());
 try {
            if (rs.next()) {
                result = rs.getInt("id");
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
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORAS WHERE id= ?", id);
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
