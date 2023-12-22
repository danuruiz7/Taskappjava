package com.tracom.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="rol")
	private String rol;
	
	@OneToMany(mappedBy = "userTask", fetch = FetchType.LAZY)
	private List<Task> listTask = new ArrayList<>();
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(String name, String password,String rol) {	
		this.name = name;
		this.password = password;
		this.rol=rol;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	

	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public List<Task> getListTask() {
		return listTask;
	}


	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", listTask=" + listTask + "]";
	}
	
	
	
	
}
