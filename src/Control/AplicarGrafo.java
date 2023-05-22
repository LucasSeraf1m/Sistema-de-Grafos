
package Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemadegrafos.Grafo;

public class AplicarGrafo {
    private Grafo grafo;
    
    public Grafo criarLigações(String caminho) throws InvalidAlgorithmParameterException {
        try {
            File arquivo = new File(caminho);
            Scanner scan;
            scan = new Scanner(arquivo);
            
            int numGrafo = getNumDeVerticesRota(caminho);
            grafo = new Grafo(numGrafo);
            
            while(scan.hasNextLine()){
                String linha = scan.nextLine();
//               Le as linhas dos nós de origem e destino e as separa
                String verticesEPeso[] = linha.split("="); // Separa o nó de origem e destino dos pesos
                int validacao = verticesEPeso[0].charAt(1);//Tratamento para pegar apenas o numero indicador dos blocos conexões
                //Tratamento para pegar apenas o numero indicador dos blocos conexões
                if(validacao == 50){//Se for o número 1 então...
                    // Armazena os nos de origem e destino em variaveis
                    String conexao[] = verticesEPeso[0].split(";"); // Retorna a rota origem sem o indice
                    conexao[0] = conexao[0].substring(1); //Apaga a primeira casa do string, nesse caso o 0
                    conexao[0] = conexao[0].substring(1); //Apaga novamente a primeira casa do string, nesse caso o 1 ou 2
                    int noOrigem = Integer.parseInt(conexao[0]);
                    int noDestino = Integer.parseInt(conexao[1]);
                    int peso = Integer.parseInt(verticesEPeso[1]);
                    
                    grafo.criaAresta(noOrigem, noDestino, peso);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AplicarGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return grafo;
    }
    
    private int getNumDeVerticesRota(String caminho) {
        int totalDeVertices=0;
        
        try {
            List<String> linhas;
            linhas = Files.readAllLines(new File(caminho).toPath());
            String ultimaLinha = linhas.get(linhas.size() - 1);
            String valores[];
            valores = ultimaLinha.split(";");
            totalDeVertices = Integer.parseInt(valores[0].substring(2));
            
        } catch (IOException ex) {
            Logger.getLogger(AplicarGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return totalDeVertices;
    }
    
    //Teste do AplicarGrafo
    public static void main(String[] args) {
        AplicarGrafo appRota = new AplicarGrafo();
        
        try {
            Grafo g = appRota.criarLigações("C:\\Teste\\rota01.txt");
//            appRota.getNumDeVerticesRota("C:\\Teste\\rota01.txt");
            System.out.println(g.caminhoMinimo(1, 3));
			
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
