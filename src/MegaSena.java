import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class MegaSena {

	public static void main(String[] args) {
		int[] numerosEscolhidos = escolherNumeros();
		System.out.print("Números escolhidos: ");
		for(int i : numerosEscolhidos) {
			System.out.print(i+"\t");
		}
		
		System.out.print("\nNúmeros sorteados: ");
		int[] numerosVencedores = numerosSorteados();
		for(int i : numerosVencedores) {
			System.out.print(i+"\t");
		}
		
		resultado(numerosEscolhidos,numerosVencedores);
	}
	
	public static int[] numerosSorteados() {
		int [] numerosSorteados = new int[7];
		Random random = new Random();
		int indice = 0;
		while(indice<7) {
			boolean repetido = false;
			int numeroSorteado = random.nextInt(101);
				for(int i = 0; i< indice; i++) {
					if(numerosSorteados[i]==numeroSorteado) {
						repetido = true;
						break;
					}
				}
				if(repetido == false) {
					numerosSorteados[indice] = numeroSorteado;
					indice++;
				}
			}
		Arrays.sort(numerosSorteados);
		return numerosSorteados;
	}
	
	public static int[] escolherNumeros() {
		Scanner sc = new Scanner(System.in);
		int[] numerosEscolhidos = new int[7];
		int indice=0;
		System.out.println("Digite sete números inteiros de 0 a 100, não repetidos");
		while(indice<7) {
			try {
				boolean repetido = false;
				System.out.print((indice+1)+": ");
				int numeroEscolhido = sc.nextInt();
				if(numeroEscolhido>=0&&numeroEscolhido<=100) {
					for(int i = 0; i< indice; i++) {
						if(numerosEscolhidos[i]==numeroEscolhido) {
							repetido = true;
							System.out.println(numeroEscolhido + " já foi selecionado");
							break;
						}
					}
					if(repetido == false) {
						numerosEscolhidos[indice] = numeroEscolhido;
						indice++;
					}
				}
				else {
					System.out.println("O número digitado não atende a todos os critérios (inteiro, de 0 a 100 e não repetido)");
				}
			}catch (InputMismatchException e) {
				System.out.println("O número inserido deve ser um número inteiro ");
				sc.nextLine();
			}
		}
		sc.close();
		Arrays.sort(numerosEscolhidos);
		return numerosEscolhidos;
	}
	
	public static void resultado(int[] numerosEscolhidos, int[] numerosSorteados) {
		int acertos = 0;
		for(int i = 0; i<numerosEscolhidos.length; i++) {
			for(int j = 0; j<numerosSorteados.length; j++) {
				if(numerosEscolhidos[i]==numerosSorteados[j]) {
					acertos++;
					break;
				}
			}
		}
		switch(acertos) {
			case 5:
				System.out.println("Parabéns você acertou " +acertos+ " números, seu prêmio é de 10 mil reais!");
			break;
			case 6:
				System.out.println("Parabéns você acertou " +acertos+ " números, seu prêmio é de 50 mil reais!");
			break;
			case 7:
				System.out.println("Parabéns você acertou " +acertos+ " números, seu prêmio é de 200 mil reais!");
			break;
			default:
				System.out.println("\nAahhh, não foi dessa vez, quem sabe na próxima?!\nTotal de acertos: " + acertos);
			break;	
		}
	}
}
