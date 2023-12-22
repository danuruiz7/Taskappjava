package com.tracom.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User userTask;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}


	public Task(int id, String name, String description, Date fechaCreacion, Date fechaActualizacion, User userTask) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.userTask = userTask;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}


	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}


	public User getUserTask() {
		return userTask;
	}


	public void setUserTask(User userTask) {
		this.userTask = userTask;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + ", userTaskID=" + userTask.getId() + "]";
	}

}
