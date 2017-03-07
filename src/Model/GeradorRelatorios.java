/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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
    private String mes="01";
    public void setMes(int mes){
        this.mes=Integer.toString(mes);
        if(this.mes.length()<2){
            this.mes="0"+this.mes;
        }
    }
    private Connection con=new Conexao().conectar();
    public void run(){
        
        Statement stm;
        try {
            
            
            Document documento=new Document();
            
            
            FileOutputStream ot=new FileOutputStream("Emprestimos_atuais"+this.mes+".pdf", true);
            PdfWriter.getInstance(documento, ot);
            
            documento.open();
            documento.addTitle("Emprestimos");
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
        JOptionPane.showMessageDialog(null,"PDF pronto referente ao mes"+this.mes,"termino",JOptionPane.PLAIN_MESSAGE);
        
        
        } catch (SQLException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
