
package Control;

import Model.Rota;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class criarArquivoRota {
    public void criar(Rota rota) {
//        try {
//            Stream<Path> paths = Files.walk(Paths.get("c://confi.txt"));
//            System.out.println(paths);
//        } catch (IOException ex) {
//            Logger.getLogger(criarArquivoRota.class.getName()).log(Level.SEVERE, null, ex);
//        }
        int numRotaArquivo = pegarNumeracaoDasRotas() +1;
        System.out.println(numRotaArquivo);
        String numRString = "";
        if(numRotaArquivo <10) {
            numRString = "0" + Integer.toString(numRotaArquivo);
        } else {
            numRString = Integer.toString(numRotaArquivo);
        }

        try {
            FileWriter arquivoRota = new FileWriter("C:\\Teste\\rota"+numRString+".txt");
            arquivoRota.write(rota.getHeader());
            arquivoRota.write('\n');
            ArrayList listaRotas = rota.getListaRota();
            for(Object i: listaRotas) {
                arquivoRota.write(i.toString());
                arquivoRota.write('\n');
                
            }
            arquivoRota.close();
        } catch(IOException erro) {
            System.out.println(erro);
        }
    }
    
    public void testeRota() {
        criarArquivoRota criarRota = new criarArquivoRota();
        Rota rota = new Rota();
        ArrayList listaRotas = new ArrayList();
        listaRotas.add("010001=01");
        listaRotas.add("010001=02");
        rota.setHeader("0002448");
        rota.setListaRota(listaRotas);
        criarRota.criar(rota);
    }
    
    public int pegarNumeracaoDasRotas() {
        File folder = new File("C:\\Teste");

        int ultNumero = 0;
        
        for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                    String nome = file.getName();
                    nome = nome.replace(".", "");
                    nome = nome.replace("txt", "");
                    nome = nome.replace("rota", "");
                    if(ultNumero < Integer.parseInt(nome)) {
                        ultNumero = Integer.parseInt(nome);
                    }
                        
                } 
        }
        
        return ultNumero;
    }
}
