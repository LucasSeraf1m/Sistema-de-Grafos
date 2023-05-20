
package Control;

import Model.ConexaoEPeso;
import Model.Rota;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemadegrafos.Grafo;

public class AplicarGrafo {
    private Grafo grafo = new Grafo(20);
    Rota rota = new Rota();
    private ArrayList resumoConexoes = new ArrayList<String>();
    private ArrayList resumoPesos = new ArrayList<String>();
    private String trailer;
    
    public void criarLigações(String caminho) throws InvalidAlgorithmParameterException {
        try {
            ConexaoEPeso cp = new ConexaoEPeso();
            ArrayList<ConexaoEPeso> cpList = new ArrayList<>();
            File arquivo = new File("C:\\Teste\\rota01.txt");
            Scanner scan;
            scan = new Scanner(arquivo);
            
            while(scan.hasNextLine()){
                String linha = scan.nextLine();
//               Le as linhas dos nós de origem e destino e as separa
                String vertices[] = linha.split("="); // Separa o nó de origem e destino ou as conexões dos pesos
                int validacao = vertices[0].charAt(1);//Tratamento para pegar apenas o numero indicador dos blocos conexões
                //Tratamento para pegar apenas o numero indicador dos blocos conexões
                if(validacao == 49){//Se for o número 1 então...
                    // Armazena os nos de origem e destino em variaveis
                    cp.setNoOrigem(retirarIndicador(vertices[0])); // Retorna a rota origem sem o indice
                    cp.setNoDestino(Integer.parseInt(vertices[1]));
                    cp.setPeso(0);
                    cpList.add(cp);
                }
                //Verificar quais os pesos das conexoes e armaxenar em variaveis
                if(validacao == 50) {
                    int peso= Integer.parseInt(vertices[1]);
                    String conexao[] = vertices[0].split(";");
                    int noOrigem = retirarIndicador(conexao[0]);
                    int noDestino= Integer.parseInt(conexao[1]);
                    
                    
                    
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AplicarGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    //Tratamento para retirar o valor do indentificador
    private int retirarIndicador(String noComIdentificador) {
        int noOrigem=0;
        noComIdentificador = noComIdentificador.substring(1); //Apaga a primeira casa do string, nesse caso o 0
        noOrigem = Integer.parseInt(noComIdentificador.substring(1)); //Apaga novamente a primeira casa do string, nesse caso o 1 ou 2
        
        return noOrigem;
    }
    
    public Grafo getGrafo() {
        return grafo;
    }
    
    //Teste do AplicarGrafo
    public static void main(String[] args) {
        AplicarGrafo appRota = new AplicarGrafo();
        Grafo g = new Grafo(20);
        try {
            appRota.criarLigações("");
            g = appRota.getGrafo();
            
            System.out.println(g.caminhoMinimo(1, 3));
			
        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }
}
