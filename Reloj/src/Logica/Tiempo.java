package Logica;
public class Tiempo {
  private int limite;
  private int valor;

  public Tiempo(){
    limite = 0;
    valor=0;
  }
  
  public Tiempo(int limite){
    this.limite = limite;
    valor=0;
  }

  public void reiniciar(){
    this.valor=0;
  }
  
  //getters
  public int getLimite(){
    return this.limite;
  }
  public int getValor(){
    return this.valor;
  }
  //setters
  public void setLimite(int limite){
    this.limite=limite;
  }
  public void setValor(int valor){
    if(valor>=this.getLimite()){
      this.valor=0;
    }else if(valor<0){
      this.valor= this.getLimite()-1;
    }else{
      this.valor=valor;
    }
  }

}