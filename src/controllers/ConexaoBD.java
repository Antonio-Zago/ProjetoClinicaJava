package controllers;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConexaoBD {
	private String driver = "org.postgresql.Driver";
	private String caminho = "jdbc:postgresql://localhost:5432/clinica";
	private String usuario = "postgres";
	private String senha = "toto190100";
	public ResultSet rs;
	private Statement sm; 
	public Connection  con;
	
	
	public void conexao() {
		try {
			System.setProperty("jdbc.Drivers",driver );
			con = DriverManager.getConnection(caminho,usuario,senha);
			//JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!");
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro de conexão: \n"+ex.getMessage());
		}
	}
	
	public void desconecta() {
		try {
			con.close();
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar desconectar: \n"+ex.getMessage());
		}
	}
}
