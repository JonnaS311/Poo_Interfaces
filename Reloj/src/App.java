/*
    Jonnathan Sotelo Rodríguez 
    20202020040
    Universidad Distrital Francisco José de Caldas
    Programación Orientada a Objetos 
*/
import Logica.Reloj;

public class App {
    public static void main(String[] args) throws Exception {
        new Interfaz();
        Reloj j = new Reloj();
        j.start();
    }
}
