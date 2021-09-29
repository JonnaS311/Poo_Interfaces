package Logica;
public class Punto{
  protected double x;
  protected double y;

  // Getters
  public double getX(){
    return this.x;
  }
  public double getY(){
    return this.y;
  }
  // Setters :c
  public void setX(double x){
    this.x = x;
  }
  public void setY(double y){
    this.y = y;
  }

  public double distancia(Punto a){
    double result = Math.pow(a.getX() - this.x, 2) + Math.pow(a.getY() - this.y,2);
    result = Math.sqrt(result);
    return result;
  }
  public double distanciaOrigen(){
    double result = Math.pow(this.x, 2) + Math.pow(this.y,2);
    result = Math.sqrt(result);
    return result;
  }
  public void moverX(double x){
    this.x+= x;
  }
  public void moverY(double y){
    this.y= this.y + y;
  }
  public void moverXY(double x, double y){
    this.x= this.x + x;
    this.y= this.y + y;
  }
  public Punto(double x, double y){
    this.x=x;
    this.y=y;
  }
  public Punto(){
    this.x=0;
    this.y=0;
  }

  public void imprimir(){
      System.out.println(this.x + "," + this.y);
  }
}