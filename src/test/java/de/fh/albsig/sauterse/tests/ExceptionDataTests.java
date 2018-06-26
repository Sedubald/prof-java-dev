package de.fh.albsig.sauterse.tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import de.fh.albsig.sauterse.retrievers.WeatherRetriever;

public class ExceptionDataTests {

	@Test
	public void testShouldReturnWeatherData() throws Exception {
		String weatherData = new WeatherRetriever().retrieve("Albstadt", "de");

		assertNotNull(weatherData);
		assertNotEquals(weatherData, "");
	}
}
