import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
    public Ventana(){
        this.setTitle("DiceX");
        this.setIconImage(new ImageIcon(getClass().getResource("/Dice/Icon.png")).getImage());
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void FontLabel(JLabel componente){
        componente.setFont(new Font("Segoe UI",Font.BOLD,20));
    }
    public void FontButton(JButton componente){
        componente.setFont(new Font("Segoe UI",Font.BOLD,20));
        componente.setBackground(new Color(62,34,89));
        componente.setForeground(new Color(230,230,230));
        componente.setBorder(BorderFactory.createEmptyBorder());
    }
    public void FontContraseña(JPasswordField componente){
        componente.setFont(new Font("Segoe UI",Font.BOLD,20));
    }
    public void FontField(JTextField componente){
        componente.setFont(new Font("Segoe UI",Font.BOLD,20));
    }
}
