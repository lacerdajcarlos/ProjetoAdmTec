package br.com.admtec.livraria.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.admtec.livraria.produtos.Ebook;
import br.com.admtec.livraria.produtos.Livro;
import br.com.admtec.livraria.produtos.LivroFisico;

public class CadastroDeLivros {

	public static void main(String[] args) {
		
		List<String>nomes =new ArrayList<>();
		nomes.add("Java 8");
		nomes.add("python");
		nomes.add("javaScript");
		
		Collections.sort(nomes);
		
		System.out.println(nomes);
		
		
		
		/*Autor autor = new Autor();
		autor.setNome("Carlos Lacerda");
		autor.setEmail("carlos@gmail.com");
		autor.setCpf("123.456.789-10");
		
		Livro livro = new LivroFisico(autor);
		livro.setNome("Java 8 pratico");
		livro.setDescricao("novos recursos da linguagem");
		livro.setValor(59.90);
		livro.setIsbn("978-85-66250-46-6");
		
		//livro.setAutor(autor);
		//livro.mostrarDetalhes();
	
		Autor autor1 = new Autor();
		autor1.setNome("Arthur Lacerda");
		autor1.setEmail("arthurs@gmail.com");
		autor1.setCpf("123.456.789-10");
		

		
		Ebook ebook = new Ebook(autor);
		ebook.setNome("phyton pratico");
		ebook.setDescricao("novos recursos de python");
		ebook.setValor(59.90);
		ebook.setIsbn("978-85-66250-46-6");
		
		ebook.mostrarDetalhes();*/
	
	

	}

}
