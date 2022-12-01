package br.com.admtec.livraria.teste;

public class CalculadoraDeEstoque {

	public static void main(String[] args) {

		double soma = 0;

		for (double i = 0; i < 35; i++) {
			soma += 59.90;

			System.out.println("a soma em estoque e: " + soma);

			if (soma < 150) {
				System.out.println("seu estoque esta muito baixo!");
			} else if (soma > 200) {
				System.out.println("Seu estoque esta muito alto!");
			} else {
				System.out.println("seu estoque esta bom!");
			}

		}
	}
}
