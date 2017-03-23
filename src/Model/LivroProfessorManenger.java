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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class LivroProfessorManenger {
    private Connection con=new Conexao().conectar();
    public void cadastrar(LivroProfessor lp){
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select quantidade from livro where id="+lp.getLiv());
            rs.next();
            int q=rs.getInt("quantidade");
            if(q==0){
                JOptionPane.showMessageDialog(null, "Livro  indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
            }else{
                stm.execute("insert into livrosprofessor(idprofessor,idlivro,dataRealizacao) values ("+lp.getProf()+","+lp.getLiv()+",'"+lp.getData()+"')");
                q--;
                stm.execute("update livro set quantidade="+q+" where id="+lp.getLiv());
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /*public void excluir(LivroProfessor lp){
         try {
            Statement stm=con.createStatement();
            stm.execute("delete from livrosprofessor where idprofessor="+lp.getProf()+" and idlivro="+lp.getLiv());
            JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    /*public void alterar(LivroProfessor lp){
        try {
            Statement stm=con.createStatement();
            stm.execute("update from livrosprofessor set idprofessor="+lp.getProf()+", idlivro="+lp.getLiv()+",dataRealizacao='"+lp.getData()+"' where idprofessor="+lp.getProf()+" and idlivro="+lp.getLiv());
            JOptionPane.showMessageDialog(null, "Alteração feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    
    public int descobrirProfessor(String nome){
        int resp=0;
        
            Statement stm;
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select id from professor where nome='"+nome+"'");
            while(rs.next()){
                resp=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return resp;
    }
    
    //retorna o nome completo de um professor pesquisando por um pedaço
    public String listarProfessores(String nome){
        String nom="";
        int u=0;
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select nome from professor where upper(nome) like upper('%"+nome+"%')");
            while(rs.next()){
                u++;
                nom=rs.getString("nome");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(u>1){
            JOptionPane.showMessageDialog(null, u+" Registros encontrados\n pequise por nome completo\nultimo foi selecionado", "Mais de um", JOptionPane.INFORMATION_MESSAGE);
            return nom;
        }else{
            return nom;
        }
    }
    
    public void devolverLivro(LivroProfessor lp){
        try {
            Statement stm=con.createStatement();
            stm.execute("update livrosprofessor set devolvido=true where idprofessor="+lp.getProf()+" and idlivro="+lp.getLiv());
            ResultSet rs=stm.executeQuery("select quantidade from livro where id="+lp.getLiv());
            rs.next();
            int q=rs.getInt("quantidade");
            q++;
            stm.execute("update livro set quantidade="+q+" where id="+lp.getLiv());
            JOptionPane.showMessageDialog(null, "Devolvido com sucesso","Devolvido",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ArrayList<String> listarLivros(int id){
        ArrayList<String> lista=new ArrayList<String>();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select l.titulo as tit,l.autor as aut from livro l inner join livrosprofessor e on e.devolvido=false and e.idprofessor="+id+" and e.idlivro=l.id");
            while(rs.next()){
                lista.add(rs.getString("tit")+"¬"+rs.getString("aut"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int descobrirLivro(String titulo,String autor){
        int u=0;
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select id from livro where titulo='"+titulo+"' and autor='"+autor+"'");
            while(rs.next()){
               u=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}
