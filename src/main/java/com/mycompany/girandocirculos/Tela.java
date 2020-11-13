package com.mycompany.girandocirculos;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author ed
 */
public class Tela extends JPanel implements Runnable {
    private final Thread thread;
    private float mercuryDegree = 0;
    private float venusDegree = 0;
    private float earthDegree = 0;
    private float moonDegree = 0;
    private float marsDegree = 0;
    private float jupiterDegree = 0;
    private float saturnDegree = 0;
    private float uranusDegree = 0;
    private float neptuneDegree = 0;
    private float plutoDegree = 0;
    private Point sunPosition = new Point(300, 100);
    private Dimension sunSize = new Dimension(90, 90);
    private Point sunCenter;
    private Point sunBorder;
    private int marsXPosition;
    
    public Tela() {
        thread = new Thread(this, "Rotate Scare");
        thread.start();
        setBackground(Color.BLACK);
    }
    @Override
    public void paintComponent(Graphics g){
        
            Graphics2D g2 = (Graphics2D) g;
            Dimension screenSize = getSize();
            
            super.paintComponent(g2);
            
            sunPosition.x = ((screenSize.width / 2) - (sunSize.width / 2));
            sunPosition.y = ((screenSize.height / 2) - (sunSize.height / 2));
            sunCenter = new Point(this.sunPosition.x + (sunSize.width / 2), this.sunPosition.y + (sunSize.height / 2));
            sunBorder = new Point(sunCenter.x + (sunSize.width / 2), sunCenter.y + (sunSize.height / 2));
            
            
            g2.setColor(Color.YELLOW);
            g2.fillOval(sunPosition.x, sunPosition.y, (int) sunSize.getWidth(), (int) sunSize.getHeight());
            
            // Mercury
            g2.setColor(new Color(66, 66, 66));
            g2.rotate(Math.toRadians(mercuryDegree), sunCenter.x, sunCenter.y);
            g2.fillOval((this.sunBorder.x) + 25, (this.sunCenter.y), 10, 10);
            
            
            // Venus
            g2.setColor(new Color(224, 224, 38));
            g2.rotate(Math.toRadians(venusDegree), sunCenter.x, sunCenter.y);
            g2.fillOval((this.sunBorder.x) + 50, (this.sunCenter.y), 15, 15);
            
            
            
            
            
            //Mars
            g2.setColor(Color.RED);
            g2.rotate(Math.toRadians(marsDegree), sunCenter.x, sunCenter.y);
            g2.fillOval(this.sunBorder.x + 135, sunCenter.y, 12, 12);
            
            
            //Jupiter
            g2.setColor(new Color(155, 142, 3));
            g2.rotate(Math.toRadians(jupiterDegree), sunCenter.x, sunCenter.y);
            g2.fillOval(this.sunBorder.x + 170, sunCenter.y, 50, 50);
            
            
            //Saturn
            Ellipse2D saturn = new Ellipse2D.Double(this.sunBorder.x + 225, sunCenter.y, 45, 45);
            g2.setColor(new Color(191, 170, 118));
            g2.rotate(Math.toRadians(saturnDegree), sunCenter.x, sunCenter.y);
            g2.fill(saturn);
            
            
            //Uranus
            g2.setColor(new Color(0, 153, 255));
            g2.rotate(Math.toRadians(uranusDegree), sunCenter.x, sunCenter.y);
            g2.fillOval(this.sunBorder.x + 300, sunCenter.y, 40, 40);
            
            
            //Neptune
            g2.setColor(new Color(0, 85, 255));
            g2.rotate(Math.toRadians(neptuneDegree), sunCenter.x, sunCenter.y);
            g2.fillOval(this.sunBorder.x + 345, sunCenter.y, 41, 41);
            
            
            //pluto
            g2.setColor(new Color(255, 255, 255));
            g2.rotate(Math.toRadians(plutoDegree), sunCenter.x, sunCenter.y);
            g2.fillOval(this.sunBorder.x + 400, sunCenter.y, 5, 5);
            
            
            // Earth
            g2.setColor(Color.BLUE);
            Ellipse2D earth = new Ellipse2D.Double((int)(this.sunBorder.x) + 75, (int)(this.sunCenter.y), 15, 15);
            g2.rotate(Math.toRadians(this.earthDegree), this.sunCenter.x, this.sunCenter.y);
            g2.fill(earth);
            
            // Earth moon
            g2.setColor(Color.WHITE);
            Ellipse2D moon = new Ellipse2D.Double(earth.getCenterX() + (int)(earth.getWidth() / 2) + 10, earth.getCenterY(), 8, 8);
            g2.rotate(Math.toRadians(moonDegree), earth.getCenterX(), earth.getCenterY());
            g2.fill(moon);
            /*
            g2.setBackground(Color.BLUE);
            
            
            
            
            */
            
    }
    
    @Override
    public void run(){
        try {
            while (true) {
                this.mercuryDegree = (float) (this.mercuryDegree >= 360 ? 0 : 0.03 + this.mercuryDegree);
                this.venusDegree = (float) (this.venusDegree >= 360 ? 0 : 0.04 + this.venusDegree);
                this.earthDegree = (float) (this.earthDegree >= 360 ? 0 : 0.02 + this.earthDegree);
                this.moonDegree = (float) (this.moonDegree >= 360 ? 0 : 0.1 + this.moonDegree);
                this.marsDegree = (float) (this.marsDegree >= 360 ? 0 : 0.04 + this.marsDegree);
                this.jupiterDegree = (float) (this.jupiterDegree >= 360 ? 0 : 0.05 + this.jupiterDegree);
                this.saturnDegree = (float) (this.saturnDegree >= 360 ? 0 : 0.03 + this.saturnDegree);
                this.uranusDegree = (float) (this.uranusDegree >= 360 ? 0 : 0.025 + this.uranusDegree);
                this.neptuneDegree = (float) (this.neptuneDegree >= 360 ? 0 : 0.03 + this.neptuneDegree);
                this.plutoDegree = (float) (this.plutoDegree >= 360 ? 0 : 0.01 + this.plutoDegree);

                Thread.sleep(24);
                super.repaint();
            }
        } catch (InterruptedException e) {
            System.out.println("W");
        }
        
    }
}
