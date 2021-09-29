import javax.swing.*;

import Logica.*;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Interfaz extends JFrame {
    private JPanel panel_label;
    private JPanel panel; 
    private JPanel panel_res; 
    private JLabel resultado= new JLabel("resultado");;
    Punto3D a;
    Punto3D b;
    public Interfaz(){
        this.getContentPane().setLayout(new GridLayout(3,1,10,0));
        panel_label();
        panel();
        panel_res();
        this.getContentPane().add(this.panel_label);
        this.getContentPane().add(this.panel);
        this.getContentPane().add(this.panel_res);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void panel(){
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1,6,10,10));
        this.panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0,10));
        String[] operaciones = {"distancia3d", "distancia2d","Distancia Origen","Distancia Origen3d"};
        JComboBox<String> selector = new JComboBox<>(operaciones);
        JTextField punto1X = new JTextField("");
        JTextField punto1Y = new JTextField("");
        JTextField punto1Z = new JTextField("");
        JTextField punto2X = new JTextField("");
        JTextField punto2Y = new JTextField("");
        JTextField punto2Z = new JTextField("");
        JButton operar = new JButton("=");

        selector.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                if (selector.getSelectedItem().equals("distancia2d")){
                    punto1Z.setEditable(false);
                    punto1Z.setText("0");
                    punto2Z.setEditable(false);
                    punto2Z.setText("0");
                    //permitidos
                    punto1X.setEditable(true);
                    punto1Y.setEditable(true);
                    punto2X.setEditable(true);
                    punto2Y.setEditable(true);
                }
                if (selector.getSelectedItem().equals("Distancia Origen")){
                    punto2X.setEditable(false);
                    punto2X.setText("0");
                    punto2Y.setEditable(false);
                    punto2Y.setText("0");
                    punto2Z.setEditable(false);
                    punto2Z.setText("0");
                    punto1Z.setEditable(false);
                    punto1Z.setText("0");
                    //permitidos
                    punto1X.setEditable(true);
                    punto1Y.setEditable(true);
                }
                if (selector.getSelectedItem().equals("Distancia Origen3d")){
                    punto2X.setEditable(false);
                    punto2X.setText("0");
                    punto2Y.setEditable(false);
                    punto2Y.setText("0");
                    punto2Z.setEditable(false);
                    punto2Z.setText("0");
                    punto2Z.setEditable(false);
                    punto2Z.setText("0");
                    // permitidos
                    punto1X.setEditable(true);
                    punto1Y.setEditable(true);
                    punto1Z.setEditable(true);
                }
                if(selector.getSelectedItem().equals("distancia3d")){
                    punto1X.setEditable(true);
                    punto1Y.setEditable(true);
                    punto1Z.setEditable(true);
                    punto2X.setEditable(true);
                    punto2Y.setEditable(true);
                    punto2Z.setEditable(true);
                }
            }
        });
        if(selector.getSelectedItem().equals("Distancia Origen")){
            punto2X.setEditable(false);
            punto2Y.setEditable(false);
            punto2Z.setEditable(false);
        }
        operar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Boolean operar = true;
                try {
                    float X1 = Float.parseFloat(punto1X.getText());
                    float Y1 = Float.parseFloat(punto1Y.getText());
                    float Z1 = Float.parseFloat(punto1Z.getText());
                    float X2 = Float.parseFloat(punto2X.getText());
                    float Y2 = Float.parseFloat(punto2Y.getText());
                    float Z2 = Float.parseFloat(punto2Z.getText());    
                    if(operar){
                        if(selector.getSelectedItem().equals("distancia2d")){
                            a =new Punto3D(X1, Y1, Z1);
                            b =new Punto3D(X2, Y2, Z2);
                            resultado.setText(a.distancia(b)+"");
                        }
                        if(selector.getSelectedItem().equals("distancia3d")){
                            a =new Punto3D(X1, Y1, Z1);
                            b =new Punto3D(X2, Y2, Z2);
                            resultado.setText(a.distancia3D(b)+"");
                        }
                        if(selector.getSelectedItem().equals("Distancia Origen")){
                            a =new Punto3D(X1, Y1, Z1);
                            b =new Punto3D(X2, Y2, Z2);
                            resultado.setText(a.distancia(b)+"");
                        }
                        if(selector.getSelectedItem().equals("Distancia Origen3d")){
                            a =new Punto3D(X1, Y1, Z1);
                            b =new Punto3D(X2, Y2, Z2);
                            resultado.setText(a.distancia(b)+"");
                        }
                    }
                } catch (NumberFormatException o) {
                   System.out.println("exploto!! :v");
                   operar= false;
                }
            }
        });
        
        this.panel.add(selector);
        this.panel.add(punto1X);
        this.panel.add(punto1Y);
        this.panel.add(punto1Z);
        this.panel.add(punto2X);
        this.panel.add(punto2Y);
        this.panel.add(punto2Z);
        this.panel.add(operar);
    }
    public void panel_res(){
        this.panel_res = new JPanel();
        this.panel_res.add(this.resultado);
    }
    public void panel_label(){
        this.panel_label = new JPanel();
        this.panel_label.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));

        JLabel x1 = new JLabel("punto a X");
        JLabel y1 = new JLabel("punto a Y");
        JLabel z1 = new JLabel("punto a Z");

        JLabel x2 = new JLabel("punto b X");
        JLabel y2 = new JLabel("punto b Y");
        JLabel z2 = new JLabel("punto b Z");

        this.panel_label.add(x1);
        this.panel_label.add(y1);
        this.panel_label.add(z1);
        this.panel_label.add(x2);
        this.panel_label.add(y2);
        this.panel_label.add(z2);
        

    }

}
