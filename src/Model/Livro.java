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
public class Livro {
    int id;
    private int quantidade;
    private int edicao;
    private String titulo;
    private String autor;
    private String editora;
    private Connection con=new Conexao().conectar();
    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the edicao
     */
    public int getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    public void cadastrar(){
        try {
            Statement stm=con.createStatement();
            stm.execute("insert into livro(titulo,autor,editora,quantidade,edicao) "
                    + "values('"+this.titulo+"','"+this.autor+"','"+this.editora+"',"+this.quantidade+","+this.edicao+")");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deletar(){
        try {
            Statement stm=con.createStatement();
            stm.execute("delete from livro where id="+this.id);
            JOptionPane.showMessageDialog(null, "Exclusão feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pesquisar(String titulo,String autor){
        
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from livro where titulo='"+titulo+"' and autor='"+autor+"'");
            
            while(rs.next()){
                this.id=rs.getInt("id");
                this.titulo=rs.getString("titulo");
                this.autor=rs.getString("autor");
                this.editora=rs.getString("editora");
                this.quantidade=rs.getInt("quantidade");
                this.edicao=rs.getInt("edicao");
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
    
    public ArrayList<String> listarAutor(String autor){
        ArrayList<String> autores=new ArrayList<String>();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select titulo,autor from livro where upper(autor) like upper('%"+autor+"%')");
            while(rs.next()){
                autores.add(rs.getString("titulo")+"¬"+rs.getString("autor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return autores;
    }

    public void atualizar() {
        try {
            Statement stm=con.createStatement();
            stm.execute("update livro set titulo='"+this.titulo+"',autor='"+this.autor+"',editora='"+this.editora+"',quantidade="+this.quantidade+",edicao="+this.edicao+" where id="+this.id);
            JOptionPane.showMessageDialog(null, "Alteração feita com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
