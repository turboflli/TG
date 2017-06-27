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
public class AlunoManager {
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
    
    public static Aluno consultar(String busca,String coluna){
        Statement stm;
        
        ArrayList<Aluno> todos=new ArrayList<Aluno>();
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select * from aluno where upper("+coluna+") like upper('%"+busca+"%')");
            
            while(rs.next()){
                Aluno a=new Aluno(rs.getInt("id"),rs.getString("nome"),rs.getString("rg"),rs.getString("ra"),rs.getString("email"),
                        rs.getString("telefone"),rs.getString("curso"),rs.getInt("semestre"),rs.getInt("periodo"));
                todos.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(todos.size()==0){
            return null;
        }else if(todos.size()==1){
            return todos.get(0);
        }else{
            String nomes="";
            int cont=1;
            for(Aluno a:todos){
                nomes+=(cont++)+". "+a.getNome()+"\n";
            }
            
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
    
    
}
