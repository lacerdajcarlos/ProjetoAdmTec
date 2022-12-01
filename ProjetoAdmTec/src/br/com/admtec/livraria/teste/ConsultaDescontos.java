package br.com.admtec.livraria.teste;

import java.util.HashSet;

import br.com.admtec.livraria.produtos.GerenciadorDeCupons;

public class ConsultaDescontos {

	public static void main(String[] args) {

		GerenciadorDeCupons gerenciador = new GerenciadorDeCupons();
		Double desconto = gerenciador.validaCupom("NODE11");
		if (desconto != null) {
			System.out.println("Cupom de desconto Valido.");
			System.out.println("valor " + desconto);
		} else {
			System.out.println("esse cupom nao exite");
		}

		/*
		 * HashSet<String> set = new HashSet<String>();
		 * set.add("nao ha repeticao em conjuntos");
		 * set.add("nao ha repeticao em conjuntos");
		 * set.add("nao ha repeticao em conjuntos");
		 * set.add("nao ha repeticao em conjuntos");
		 * set.add("nao ha repeticao em conjuntos"); System.out.println(set.size());
		 * 
		 * 
		 * /*GerenciadorDeCupons gerenciador = new GerenciadorDeCupons();
		 * 
		 * if(gerenciador.validaCupom("CUP1234")) {
		 * System.out.println("cupom de desconto valido"); }else {
		 * System.out.println("Este cupom nao existe");
		 * 
		 * 
		 * }
		 */

	}

}
