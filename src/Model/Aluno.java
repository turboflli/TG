/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class Aluno {
    private String nome,rg,email,ra,telefone,curso;
    private int id,semestre,periodo;
    
    private Connection con=new Conexao().conectar();
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ra
     */
    public String getRa() {
        return ra;
    }

    /**
     * @param ra the ra to set
     */
    public void setRa(String ra) {
        this.ra = ra;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    public void cadastrar(){
        try {
            Statement stm=con.createStatement();
            stm.execute("insert into aluno(nome,rg,ra,email,telefone,curso,semestre,periodo) values"
                    + "('"+this.nome+"','"+this.rg+"','"+this.ra+"','"+this.email+"','"+this.telefone+"','"+this.curso+"',"+this.semestre+","+this.periodo+")");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean consultarPorNome(String nome){
        Statement stm;
        int u=0;
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select * from aluno where upper(nome) like upper('%"+nome+"%')");
            
            while(rs.next()){
                u++;
                this.id=rs.getInt("id");
                this.nome=rs.getString("nome");
                this.rg=rs.getString("rg");
                this.ra=rs.getString("ra");
                this.email=rs.getString("email");
                this.telefone=rs.getString("telefone");
                this.curso=rs.getString("curso");
                this.semestre=rs.getInt("semestre");
                this.periodo=rs.getInt("periodo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(u==0){
        return false;
        }else if(u==1){
        return true;
        }else{
            JOptionPane.showMessageDialog(null, u+" Registros encontrados\n pequise por outro campo", "Mais de um", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
    
    public void deletar(){
        try {
            Statement stm=con.createStatement();
            stm.execute("delete from aluno where id="+this.id);
            JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(){
        try {
            Statement stm=con.createStatement();
            stm.execute("update aluno set nome='"+this.nome+"',rg='"+this.rg+"',ra='"+this.ra+"',email='"+this.email+"',telefone='"+this.telefone+"'"
                    + ",curso='"+this.curso+"',semestre="+this.semestre+",periodo="+this.periodo+" where id="+this.id);
            JOptionPane.showMessageDialog(null, "Alteração feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean consultarPorRa(String ra){
        Statement stm;
        int u=0;
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select * from aluno where ra='"+ra+"'");
            
            while(rs.next()){
                u++;
                this.id=rs.getInt("id");
                this.nome=rs.getString("nome");
                this.rg=rs.getString("rg");
                this.ra=rs.getString("ra");
                this.email=rs.getString("email");
                this.telefone=rs.getString("telefone");
                this.curso=rs.getString("curso");
                this.semestre=rs.getInt("semestre");
                this.periodo=rs.getInt("periodo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(u==0){
        return false;
        }else{
            return true;
        }
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the periodo
     */
    public int getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    
}
