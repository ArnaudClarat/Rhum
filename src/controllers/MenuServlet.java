package controllers;

import DAO.RhumDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MenuServlet", urlPatterns = {"/menu"})
public class MenuServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		handleRequest(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		handleRequest(request, response);
	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setAttribute("rhums", RhumDAO.getAll());
			req.getRequestDispatcher("/web/vues/menu.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
