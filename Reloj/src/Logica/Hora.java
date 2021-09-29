package Logica;
public class Hora extends Tiempo{
  public Hora(){
    this.setLimite(24);
    this.setValor(0);
  }
  public Hora(int valor){
    this.setLimite(24);
    this.setValor(valor);
  }
}