package br.com.admtec.livraria.produtos;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeCupons {
	
	private Map<String, Double> cupons;
	
	public GerenciadorDeCupons() {
		this.cupons = new HashMap<>();
		cupons.put("NODE11",10.0);
		cupons.put("NODE22",12.0);
		cupons.put("NODE30",13.0);
		cupons.put("NODE40",14.0);
		cupons.put("NODE05",5.0);
		cupons.put("NODE50",15.0);
	}
	
	public Double validaCupom(String cupom) {
		return this.cupons.get(cupom);
	}
	
	


}
