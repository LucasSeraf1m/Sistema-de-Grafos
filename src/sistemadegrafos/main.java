
package sistemadegrafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author lucas
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File arquivo = new File("C:\\Teste\\Configuracao\\config.txt");
        Scanner scan = new Scanner(arquivo);
        while(scan.hasNextLine()){
            String caminho[] = scan.nextLine().split("=");
            File pastas = new File(caminho[1]);
            boolean pasta = pastas.mkdirs();
            if(pasta){
                System.out.println("Pasta Criada");
            }else{
                System.out.println("Nao foi possivel criar pasta");
            }
        }
    }
    
}
