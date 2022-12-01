package br.com.admtec.livraria.teste;

import java.util.List;

import br.com.admtec.livraria.produtos.CarrinhoDeCompras;
import br.com.admtec.livraria.produtos.Ebook;
import br.com.admtec.livraria.produtos.LivroFisico;
import br.com.admtec.livraria.produtos.Produto;

public class RegistroDeVendas {


	public static void main(String[] args) {
		
	   // Autor autor = new Autor();
		//autor.setNome("Carlos Lacerda");
		
		LivroFisico fisico = new LivroFisico();
		fisico.setTitulo("test-Driven Development");
		fisico.setValor(59.90);
		if(fisico.aplicaDescontoDe10Porcento()) {
			System.out.println("valor agora e: "+ fisico.getValor());
		}
		
		Ebook ebook = new Ebook();
		ebook.setTitulo("test-Driven Development");
		ebook.setValor(29.90);
		
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		carrinho.adiciona(fisico);
		carrinho.adiciona(ebook);
		
		List <Produto> produtos = carrinho.getProdutos();
		
		for (Produto produto : produtos) {
			System.out.println(produto);
			
		}
		
			
			}
}