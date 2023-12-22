package com.tracom.DAO;

import java.util.Date;

import com.tracom.entidades.Task;
import com.tracom.entidades.User;
import com.tracom.utils.JPAUtil;

import jakarta.persistence.EntityManager;

public class TaskDAO {
	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void newTask(String nameTask,String descripcion,int id) {
		
		UserDAO uDAO = new UserDAO();
		
		User user = uDAO.buscarUserPorId(id);
		
		Task t = new Task();
		t.setName(nameTask);
		t.setDescription(descripcion);
		t.setFechaCreacion(new Date());
		t.setFechaActualizacion(null);
		t.setUserTask(user);
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
	
	public Task taskId(int id) {
		try {
			em.getTransaction().begin();

			Task task = em.find(Task.class, id);

			em.getTransaction().commit();
			return task;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void taskUpdate(int id, String nameTask, String descripcion) {
		Task t = em.find(Task.class, id);

		try {
			em.getTransaction().begin();
			t.setName(nameTask);
			t.setDescription(descripcion);
			t.setFechaActualizacion(new Date());
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteTask(int id) {
		try {
			Task task = taskId(id);
			em.getTransaction().begin();
			em.remove(task);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
