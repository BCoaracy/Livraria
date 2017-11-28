package VIEW;

import CONTROLLER.Controle;
import MODEL.AutoresBEAN;

public class EditarAutor extends javax.swing.JInternalFrame {

    
    public EditarAutor() {
        initComponents();
        labelAlterado.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        aplicar = new javax.swing.JButton();
        textID = new javax.swing.JTextField();
        buscarID = new javax.swing.JButton();
        labelAlterado = new javax.swing.JLabel();
        jRBAtivo = new javax.swing.JRadioButton();
        jRBInativo = new javax.swing.JRadioButton();
        buscarNome = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setText("Autor:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Status:");

        aplicar.setText("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });

        buscarID.setText("Buscar - ID");
        buscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarIDActionPerformed(evt);
            }
        });

        labelAlterado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelAlterado.setText("Alteração Concluída!");

        jRBAtivo.setText("Ativo");
        jRBAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBAtivoActionPerformed(evt);
            }
        });

        jRBInativo.setText("Inativo");
        jRBInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBInativoActionPerformed(evt);
            }
        });

        buscarNome.setText("Buscar - Nome");
        buscarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRBAtivo)
                                .addGap(18, 18, 18)
                                .addComponent(jRBInativo))
                            .addComponent(textID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelAlterado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBAtivo)
                    .addComponent(jRBInativo)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(aplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAlterado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
        Controle control = new Controle();
        AutoresBEAN autor = new AutoresBEAN();
        autor.setNome(textNome.getText());
        if(jRBAtivo.isSelected())
            autor.setStatus(1);
        if(jRBInativo.isSelected())
            autor.setStatus(0);
        control.updateAutor(autor);

        textNome.setText(null);
        textID.setText(null);
        jRBAtivo.setSelected(false);
        jRBInativo.setSelected(false);

        labelAlterado.setVisible(true);

    }//GEN-LAST:event_aplicarActionPerformed

    private void buscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarIDActionPerformed

        Controle control = new Controle();
        AutoresBEAN autor = new AutoresBEAN();
        autor = control.findAutor(Integer.parseInt(textID.getText()));
        textID.setText(Integer.toString(autor.getIdAutor()));
        textNome.setText(autor.getNome());
        if(autor.getStatus()!=0){
            jRBAtivo.setSelected(true);
        }else if (autor.getStatus()==0){
            jRBInativo.setSelected(true);
        }
    }//GEN-LAST:event_buscarIDActionPerformed

    private void jRBAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBAtivoActionPerformed
        if(jRBInativo.isSelected())
            jRBInativo.setSelected(false);
    }//GEN-LAST:event_jRBAtivoActionPerformed

    private void jRBInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBInativoActionPerformed
        if(jRBAtivo.isSelected())
            jRBAtivo.setSelected(false);
    }//GEN-LAST:event_jRBInativoActionPerformed

    private void buscarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNomeActionPerformed
        Controle control = new Controle();
        AutoresBEAN autor = new AutoresBEAN();
        autor.setNome(textNome.getText());
        int idAutor = control.findIdAutor(autor);
        autor = control.findAutor(idAutor);
        textID.setText(Integer.toString(autor.getIdAutor()));
        textNome.setText(autor.getNome());
        if(autor.getStatus()!=0){
            jRBAtivo.setSelected(true);
        }else if (autor.getStatus()==0){
            jRBInativo.setSelected(true);
        }
    }//GEN-LAST:event_buscarNomeActionPerformed

    private static EditarAutor instance = null;
        public static EditarAutor getInstance() {
            if (instance == null) {
                instance = new EditarAutor();
                Interface.getInstance().getDesktop().add(instance);
            }
            return instance;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicar;
    private javax.swing.JButton buscarID;
    private javax.swing.JButton buscarNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRBAtivo;
    private javax.swing.JRadioButton jRBInativo;
    private javax.swing.JLabel labelAlterado;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
