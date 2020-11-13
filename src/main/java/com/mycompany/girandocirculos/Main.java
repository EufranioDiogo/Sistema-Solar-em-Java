package com.mycompany.girandocirculos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author ed
 */
public class Main extends JFrame {
    public Main() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        setSize(screenSize.width / 2, screenSize.height / 2);
        
        Dimension windowSize = getSize();
        setTitle("Ola");
        add(new Tela());
        
        int x = (screenSize.width - windowSize.width) / 2;
        int y = (screenSize.height - windowSize.height) / 2;
        setBackground(Color.BLACK);
        setLocation(x, y);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Main();
        
    }
}
