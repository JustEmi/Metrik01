package softwaretechnik;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class DrawObject extends Canvas implements MouseListener, ActionListener{
	
	MenuBar mmb = new MenuBar();
	
	Menu _menu = new Menu("Hintergrundfarbe auswählen");
	MenuItem m1 =new MenuItem("rot");
	MenuItem m2 =new MenuItem("gelb");
	MenuItem m3 =new MenuItem("grün");
	
	private float _x, _y;
	private int counter;

	public DrawObject() {
		_x = _y= 0;
		setSize(500, 500);
		setBackground(Color.WHITE);
		addMouseListener(this);
		
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);

		_menu.add(m1);
		_menu.add(m2);
		_menu.add(m3);

		mmb.add(_menu);
	}
	
	public float get_x() {
		return _x;
	}
	
	public float get_y() {
		return _y;
	}
	
	@Override
	public void paint(Graphics g) {
        if(_x == 0 && _y ==0)return;
        
        if(counter == 2) {
        	getGraphics().clearRect(0, 0, 500, 500);
        	System.out.println("hallo");
        	counter = -1;
        	
        }else {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2.5F));
        Ellipse2D ellipse = new Ellipse2D.Float(_x,_y,100,100);
        g2d.draw(ellipse);
        }
        counter++;
       
		//sobald neues recheck erstellt wurde, soll listener berechnung ausführen
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		_x = e.getX();
		_y = e.getY();
		paint(getGraphics());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_x = _y = 0;
		setBackground(Color.GREEN);
		if(e.getSource().equals(m1)) {
			setBackground(Color.RED);
		}
		if(e.getSource().equals(m2)) {
			setBackground(Color.YELLOW);
		}
	}
}