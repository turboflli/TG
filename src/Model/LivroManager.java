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
public class LivroManager {
    private static Connection con=new Conexao().conectar();
     public static void cadastrar(Livro l){
        try {
            Statement stm=con.createStatement();
            stm.execute("insert into livro(titulo,autor,editora,quantidade,edicao) "
                    + "values('"+l.getTitulo()+"','"+l.getAutor()+"','"+l.getEditora()+"',"+l.getQuantidade()+","+l.getEdicao()+")");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void deletar(Livro l){
        try {
            Statement stm=con.createStatement();
            stm.execute("delete from livro where id="+l.getId());
            JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Livro pesquisar(String titulo,String autor){
        Livro l=new Livro();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from livro where titulo='"+titulo+"' and autor='"+autor+"'");
            
            while(rs.next()){
                l=new Livro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"),rs.getString("editora"),rs.getInt("quantidade"),rs.getInt("edicao"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    
    
    

    public static void atualizar(Livro l) {
        try {
            Statement stm=con.createStatement();
            stm.execute("update livro set titulo='"+l.getTitulo()+"',autor='"+l.getAutor()+"',editora='"+l.getEditora()+"',quantidade="+l.getQuantidade()+",edicao="+l.getEdicao()+" where id="+l.getId());
            JOptionPane.showMessageDialog(null, "Alteração feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
