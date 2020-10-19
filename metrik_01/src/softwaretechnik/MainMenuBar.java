package softwaretechnik;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
public class MainMenuBar extends Canvas implements ActionListener{
	
	private Menu _menu;
	
	public MainMenuBar() {
		_menu = new Menu("Hintergrundfarbe-Programm");
		
		MenuItem m1 =new MenuItem("Farbe: rot");
		MenuItem m2 =new MenuItem("Farbe: gelb");
		MenuItem m3 =new MenuItem("Farbe: grün");
		MenuItem m4 =new MenuItem("Farbe: ocker");
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		
		_menu.add(m1);
		_menu.add(m2);
		_menu.add(m3);
		_menu.add(m4);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource());
		if(this.getName() == "m1") {
			System.out.println("blau");
		}
	}
}
