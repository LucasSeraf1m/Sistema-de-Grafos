
package sistemadegrafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import sistemadegrafos.Rotas;
import view.ConfigTela;
import view.DijsktraTela;
/**
 *
 * @author lucas
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        Thread rotaAuto = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    while(!Thread.currentThread().isInterrupted()){
                        System.out.println("Procurando rota");
                        File rota = new File("C:\\Teste\\rota.txt");
                        if(rota.exists()){
                            System.out.println("Rota encontrada");
                            Scanner scanRota = new Scanner(rota);
                            ArrayList<String> arlRota = new ArrayList<>();
                            while(scanRota.hasNextLine()){
                                arlRota.add(scanRota.nextLine());
                            }
                            scanRota.close();
                            Rotas veriRota = new Rotas();
                            veriRota.verificacao(arlRota, rota);
                        }
                        
                        Thread.sleep(2000);
                    }
                    
                }
                catch (Exception e) {
                    e.printStackTrace();
		}
            }
        });
        
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
        if(arlLinhas.size() == 2){
            ConfigTela telaConf = new ConfigTela(arquivo);
            telaConf.setVisible(true);
        }else{
            String rotaA[] = arlLinhas.get(2).split("=");
            if(rotaA[1] == "true"){
                rotaAuto.start();
            }else{
                DijsktraTela tela = new DijsktraTela();
                tela.setVisible(true);
            }
        }
        
        
    }
}
