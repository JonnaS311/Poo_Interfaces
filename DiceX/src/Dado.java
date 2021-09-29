import java.util.Random;
public class Dado {
    private int numero;
    private static Random r;

    public Dado(){
        r = new Random();
        this.generar_numero();
    }
    public void generar_numero(){
        this.numero = r.nextInt(6)+1;
    }
    public int get_numero(){
        return this.numero;
    }
}
