package MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDAO {
    
     private static ClientesDAO instance;
    
    private ClientesDAO(){
        MySQLDAO.getConnection();
    }
    
    public static ClientesDAO getInstance() {
        if (instance == null) {
            instance = new ClientesDAO();
        }
        return instance;
    }
    
    public long create(ClientesBEAN cliente) {
        String query = "INSERT INTO CLIENTES (Nome, cpf) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, cliente.getNome(), cliente.getCPF());
    }

    public void update(ClientesBEAN cliente) {
        String query = "UPDATE CLIENTES SET Nome=?, cpf=? WHERE idCliente= ?";
        MySQLDAO.executeQuery(query, cliente.getNome(),  cliente.getCPF(), cliente.getIdCliente());
    }
    
    public void delete(ClientesBEAN cliente){
        String query = "DELETE FROM CLIENTES WHERE idCliente = ?";
        MySQLDAO.executeQuery(query, cliente.getIdCliente());
    }
    
    public ArrayList<ClientesBEAN> findAllClientes(){
        return listaClientes ("SELECT * FROM CLIENTES ORDER BY Nome");
    }
    
    public ArrayList<ClientesBEAN> listaClientes(String query) {
        ArrayList<ClientesBEAN> lista = new ArrayList<ClientesBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new ClientesBEAN(rs.getInt("idCliente"),
                        rs.getString("Nome"), rs.getString("CPF")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public ClientesBEAN findCliente(int idCliente) {
        ClientesBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTES WHERE idAutor=?", idCliente);
        try {
            if (rs.next()) {
                result = new ClientesBEAN(rs.getInt("idCliente"),
                        rs.getString("Nome"), rs.getString("CPF"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int findIdCliente(ClientesBEAN cliente) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(
        "SELECT * FROM CLIENTES WHERE Nome= ? "
                ,cliente.getNome());

        try {
            if (rs.next()) {
                result = rs.getInt("idCliente");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ClientesBEAN findIdClienteNome(String nomeCliente){
        ClientesBEAN result = null;
        ResultSet rs = null;
        nomeCliente = "%"+nomeCliente+"%";
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTES WHERE Nome like ?", nomeCliente);
        try {
            if (rs.next()) {
                result = new ClientesBEAN(rs.getInt("idCliente"), rs.getString("Nome"), rs.getString("CPF"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public Boolean isExist(int idCliente) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTES WHERE idCliente= ?", idCliente);
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
