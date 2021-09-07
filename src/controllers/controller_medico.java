package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Medico;


public class controller_medico {
	
	ConexaoBD conec = new ConexaoBD();
	
	
	public void Gravar(Medico med) {
		conec.conexao(); //Conexão com o banco de dados
		String sql = "insert into tbl_medicos(nome_medico,especialidade_medico, crm_medico) values(";
		sql += "'" +med.getNome() + "'" + ",";
		sql += "'" +med.getEspecilaidade()+ "'"  + ",";
		sql += med.getCrm() + ")";
		
		try {
			PreparedStatement pat = conec.con.prepareStatement(sql);
			pat.execute();
			JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
		}
		catch(SQLException a){
			JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados: \n" +a.getMessage());
		}
	}
	
	public ArrayList<Medico> PesquisaMedico(String nome) {
		String sql = "select * from tbl_medicos where nome_medico like '%" + nome + "%' order by cod_medico";
		conec.conexao(); //Conexão com o banco de dados
		ResultSet result;
		ArrayList<Medico> lista = new ArrayList();
		try {
			PreparedStatement ps = conec.con.prepareStatement(sql);
			result = ps.executeQuery();
			while(result.next()) {
				Medico med = new Medico();
				med.setCodigo(result.getInt("cod_medico"));
				med.setNome(result.getString("nome_medico"));
				med.setEspecilaidade(result.getString("especialidade_medico"));
				med.setCrm(result.getInt("crm_medico"));
				lista.add(med);
			}
			
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados: \n" +e.getMessage());
			return null;
		}
		finally {
			conec.desconecta();
		}
	}
	
	public void EditarMedico(Medico med) {
		conec.conexao(); //Conexão com o banco de dados
		String sql = "update tbl_medicos set nome_medico = ";
		sql += "'" +med.getNome() + "'" + ",";
		sql += " especialidade_medico = ";
		sql += "'" +med.getEspecilaidade()+ "'"  + ",";
		sql += " crm_medico = ";
		sql += med.getCrm();
		sql += " where cod_medico = ";
		sql += med.getCodigo();
		
		try {
			PreparedStatement pat = conec.con.prepareStatement(sql);
			pat.execute();
			JOptionPane.showMessageDialog(null, "Dados modificados com sucesso!");
		}
		catch(SQLException a){
			JOptionPane.showMessageDialog(null, "Erro ao tentar modificar os dados: \n" +a.getMessage());
		}
		finally {
			conec.desconecta();
		}
	}
	
	public void ExcluirMedico(Integer cod) {
		conec.conexao(); //Conexão com o banco de dados
		String sql = "delete from tbl_medicos where cod_medico = ";
		sql += cod;
		
		try {
			PreparedStatement pat = conec.con.prepareStatement(sql);
			pat.execute();
			JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
		}
		catch(SQLException a){
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir os dados: \n" +a.getMessage());
		}
		finally {
			conec.desconecta();
		}
	}
}
