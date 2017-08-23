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
public class EmprestimoManager {
    private static Connection con=new Conexao().conectar();
    
    public final static int Livro1Pendente=1;
    public final static int Livro2Pendente=2;
    public final static int AmbosLivrosPendente=3;
    public static void cadastrar(int pendentes,Emprestimos e){
        if(pendentes==AmbosLivrosPendente){
          try {
              int quantidadeLivro1,quantidadeLivro2;
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro1());
                rs.next();
                quantidadeLivro1=rs.getInt("quantidade");
                int totalReservados=0;
                    int id=0;
                    rs=stm.executeQuery("select id,aluno,livro1,livro2 from reserva where (livro1="+e.getLivro1()+" or livro2="+e.getLivro1()+") and vencida=0 order by dataRealizacao");
                    while(rs.next()){
                        if(rs.getInt("aluno")==e.getAluno()){//ve se o aluno é dono da reserva
                            int idLivro1=rs.getInt("livro1");
                            int idLivro2=rs.getInt("livro2");
                            id=rs.getInt("id");
                            if(idLivro1==e.getLivro1()){//vê se o livro da reserva é o mesmo que o emprestado
                                idLivro1=0;
                               // stm.execute("update reserva set livro1=null where id="+id);
                            }
                            if(idLivro2==e.getLivro1()){
                                idLivro2=0;
                               // stm.execute("update reserva set livro2=null where id="+id);
                            }
                            if(idLivro1==0 && idLivro2==0){stm.execute("update reserva set vencida=1 where id="+id);}
                            break;
                        }
                        totalReservados++;
                        if(totalReservados>=quantidadeLivro1){break;}
                    }
                
                if(quantidadeLivro1==0 || quantidadeLivro1<=totalReservados){//ve se tem livro ou se tem mais reserva que livro
                    JOptionPane.showMessageDialog(null, "Livro 1 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                    //abre reserva
                    if(JOptionPane.showConfirmDialog(null, "Quer fazer uma reserva?", "Reserva", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ControleReserva cr=new ControleReserva();cr.show();}
                }else {//continua para livro 2
                    rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro2());
                    rs.next();
                    quantidadeLivro2=rs.getInt("quantidade");
                    totalReservados=0;
                    id=0;
                    rs=stm.executeQuery("select id,aluno,livro1,livro2 from reserva where (livro1="+e.getLivro2()+" or livro2="+e.getLivro2()+") and vencida=0 order by dataRealizacao");
                    while(rs.next()){
                        if(rs.getInt("aluno")==e.getAluno()){//vê se é mesmo aluno da reserva
                            int idLivro1=rs.getInt("livro1");
                            int idLivro2=rs.getInt("livro2");
                            id=rs.getInt("id");
                            if(idLivro1==e.getLivro2()){//ve se tem livro ou se tem mais reserva que livro
                                idLivro1=0;
                                //stm.execute("update reserva set livro1=null where id="+id);
                            }
                            if(idLivro2==e.getLivro2()){
                                idLivro2=0;
                                //stm.execute("update reserva set livro2=null where id="+id);
                            }
                            if(idLivro1==0 && idLivro2==0){stm.execute("update reserva set vencida=1 where id="+id);}
                            break;
                        }
                        totalReservados++;
                        if(totalReservados>=quantidadeLivro2){break;}
                    }
                    if(quantidadeLivro2==0 || quantidadeLivro2<=totalReservados){//ve se tem livro ou se tem mais reserva que livro
                        JOptionPane.showMessageDialog(null, "Livro 2 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                        //abre reserva
                    if(JOptionPane.showConfirmDialog(null, "Quer fazer uma reserva?", "Reserva", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ControleReserva cr=new ControleReserva();cr.show();}
                    }else {
                        stm.execute("insert into emprestimo(aluno,livro1,livro2,pendentes,dataRealizacao,dataDevolucao) "
                                + "values("+e.getAluno()+","+e.getLivro1()+","+e.getLivro2()+","+AmbosLivrosPendente+",'"+e.getDatarealizacao()+"','"+e.getDataDevolucao()+"')");
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                        quantidadeLivro1-=1;quantidadeLivro2-=1;
                        stm.execute("update livro set quantidade="+quantidadeLivro1+" where id="+e.getLivro1());
                        stm.execute("update livro set quantidade="+quantidadeLivro2+" where id="+e.getLivro2());
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
                    int quantidadeUnico=rs.getInt("quantidade");
                    int totalReservados=0;
                    int id=0;
                    rs=stm.executeQuery("select id,aluno,livro1,livro2 from reserva where (livro1="+e.getLivro1()+" or livro2="+e.getLivro1()+") and vencida=0order by dataRealizacao");
                    while(rs.next()){
                        if(rs.getInt("aluno")==e.getAluno()){
                            int idLivro1=rs.getInt("livro1");
                            int idLivro2=rs.getInt("livro2");
                            id=rs.getInt("id");
                            if(idLivro1==e.getLivro1()){
                                idLivro1=0;
                                //stm.execute("update reserva set livro1=null where id="+id);
                            }
                            if(idLivro2==e.getLivro1()){
                                idLivro2=0;
                                //stm.execute("update reserva set livro2=null where id="+id);
                            }
                            if(idLivro1==0 && idLivro2==0){stm.execute("update reserva set vencida=1 where id="+id);}
                            break;
                        }
                        totalReservados++;
                        if(totalReservados>=quantidadeUnico){break;}
                    }
                    
                    if(quantidadeUnico==0 || quantidadeUnico<=totalReservados){
                        JOptionPane.showMessageDialog(null, "Livro 1 indisponível\ntodos os exemplares já estão emprestados","Sem",JOptionPane.ERROR_MESSAGE);
                        //abre reserva
                    if(JOptionPane.showConfirmDialog(null, "Quer fazer uma reserva?", "Reserva", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ControleReserva cr=new ControleReserva();cr.show();}
                    }else {
                        stm.execute("insert into emprestimo(aluno,livro1,pendentes,dataRealizacao,dataDevolucao) "
                                + "values("+e.getAluno()+","+e.getLivro1()+","+Livro1Pendente+",'"+e.getDatarealizacao()+"','"+e.getDataDevolucao()+"')");
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                        quantidadeUnico-=1;
                        stm.execute("update livro set quantidade="+quantidadeUnico+" where id="+e.getLivro1());
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Emprestimos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
                Emprestimos e=new Emprestimos(rs.getInt("id"), rs.getInt("aluno"), rs.getInt("livro1"), rs.getInt("livro2"),
                rs.getInt("pendentes"), rs.getString("dataRealizacao"),rs.getString("dataDevolucao"),  rs.getInt("multa"));
                    todos.add(e);
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManager.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EmprestimoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
    
    public static void devolver(Emprestimos e,int livroPosicao){
        Statement stm;
        
        try {
            stm = con.createStatement();
            stm.execute("update emprestimo set pendentes="+(e.getPendentes()-livroPosicao)+" where id="+e.getId());
            ResultSet rs;
            if(livroPosicao==Livro1Pendente){
                rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro1());
            }else{
                rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro2());
            }
            rs.next();
            int quantidade=rs.getInt("quantidade");
            quantidade++;
            stm.execute("update livro set quantidade="+quantidade+" where id="+e.getLivro1());
            JOptionPane.showMessageDialog(null, "livro "+livroPosicao+" devolvido com sucesso","Devolução",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public static boolean pagar(Emprestimos e){
        if(e.getPendentes()==0){
            Statement stm;
            try {
            stm = con.createStatement();
            stm.execute("update emprestimo set multa="+e.getMulta()+", dataPagamento='"+e.getDataPagamento()+"' where id="+e.getId());
                JOptionPane.showMessageDialog(null, "Pago com sucesso","Pagamento",JOptionPane.PLAIN_MESSAGE);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(EmprestimoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Primeiro devolva o livro","Devolva",JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }
    
    public static void contar(){
        Statement stm;
        String h="";
        GregorianCalendar calen=new GregorianCalendar();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy"); 
        try {
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select a.nome as nome, count(a.nome) as quantidade from emprestimo e inner join aluno a on  e.pendentes>0 and e.dataDevolucao='"+formato.format(calen.getTime())+"' and a.id=e.aluno group by a.nome;");
            while(rs.next()){
                h+=rs.getString("nome")+" : "+rs.getInt("quantidade")+";";
            };
            Menu.setnomes(h);
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static void adiar(Emprestimos e){
            Statement stm;
            try {
            stm = con.createStatement();
            stm.execute("update emprestimo set dataDevolucao='"+e.getDataDevolucao()+"' where id="+e.getId());
                JOptionPane.showMessageDialog(null, "Adiado com sucesso","adiado",JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(EmprestimoManager.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
    public static void killreserva(String data){
        Statement stm;
            try {
            stm = con.createStatement();
            stm.execute("delete from reserva where str_to_date(dataDevolucao,'%d%m%Y')<STR_TO_DATE('"+data+"','%d/%m/%Y')");
                
            } catch (SQLException ex) {
                Logger.getLogger(EmprestimoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void atualizarMulta(String data){

    Statement stm;
        try {
            stm = con.createStatement();
            stm.execute("update emprestimo e set e.multa=e.multa+1 where e.pendentes>0 and  str_to_date(dataDevolucao,'%d%m%Y')<STR_TO_DATE('"+data+"','%d/%m/%Y')");
                
            } catch (SQLException ex) {
                Logger.getLogger(EmprestimoManager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
    public static void cadastrarReserva(int pendentes,Emprestimos e) {
        e.setDatarealizacao(e.getDatarealizacao().substring(4)+e.getDatarealizacao().substring(2, 4)+e.getDatarealizacao().substring(0, 2));
        if(pendentes==AmbosLivrosPendente){
          try {
              int quantidadeLivro1,quantidadeLivro2;
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro1());
                rs.next();
                quantidadeLivro1=rs.getInt("quantidade");//total disponivel
                rs=stm.executeQuery("select count(*) as total from reserva where livro1="+e.getLivro1()+" or livro2="+e.getLivro1());
                rs.next();
                int totalReservados=rs.getInt("total");//total de reservas
                if(quantidadeLivro1>totalReservados){//tem mais disponiveis que reserrvados?
                    JOptionPane.showMessageDialog(null, "Livro1 Está dispónivel não precisa fazer reserva","já tem",JOptionPane.ERROR_MESSAGE);
                }else {//continua para o livro2
                    rs=stm.executeQuery("select quantidade from livro where id="+e.getLivro2());
                    rs.next();
                    quantidadeLivro2=rs.getInt("quantidade");//total disponivel
                    rs=stm.executeQuery("select count(*) as total from reserva where livro1="+e.getLivro2()+" or livro2="+e.getLivro2());
                    rs.next();
                    totalReservados=rs.getInt("total");//total de reservas
                    if(quantidadeLivro2>totalReservados){//tem mais disponiveis que reserrvados?
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
                    int quantidadeUnico=rs.getInt("quantidade");
                    rs=stm.executeQuery("select count(*) as total from reserva where livro1="+e.getLivro1()+" or livro2="+e.getLivro1());
                    rs.next();
                    int totalReservados=rs.getInt("total");
                    if(quantidadeUnico>totalReservados){
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
