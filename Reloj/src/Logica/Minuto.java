package Logica;
public class Minuto extends Tiempo{
  public Minuto(){
    this.setLimite(60);
  }
  public Minuto(int valor){
    this.setLimite(60);
    this.setValor(valor);
  }
}