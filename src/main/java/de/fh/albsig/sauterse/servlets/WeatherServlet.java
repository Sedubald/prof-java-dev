package de.fh.albsig.sauterse.servlets;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import de.fh.albsig.sauterse.data.ExceptionData;
import de.fh.albsig.sauterse.retrievers.WeatherRetriever;

/**
 * Servlet implementation class WeatherServlet.
 */
public class WeatherServlet extends HttpServlet {
    /**
     * The serial version.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The class logger.
     */
    private static Logger logger = Logger.getLogger(WeatherServlet.class);

    /**
     * @see HttpServlet#HttpServlet().
     */
    public WeatherServlet() {
        super();
        System.out.println("WeatherServlet created");
        PropertyConfigurator.configure(WeatherServlet.class.getClassLoader()
                .getResource("log4j.properties"));
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request,
     * HttpServletResponse response).
     * @param request the consumers request.
     * @param response the servers response.
     * @throws ServletException if doGet fails.
     * @throws IOException if doGet fails.
     */
    public final void doGet(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("doGet()");

        ExceptionData ex = null;
        String result = null;

        try {
            String location = request.getParameter("location");
            String country = request.getParameter("country");
            if (location == null || location.equals("")) {
                ex = new ExceptionData("Parameter missing",
                    "Parameter location cannot be null.");
            } else if (country == null || country.equals("")) {
                ex = new ExceptionData("Parameter missing",
                    "Parameter country cannot be null.");
            } else {
                result = new WeatherRetriever()
                        .retrieve(location, country);
                logger.info("Returning weather data for location "
                        + location + " and country " + country);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().append(result);
                response.getWriter().flush();
                response.getWriter().close();
            }
        } catch (Exception e) {
            ex = new ExceptionData(e.toString(), e.getMessage());
            logger.error(e);
        }
        if (ex != null) {
            StringWriter sw = new StringWriter();
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(
                        ExceptionData.class);
                Marshaller jaxbMarshaller =
                        jaxbContext.createMarshaller();
                jaxbMarshaller.marshal(ex, sw);
                System.out.println(sw.toString());
                response.setStatus(
                        HttpServletResponse
                        .SC_BAD_REQUEST);
                response.getWriter().
                    append(sw.toString());
                response.getWriter().flush();
                response.getWriter().close();
            } catch (JAXBException e) {
                logger.error(e);
                response.setStatus(HttpServletResponse
                        .SC_INTERNAL_SERVER_ERROR);
                response.getWriter().append("<error>"
                    + "<status>500</status>"
                    + "<message>Internal Server Error"
                    + "</message>"
                    + "</error>");
                response.getWriter().flush();
                response.getWriter().close();
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request,
     * HttpServletResponse response).
     * @param request the consumers request.
     * @param response the servers response.
     * @throws ServletException if doGet fails.
     * @throws IOException if doGet fails.
     */
    protected final void doPost(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
