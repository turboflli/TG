package view;

import Model.Aluno;
import Model.AlunoManager;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class ControleAluno extends javax.swing.JFrame {
    private Aluno a;
    
    /**
     * Creates new form ControleAluno
     */
    public ControleAluno() {
        initComponents();
        ButExcluir.setVisible(false);
        ButAlterar.setVisible(false);
        a=new Aluno();
       //System.load("E:/open/opencv/build/java/x86/opencv_java2410.dll");
        //JOptionPane.showMessageDialog(null, System.getProperty("sun.arch.data.model"));
        if(System.getProperty("sun.arch.data.model").equals("32")){
        System.load(System.getProperty("user.dir")+"\\opencv_java241032.dll");
        }else if(System.getProperty("sun.arch.data.model").equals("64")){
        System.load(System.getProperty("user.dir")+"\\opencv_java241064.dll");    
        }
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ButGravar = new javax.swing.JButton();
        ButExcluir = new javax.swing.JButton();
        ButAlterar = new javax.swing.JButton();
        TextNome = new javax.swing.JTextField();
        TextRG = new javax.swing.JFormattedTextField();
        TextEmail = new javax.swing.JTextField();
        ButPesquisarN = new javax.swing.JButton();
        TextRal = new javax.swing.JFormattedTextField();
        TextTelefone = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        ButPesquisarR = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextCurso = new javax.swing.JTextField();
        TextSemestre = new javax.swing.JFormattedTextField();
        ComboPeriodo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Alunos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 46, 51), 14), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 217, 217), 8)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("RG:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("RA:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("E-mail:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Telefone:");

        ButGravar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Chest.gif"))); // NOI18N
        ButGravar.setText("Gravar");
        ButGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButGravarActionPerformed(evt);
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

        ButAlterar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pena.png"))); // NOI18N
        ButAlterar.setText("Alterar");
        ButAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAlterarActionPerformed(evt);
            }
        });

        TextNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        try {
            TextRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-A")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextRG.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TextEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextEmail.setText("@fatec.sp.gov.br");

        ButPesquisarN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButPesquisarN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        ButPesquisarN.setText("Pesquisar");
        ButPesquisarN.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ButPesquisarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButPesquisarNActionPerformed(evt);
            }
        });

        try {
            TextRal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###.#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextRal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        try {
            TextTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextTelefone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/banner.png"))); // NOI18N
        jButton1.setText("identificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ButPesquisarR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButPesquisarR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        ButPesquisarR.setText("Pesquisar");
        ButPesquisarR.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ButPesquisarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButPesquisarRActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Curso:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Semestre:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Periodo:");

        TextCurso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        try {
            TextSemestre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextSemestre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextSemestre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextSemestreFocusLost(evt);
            }
        });

        ComboPeriodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manha", "Tarde", "Noite" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButGravar, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ButExcluir)
                .addGap(18, 18, 18)
                .addComponent(ButAlterar)
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextRG, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextRal, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButPesquisarR)
                            .addComponent(ButPesquisarN)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TextCurso, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TextEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                    .addComponent(TextSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButPesquisarN))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ButPesquisarR)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextRal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ComboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButGravar)
                    .addComponent(ButExcluir)
                    .addComponent(ButAlterar)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
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

    private void ButPesquisarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButPesquisarNActionPerformed
        a=AlunoManager.consultar(TextNome.getText(),"nome");
        if(a!=null) {
            TextNome.setText(a.getNome());
            TextRG.setText(a.getRg());
            TextRal.setText(a.getRa());
            TextEmail.setText(a.getEmail());
            TextTelefone.setText(a.getTelefone());
            TextCurso.setText(a.getCurso());
            if(a.getSemestre()>9){
                TextSemestre.setText(Integer.toString(a.getSemestre()));
            }else{
                TextSemestre.setText("0"+Integer.toString(a.getSemestre()));
            }
            ComboPeriodo.setSelectedIndex(a.getPeriodo()-1);
            ButExcluir.setVisible(true);
            ButAlterar.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Nome não encontrado","Vazio",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButPesquisarNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VideoCapture cam=new VideoCapture(0);
        Mat frame= new Mat();
        cam.open(0);
        cam.read(frame);
        Highgui.imwrite("qr.png",frame);
        cam.release();
        BufferedImage img = null;
        Result res=null;
        try {
            img=ImageIO.read(new FileInputStream("qr.png"));
            BinaryBitmap map=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(img)));
            res=new MultiFormatReader().decode(map);
            String resultado=res.getText();
            //JOptionPane.showMessageDialog(null, res.getText());
            TextNome.setText(resultado.split("\n")[0]);
            TextRG.setText(resultado.split("\n")[1]);
            TextRal.setText(resultado.split("\n")[2]);
            File f=new File("qr.png");
            f.delete();
            
        } catch (FileNotFoundException ex) {
            System.out.println("aqui");
            //Logger.getLogger(ControleAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControleAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(ControleAluno.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ButGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButGravarActionPerformed
       a.setNome(TextNome.getText());
       a.setRg(TextRG.getText().replace(".", "").replace("-",""));
       a.setRa(TextRal.getText().replace(".", ""));
       a.setEmail(TextEmail.getText());
       a.setTelefone(TextTelefone.getText().replace("-", "").replace("(", "").replace(")",""));
       a.setCurso(TextCurso.getText());
       a.setSemestre(Integer.parseInt(TextSemestre.getText().trim()));
       a.setPeriodo(ComboPeriodo.getSelectedIndex()+1);
       AlunoManager.cadastrar(a);
    }//GEN-LAST:event_ButGravarActionPerformed

    private void ButPesquisarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButPesquisarRActionPerformed
        a=AlunoManager.consultar(TextRal.getText().replace(".", ""),"ra");
        if(a!=null ) {
            TextRG.setText(a.getRg());
            TextNome.setText((a.getNome()));
            TextEmail.setText(a.getEmail());
            TextTelefone.setText(a.getTelefone());
            TextCurso.setText(a.getCurso());
            if(a.getSemestre()>9){
                TextSemestre.setText(Integer.toString(a.getSemestre()));
            }else{
                TextSemestre.setText("0"+Integer.toString(a.getSemestre()));
            }
            ComboPeriodo.setSelectedIndex(a.getPeriodo()-1);
            ButExcluir.setVisible(true);
            ButAlterar.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"RA não encontrado","Vazio",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButPesquisarRActionPerformed

    private void ButExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButExcluirActionPerformed
        int resposta=JOptionPane.showConfirmDialog(null, "Tem certeza que quer deletar?\nSerá excluido permanentemente", "Exclusão", JOptionPane.YES_NO_OPTION);
        if(resposta==JOptionPane.YES_OPTION) {
            
            String respost=JOptionPane.showInputDialog(null, "Escreva 'deletar' \nignorar maiusculo e minusculo", "Confirmação", JOptionPane.QUESTION_MESSAGE);
            if(respost.equalsIgnoreCase("deletar")){
                AlunoManager.deletar(a);
                a=new Aluno();
                TextNome.setText("");
                TextRG.setText("");
                TextRal.setText("");
                TextEmail.setText("@fatec.sp.gov.br");
                TextTelefone.setText("");
                TextCurso.setText("");
                TextSemestre.setText("");
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
                a.setNome(TextNome.getText());
                a.setRg(TextRG.getText().replace(".", "").replace("-",""));
                a.setRa(TextRal.getText().replace(".", ""));
                a.setEmail(TextEmail.getText());
                a.setTelefone(TextTelefone.getText().replace("-", "").replace("(", "").replace(")",""));
                a.setCurso(TextCurso.getText());
                a.setSemestre(Integer.parseInt(TextSemestre.getText().trim()));
                a.setPeriodo(ComboPeriodo.getSelectedIndex()+1);
                AlunoManager.atualizar(a);
                a=new Aluno();
                TextNome.setText("");
                TextRG.setText("");
                TextRal.setText("");
                TextEmail.setText("@fatec.sp.gov.br");
                TextTelefone.setText("");
                TextCurso.setText("");
                TextSemestre.setText("");
                ButAlterar.setVisible(false);
                ButExcluir.setVisible(false);
            }
        }
    }//GEN-LAST:event_ButAlterarActionPerformed

    private void TextSemestreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextSemestreFocusLost
        if(TextSemestre.getText().substring(1).equals(" ")){
            TextSemestre.setText("0"+TextSemestre.getText());
        }
        if(TextSemestre.getText().substring(0,1).equals(" ") && !TextSemestre.getText().substring(1).equals(" ")){
            TextSemestre.setText(TextSemestre.getText()+"0");
        }
    }//GEN-LAST:event_TextSemestreFocusLost

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
            java.util.logging.Logger.getLogger(ControleAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButAlterar;
    private javax.swing.JButton ButExcluir;
    private javax.swing.JButton ButGravar;
    private javax.swing.JButton ButPesquisarN;
    private javax.swing.JButton ButPesquisarR;
    private javax.swing.JComboBox ComboPeriodo;
    private javax.swing.JTextField TextCurso;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextNome;
    private javax.swing.JFormattedTextField TextRG;
    private javax.swing.JFormattedTextField TextRal;
    private javax.swing.JFormattedTextField TextSemestre;
    private javax.swing.JFormattedTextField TextTelefone;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
