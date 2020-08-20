package controllers;

import models.Rhum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet")
public class IndexServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		handleRequest(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		handleRequest(request, response);
	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.getRequestDispatcher("views/templates/menu.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			
		}
	}
}
