import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

import java.io.Reader;
import org.json.simple.parser.ParseException;


public class InicioSesion extends Ventana{
    private JPanel panel;

    public InicioSesion(){
        panel_superior();
        this.getContentPane().add(this.panel);
        this.pack();
    }

    public void panel_superior(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(6,1,10,5));
        panel.setBackground(new Color(60,78,195));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100,150));

        JTextField usuario= new JTextField();
        JTextField contraseña = new JPasswordField();
        JButton ingresar = new JButton("ingresar");
        JButton registro = new JButton("registrarse");
        JLabel n_usuario = new JLabel("Nombre de Usuario");
        JLabel n_contraseña = new JLabel("Contraseña");
        //propiedades Componentes
        
        FontLabel(n_usuario);
        FontLabel(n_contraseña);
        FontButton(registro);
        FontButton(ingresar);
        FontField(contraseña);
        FontField(usuario);
        
        //eventos
        
        ingresar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                try {
                    String Obtener_nombre = usuario.getText();
                    String Obtener_contraseña = contraseña.getText();
                    validar_Entrada(Obtener_nombre,Obtener_contraseña);

                } catch (ParseException e1) {
                }
            }
        });

        registro.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                new Registro();
                cerrar();

            }
        });

        panel.add(n_usuario);
        panel.add(usuario);
        panel.add(n_contraseña);
        panel.add(contraseña);
        panel.add(ingresar);
        panel.add(registro);
    }

    public void cerrar(){
        this.setVisible(false);
    }
    public void validar_Entrada(String nombre,String password) throws ParseException{
        JSONObject usuario = new JSONObject();
        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("src\\Usuarios.json")){
            usuario = (JSONObject) parser.parse(reader);
            if(usuario.get(nombre)!= null){
                JSONArray datos = (JSONArray) usuario.get(nombre);
                String contraseña = (String) datos.get(0);
                if(contraseña.equals(password)){
                    this.setVisible(false);
                    int saldo = (int)((long) datos.get(1));
                    Logica_Juego j = new Logica_Juego(new Jugador(nombre,password,saldo));
                    new Juego(j);
                }
            } 
        }catch(IOException e){

        }   
    }
}