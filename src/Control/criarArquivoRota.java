
package Control;

import Model.Rota;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class criarArquivoRota {
    public void criar(Rota rota) {
        int numRotaArquivo = pegarUltimaRotaCriada() +1;
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
            
            ArrayList listaRotas = rota.getResumoConexoes();
            for(Object i: listaRotas) {
                arquivoRota.write(i.toString());
                arquivoRota.write('\n');
            }
            
            ArrayList listaPesos = rota.getResumoPesos();
            for(Object i: listaPesos) {
                arquivoRota.write(i.toString());
                arquivoRota.write('\n');
            }
            
            arquivoRota.write(rota.getTrailer());
            arquivoRota.write('\n');
            
            arquivoRota.close();
        } catch(IOException erro) {
            System.out.println(erro);
        }
    }
    
    public void criar(Rota rota, String result) {
        int numRotaArquivo = pegarUltimaRotaCriada() +1;
        System.out.println(numRotaArquivo);
        String numRString = "";
        if(numRotaArquivo <10) {
            numRString = "0" + Integer.toString(numRotaArquivo);
        } else {
            numRString = Integer.toString(numRotaArquivo);
        }

        try {
            FileWriter arquivoRota = new FileWriter("C:\\Teste\\Processado\\rota"+numRString+".txt");
            
            arquivoRota.write(rota.getHeader());
            arquivoRota.write('\n');
            
            ArrayList listaRotas = rota.getResumoConexoes();
            for(Object i: listaRotas) {
                arquivoRota.write(i.toString());
                arquivoRota.write('\n');
            }
            
            ArrayList listaPesos = rota.getResumoPesos();
            for(Object i: listaPesos) {
                arquivoRota.write(i.toString());
                arquivoRota.write('\n');
            }
            
            arquivoRota.write(rota.getTrailer());
            arquivoRota.write('\n');
            
            arquivoRota.write(result);
            arquivoRota.write('\n');
            
            arquivoRota.close();
        } catch(IOException erro) {
            System.out.println(erro);
        }
    }
    
    // Funções para pegar ultimo arquivo de rotas
    public int pegarUltimaRotaCriada() {
        int ultNumero=0, rota;
        
        rota = verificarUltimaRota("C:\\Teste");
        if(ultNumero<rota) {
            ultNumero = rota;
        }
        
        
        rota = pegarUltimaRotaCriadaProcessado();
        if(ultNumero<rota) {
            ultNumero = rota;
        }
        
        rota = pegarUltimaRotaCriadaNaoProcessado();
        if(ultNumero<rota) {
            ultNumero = rota;
        }
        
        return ultNumero;
    }
    
    public int pegarUltimaRotaCriadaProcessado() {
        int ultNumero;
        ultNumero = verificarUltimaRota("C:\\Teste\\Processado");
        return ultNumero;
    }
    
    public int pegarUltimaRotaCriadaNaoProcessado() {
        int ultNumero;
        ultNumero = verificarUltimaRota("C:\\Teste\\NaoProcessado");
        return ultNumero;
    }
    
    public int verificarUltimaRota(String rota) {
        File folder = new File(rota);
        int ultNumero = 0;
        
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                String nome = file.getName();
                //Tratamento do  nome do arquivo para pegar o número
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
           
    // Função para teste
    public void testeRota() {
        criarArquivoRota criarRota = new criarArquivoRota();
        Rota rota = new Rota();
        rota.setHeader("0002448");              //Cria o cabeçalho
        
        ArrayList resumoConexoes = new ArrayList();   //Cria as arestas
        resumoConexoes.add("010001=01");
        resumoConexoes.add("010001=02");
        rota.setResumoConexoes(resumoConexoes);
        
        ArrayList resumoPesos = new ArrayList();   //Cria as arestas
        resumoPesos.add("020001=01");
        resumoPesos.add("020001=02");
        rota.setResumoPesos(resumoPesos);
        
        rota.setTrailer("202304");          //Criado o trailer
        criarRota.criar(rota);
    }
}
