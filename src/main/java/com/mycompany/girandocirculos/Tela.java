package com.mycompany.girandocirculos;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
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
    private Dimension sunSize = new Dimension(60, 60);
    private Point sunCenter;
    private Point sunBorder;
    private int marsXPosition;
    private AffineTransform at;
    
    public Tela() {
        thread = new Thread(this, "Rotate Scare");
        thread.start();
        setBackground(Color.BLACK);
    }
    @Override
    public void paintComponent(Graphics g){
        
            Graphics2D g2 = (Graphics2D) g;
            Dimension windowSize = getSize();
            
            super.paintComponent(g2);
            
            sunPosition.x = ((windowSize.width / 2) - (sunSize.width / 2));
            sunPosition.y = ((windowSize.height / 2) - (sunSize.height / 2));
            sunCenter = new Point(this.sunPosition.x + (sunSize.width / 2), this.sunPosition.y + (sunSize.height / 2));
            sunBorder = new Point(sunCenter.x + (sunSize.width / 2), sunCenter.y + (sunSize.height / 2));
            
            
            g2.setColor(Color.YELLOW);
            g2.fillOval(sunPosition.x, sunPosition.y, (int) sunSize.getWidth(), (int) sunSize.getHeight());
            
            // Mercury
            at = new AffineTransform();
            g2.setColor(new Color(66, 66, 66));
            at.rotate(Math.toRadians(mercuryDegree), sunCenter.x, sunCenter.y);
            g2.setTransform(at);
            g2.fillOval((this.sunBorder.x) + 25, (this.sunCenter.y), 10, 10);
            
            
            // Venus
            at = new AffineTransform();
            g2.setColor(new Color(224, 224, 38));
            at.rotate(Math.toRadians(venusDegree), sunCenter.x, sunCenter.y);
            g2.setTransform(at);
            g2.fillOval((this.sunBorder.x) + 50, (this.sunCenter.y), 15, 15);
            
            
            
            
            
            //Mars
            at = new AffineTransform();
            g2.setColor(Color.RED);
            at.rotate(Math.toRadians(marsDegree), sunCenter.x, sunCenter.y);
            g2.setTransform(at);
            g2.fillOval(this.sunBorder.x + 135, sunCenter.y, 12, 12);
            
            
            //Jupiter
            at = new AffineTransform();
            g2.setColor(new Color(155, 142, 3));
            at.rotate(Math.toRadians(jupiterDegree), sunCenter.x, sunCenter.y);
            g2.setTransform(at);
            g2.fillOval(this.sunBorder.x + 170, sunCenter.y, 40, 40);
            
            
            //Saturn
            at = new AffineTransform();
            Ellipse2D saturn = new Ellipse2D.Double(this.sunBorder.x + 225, sunCenter.y, 35, 35);
            g2.setColor(new Color(191, 170, 118));
            at.rotate(Math.toRadians(saturnDegree), sunCenter.x, sunCenter.y);
            g2.setTransform(at);
            g2.fill(saturn);
            
            
            //Uranus
            at = new AffineTransform();
            g2.setColor(new Color(0, 153, 255));
            at.rotate(Math.toRadians(uranusDegree), sunCenter.x, sunCenter.y);
            g2.setTransform(at);
            g2.fillOval(this.sunBorder.x + 300, sunCenter.y, 30, 30);
            
            
            //Neptune
            at = new AffineTransform();
            g2.setColor(new Color(0, 85, 255));
            at.rotate(Math.toRadians(neptuneDegree), sunCenter.x, sunCenter.y);
            g2.setTransform(at);
            g2.fillOval(this.sunBorder.x + 345, sunCenter.y, 25, 25);
            
            
            //pluto
            at = new AffineTransform();
            g2.setColor(new Color(255, 255, 255));
            at.rotate(Math.toRadians(plutoDegree), sunCenter.x, sunCenter.y);
            g2.setTransform(at);
            g2.fillOval(this.sunBorder.x + 400, sunCenter.y, 5, 5);
            
            
            // Earth
            at = new AffineTransform();
            g2.setColor(Color.BLUE);
            Ellipse2D earth = new Ellipse2D.Double((int)(this.sunBorder.x) + 85, (int)(this.sunCenter.y), 15, 15);
            at.rotate(Math.toRadians(this.earthDegree), this.sunCenter.x, this.sunCenter.y);
            g2.setTransform(at);
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
                this.mercuryDegree += -1.5;
                this.venusDegree += 1.0;
                this.earthDegree += 0.5;
                this.moonDegree += 0.8;
                this.marsDegree += 0.5;
                this.jupiterDegree += -0.4;
                this.saturnDegree += 0.3;
                this.uranusDegree += -0.25 ;
                this.neptuneDegree += 0.2;
                this.plutoDegree += -1;

                Thread.sleep(24);
                super.repaint();
            }
        } catch (InterruptedException e) {
            System.out.println("W");
        }
        
    }
}
