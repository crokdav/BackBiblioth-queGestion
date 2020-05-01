package com.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="livre")
@Entity
public class Livre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LIVRE")
	private Long id;
	
	
	@Column(name="nomLivre")
	private String nomLivre;
	
	@Column(name="auteur")
	private String auteur;	
	
	@Column(name="quantite")
	private int quantite;
	
	@Column(name="description")
	private String description;

	public Livre(Long id, String nomLivre, String auteur, int quantite) {
		super();
		this.id = id;
		this.nomLivre = nomLivre;
		this.auteur = auteur;
		this.quantite = quantite;
	}

	
	
	
	public Livre(Long id, String nomLivre, String auteur, int quantite, String description) {
		super();
		this.id = id;
		this.nomLivre = nomLivre;
		this.auteur = auteur;
		this.quantite = quantite;
		this.description = description;
	}




	public Livre(String nomLivre, String auteur, int quantite, String description) {
		super();
		this.nomLivre = nomLivre;
		this.auteur = auteur;
		this.quantite = quantite;
		this.description = description;
	}



	public Livre() {
		super();
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Livre(String nomLivre, String auteur, int quantite) {
		super();
		this.nomLivre = nomLivre;
		this.auteur = auteur;
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomLivre() {
		return nomLivre;
	}

	public void setNomLivre(String nomLivre) {
		this.nomLivre = nomLivre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", nomLivre=" + nomLivre + ", auteur=" + auteur + ", quantite=" + quantite + "]";
	}
	
	
	
	

}
