/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class GeradorRelatorios extends Thread{
    private String mes="";
    private boolean professor;
    public void setMes(int mes){
        this.mes=Integer.toString(mes);
        if(this.mes.length()<2){
            this.mes="0"+this.mes;
        }
    }
    public void setProfessor(boolean professor) {
        this.professor = professor;
    }
    private Connection con=new Conexao().conectar();
    public void run(){
        
        if(this.professor){
            GerarProfessor();
        }else {
            GerarMes();
            
        }
        
    }
    
    
    private void GerarMes(){
        Statement stm;
        try {
            
            
            Document documento=new Document();
            
            
            FileOutputStream ot=new FileOutputStream("Emprestimos_atuais"+this.mes+".pdf", true);
            PdfWriter.getInstance(documento, ot);
            
            documento.open();
            Paragraph pa=new Paragraph();
          Font fonte =new Font(Font.FontFamily.TIMES_ROMAN , 28, Font.BOLD,new BaseColor(0,0,0));
         pa.setFont(fonte);
          pa.setAlignment(Element.ALIGN_CENTER);
          pa.setSpacingAfter(50);
        pa.add("Emprestimos Atuais");
        documento.add(pa);
            PdfPTable table = new PdfPTable(5);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Aluno"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("livro1"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("livro2"));
            PdfPCell cell4 = new PdfPCell(new Paragraph("realizacao"));
            PdfPCell cell5 = new PdfPCell(new Paragraph("Devolucao"));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            
            
            stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select a.nome, c.liv1,c.liv2,c.dr,c.dd from aluno a right join (select c.ida as idaluno,c.til1 as liv1, l.titulo as liv2,c.rea as dr,c.dev as dd from livro l right join (select e.aluno as ida,l.titulo as til1 ,e.livro2 as id2,e.dataRealizacao as rea,e.dataDevolucao as dev from livro l inner join emprestimo e where e.livro1=l.id and e.dataRealizacao like '__"+this.mes+"____') as c on l.id=id2)as c on c.idaluno=a.id");
            
            String data="";
            
        while(rs.next()){
            cell1 = new PdfPCell(new Paragraph(rs.getString("nome")));
            cell2 = new PdfPCell(new Paragraph(rs.getString("liv1")));
            cell3 = new PdfPCell(new Paragraph(rs.getString("liv2")));
            data=rs.getString("dr");
            data=data.substring(0, 2)+"/"+data.substring(2,4)+"/"+data.substring(4);
            cell4 = new PdfPCell(new Paragraph(data));
            data=rs.getString("dd");
            data=data.substring(0, 2)+"/"+data.substring(2,4)+"/"+data.substring(4);
            cell5 = new PdfPCell(new Paragraph(data));
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
        }
        documento.add(table);
        documento.close();
        JOptionPane.showMessageDialog(null,"PDF pronto referente ao mes "+this.mes,"termino",JOptionPane.INFORMATION_MESSAGE);
        
        
        } catch (SQLException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void GerarProfessor(){
       Statement stm;
       int id=0;
       String name="";
        try {
            
            
            Document documento=new Document();
            
            
            FileOutputStream ot=new FileOutputStream("Emprestimos_Com_professor.pdf", true);
            PdfWriter.getInstance(documento, ot);
            PdfPTable table;
            documento.open();
            
            Statement el=con.createStatement();
            ResultSet els=el.executeQuery("select id,nome from professor");
            
            while(els.next()){
                
                id=els.getInt("id");
                name=els.getString("nome");
                Paragraph pa=new Paragraph();
                Font fonte =new Font(Font.FontFamily.TIMES_ROMAN , 28, Font.BOLD,new BaseColor(0,0,0));
                pa.setFont(fonte);
                pa.setAlignment(Element.ALIGN_CENTER);
                pa.setSpacingAfter(50);
                pa.add(name);
                documento.add(pa);
                table = new PdfPTable(2);
                table.setSpacingAfter(20);

                PdfPCell cell2 = new PdfPCell(new Paragraph("livro"));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Data"));
            

                table.addCell(cell2);
                table.addCell(cell3);

            
            
                stm = con.createStatement();
                ResultSet rs=stm.executeQuery("select l.titulo as titulo,e.dataRealizacao as dr from livro l inner join livrosprofessor e on e.idlivro=l.id  and e.dataRealizacao like '__"+this.mes+"____' and e.idprofessor="+id);
            
                String data="";
            
                while(rs.next()){

                    cell2 = new PdfPCell(new Paragraph(rs.getString("titulo")));

                    data=rs.getString("dr");
                    data=data.substring(0, 2)+"/"+data.substring(2,4)+"/"+data.substring(4);
                   cell3 = new PdfPCell(new Paragraph(data));

                    table.addCell(cell2);
                    table.addCell(cell3);

                }
                documento.add(table);
            }
            
            
        documento.close();
        JOptionPane.showMessageDialog(null,"PDF pronto referente aos professores do mês "+this.mes,"termino",JOptionPane.INFORMATION_MESSAGE);
        
        
        } catch (SQLException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
