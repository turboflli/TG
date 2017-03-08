/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.Professor;
import Model.ProfessorManenger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControleProfessor extends javax.swing.JFrame {

    private Professor p=new Professor();
    private ProfessorManenger pm=new ProfessorManenger();
    /**
     * Creates new form ControleProfessor
     */
    public ControleProfessor() {
        initComponents();
        ButAlterar.setVisible(false);
        ButExcluir.setVisible(false);
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
        TextNome = new javax.swing.JTextField();
        ButCadastro = new javax.swing.JButton();
        ButPesquisar = new javax.swing.JButton();
        ButAlterar = new javax.swing.JButton();
        ButExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        TextNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ButCadastro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButCadastro.setText("Cadastrar");
        ButCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCadastroActionPerformed(evt);
            }
        });

        ButPesquisar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButPesquisar.setText("Pesquisar");
        ButPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButPesquisarActionPerformed(evt);
            }
        });

        ButAlterar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButAlterar.setText("Alterar");
        ButAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAlterarActionPerformed(evt);
            }
        });

        ButExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(TextNome))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ButPesquisar)
                                .addGap(144, 144, 144)
                                .addComponent(ButExcluir)
                                .addGap(0, 46, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ButCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButAlterar)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButCadastro)
                    .addComponent(ButAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButPesquisar)
                    .addComponent(ButExcluir))
                .addContainerGap())
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

    private void ButCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCadastroActionPerformed
        
        p.setNome(TextNome.getText());
        pm.cadastrar(p);
    }//GEN-LAST:event_ButCadastroActionPerformed

    private void ButPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButPesquisarActionPerformed
        p=pm.consultar(TextNome.getText());
        if(p.getNome()!=null){
            TextNome.setText(p.getNome());
            ButAlterar.setVisible(true);
            ButExcluir.setVisible(true);
        }
        
    }//GEN-LAST:event_ButPesquisarActionPerformed

    private void ButExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButExcluirActionPerformed
        int resposta=JOptionPane.showConfirmDialog(null, "Tem certeza que quer deletar?\nSerá excluido permanentemente", "Exclusão", JOptionPane.YES_NO_OPTION);
        if(resposta==JOptionPane.YES_OPTION) {
            
            String respost=JOptionPane.showInputDialog(null, "Escreva 'deletar' \nignorar maiusculo e minusculo", "Confirmação", JOptionPane.QUESTION_MESSAGE);
            if(respost.equalsIgnoreCase("deletar")){
        pm.Excluir(p);
        ButAlterar.setVisible(false);
        ButExcluir.setVisible(false);
            }}
    }//GEN-LAST:event_ButExcluirActionPerformed

    private void ButAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButAlterarActionPerformed
       int resposta=JOptionPane.showConfirmDialog(null, "Tem certeza que quer subistituir?\nOs dados serão trocatos permanentemente", "Alteração", JOptionPane.YES_NO_OPTION);
        if(resposta==JOptionPane.YES_OPTION) {
            
            String respost=JOptionPane.showInputDialog(null, "Escreva 'sim' \nignorar maiusculo e minusculo", "Confirmação", JOptionPane.QUESTION_MESSAGE);
            if(respost.equalsIgnoreCase("sim")){
        p.setNome(TextNome.getText());
        pm.Alterar(p);
        ButAlterar.setVisible(false);
        ButExcluir.setVisible(false);
            }}
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
            java.util.logging.Logger.getLogger(ControleProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButAlterar;
    private javax.swing.JButton ButCadastro;
    private javax.swing.JButton ButExcluir;
    private javax.swing.JButton ButPesquisar;
    private javax.swing.JTextField TextNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
