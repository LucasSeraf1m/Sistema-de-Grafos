package sistemadegrafos;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Rotas {
    
    int somaPeso = 0;
    int somaPesoHI;
    
    public void verificacao(ArrayList<String> al){
        try {
            String quantNOH = "";
            String somaPesoH = "";
            int countLinhaCT = 0;
            int countLinhaC = 0;
            int countLinhaP = 0;
            int countLinhaPT = 0;        
            ArrayList<String> arlNos = new ArrayList<String>();
            for(int i = 0; i < al.size(); i++){
               String linha = al.get(i);
               if(linha.startsWith("00")){
                   if(linha.length() != 8){
                        throw new Exception("Header Invalido");
                   }
                   quantNOH = linha.substring(2, 4);
                   somaPesoH = linha.substring(4, 8);
               }   
               if(linha.startsWith("01")){
                   countLinhaC++;
                   if(linha.length() != 7){
                        throw new Exception("Resumo de Conexoes Invalido");
                   }
                   String no = linha.substring(2, 4);
                   if(!arlNos.contains(no)){
                       arlNos.add(no);
                   }
                   String nos[] = al.get(i).split("=");
                   if(!arlNos.contains(nos[1])){
                       arlNos.add(nos[1]);
                   }
               }
               if(linha.startsWith("02")){
                   countLinhaP++;
                   String peso[] = al.get(i).split("=");
                   somaPeso += Integer.parseInt(peso[1]);
               }
               if(linha.startsWith("09")){
                   String trailer[] = al.get(i).split(";");
                   String rc = linha.substring(2, 4);
                   countLinhaCT = Integer.parseInt(rc);
                   countLinhaPT = Integer.parseInt(trailer[1]);
               }
            }
            //verificacoes para retorno
            int quantNO = Integer.parseInt(quantNOH);
            if(quantNO != arlNos.size()){
                throw new Exception("Numero Totais de Nos Invalidos");
            }
            somaPesoHI = Integer.parseInt(somaPesoH);
            if(somaPesoHI != somaPeso){
                throw new Exception("Soma dos pesos difere (Valor do registro Header = " + somaPesoHI + " e soma dos pesos = "+somaPeso+")");
            }
            if(countLinhaC != countLinhaCT){
                throw new Exception("Numero de Linhas de Conexoes Diferentes");
            }
            if(countLinhaP != countLinhaPT){
                throw new Exception("Numero de Linhas de Pesos Diferentes");
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
