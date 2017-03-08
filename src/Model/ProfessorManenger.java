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
public class ProfessorManenger {
     private Connection con=new Conexao().conectar();
    public void cadastrar(Professor p){
         try {
            Statement stm=con.createStatement();
            stm.execute("insert into professor(nome) values('"+p.getNome()+"')");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Alterar(Professor p){
         try {
            Statement stm=con.createStatement();
            stm.execute("update professor set nome ='"+p.getNome()+"' where id="+p.getId());
            JOptionPane.showMessageDialog(null, "Alteração feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Excluir(Professor p){
        try {
            Statement stm=con.createStatement();
            stm.execute("delete from professor where id="+p.getId());
             JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Professor consultar(String name){
        Professor p=new Professor();
        Statement stm;
        int u=0;
         try {
             stm = con.createStatement();
             ResultSet rs=stm.executeQuery("select * from professor where upper(nome) like upper('%"+name+"%')");
             while(rs.next()){
                 p.setId(rs.getInt("id"));
                 p.setNome(rs.getString("nome"));
                 u++;
             }
         } catch (SQLException ex) {
             Logger.getLogger(ProfessorManenger.class.getName()).log(Level.SEVERE, null, ex);
         }
        if(u==0){
            JOptionPane.showMessageDialog(null,"nenhum professor encontrado","Vazio",JOptionPane.ERROR_MESSAGE);
        }else if(u>1){
            JOptionPane.showMessageDialog(null,u+" Registro foram encontrados\n pesquise por nome mais completo\nultimo foi selecionado","Vario",JOptionPane.INFORMATION_MESSAGE);
        }
        return p;
    }
}
