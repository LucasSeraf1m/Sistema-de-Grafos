
package Model;

public class Config {
    private static String linhaProcessado; 
    private static String linhaNaoProcessado; 
    private static String linhaRotaAutomaica;

    public static String getLinhaProcessado() {
        return linhaProcessado;
    }

    public static void setLinhaProcessado(String linhaProcessado) {
        Config.linhaProcessado = linhaProcessado;
    }

    public static String getLinhaNaoProcessado() {
        return linhaNaoProcessado;
    }

    public static void setLinhaNaoProcessado(String linhaNaoProcessado) {
        Config.linhaNaoProcessado = linhaNaoProcessado;
    }

    public static String getLinhaRotaAutomaica() {
        return linhaRotaAutomaica;
    }

    public static void setLinhaRotaAutomaica(String linhaRotaAutomaica) {
        Config.linhaRotaAutomaica = linhaRotaAutomaica;
    }
    
    
}
