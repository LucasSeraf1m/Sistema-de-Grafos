
package sistemadegrafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import sistemadegrafos.Rotas;
/**
 *
 * @author lucas
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File caminhoConfig = new File("C:\\Teste\\Configuracao");
        if(!caminhoConfig.exists()){
            System.out.println("Diretorio nao existe");
            System.exit(0);
        }
        File arquivo = new File("C:\\Teste\\Configuracao\\config.txt");
        if(!arquivo.exists()){
            System.out.println("Arquivo nao existe");
            System.exit(0);
        }
        Scanner scan = new Scanner(arquivo);
        if(arquivo.length() == 0){
            System.out.println("Arquivo em branco");
            System.exit(0);
        }
        
        ArrayList<String> arlLinhas = new ArrayList<String>();
        while(scan.hasNextLine()){
            arlLinhas.add(scan.nextLine());
        }

        if(arlLinhas.size() == 1){
            System.out.println("Arquivo Incompleto");
            System.exit(0);
        }

        for(int i = 0; i < arlLinhas.size(); i++){
            if(arlLinhas.get(i).contains("@")){
                    System.out.println("Arquivo Incorreto");
                    System.exit(0);
                }
        }
        for(int i = 0; i < arlLinhas.size(); i++){
            String caminho[] = arlLinhas.get(i).split("=");
            File pastas = new File(caminho[1]);
            boolean pasta = pastas.mkdirs();
            if(pasta){
                System.out.println("Pasta Criada");
            }else{
                System.out.println("Pasta ja existe");
            }
        }
        
        File rota = new File("C:\\Teste\\rota01.txt");
        File pastaP = new File("C:\\Teste\\Processado");
        File pastaNP = new File("C:\\Teste\\NaoProcessado");
        Scanner scanRota = new Scanner(rota);
        
        ArrayList<String> arlRota = new ArrayList<String>();
        while(scanRota.hasNextLine()){
            arlRota.add(scanRota.nextLine());
        }
        Rotas veriRota = new Rotas();
        int x = veriRota.verificacao(arlRota);
        switch(x){
            case 0: //mover pra pasta de processado;
                    break;
            case 1: System.out.println("Numero Totais de Nos Invalidos");
                    //mover o arquivo pra pasta nao processado
                    break;
            case 2: int peso = veriRota.getPeso();
                    int pesoH = veriRota.getPesoH();
                    System.out.println("Soma dos pesos difere (Valor do registro Header = " + pesoH + " e soma dos pesos = "+peso);
                    //mover o arquivo pra pasta nao processado
                    break;
            case 3: System.out.println("Header Invalido");
                    break;
            case 4: System.out.println("Resumo de Conexoes Invalido");
                    break;
            case 5: System.out.println("Numero de Linhas de Conexoes Diferentes");
                    // mover o arquivo pra pasta nao processado
                    break;
            case 6: System.out.println("Numero de Linhas de Pesos Diferentes");
                    //mover o arquivo pra pasta nao processado
        }
    }
}
