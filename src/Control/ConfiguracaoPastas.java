
package Control;

import Model.Config;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguracaoPastas {
    private String caminhoTeste = "C:/Teste/";
    private String caminhoProcessado= Config.getLinhaProcessado();
    private String caminhoNaoProcessado=Config.getLinhaNaoProcessado();
    
    public void criarArquivoConfig() {
        String caminhoConf = caminhoTeste + "/Configuracao";
        verificarCriarPasta(caminhoConf);
        try {
            FileWriter conf = new FileWriter(caminhoConf+"/config.txt");
            conf.write("Processado="+caminhoProcessado);
            conf.write("\n");
            conf.write("NaoProcessado="+caminhoNaoProcessado);
            conf.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfiguracaoPastas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Cria a pasta c:\teste\...
    public void criarPastaPadrao() {
        //Verifica se não existe pasta criada
        verificarCriarPasta("c:\\Teste\\Teste");
        verificarCriarPasta("c:\\Teste\\Configuracao");
        verificarCriarPasta("c:\\Teste\\NaoProcessado");
        verificarCriarPasta("c:\\Teste\\Processado");
    }
    
    //Criar pasta em outro lugar com mesma estrutura
    public void criarPastaPadrao(String caminho) {
//        Verifica se não existe pasta criada
        verificarCriarPasta(caminho + "Teste\\");
        verificarCriarPasta(caminho + "Teste\\Processado");
        verificarCriarPasta(caminho + "Teste\\NaoProcessado");
    }
    
    public void verificarCriarPasta(String caminho) {
       boolean existencia = verificarExistenciaPasta(caminho);
       if(!existencia) {
            //Criar pasta nova
            criarPasta(caminho);
       }    
    }
    
    //Verifica se não existe pasta criada
    public boolean verificarExistenciaPasta(String caminho) {
        boolean existencia=false;
        String pastas[] = caminho.split("/");
        String pastasRaiz="";
        
        for (int i=0; i<pastas.length-1; i++) {
            pastasRaiz += pastas[i] +"/";
        }
        
        if(pastas[pastas.length - 1].equals("Processado")) {
            caminhoProcessado = caminho;
        } else if(pastas[pastas.length - 1].equals("NaoProcessado")) {
            caminhoNaoProcessado = caminho;    
        } else {
            caminhoTeste = caminho;
        }
        
        File pastaC = new File(pastasRaiz);
        
        try {
            for(File pasta : pastaC.listFiles()) {
                String nomePasta = pasta.getName();

                if(nomePasta.equals(pastas[pastas.length - 1])) {
                    existencia=true;
                }
            }
//            JOptionPane.sho
            
            return existencia;
        } catch (Exception e) {
            return existencia;
        }
    }
    
    public void criarPasta(String caminho) {
        File file = new File(caminho);
        file.mkdirs();//Cria diretorio do caminho
    }
    
    //Funcao main para teste do arquivo
    public static void main(String[] args) {
        ConfiguracaoPastas conf =  new ConfiguracaoPastas();
        conf.verificarCriarPasta("c:/Teste/Teste/");
        conf.verificarCriarPasta("c:/Teste/Teste/Processado");
        conf.verificarCriarPasta("c:/Teste/Teste/NaoProcessado");
        conf.criarArquivoConfig();
    }
}
