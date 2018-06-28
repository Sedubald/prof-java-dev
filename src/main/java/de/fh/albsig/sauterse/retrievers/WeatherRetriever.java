package de.fh.albsig.sauterse.retrievers;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author Sebastian Sauter.
 *
 */
public class WeatherRetriever {
    /**
     * The class logger.
     */
    private static Logger logger = Logger.getLogger(WeatherRetriever.class);

    /**
     *
     * @param location of the weather data.
     * @param country of the weather data.
     * @return weather data in xml format as string.
     * @throws Exception if retrieving fails.
     */
    public final String retrieve(final String location,
            final String country)
            throws Exception {
        logger.info("Retrieving Weather Data");
        String url = "https://query.yahooapis.com/v1/"
                + "public/yql?q=select%20*"
                + "%20from%20weather.forecast%20"
                + "where%20woeid%20in%20(select%20"
                + "woeid%20from%20geo.places(1)%20"
                + "where%20text%3D%22" + location
                + "%2C" + country + "%22)"
                + "&format=xml&env=store%3A%2F%2F"
                + "datatables.org%2Falltableswithkeys";
        URLConnection conn = new URL(url).openConnection();
        InputStream data = conn.getInputStream();
        StringWriter writer = new StringWriter();
        IOUtils.copy(data, writer, StandardCharsets.UTF_8);
        return writer.toString();
    }
}
