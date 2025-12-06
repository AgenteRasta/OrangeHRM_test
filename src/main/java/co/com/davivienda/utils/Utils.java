package co.com.davivienda.utils;

public class Utils {

    public static void generarEspera(int segundos) {
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
