package com.tracom.utils;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		
		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	}

}
