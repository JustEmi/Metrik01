package uebung01_brodmann_bothe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * @authors: Emilia Maria Bothe (m26329), Paul Brodmann (m26405)
 * @date 19.10.2020
 * @version: 1.2.2
 * Softwaretechnik: Uebung 01
 *
 * Description:
 * The DrawObject class includes all necessary methods for the wokring of the programm.
 * It creates the menubar and it attributes. Moreover it has methods to draw circles in 
 * adjustable radii with a double click.
 */
public class DrawObject extends Canvas implements MouseListener, ActionListener{
	
	// general attributes
	private float _x, _y; // position of the circles
	private int counter; // number of circles on the canvas
	private int i = 0; // position of the coordinates
	private static int r = 50; // standard radius 
	private static int r1 = 50;
	private static int r2 = 25; 
	private static int r3 = 5;
	
	// temporary x and y coordinates
	private static int circX1;
	private static int circX2;
	private static int circY1;
	private static int circY2;
	
	// attributes for the Menu
	MenuBar mmb = new MenuBar();
	Menu _menu = new Menu("Change Backgroundcolor");
	MenuItem m1 = new MenuItem("rot");
	MenuItem m2 = new MenuItem("gelb");
	MenuItem m3 = new MenuItem("grün");
	
	Menu _menu2 = new Menu("Change Circle radius");
	MenuItem m4 = new MenuItem("Radius: 50px");
	MenuItem m5 = new MenuItem("Radius: 25px");
	MenuItem m6 = new MenuItem("Radius: 5px");
	
	
	/**
	 * Constructor of the DrawObject class.
	 * Sets the x and y coordinates to 0. Furthermore it sets the window size 
	 * and background color of the window and adds a mouse listener to the canvas.
	 * In addition adds the constructor actionlistener to the menu items and connects them 
	 * to the menu and menubar.
	 */
	public DrawObject() {
		_x = _y= 0;
		setSize(500, 500);
		setBackground(Color.WHITE);
		addMouseListener(this);
		
		
		// Add menubar
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);
		m6.addActionListener(this);

		_menu.add(m1);
		_menu.add(m2);
		_menu.add(m3);
		
		_menu2.add(m4);
		_menu2.add(m5);
		_menu2.add(m6);

		mmb.add(_menu);
		mmb.add(_menu2);
	}
	
	
	/**
	 * Creates the Circles, where the user uses a double click on the canvas.
	 * In addition appear the coordinates of the circles on the top left corner
	 * of the canvas. 
	 * 
	 * @param g canvas, on which you are working ?
	 */
    @Override
    public void paint(Graphics g) {
        if(_x == 0 && _y ==0) return;
        Graphics2D g2d = (Graphics2D) g;

        if(counter == 2) {
        	getGraphics().clearRect(0, 0, 500, 500);
        	counter = -1;
        	i = 0;
        	
        }else {
        	g2d.setStroke(new BasicStroke(2.5F));
        	Ellipse2D ellipse = new Ellipse2D.Float(_x-r,_y-r,r*2,r*2);
        	g2d.draw(ellipse);
        	
        	// output of the coordinates
        	String s = "Coordinates: " + getCoordinates().toString();
            g.drawString(s, 10,15+i);
            i = i + 15;
            
            
        }
        
        // assignment of the temporary coordinates
        if(counter%2 == 0 || counter == 0 ) {
        	circX1 = (int) _x;
        	circY1 = (int) _y;
        } else {
        	circX2 = (int) _x;
        	circY2 = (int) _y;
        }
        
        // output of the distance
        if(counter == 1) {
        	double d = circleDistance();
        	String dist = null;
        	dist = "Distance of circles: " + dist.valueOf(d);
        	g.drawString(dist, 170, 15);
        	
        	g2d.drawLine(circX1, circY1, circX2, circY2);
        } 
        counter++;        
    }
    
    /**
     * Safes the coordinates of a circle in a list.
     * @return list of coordinates
     */
    private ArrayList<Float> getCoordinates(){
        ArrayList<Float> list = new ArrayList<Float>();
        list.add(this._x);
        list.add(this._y);

        return list;
    }
    
    /**
     * Changes the radii of the circle.
     * 
     * @param radius of the circle
     * @return radius of the circle
     */
    private static int setRadius(int radius) {
    	r = radius;
    	return r;
    }
   
    /**
     * Calculates the distance between two circles.
     */
    private static double circleDistance() {
    	double distance = Math.sqrt(Math.pow(circX2-circX1, 2)+Math.pow(circY2-circY1, 2));
    	return distance;
    }
    
    /**
     * Changes the background color if a menuitem is.
     * chosen.
     * 
     *  @param e menuitem, which is chosen
     */
    @Override
	public void actionPerformed(ActionEvent e) {
		_x = _y = 0;
		if(e.getSource().equals(m1)) {
			setBackground(Color.RED);
		} else if(e.getSource().equals(m2)) {
			setBackground(Color.YELLOW);
		} else if(e.getSource().equals(m3)) {
			setBackground(Color.GREEN);
		} else if(e.getSource().equals(m4)) {
			setRadius(r1);
		} else if(e.getSource().equals(m5)) {
			setRadius(r2);
		} else if(e.getSource().equals(m6)) {
			setRadius(r3);
		}
	}

    /**
     * Sets the x and y coordinates of the position where the canvas 
     * is clicked. It only paints a circle when a double click happens. 
     * 
     * @param e position, where the user clicks the canvas
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        _x = e.getX();
        _y = e.getY();
        if(e.getClickCount() == 2) {
        	 paint(getGraphics());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}