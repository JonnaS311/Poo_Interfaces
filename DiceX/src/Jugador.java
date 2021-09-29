import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.Reader;
import org.json.simple.parser.ParseException;
public class Jugador {
    private String nombre;
    private String contraseña;
    private int saldo;

    public Jugador(String nombre, String contraseña,int saldo){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.saldo= saldo;
    }
    public String get_nombre(){
        return this.nombre;
    }
    public String get_contraseña(){
        return this.contraseña;
    }
    public int get_saldo(){
        return this.saldo;
    }
    public void set_saldo(int saldo){
        this.saldo= saldo;
    }
    @SuppressWarnings("unchecked")
    public void guardar() throws ParseException{
        JSONObject usuario = new JSONObject();
        JSONArray datos = new JSONArray();
        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("src\\Usuarios.json")){
            usuario = (JSONObject) parser.parse(reader);
            datos.add(this.contraseña);
            datos.add(this.saldo);
            usuario.put(this.nombre,datos);
            try(FileWriter file = new FileWriter("src\\Usuarios.json",false
            )){
                file.write(usuario.toJSONString());
                file.close();
            }catch(IOException e){
                System.out.print("fallo!!");
            }
        }catch(IOException e){

        }
        // Añadir los Datos
    }
    @SuppressWarnings("unchecked")
    public void nuevoSaldo() throws ParseException{
        JSONObject usuario = new JSONObject();
        JSONArray datos = new JSONArray();
        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("src\\Usuarios.json")){
            usuario = (JSONObject) parser.parse(reader);
            datos.add(this.contraseña);
            datos.add(this.saldo);
            usuario.replace(this.nombre, datos);
            try(FileWriter file = new FileWriter("src\\Usuarios.json",false
            )){
                file.write(usuario.toJSONString());
                file.close();
            }catch(IOException e){
                System.out.print("fallo!!");
            }
        }catch(IOException e){

        }
    }
}
