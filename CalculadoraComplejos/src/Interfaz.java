/*  
    Jonnathan Sotelo Rodríguez
    20202020040
    Programación Orientada a Objetos
    Universidad Distrital 
*/

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame{
    private JPanel panel_label;
    private JPanel panel;
    private Calculadora c;
    JLabel resultado= new JLabel("resultado");
    JPanel panel_respuesta;
    

    public Interfaz(){
        this.setTitle("CalculadoraComplejos");
        this.getContentPane().setLayout(new GridLayout(3,1,0,0));
        //componentes
        panel();
        panel_respuesta();
        panel_label();
        this.getContentPane().add(panel_label);
        this.getContentPane().add(panel);
        this.getContentPane().add(panel_respuesta);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void panel(){
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1,5,10,10));
        this.panel.setBorder(BorderFactory.createEmptyBorder(0, 50, 5,50));

        String[] operaciones = {"suma","resta","multiplicacion","division","conjugado","norma"};
        JComboBox<String> selector = new JComboBox<String>(operaciones);

        JTextField primer_real = new JTextField("",6);
        JTextField primer_ima = new JTextField("",6);
        JTextField segundo_real = new JTextField("",6);
        JTextField segundo_ima = new JTextField("",6);
        JButton operar = new JButton("= ");
        // eventos 
        selector.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                if(selector.getSelectedItem().equals("conjugado")||selector.getSelectedItem().equals("norma")){
                    segundo_real.setEditable(false);
                    segundo_ima.setEditable(false);
                    segundo_real.setText("0");
                    segundo_ima.setText("0");
                    primer_real.setText("");
                    primer_ima.setText("");
                }
                else{
                    segundo_real.setEditable(true);
                    segundo_ima.setEditable(true);
                    segundo_real.setText("");
                    segundo_ima.setText("");
                }
            }
        });

        operar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                Boolean operar= true;
                try {
                    float real1 = Float.parseFloat(primer_real.getText());
                    float ima1 = Float.parseFloat(primer_ima.getText());
                    float real2 = Float.parseFloat(segundo_real.getText());
                    float ima2 = Float.parseFloat(segundo_ima.getText());
                    cargar_datos(real1,ima1,real2,ima2);
                } catch (NumberFormatException o) {
                   System.out.println("exploto!! :v");
                   operar= false;
                }
                if(operar){
                    if(selector.getSelectedItem().equals("suma")){
                        resultado.setText(c.suma());
                    }
                    if(selector.getSelectedItem().equals("resta")){
                        resultado.setText(c.resta());
                    }
                    if(selector.getSelectedItem().equals("multiplicacion")){
                        resultado.setText(c.multiplicacion());
                    }
                    if(selector.getSelectedItem().equals("division")){
                        resultado.setText(c.division());
                    }
                    if(selector.getSelectedItem().equals("conjugado")){
                        resultado.setText(c.conjugado(c.getCom_real1(),c.getCom_ima1()));
                    }
                    if(selector.getSelectedItem().equals("norma")){
                        resultado.setText(c.norma(c.getCom_real1(),c.getCom_ima1()));
                }
                
                }       
                }
            });
        this.panel.add(selector);
        this.panel.add(primer_real);
        this.panel.add(primer_ima);
        this.panel.add(segundo_real);
        this.panel.add(segundo_ima);
        this.panel.add(operar);
    }
    public void panel_respuesta(){
        this.panel_respuesta = new JPanel();
        this.panel_respuesta.add(resultado);

    }
    public void cargar_datos(float real1,float ima1,float real2, float ima2){
        c = new Calculadora(real1,ima1,real2,ima2);
    }
    public void panel_label(){
        this.panel_label = new JPanel();
        this.panel_label.setLayout(new FlowLayout(FlowLayout.CENTER,30,5));

        JLabel complejo_real1 = new JLabel("Complejo 1 Real");
        JLabel complejo_ima1 = new JLabel("Complejo 1 Ima");

        JLabel complejo_real2 = new JLabel("Complejo 2 Real");
        JLabel complejo_ima2 = new JLabel("Complejo 2 Ima");

        this.panel_label.add(complejo_real1);
        this.panel_label.add(complejo_ima1);
        this.panel_label.add(complejo_real2);
        this.panel_label.add(complejo_ima2);
    }
}
