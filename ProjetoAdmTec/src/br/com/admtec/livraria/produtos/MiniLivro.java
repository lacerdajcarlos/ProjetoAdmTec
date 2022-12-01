package br.com.admtec.livraria.produtos;

public class MiniLivro extends Livro implements Promocional {

	public MiniLivro() {
	
	}

	@Override
	public boolean aplicaDescontoDe(double porcentagem) {
		return false;
	}

}
