/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.ControleLivro;

/**
 *
 * @author Lucas
 */
public class CadastradorDeLivros extends Thread{
    private File file;
    public void setFile(File file){
        this.file=file;
    }
    public  void run(){
        FileInputStream planilha=null;  
        
                //torna arquivo editável
        int cont=0;
        int suc=0;
        try {
            planilha = new FileInputStream(this.file);
            XSSFWorkbook workbook= new XSSFWorkbook(planilha);
            
                //XSSFWorkbook wb=new XSSFWorkbook();
                //pega primeira planilha
                XSSFSheet plan1= workbook.getSheetAt(0);
                //XSSFSheet plan2= wb.createSheet();
                // retorna todas as linhas.
                ControleLivro.setMax(plan1.getPhysicalNumberOfRows());
                Iterator<Row> row=plan1.iterator();
                
                Conexao con=new Conexao();
                Connection conn=new Conexao().conectar();
                
                while(row.hasNext()) //enquanto tiver uma próxima linha
                {
                    Row linha= row.next();//cira um objeto linha para cada linha lida no iterator
                   Cell titulo = linha.getCell(0);
                   Cell autor = linha.getCell(1);
                   Cell editora = linha.getCell(2);
                   Cell quantidade = linha.getCell(3);
                
                if ( (!titulo.getStringCellValue().equalsIgnoreCase("título") ||!titulo.getStringCellValue().equalsIgnoreCase("titulo") ) && quantidade.getCellType()== Cell.CELL_TYPE_NUMERIC){
                    
                        
                            try {
                                conn.createStatement().execute("insert into livro(titulo,autor,editora,quantidade)"
                                        + "values('"+titulo.getStringCellValue().replace("'","")+"','"+autor.getStringCellValue().replace("'","")+"','"+editora.getStringCellValue().replace("'","")+"',"
                                        + quantidade.getNumericCellValue()+")");
                                suc++;
                            } catch (SQLException ex) {
                                cont++;
                                JOptionPane.showMessageDialog(null,"Erro na linha: "+linha.getRowNum(),"Falha",JOptionPane.ERROR_MESSAGE);
                            }
                    
                    
                    
                    
                    
                }
                new Thread(new Runnable() {
            public void run() {
                ControleLivro.inc();
            }
            }).start();
                }
            //vria workbook
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CadastradorDeLivros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastradorDeLivros.class.getName()).log(Level.SEVERE, null, ex);
        } 
                
           JOptionPane.showMessageDialog(null,"sucesso: "+suc+"  erros: "+cont,"resultado",JOptionPane.INFORMATION_MESSAGE);
    }
}
