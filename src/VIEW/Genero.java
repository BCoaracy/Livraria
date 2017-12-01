package VIEW;

import CONTROLLER.Controle;
import MODEL.GenerosBEAN;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Genero extends javax.swing.JInternalFrame {

    ArrayList<GenerosBEAN> generos = new ArrayList();
    
    public Genero() {
        initComponents();
        atualizarCombobox();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alterar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        jComboGenero = new javax.swing.JComboBox<>();
        Genero = new javax.swing.JLabel();
        textGenero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textCheck = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        jComboGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboGeneroActionPerformed(evt);
            }
        });

        Genero.setText("Genero");

        jLabel1.setText("Generos");

        textCheck.setEditable(false);
        textCheck.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Genero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jComboGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(alterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textCheck))))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Genero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarCombobox(){
        Controle control = new Controle();
        
        generos = control.listaGeneros();
        jComboGenero.removeAllItems();
        for(GenerosBEAN g :generos){
            jComboGenero.addItem(g.getGenero());
        }
        
    }    
    
    private void jComboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboGeneroActionPerformed
        String texto = (String) jComboGenero.getSelectedItem();
        textGenero.setText(texto);
    }//GEN-LAST:event_jComboGeneroActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        Controle control = new Controle();
        GenerosBEAN genero = new GenerosBEAN(textGenero.getText());
        control.addGenero(genero);
        textGenero.setText(null);
        textCheck.setText("Cadastrado!");
        atualizarCombobox();
    }//GEN-LAST:event_cadastrarActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        Controle control = new Controle();
        GenerosBEAN genero = new GenerosBEAN(textGenero.getText());
        genero.setIdGenero(control.findGenero(genero));
        control.updateGeneros(genero);
        textCheck.setText("Alterado!");
        atualizarCombobox();
    }//GEN-LAST:event_alterarActionPerformed

    private static Genero instance = null;
    public static Genero getInstance() {
        if (instance == null) {
            instance = new Genero();
            Interface.getInstance().getDesktop().add(instance);
        }
        return instance;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Genero;
    private javax.swing.JButton alterar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JComboBox<String> jComboGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textCheck;
    private javax.swing.JTextField textGenero;
    // End of variables declaration//GEN-END:variables
}
