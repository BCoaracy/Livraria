
package MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmprestimosDAO {
    private static EmprestimosDAO instance;
    
    private EmprestimosDAO(){
        MySQLDAO.getConnection();
    }
    
    public static EmprestimosDAO getInstance() {
        if (instance == null) {
            instance = new EmprestimosDAO();
        }
        return instance;
    }
    
    public long create(EmprestimosBEAN emprestimo) {
        String query = "INSERT INTO EMPRESTIMO (DataLocacao, DataDevolucao, IdCliente) VALUES (?,?,?)";
        return MySQLDAO.executeQuery(query, emprestimo.getDataLocacao(), emprestimo.getDataDevolucao(),
                emprestimo.getIdCliente());
    }

    public void update(EmprestimosBEAN emprestimo) {
        String query = "UPDATE EMPRESTIMO SET DataLocacao=?, DataDevolucao=?, idCliente=? WHERE idEmprestimo = ?";
        MySQLDAO.executeQuery(query, emprestimo.getDataLocacao(), emprestimo.getDataDevolucao(),
                emprestimo.getIdCliente());
    }
    
    public void delete(EmprestimosBEAN emprestimo){
        String query = "DELETE FROM EMPRESTIMO WHERE idAutor = ?";
        MySQLDAO.executeQuery(query, emprestimo.getIdEmprestimo());
    }
    
    public ArrayList<EmprestimosBEAN> findAllEmprestimos(){
        return listaEmprestimos ("SELECT * FROM EMPRESTIMO ORDER BY idEmprestimo");
    }
    
    public ArrayList<EmprestimosBEAN> listaEmprestimos(String query) {
        ArrayList<EmprestimosBEAN> lista = new ArrayList<EmprestimosBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new EmprestimosBEAN(rs.getInt("idEmprestimo"),
                        rs.getDate("DataLocacao"), rs.getDate("DateDevolucao"), rs.getInt("idCliente"), rs.getInt("Status")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public EmprestimosBEAN findEmprestimo(int idEmprestimo) {
        EmprestimosBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EMPRESTIMO WHERE idEmprestimo=?", idEmprestimo);
        try {
            if (rs.next()) {
                result = new EmprestimosBEAN(rs.getInt("idEmprestimo"),
                        rs.getDate("DataLocacao"), rs.getDate("DateDevolucao"), rs.getInt("idCliente"), rs.getInt("Status"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
//    public int findIdEmprestimo(EmprestimosBEAN emprestimo) {
//        int result = 0;
//        ResultSet rs = null;
//        rs = MySQLDAO.getResultSet(
//        "SELECT * FROM EMPRESTIMO WHERE Nome= ? and status= ?"
//                ,emprestimo.getNome(), emprestimo.getStatus());
//
//        try {
//            if (rs.next()) {
//                result = rs.getInt("idAutor");
//            }
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
    
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
