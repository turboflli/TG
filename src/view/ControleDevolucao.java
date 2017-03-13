/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.EmprestimoManenger;
import Model.Emprestimos;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ControleDevolucao extends javax.swing.JFrame {
    private ArrayList<Emprestimos> listaEmprestimos;
    private Emprestimos e;
    private GregorianCalendar calen;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    /**
     * Creates new form ControleDevolucao
     */
    public ControleDevolucao() {
        initComponents();
        e=new Emprestimos();
        calen=new GregorianCalendar();
        ButLivro1.setVisible(false);
        ButLivro2.setVisible(false);
        lLivro1.setVisible(false);
        lLivro2.setVisible(false);
        lRealizacao.setVisible(false);
        lDevolucao.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        TextMulta.setVisible(false);
        ButPagar.setVisible(false);
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
        lRealizacao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lDevolucao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ButPagar = new javax.swing.JButton();
        TextNome = new javax.swing.JTextField();
        TextMulta = new javax.swing.JFormattedTextField();
        jComboBox1 = new javax.swing.JComboBox();
        lLivro1 = new javax.swing.JLabel();
        lLivro2 = new javax.swing.JLabel();
        ButLivro1 = new javax.swing.JButton();
        ButLivro2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 46, 51), 14), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 217, 217), 8)));

        lRealizacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lRealizacao.setText("00/00/0000");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("-");

        lDevolucao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lDevolucao.setText("00/00/0000");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Multa:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Nome:");

        ButPagar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/coin.png"))); // NOI18N
        ButPagar.setText("Pagar");
        ButPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButPagarActionPerformed(evt);
            }
        });

        TextNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextNomeKeyPressed(evt);
            }
        });

        try {
            TextMulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextMulta.setText("00");
        TextMulta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        lLivro1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lLivro1.setText("jLabel1");

        lLivro2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lLivro2.setText("jLabel2");

        ButLivro1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButLivro1.setText("Devolver");
        ButLivro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButLivro1ActionPerformed(evt);
            }
        });

        ButLivro2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButLivro2.setText("Devolver");
        ButLivro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButLivro2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ButLivro2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButLivro1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lLivro2)
                            .addComponent(lLivro1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButPagar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lRealizacao)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lDevolucao)))
                        .addGap(239, 239, 239)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lLivro1)
                    .addComponent(ButLivro1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButLivro2)
                    .addComponent(lLivro2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRealizacao)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lDevolucao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButPagar)
                    .addComponent(TextMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextNomeKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            String h=e.descobrirAluno(TextNome.getText());
            if(h.length()>0){
                TextNome.setText(h);
                listaEmprestimos=EmprestimoManenger.returnaTodos(TextNome.getText());
                jComboBox1.removeAllItems();
                for(int u=0;u<listaEmprestimos.size();u++){
                 jComboBox1.addItem(listaEmprestimos.get(u).getId());
                }
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado","Vazio",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_TextNomeKeyPressed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(jComboBox1.getItemCount()>0){
            
            Emprestimos escolhido=listaEmprestimos.get(jComboBox1.getSelectedIndex());
            if(escolhido.getPendentes()==3 ){
                lLivro1.setText(EmprestimoManenger.getLivro(escolhido.getLivro1()));
                lLivro2.setText(EmprestimoManenger.getLivro(escolhido.getLivro2()));
                lLivro1.setVisible(true);
                lLivro2.setVisible(true);
                ButLivro1.setVisible(true);
                ButLivro2.setVisible(true);
            }else if(escolhido.getPendentes()==1){
                lLivro1.setText(EmprestimoManenger.getLivro(escolhido.getLivro1()));
                lLivro1.setVisible(true);
                ButLivro1.setVisible(true);
                lLivro2.setVisible(false);
                ButLivro2.setVisible(false);
            }else if(escolhido.getPendentes()==2){
                lLivro2.setText(EmprestimoManenger.getLivro(escolhido.getLivro2()));
                lLivro2.setVisible(true);
                ButLivro2.setVisible(true);
                lLivro1.setVisible(false);
                ButLivro1.setVisible(false);
            }else{
                ButLivro1.setVisible(false);
                ButLivro2.setVisible(false);
                lLivro1.setVisible(false);
                lLivro2.setVisible(false);
            }
            String data=escolhido.getDatarealizacao();
            data=data.substring(0, 2)+"/"+data.substring(2, 4)+"/"+data.substring(4);
            lRealizacao.setText(data);
            data=escolhido.getDataDevolucao();
            data=data.substring(0, 2)+"/"+data.substring(2, 4)+"/"+data.substring(4);
            lDevolucao.setText(data);
            lRealizacao.setVisible(true);
            lDevolucao.setVisible(true);
            jLabel1.setVisible(true);
            Date tempo;
            Date hoje;
            try {
                
                tempo = formato.parse(data);
                calen=new GregorianCalendar();
                hoje=calen.getTime();
                data=formato.format(hoje);
                hoje=formato.parse(data);
                if(hoje.after(tempo)){
                    multar();
                    escolhido.setMulta(Integer.parseInt(TextMulta.getText()));
                    EmprestimoManenger.multar(escolhido);
            }else{
                    jLabel2.setVisible(false);
                TextMulta.setVisible(false);
                ButPagar.setVisible(false);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControleDevolucao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void ButLivro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButLivro1ActionPerformed
        Emprestimos escolhido=listaEmprestimos.get(jComboBox1.getSelectedIndex());
        EmprestimoManenger.devolver1(escolhido);
        ButLivro1.setVisible(false);
        lLivro1.setVisible(false);
    }//GEN-LAST:event_ButLivro1ActionPerformed

    private void ButLivro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButLivro2ActionPerformed
        Emprestimos escolhido=listaEmprestimos.get(jComboBox1.getSelectedIndex());
        EmprestimoManenger.devolver2(escolhido);
        ButLivro2.setVisible(false);
        lLivro2.setVisible(false);
    }//GEN-LAST:event_ButLivro2ActionPerformed

    private void ButPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButPagarActionPerformed
        Emprestimos escolhido=listaEmprestimos.get(jComboBox1.getSelectedIndex());
        escolhido.setMulta(Integer.parseInt(TextMulta.getText()));
        calen= new GregorianCalendar();
        escolhido.setDataPagamento(formato.format(calen.getTime()).replace("/", ""));
        EmprestimoManenger.pagar(escolhido);
        jLabel2.setVisible(false);
        TextMulta.setVisible(false);
        ButPagar.setVisible(false);
    }//GEN-LAST:event_ButPagarActionPerformed

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
            java.util.logging.Logger.getLogger(ControleDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleDevolucao().setVisible(true);
            }
        });
    }

    
    
    private void multar(){
        jLabel2.setVisible(true);
        TextMulta.setVisible(true);
        ButPagar.setVisible(true);
        int days=0;
        Date tempo;
            Date hoje;
            try {
                tempo = formato.parse(lDevolucao.getText());
                hoje=calen.getTime();
                String temp=formato.format(hoje);
                hoje=formato.parse(temp);
                while(hoje.compareTo(tempo)==1){
                    calen.setTime(tempo);
                    calen.add(Calendar.DAY_OF_YEAR, 1);
                    tempo=calen.getTime();
                    if(tempo.getDay()!=0 && tempo.getDay()!=6){days++;}//exclui sabados e domingos
                }
                
                if(days>9){
                    TextMulta.setText(Integer.toString(days));
                }else{
                    TextMulta.setText("0"+Integer.toString(days));
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControleDevolucao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButLivro1;
    private javax.swing.JButton ButLivro2;
    private javax.swing.JButton ButPagar;
    private javax.swing.JFormattedTextField TextMulta;
    private javax.swing.JTextField TextNome;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lDevolucao;
    private javax.swing.JLabel lLivro1;
    private javax.swing.JLabel lLivro2;
    private javax.swing.JLabel lRealizacao;
    // End of variables declaration//GEN-END:variables
}
