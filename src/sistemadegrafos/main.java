
package sistemadegrafos;

import Control.ConfiguracaoPastas;
import Model.Config;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import view.ConfigTela;
import view.DijsktraTela;
import view.Menu;
/**
 *
 * @author lucas
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ConfiguracaoPastas confPasta = new ConfiguracaoPastas();
        confPasta.criarPastaPadrao();
        if(!confPasta.verificarExistenciaPasta("c:/Teste/Configuracao/config.txt")) {
            confPasta.criarPastaPadrao();
            ConfigTela tela = new ConfigTela();
            tela.setVisible(true);
        } else if(confPasta.verificarExistenciaPasta("c:/Teste/Configuracao/config.txt")) {
            Menu telaMenu=new Menu();
            telaMenu.setVisible(true);
        
            System.out.println("a");
        
        
//        if(arlLinhas.size() == 2) {
//            
//        }
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
            ConfigTela telaConf = new ConfigTela();
            telaConf.setConfig(arquivo);
            telaConf.setVisible(true);
        }else{
            String rotaA[] = arlLinhas.get(2).split("=");
            System.out.println(rotaA[1]);
            if(rotaA[1].equals("true")){
                rotaAuto.start();
            }else {
                System.out.println();
                DijsktraTela tela = new DijsktraTela();
                tela.setVisible(true);
            }
        }
        }
    }
}
