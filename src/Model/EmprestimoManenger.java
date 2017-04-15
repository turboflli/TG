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
public class EmprestimoManenger {
    private static Connection con=new Conexao().conectar();
    public static  ArrayList<Emprestimos> returnaTodos(String nome){
        ArrayList<Emprestimos> todos=new ArrayList<>();
        int id=0;
        
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select id from aluno where nome ='"+nome+"'");
            while(rs.next()){
                id=rs.getInt("id");
            }
            
            rs=stm.executeQuery("select * from emprestimo where (pendentes>0 or multa>0) and dataPagamento='' and aluno="+id);
            while(rs.next()){
                Emprestimos e=new Emprestimos();
                e.setId(rs.getInt("id"));
                e.setAluno(rs.getInt("aluno"));
                e.setLivro1(rs.getInt("livro1"));
                e.setLivro2(rs.getInt("livro2"));
                e.setPendentes(rs.getInt("pendentes"));
                e.setDataDevolucao(rs.getString("dataDevolucao"));
                e.setDatarealizacao(rs.getString("dataRealizacao"));
                e.setMulta(rs.getInt("multa"));
                    todos.add(e);
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return todos;
    }
    
    
    public static String getLivro(int id){
        String resp="";
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select titulo,autor from livro where id="+id);
            while(rs.next()){
            resp=rs.getString("titulo")+"¬"+rs.getString("autor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
    
    public static void devolver1(Emprestimos e){
        Statement stm;
        
        try {
            stm = con.createStatement();
            stm.execute("update emprestimo set pendentes="+(e.getPendentes()-1)+" where id="+e.getId());
            ResultSet rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro1());
            rs.next();
            int q=rs.getInt("quantidade");
            q++;
            stm.execute("update livro set quantidade="+q+" where id="+e.getLivro1());
            JOptionPane.showMessageDialog(null, "livro 1 devolvido com sucesso","Devolução",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void devolver2(Emprestimos e){
        Statement stm;
        try {
            stm = con.createStatement();
            stm.execute("update emprestimo set pendentes="+(e.getPendentes()-2)+" where id="+e.getId());
            ResultSet rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro2());
            rs.next();
            int q=rs.getInt("quantidade");
            q++;
            stm.execute("update livro set quantidade="+q+" where id="+e.getLivro2());
            JOptionPane.showMessageDialog(null, "livro 2 devolvido com sucesso","Devolução",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   /* public static void multar(Emprestimos e){
        Statement stm;
        try {
        stm = con.createStatement();
        stm.execute("update emprestimo set multa="+e.getMulta()+" where id="+e.getId());
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    */
    public static boolean pagar(Emprestimos e){
        if(e.getPendentes()==0){
            Statement stm;
            try {
            stm = con.createStatement();
            stm.execute("update emprestimo set multa="+e.getMulta()+", dataPagamento='"+e.getDataPagamento()+"' where id="+e.getId());
                JOptionPane.showMessageDialog(null, "Pago com sucesso","Pagamento",JOptionPane.PLAIN_MESSAGE);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Primeiro devolva o livro","Devolva",JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }
    
    public static int contar(){
        int c=0;
        Statement stm;
        GregorianCalendar calen=new GregorianCalendar();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy"); 
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select count(*) as contador from emprestimo where pendentes>0 and dataDevolucao='"+formato.format(calen.getTime())+"'");
            rs.next();
            c=rs.getInt("contador");
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return c;
    }
    
    public static void adiar(Emprestimos e){
            Statement stm;
            try {
            stm = con.createStatement();
            stm.execute("update emprestimo set dataDevolucao='"+e.getDataDevolucao()+"' where id="+e.getId());
                JOptionPane.showMessageDialog(null, "Adiado com sucesso","adiado",JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
    public static void killreserva(String data){
        Statement stm;
            try {
            stm = con.createStatement();
            stm.execute("delete from reserva where str_to_date(dataDevolucao,'%d%m%Y')<STR_TO_DATE('"+data+"','%d/%m/%Y')");
                
            } catch (SQLException ex) {
                Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void atualizarMulta(String data){

    Statement stm;
        try {
            stm = con.createStatement();
            stm.execute("update emprestimo e set e.multa=e.multa+1 where e.pendentes>0 and  str_to_date(dataDevolucao,'%d%m%Y')<STR_TO_DATE('"+data+"','%d/%m/%Y')");
                
            } catch (SQLException ex) {
                Logger.getLogger(EmprestimoManenger.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
