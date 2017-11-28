
package VIEW;

import CONTROLLER.Controle;
import MODEL.EditorasBEAN;        

public class EditarEditoras extends javax.swing.JInternalFrame {

    public EditarEditoras() {
        initComponents();
        labelAlterado.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textRazao = new javax.swing.JTextField();
        textEndereco = new javax.swing.JTextField();
        textTel = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        textID = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        labelAlterado = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Id Editora");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 24, -1, -1));

        jLabel2.setText("Razao");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 67, -1, -1));

        jLabel3.setText("Endereco");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 99, -1, -1));

        jLabel4.setText("Telefone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 128, -1, -1));
        getContentPane().add(textRazao, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 67, 91, -1));
        getContentPane().add(textEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 96, 91, -1));
        getContentPane().add(textTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 125, 91, -1));

        jButton1.setText("Aplicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 179, 91, -1));
        getContentPane().add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 21, 58, -1));

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 20, -1, -1));

        labelAlterado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelAlterado.setText("ALTERADO!");
        getContentPane().add(labelAlterado, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 226, 90, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
            
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Controle control = new Controle();
        EditorasBEAN editora = new EditorasBEAN();
        editora = control.findEditora(Integer.parseInt(textID.getText()));
        textRazao.setText(editora.getRazao());
        textEndereco.setText(editora.getEndereco());
        textTel.setText(editora.getTelefone());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Controle control = new Controle();
        EditorasBEAN editora = new EditorasBEAN();
        editora.setId(Integer.parseInt(textID.getText()));
        editora.setRazao(textRazao.getText());
        editora.setEndereco(textEndereco.getText());
        editora.setTelefone(textTel.getText());
        control.updateEditoras(editora);
        
        textRazao.setText(null);
        textEndereco.setText(null);
        textTel.setText(null);
        
        labelAlterado.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private static EditarEditoras instance = null;
    public static EditarEditoras getInstance() {
        if (instance == null) {
            instance = new EditarEditoras();
            Interface.getInstance().getDesktop().add(instance);
        }
        return instance;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelAlterado;
    private javax.swing.JTextField textEndereco;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textRazao;
    private javax.swing.JTextField textTel;
    // End of variables declaration//GEN-END:variables
}
