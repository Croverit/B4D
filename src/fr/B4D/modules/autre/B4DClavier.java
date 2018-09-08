package fr.B4D.modules.autre;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import fr.B4D.classes.B4DException;
import fr.B4D.classes.B4DException.Raison;
import fr.B4D.classes.PointF;

public final class B4DClavier {

	  /***************/
	 /* ECRIRE CHAT */
	/***************/
	
	public static void Ecrire_Chat(String texte, double attente) throws B4DException {
		
		B4DSouris.Clic_Gauche(new PointF(0.05347166799, 0.98902195608), false, 0.5);
		Ecrire_Clavier(texte,attente);
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}catch(AWTException e) {
			throw new B4DException(Raison.Clavier);
		}
	}
	public static void Ecrire_Chat(String texte) throws B4DException {
		B4DClavier.Ecrire_Chat(texte, 0.5);
	}

	  /******************/
	 /* ECRIRE CLAVIER */
	/******************/
	
	public static void Ecrire_Clavier(String texte, double attente) throws B4DException {
		Clipboard clipboard = getSystemClipboard();
		Robot robot;
		try {
			robot = new Robot();
			clipboard.setContents(new StringSelection(texte), null);
			robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyRelease(KeyEvent.VK_V);
		} catch (AWTException e) {
			throw new B4DException(Raison.Clavier);
		}			
		B4DAttente.Attendre(attente);
	}
	public static void Ecrire_Clavier(String texte) throws B4DException {
		Ecrire_Clavier(texte, 0.5);
	}
	
	  /*****************/
	 /* PRESSE PAPIER */
	/*****************/
	
	public static void CopierPressePapier(String texte) throws B4DException {
		Clipboard clipboard = getSystemClipboard();
		Robot robot;
		try {
			robot = new Robot();
			clipboard.setContents(new StringSelection(texte), null);
			robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyRelease(KeyEvent.VK_V);
		} catch (AWTException e) {
			throw new B4DException(Raison.PressePapier);
		}
	}
	
	public static String RecupererPressePapier() throws B4DException{
        Clipboard systemClipboard = getSystemClipboard();
        DataFlavor dataFlavor = DataFlavor.stringFlavor;

        if (systemClipboard.isDataFlavorAvailable(dataFlavor)) {
			try {
				return (String) systemClipboard.getData(dataFlavor);
			} catch (Exception e) {
				throw new B4DException(Raison.PressePapier);
			}
        }
		return "";
	}
	
    private static Clipboard getSystemClipboard(){
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = defaultToolkit.getSystemClipboard();
        return systemClipboard;
    }
}
