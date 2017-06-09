/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.Livro;
import Model.LivroMananger;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControleLivro extends javax.swing.JFrame {
    private Livro l;
    /**
     * Creates new form ControleLivro
     */
    public ControleLivro() {
        initComponents();
        ButAlterar.setVisible(false);
        ButExcluir.setVisible(false);
        l=new Livro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextTitulo = new javax.swing.JTextField();
        ButListaTitulo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TextAutor = new javax.swing.JTextField();
        ButListaAutor = new javax.swing.JButton();
        Lista = new javax.swing.JComboBox();
        ButPesquisa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextEditora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextEdicao = new javax.swing.JFormattedTextField();
        TextQuantidade = new javax.swing.JFormattedTextField();
        ButGravar = new javax.swing.JButton();
        ButAlterar = new javax.swing.JButton();
        ButExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Livros");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 46, 51), 14), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 217, 217), 8)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Titulo:");

        TextTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ButListaTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButListaTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lista.png"))); // NOI18N
        ButListaTitulo.setText("Listar");
        ButListaTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ButListaTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButListaTituloActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Autor:");

        TextAutor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ButListaAutor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButListaAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lista.png"))); // NOI18N
        ButListaAutor.setText("Listar");
        ButListaAutor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ButListaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButListaAutorActionPerformed(evt);
            }
        });

        Lista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ButPesquisa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        ButPesquisa.setText("Pesquisar");
        ButPesquisa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ButPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButPesquisaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Titulos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Editora:");

        TextEditora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Edição:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Quantidade:");

        try {
            TextEdicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextEdicao.setText("00");
        TextEdicao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        try {
            TextQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextQuantidade.setText("00");
        TextQuantidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ButGravar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Chest.gif"))); // NOI18N
        ButGravar.setText("Gravar");
        ButGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButGravarActionPerformed(evt);
            }
        });

        ButAlterar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pena.png"))); // NOI18N
        ButAlterar.setText("Alterar");
        ButAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAlterarActionPerformed(evt);
            }
        });

        ButExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fire.png"))); // NOI18N
        ButExcluir.setText("Excluir");
        ButExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(TextTitulo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextAutor)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextEditora)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(TextEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(TextQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(89, 89, 89)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ButGravar)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(ButAlterar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ButExcluir)))
                                        .addGap(0, 12, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ButListaAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ButListaTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButListaTitulo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ButListaAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButPesquisa)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButGravar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ButAlterar)
                    .addComponent(ButExcluir)
                    .addComponent(TextQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButGravarActionPerformed
        l.setTitulo(TextTitulo.getText());
        l.setAutor(TextAutor.getText());
        l.setEditora(TextEditora.getText());
        l.setQuantidade(Integer.parseInt(TextQuantidade.getText()));
        l.setEdicao(Integer.parseInt(TextEdicao.getText()));
        LivroMananger.cadastrar(l);
    }//GEN-LAST:event_ButGravarActionPerformed

    private void ButListaTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButListaTituloActionPerformed
        ArrayList<String> comp=new ArrayList<String>();
        Lista.removeAllItems();
        comp=LivroMananger.listarTitulo(TextTitulo.getText());
         if(comp.size()>=1){
            for (String vez:comp){
                Lista.addItem(vez);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Nenhum livro encontrado","Vazio",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButListaTituloActionPerformed

    private void ButListaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButListaAutorActionPerformed
        ArrayList<String> comp=new ArrayList<String>();
        Lista.removeAllItems();
        comp=LivroMananger.listarAutor(TextAutor.getText());
        if(comp.size()>=1){
            for (String vez:comp){
                Lista.addItem(vez);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Nenhum livro encontrado","Vazio",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButListaAutorActionPerformed

    private void ButPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButPesquisaActionPerformed
        String temp=Lista.getSelectedItem().toString();
        l=LivroMananger.pesquisar(temp.split("¬")[0], temp.split("¬")[1]);
        TextTitulo.setText(l.getTitulo());
        TextAutor.setText(l.getAutor());
        TextEditora.setText(l.getEditora());
        if(l.getQuantidade()<10){
            TextQuantidade.setText("0"+Integer.toString(l.getQuantidade()));
        }else{
            TextQuantidade.setText(Integer.toString(l.getQuantidade()));
        }
        if(l.getEdicao()<10){
            TextEdicao.setText("0"+Integer.toString(l.getEdicao()));
        }else{
            TextEdicao.setText(Integer.toString(l.getEdicao()));    
        }
        ButAlterar.setVisible(true);
        ButExcluir.setVisible(true);
        Lista.removeAllItems();
    }//GEN-LAST:event_ButPesquisaActionPerformed

    private void ButExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButExcluirActionPerformed
        int resposta=JOptionPane.showConfirmDialog(null, "Tem certeza que quer deletar?\nSerá excluido permanentemente", "Exclusão", JOptionPane.YES_NO_OPTION);
        if(resposta==JOptionPane.YES_OPTION) {
            
            String respost=JOptionPane.showInputDialog(null, "Escreva 'deletar' \nignorar maiusculo e minusculo", "Confirmação", JOptionPane.QUESTION_MESSAGE);
            if(respost.equalsIgnoreCase("deletar")){
                LivroMananger.deletar(l);
                l=new Livro();
                TextTitulo.setText("");
                TextAutor.setText("");
                TextEdicao.setText("");
                TextQuantidade.setText("00");
                TextEdicao.setText("00");
                ButAlterar.setVisible(false);
                ButExcluir.setVisible(false);
            }
        }
    }//GEN-LAST:event_ButExcluirActionPerformed

    private void ButAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButAlterarActionPerformed
        int resposta=JOptionPane.showConfirmDialog(null, "Tem certeza que quer subistituir?\nOs dados serão trocatos permanentemente", "Alteração", JOptionPane.YES_NO_OPTION);
        if(resposta==JOptionPane.YES_OPTION) {
            
            String respost=JOptionPane.showInputDialog(null, "Escreva 'sim' \nignorar maiusculo e minusculo", "Confirmação", JOptionPane.QUESTION_MESSAGE);
            if(respost.equalsIgnoreCase("sim")){ 
                l.setTitulo(TextTitulo.getText());
                l.setAutor(TextAutor.getText());
                l.setEditora(TextEditora.getText());
                l.setQuantidade(Integer.parseInt(TextQuantidade.getText()));
                l.setEdicao(Integer.parseInt(TextEdicao.getText()));
                LivroMananger.atualizar(l);
                l=new Livro();
                TextTitulo.setText("");
                TextAutor.setText("");
                TextEdicao.setText("");
                TextQuantidade.setText("00");
                TextEdicao.setText("00");
                ButAlterar.setVisible(false);
                ButExcluir.setVisible(false);
            }
        }
    }//GEN-LAST:event_ButAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControleLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButAlterar;
    private javax.swing.JButton ButExcluir;
    private javax.swing.JButton ButGravar;
    private javax.swing.JButton ButListaAutor;
    private javax.swing.JButton ButListaTitulo;
    private javax.swing.JButton ButPesquisa;
    private javax.swing.JComboBox Lista;
    private javax.swing.JTextField TextAutor;
    private javax.swing.JFormattedTextField TextEdicao;
    private javax.swing.JTextField TextEditora;
    private javax.swing.JFormattedTextField TextQuantidade;
    private javax.swing.JTextField TextTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
