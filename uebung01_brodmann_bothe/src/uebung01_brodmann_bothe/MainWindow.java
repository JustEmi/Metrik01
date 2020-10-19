package uebung01_brodmann_bothe;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @authors: Emilia Maria Bothe (m26329), Paul Brodmann (m26405)
 * @date 19.10.2020
 * @version: 1.2.1
 * Softwaretechnik: Uebung 01
 *
 * Description:
 * The MainWindow class is the initiator(?) for the window which is later shown.
 * It calls for the other classes necessary for the programm to work and sets 
 * important attributes for the window.
 */
public class MainWindow extends Frame implements WindowListener {

	/**
	 * Constructor of the MainWindow class.
	 * Basic attribute such as, size and title of the window is set. 
	 * Furthermore a listener is added to the window, so the programm can
	 * react of clicks on the window. A DrawObject is created an is added to the 
	 * window and a menubar is set for the programm.
	 */
	public  MainWindow() {
		setTitle("Programm für Softwaretechnik");
		setSize(500,300);
		addWindowListener(this);
		
		DrawObject draw =new DrawObject();
		add(draw);
		setMenuBar(draw.mmb);
	}

	/**
	 * Makes the window visible when called.
	 */
    public void openWindow(){
        setVisible(true);
    }


    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}