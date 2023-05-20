import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.util.Scanner;
import sistemadegrafos.Grafo;

public class Principal {
	
	private static final int S1 = 0;
	private static final int S2 = 1;
	private static final int S3 = 2;
	private static final int S4 = 3;
	private static final int S5 = 4;
	private static final int S6 = 5;
	private static final int S7 = 6;
	private static final int S8 = 7;
	private static final int S9 = 8;
	private static final int S10 = 9;
	private static final int S11 = 10;
	private static final int S12 = 11;
	private static final int S13 = 12;
	private static final int S14 = 13;
	private static final int S15 = 14;
	private static final int S16 = 15;
	private static final int S17 = 16;
	private static final int S18 = 17;
	private static final int S19 = 18;
	private static final int S20 = 19;
	
	
	private static int lerEstacao(final String tipoNo, final Scanner in) {
		
		while (true) {
			System.out.println(tipoNo+":");
			String linha = in.nextLine().trim();
			if (linha.isEmpty()) {
				System.out.println("Até a próxima!");
				System.exit(0);
			}
			
			try {
				int estacao = Integer.parseInt(linha);
				if (estacao >= 1 && estacao <= 20) {
					return estacao - 1;
				}
				else {
					System.out.println("Digite uma estação válida. Opções: 1 a 20");	
				}
			}
			catch (Exception e) {
				System.out.println("Digite uma estação válida. Opções: 1 a 20");
			}	
		}
	}
        
	public static void main(String[] args) throws InvalidAlgorithmParameterException {
		
		Grafo metro = new Grafo(20);
		
		// Linha vermelha.
		metro.criaAresta(S1, S2, 16);
		metro.criaAresta(S2, S3, 14);
		metro.criaAresta(S3, S4, 12);
		metro.criaAresta(S4, S5, 12);
		metro.criaAresta(S5, S6, 14);
		
		// Linha verde.
		metro.criaAresta(S7, S8, 15);
		metro.criaAresta(S8, S9, 11);
		metro.criaAresta(S9, S10, 13);
		metro.criaAresta(S10, S11, 16);
		metro.criaAresta(S11, S6, 15);
		
		// Linha amarela.
		metro.criaAresta(S12, S8, 11);
		metro.criaAresta(S8, S2, 8);
		metro.criaAresta(S2, S15, 7);
		metro.criaAresta(S15, S16, 7);
		metro.criaAresta(S16, S17, 12);
		metro.criaAresta(S17, S18, 9);
		
		// Linha azul.
		metro.criaAresta(S12, S9, 17);
		metro.criaAresta(S9, S13, 7);
		metro.criaAresta(S13, S14, 9);
		metro.criaAresta(S14, S5, 9);
		metro.criaAresta(S5, S17, 10);
		
		// Linha Roxa.
		metro.criaAresta(S10, S13, 11);
		metro.criaAresta(S13, S3, 13);
		metro.criaAresta(S3, S16, 11);
		metro.criaAresta(S16, S19, 13);
		metro.criaAresta(S19, S20, 12);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Bem-vindo ao Subway System!");
		System.out.println("	Disciplina de Teoria de Grafos!");
		System.out.println("--------------------------------------------");
		
		while (true) {
			
			System.out.println("Por favor, entre com a sua rota ou pressione ENTER para sair do programa.");
			
			int origem = lerEstacao("Origem", in);
			int destino = lerEstacao("Destino", in);
			System.out.println("A rota mais rápida é: ");
			
			List<Integer> estacoes = metro.caminhoMinimo(origem, destino); 
			
			for (Integer e : estacoes) {
				System.out.print((e + 1) +" -> ");
			}
			
			System.out.println("Fim da Rota");
		}
		
	}

}
















