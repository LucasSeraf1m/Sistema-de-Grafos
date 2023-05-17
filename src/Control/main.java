
package Control;

import Model.Rota;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author lucas
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        File arquivo = new File("C:\\Teste\\Configuracao\\config.txt");
//        File pastaTeste = new File("C:\\Teste");
//        boolean pastaA = pastaTeste.mkdirs();
//        File pastaTesteConfiguracao = new File("C:\\Teste\\Configuracao");
//        boolean pastaB = pastaTesteConfiguracao.mkdirs();
//        Scanner scan = new Scanner(arquivo);
//        while(scan.hasNextLine()){
//            String caminho[] = scan.nextLine().split("=");
//            File pastas = new File(caminho[1]);
//            boolean pasta = pastas.mkdirs();
//            if(pastaB){
//                System.out.println("Pasta Criada");
//            }else{
//                System.out.println("Nao foi possivel criar pasta");
//            }
//        }

    
        
    criarArquivoRota criarRota = new criarArquivoRota();
    Rota rota = new Rota();
    ArrayList listaRotas = new ArrayList();
    listaRotas.add("010001=01");
    listaRotas.add("010001=02");
    listaRotas.add("010001=02");
    rota.setHeader("0002448");
    //rota.setListaRota(listaRotas);
    criarRota.criar(rota);
        
    }
}
