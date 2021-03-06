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
public class ProfessorManager {
     private static Connection con=new Conexao().conectar();
    public static void cadastrar(Professor p){
         try {
            Statement stm=con.createStatement();
            stm.execute("insert into professor(nome) values('"+p.getNome()+"')");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Por favor anote e me passe: \n"+ex.getErrorCode(),"Erro",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void Alterar(Professor p){
         try {
            Statement stm=con.createStatement();
            stm.execute("update professor set nome ='"+p.getNome()+"' where id="+p.getId());
            JOptionPane.showMessageDialog(null, "Alteração feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void Excluir(Professor p){
        try {
            Statement stm=con.createStatement();
            stm.execute("delete from professor where id="+p.getId());
             JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Professor consultar(String name){
        
        Statement stm;
        ArrayList<Professor> todos=new ArrayList<>();
         try {
             stm = con.createStatement();
             ResultSet rs=stm.executeQuery("select * from professor where upper(nome) like upper('%"+name+"%')");
             while(rs.next()){
                 Professor p=new Professor();
                 p.setId(rs.getInt("id"));
                 p.setNome(rs.getString("nome"));
                 todos.add(p);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
         }
        if(todos.size()==0){
            return null;
        }else if(todos.size()==1){
            return todos.get(0);
        }else{
            String nomes="";
            int cont=1;
            for(Professor p:todos){nomes+=(cont++)+". "+p.getNome()+"\n";}
            try{
                String resp=JOptionPane.showInputDialog(null, todos.size()+" Registros encontrados\n"+nomes, "Mais de um", JOptionPane.INFORMATION_MESSAGE);
                if(resp!=null){
                    int indice=Integer.parseInt(resp)-1;
                    if(indice>=0 && indice<todos.size()){
                        return todos.get(indice);
                    }
                }
            }catch(NumberFormatException e){}
            
        }
        return todos.get(0);
    }
}
