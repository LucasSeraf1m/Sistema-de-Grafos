package Pacote;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import Pacote.Grafo;
import Pacote.Grafo.Vertice;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception{
        File arquivo = new File("C:\\Users\\felip\\OneDrive\\Área de Trabalho\\configs.txt");
            Scanner scan = new Scanner(arquivo);
            Grafo g = new Grafo();
            String valor[];
            int x = -1;
            int duplicados = 0,  negativos = 0;
            ArrayList linhasNeg = new ArrayList<Integer>();
            ArrayList linhasDup = new ArrayList<Integer>();
            ArrayList list = new ArrayList<Integer>();
            ArrayList listVertices = new ArrayList<Vertice>();
            
            while(scan.hasNextLine()) {
                if(x == -1) {
                    System.out.println(scan.nextLine());
                    x++;
                } else {
                    valor = scan.nextLine().split(": ");
                    
                    if(!valor[1].equals("TRAILER33")) {
                        int valorN = Integer.parseInt(valor[1]);
                        if(valorN > 0) {
                            if(list.contains(valorN)) {
                                duplicados++;
                                linhasDup.add(x+1);
                            }else {
                                
                                Vertice ver = g.addVertice(valor[1].toString());
                                
                                list.add(Integer.parseInt(valor[1]));
                                listVertices.add(ver);
                            }
                        } else {
                            negativos++;
                            linhasNeg.add(x);
                        }

//					if (valor[1].endsWith("1") && g.vertices[x] {
//						
//						g.addAresta(valor[1], null);
//					}

                    }
            }			
            x++;
        }
            
        x=0;
        for (Object ver: listVertices) {
            if(Integer.parseInt(ver.toString()) < 700) {
                if (ver.toString().endsWith("1")  ) {
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+1));
                } else if(ver.toString().endsWith("2")) {
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+1));
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+3));
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+4));
                } else if(ver.toString().endsWith("3")) {
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+1));
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+3));
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+4));
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+5));
                } else if(ver.toString().endsWith("4")) {
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+3));
                    g.addAresta((Grafo.Vertice) listVertices.get(x), (Grafo.Vertice) listVertices.get(x+4));
                }
            }
            
           
//            System.out.println(ver.toString());
//            System.out.println(x);
            x++;
            
        }
        
        FileWriter   arquivoVertices = new FileWriter ("C:\\Users\\felip\\OneDrive\\Área de Trabalho\\arquivoVertices.txt");
        arquivoVertices.write(g.toString());
        arquivoVertices.write("\n");
        arquivoVertices.write("Quantidade de números duplacados: " + duplicados + ". Nas linhas: ");
        for(Object i: linhasDup) {
            arquivoVertices.write(i + ", ");
        }
        arquivoVertices.write("\nQuantidade de números negativos: " + negativos + ". Nas linhas: ");
        for(Object i: linhasNeg) {
            arquivoVertices.write(i + ", ");
        }
        arquivoVertices.close();
        
//        System.out.println();
//        g.addAresta(list.get(1), list.get(1));
//                
//        for(int t = 0; t<list.size(); t++) {
//            
//            System.out.println(list.get(t));
//        }
        
//        System.out.println("");
//        System.out.println("Números duplicados: " + duplicados);
    }
}