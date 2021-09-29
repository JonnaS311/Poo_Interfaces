import org.json.simple.parser.ParseException;

public class Logica_Juego {
    private Dado dado1;
    private Dado dado2;
    private Jugador jugador;
    private int apuesta;

    public Logica_Juego(Jugador jugador){
        this.jugador = jugador;
    }
    public String Get_nombre_jugador(){
        return jugador.get_nombre();
    }
    public int Get_saldo_jugador(){
        return jugador.get_saldo();
    }
    public Dado getDado1() {
        return dado1;
    }
    public Dado getDado2() {
        return dado2;
    }
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }
    public void setDado1(Dado dado1) {
        this.dado1 = dado1;
    }
    public void setDado2(Dado dado2) {
        this.dado2 = dado2;
    }
    public int Logica()throws ParseException{
        if(this.dado1.get_numero()+this.dado2.get_numero() == 2 ||this.dado1.get_numero()+this.dado2.get_numero() == 3 || this.dado1.get_numero()+this.dado2.get_numero() == 12){
            jugador.set_saldo(jugador.get_saldo()-this.apuesta);
            System.out.println("perdio!!");
            nuevoSaldo();
            return  jugador.get_saldo();
        }
        else if(dado1.get_numero()+dado2.get_numero() == 7 || dado1.get_numero()+dado2.get_numero() == 11){
            jugador.set_saldo(jugador.get_saldo()+this.apuesta);
            System.out.println("gano!!");
            nuevoSaldo();
            return  jugador.get_saldo();
        }
        return this.apuesta;
    }
    public void nuevoSaldo() throws ParseException{
        jugador.nuevoSaldo();
    }
    public int revancha() throws ParseException{
        int valor_ganar= dado1.get_numero()+dado2.get_numero();
            do{
                this.dado1.generar_numero();
                this.dado2.generar_numero();
                if(this.dado1.get_numero()+this.dado2.get_numero()==valor_ganar){
                    jugador.set_saldo(jugador.get_saldo()+this.apuesta);
                    nuevoSaldo();
                    return  jugador.get_saldo();
                }
                else if(this.dado1.get_numero()+this.dado2.get_numero()==7){
                    jugador.set_saldo(jugador.get_saldo()-this.apuesta);
                    nuevoSaldo();
                    return  jugador.get_saldo();
                }
            }while(this.dado1.get_numero()+this.dado2.get_numero()!=7||this.dado1.get_numero()+this.dado2.get_numero()!=valor_ganar);
            return 0;
    }
}
