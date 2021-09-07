package models;

public class Medico {
	private int codigo;
	private String nome;
	private String especilaidade;
	private int crm;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecilaidade() {
		return especilaidade;
	}
	public void setEspecilaidade(String especilaidade) {
		this.especilaidade = especilaidade;
	}
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
}
