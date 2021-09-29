import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import Logica.Reloj;

public class Interfaz extends JFrame {
    private JPanel panel;
    private JPanel panel_hora;
    private Reloj reloj;
    JLabel hora;
    static boolean estado = false;
    Interfaz(){
        this.setTitle("Reloj");
        this.setLayout(new GridLayout(2,1));
        panel();
        panel_hora();
        this.getContentPane().add(panel_hora);
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void panel(){
        this.panel = new JPanel();
        reloj = new Reloj(21,9,11);
        JButton avanzar = new JButton("Avanzar");
        JButton retroceder = new JButton("Retroceder");
        JButton reiniciar = new JButton("Reiniciar");
        hora= new JLabel(reloj.toString());
        avanzar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                estado = !estado;
                if(estado){
                    avanzar(true);
                    retroceder.setEnabled(false);
                }
                else{
                    avanzar(false);
                    
                    retroceder.setEnabled(true);
                }
            }});

        retroceder.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                estado = !estado;
                if(estado){
                    retroceder(true);
                    avanzar.setEnabled(false);
                }
                else{
                    retroceder(false);
                    avanzar.setEnabled(true);
                }
            }});
        
        reiniciar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                reloj.reiniciar();
                hora.setText(reloj.toString());
            }});
        
        this.panel.add(avanzar);
        this.panel.add(retroceder);
        this.panel.add(reiniciar);
    }
    public void panel_hora(){
        this.panel_hora = new JPanel();
        this.panel_hora.add(hora);

    }
    public void avanzar(boolean Estado){
        Runnable runnable = new Runnable(){
            public void run(){
                while(Interfaz.estado){
                try {
                    Thread.sleep(1000);
                    reloj.avanzar();
                    hora.setText(reloj.toString());
                    } catch (InterruptedException e) {
                    System.out.print("se interummpio");
                     Thread.currentThread().interrupt();
                    }        
                } 
            }
        };
        Thread hilo = new Thread(runnable);
        if(Estado){
            hilo.start();
        }
        else{
            estado =false;
        }   
    }
    public void retroceder(boolean Estado){
        Runnable runnable = new Runnable(){
            public void run(){
                while(Interfaz.estado){
                try {
                    Thread.sleep(1000);
                    reloj.retroceder();
                    hora.setText(reloj.toString());
                    } catch (InterruptedException e) {
                    System.out.print("se interummpio");
                     Thread.currentThread().interrupt();
                    }        
                } 
            }
        };
        Thread hilo = new Thread(runnable);
        if(Estado){
            hilo.start();
        }
        else{
            estado =false;
        }
        
    }
}

