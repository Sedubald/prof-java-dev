package de.fh.albsig.sauterse.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import de.fh.albsig.sauterse.data.ExceptionData;

public class WeatherRetrieverTests {

	@Test
	public void testConstructorAndGetter() {
		String name = "exceptionname";
		String message = "exceptionmessage";
		ExceptionData ed = new ExceptionData(name, message);
		
		assertEquals(ed.getName(), name);
		assertEquals(ed.getMessage(), message);
	}
	
	@Test
	public void testGetterAndSetter() {
		String name = "exceptionname";
		String message = "exceptionmessage";
		ExceptionData ed = new ExceptionData();
		ed.setName(name);
		ed.setMessage(message);
		
		assertEquals(ed.getName(), name);
		assertEquals(ed.getMessage(), message);
	}
}
