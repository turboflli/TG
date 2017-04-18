/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public Connection conectar(){
		String maq="localhost",nome_db="TGBiblioteca",user="root",senha="Lucas00";
		try{
			
			//Class.forName("com.mysql.jdbc.Driver");// diz qual é o tipo de sgbd que vc está usando, jdbc
			return  DriverManager.getConnection("jdbc:mysql://"+maq+"/"+nome_db+"?user="+user+"&password="+senha);//classe de conexão
			//Statement stm =  conn.createStatement();
			//return stm;
		}
		catch(SQLException e){
		throw new RuntimeException(e);
                    //System.out.println("Erro: "+e);
			//return null;
		}
	}
}
