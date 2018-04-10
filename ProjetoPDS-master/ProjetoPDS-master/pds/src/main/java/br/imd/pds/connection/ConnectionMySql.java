package br.imd.pds.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMySql {

	public static String status = "Não conectou...";

	// Método de Conexão//

	public static java.sql.Connection getConnectionMySQL() {
	 
		Connection connection = null; //atributo do tipo Connection
 
		try {
			// Carregando o JDBC Driver padrão
			String driverName = "com.mysql.jdbc.Driver";                        
			Class.forName(driverName);	 
			
			// Configurando a nossa conexão com um banco de dados//
			String serverName = "localhost";    //caminho do servidor do BD
	        String mydatabase ="pdsproject";        //nome do seu banco de dados
	        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	        String username = "root";        //nome de um usuário de seu BD      
	        String password = "root123";      //sua senha de acesso
	        connection = DriverManager.getConnection(url, username, password);
	 
	        //Testa sua conexão//
	        if (connection != null) {
	            status = ("STATUS--->Conectado com sucesso!");
	        } else {
	        	status = ("STATUS--->Não foi possivel realizar conexão");
	        }
	        return connection;
	 
	        } catch (ClassNotFoundException e) {  //Driver não encontrado
	        	System.out.println("O driver expecificado nao foi encontrado.");
	            return null;
	        } catch (SQLException e) {
	        	//Não conseguindo se conectar ao banco
	        	System.out.println("Nao foi possivel conectar ao Banco de Dados.");
	 
	            return null;
	        }
	}

	// Método que retorna o status da sua conexão//
	public static String statusConection() {
		return status;
	}

	// Método que fecha sua conexão//
	public static boolean closeConnection() {

		try {
			ConnectionMySql.getConnectionMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	// Método que reinicia sua conexão//

	public static java.sql.Connection rebootConnection() {

		closeConnection();
		return ConnectionMySql.getConnectionMySQL();
	}
	
	
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionMySql.getConnectionMySQL();
		 Statement stmt = null;
		    String query = "select name_adm from administrator";
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            //String coffeeName = rs.getString("adm_id");
		            String supplierID = rs.getString("name_adm");
//		            float price = rs.getFloat("PRICE");
//		            int sales = rs.getInt("SALES");
//		            int total = rs.getInt("TOTAL");
		            System.out.println(supplierID);
		        }
		    } catch (SQLException e ) {
		    	System.out.print(e.getMessage());
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		 
		}
}
