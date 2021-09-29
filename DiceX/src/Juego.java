import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego extends Ventana{
    private JPanel panelDerecho;
    private JPanel panelIzquierdo;
    private Dado dado1;
    private Dado dado2;
    Logica_Juego logica;
    JTextField apuestaCasilla;
    JLabel saldo_usuario;
    JLabel ultimo_movimiento;
    int apuesta;
    
    public Juego(Logica_Juego j){
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        this.logica= j;
        this.apuestaCasilla = new JTextField(15);
        this.saldo_usuario = new JLabel(logica.Get_saldo_jugador()+"");
        ultimo_movimiento = new JLabel("Ultimo Movimiento");

        panelIzquierdo();
        panelDerecho();
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        this.add(panelDerecho);
        this.add(panelIzquierdo);
        this.pack();
        this.setVisible(true);
    }

    public void panelDerecho(){
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridLayout(5,0,8,8));
        panelDerecho.setBackground(new Color(60,78,195));
        JLabel nombre_usuario = new JLabel(logica.Get_nombre_jugador());
        
        //jugar.setMargin(new Insets(5, 5, 5, 5));
        //Modificaciones Componentes
        FontLabel(nombre_usuario);
        FontLabel(saldo_usuario);
        FontLabel(ultimo_movimiento);
        FontField(apuestaCasilla);
        nombre_usuario.setText(logica.Get_nombre_jugador());
        saldo_usuario.setText(logica.Get_saldo_jugador()+"");

        panelDerecho.add(nombre_usuario);
        panelDerecho.add(saldo_usuario);
        panelDerecho.add(apuestaCasilla);
        panelDerecho.add(ultimo_movimiento);
    }

    public void panelIzquierdo(){
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        panelIzquierdo.setBackground(new Color(60,78,195));
        dado1.generar_numero();
        dado2.generar_numero();

        JButton jugar = new JButton("Jugar!");
        JLabel dado1=new JLabel(new ImageIcon("src\\Dice\\Dado"+this.dado1.get_numero()+"(morado).png"));
        JLabel dado2=new JLabel(new ImageIcon("src\\Dice\\Dado"+this.dado2.get_numero()+"(rojo).png"));
        FontButton(jugar);

        jugar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                apuesta = Integer.parseInt(apuestaCasilla.getText());
                if(apuesta<=logica.Get_saldo_jugador()+1){
                    Juego.this.dado1.generar_numero();
                    Juego.this.dado2.generar_numero();
                    int aux = logica.Get_saldo_jugador();
                    dado1.setIcon(new ImageIcon("src\\Dice\\Dado"+Juego.this.dado1.get_numero()+"(morado).png"));
                    dado2.setIcon(new ImageIcon("src\\Dice\\Dado"+Juego.this.dado2.get_numero()+"(rojo).png"));
                    try {
                        jugar(apuesta);
    
                    } catch (org.json.simple.parser.ParseException e1) {
                        e1.printStackTrace();
                    }
    
                    if(aux>logica.Get_saldo_jugador()){
                        ultimo_movimiento.setText("Perdio!! -"+apuesta);
                    }
                    else if(aux<logica.Get_saldo_jugador()){
                        ultimo_movimiento.setText("Ganó!! +"+apuesta);
                    }
                    else{
                        try {
                            logica.revancha();
        
                        } catch (org.json.simple.parser.ParseException e1) {
                            e1.printStackTrace();
                        } 
                        Juego.this.dado1 = logica.getDado1();
                        Juego.this.dado2 = logica.getDado2();
                        dado1.setIcon(new ImageIcon("src\\Dice\\Dado"+Juego.this.dado1.get_numero()+"(morado).png"));
                        dado2.setIcon(new ImageIcon("src\\Dice\\Dado"+Juego.this.dado2.get_numero()+"(rojo).png"));
                        if(aux>logica.Get_saldo_jugador()){
                            ultimo_movimiento.setText("(revancha) Perdio!! -"+apuesta);
                        }
                        else if(aux<logica.Get_saldo_jugador()){
                            ultimo_movimiento.setText("(revancha) Ganó!! +"+apuesta);
                        }
                    }
                    saldo_usuario.setText(logica.Get_saldo_jugador()+"");
                    apuestaCasilla.setText("");
                }
                else{
                    ultimo_movimiento.setText("Upps! creo que no te alcanza");
                }
            }
        });
        panelIzquierdo.add(dado1,c);
        panelIzquierdo.add(dado2);
        c.gridy= 1;
        c.ipady = 40;
        c.ipadx = 100;
        c.fill = GridBagConstraints.CENTER;
        c.gridwidth = 3;
        c.insets = new Insets(20,10,20,10);
        panelIzquierdo.add(jugar,c);
    }
    public void jugar(int apuesta) throws org.json.simple.parser.ParseException{
        logica.setApuesta(apuesta);
        logica.setDado1(dado1);
        logica.setDado2(dado2);
        logica.Logica();

    }


}