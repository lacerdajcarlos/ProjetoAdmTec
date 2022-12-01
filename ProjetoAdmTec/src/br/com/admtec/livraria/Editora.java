package br.com.admtec.livraria;

public class Editora {
	private int idEditora;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	
	public Editora() {
		
	}
	
	public Editora(int idEditora, String nomeFantasia,String razaoSocial, String cnpj) {
		this.idEditora = idEditora ;
		this.nomeFantasia=nomeFantasia;
		this.razaoSocial=razaoSocial;
		this.cnpj=cnpj;
		}

		
	public int getidEditora() {
		return idEditora;
	}

	public void setidEditora(int idEditora) {
		this.idEditora = idEditora;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	}
	
	


