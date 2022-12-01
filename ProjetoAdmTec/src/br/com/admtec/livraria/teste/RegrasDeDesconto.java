package br.com.admtec.livraria.teste;

import br.com.admtec.livraria.produtos.Ebook;
import br.com.admtec.livraria.produtos.Livro;
import br.com.admtec.livraria.produtos.MiniLivro;

public class RegrasDeDesconto {

	public static void main(String[] args) {

		/*Autor autor = new Autor();
		autor.setNome("carlos lacerda");
		autor.setCpf("12345678");
		autor.setEmail("carlos@email.com");*/

		
		MiniLivro livro = new MiniLivro();
		livro.setValor(39.90);
		System.out.println("valor atual: " + livro.getValor());

		if (livro.aplicaDescontoDe(0.3)) {
			System.out.println("desconto nao pode ser maior do que 30%");
		} else {
			System.out.println("valor com desconto: " + livro.getValor());
		}

		Ebook ebook = new Ebook();
		ebook.setValor(29.90);
		if (!ebook.aplicaDescontoDe(0.15)) {
			System.out.println("desconto no ebook nao pode ser maior do que: " + "15%");
		} else {
			System.out.println("valor do ebook com desconto: " + ebook.getValor());

		}

	}

}
