package controllers;

import DAO.RhumDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Post");
		handleRequest(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Get");
		handleRequest(request, response);
	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse res) {
		try {
			System.out.println("handleRequest");
			req.setAttribute("rhums", RhumDAO.getAll());
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
