import java.awt.*;
import javax.swing.*;

import org.json.simple.parser.ParseException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Registro extends Ventana {
    private JPanel panel;

    public Registro(){
        this.panel();
        this.getContentPane().add(this.panel);
        this.pack();
    }
    public void panel(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(6,1,10,5));
        panel.setBackground(new Color(60,78,195));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100,150));

        JTextField usuario= new JTextField();
        JTextField contraseña = new JPasswordField();
        JLabel n_contraseña = new JLabel("Contraseña");
        JLabel n_usuario = new JLabel("Nombre de Usuario");
        JButton añadir = new JButton("Añadir");
        
        FontLabel(n_usuario);
        FontLabel(n_contraseña);
        FontButton(añadir);
        FontField(contraseña);
        FontField(usuario);

        //eventos
        añadir.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                try{
                    String Obtener_nombre = usuario.getText();
                    String Obtener_contraseña = contraseña.getText();
                    
                    if(!Obtener_nombre.equals("") && !Obtener_contraseña.equals("")){
                        guardar_datos(Obtener_nombre, Obtener_contraseña);
                    }
                    Registro.this.setVisible(false);
                    new InicioSesion();               
                }catch(ParseException o){
                }   
            }
        });

        panel.add(n_usuario);
        panel.add(usuario);
        panel.add(n_contraseña);
        panel.add(contraseña);
        panel.add(añadir);
    }
    public void guardar_datos(String nombre,String contraseña) throws ParseException{
        Jugador nuevo =new Jugador(nombre, contraseña, 1000);
        nuevo.guardar();
        
    }
}
