package sistemadegrafos;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	
	private static final int INDEFINIDO = -1;
	private int vertices[][];
	
	/**
	 * Contrutor padr�o.
	 * @param numVertices
	 * 			N�mero total de vertices deste grafo.
	 */
	public Grafo(final int numVertices) {
		vertices = new int[numVertices][numVertices];
	}
	
	/**
	 * Cria uma aresta no grafo.
	 * @param noOrigem
	 * 			N� origem
	 * @param noDestino
	 * 			N� destino
	 * @param peso
	 * 			Distancia
	 * @throws InvalidAlgorithmParameterException
	 * 			Levanta esta exce��o caso o m�todo receber um peso negativo.
	 */
	public void criaAresta(final int noOrigem, final int noDestino, final int peso) throws InvalidAlgorithmParameterException {
		
		//
		// Se possuir peso ...
		//
		if (peso >= 1) {
			vertices[noOrigem][noDestino] = peso;
			vertices[noDestino][noOrigem] = peso;	
		}
		else {
			throw new InvalidAlgorithmParameterException("O peso do no origem ["+noOrigem+"] para o no destino ["+noDestino+"] n�o pode ser negativo ["+peso+"]");
		}
	}
	
	/**
	 * @return
	 * 	O custo entre os dois vertices.
	 */
	public int getCusto(final int noOrigem, final int noDestino) {
		int custo = 0;
		if (noOrigem > vertices.length) {
			throw new ArrayIndexOutOfBoundsException("No origem ["+noOrigem+"] n�o existe no grafo");
		}
		else if (noDestino > vertices.length) {
			throw new ArrayIndexOutOfBoundsException("No destino ["+noDestino+"] n�o existe no grafo");
		}
		else {
			custo = vertices[noOrigem][noDestino];
		}
		
		return custo;
	}
	
	public List<Integer> getVizinhos(final int no) {
		List<Integer> vizinhos = new ArrayList<Integer>();
		for (int i = 0; i < vertices[no].length; i++) {
			if (vertices[no][i] > 0) {
				vizinhos.add(i);
			}
		}
		return vizinhos;
	}
	
	public int getMaisProximo(final int listaCusto[], final Set<Integer> listaNaoVisitados) {
		double minDistancia = Integer.MAX_VALUE;
		int noProximo = 0;
		for (Integer i : listaNaoVisitados) {
			if (listaCusto[i] < minDistancia) {
				minDistancia = listaCusto[i];
				noProximo = i;
			}
		}
		return noProximo;
	}
	
	
	
	public List<Integer> caminhoMinimo(final int noOrigem, final int noDestino) {	
		// Variaveis de controle.
		int custo[] = new int[vertices.length];
		int antecessor[] = new int[vertices.length];
		Set<Integer> naoVisitados = new HashSet<Integer>();
		
		// Custo inicial do noOrigem � ZERO.
		custo[noOrigem] = 0;
		
		// Define que todos os outros vertices, diferentes do n� origem tem peso infinito.
		for (int v = 0; v < vertices.length; v++) {
			if (v != noOrigem) {
				custo[v] = Integer.MAX_VALUE; // Simboliza o infinito.
			}
			antecessor[v] = INDEFINIDO;
			naoVisitados.add(v);
		}
		
		while (!naoVisitados.isEmpty()) {
			
			// Busca o vertice n�o visitado mais pr�ximo.
			int noMaisProximo = getMaisProximo(custo, naoVisitados);
			
			// Retira da lista.
			naoVisitados.remove(noMaisProximo);
			
			for (Integer vizinho : getVizinhos(noMaisProximo)) {
				int custoTotal = custo[noMaisProximo] + getCusto(noMaisProximo, vizinho);
				if (custoTotal < custo[vizinho]) {
					custo[vizinho] = custoTotal;
					antecessor[vizinho] = noMaisProximo;
				}
			}
			
			if (noMaisProximo == noDestino) {
				return caminhoMaisProximo(antecessor, noMaisProximo);
			}
			
		}
		
		return Collections.emptyList();
	}
	
	private List<Integer> caminhoMaisProximo(final int antecessor[], int noMaisProximo) {
		List<Integer> caminho = new ArrayList<Integer>();
		caminho.add(noMaisProximo);
		while (antecessor[noMaisProximo] != INDEFINIDO) {
			caminho.add(antecessor[noMaisProximo]);
			noMaisProximo = antecessor[noMaisProximo];
		}
		
		Collections.reverse(caminho);
		return caminho;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grafo g = new Grafo(5);
		
		try {
			g.criaAresta(0, 2, 30);
			g.criaAresta(0, 1, 50);
			g.criaAresta(0, 3, 50);
			g.criaAresta(2, 4, 50);
			
			System.out.println(g.caminhoMinimo(0, 4));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
