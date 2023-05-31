
package Control;

import Model.Rota;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lucas
 */


public class main {
    
    public static int lerEstacao(final String tipoNo, final Scanner in) {

		while (true) {
			System.out.println(tipoNo+":");
			String linha = in.nextLine().trim();
			if (linha.isEmpty()) {
				System.out.println("Até a próxima!");
				System.exit(0);
			}
			
			try {
				int estacao = Integer.parseInt(linha);
				if (estacao >= 1 && estacao <= 20) {
					return estacao - 1;
				}
				else {
					System.out.println("Digite uma estação válida. Opções: 1 a 20");	
				}
			}
			catch (Exception e) {
				System.out.println("Digite uma estação válida. Opções: 1 a 20");
			}	
		}
	}

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

    
    
   
        
    }
}
