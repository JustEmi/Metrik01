package uebung01_brodmann_bothe;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class DrawObject extends Canvas implements MouseListener {
    private float _x;
    private float _y;
    private int i = 0;
    
    public DrawObject() {
        _x =0;
        _y = 0;
        setSize(500,500);
        setBackground(Color.GRAY);
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        if(_x == 0 && _y ==0) return;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2.5F));
        Ellipse2D ellipse = new Ellipse2D.Float(_x,_y,100,100);
        g2d.draw(ellipse);
        
        String s = "Coordinates: " + getCoordinates().toString();

        g.drawString(s, 10,15+i);
        i = i + 15;
        /**
         * TODO:  if reset i zurücketzen
         */
    }
    
    private ArrayList<Float> getCoordinates(){
        ArrayList<Float> list = new ArrayList<Float>();
        list.add(this._x);
        list.add(this._y);

        return list;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        _x = e.getX();
        _y = e.getY();
        paint(getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
