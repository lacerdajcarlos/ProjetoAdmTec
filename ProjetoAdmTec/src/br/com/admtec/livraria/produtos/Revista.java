package br.com.admtec.livraria.produtos;

import br.com.admtec.livraria.Editora;

public class Revista implements Produto, Promocional {

	private int id;
	private String titulo;
	private String descricao;
	private double valor;
	private int edicao;

	public Revista() {

	}

	public Revista(int id, String titulo, String descricao, double valor, int edicao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.edicao = edicao;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean aplicaDescontoDe(double porcentagem) {
		if (porcentagem > 0.1) {
			return false;
		}
		double desconto = getValor() * porcentagem;
		setValor(getValor() - desconto);
		return false;
	}

	@Override
	public int compareTo(Produto outro) {
		if (this.getValor() < outro.getValor()) {
			return -1;
		}
		if (this.getValor() > outro.getValor()) {
			return 1;
		}
		return 0;

	}

	@Override
	public double getValor() {
		// TODO Auto-generated method stub
		return 0;
	}

}
