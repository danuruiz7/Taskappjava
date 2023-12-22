package com.tracom.DAO;

import com.tracom.entidades.User;
import com.tracom.utils.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAO {

	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public void newUser(String name, String password, String rol) {

		User u = new User(name, password, rol);
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

	}

	public User comprobarIngreso(String name, String password) {
		User u = new User();
		try {
			TypedQuery<User> query = em
					.createQuery("SELECT u FROM User u WHERE u.name = :name AND u.password = :password", User.class);
			query.setParameter("name", name);
			query.setParameter("password", password);
			u = query.getSingleResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public User buscarUserPorId(int id) {

		try {
			em.getTransaction().begin();

			User user = em.find(User.class, id);

			em.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
