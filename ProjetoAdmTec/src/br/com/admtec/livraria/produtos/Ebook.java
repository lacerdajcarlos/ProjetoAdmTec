package br.com.admtec.livraria.produtos;

public class Ebook extends Livro implements Promocional {
	private String waterMark;
	
	public Ebook() {
	
	}
	@Override
	public boolean aplicaDescontoDe(double porcentagem) {
		if (porcentagem > 0.15) {
			return false;
		}
		double desconto = getValor() * porcentagem;
		setValor(getValor()-desconto);
		System.out.println("aplicando desconto no Ebook");
		return true;
	}

	public String getWaterMark() {
		return waterMark;
	}

	public void setWaterMark(String waterMark) {
		this.waterMark = waterMark;
	}
	
	


}
