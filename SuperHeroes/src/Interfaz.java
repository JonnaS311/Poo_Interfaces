import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import superheroes.Eternos;
import superheroes.GuardianesDelUniverso;
import superheroes.Simbionte;

import java.awt.event.*;
public class Interfaz extends JFrame{
    private JPanel superHeroes;
    private JPanel botones;
    private Simbionte venom;
    private Eternos thanos;
    private GuardianesDelUniverso linternaVerde;
    public Interfaz(){
        this.setTitle("Superheroes");
        this.getContentPane().setLayout(new GridLayout(2,1,10,10));
        //instancia del superheroe
        venom = new Simbionte();
        thanos = new Eternos();
        linternaVerde = new GuardianesDelUniverso();
        //componentes
        superHeroes();
        botones();
        this.add(superHeroes);
        this.add(botones);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void superHeroes(){
        this.superHeroes = new JPanel();
        Image venomI= new ImageIcon("src\\Image\\venom.jpg").getImage().getScaledInstance(225, 150, Image.SCALE_SMOOTH);
        Image linternaVerdeI =new ImageIcon("src\\Image\\LinternaVerde.jpg").getImage().getScaledInstance(225, 150, Image.SCALE_SMOOTH);
        Image thanosI =new ImageIcon("src\\Image\\thanos.jpg").getImage().getScaledInstance(225, 150, Image.SCALE_SMOOTH);
        JLabel venom = new JLabel(new ImageIcon(venomI));
        JLabel thanos = new JLabel(new ImageIcon(thanosI));
        JLabel linternaVerde = new JLabel(new ImageIcon(linternaVerdeI));

        this.superHeroes.add(venom);
        this.superHeroes.add(thanos);
        this.superHeroes.add(linternaVerde);
    }
    public void botones(){
        this.botones = new JPanel();
        JButton venom = new JButton("Venom");
        JButton thanos = new JButton("thanos");
        JButton linternaVerde = new JButton("Linterna Verde");
        venom.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 90, 10, 90),  new EtchedBorder()));
        thanos.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 90, 10, 90),  new EtchedBorder()));
        linternaVerde.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 90, 10, 90),  new EtchedBorder()));

        venom.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(null, "Parasitaje: "+Interfaz.this.venom.parasitaje()+"\nEctosimbiosis: "+Interfaz.this.venom.ectosimbiosis());
            }
        });
        thanos.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(null, "conservar Conocimiento: "+Interfaz.this.thanos.conservarConocimiento()+"\nRegeneración: "+Interfaz.this.thanos.regeneracion()+"\nResistencia: "+Interfaz.this.thanos.resistencia());
            }
        });
        linternaVerde.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(null, "Conciencia Cosmica: "+Interfaz.this.linternaVerde.concienciaCosmica()+"\nResistencia: "+Interfaz.this.linternaVerde.resistencia());
            }
        });
        this.botones.add(venom);
        this.botones.add(thanos);
        this.botones.add(linternaVerde);
    }
}
