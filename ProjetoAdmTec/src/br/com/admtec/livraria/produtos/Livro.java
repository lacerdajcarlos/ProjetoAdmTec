package br.com.admtec.livraria.produtos;

import br.com.admtec.livraria.AutorNuloException;
import br.com.admtec.livraria.Editora;

public abstract class Livro implements Produto {

	private int id;
	private String titulo;
	private String autor;
	private double valor;
	private String isbn;
	private Editora editora;
	private byte edicao;
	private short ano;

	public Livro(int id, String titulo, String autor, double valor, String isbn, Editora editora,byte edicao, short ano) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
		this.isbn = isbn;
		this.editora = editora;
		this.edicao = edicao;
		this.ano = ano;
	}

	public Livro() {
		this.isbn = "000-00-00000-00-0";

	}

	public double getTaxImpressao() {
		return this.getValor() * 0.05;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public byte getEdicao() {
		return edicao;
	}

	public void setEdicao(byte edicao) {
		this.edicao = edicao;
	}

	public short getAno() {
		return ano;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}

	@Override
	public int compareTo(Produto outro) {
		return (int) (this.getValor() - outro.getValor());
	}

}
