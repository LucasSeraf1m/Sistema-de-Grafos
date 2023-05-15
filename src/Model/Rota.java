
package Model;

import java.util.ArrayList;

public class Rota {
    private String header;  
    private ArrayList resumoConexoes = new ArrayList<String>();
    private ArrayList resumoPesos = new ArrayList<String>();
    private String trailer;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ArrayList getResumoConexoes() {
        return resumoConexoes;
    }

    public void setResumoConexoes(ArrayList resumoConexoes) {
        this.resumoConexoes = resumoConexoes;
    }

    public ArrayList getResumoPesos() {
        return resumoPesos;
    }

    public void setResumoPesos(ArrayList resumoPesos) {
        this.resumoPesos = resumoPesos;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
