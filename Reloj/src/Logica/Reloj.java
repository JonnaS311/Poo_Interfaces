package Logica;

public class Reloj{
 private Hora hora;
 private Minuto minuto;
 private Segundo segundo;

  public Reloj(){
    hora = new Hora();
    minuto = new Minuto();
    segundo = new Segundo();
  }
  public Reloj(Hora hora, Minuto minuto, Segundo segundo){
    this.hora = hora;
    this.minuto = minuto;
    this.segundo = segundo;
  }
  
  public Reloj(int hora, int minuto, int segundo){
    this.hora = new Hora(hora);
    this.minuto = new Minuto(minuto);
    this.segundo = new Segundo(segundo);
  }

  public void avanzar(){
        this.segundo.setValor(this.segundo.getValor()+ 1);
        if(this.segundo.getValor()==0){
          this.minuto.setValor(this.minuto.getValor()+1);
        }
        if(this.minuto.getValor()==0 && this.segundo.getValor()==0){
          this.hora.setValor(this.hora.getValor()+1);
        }
  }
  
  public void retroceder(){
    this.segundo.setValor(this.segundo.getValor()-1);
    if(this.segundo.getValor()==this.segundo.getLimite()-1){
      this.minuto.setValor(this.minuto.getValor()-1);
    }
    if(this.minuto.getValor()==this.minuto.getLimite()-1 && this.segundo.getValor()==this.segundo.getLimite()-1){
      this.hora.setValor(this.hora.getValor()-1);
    }
  }
  public void reiniciar(){
    this.segundo.reiniciar();
    this.minuto.reiniciar();
    this.hora.reiniciar();
  }
  public void start(){

  }

  public Hora get_hora(){
    return this.hora;
  }
  public Minuto get_minuto(){
    return this.minuto;
  }
  public Segundo get_segundo(){
    return this.segundo;
  }
  public String toString(){
    return this.segundo.getValor()+"/"+this.minuto.getValor()+"/"+this.hora.getValor();
  }
}