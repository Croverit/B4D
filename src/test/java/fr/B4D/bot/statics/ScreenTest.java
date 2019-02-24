package fr.B4D.bot.statics;

import java.awt.AWTException;
import java.awt.Point;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import fr.B4D.bot.Configuration;
import fr.B4D.dao.DAOFactory;
import fr.B4D.utils.Rectangle;
import net.sourceforge.tess4j.TesseractException;

public class ScreenTest {

	private Screen screen;
	
	@Before
	public void before() throws ClassNotFoundException, IOException, AWTException {
		Configuration configuration = DAOFactory.getConfigurationDAO().find();
		screen = new Screen(configuration);
	}
	
	@Test
	public void test() throws AWTException, IOException, TesseractException {
		String out = screen.OCR(new Rectangle(new Point(0,0), new Point(500,300)));
		System.out.println(out);
	}
}
