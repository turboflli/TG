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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class LivroProfessorManager {
    private static Connection con=new Conexao().conectar();
    public static void cadastrar(LivroProfessor lp){
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select quantidade from livro where id="+lp.getLivroId());
            rs.next();
            int q=rs.getInt("quantidade");
            if(q==0){
                JOptionPane.showMessageDialog(null, "Livro  indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
            }else{
                stm.execute("insert into livrosprofessor(idprofessor,idlivro,dataRealizacao) values ("+lp.getProfessorId()+","+lp.getLivroId()+",'"+lp.getDataRealizacao()+"')");
                q--;
                stm.execute("update livro set quantidade="+q+" where id="+lp.getLivroId());
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public static int descobrirProfessor(String nome){
        int resp=0;
        
            Statement stm;
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select id from professor where nome='"+nome+"'");
            while(rs.next()){
                resp=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return resp;
    }
    
    //retorna o nome completo de um professor pesquisando por um pedaço
    public static String listarProfessores(String nome){
        ArrayList<String>todos=new ArrayList<>();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select nome from professor where upper(nome) like upper('%"+nome+"%')");
            while(rs.next()){
                todos.add(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(todos.size()<1){
            return null;
        }else if(todos.size()==1){
            return todos.get(0);
        }else{
            String nomes="";
            int cont=1;
            for(String n:todos){nomes+=(cont++)+". "+n+"\n";}
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
    
    public static void devolverLivro(LivroProfessor lp){
        try {
            Statement stm=con.createStatement();
            GregorianCalendar calen=new GregorianCalendar();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy"); 
        String data=formato.format(calen.getTime());
            stm.execute("update livrosprofessor set dataDevolucao='"+data+"' where "
                    + "idprofessor="+lp.getProfessorId()+" and idlivro="+lp.getLivroId());
            ResultSet rs=stm.executeQuery("select quantidade from livro where id="+lp.getLivroId());
            rs.next();
            int q=rs.getInt("quantidade");
            q++;
            stm.execute("update livro set quantidade="+q+" where id="+lp.getLivroId());
            JOptionPane.showMessageDialog(null, "Devolvido com sucesso","Devolvido",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static ArrayList<String> listarLivros(int id){
        ArrayList<String> lista=new ArrayList<String>();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select l.titulo as tit,l.autor as aut from livro l inner join "
                    + "livrosprofessor e on e.dataDevolucao='' and e.idprofessor="+id+" and e.idlivro=l.id");
            while(rs.next()){
                lista.add(rs.getString("tit")+"¬"+rs.getString("aut"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static int descobrirLivro(String titulo,String autor){
        int u=0;
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select id from livro where titulo='"+titulo+"' "
                    + "and autor='"+autor+"'");
            while(rs.next()){
               u=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroProfessorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}
