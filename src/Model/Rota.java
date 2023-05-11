
package Model;

import java.util.ArrayList;

public class Rota {
    private String header;  
    private ArrayList listaRota = new ArrayList<String>();

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ArrayList getListaRota() {
        return listaRota;
    }

    public void setListaRota(ArrayList listaRota) {
        this.listaRota = listaRota; 
    }
    
    
    
}
