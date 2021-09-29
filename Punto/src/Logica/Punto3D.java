package Logica;
public class Punto3D extends Punto{
  private double z;
  
  public double MoverZ(double z){
    this.z= this.z + z;
    return this.z;
  }
  public double getZ(){
    return this.z;
  }
  public void setZ(double z){
    this.z = z;
  }
  public void moverXYZ(double x, double y, double z){
    this.x+=x;
    this.y+=y;
    this.z+=z;
  }
  public double distancia3D(Punto3D a){
    double result = Math.pow(a.x - this.x, 2) + Math.pow(a.y - this.y,2) + Math.pow(a.z - this.z, 2);
    result = Math.sqrt(result);
    return result;
  }
  public double distanciaOrigen3D(){
    double result = Math.pow(this.x, 2) + Math.pow(this.y,2)+ Math.pow(this.z, 2);
    result = Math.sqrt(result);
    return result;
  }

  public Punto3D(double x,double y,double z){
    super(x,y);
    this.z = z;
  }
   public Punto3D(){
    super(0,0);
    this.z = 0;
   }
}