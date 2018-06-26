package de.fh.albsig.sauterse.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import de.fh.albsig.sauterse.servlets.WeatherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeatherServletTests {

	@Test
    public void shouldReturnTextHtml() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("location")).thenReturn("Bitz");
        when(request.getParameter("country")).thenReturn("de");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new WeatherServlet().doGet(request, response);
        
        assertTrue(stringWriter != null);
        assertFalse(stringWriter.toString().equals(""));
    }
    
    @Test
    public void shouldReturnErrorCode() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("location")).thenReturn("Bitz");
        when(response.getStatus()).thenReturn(400);
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new WeatherServlet().doGet(request, response);
        
        assertEquals(400, response.getStatus());
    }
}
