package com.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="nom")
	private String nomEtudiant;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	private Livre livre;

	public Notification(long id, String nomEtudiant, Date date, Livre livre) {
		super();
		this.id = id;
		this.nomEtudiant = nomEtudiant;
		this.date = date;
		this.livre = livre;
	}

	public Notification(String nomEtudiant, Date date, Livre livre) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.date = date;
		this.livre = livre;
	}

	public Notification() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	
	
	
}
