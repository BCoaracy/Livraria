package VIEW;

import CONTROLLER.Controle;
import MODEL.AutoresBEAN;
import MODEL.GenerosBEAN;
import MODEL.LivrosBEAN;
import MODEL.EditorasBEAN;
import java.util.ArrayList;

public class CadastrarLivros extends javax.swing.JInternalFrame {

    ArrayList<GenerosBEAN> generos = new ArrayList();
    ArrayList<AutoresBEAN> autores = new ArrayList();
    ArrayList<EditorasBEAN> editoras = new ArrayList();
    
    
    public CadastrarLivros() {
        initComponents();
        atualizarCombobox();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        textSubTitulo = new javax.swing.JTextField();
        textPag = new javax.swing.JTextField();
        bCadastrar = new javax.swing.JButton();
        comboGeneros = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboAutores = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboEditora = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setText("Titulo:");

        jLabel2.setText("Subtitulo:");

        jLabel3.setText("Quantidade de páginas:");

        jLabel4.setText("Gêneros:");

        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Autores:");

        jLabel6.setText("Editora:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(comboEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bCadastrar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(comboAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(comboGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(textPag))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(textSubTitulo))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textSubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(bCadastrar)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarCombobox(){
        Controle control = new Controle(); 
        generos = control.listaGeneros();
        for(GenerosBEAN g :generos){
            comboGeneros.addItem(g.getGenero());
        }
        autores = control.listaAutores();
        for(AutoresBEAN a : autores){
            if(a.getStatus()==1)
            comboAutores.addItem(a.getNome());
        }
        editoras = control.listaEditoras();
        for(EditorasBEAN e : editoras){
            comboEditora.addItem(e.getRazao());
        }
        
    }
    
    
    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        Controle control = new Controle();
        String titulo = textTitulo.getText();
        String subtitulo = textSubTitulo.getText();
        int paginas = Integer.parseInt(textPag.getText());
        int genero = comboGeneros.getSelectedIndex()+1;
        int autor = comboAutores.getSelectedIndex()+1;
        int idEditora = comboEditora.getSelectedIndex()+1;
        int status = 1;
        LivrosBEAN livro = new LivrosBEAN(0, titulo, subtitulo, paginas, idEditora, genero, status, autor);
        control.addLivros(livro);
    }//GEN-LAST:event_bCadastrarActionPerformed

    private static CadastrarLivros instance = null;
    public static CadastrarLivros getInstance() {
        if (instance == null) {
            instance = new CadastrarLivros();
            Interface.getInstance().getDesktop().add(instance);
        }
        return instance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JComboBox<String> comboAutores;
    private javax.swing.JComboBox<String> comboEditora;
    private javax.swing.JComboBox<String> comboGeneros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textPag;
    private javax.swing.JTextField textSubTitulo;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}
