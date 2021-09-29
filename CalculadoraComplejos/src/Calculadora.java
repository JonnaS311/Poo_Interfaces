public class Calculadora {
    private float com_real1;
    private float com_ima1;
    private float com_real2;
    private float com_ima2;

    public Calculadora(float real1,float ima1,float real2, float ima2){

        this.com_real1= real1;
        this.com_ima1= ima1;
        this.com_real2= real2;
        this.com_ima2= ima2;
    }
    public Calculadora(){
        this.com_real1= 0;
        this.com_ima1= 0;
        this.com_real2= 0;
        this.com_ima2= 0;
    }

    public String suma(){
        float res_real= 0;
        float res_ima= 0;
        res_real= this.com_real1 + this.com_real2;
        res_ima = this.com_ima1 + this.com_ima2;
        if(res_ima>=0){
            return res_real+"+"+res_ima+"i";
        }
        else{
            return res_real+""+res_ima+"i";
        }   
      }
      public String resta(){
        float res_real= 0;
        float res_ima= 0;
        res_real= this.com_real1 - this.com_real2;
        res_ima = this.com_ima1 - this.com_ima2;
        if(res_ima>=0){
            return res_real+"+"+res_ima+"i";
        }
        else{
            return res_real+""+res_ima+"i";
        }   
      }
      // falta division, no tenía ganas de hacerla hoy :c
      public String division(){
        float res_real= 0;
        float res_ima= 0;
        double cociente;
        
        cociente= com_real2*com_real2 + com_ima2*com_ima2;
    
        res_real= com_real1*com_real2 + com_ima1*com_ima2;
    
        res_ima= com_real1*com_ima2*(-1) + com_real2*com_ima1;
    
        if(com_real2!=0){
            if(res_ima>=0){
                return res_real+"/"+cociente+"+"+res_ima+"/"+cociente+"i";
            }
            else{
                return res_real+"/"+cociente+""+res_ima+"/"+cociente+"i";
            }  
        }
        else{
          return "División entre 0";
        }
      }
      public String multiplicacion(){
        float res_real= 0;
        float res_ima= 0;
        res_real=(com_real1*com_real2)-(com_ima1*com_ima2);
        res_ima= (com_real1*com_ima2)+(com_real2*com_ima1);
        if(res_ima>=0){
            return res_real+"+"+res_ima+"i";
        }
        else{
            return res_real+""+res_ima+"i";
        }   
      }
      public String conjugado(float com_real, float com_ima){
        com_ima= com_ima*-1;
        if(com_ima>0){
            return com_real+"+"+com_ima+"i";
        }
        else{
            return com_real+""+com_ima+"i";
        } 
      }
      public String norma(float com_real, float com_ima){
        double resultado;
        resultado =  Math.sqrt(Math.pow(com_real,2)+Math.pow(com_ima,2));
        resultado= Math.round(resultado*100);
        resultado= resultado/100;
        return resultado+"";
      }

      //setter & getters
     public float getCom_ima1() {
         return com_ima1;
     }
     public float getCom_ima2() {
         return com_ima2;
     }
     public float getCom_real1() {
         return com_real1;
     }
     public float getCom_real2() {
         return com_real2;
     }
}
