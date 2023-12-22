package com.tracom.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracom.DAO.TaskDAO;
import com.tracom.entidades.Task;
import com.tracom.entidades.User;


@WebServlet("/SvTarea")
public class SvTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SvTarea() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskDAO tDAO = new TaskDAO();
		
		
		String accion = request.getParameter("tipo");
		
		if(accion.equals("crear")) {
			int idUser = (Integer) request.getSession().getAttribute("id");
			String nameTask = request.getParameter("nameTask");
			String description = request.getParameter("description");
			tDAO.newTask(nameTask, description, idUser);	
			
			response.sendRedirect("crearTarea.jsp");
		}else if(accion.equals("eliminar")) {
			int idTask = Integer.parseInt(request.getParameter("idTask")) ;
			
			tDAO.deleteTask(idTask);
			
			response.sendRedirect("verTareas.jsp");
			
		}else if(accion.equals("editar")) {
			int idTask = Integer.parseInt(request.getParameter("idTask")) ;
			
			Task t = tDAO.taskId(idTask);
			HttpSession misession = request.getSession();
			misession.setAttribute("taskEdit",t);
			
			response.sendRedirect("editarTarea.jsp");
			
		}else if(accion.equals("actulizar")) {
			int idTask = Integer.parseInt(request.getParameter("idTask")) ;
			String nameTask = request.getParameter("nameTask");
			String description = request.getParameter("description");
			
			tDAO.taskUpdate(idTask, nameTask, description);
			
			
			response.sendRedirect("verTareas.jsp");
		}
		
		
		
	}

}
