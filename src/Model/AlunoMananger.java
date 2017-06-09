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
public class AlunoMananger {
    private static Connection con=new Conexao().conectar();
    
     public static void cadastrar(Aluno a){
        try {
            Statement stm=con.createStatement();
            stm.execute("insert into aluno(nome,rg,ra,email,telefone,curso,semestre,periodo) values"
                    + "('"+a.getNome()+"','"+a.getRg()+"','"+a.getRa()+"','"+a.getEmail()+"','"+a.getTelefone()+"','"+a.getCurso()+"',"+a.getSemestre()+","+a.getPeriodo()+")");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static Aluno consultarPorNome(String nome){
        Statement stm;
        int u=0;
        Aluno a=new Aluno();
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select * from aluno where upper(nome) like upper('%"+nome+"%')");
            
            while(rs.next()){
                u++;
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setRg(rs.getString("rg"));
                a.setRa(rs.getString("ra"));
                a.setEmail(rs.getString("email"));
                a.setTelefone(rs.getString("telefone"));
                a.setCurso(rs.getString("curso"));
                a.setSemestre(rs.getInt("semestre"));
                a.setPeriodo(rs.getInt("periodo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(u==0){
            return null;
        }else if(u==1){

        }else{
            JOptionPane.showMessageDialog(null, u+" Registros encontrados\n pequise por outro campo", "Mais de um", JOptionPane.INFORMATION_MESSAGE);
        }
        return a;
    }
    
    public static void deletar(Aluno a){
        try {
            Statement stm=con.createStatement();
            stm.execute("delete from aluno where id="+a.getId());
            JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void atualizar(Aluno a){
        try {
            Statement stm=con.createStatement();
            stm.execute("update aluno set nome='"+a.getNome()+"',rg='"+a.getRg()+"',ra='"+a.getRa()+"',email='"+a.getEmail()+"',telefone='"+a.getTelefone()+"'"
                    + ",curso='"+a.getCurso()+"',semestre="+a.getSemestre()+",periodo="+a.getPeriodo()+" where id="+a.getId());
            JOptionPane.showMessageDialog(null, "Alteração feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Aluno consultarPorRa(String ra){
        Statement stm;
        Aluno a=new Aluno();
        int u=0;
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select * from aluno where ra='"+ra+"'");
            
            while(rs.next()){
                u++;
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setRg(rs.getString("rg"));
                a.setRa(rs.getString("ra"));
                a.setEmail(rs.getString("email"));
                a.setTelefone(rs.getString("telefone"));
                a.setCurso(rs.getString("curso"));
                a.setSemestre(rs.getInt("semestre"));
                a.setPeriodo(rs.getInt("periodo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(u==0){
        return null;
        }else{
            return a;
        }
    }
}