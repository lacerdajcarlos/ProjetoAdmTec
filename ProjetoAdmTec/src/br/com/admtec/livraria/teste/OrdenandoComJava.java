package br.com.admtec.livraria.teste;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.admtec.livraria.produtos.Ebook;
import br.com.admtec.livraria.produtos.LivroFisico;
import br.com.admtec.livraria.produtos.Produto;

public class OrdenandoComJava {

	public static void main(String[] args) {
	//	Autor autor = new Autor();
		//autor.setNome("carlos lacerda");

		LivroFisico fisico = new LivroFisico();
		fisico.setTitulo("Jaava 8 Pratico");
		fisico.setValor(59.90);

		Ebook ebook = new Ebook();
		ebook.setTitulo("java 8 Prtaico");
		ebook.setValor(29.90);

		List<Produto> produtos = Arrays.asList(fisico, ebook);

		Collections.sort(produtos);

		for (Produto produto : produtos) {
			System.out.println(produto.getValor());
		}

	}

}
