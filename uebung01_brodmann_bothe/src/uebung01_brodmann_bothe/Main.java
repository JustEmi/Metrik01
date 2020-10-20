package uebung01_brodmann_bothe;

/**
 * @authors: Emilia Maria Bothe (m26329), Paul Brodmann (m26405)
 * @date 19.10.2020
 * @version: 1.2.2
 * Softwaretechnik: Uebung 01
 *
 * Description:
 * The Main class starts the project. It instantiated an object of the
 * class MainWindow and calls the openWindow-Method. In the following a window 
 * will be opening with the user interface.
 */
public class Main {

    public static void main(String[] args) {
	    MainWindow mw = new MainWindow();
	    mw.openWindow();
    }
}
