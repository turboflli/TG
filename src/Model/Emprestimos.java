/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.FdfReader;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class Emprestimos {
    private Connection con=new Conexao().conectar();
    private int id,aluno,livro1,livro2,pendentes,multa;
    private String datarealizacao,dataDevolucao,dataPagamento;

    

    /**
     * @return the aluno
     */
    public int getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the livro1
     */
    public int getLivro1() {
        return livro1;
    }

    /**
     * @param livro1 the livro1 to set
     */
    public void setLivro1(int livro1) {
        this.livro1 = livro1;
    }

    /**
     * @return the livro2
     */
    public int getLivro2() {
        return livro2;
    }

    /**
     * @param livro2 the livro2 to set
     */
    public void setLivro2(int livro2) {
        this.livro2 = livro2;
    }

    /**
     * @return the pendente
     */
    public int getPendentes() {
        return pendentes;
    }

    /**
     * @param pendente the pendente to set
     */
    public void setPendentes(int pendentes) {
        this.pendentes = pendentes;
    }

    /**
     * @return the datarealizacao
     */
    public String getDatarealizacao() {
        return datarealizacao;
    }

    /**
     * @param datarealizacao the datarealizacao to set
     */
    public void setDatarealizacao(String datarealizacao) {
        this.datarealizacao = datarealizacao;
    }

    /**
     * @return the dataDevolucao
     */
    public String getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public void cadastrar(int p){
        if(p==3){
          try {
              int q1,q2;
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select quantidade from livro where id="+this.livro1);
                rs.next();
                q1=rs.getInt("quantidade");
                if(q1==0){
                    JOptionPane.showMessageDialog(null, "Livro 1 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                }else {
                    rs=stm.executeQuery("select quantidade from livro where id="+this.livro2);
                    rs.next();
                    q2=rs.getInt("quantidade");
                    if(q2==0){
                        JOptionPane.showMessageDialog(null, "Livro 2 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                    }else {
                        stm.execute("insert into emprestimo(aluno,livro1,livro2,pendentes,dataRealizacao,dataDevolucao) "
                                + "values("+this.aluno+","+this.livro1+","+this.livro2+","+p+",'"+this.datarealizacao+"','"+this.dataDevolucao+"')");
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                        q1-=1;q2-=1;
                        stm.execute("update livro set quantidade="+q1+" where id="+livro1);
                        stm.execute("update livro set quantidade="+q2+" where id="+livro2);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Emprestimos.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }else {
            try{
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select quantidade from livro where id="+this.livro1);
                    rs.next();
                    int q=rs.getInt("quantidade");
                    if(q==0){
                        JOptionPane.showMessageDialog(null, "Livro 1 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                    }else {
                        stm.execute("insert into emprestimo(aluno,livro1,pendentes,dataRealizacao,dataDevolucao) "
                                + "values("+this.aluno+","+this.livro1+","+p+",'"+this.datarealizacao+"','"+this.dataDevolucao+"')");
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                        q-=1;
                        stm.execute("update livro set quantidade="+q+" where id="+livro1);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Emprestimos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public String descobrirAluno(String nome){
        Statement stm;
        String nom="";
        int u=0;
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select id,nome from aluno where upper(nome) like upper('%"+nome+"%')");
            
            while(rs.next()){
                u++;
                this.aluno=rs.getInt("id");
                nom=rs.getString("nome");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(u<=1){
        return nom;
        }else{
            JOptionPane.showMessageDialog(null, u+" Registros encontrados\n pequise por nome completo\nultimo foi selecionado", "Mais de um", JOptionPane.INFORMATION_MESSAGE);
            return nom;
        }

    }
    
    public void descobrirLivro1(String titulo,String autor){
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from livro where titulo='"+titulo+"' and autor='"+autor+"'");
            
            while(rs.next()){
                this.livro1=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void descobrirLivro2(String titulo,String autor){
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from livro where titulo='"+titulo+"' and autor='"+autor+"'");
            
            while(rs.next()){
                this.livro2=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<String> listarTitulo(String tirulo){
        ArrayList<String> titulos=new ArrayList<String>();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select titulo,autor from livro where upper(titulo) like upper('%"+tirulo+"%')");
            while(rs.next()){
                titulos.add(rs.getString("titulo")+"¬"+rs.getString("autor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return titulos;
    }

    /**
     * @return the multa
     */
    public int getMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(int multa) {
        this.multa = multa;
    }

    /**
     * @return the dataPagamento
     */
    public String getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
     
     
   
    
}
