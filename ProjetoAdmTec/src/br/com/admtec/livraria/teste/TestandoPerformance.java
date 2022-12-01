package br.com.admtec.livraria.teste;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TestandoPerformance {

	public static void main(String[] args) {
	 HashSet <String> colecao = new HashSet<String>();
		
		for(int i = 0; i < 10000; i++) {
			colecao.add("intem: "+i);
		}
		long inicio = System.currentTimeMillis();
		
		for(int i = 0; i <100000; i++) {
			colecao.contains("item: "+i);
		}
		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
	System.out.println("Demorou "+ tempo+ " MS para executar");
	}

}
