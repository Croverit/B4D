package fr.B4D.bot.statics;

import org.junit.Before;
import org.junit.Test;

import fr.B4D.bot.B4DException;

public class LoggerTest_ {

	private Logger logger;
	
	@Before
	public void before() {
		logger = new Logger();
	}
	
	@Test
	public void popUpTest() {
		logger.popUp("This is a popUp test message.");
	}
	
	@Test
	public void debugTest() {
		logger.debug(this, "This is a debug test message.");
	}
	
	@Test
	public void warningTest() {
		logger.warning(this, "This is a warning test message.");
	}
	
	@Test
	public void errorTest() {
		logger.error(new B4DException("This is an error test message."));
	}
}
