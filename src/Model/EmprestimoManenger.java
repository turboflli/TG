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
import view.ControleReserva;
import view.Menu;

/**
 *
 * @author Lucas
 */
public class EmprestimoManenger {
    private static Connection con=new Conexao().conectar();
    
    
    public static void cadastrar(int p,Emprestimos e){
        if(p==3){
          try {
              int q1,q2;
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro1());
                rs.next();
                q1=rs.getInt("quantidade");
                int t=0;
                    int id=0;
                    rs=stm.executeQuery("select id,aluno,livro1,livro2 from reserva where livro1="+e.getLivro1()+" or livro2="+e.getLivro1()+" order by dataRealizacao");
                    while(rs.next()){
                        if(rs.getInt("aluno")==e.getAluno()){//ve se o aluno é dono da reserva
                            int l1=rs.getInt("livro1");
                            int l2=rs.getInt("livro2");
                            id=rs.getInt("id");
                            if(l1==e.getLivro1()){//vê se o livro da reserva é o mesmo que o emprestado
                                l1=0;
                                stm.execute("update reserva set livro1=null where id="+id);
                            }
                            if(l2==e.getLivro1()){
                                l2=0;
                                stm.execute("update reserva set livro2=null where id="+id);
                            }
                            if(l1==0 && l2==0){stm.execute("delete from reserva where id="+id);}
                            break;
                        }
                        t++;
                        if(t>=q1){break;}
                    }
                
                if(q1==0 || q1<=t){//ve se tem livro ou se tem mais reserva que livro
                    JOptionPane.showMessageDialog(null, "Livro 1 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                    //abre reserva
                    if(JOptionPane.showConfirmDialog(null, "Quer fazer uma reserva?", "Reserva", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ControleReserva cr=new ControleReserva();cr.show();}
                }else {//continua para livro 2
                    rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro2());
                    rs.next();
                    q2=rs.getInt("quantidade");
                    t=0;
                    id=0;
                    rs=stm.executeQuery("select id,aluno,livro1,livro2 from reserva where livro1="+e.getLivro2()+" or livro2="+e.getLivro2()+" order by dataRealizacao");
                    while(rs.next()){
                        if(rs.getInt("aluno")==e.getAluno()){//vê se é mesmo aluno da reserva
                            int l1=rs.getInt("livro1");
                            int l2=rs.getInt("livro2");
                            id=rs.getInt("id");
                            if(l1==e.getLivro2()){//ve se tem livro ou se tem mais reserva que livro
                                l1=0;
                                stm.execute("update reserva set livro1=null where id="+id);
                            }
                            if(l2==e.getLivro2()){
                                l2=0;
                                stm.execute("update reserva set livro2=null where id="+id);
                            }
                            if(l1==0 && l2==0){stm.execute("delete from reserva where id="+id);}
                            break;
                        }
                        t++;
                        if(t>=q2){break;}
                    }
                    if(q2==0 || q2<=t){//ve se tem livro ou se tem mais reserva que livro
                        JOptionPane.showMessageDialog(null, "Livro 2 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                        //abre reserva
                    if(JOptionPane.showConfirmDialog(null, "Quer fazer uma reserva?", "Reserva", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ControleReserva cr=new ControleReserva();cr.show();}
                    }else {
                        stm.execute("insert into emprestimo(aluno,livro1,livro2,pendentes,dataRealizacao,dataDevolucao) "
                                + "values("+e.getAluno()+","+e.getLivro1()+","+e.getLivro2()+","+p+",'"+e.getDatarealizacao()+"','"+e.getDataDevolucao()+"')");
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                        q1-=1;q2-=1;
                        stm.execute("update livro set quantidade="+q1+" where id="+e.getLivro1());
                        stm.execute("update livro set quantidade="+q2+" where id="+e.getLivro2());
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Emprestimos.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }else {//para 1 livro
            try{
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro1());
                    rs.next();
                    int q=rs.getInt("quantidade");
                    int t=0;
                    int id=0;
                    rs=stm.executeQuery("select id,aluno,livro1,livro2 from reserva where livro1="+e.getLivro1()+" or livro2="+e.getLivro1()+" order by dataRealizacao");
                    while(rs.next()){
                        if(rs.getInt("aluno")==e.getAluno()){
                            int l1=rs.getInt("livro1");
                            int l2=rs.getInt("livro2");
                            id=rs.getInt("id");
                            if(l1==e.getLivro1()){
                                l1=0;
                                stm.execute("update reserva set livro1=null where id="+id);
                            }
                            if(l2==e.getLivro1()){
                                l2=0;
                                stm.execute("update reserva set livro2=null where id="+id);
                            }
                            if(l1==0 && l2==0){stm.execute("delete from reserva where id="+id);}
                            break;
                        }
                        t++;
                        if(t>=q){break;}
                    }
                    
                    if(q==0 || q<=t){
                        JOptionPane.showMessageDialog(null, "Livro 1 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                        //abre reserva
                    if(JOptionPane.showConfirmDialog(null, "Quer fazer uma reserva?", "Reserva", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ControleReserva cr=new ControleReserva();cr.show();}
                    }else {
                        stm.execute("insert into emprestimo(aluno,livro1,pendentes,dataRealizacao,dataDevolucao) "
                                + "values("+e.getAluno()+","+e.getLivro1()+","+p+",'"+e.getDatarealizacao()+"','"+e.getDataDevolucao()+"')");
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                        q-=1;
                        stm.execute("update livro set quantidade="+q+" where id="+e.getLivro1());
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Emprestimos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static Aluno descobrirAluno(String nome){
        Statement stm;
        
        ArrayList<Aluno> todos=new ArrayList<Aluno>();
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select id,nome from aluno where upper(nome) like upper('%"+nome+"%')");
            
            while(rs.next()){
                Aluno a=new Aluno();
                a.setId(rs.getInt("id"));
               a.setNome(rs.getString("nome"));
               todos.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(todos.size()<1){
        return null;
        }else if(todos.size()==1){
            return todos.get(0);
        }else{
            String nomes="";
            int cont=1;
            for(Aluno a:todos){nomes+=(cont++)+". "+a.getNome()+"\n";}
            String resp=JOptionPane.showInputDialog(null, todos.size()+" Registros encontrados\n"+nomes, "Mais de um", JOptionPane.INFORMATION_MESSAGE);
            try{
                return todos.get(Integer.parseInt(resp)-1);
            }catch(IndexOutOfBoundsException e){
            }catch(NullPointerException e){
            }catch(NumberFormatException e){}
        }
        return todos.get(0);

    }
    
    public static int descobrirLivro(String titulo,String autor){
        int idlivro=0;
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from livro where titulo='"+titulo+"' and autor='"+autor+"'");
            
            while(rs.next()){
                idlivro=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idlivro;
    }
    
    
    public static ArrayList<String> listar(String busca,String coluna){
        ArrayList<String> titulos=new ArrayList<String>();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select titulo,autor from livro where upper("+coluna+") like upper('%"+busca+"%')");
            while(rs.next()){
                titulos.add(rs.getString("titulo")+"¬"+rs.getString("autor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return titulos;
    }
    
    
    
    
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
        String h="";
        GregorianCalendar calen=new GregorianCalendar();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy"); 
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select a.nome as nome from emprestimo e inner join aluno a on  e.pendentes>0 and e.dataDevolucao='"+formato.format(calen.getTime())+"' and a.id=e.aluno");
            while(rs.next()){
                c++;
                h+=rs.getString("nome")+";";
            };
            Menu.setnomes(h);
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
    
    
    
    public static void cadastrarReserva(int p,Emprestimos e) {
        e.setDatarealizacao(e.getDatarealizacao().substring(4)+e.getDatarealizacao().substring(2, 4)+e.getDatarealizacao().substring(0, 2));
        if(p==3){
          try {
              int q1,q2;
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro1());
                rs.next();
                q1=rs.getInt("quantidade");//total disponivel
                rs=stm.executeQuery("select count(*) as total from reserva where livro1="+e.getLivro1()+" or livro2="+e.getLivro1());
                rs.next();
                int t=rs.getInt("total");//total de reservas
                if(q1>t){//tem mais disponiveis que reserrvados?
                    JOptionPane.showMessageDialog(null, "Livro1 Está dispónivel não precisa fazer reserva","já tem",JOptionPane.ERROR_MESSAGE);
                }else {//continua para o livro2
                    rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro2());
                    rs.next();
                    q2=rs.getInt("quantidade");//total disponivel
                    rs=stm.executeQuery("select count(*) as total from reserva where livro1="+e.getLivro2()+" or livro2="+e.getLivro2());
                    rs.next();
                    t=rs.getInt("total");//total de reservas
                    if(q2>t){//tem mais disponiveis que reserrvados?
                        JOptionPane.showMessageDialog(null, "Livro2 Está dispónivel não precisa fazer reserva","já tem",JOptionPane.ERROR_MESSAGE);
                    }else {//cadastra reserva
                        stm.execute("insert into reserva(aluno,livro1,livro2,dataRealizacao,dataDevolucao) "
                                + "values("+e.getAluno()+","+e.getLivro1()+","+e.getLivro2()+",'"+e.getDatarealizacao()+"','"+e.getDataDevolucao()+"')");
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Emprestimos.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }else {//para 1 livro
            try{
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro1());
                    rs.next();
                    int q=rs.getInt("quantidade");
                    rs=stm.executeQuery("select count(*) as total from reserva where livro1="+e.getLivro1()+" or livro2="+e.getLivro1());
                    rs.next();
                    int t=rs.getInt("total");
                    if(q>t){
                        JOptionPane.showMessageDialog(null, "Livro 1 Está dispónivel não precisa fazer reserva","já tem",JOptionPane.ERROR_MESSAGE);
                    }else {
                        stm.execute("insert into reserva(aluno,livro1,dataRealizacao,dataDevolucao) "
                                + "values("+e.getAluno()+","+e.getLivro1()+",'"+e.getDatarealizacao()+"','"+e.getDataDevolucao()+"')");
                        JOptionPane.showMessageDialog(null, "reservado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Emprestimos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
