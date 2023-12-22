package com.tracom.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracom.DAO.UserDAO;
import com.tracom.entidades.User;

@WebServlet("/SvUsuario")
public class SvUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SvUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}

		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO uDAO = new UserDAO();
		String name = request.getParameter("usuario");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");
		String tipo = request.getParameter("tipo");

		if (tipo.equals("login")) {

			User u = uDAO.comprobarIngreso(name, password);

			if (u != null) {
				HttpSession misession = request.getSession(true);
				misession.setAttribute("user", u);
			
				
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("loginError.jsp");
			}

		} else if (tipo.equals("registrar")) {

			uDAO.newUser(name, password, rol);
			response.sendRedirect("login.jsp");
		}

	}

}
